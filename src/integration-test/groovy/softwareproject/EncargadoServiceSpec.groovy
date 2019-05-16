package softwareproject

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class EncargadoServiceSpec extends Specification {

    EncargadoService encargadoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Encargado(...).save(flush: true, failOnError: true)
        //new Encargado(...).save(flush: true, failOnError: true)
        //Encargado encargado = new Encargado(...).save(flush: true, failOnError: true)
        //new Encargado(...).save(flush: true, failOnError: true)
        //new Encargado(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //encargado.id
    }

    void "test get"() {
        setupData()

        expect:
        encargadoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Encargado> encargadoList = encargadoService.list(max: 2, offset: 2)

        then:
        encargadoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        encargadoService.count() == 5
    }

    void "test delete"() {
        Long encargadoId = setupData()

        expect:
        encargadoService.count() == 5

        when:
        encargadoService.delete(encargadoId)
        sessionFactory.currentSession.flush()

        then:
        encargadoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Encargado encargado = new Encargado()
        encargadoService.save(encargado)

        then:
        encargado.id != null
    }
}
