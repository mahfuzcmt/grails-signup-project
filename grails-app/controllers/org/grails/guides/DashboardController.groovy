package org.grails.guides

class DashboardController {
    UserService userService

    def index() {
        Map response = userService.list(params)
        [userList: response.list, total: response.count]
    }
}
