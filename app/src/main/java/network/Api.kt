package network

import retrofit2.Call
import retrofit2.http.GET

//interface is required to make a network call, all endpoints and methods are defined here
public interface Api {



    @GET("marvel")
    fun getHeroes() : Call< List<HeroModel> > //this function will be called to call "https://simplifiedcoding.net/demos/marvel"
    //response body type of API is wrapped in Call interface
}