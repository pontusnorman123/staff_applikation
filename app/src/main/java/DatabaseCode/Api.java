package DatabaseCode;

import DatabaseCode.Structure.Bookings;
import DatabaseCode.Structure.Kitchenapp2s;
import DatabaseCode.Structure.Kitchenorder;
import DatabaseCode.Structure.Kitchenorders;
import DatabaseCode.Structure.Menuitems;
import DatabaseCode.Structure.Resturangorder;
import DatabaseCode.Structure.Resturangorders;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Api {
    @Headers({"Accept: application/xml"})
    @GET("se.miun.enities.kitchenapp2")
    Call<Kitchenapp2s> listView();

    @Headers({"Accept: application/xml"})
    @GET("se.miun.enities.resturangorder")
    Call<Resturangorders> listResturang();

    @Headers({"Accept: application/xml"})
    @GET("se.miun.enities.menuitem")
    Call<Menuitems> listMenu();

    @Headers({"Accept: application/xml"})
    @GET("se.miun.enities.kitchenorder")
    Call<Kitchenorders> listKitchen();

    @Headers({"Accept: application/xml"})
    @GET("se.miun.enities.booking")
    Call<Bookings> listBooking();

    @Headers({"Content-Type: application/xml; charset=utf-8"})
    @POST("se.miun.enities.resturangorder")
    Call<ResponseBody> newResturang(@Body() Resturangorder resturangorder);

    @Headers({"Content-Type: application/xml; charset=utf-8"})
    @POST("se.miun.enities.kitchenorder")
    Call<ResponseBody> newKitchen(@Body() Kitchenorder kitchenorder);

    @Headers({"Content-Type: application/json"})
    @PUT("se.miun.enities.kitchenorder/{id}")
    Call<Kitchenorder> updateKitchen(@Path("id") int id, @Body Kitchenorder body);
}
