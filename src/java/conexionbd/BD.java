package conexionbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author saul.ortigoza
 */
public class BD {

    private static final String host = "127.0.0.1";
    private static final String bd = "rotacionmedicabienestar";
    private static final String usr = "root";
    private static final String pwd = "";
    private static final String protocolo = "jdbc:mysql://";
    private static final String driver = "com.mysql.jdbc.Driver";
    
    public static Connection getConection() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        return DriverManager.getConnection(protocolo+host+"/"+bd,usr,pwd);
    }    
}
