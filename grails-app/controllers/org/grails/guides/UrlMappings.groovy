package org.grails.guides

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        '/'(controller: 'dashboard', action: 'index')
        '/signin'(controller: 'authentication', action: 'signin')
        '/signup'(controller: 'authentication', action: 'registration')
        '/doRegistration'(controller: 'authentication', action: 'doRegistration')
        '/doLogin'(controller: 'authentication', action: 'doLogin')
        '500'(view: '/error')
        '404'(view: '/notFound')
    }
}
