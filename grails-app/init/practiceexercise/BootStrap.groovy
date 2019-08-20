package practiceexercise

import com.practice.Auther
import com.practice.Book

class BootStrap {

    def init = { servletContext ->
        def eric = new Auther(name: "Eric", biography: "Grails Developer & Writer").save()
        def grails3Book = new Book(author: eric, title: "Practical Grails 3", price: 100).save()
    }
    def destroy = {
    }
}
