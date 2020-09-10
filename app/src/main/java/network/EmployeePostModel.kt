package network

import com.google.gson.annotations.SerializedName

class EmployeePostModel {
    @SerializedName("name") var name : String
    @SerializedName("salary") var salary : String
    @SerializedName("age") var age : String
    constructor(name : String,salary : String,age : String) {
        this.name = name
        this.salary = salary
        this.age = age
    }
}