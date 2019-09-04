package practiceexercise

import grails.plugin.springsecurity.annotation.Secured

class UrlMappings {



    // @Secured(value=["hasRole('adminRole')"], httpMethod='POST')
    static mappings = {
        "/api/authorRest"(resources: "authorRest")
//        group "/api", {
//
//                "/books"(resources:"book") {
//                    "/author"(resources:"author", includes: [ACTION_SHOW])
//                }
//                "/authors"(resources:"author") {
//                    "/books"(resources:"book", includes: [ACTION_SHOW, ACTION_INDEX])
//                }
//
//        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
