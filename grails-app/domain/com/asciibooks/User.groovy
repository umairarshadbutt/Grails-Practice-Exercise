package com.asciibooks

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@EqualsAndHashCode(includes='email')
@ToString(includes='email', includeNames=true, includePackage=false)
class User implements Serializable {

    private static final long serialVersionUID = 1

    String email
    String password
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    Set<Role> getAuthorities() {
        (UserRole.findAllByUser(this) as List<UserRole>)*.role as Set<Role>
    }

    static constraints = {
        password blank: false,
                password: true,
                validator: { password, user ->
                    for (commonPass in ["12345678", "password", "123456789", "football", "baseball", "1234567890", "1qaz2wsx", "princess", "qwertyuiop", "starwars"]) {
                        if (password.toString().compareToIgnoreCase(commonPass) == 0)
                            return ['tooCommon']
                    }
                },
                minSize: 8
        email blank: false, unique: true, email: true
    }

    static mapping = {
	    password column: '`password`'
    }
}
