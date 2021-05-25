package com.example.crudapplication

import java.io.Serializable

class User : Serializable {

    var user:String = ""
    var password:String = ""
    var name:String = ""

    internal constructor(user:String, password:String, name:String){
        this.user = user
        this.password = password
        this.name = name
    }

}