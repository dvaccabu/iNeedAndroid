package services;

import java.util.List;

import model.Category;
import model.Customer;
import model.Language;
import model.ServiceOffer;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import model.Account;

public interface MyApiService {
    @GET("accounts")
    Call<List<Account>> getAccount(@Query("email") String username);

    @GET("customers")
    Call<List<Customer>> getCustomerByAccountId(@Query("acccountId") int accountId);

    @GET("categories?_embed=services")
    Call<List<Category>> getFullCategories();

    @GET("languages")
    Call<List<Language>> getLanguages();

    @GET("servicesoffer?_expand=serviceprovider")
    Call<List<ServiceOffer>> getServiceProvidersByService(@Query("serviceId") int serviceId);

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
