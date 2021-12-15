package DatabaseCode;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface GetBooking {
    @Headers({
            "Accept: application/xml"
    })
    @GET("se.miun.enities.booking")
    Call<Bookings> listBooking();
}
