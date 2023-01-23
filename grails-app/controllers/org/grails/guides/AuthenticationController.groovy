package org.grails.guides

import org.grails.guides.utils.AppUtil

class AuthenticationController {

    AuthenticationService authenticationService
    UserService userService

    def login() {

        if (authenticationService.isAuthenticated()) {
            redirect(uri: "/")
        }
    }

    def signin() {
        if (authenticationService.isAuthenticated()) {
            render("/authentication/signin.gsp")
        }
    }

    def doLogin() {
        if (authenticationService.doLogin(params.email, params.password)) {
            redirect(uri: "/")
        } else {
            redirect(uri: "/signin")
        }
    }

    def logout() {
        session.invalidate()
        redirect(uri: "/signin")
    }

    def registration() {
        [user: flash.redirectParams]
    }

    def doRegistration() {
        def response = userService.save(params)
        if (response.isSuccess) {
            authenticationService.setUserAuthorization(response.model)
            redirect(controller: "dashboard", action: "index")
        } else {
            flash.redirectParams = response.model
            redirect(uri: "/signup")
        }
    }
}