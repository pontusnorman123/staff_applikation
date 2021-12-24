package DatabaseCode;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface PostKitchenOrder {
    @Headers({"Content-Type: application/xml; charset=utf-8"})
    @POST("se.miun.enities.kitchenorder")
    Call<ResponseBody> sendNewData(@Body() Kitchenorder kitchenorder);
}
