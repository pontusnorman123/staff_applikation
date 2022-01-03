package DatabaseCode;

import android.os.AsyncTask;
import android.os.Handler;

import com.example.staff_app.MenuItem;
import com.example.staff_app.SF;

import java.io.IOException;

import DatabaseCode.Structure.Kitchenorders;
import DatabaseCode.Structure.Menuitems;
import DatabaseCode.Structure.Resturangorders;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class GetRetrofitMenuId extends AsyncTask<Void, Void, Menuitems> {
    public Menuitems menuitemTable = new Menuitems();
    public Resturangorders resturangTable = new Resturangorders();
    public Kitchenorders kitchenorders = new Kitchenorders();
    public Handler handler;
    protected Menuitems doInBackground(Void... voids) {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);  // <-- this is the important line!

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/Anton2/webresources/")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .client(httpClient.build())
                .build();
        Api service = retrofit.create(Api.class);
        Call<Menuitems> listMenuItem = service.listMenu();
        try {

            Response<Menuitems> result = listMenuItem.execute();
            menuitemTable = result.body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Retrofit retrofitResturang = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/Anton2/webresources/")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .client(httpClient.build())
                .build();
        Api serviceR = retrofitResturang.create(Api.class);
        Call<Resturangorders> resturanglist = serviceR.listResturang();
        try {

            Response<Resturangorders> result = resturanglist.execute();
            resturangTable = result.body();
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
            kitchenorders = result.body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return menuitemTable;

    }
    protected void onPostExecute(Menuitems result) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                SF.s.resetAll();
                for(int i = 0; i < result.menuitemTable.size(); i++){
                    if(result.menuitemTable.get(i).foodtype==1) {
                        SF.s.addFood(new MenuItem(result.menuitemTable.get(i).foodname,
                                result.menuitemTable.get(i).id, result.menuitemTable.get(i).price));
                    }
                    if(result.menuitemTable.get(i).foodtype==2){
                        SF.s.addStarter(new MenuItem(result.menuitemTable.get(i).foodname,
                                result.menuitemTable.get(i).id, result.menuitemTable.get(i).price));
                    }
                }
                MenuItem drink = new MenuItem("Coca Cola", 3);
                MenuItem drink2 = new MenuItem("Fanta", 9);
                SF.s.addDrink(drink);
                SF.s.addDrink(drink2);
                SF.s.customAdapterFood.notifyDataSetChanged();
            }
        });


    }
}
