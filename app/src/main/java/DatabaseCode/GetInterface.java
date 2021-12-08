package DatabaseCode;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface GetInterface {
    @Headers({
            "Accept: application/xml"
    })
    @GET("se.miun.enities.menuitem")
    Call<Menuitems> listMenuItem();
}
