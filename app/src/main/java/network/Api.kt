package network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

//interface is required to make a network call, all endpoints and methods are defined here
public interface Api {



    @GET("marvel")
    fun getHeroes() : Call< List<HeroModel> > //this function will be called to call "https://simplifiedcoding.net/demos/marvel"
    //response body type of API is wrapped in Call interface

    @GET("employees")
    fun getEmployees() : Call <GetEmployeesResponseModel>

    @GET("employee/{id}")
    fun getEmployee(@Path("id") id: Int) : Call <GetEmployeeResponseModel>

    @POST("create")
    fun createEmployee(@Body employee:EmployeePostModel ) : Call<EmployeePostResponseModel>
}