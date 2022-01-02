package DatabaseCode;

import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;

import DatabaseCode.Structure.Resturangorders;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class PostRetrofitResturang extends AsyncTask<Resturangorders, Void, Resturangorders> {
    private static final String TAG = "XmlWriterTask";
    public Resturangorders resturangorders = new Resturangorders();
    public Handler handler;
    @Override
    protected Resturangorders doInBackground(Resturangorders... voids) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        //logging.level(HttpLoggingInterceptor.Level.BODY);   // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);  // <-- this is the important line!

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/Anton2/webresources/")//http://10.0.2.2:8080/WebbTest2/webresources/    http://localhost:8080/WebbTest2/webresources/se.miun.register
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .client(httpClient.build())
                .build();
        Api service = retrofit.create(Api.class);


        for(int i = 0; i < resturangorders.resturangorderTable.size(); i++){
            Call<ResponseBody> call = service.newResturang(
                    resturangorders.resturangorderTable.get(i)
            );

            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    int statusCode = response.code();
                    Log.d(TAG, "onResponse: " + statusCode);
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Log.d(TAG, "onFailure: " + t.getMessage());
                }
            });
        }





        return null;
    }
}
