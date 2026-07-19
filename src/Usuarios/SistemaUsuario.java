package Usuarios;
import java.util.Scanner;
import Excepciones.DatosInvalidosException;
import java.util.InputMismatchException;
import Excepciones.EmailDuplicadoException;
import Excepciones.UsuarioNoEncontradoException;

public class SistemaUsuario {

    static GestorUsuarios gestor = GestorUsuarios.getInstance();

    public static void main(String[] args) {

        // Usuarios precargados - Admin y Tester
        gestor.agregarUsuario(
                new Admin(
                        "Joaquín",
                        "Aldama",
                        "aldamajoaquin@gmail.com",
                        "admin123",
                        "Uruguay",
                        24
                )
        );

        gestor.agregarUsuario(new Tester(
                "Tester",
                "Senior",
                "tester@CES.com.uy",
                "tester123",
                "Uruguay",
                9999
        ));

        Scanner scanner = new Scanner(System.in);



        //Menú de navegación inicial

        int opcion = 1;

        while (opcion != 3) {

            System.out.println("MENÚ");
            System.out.println("1 - Registrar Administrador");
            System.out.println("2 - Login");
            System.out.println("3 - Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número.");
                scanner.nextLine(); // limpia la entrada inválida
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("Registro");
                    try {
                        registrarUsuario(scanner);
                    } catch (DatosInvalidosException | EmailDuplicadoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Login");
                    loginUsuario(scanner);
                    break;
                case 3:
                    System.out.println("Salir");
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Error: Seleccione una de las opciones en pantalla");
                    break;
            }


        }
    }



//Función para registrar Usuario nuevo

    public static void registrarUsuario(Scanner scanner) throws DatosInvalidosException, EmailDuplicadoException {

        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();

        if (nombre.isBlank()) {
            throw new DatosInvalidosException("Debe ingresar un nombre.");
        }


        System.out.print("Ingrese apellido: ");
        String apellido = scanner.nextLine();

        if (apellido.isBlank()) {
            throw new DatosInvalidosException("Debe ingresar un apellido.");
        }

        System.out.print("Ingrese email: ");
        String email = scanner.nextLine();
        validarEmail(email);
        for(Usuario usuario : gestor.getUsuarios()) {

            if (usuario.getEmail().equalsIgnoreCase(email)) {
                throw new EmailDuplicadoException("Ya existe un usuario con ese email.");
            }

        }

        System.out.print("Ingrese contraseña: ");
        String contraseña = scanner.nextLine();

        if (contraseña.isBlank()) {
            throw new DatosInvalidosException("Debe ingresar una contraseña.");
        }

        if(contraseña.length() < 8){

            throw new DatosInvalidosException(
                    "La contraseña debe tener mínimo 8 caracteres."
            );
        }

        System.out.print("Confirmar contraseña: ");
        String repetirContraseña = scanner.nextLine();

        if (!contraseña.equals(repetirContraseña)) {
            System.out.println("Las contraseñas no coinciden");
            return;
        }

        System.out.print("Ingrese país: ");
        String pais = scanner.nextLine();

        if (pais.isBlank()) {
            throw new DatosInvalidosException("Debe ingresar un país.");
        }

       int edad;
        try {
            System.out.print("Ingrese edad: ");
            edad = scanner.nextInt();
            scanner.nextLine();

            if (edad <= 0) {
                throw new DatosInvalidosException(
                        "La edad debe ser mayor a cero."
                );
            }
        } catch (InputMismatchException e) {
            scanner.nextLine();
            throw new DatosInvalidosException(
                    "La edad debe ser un número."
            );
        }

        Usuario usuario = new Admin(
                nombre,
                apellido,
                email,
                contraseña,
                pais,
                edad
        );

        gestor.agregarUsuario(usuario);
        System.out.println("Usuario registrado correctamente.");
    }


    //Función para validar Mail en registro de Usuario

    public static void validarEmail(String email)
            throws DatosInvalidosException {

        if(email.isBlank()){

            throw new DatosInvalidosException(
                    "El email no puede estar vacío."
            );

        }

        if(!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")){

            throw new DatosInvalidosException(
                    "El formato del email no es válido."
            );

        }

    }

    //Función para loguear usuarios registrados

    public static void loginUsuario(Scanner scanner) {

        if (gestor.getUsuarios().isEmpty()) {

            System.out.println("No existen usuarios registrados.");
            return;
        }
        System.out.print("Ingrese email: ");
        String email = scanner.nextLine();

        System.out.print("Ingrese contraseña: ");
        String contraseña = scanner.nextLine();

        for(Usuario usuario : gestor.getUsuarios()){

            if (email.equals(usuario.getEmail())
                    && contraseña.equals(usuario.getContraseña())) {

                System.out.println("Login exitoso. Bienvenido "
                        + usuario.getNombre());

                menuAdministrador(scanner);
                return;
            }
        }

        System.out.println("Alguno de los datos es incorrecto, por favor verifique e intente nuevamente");

    }

    // Función para Alta de Tester
    public static void crearTester(Scanner scanner)
            throws DatosInvalidosException, EmailDuplicadoException {

        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();

        if (nombre.isBlank()) {
        throw new DatosInvalidosException("Debe ingresar un nombre.");
    }

        System.out.print("Ingrese apellido: ");
        String apellido = scanner.nextLine();

        if (apellido.isBlank()) {
        throw new DatosInvalidosException("Debe ingresar un apellido.");
    }

        System.out.print("Ingrese email: ");
        String email = scanner.nextLine();
        validarEmail(email);
        for (Usuario usuario : gestor.getUsuarios()) {

        if (usuario.getEmail().equalsIgnoreCase(email)) {
            throw new EmailDuplicadoException("Ya existe un usuario con ese email.");
        }
    }

        System.out.print("Ingrese contraseña: ");
        String contraseña = scanner.nextLine();
        if (contraseña.isBlank()) {
        throw new DatosInvalidosException("Debe ingresar una contraseña.");
    }

        if (contraseña.length() < 8) {
        throw new DatosInvalidosException("La contraseña debe tener mínimo 8 caracteres.");
    }

        System.out.print("Confirmar contraseña: ");
        String repetirContraseña = scanner.nextLine();

        if (!contraseña.equals(repetirContraseña)) {
        throw new DatosInvalidosException("Las contraseñas no coinciden.");
    }

        System.out.print("Ingrese país: ");
        String pais = scanner.nextLine();
        if (pais.isBlank()) {

        throw new DatosInvalidosException("Debe ingresar un país.");
    }

        int edad;
        try {
        System.out.print("Ingrese edad: ");
        edad = scanner.nextInt();
        scanner.nextLine();

        if (edad <= 0) {
            throw new DatosInvalidosException("La edad debe ser mayor a cero.");
        }

    } catch (InputMismatchException e) {

        scanner.nextLine();

        throw new DatosInvalidosException("La edad debe ser un número.");
    }

        Usuario tester = new Tester(
                nombre,
                apellido,
                email,
                contraseña,
                pais,
                edad
        );

        gestor.agregarUsuario(tester);
        System.out.println("Tester creado correctamente.");
    }


    // Función Listado de Usuarios
    public static void listarUsuarios() {

        System.out.println("\nLISTA DE USUARIOS:");

        for(Usuario usuario : gestor.getUsuarios()){

            System.out.println(
                    usuario.getNombre()
                            + " "
                            + usuario.getApellido()
                            + " | "
                            + usuario.getEmail()
                            + " | "
                            + usuario.getTipoUsuario()
            );
        }
    }

    // Función Búsqueda de Usuarios
    public static void buscarUsuario(Scanner scanner)
            throws UsuarioNoEncontradoException {

        System.out.print("Ingrese email: ");
        String email = scanner.nextLine();

        for(Usuario usuario : gestor.getUsuarios()){
            if (usuario.getEmail().equalsIgnoreCase(email)) {

                System.out.println("Usuario encontrado:");

                System.out.println(
                        usuario.getNombre()
                                + " "
                                + usuario.getApellido()
                                + " | "
                                + usuario.getEmail()
                                + " | "
                                + usuario.getTipoUsuario()
                );
                return;
            }
        }

        throw new UsuarioNoEncontradoException(
                "No existe un usuario registrado con ese email."
        );
    }

    // Menú del Admin
    public static void menuAdministrador(Scanner scanner) {

        int opcion = 0;

        while (opcion != 4) {

            System.out.println("\nPANEL ADMIN");

            System.out.println("1 - Crear Usuario Tester");
            System.out.println("2 - Listar Usuarios");
            System.out.println("3 - Buscar Usuario");
            System.out.println("4 - Cerrar sesión");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número.");
                scanner.nextLine(); // limpia la entrada inválida
                continue;
            }

            switch (opcion) {

                case 1:
                    try {
                        crearTester(scanner);
                    } catch (DatosInvalidosException | EmailDuplicadoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    listarUsuarios();
                    break;

                case 3:
                    try {
                        buscarUsuario(scanner);
                    } catch (UsuarioNoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Sesión cerrada.");
                    break;
            }
        }
    }
}
