import Usuarios.Admin;

import java.util.Scanner;

public class Main {

    static Admin usuarioRegistrado = null;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int opcion = 0;

        while (opcion != 3) {

            System.out.println("\n===== MENÚ =====");
            System.out.println("1 - Registrarse");
            System.out.println("2 - Login");
            System.out.println("3 - Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {

                registrarUsuario(scanner);

            } else if (opcion == 2) {

                loginUsuario(scanner);

            } else if (opcion == 3) {

                System.out.println("Programa finalizado.");

            } else {

                System.out.println("Opción inválida.");

            }
        }
    }

    public static void registrarUsuario(Scanner scanner) {

        if (usuarioRegistrado != null) {

            System.out.println("Ya existe un usuario registrado.");
            return;

        }

        Admin usuario = new Admin();

        System.out.print("Ingrese nombre: ");
        usuario.nombre = scanner.nextLine();

        System.out.print("Ingrese apellido: ");
        usuario.apellido = scanner.nextLine();

        System.out.print("Ingrese email: ");
        usuario.email = scanner.nextLine();

        System.out.print("Ingrese contraseña: ");
        usuario.contraseña = scanner.nextLine();

        System.out.print("Ingrese país: ");
        usuario.pais = scanner.nextLine();

        usuarioRegistrado = usuario;

        System.out.println("Usuario registrado correctamente.");
    }

    public static void loginUsuario(Scanner scanner) {

        if (usuarioRegistrado == null) {

            System.out.println("No existe un usuario registrado.");
            return;

        }

        System.out.print("Ingrese email: ");
        String email = scanner.nextLine();

        System.out.print("Ingrese contraseña: ");
        String contraseña = scanner.nextLine();

        if (email.equals(usuarioRegistrado.email)
                && contraseña.equals(usuarioRegistrado.contraseña)) {

            System.out.println("Login exitoso. Bienvenido " + usuarioRegistrado.nombre);

        } else {

            System.out.println("Credenciales incorrectas.");

        }
    }
}