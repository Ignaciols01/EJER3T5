
import java.util.*;

public class Biblioteca {
    static List<Libro> libros = new ArrayList<>();
    static List<Usuario> usuarios = new ArrayList<>();

    public static void inicializarDatos() {
        libros.add(new Libro("IT", "Stephen King", "Terror"));
        libros.add(new Libro("El principito", "Antoine de Saint-Exupéry", "Fábula"));
        libros.add(new Libro("Cumbre Borrascosas", "Emily Bronte", "Drama"));
        libros.add(new Libro("Drácula", "Bram Stoker", "Terror"));
        libros.add(new Libro("Alicia en el País de las Maravillas", "Lewis Carrol", "Infantil"));
        libros.add(new Libro("Alicia en el País de las Maravillas", "Lewis Carrol", "Infantil"));
        libros.add(new Libro("Romeo y Julieta", "William Shakespeare", "Drama"));

        usuarios.add(new Usuario("admin", "admin123", true));
        usuarios.add(new Usuario("usuario1", "pass123", false));
    }

    public static void agregarLibro(String titulo, String autor, String categoria) {
        libros.add(new Libro(titulo, autor, categoria));
        System.out.println("Libro agregado exitosamente.");
    }

    public static void mostrarLibros() {
        System.out.println("\n--- Lista de Libros ---");
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }

    public static void mostrarLibrosPrestados() {
        System.out.println("\n--- Libros Prestados ---");
        for (Libro libro : libros) {
            if (libro.prestado) {
                System.out.println(libro);
            }
        }
    }

    public static void eliminarLibro(String titulo) {
        for (Iterator<Libro> it = libros.iterator(); it.hasNext(); ) {
            Libro libro = it.next();
            if (libro.titulo.equalsIgnoreCase(titulo)) {
                it.remove();
                System.out.println("Libro eliminado exitosamente.");
                return;
            }
        }
        System.out.println("No se encontró el libro.");
    }
}