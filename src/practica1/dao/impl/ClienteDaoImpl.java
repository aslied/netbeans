package practica1.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import practica1.conex.AccesoDB;
import practica1.dao.ClienteDao;
import practica1.entity.ClienteEntity;

public class ClienteDaoImpl implements ClienteDao {

    @Override
    public void insertCliente(ClienteEntity insertar) {
        Connection db = null;
        PreparedStatement sentencia = null;
        insertar.setEstado("0");
        try {
            String sql = "INSERT INTO cliente(nombre,direccion,telefono) VALUES (?,?,?)";

            db = AccesoDB.getConnection();
            sentencia = db.prepareStatement(sql);
            sentencia.setString(1, insertar.getNombre());
            sentencia.setString(2, insertar.getDireccion());
            sentencia.setString(3, insertar.getTelefono());
            sentencia.executeUpdate();
            insertar.setEstado("1");

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            if (sentencia != null) {
                try {
                    sentencia.close();
                } catch (Exception e) {
                }
            }
            if (db != null) {
                try {
                    db.close();
                } catch (Exception e) {
                }
            }

        }

    }

    @Override
    public List<ClienteEntity> listarCliente() {
        Connection cnx = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        ClienteEntity cliente = null;
        List<ClienteEntity> list = new ArrayList<>();
        try {
            cnx = AccesoDB.getConnection();
            String sql = "select * from cliente order by id";
            sentencia = cnx.prepareStatement(sql);
            rs = sentencia.executeQuery();
            while (rs.next()) {
                cliente = new ClienteEntity();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTelefono(rs.getString("telefono"));
                list.add(cliente);

            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                }
            }

            if (sentencia != null) {
                try {
                    sentencia.close();
                } catch (Exception e) {
                }
            }
            if (cnx != null) {
                try {
                    cnx.close();
                } catch (Exception e) {
                }
            }
        
        }
        return list;
    }

}
