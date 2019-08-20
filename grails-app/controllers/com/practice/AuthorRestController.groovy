package com.practice

import grails.rest.RestfulController

class AuthorRestController extends RestfulController<Auther> {

    static responseFormats = ['json']

    AuthorRestController() {
        super(Auther)
    }
}
