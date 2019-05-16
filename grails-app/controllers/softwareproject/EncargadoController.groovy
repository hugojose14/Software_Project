package softwareproject

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
@Secured(['ROLE_ADMIN'])

class EncargadoController {

    EncargadoService encargadoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond encargadoService.list(params), model:[encargadoCount: encargadoService.count()]
    }

    def show(Long id) {
        respond encargadoService.get(id)
    }

    def create() {
        respond new Encargado(params)
    }

    def save(Encargado encargado) {
        if (encargado == null) {
            notFound()
            return
        }

        try {
            encargadoService.save(encargado)
        } catch (ValidationException e) {
            respond encargado.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'encargado.label', default: 'Encargado'), encargado.id])
                redirect encargado
            }
            '*' { respond encargado, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond encargadoService.get(id)
    }

    def update(Encargado encargado) {
        if (encargado == null) {
            notFound()
            return
        }

        try {
            encargadoService.save(encargado)
        } catch (ValidationException e) {
            respond encargado.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'encargado.label', default: 'Encargado'), encargado.id])
                redirect encargado
            }
            '*'{ respond encargado, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        encargadoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'encargado.label', default: 'Encargado'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'encargado.label', default: 'Encargado'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
