package Usuarios;
import Usuarios.Usuario;

//Herencia a clase Usuario
public class Tester extends Usuario {
   public Tester(String nombre, String apellido, String email, String contraseña, String pais, int edad) {
   super(nombre, apellido, email, contraseña, pais, edad);
}
}

