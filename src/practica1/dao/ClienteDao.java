package practica1.dao;

import java.util.List;
import practica1.entity.ClienteEntity;

public interface ClienteDao {

    void insertCliente(ClienteEntity insertar);

    List<ClienteEntity> listarCliente();

}
