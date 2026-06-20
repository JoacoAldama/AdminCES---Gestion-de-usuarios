package Usuarios;

public abstract class Usuario {
    // Atributos básicos
       private String nombre;
       private String apellido;
       private String email;
       private String contraseña;
       private String repetircontraseña;
       private String pais;
       private int edad;

       public Usuario(String nombre, String apellido, String email,String contraseña, String pais, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contraseña = contraseña;
        this.pais = pais;
        this.edad = edad;
    }

    public abstract String getTipoUsuario();

//Getters y Setters
        public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getPais() {
        return pais;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    }
