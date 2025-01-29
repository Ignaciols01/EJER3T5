
public class Libro {
    String titulo, autor, categoria;
    boolean prestado;

    public Libro(String titulo, String autor, String categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.prestado = false;
    }

    @Override
    public String toString() {
        return "[" + (prestado ? "Prestado" : "Disponible") + "] " + titulo + " - " + autor + " (" + categoria + ")";
    }
}