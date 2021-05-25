package com.example.crudapplication

import java.io.Serializable

class JobApplication : Serializable{

    var firstName = ""
    var lastName = ""
    var streetAddress1 = ""
    var streetAddress2 = ""
    var city = ""
    var state = ""
    var postal = ""
    var country = ""
    var email = ""
    var areaCode = ""
    var phone = ""
    var position = ""
    var date = ""

    internal constructor(
        firstName: String, lastName: String, streetAddress1: String,
        streetAddress2: String, city: String, state: String, postal: String,
        country: String, email: String, areaCode: String, phone: String,
        position: String, date: String,
    ){
        this.firstName = firstName
        this.lastName = lastName
        this.streetAddress1 = streetAddress1
        this.streetAddress2 = streetAddress2
        this.city = city
        this.state = state
        this.postal = postal
        this.country = country
        this.email = email
        this.areaCode = areaCode
        this.phone = phone
        this.position = position
        this.date = date

    }
}