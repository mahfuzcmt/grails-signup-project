package org.grails.guides

import org.grails.guides.utils.AppUtil

class DashboardInterceptor {

    AuthenticationService authenticationService

    boolean before() {
        if (authenticationService.isAuthenticated()){
            return true
        }
        redirect(uri: "/signin")
        return false
    }
}
