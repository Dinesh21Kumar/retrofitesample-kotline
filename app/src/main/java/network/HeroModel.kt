package network

import com.google.gson.annotations.SerializedName

//this is class which defines the objects which will be returned from API
class HeroModel {
    //fields, their names can be diffrent from keys coming from json response object
    //use SerializedName which should have same value as key present in json

    @SerializedName("name")         var name: String
    @SerializedName("realname")     var realName: String
    @SerializedName("team")         var team: String
    @SerializedName("firstappearance")  var firstappearance: String
    @SerializedName("createdby")    var createdBy: String
    @SerializedName("publisher")    var publisher: String
    @SerializedName("imageurl")     var imageUrl: String
    @SerializedName("bio")          var bio: String

    //constructor
    constructor(name : String,  realname : String,  team : String,  firstappearance:String,  createdBy : String,  publisher :String ,  imageUrl : String,  bio : String) {
        this.name = name
        this.realName = realname
        this.team = team
        this.firstappearance = firstappearance
        this.createdBy = createdBy
        this.publisher = publisher
        this.imageUrl = imageUrl
        this.bio = bio
    }

}