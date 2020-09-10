package com.example.retrofitexample

import android.os.Bundle
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import network.Api
import network.HeroModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getHeroes()
    }

    private fun getHeroes() {
        //define base url of api
        var BASE_URL : String = "https://simplifiedcoding.net/demos/"
        //create retrofit obj with gson convertor and base url for api call
        val retroFit : Retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        //create object from retrofit with Api interface
        val api: Api = retroFit.create(Api::class.java)

        //now making the call object
        //Here we are using the api method that we created inside the api interface
        //now making the call object
        //Here we are using the api method that we created inside the api interface
        val call: Call<List<HeroModel>> = api.getHeroes()
        call.enqueue(object  : Callback< List<HeroModel> > {


            override fun onFailure(call: Call<List<HeroModel>>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show();
            }

            override fun onResponse(
                call: Call<List<HeroModel>>,
                response: Response<List<HeroModel>>
            ) {
                //In this point we got our hero list
                val heroList: List<HeroModel>? = response.body()
                println(heroList.toString())

                //now we can do whatever we want with this list
                val heroes = ArrayList<String>()
                if (heroList != null) {
                    for(h in heroList) {
                        heroes.add(h.name)
                    }
                }
                //show heroes in Listview (use recyclerview instead)
                listViewHeroes.setAdapter(
                    ArrayAdapter(
                        applicationContext,
                        android.R.layout.simple_list_item_1,
                        heroes
                    )
                )
            }

        })



    }

}






