package bd.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {
	
	private static String basedatos="test";
	private static String url="jdbc:mysql://localhost/" + basedatos;
	private static String user ="root";
	private static String password="********";
	
	//funcion principal
	public static void main(String[] args)
	{
		try {
			//objeto para conectar a la base de datos
			Connection conexion;
			//objeto statement que nos permite preparar un query
			Statement instruccion;
			//objeto resulset que almacena la informacion de la consulta creada con statement.
			ResultSet setRes;
			
	
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conexion = DriverManager.getConnection(url, user, password);
			
			if(conexion!=null)
			{
				instruccion = conexion.createStatement();
				
				setRes = instruccion.executeQuery("Select * from usuarios;");
				while(setRes.next())
				{
					String resulset = Integer.toString(setRes.getInt(1)) + " " 
														+ setRes.getString(2) + " " 
							                            + setRes.getString(3) + " "
							                            + setRes.getString(4) + " "
							                            + setRes.getString(5) + " "
							                            + setRes.getString(6) + " "
							                            + setRes.getString(7);
					System.out.println(resulset);
				}
				setRes.close();
				instruccion.close();
				conexion.close();
			}
		} catch (InstantiationException e) {
			System.out.println("ERROR : " + e.getMessage());
		} catch (IllegalAccessException e) {
			System.out.println("ERROR : " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("ERROR : " + e.getMessage());
		}
	}
}
