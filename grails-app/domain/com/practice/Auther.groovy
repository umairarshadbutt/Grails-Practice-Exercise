package com.practice

import grails.rest.Resource
@Resource(uri="/authors", formats='json')
class Auther {

    String name
    String penName

    String biography

    Boolean privateProfile = false
    Boolean active = true

    Address address = new Address()

    Date lastUpdated
    Date dateCreated

    static hasMany = [books: Book]

    static constraints = {
        penName nullable: true
        biography nullable: true
    }

    String getDisplayName() {
        penName ?: name
    }

}
