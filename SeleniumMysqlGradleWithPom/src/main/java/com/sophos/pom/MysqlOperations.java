package com.sophos.pom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static developmentutilities.MysqlOperationsUtilities.*;

public class MysqlOperations {
private Connection conexion = null; 
    
    public MysqlOperations () throws SQLException, ClassNotFoundException{
        try {
            connect();
        } catch (SQLException e) {
        	System.err.println("Error al conectar a la base de datos");
        }
    }
    
    public void connect() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		conexion = DriverManager.getConnection(getJDBC(), getUSER(), getPASSWORD());
   }
    
    public void closeConnection() throws SQLException{
        if (conexion!= null)
            conexion.close();
    }
    
    public ArrayList<String> consultData(String query) throws SQLException {
		Statement statement = conexion.createStatement();
		ResultSet resultadoQuery = statement.executeQuery(query);
		
		ArrayList<String> datos = new ArrayList<>();
        while (resultadoQuery.next()){
        	datos.add(resultadoQuery.getString("nombre"));         
        }
        resultadoQuery.close();
        statement.close();
        return datos;
	}
    
    public void executeQuery(String query) throws SQLException {
    	Statement statement = conexion.createStatement();
		statement.executeUpdate(query);
    }

}
