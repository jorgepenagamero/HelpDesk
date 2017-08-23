/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConnection {
    public Statement st;
    public ResultSet rs;
    public Connection conn;
    
    public DatabaseConnection(){
        
    }
    @SuppressWarnings("CallToThreadDumpStack")
    public Connection setConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/helpdesk?zeroDateTimeBehavior=convertToNull","root","toor"); // url,us, pass
        }catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }
    public ResultSet getResult(String query, Connection conn){
        this.conn = conn;
        try{
            st=conn.createStatement();
            rs=st.executeQuery(query);
         }catch(Exception e){
             
         }
    return rs;
    }
}
