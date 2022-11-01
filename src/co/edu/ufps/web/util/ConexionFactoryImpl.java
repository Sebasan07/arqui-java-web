package co.edu.ufps.web.util;

public class ConexionFactoryImpl  {

	public ConexionFactory getConexion(String tipo) {
		
		switch(tipo.toUpperCase()) {
		case "POSTGRESQL":
			return new ConexionPostgreSQL();
		default:
			return null;
		}
	}
}
