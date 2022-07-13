package MissingStudio.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class JDBCJUnitTest {

    /**
     * Constante de URI para conectar a BBDD
     */
    protected static String uriConexionBD = "jdbc:mysql://localhost:3306/bddtv";

    @Test
    public void testJDBC() throws ClassNotFoundException, SQLException {
        Connection conexionBD = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexionBD = DriverManager.getConnection(uriConexionBD, "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(conexionBD);
        conexionBD.close();
    }
}
