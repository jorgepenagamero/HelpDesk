/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author GAMERO
 */
public class cConexion {
     private static final String MYSQL_URL = "jdbc:mysql://localhost:3306/helpdesk?zeroDateTimeBehavior=convertToNull";
    private static final String MYSQL_USER = "root";
    private static final String MYSQL_PASSWD = "toor";

    public static Connection conectar_ds() {
        Connection cnn = null;
        try {

            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            cnn = DriverManager.getConnection(MYSQL_URL, MYSQL_USER, MYSQL_PASSWD);
            System.out.println("Conectado a " + MYSQL_URL);
        } catch (SQLException ex) {
            System.out.println("Error al conectarse a la base de datos: " + ex.getMessage());
        } finally {
            return cnn;
        }
    }
    public static void main(String args[]){
        conectar_ds();
    }
}
