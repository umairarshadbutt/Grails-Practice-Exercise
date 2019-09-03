package practiceexercise

import com.asciibooks.Role
import com.asciibooks.User
import com.asciibooks.UserRole
import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification
import spock.lang.Unroll

class AuthenticationTokenSpec extends Specification implements DomainUnitTest<AuthenticationToken> {

    void setup() {
       // rest = new RestBuilder()
        baseUrl = "http://localhost:${serverPort}"

        def adminRole = new Role(authority: 'ROLE_ADMIN').save(failOnError:true)
        def authorRole = new Role(authority: 'ROLE_AUTHOR').save(failOnError:true)

        def admin = new User(email: "admin@gmail.com", password: 'password1').save(failOnError:true)
        def author = new User(email: "author@gmail.com", password: 'password1').save(failOnError:true)

        UserRole.create(admin, adminRole)
        UserRole.create(author, authorRole)
        UserRole.create(authorCaseInsensitive, authorRole)
    }

    void "login with bad creds"() {
        when:
        def resp = rest.post("${baseUrl}/api/login") {
            json {
                email = "bad"
                password = "bad"
            }
        }
        def contentType = resp.headers.contentType

        then:
        resp.status == UNAUTHORIZED.value()
        !contentType

        and:
        !resp.json
    }
    def cleanup() {
        UserRole.executeUpdate 'delete UserRole'
        User.executeUpdate 'delete User'
        Role.executeUpdate 'delete Role'
    }

    @Unroll
    void "login with #emailAddress"() {
        when:
        def resp = rest.post("${baseUrl}/api/login") {
            json {
                email = emailAddress
                password = userPassword
            }
        }
        def contentType = resp.headers.getContentType()

        then:
        resp.status == OK.value()
        contentType.subtype == 'json'
        contentType.type == 'application'

        and:
        resp.json.username.toLowerCase() == emailAddress.toLowerCase()
        and:
        resp.json.access_token
        resp.json.refresh_token
        resp.json.token_type == "Bearer"
        resp.json.expires_in == 3600

        where:
        emailAddress             | userPassword
        "admin@gmail.com"   | "password1"
        "author@gmail.com" | "password1"
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
