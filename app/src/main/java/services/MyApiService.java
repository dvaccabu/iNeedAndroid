package services;

import java.util.List;

import model.Category;
import model.Customer;
import model.Language;
import model.ServiceOffer;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import model.Account;

public interface MyApiService {
    @GET("accounts")
    Call<List<Account>> getAccount(@Query("email") String username);

    @FormUrlEncoded
    @POST("accounts")
    Call<Account> postNewAccount(
            @Field("email") String email,
            @Field("password") String password
    );

    @GET("customers")
    Call<List<Customer>> getCustomerByAccountId(@Query("accountId") int accountId);

    @FormUrlEncoded
    @POST("customers")
    Call<Customer> postNewCustomer(
            @Field("fname") String fname,
            @Field("lname") String lname,
            @Field("accountId") int accountId
    );

    @GET("categories?_embed=services")
    Call<List<Category>> getFullCategories();

    @GET("languages")
    Call<List<Language>> getLanguages();

    @GET("servicesoffer?_expand=serviceprovider")
    Call<List<ServiceOffer>> getServiceProvidersByService(@Query("serviceId") int serviceId);
}
