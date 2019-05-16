package softwareproject

//Estudiante heredando de clase Usuario
class Estudiante extends Usuario{

    String semestre




    static hasMany = [reservas: Reserva]

    static constraints = {

        semestre blank: false, unique: true,inList: ["1","2","3","4","5","6","7","8","9"]
        
    }
}
