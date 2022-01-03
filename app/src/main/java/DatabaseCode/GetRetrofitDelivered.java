package DatabaseCode;

import android.os.AsyncTask;
import android.os.Handler;

import com.example.staff_app.Order;
import com.example.staff_app.SO;

import java.io.IOException;
import java.util.ArrayList;

import DatabaseCode.Structure.Kitchenapp2s;
import DatabaseCode.Structure.Kitchenorders;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class GetRetrofitDelivered extends AsyncTask<Void, Void, Void> {
    public Kitchenapp2s viewList = new Kitchenapp2s();
    public Kitchenorders kitchenList = new Kitchenorders();
    public Handler handler;
    protected Void doInBackground(Void... voids) {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);  // <-- this is the important line!

        Retrofit retrofitView = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/Anton2/webresources/")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .client(httpClient.build())
                .build();
        Api service = retrofitView.create(Api.class);
        Call<Kitchenapp2s> listKitchen = service.listView();
        try {

            Response<Kitchenapp2s> result = listKitchen.execute();
            viewList = result.body();

        } catch (IOException e) {
            e.printStackTrace();
        }

        Retrofit retrofitKitchen = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/Anton2/webresources/")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .client(httpClient.build())
                .build();
        Api serviceK = retrofitKitchen.create(Api.class);
        Call<Kitchenorders> kitchenorderList = serviceK.listKitchen();
        try {

            Response<Kitchenorders> result = kitchenorderList.execute();
            kitchenList = result.body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }
    protected void onPostExecute(Void result) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                /*Behandling av inkommande data från databasen*/
                //Steg 1: kolla om det finns en nyare tidssämpel i databasen än den lokala listan
                //Detta för att kolla om det finns ny data redo för hämtning
                Long localTime = Long.parseLong("0");
                Long databaseTime = Long.parseLong("1");

                ArrayList<Order> items = SO.s.getOrders();
                if(items.size() != 0)
                    localTime = Long.parseLong(items.get(0).getTimestamp());
                for(int i = 1; i < items.size(); i++){
                    if(localTime < Long.parseLong(items.get(i).getTimestamp()))
                        localTime = Long.parseLong(items.get(i).getTimestamp());
                }

                if(viewList.viewTable.size() != 0)
                    databaseTime = Long.parseLong(viewList.viewTable.get(0).timestamp);
                for(int i = 1; i < viewList.viewTable.size(); i++){
                    if (databaseTime < Long.parseLong(viewList.viewTable.get(i).timestamp))
                        databaseTime = Long.parseLong(viewList.viewTable.get(i).timestamp);
                }

                if(databaseTime > localTime){
                    //Steg 2: Om det finns ny data att hämta...

                    for(int i = 0; i< kitchenList.kitchenorderTable.size(); i++){
                        for(int j = 0; j < viewList.viewTable.size(); j++){
                            boolean done = kitchenList.kitchenorderTable.get(i).done;
                            boolean delivered = kitchenList.kitchenorderTable.get(i).delivered;

                            //Om indexet i är vid ett värde som: är done && inte delivered &&
                            // index i's id motsvarar index j's id(synkronisering mellan listerna))
                            if(kitchenList.kitchenorderTable.get(i).id == viewList.viewTable.get(j).id &&
                                    done && !delivered){

                                //Kollar om det kommande objektet från databasen finns i den lokala listan
                                boolean exist = false;
                                for(int k = 0;k < items.size(); k++){
                                    int localOrderTableNr = items.get(k).getTableNumber();
                                    int tableNr = viewList.viewTable.get(j).tablenr;
                                    if(tableNr == localOrderTableNr)
                                        exist = true;
                                }

                                //Kollar om alla andra objekt med samma tableNr är done
                                boolean allDone = true;
                                for(int k = 0;k < viewList.viewTable.size() && allDone; k++){
                                    if(j!=k)
                                        if(viewList.viewTable.get(j).tablenr == viewList.viewTable.get(k).tablenr) {
                                            int localID = viewList.viewTable.get(k).id;
                                            int l = 0;
                                            // loop l är för synkronisering mellan listor
                                            for(; l < kitchenList.kitchenorderTable.size() && localID != kitchenList.kitchenorderTable.get(l).id; l++){}
                                            if(!kitchenList.kitchenorderTable.get(l).done && viewList.viewTable.get(k).id != 1)
                                                allDone = false;
                                        }
                                }
                                int tableNr = viewList.viewTable.get(j).tablenr;
                                if(!exist && allDone)
                                    SO.s.addOrder(new Order(tableNr, viewList.viewTable.get(j).kitchenid, viewList.viewTable.get(j).id, viewList.viewTable.get(j).timestamp));
                            }
                        }
                    }
                }
            }
        });
    }
}
