package network

import com.google.gson.annotations.SerializedName

class EmployeeModel {
    @SerializedName("id") var id: String
    @SerializedName("employee_name") var employee_name: String
    @SerializedName("employee_salary") var employee_salary : Int
    @SerializedName("employee_age") var employee_age : Int
    @SerializedName("profile_image") var profile_image: String
    constructor(id: String,employee_name: String,employee_salary : Int,employee_age : Int,profile_image: String) {
        this.id = id
        this.employee_name = employee_name
        this.employee_salary = employee_salary
        this.employee_age = employee_age
        this.profile_image = profile_image
    }
}