package network

import com.google.gson.annotations.SerializedName

class GetEmployeesResponseModel {
    @SerializedName("status") var status: String
    @SerializedName("data") var data : List<EmployeeModel>

    constructor(status: String, data : List<EmployeeModel>) {
        this.status = status
        this.data = data
    }
}