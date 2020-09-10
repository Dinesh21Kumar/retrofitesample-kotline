package com.example.retrofitexample

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import network.*
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
        getEmployees()
        getEmployee()
        createEmployee()
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

    private fun getEmployees() {
        //define base url of api
        var BASE_URL : String = "http://dummy.restapiexample.com/api/v1/"
        //create retrofit obj with gson convertor and base url for api call
        val retroFit : Retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        //create object from retrofit with Api interface
        val api: Api = retroFit.create(Api::class.java)

        //now making the call object
        //Here we are using the api method that we created inside the api interface
        //now making the call object
        //Here we are using the api method that we created inside the api interface
        val call: Call<GetEmployeesResponseModel> = api.getEmployees()
        call.enqueue(object  : Callback<GetEmployeesResponseModel> {


            override fun onFailure(call: Call<GetEmployeesResponseModel>, t: Throwable) {
                println(t.message)
                Log.e("employeeList",t.message)
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show();
            }

            override fun onResponse(
                call: Call<GetEmployeesResponseModel>,
                response: Response<GetEmployeesResponseModel>
            ) {
                //In this point we got our hero list
                val response: GetEmployeesResponseModel? = response.body()
                Log.d("employeeList",response?.data.toString())
                for(d in response?.data!!) {
                    println(d.employee_name)
                }
            }
        })
    }

    private fun getEmployee() {
        //define base url of api
        var BASE_URL : String = "http://dummy.restapiexample.com/api/v1/"
        //create retrofit obj with gson convertor and base url for api call
        val retroFit : Retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        //create object from retrofit with Api interface
        val api: Api = retroFit.create(Api::class.java)

        //now making the call object
        //Here we are using the api method that we created inside the api interface
        //now making the call object
        //Here we are using the api method that we created inside the api interface
        val call: Call<GetEmployeeResponseModel> = api.getEmployee(1)
        call.enqueue(object  : Callback<GetEmployeeResponseModel> {


            override fun onFailure(call: Call<GetEmployeeResponseModel>, t: Throwable) {
                println(t.message)
                Log.e("employee",t.message)
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show();
            }

            override fun onResponse(
                call: Call<GetEmployeeResponseModel>,
                response: Response<GetEmployeeResponseModel>
            ) {
                //In this point we got our employee with id 1
                val response: GetEmployeeResponseModel? = response.body()
                Log.d("employee",response?.data!!.employee_name)
            }
        })
    }

    fun createEmployee() {
        //define base url of api
        var BASE_URL : String = "http://dummy.restapiexample.com/api/v1/"
        //create retrofit obj with gson convertor and base url for api call
        val retroFit : Retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        //create object from retrofit with Api interface
        val api: Api = retroFit.create(Api::class.java)

        //now making the call object
        //Here we are using the api method that we created inside the api interface
        //now making the call object
        //Here we are using the api method that we created inside the api interface
        val call: Call<EmployeePostResponseModel> = api.createEmployee(EmployeePostModel("dinesh","2200","24"))
        call.enqueue(object  : Callback<EmployeePostResponseModel> {


            override fun onFailure(call: Call<EmployeePostResponseModel>, t: Throwable) {
                println(t.message)
                Log.e("employee_post",t.message)
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show();
            }


            override fun onResponse(
                call: Call<EmployeePostResponseModel>,
                response: Response<EmployeePostResponseModel>
            ) {
                val response: EmployeePostResponseModel? = response.body()
                Log.d("employee_post",response?.status)
            }
        })
    }

}






