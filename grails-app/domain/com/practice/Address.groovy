package com.practice

class Address {
    String street
    String city
    String state
    String country
    String zipCode
    Long latitude
    Long longitude

    static constraints = {
        street(nullable:true)
        city(nullable:true)
        state(nullable:true)
        country(nullable:true)
        zipCode(nullable:true)
        latitude(nullable:true)
        longitude(nullable:true)
    }

    String toString() {
        "${street?:''} ${city?:''} ${state?:''}${zipCode ? ", $zipCode" : ''}"
    }
}
