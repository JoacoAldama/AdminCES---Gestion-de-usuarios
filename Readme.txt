#AdminCES 

Proyecto desarrollado en Java como entrega final del curso "Introducción a la Programación para Testers".
El sistema simula la gestión de usuarios del portal AdminCES, permitiendo el registro de administradores, autenticación, creación de usuarios Tester y consulta de usuarios registrados.

## URL del sistema
http://cestore.ces.com.uy/adminces

## Tecnologías utilizadas

- Java
- IntelliJ IDEA


## ¿Cómo ejecutar?

1. Clonar el repositorio.

2. Abrir el proyecto en IntelliJ IDEA.

3. Ejecutar SistemaUsuario.java.

4. Utilizar el menú de navegación por consola.


-------------------------------------------------------------------------------------------------------------------------------


# Funcionalidades principales del sistema

## 1. Registro de usuario Administrador

El sistema permite registrar usuarios con rol Administrador.

### Datos requeridos:

* Nombre
* Apellido
* Email (único)
* Contraseña
* País de nacimiento

---

## 2. Inicio de Sesión

Permite autenticar usuarios administradores dentro del sistema.

### Datos requeridos:

* Email (Único)
* Contraseña

---

## 3. Reinicio de Contraseña (Pendiente implementar)

El sistema permite actualizar la contraseña de un usuario administrador existente.

### Datos requeridos:

* Email del usuario (Único)
* Nueva contraseña
* Repetir nueva contraseña

---

# Gestión de Usuarios

El sistema permite a los usuarios Administradores gestionar cuentas de usuarios Tester.

Las funcionalidades identificadas son:

* Alta de usuarios Tester
* Baja de usuarios Tester (Pendiente implementar)
* Consulta de lista completa de usuarios (incluyendo administradores)

---

## 4. Alta de cuenta Tester

Permite registrar usuarios con rol Tester.

### Datos requeridos:

* Nombre
* Apellido
* Email (único)
* País de nacimiento
* Contraseña por defecto
* Perfil Tester

### Perfiles disponibles:

* Junior
* Senior
* Líder

### Países disponibles para perfil Tester:

* Uruguay
* Argentina
* Brasil
* Paraguay

---
Observaciones generales:

El sistema presenta funcionalidades típicas de una base de gestión de usuarios, cuenta con:

* autenticación
* gestión de usuarios
* control de acceso


---
Diagrama UML(Actualizado 19/7/2026):

                                         +--------------------------------------+
                                         |        <<abstract>> Usuario          |
                                         +--------------------------------------+
                                         | - nombre: String                     |
                                         | - apellido: String                   |
                                         | - email: String                      |
                                         | - contraseña: String                 |
                                         | - pais: String                       |
                                         | - edad: int                          |
                                         +--------------------------------------+
                                         | + Usuario(...)                       |
                                         | + getNombre()                        |
                                         | + getApellido()                      |
                                         | + getEmail()                         |
                                         | + getContraseña()                    |
                                         | + getPais()                          |
                                         | + getEdad()                          |
                                         | + setNombre()                        |
                                         | + setApellido()                      |
                                         | + setEmail()                         |
                                         | + setContraseña()                    |
                                         | + setPais()                          |
                                         | + setEdad()                          |
                                         | + getTipoUsuario()                   |
                                         +--------------------------------------+
                                                        ▲
                                                        │
                                   ┌────────────────────┴────────────────────┐
                                   │                                         │
                     +---------------------------+           +---------------------------+
                     |          Admin            |           |          Tester           |
                     +---------------------------+           +---------------------------+
                     |                           |           |                           |
                     +---------------------------+           +---------------------------+
                     | + Admin(...)              |           | + Tester(...)             |
                     | + getTipoUsuario()        |           | + getTipoUsuario()        |
                     +---------------------------+           +---------------------------+


+------------------------------------------------------+
|          <<Singleton>> GestorUsuarios                |
+------------------------------------------------------+
| - instancia: GestorUsuarios                          |
| - usuarios: ArrayList<Usuario>                       |
+------------------------------------------------------+
| + getInstance()                                      |
| + getUsuarios()                                      |
| + agregarUsuario(Usuario)                            |
+------------------------------------------------------+
                    │
                    │ administra
                    ▼
                 0..* Usuario


+------------------------------------------------------+
|                SistemaUsuario                        |
+------------------------------------------------------+
| - gestor: GestorUsuarios                             |
+------------------------------------------------------+
| + main(String[])                                     |
| + registrarUsuario(Scanner)                          |
| + validarEmail(String)                               |
| + loginUsuario(Scanner)                              |
| + crearTester(Scanner)                               |
| + listarUsuarios()                                   |
| + buscarUsuario(Scanner)                             |
| + menuAdministrador(Scanner)                         |
+------------------------------------------------------+
                    │
                    │ utiliza
                    ▼
             GestorUsuarios


+-------------------------------------+
| <<Exception>>                       |
| DatosInvalidosException             |
+-------------------------------------+

+-------------------------------------+
| <<Exception>>                       |
| EmailDuplicadoException             |
+-------------------------------------+

+-------------------------------------+
| <<Exception>>                       |
| UsuarioNoEncontradoException        |
+-------------------------------------+

--------
# Autor

Joaquín Aldama

	
