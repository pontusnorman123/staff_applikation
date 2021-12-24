package DatabaseCode;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface GetKitchenOrder {
    @Headers({
            "Accept: application/xml"
    })
    @GET("se.miun.enities.kitchenorder")
    Call<Kitchenorders> listKitchen();
}
