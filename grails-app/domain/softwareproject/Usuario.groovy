package softwareproject

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic
import java.util.regex.Matcher;

@GrailsCompileStatic
@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class Usuario implements Serializable {

    private static final long serialVersionUID = 1

    String username
    String password
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired
    String name
    String codigo
    String correo


    Set<Rol> getAuthorities() {
        (UsuarioRol.findAllByUsuario(this) as List<UsuarioRol>)*.rol as Set<Rol>
    }

    static constraints = {
        codigo unique: true, regex: "^[T-0{3}-\d{5}]*$"
        password nullable: false, blank: false, password: true
        username nullable: false, blank: false, unique: true

    }

    static mapping = {
	    password column: '`password`'
    }
}
