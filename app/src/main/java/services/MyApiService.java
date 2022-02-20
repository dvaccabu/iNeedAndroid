package services;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import services.response.AccountResponse;

public interface MyApiService {
    @GET("accounts")
    Call<List<AccountResponse>> getAccount(@Query("email") String username);

//    @FormUrlEncoded
//    @POST("upload/photo")
//    Call<SimpleResponse> postPhoto(
//            @Field("image") String base64,
//            @Field("extension") String extension,
//            @Field("user_id") String user_id
//    );
//
//    @GET("login")
//    Call<LoginResponse> getLogin(
//            @Query("username") String username,
//            @Query("password") String password
//    );
//
//    @FormUrlEncoded
//    @POST("product")
//    Call<SimpleResponse> postNewProduct(
//            @Field("code") String code,
//            @Field("name") String name,
//            @Field("description") String description
//    );
}
