package softwareproject

class Reserva {

    //relacion 1 a 1, la reserva debe tener un usuario y una sala
     def Usuario usuario
     def Sala sala

    //Para llevar el conteo en horas y minutos de la reserva
     Date fechaInicio
     Date fechaFinal

    static constraints = {


    }
}
