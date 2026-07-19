package Usuarios;
import java.util.ArrayList;

//Patrón de diseño Singleton
public class GestorUsuarios {

    private static GestorUsuarios instancia;
    private ArrayList<Usuario> usuarios;

    private GestorUsuarios(){
        usuarios = new ArrayList<>();
    }

   public static GestorUsuarios getInstance(){
        if(instancia == null){
            instancia = new GestorUsuarios();
        }
        return instancia;
    }

    public ArrayList<Usuario> getUsuarios(){
        return usuarios;
    }

    public void agregarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }
}