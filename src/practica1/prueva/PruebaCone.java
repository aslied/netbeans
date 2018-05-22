package practica1.prueva;
import practica1.conex.AccesoDB;
import practica1.entity.ClienteEntity;
import practica1.servi.ClienteServic;

public class PruebaCone {

    private static final ClienteServic service = new ClienteServic();

    public static void main(String[] args) {
        ClienteEntity cliente = new ClienteEntity();
       // //cliente.setNombre("Elias");
       // cliente.setDireccion("Lima");
       // cliente.setTelefono("987654321");
        service.insertCliente(cliente);
       cliente.setId(2);
        service.eliminarCliente(cliente);
    }

}
