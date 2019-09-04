package com.asciibooks

import com.asciibooks.Author
import grails.plugin.springsecurity.annotation.Secured
import grails.rest.RestfulController

@Secured('ROLE_ADMIN')
class AuthorRestController extends RestfulController<Author> {
    static responseFormats = ['json']

//    @Secured('ROLE_ADMIN')
//    def index(Integer max) {
//        params.max = Math.min(max ?: 10, 100)
//        respond listAllResources(params), model: [("${resourceName}Count".toString()): countResources()]
//    }
    AuthorRestController () {
        super(Author)
    }
}
