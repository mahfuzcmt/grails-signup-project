package org.grails.guides

class DashboardController {

    def index() {
        [users: User.list()]
    }
}
