package com.sophos.test.proyectoMysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ManejoMysql {
private Connection conexion = null; 
    
    public ManejoMysql () throws SQLException{
        try {
            conectar();
        } catch (SQLException e) {
        	System.err.println("Error al conectar a la base de datos");
        }
    }
    
    public void conectar() throws SQLException{
        //se hace la url de conexion host-puerto-bd
       String jdbc = "jdbc:mysql://localhost:3306/datos?autoReconnect=true&useSSL=false";
       //String jdbc = "jdbc:mysql://localhost:3306/datos";
       // se obtiene la conexion. url-usuario-pass
       conexion = DriverManager.getConnection(jdbc, "root", "1234");
   }
    
    public void cerrar() throws SQLException{
        if (conexion!= null)
            conexion.close();
    }
    
    public ArrayList<String> consultaDatos(String query) throws SQLException {
		// Statement se utiliza para crear sentencias sql
		Statement statement = conexion.createStatement();
		// guardamos el resultado en un ResultSet
		ResultSet resultadoQuery = statement.executeQuery(query);
		
		//recorremos el ResultSet con next() que parará cuando no haya mas resultados
		ArrayList<String> datos = new ArrayList<>();
        while (resultadoQuery.next()){
        	datos.add(resultadoQuery.getString("nombre"));         
        }
        //cerramos todo
        resultadoQuery.close();
        statement.close();
        return datos;
	}
    
    public void ejecutarConsulta(String query) throws SQLException {
    	Statement statement = conexion.createStatement();
		statement.executeUpdate(query);
    }
    

}
