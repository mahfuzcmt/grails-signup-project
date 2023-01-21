package org.grails.guides

import grails.gorm.transactions.Transactional
import org.grails.guides.utils.AppUtil

@Transactional
class AuthenticationService {

    private static final String AUTHORIZED = "AUTHORIZED"

    def setUserAuthorization(User user) {
        def authorization = [isLoggedIn: true, user: user]
        AppUtil.getAppSession()[AUTHORIZED] = authorization
    }

    def doLogin(String email, String password){
        password = password.encodeAsMD5()
        User user = User.findByEmailAndPassword(email, password)
        if (user){
            setUserAuthorization(user)
            return true
        }
        return false
    }

    boolean isAuthenticated(){
        def authorization = AppUtil.getAppSession()[AUTHORIZED]
        if (authorization && authorization.isLoggedIn){
            return true
        }
        return false
    }


    User getUser(){
        def authorization = AppUtil.getAppSession()[AUTHORIZED]
        return authorization?.user
    }


    def getUserFullName(){
        User user = getUser()
        return "${user.firstName} ${user.lastName}"
    }

}
