package practica1.servi;

import java.util.List;
import practica1.dao.ClienteDao;
import practica1.dao.impl.ClienteDaoImpl;
import practica1.entity.ClienteEntity;

public class ClienteServic implements ClienteDao {

    private ClienteDao cliente = new ClienteDaoImpl();

    @Override
    public void insertCliente(ClienteEntity insertar) {
        cliente.insertCliente(insertar);
    }
    
    
    public void eliminarCliente(ClienteEntity cliente) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ClienteEntity> listarCliente() {
        return cliente.listarCliente();
    }
    
}
