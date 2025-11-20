package co.edu.uniquindio.poo.proyectofinal.banco.model.dominio;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class BeneficioTest {

    @Test
    void testCanjear() {
        // Preparación del entorno de prueba
        Banco banco = new Banco("BancoPrueba", "123456789", "DireccionPrueba", "NIT123456", "CiudadPrueba");
        Cliente cliente = new Cliente("123456789", "Juan Perez", "Calle Falsa 123", "juan.perez@example.com", LocalDate.of(2002,02,12), "12231", banco);
        cliente.setPuntos(1000);
        Beneficio beneficio = new Beneficio("Descuento", 30, "Descuento en compras");
    
        // Ejecución
        boolean resultado = beneficio.canjear(cliente);

        // Verificaciones
        assertTrue(resultado);
        assertEquals(500, cliente.getPuntos()); // 1000 - 500
    }
}
