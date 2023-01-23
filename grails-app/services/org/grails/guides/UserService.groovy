package org.grails.guides

import grails.web.servlet.mvc.GrailsParameterMap
import org.grails.guides.utils.AppUtil


class UserService {

    def save(GrailsParameterMap params) {
        User user = new User(params)
        def response = AppUtil.saveResponse(false, user)
        if (user.validate()) {
            user.save()
            if (!user.hasErrors()){
                response.isSuccess = true
            }
        }
        return response
    }

    def update(User user, GrailsParameterMap params) {
        user.properties = params
        def response = AppUtil.saveResponse(false, user)
        if (user.validate()) {
            user.save(flush: true)
            if (!user.hasErrors()){
                response.isSuccess = true
            }
        }
        return response
    }


    def getById(Serializable id) {
        return User.get(id)
    }

    Map list(GrailsParameterMap params) {
        params.max = params.max ?: 5
        params.offset = params.offset ?: 0
        List<User> userList = User.createCriteria().list(params) { }
        return [list: userList, count: User.list().size()]
    }

    def delete(User user) {
        try {
            user.delete(flush: true)
        } catch (Exception e) {
            println(e.getMessage())
            return false
        }
        return true
    }
}
