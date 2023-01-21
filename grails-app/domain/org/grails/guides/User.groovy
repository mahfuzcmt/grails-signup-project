package org.grails.guides

class User {

    Integer id
    String firstName
    String lastName
    String email
    String password
    Boolean isActive = true

    Date dateCreated
    Date lastUpdated

    static constraints = {
        email(email: true, nullable: false, unique: true, blank: false)
        password(blank: false)
        lastName(nullable: true)
    }

    static mapping = { }

    def beforeInsert (){
        this.password = this.password.encodeAsMD5()
    }


    def beforeUpdate(){
        this.password = this.password.encodeAsMD5()
    }

}
