package co.edu.uniquindio.poo.proyectofinal.banco.model.servicios;

package co.edu.uniquindio.poo.proyectofinal.banco.model.servicios;

import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.Cliente;
import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.CuentaVirtual;
import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.Usuario;
import co.edu.uniquindio.poo.proyectofinal.banco.model.puntos.PuntosService;
import co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones.Deposito;
import co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones.Retiro;
import co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones.Transferencia;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Clase que actua como centro de operaciones, NO representa un banco.
 *
 * @author DANIEL GIL, JHONATAN MOSQUERA.
 */
public class BancoService {
    private Map<String, Usuario>  usuarios = new HashMap<>();
    private final Map<String, String> credenciales = new HashMap<>(); // username -> password
    private final Map<String, CuentaVirtual> cuentas = new HashMap<>(); // numeroCuenta -> cuenta
    private final Notificador notificador = new Notificador();
    private final PuntosService puntosService = new PuntosService();
    private Usuario sesion;

    public Notificador getNotificador() {
        return notificador;
    }
    // Obtiene al usuario asugnado a el usuario si la sesion existe (depende del ususario)
    public Optional<Cliente> getSesion() {
        return Optional.ofNullable(sesion).map(Usuario::getCliente);
    }

    // Optiene al usuario en sesio siempre que exista
    public Optional<Usuario> getSesionUsuario() {
        return Optional.ofNullable(sesion);
    }


    public boolean login(String username, String password) {
        Usuario u = usuarios.get(username);
        if (u != null && u.getPassword().equals(password)) {
            sesion = u;
            return true;
        }
        sesion = null;
        return false;
    }

    public boolean registrar(String username, String password, Cliente cliente) {
        if (usuarios.containsKey(username)) {
            return false;
        }
        Usuario nuevoUsuario = new Usuario(username, password, cliente);
        nuevoUsuario.setCliente(cliente);
        usuarios.put(username, nuevoUsuario);
        return true;
    }

    public boolean completarPerfil(Cliente c) {
        if (c == null) return false;
        Usuario u = usuarios.get(c.getUsername());
        if (u == null) return false;
        u.setCliente(c);
        return true;
    }

    public CuentaVirtual crearCuentaUnica(Cliente c, String numeroCuenta) {
        if (c.getCuenta() != null) return c.getCuenta();

        CuentaVirtual cuenta = new CuentaVirtual(numeroCuenta, 0.0, c);
        c.setCuenta(cuenta);

        cuentas.put(numeroCuenta, cuenta);
        notificador.notificar("Cuenta creada: " + numeroCuenta + " con saldo inicial 0.0");

        return cuenta;
    }

    public CuentaVirtual buscarCuenta(String numero) {
        return cuentas.get(numero);
    }

    public boolean depositar(Cliente c, double monto) {
        if (c.getCuenta() == null) return false;
        Deposito d = new Deposito(c.getCuenta(), monto);
        boolean ok = d.ejecutar();
        if (ok) {
            int puntos = puntosService.sumPuntos(c, d);
            notificador.notificar(d.enviarNotificacion() + " | Puntos +" + puntos);
            c.getHistorial().add(d);
        }
        return ok;
    }

    public boolean retirar(Cliente c, double monto) {
        if (c.getCuenta() == null) return false;
        Retiro r = new Retiro(c.getCuenta(), monto);
        boolean ok = r.ejecutar();
        if (ok) {
            int puntos = puntosService.sumPuntos(c, r);
            notificador.notificar(r.enviarNotificacion() + " | Puntos +" + puntos);
            c.getHistorial().add(r);
        }
        return ok;
    }

    public boolean transferir(Cliente origen, String cuentaDestino, double monto) {
        CuentaVirtual destino = buscarCuenta(cuentaDestino);
        if (origen.getCuenta() == null || destino == null) return false;
        Transferencia t = new Transferencia(origen.getCuenta(), destino, monto);
        boolean ok = t.ejecutar();
        if (ok) {
            int puntos = puntosService.sumPuntos(origen, t);
            notificador.notificar(t.enviarNotificacion() + " | Puntos +" + puntos);
            origen.getHistorial().add(t);
            destino.getCliente().getHistorial().add(t);
        }
        return ok;
    }

    public boolean canjearBeneficio(Cliente c, String nombreBeneficio, int costoPuntos) {
        if (puntosService.getPuntos(c) < costoPuntos) return false;
        puntosService.restarPuntos(c, costoPuntos);
        notificador.notificar("Beneficio canjeado: " + nombreBeneficio + " | -" + costoPuntos + " puntos");
        return true;
    }
}