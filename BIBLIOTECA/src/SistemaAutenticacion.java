

import java.util.List;

public class SistemaAutenticacion {
    public static Usuario autenticarUsuario(String nombre, String contrasena, List<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            if (usuario.nombre.equals(nombre) && usuario.contrasena.equals(contrasena)) {
                return usuario;
            }
        }
        return null;
    }
}