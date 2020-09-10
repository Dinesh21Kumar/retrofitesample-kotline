package network

import com.google.gson.annotations.SerializedName

class GetEmployeeResponseModel {
    @SerializedName("status") var status: String
    @SerializedName("data") var data : EmployeeModel

    constructor(status: String, data : EmployeeModel) {
        this.status = status
        this.data = data
    }
}