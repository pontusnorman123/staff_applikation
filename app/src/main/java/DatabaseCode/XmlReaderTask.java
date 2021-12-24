package DatabaseCode;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import com.example.staff_app.FoodCustomAdapter;
import com.example.staff_app.MainActivity;
import com.example.staff_app.MenuItem;
import com.example.staff_app.SF;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class XmlReaderTask extends AsyncTask<Void, Void, Menuitems> {
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
                .baseUrl("http://10.0.2.2:8080/Anton2/webresources/")//http://10.0.2.2:8080/WebbTest2/webresources/    http://localhost:8080/WebbTest2/webresources/se.miun.register
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .client(httpClient.build())
                .build();
        GetInterface service = retrofit.create(GetInterface.class);
        Call<Menuitems> listMenuItem = service.listMenuItem();
        try {

            Response<Menuitems> result = listMenuItem.execute();
            menuitemTable = result.body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Retrofit retrofitResturang = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/Anton2/webresources/")//http://10.0.2.2:8080/WebbTest2/webresources/    http://localhost:8080/WebbTest2/webresources/se.miun.register
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .client(httpClient.build())
                .build();
        GetResturang serviceR = retrofitResturang.create(GetResturang.class);
        Call<Resturangorders> resturanglist = serviceR.listResturang();
        try {

            Response<Resturangorders> result = resturanglist.execute();
            resturangTable = result.body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Retrofit retrofitKitchen = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/Anton2/webresources/")//http://10.0.2.2:8080/WebbTest2/webresources/    http://localhost:8080/WebbTest2/webresources/se.miun.register
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .client(httpClient.build())
                .build();
        GetKitchenOrder serviceK = retrofitKitchen.create(GetKitchenOrder.class);
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
                SF.s.customAdapterFood.notifyDataSetChanged();
            }
        });


    }
}
