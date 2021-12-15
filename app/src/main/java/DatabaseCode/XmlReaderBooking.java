package DatabaseCode;

import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import com.example.staff_app.MenuItem;
import com.example.staff_app.SF;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class XmlReaderBooking extends AsyncTask<Void, Void, Bookings> {
    public TextView name1;
    public TextView guest1;
    public TextView time1;
    public TextView name2;
    public TextView guest2;
    public TextView time2;
    public TextView name3;
    public TextView guest3;
    public TextView time3;
    public TextView name4;
    public TextView guest4;
    public TextView time4;
    public TextView name5;
    public TextView guest5;
    public TextView time5;
    public TextView name6;
    public TextView guest6;
    public TextView time6;
    public TextView name7;
    public TextView guest7;
    public TextView time7;
    public Bookings bookingTable = new Bookings();
    public Handler handler;
    protected Bookings doInBackground(Void... voids) {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);  // <-- this is the important line!

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/Anton2/webresources/")//http://10.0.2.2:8080/WebbTest2/webresources/    http://localhost:8080/WebbTest2/webresources/se.miun.register
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .client(httpClient.build())
                .build();
        GetBooking service = retrofit.create(GetBooking.class);
        Call<Bookings> listMenuItem = service.listBooking();
        try {

            Response<Bookings> result = listMenuItem.execute();
            bookingTable = result.body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bookingTable;

    }
    protected void onPostExecute(Bookings result) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
                String systemDate = currentDate.substring(0,2)+'.'+currentDate.substring(3, 5)+'.'+currentDate.substring(6, 10);
                //String dateDB = result.BookingTable.get(0).date;
                for(int i = 0; i < result.BookingTable.size(); i++){
                    if(result.BookingTable.get(i).date.equals(systemDate)){
                        if(result.BookingTable.get(i).tablenr == 1){
                            name1.setText(result.BookingTable.get(i).name);
                            guest1.setText(String.valueOf(result.BookingTable.get(i).guestnr));
                            time1.setText(String.valueOf(result.BookingTable.get(i).pass));
                        }
                        if(result.BookingTable.get(i).tablenr == 2){
                            name2.setText(result.BookingTable.get(i).name);
                            guest2.setText(String.valueOf(result.BookingTable.get(i).guestnr));
                            time2.setText(String.valueOf(result.BookingTable.get(i).pass));
                        }
                        if(result.BookingTable.get(i).tablenr == 3){
                            name3.setText(result.BookingTable.get(i).name);
                            guest3.setText(String.valueOf(result.BookingTable.get(i).guestnr));
                            time3.setText(String.valueOf(result.BookingTable.get(i).pass));
                        }
                        if(result.BookingTable.get(i).tablenr == 4){
                            name4.setText(result.BookingTable.get(i).name);
                            guest4.setText(String.valueOf(result.BookingTable.get(i).guestnr));
                            time4.setText(String.valueOf(result.BookingTable.get(i).pass));
                        }
                        if(result.BookingTable.get(i).tablenr == 5){
                            name5.setText(result.BookingTable.get(i).name);
                            guest5.setText(String.valueOf(result.BookingTable.get(i).guestnr));
                            time5.setText(String.valueOf(result.BookingTable.get(i).pass));
                        }
                        if(result.BookingTable.get(i).tablenr == 6){
                            name6.setText(result.BookingTable.get(i).name);
                            guest6.setText(String.valueOf(result.BookingTable.get(i).guestnr));
                            time6.setText(String.valueOf(result.BookingTable.get(i).pass));
                        }
                        if(result.BookingTable.get(i).tablenr == 7){
                            name7.setText(result.BookingTable.get(i).name);
                            guest7.setText(String.valueOf(result.BookingTable.get(i).guestnr));
                            time7.setText(String.valueOf(result.BookingTable.get(i).pass));
                        }
                    }


                }
            }
        });


    }
}
