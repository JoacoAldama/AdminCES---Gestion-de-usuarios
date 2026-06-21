# Proyecto AdminCES -En construcción.

## URL del sistema

http://cestore.ces.com.uy/adminces



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

## 3. Reinicio de Contraseña

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
* Baja de usuarios Tester
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
* actualización de credenciales

---
Diagrama UML(Actual 21/6/2026):

+----------------------------------+
|    <<abstract>> Usuario          |
+----------------------------------+
| - nombre: String                 |
| - apellido: String               |
| - email: String                  |
| - contraseña: String             |
| - pais: String                   |
| - edad: int                      |
+----------------------------------+
| + Usuario(...)                   |
| + getNombre()                    |
| + getApellido()                  |
| + getEmail()                     |
| + getContraseña()                |
| + getPais()                      |
| + getEdad()                      |
| + setNombre()                    |
| + setApellido()                  |
| + setEmail()                     |
| + setContraseña()                |
| + setPais()                      |
| + setEdad()                      |
| + getTipoUsuario()               |
+----------------------------------+
                ▲
                |
        -------------------
        |                 |
        |                 |
+----------------+  +----------------+
|     Admin      |  |     Tester     |
+----------------+  +----------------+
|                |  |                |
+----------------+  +----------------+
| + Admin(...)   |  | + Tester(...)  |
| + getTipoUsuario()| | + getTipoUsuario() |
+----------------+  +----------------+


+--------------------------------------+
|         SistemaUsuario               |
+--------------------------------------+
| - usuarios: ArrayList<Usuario>       |
+--------------------------------------+
| + registrarUsuario()                 |
| + loginUsuario()                     |
| + listarUsuarios()                   |
| + buscarUsuario()                    |
+--------------------------------------+
                 |
                 | utiliza
                 ▼
      ArrayList<Usuario>

--------
# Autor

Joaquín Aldama

	
