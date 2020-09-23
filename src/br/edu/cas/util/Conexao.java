package br.edu.cas.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {


  private static final String USERNAME = "postgres";

  private static final String PASSWORD = "1234";

  private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/postgres";

  public static Connection getConnection() {
	  
	  Connection connection = null;
	  
	  try {
		
		  Class.forName("org.postgresql.Driver"); //passando o driver
		  
		   connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		  //Cria a conexão com o banco de dados
		  
	} catch (Exception e) {
		e.printStackTrace();
	}
	  return connection;
  }
	
}
