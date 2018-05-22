package practica1.conex;


import java.sql.Connection;
import java.sql.DriverManager;


public class AccesoDB {

private static final String DRIVE="com.mysql.jdbc.Driver";
private static final String URL="jdbc:mysql://localhost:3306/prueva1";
private static final String USUAR="root";
private static final String PASS="";
    
    
    
        
    public static Connection getConnection(){
        try {
            Class.forName(DRIVE);
            return DriverManager.getConnection(URL, USUAR, PASS);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
 
    }
    
}
