package Usuarios;
import Usuarios.Usuario;

//Herencia a clase Usuario
public class Admin extends Usuario {

    public Admin (String nombre, String apellido, String email, String contraseña, String pais, int edad) {
        super(nombre, apellido, email, contraseña, pais, edad);
    }
    @Override
    public String getTipoUsuario() {
        return "Administrador";
    }
    }


