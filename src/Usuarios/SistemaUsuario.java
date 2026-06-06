package Usuarios;

import java.util.Scanner;

public class SistemaUsuario {

    static Usuario[] usuarios = new Usuario[10];
    static int cantidadUsuarios = 0;

    public static void main(String[] args) {

        // Usuarios precargados - Admin y Tester
    usuarios[cantidadUsuarios++] = new Admin(
            "Joaquín",
            "Aldama",
            "aldamajoaquin@gmail.com",
            "admin123",
            "Uruguay",
            24
    );

    usuarios[cantidadUsuarios++] = new Tester(
            "Tester",
            "Senior",
            "tester@CES.com.uy",
            "tester123",
            "Uruguay",
            9999
    );

        Scanner scanner = new Scanner(System.in);

     //Menú de navegacion
        int opcion = 1;

        while (opcion != 3) {

            System.out.println("MENÚ");
            System.out.println("1 - Registrarse");
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

        Usuario usuario = new Usuario(
                nombre,
                apellido,
                email,
                contraseña,
                pais,
                edad
        );

        usuarios[cantidadUsuarios] = usuario;
        cantidadUsuarios++;

        System.out.println("Usuario registrado correctamente.");
    }

    //Función para loguear usuarios registrados

    public static void loginUsuario(Scanner scanner) {

        if (cantidadUsuarios == 0) {

            System.out.println("No existen usuarios registrados.");
            return;
        }
        System.out.print("Ingrese email: ");
        String email = scanner.nextLine();

        System.out.print("Ingrese contraseña: ");
        String contraseña = scanner.nextLine();

        for (int i = 0; i < cantidadUsuarios; i++) {

            if (email.equals(usuarios[i].getEmail())
                    && contraseña.equals(usuarios[i].getContraseña())) {

                System.out.println("Login exitoso. Bienvenido "
                        + usuarios[i].getNombre());

                return;
            }
        }

        System.out.println("Alguno de los datos es incorrecto, por favor verifique e intente nuevamente");

    }
}
