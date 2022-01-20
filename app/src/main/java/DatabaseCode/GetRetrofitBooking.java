package DatabaseCode;

import android.os.AsyncTask;
import android.os.Handler;
import android.widget.TextView;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import DatabaseCode.Structure.Bookings;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class GetRetrofitBooking extends AsyncTask<Void, Void, Bookings> {
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
        Api service = retrofit.create(Api.class);
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
                String currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());
                //String dateDB = result.BookingTable.get(0).date;
                for(int i = 0; i < result.BookingTable.size(); i++){
                    if(result.BookingTable.get(i).date.equals(systemDate)){

                        if(stringCompare(currentTime, "15:00:00")<0){

                            if(result.BookingTable.get(i).tablenr == 1 && result.BookingTable.get(i).pass == 1){
                                name1.setText(result.BookingTable.get(i).name);
                                guest1.setText(String.valueOf(result.BookingTable.get(i).guestnr));
                                if(result.BookingTable.get(i).pass == 1)
                                    time1.setText("Lunch");
                                if(result.BookingTable.get(i).pass == 2)
                                    time1.setText("Dinner");
                            }
                            if(result.BookingTable.get(i).tablenr == 2 && result.BookingTable.get(i).pass == 1){
                                name2.setText(result.BookingTable.get(i).name);
                                guest2.setText(String.valueOf(result.BookingTable.get(i).guestnr));
                                if(result.BookingTable.get(i).pass == 1)
                                    time2.setText("Lunch");
                                if(result.BookingTable.get(i).pass == 2)
                                    time2.setText("Dinner");
                            }
                            if(result.BookingTable.get(i).tablenr == 3  && result.BookingTable.get(i).pass == 1){
                                name3.setText(result.BookingTable.get(i).name);
                                guest3.setText(String.valueOf(result.BookingTable.get(i).guestnr));
                                if(result.BookingTable.get(i).pass == 1)
                                    time3.setText("Lunch");
                                if(result.BookingTable.get(i).pass == 2)
                                    time3.setText("Dinner");
                            }
                            if(result.BookingTable.get(i).tablenr == 4  && result.BookingTable.get(i).pass == 1){
                                name4.setText(result.BookingTable.get(i).name);
                                guest4.setText(String.valueOf(result.BookingTable.get(i).guestnr));
                                if(result.BookingTable.get(i).pass == 1)
                                    time4.setText("Lunch");
                                if(result.BookingTable.get(i).pass == 2)
                                    time4.setText("Dinner");
                            }
                            if(result.BookingTable.get(i).tablenr == 5  && result.BookingTable.get(i).pass == 1){
                                name5.setText(result.BookingTable.get(i).name);
                                guest5.setText(String.valueOf(result.BookingTable.get(i).guestnr));
                                if(result.BookingTable.get(i).pass == 1)
                                    time5.setText("Lunch");
                                if(result.BookingTable.get(i).pass == 2)
                                    time5.setText("Dinner");
                            }
                            if(result.BookingTable.get(i).tablenr == 6  && result.BookingTable.get(i).pass == 1){
                                name6.setText(result.BookingTable.get(i).name);
                                guest6.setText(String.valueOf(result.BookingTable.get(i).guestnr));
                                if(result.BookingTable.get(i).pass == 1)
                                    time6.setText("Lunch");
                                if(result.BookingTable.get(i).pass == 2)
                                    time6.setText("Dinner");
                            }
                            if(result.BookingTable.get(i).tablenr == 7  && result.BookingTable.get(i).pass == 1){
                                name7.setText(result.BookingTable.get(i).name);
                                guest7.setText(String.valueOf(result.BookingTable.get(i).guestnr));
                                if(result.BookingTable.get(i).pass == 1)
                                    time7.setText("Lunch");
                                if(result.BookingTable.get(i).pass == 2)
                                    time7.setText("Dinner");
                            }
                        }
                        else{
                            if(result.BookingTable.get(i).tablenr == 1 && result.BookingTable.get(i).pass == 2){
                                name1.setText(result.BookingTable.get(i).name);
                                guest1.setText(String.valueOf(result.BookingTable.get(i).guestnr));
                                if(result.BookingTable.get(i).pass == 1)
                                    time1.setText("Lunch");
                                if(result.BookingTable.get(i).pass == 2)
                                    time1.setText("Dinner");
                            }
                            if(result.BookingTable.get(i).tablenr == 2 && result.BookingTable.get(i).pass == 2){
                                name2.setText(result.BookingTable.get(i).name);
                                guest2.setText(String.valueOf(result.BookingTable.get(i).guestnr));
                                if(result.BookingTable.get(i).pass == 1)
                                    time2.setText("Lunch");
                                if(result.BookingTable.get(i).pass == 2)
                                    time2.setText("Dinner");
                            }
                            if(result.BookingTable.get(i).tablenr == 3 && result.BookingTable.get(i).pass == 2){
                                name3.setText(result.BookingTable.get(i).name);
                                guest3.setText(String.valueOf(result.BookingTable.get(i).guestnr));
                                if(result.BookingTable.get(i).pass == 1)
                                    time3.setText("Lunch");
                                if(result.BookingTable.get(i).pass == 2)
                                    time3.setText("Dinner");
                            }
                            if(result.BookingTable.get(i).tablenr == 4 && result.BookingTable.get(i).pass == 2){
                                name4.setText(result.BookingTable.get(i).name);
                                guest4.setText(String.valueOf(result.BookingTable.get(i).guestnr));
                                if(result.BookingTable.get(i).pass == 1)
                                    time4.setText("Lunch");
                                if(result.BookingTable.get(i).pass == 2)
                                    time4.setText("Dinner");
                            }
                            if(result.BookingTable.get(i).tablenr == 5 && result.BookingTable.get(i).pass == 2){
                                name5.setText(result.BookingTable.get(i).name);
                                guest5.setText(String.valueOf(result.BookingTable.get(i).guestnr));
                                if(result.BookingTable.get(i).pass == 1)
                                    time5.setText("Lunch");
                                if(result.BookingTable.get(i).pass == 2)
                                    time5.setText("Dinner");
                            }
                            if(result.BookingTable.get(i).tablenr == 6 && result.BookingTable.get(i).pass == 2){
                                name6.setText(result.BookingTable.get(i).name);
                                guest6.setText(String.valueOf(result.BookingTable.get(i).guestnr));
                                if(result.BookingTable.get(i).pass == 1)
                                    time6.setText("Lunch");
                                if(result.BookingTable.get(i).pass == 2)
                                    time6.setText("Dinner");
                            }
                            if(result.BookingTable.get(i).tablenr == 7 && result.BookingTable.get(i).pass == 2){
                                name7.setText(result.BookingTable.get(i).name);
                                guest7.setText(String.valueOf(result.BookingTable.get(i).guestnr));
                                if(result.BookingTable.get(i).pass == 1)
                                    time7.setText("Lunch");
                                if(result.BookingTable.get(i).pass == 2)
                                    time7.setText("Dinner");
                            }
                        }

                    }


                }
            }
        });


    }

    public static int stringCompare(String str1, String str2){

        int l1 = str1.length();
        int l2 = str2.length();
        int lmin = Math.min(l1, l2);

        for (int i = 0; i < lmin; i++) {
            int str1_ch = (int)str1.charAt(i);
            int str2_ch = (int)str2.charAt(i);

            if (str1_ch != str2_ch) {
                return str1_ch - str2_ch;
            }
        }

        // Edge case for strings like
        // String 1="Geeks" and String 2="Geeksforgeeks"
        if (l1 != l2) {
            return l1 - l2;
        }

        // If none of the above conditions is true,
        // it implies both the strings are equal
        else {
            return 0;
        }
    }
}
