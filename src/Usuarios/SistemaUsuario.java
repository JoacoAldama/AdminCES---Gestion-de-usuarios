package Usuarios;

import java.util.Scanner;
import java.util.ArrayList;

public class SistemaUsuario {

    static ArrayList<Usuario> usuarios = new ArrayList<>();


    public static void main(String[] args) {

        // Usuarios precargados - Admin y Tester

    usuarios.add(new Admin(
            "Joaquín",
            "Aldama",
            "aldamajoaquin@gmail.com",
            "admin123",
            "Uruguay",
            24
    ));

        usuarios.add(new Tester(
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

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Registro");
                    registrarUsuario(scanner);
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

    public static void registrarUsuario(Scanner scanner) {

        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese email: ");
        String email = scanner.nextLine();

        System.out.print("Ingrese contraseña: ");
        String contraseña = scanner.nextLine();

        System.out.print("Confirmar contraseña: ");
        String repetirContraseña = scanner.nextLine();

        if (!contraseña.equals(repetirContraseña)) {
            System.out.println("Las contraseñas no coinciden");
            return;
        }

        System.out.print("Ingrese país: ");
        String pais = scanner.nextLine();

        System.out.print("Ingrese edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();

        Usuario usuario = new Admin(
                nombre,
                apellido,
                email,
                contraseña,
                pais,
                edad
        );

        usuarios.add(usuario);
        System.out.println("Usuario registrado correctamente.");
    }

    //Función para loguear usuarios registrados

    public static void loginUsuario(Scanner scanner) {

        if (usuarios.isEmpty()) {

            System.out.println("No existen usuarios registrados.");
            return;
        }
        System.out.print("Ingrese email: ");
        String email = scanner.nextLine();

        System.out.print("Ingrese contraseña: ");
        String contraseña = scanner.nextLine();

        for (Usuario usuario : usuarios) {

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

    // Listado de Usuarios
    public static void listarUsuarios() {

        System.out.println("\nLISTA DE USUARIOS:");

        for (Usuario usuario : usuarios) {

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

    // Búsqueda de Usuarios
    public static void buscarUsuario(Scanner scanner) {

        System.out.print("Ingrese email: ");
        String email = scanner.nextLine();

        for (Usuario usuario : usuarios) {

            if (usuario.getEmail().equals(email)) {

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

        System.out.println("Usuario no encontrado.");
    }

    // Menú del Admin
    public static void menuAdministrador(Scanner scanner) {

        int opcion = 0;

        while (opcion != 3) {

            System.out.println("\nPANEL ADMIN");

            System.out.println("1 - Listar Usuarios");
            System.out.println("2 - Buscar Usuario");
            System.out.println("3 - Cerrar sesión");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    listarUsuarios();
                    break;

                case 2:
                    buscarUsuario(scanner);
                    break;

                case 3:
                    System.out.println("Sesión cerrada.");
                    break;
            }
        }
    }
}
