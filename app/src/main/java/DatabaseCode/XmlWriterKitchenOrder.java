package DatabaseCode;

import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class XmlWriterKitchenOrder extends AsyncTask<Void, Void, Resturangorders> {
    public Handler handler;
    public Kitchenorders kitchenorders = new Kitchenorders();
    protected Resturangorders doInBackground(Void... voids){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/Anton2/webresources/")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .client(httpClient.build())
                .build();
        PostKitchenOrder service = retrofit.create(PostKitchenOrder.class);

        for(int i = 0; i < kitchenorders.kitchenorderTable.size(); i++){
            Call<ResponseBody> call = service.sendNewData(
                    kitchenorders.kitchenorderTable.get(i)
            );

            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    int statusCode = response.code();
                    Log.d(null, "onResponse: " + statusCode);
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Log.d(null, "onFailure: " + t.getMessage());
                }
            });
        }

        return null;
    }
}
