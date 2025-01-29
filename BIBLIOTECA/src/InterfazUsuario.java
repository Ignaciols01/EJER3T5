// Archivo: InterfazUsuario.java
import java.util.*;

public class InterfazUsuario {
    static Usuario usuarioActual;
    static Scanner scanner = new Scanner(System.in);

    public static void iniciarSesion() {
        while (true) {
            System.out.println("--- Bienvenido a la Biblioteca Digital ---");
            System.out.print("Nombre de usuario: ");
            String nombre = scanner.nextLine();
            System.out.print("Contraseña: ");
            String contrasena = scanner.nextLine();

            usuarioActual = SistemaAutenticacion.autenticarUsuario(nombre, contrasena, Biblioteca.usuarios);
            if (usuarioActual != null) {
                System.out.println("¡Inicio de sesión exitoso! Bienvenido, " + usuarioActual.nombre);
                mostrarMenu();
                break;
            } else {
                System.out.println("Credenciales incorrectas. Inténtelo de nuevo.\n");
            }
        }
    }

    public static void mostrarMenu() {
        while (true) {
            System.out.println("\n--- Menú Principal ---");
            if (usuarioActual.esAdmin) {
                System.out.println("1. Agregar libro");
                System.out.println("2. Eliminar libro");
                System.out.println("3. Mostrar libros");
                System.out.println("4. Mostrar libros prestados");
            } else {
                System.out.println("1. Buscar libros");
                System.out.println("2. Realizar préstamo");
                System.out.println("3. Devolver libro");
            }
            System.out.println("0. Salir");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 0) {
                System.out.println("Cerrando sesión...");
                break;
            }

            if (usuarioActual.esAdmin) {
                switch (opcion) {
                    case 1 -> agregarLibro();
                    case 2 -> eliminarLibro();
                    case 3 -> Biblioteca.mostrarLibros();
                    case 4 -> Biblioteca.mostrarLibrosPrestados();
                    default -> System.out.println("Opción inválida.");
                }
            } else {
                switch (opcion) {
                    case 1 -> buscarLibros();
                    case 2 -> realizarPrestamo();
                    case 3 -> devolverLibro();
                    default -> System.out.println("Opción inválida.");
                }
            }
        }
    }

    public static void agregarLibro() {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Categoría: ");
        String categoria = scanner.nextLine();
        Biblioteca.agregarLibro(titulo, autor, categoria);
    }

    public static void eliminarLibro() {
        System.out.print("Ingrese el título del libro a eliminar: ");
        String titulo = scanner.nextLine();
        Biblioteca.eliminarLibro(titulo);
    }

    public static void realizarPrestamo() {
        System.out.print("Ingrese el título del libro a prestar: ");
        String titulo = scanner.nextLine();
        for (Libro libro : Biblioteca.libros) {
            if (libro.titulo.equalsIgnoreCase(titulo) && !libro.prestado) {
                libro.prestado = true;
                usuarioActual.prestamos.add(libro);
                System.out.println("Préstamo realizado exitosamente.");
                return;
            }
        }
        System.out.println("El libro no está disponible.");
    }

    static void buscarLibros() {
        System.out.print("Ingrese título, autor o categoría: ");
        String criterio = scanner.nextLine().toLowerCase();

        for (Libro libro : Biblioteca.libros) {
            if (libro.titulo.toLowerCase().contains(criterio) ||
                libro.autor.toLowerCase().contains(criterio) ||
                libro.categoria.toLowerCase().contains(criterio)) {
                System.out.println(libro);
            }
        }
    }

    public static void devolverLibro() {
        System.out.print("Ingrese el título del libro a devolver: ");
        String titulo = scanner.nextLine();
        for (Iterator<Libro> it = usuarioActual.prestamos.iterator(); it.hasNext(); ) {
            Libro libro = it.next();
            if (libro.titulo.equalsIgnoreCase(titulo)) {
                libro.prestado = false;
                it.remove();
                System.out.println("Libro devuelto exitosamente.");
                return;
            }
        }
        System.out.println("No se encontró el libro en sus préstamos.");
    }
}
