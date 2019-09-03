package practiceexercise

import grails.plugin.springsecurity.annotation.Secured

class UrlMappings {



    // @Secured(value=["hasRole('adminRole')"], httpMethod='POST')
    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
