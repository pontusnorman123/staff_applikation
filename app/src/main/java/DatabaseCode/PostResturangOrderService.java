package DatabaseCode;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface PostResturangOrderService {
    @Headers({"Content-Type: application/xml; charset=utf-8"})
    @POST("se.miun.enities.resturangorder")
    Call<ResponseBody> sendNewData(@Body() Resturangorder resturangorder);
}
