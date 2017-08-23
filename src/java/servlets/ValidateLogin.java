/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import login.DatabaseConnection;
/**
 *
 * @author GAMERO
 */
public class ValidateLogin extends HttpServlet {

    Connection  conn;
    ResultSet  res;
    String username, password, query;
    DatabaseConnection dbconn;
    
       protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try {
           username = request.getParameter("username");
           password = request.getParameter("password");
           if(request.getParameter("listlogin").equals("Administrador")){
           
           query= "select * from administrador where nomadmin= '"+username+"' and passadmin='"+password+"'";
           dbconn = new DatabaseConnection();
           conn = dbconn.setConnection();
           res = dbconn.getResult(query,conn);
               if(res.next()){
                   
                  RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/admin/mainadmin.jsp");
                  rd.forward(request, response);
               }else{
                 RequestDispatcher rd = request.getRequestDispatcher("loginerror.jsp");
                 rd.forward(request, response);
                }
           }else if(request.getParameter("listlogin").equals("Docente")){
               query= "select * from docente where usuario_d= '"+username+"' and clave_d='"+password+"'";
                dbconn = new DatabaseConnection();
                 conn = dbconn.setConnection();
                res = dbconn.getResult(query,conn);
                 if(res.next()){
                  RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/docente/menudocente.jsp");
                  rd.forward(request, response);
               }else{
                 RequestDispatcher rd = request.getRequestDispatcher("loginerror.jsp");
                 rd.forward(request, response);
                }
               
               
           }else if(request.getParameter("listlogin").equals("Alumno")){
                query= "select * from alumno where usuario_a= '"+username+"' and clave_a='"+password+"'";
                dbconn = new DatabaseConnection();
                 conn = dbconn.setConnection();
                res = dbconn.getResult(query,conn);
                 if(res.next()){
                  RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/alumno/menualumno.jsp");
                  rd.forward(request, response);
                 }else{
                 RequestDispatcher rd = request.getRequestDispatcher("loginerror.jsp");
                 rd.forward(request, response);
                }
               
           }
           RequestDispatcher rd = request.getRequestDispatcher("loginerror.jsp");
                 rd.forward(request, response);
           
           
        }catch(Exception e){
            RequestDispatcher rd = request.getRequestDispatcher("loginerror.jsp");
            rd.forward(request, response);
             }
              finally{
                out.close();
              }
        }
       

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
