package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entities.Alta;
import persistence.DaoAlta;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;


import javax.sql.DataSource;

public class DaoAlta {

	Connection conn;
	DataSource ds;

	public static List<Alta> listaAlta;

	static {
		listaAlta = new ArrayList<Alta>();
	}

	public boolean add(Alta alta) throws ClassNotFoundException, SQLException {

		InitialContext ctx;
		
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/Pruebas");
		} catch (NamingException e1) {
			e1.printStackTrace();
		}
		
		conn = ds.getConnection();
		
		
		try {
			//Query utilizada para la inserción a la DB del objeto JSON pasado
			String query = "INSERT INTO dbo.GENESYS_ARTELOG (agente,extension,host,evento,descripcion) values(?,?,?,?,?)";

			try {
				PreparedStatement ps = conn.prepareStatement(query);
				
				ps.setString(1, alta.getAgente().toString());
				ps.setString(2, alta.getExtension().toString());
				ps.setString(3, alta.getHost().toString());
				ps.setString(4, alta.getEvento().toString());
				ps.setString(5, alta.getDescripcion().toString());

				ps.execute();

			} catch (Exception e) {
				System.out.println("Se ha producido un error al realizar la insercion");
				e.printStackTrace();
				conn.close();
				return false;
			}

		} catch (Exception e) {
			System.out.println("Se ha producido un error al realizar la conexion");
			e.printStackTrace();
			conn.close();
			return false;
		}
		conn.close();
		return true;

	}

}
