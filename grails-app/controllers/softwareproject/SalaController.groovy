package softwareproject

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

@Secured(['ROLE_ADMIN'])

class SalaController {

    SalaService salaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond salaService.list(params), model:[salaCount: salaService.count()]
    }

    def show(Long id) {
        respond salaService.get(id)
    }

    def create() {
        respond new Sala(params)
    }

    def save(Sala sala) {
        if (sala == null) {
            notFound()
            return
        }

        try {
            salaService.save(sala)
        } catch (ValidationException e) {
            respond sala.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sala.label', default: 'Sala'), sala.id])
                redirect sala
            }
            '*' { respond sala, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond salaService.get(id)
    }

    def update(Sala sala) {
        if (sala == null) {
            notFound()
            return
        }

        try {
            salaService.save(sala)
        } catch (ValidationException e) {
            respond sala.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sala.label', default: 'Sala'), sala.id])
                redirect sala
            }
            '*'{ respond sala, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        salaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sala.label', default: 'Sala'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sala.label', default: 'Sala'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
