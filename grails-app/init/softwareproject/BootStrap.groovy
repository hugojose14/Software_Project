package softwareproject

class BootStrap {

    def init = { servletContext ->

//creo los roles que voy a necesitar

        Rol adminRol = new Rol(authority: 'ROLE_ADMIN')

        Rol estudianteRol = new Rol(authority: 'ROL_EST')

        Rol encargadoRol = new Rol(authority: 'ROL_ENC')

        adminRol.save(flush: true)
        estudianteRol.save(flush: true)
        encargadoRol.save(flush: true)

//creo el usuario administrador
        def user = new Administrador (username: 'admin', password: '1234', name: 'Administrador', codigo: '0000', correo: 'admin@gmail.com')


        user.save()


//creo la relacion entre al usuario y el rol administrador
        if(!user.authorities.contains(adminRol)){

            UsuarioRol.create(user,adminRol,true)

        }
    }
    def destroy = {
    }
}
