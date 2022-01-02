package DatabaseCode;

import android.os.AsyncTask;
import android.os.Handler;

import com.example.staff_app.MenuItem;
import com.example.staff_app.SF;
import com.example.staff_app.SO;

import java.io.IOException;

import DatabaseCode.Structure.Kitchenapp2s;
import DatabaseCode.Structure.Kitchenorder;
import DatabaseCode.Structure.Kitchenorders;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;


public class PutAdapter extends AsyncTask<Void, Void, Void> {
    public Handler handler;
    public Kitchenapp2s viewList = new Kitchenapp2s();
    public int tableNr;
    protected Void doInBackground(Void... voids){
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
        return null;
    }

    protected void onPostExecute(Void result) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < viewList.viewTable.size(); i++){
                    if(tableNr == viewList.viewTable.get(i).tablenr){
                        Kitchenorder kitchenorder = new Kitchenorder();
                        kitchenorder.orderid = viewList.viewTable.get(i).id;
                        kitchenorder.id = viewList.viewTable.get(i).kitchenid;
                        kitchenorder.delivered = true;
                        kitchenorder.done = true;
                        PutRetrofitKitchen putRetrofitKitchen = new PutRetrofitKitchen();
                        putRetrofitKitchen.kitchenUpdate = null;
                        putRetrofitKitchen.kitchenUpdate = kitchenorder;
                        putRetrofitKitchen.handler = new Handler();
                        putRetrofitKitchen.execute();
                    }
                }
            }
        });


    }
}
