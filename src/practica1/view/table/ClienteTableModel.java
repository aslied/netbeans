
package practica1.view.table;

import java.util.ArrayList;
import java.util.List;
import static javax.swing.UIManager.getInt;
import static javax.swing.UIManager.getString;
import javax.swing.table.DefaultTableModel;
import practica1.entity.ClienteEntity;
import static sun.font.FontManagerNativeLibrary.load;


public class ClienteTableModel extends DefaultTableModel{
  
    private final Class[] clase =new Class[]{String.class, String.class, String.class,String.class};
    private final String[]header=new String[]{"ID", "Nombre", "Direccion", "Telefono"};
 
    private List<ClienteEntity>list;
    
    public ClienteTableModel(List<ClienteEntity>list){
        this.list=list;
        load();
    }
    @Override
    public String getColumnName(int Column){
        return header [Column];
        
    }
    @Override
    public Class<?> getColumnClass(int columnIndex){
        return clase[columnIndex];
    }
    @Override
    public int getColumnCount(){
        return header.length;
            }
    private void load(){
        for(ClienteEntity entity : list){
            List<String>row = new ArrayList<>();
            //row.add(StrUtil.getString(entity.getId()));
            row.add(getString(entity.getId()));
            row.add(entity.getNombre());
            row.add(entity.getDireccion());
            row.add(entity.getTelefono());
            addRow(row.toArray(new String[row.size()]));
                       
        }
    }
    //Public boolean isCellEditable(int rowIndex, int columnIndex){
       // return false;
    //}
}
