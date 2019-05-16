package softwareproject

import grails.gorm.services.Service

@Service(Encargado)
interface EncargadoService {

    Encargado get(Serializable id)

    List<Encargado> list(Map args)

    Long count()

    void delete(Serializable id)

    Encargado save(Encargado encargado)

}