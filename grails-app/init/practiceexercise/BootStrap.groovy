package practiceexercise

import com.asciibooks.Author
import com.asciibooks.Book
import com.asciibooks.Role
import com.asciibooks.User
import com.asciibooks.UserRole
import grails.util.Environment

class BootStrap {
    def init = { servletContext ->
        if(Environment.current == Environment.DEVELOPMENT) {
            createDevUsers()
            createDevData()
        }
    }

    def createDevData() {
        def eric = new Author(name: "Eric Helgeson", biography: "Grails Developer & Writer").save(failOnError:true)
        def grails3Book = new Book(author: eric, title: "Practical Grails 3", price: 100).save(failOnError:true)
        def boot1Book = new Book(author: eric, title: "Practical Spring Boot", price: 200).save(failOnError:true)
    }

    def createDevUsers() {
        def adminRole = new Role(authority: 'ROLE_ADMIN').save(failOnError:true)
        def authorRole = new Role(authority: 'ROLE_AUTHOR').save(failOnError:true)

        def admin = new User(email: "admin@gmail.com", password: 'password1').save(failOnError:true)
        def author = new User(email: "author@gmail.com", password: 'password1').save(failOnError:true)

        UserRole.create(admin, adminRole)
        UserRole.create(author, authorRole)
    }

    def destroy = { }
}
