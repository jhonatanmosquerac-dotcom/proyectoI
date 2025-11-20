package co.edu.uniquindio.poo.proyectofinal.banco.model.dominio;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class UsuarioTest {
    @Test
    void testAutenticar() {
    Banco banco = new Banco("BancoPrueba", "123456789", "DireccionPrueba", "NIT123456", "CiudadPrueba");
    Cliente cliente = new Cliente("123456789", "Juan Perez", "Calle Falsa 123", "juan.perez@example.com", LocalDate.of(2002,02,12), "12231", banco);
    Usuario usuario = new Usuario("juanp", "password123", cliente);
    assert(usuario.autenticar("juanp", "password123"));
    }
}
