package network

import com.google.gson.annotations.SerializedName

class EmployeePostResponseModel {
    @SerializedName("status") var status: String
    @SerializedName("data") var data : EmployeePostModel
    constructor(status: String,data : EmployeePostModel) {
        this.status = status
        this.data  = data
    }
}