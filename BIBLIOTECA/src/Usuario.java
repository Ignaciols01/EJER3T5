
import java.util.*;

public class Usuario {
    String nombre, contrasena;
    boolean esAdmin;
    List<Libro> prestamos;

    public Usuario(String nombre, String contrasena, boolean esAdmin) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.esAdmin = esAdmin;
        this.prestamos = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Usuario: " + nombre + (esAdmin ? " (Admin)" : " (Usuario)") + ", Préstamos activos: " + prestamos.size();
    }
}