package main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.JDBC;

public class Queries {
	private static Connection connection = JDBC.getConnection();
	private static Statement st = null;
    private static ResultSet rs = null;
    
    public static void inserirSala(int id, int numero, int capacidade, String codigo_bloco) throws SQLException{
    	String query = "INSERT INTO Sala VALUES ("+id+","+numero+","+capacidade+","+codigo_bloco+")";
    	st = connection.createStatement();
    	st.execute(query);
    	System.out.println("Sala inserida com sucesso!");
    }
    
    public static void selecionarPessoaPorCPF(String cpf) throws SQLException{
    	String query = "SELECT nome FROM Pessoa WHERE cpf = '"+cpf+"'";
    	st = connection.createStatement();
    	rs = st.executeQuery(query);
    	while (rs.next()){
    		System.out.println(rs.getString(1));
    	}
    }

	public static void selecionarProfessoras() throws SQLException {
		String query = "SELECT * FROM vprofessoras";
    	st = connection.createStatement();
    	rs = st.executeQuery(query);
    	while (rs.next()){
    		System.out.println(rs.getString(1));
    	}
	}

	public static void descobreAlunosProfessores() throws SQLException {
		String query = "SELECT * FROM seleciona_alunos_professores()";
    	st = connection.createStatement();
    	rs = st.executeQuery(query);
        String dre = null;
        String nome = null;
        String registro = null;
    	while (rs.next()){
    		dre = rs.getString(1);
    		registro = rs.getString(2);
    		if (!(dre==null || registro==null)){
    			nome = selecionarPessoaPorDRE(dre);
        		System.out.println(nome+" - dre: " +dre+" registro: "+registro);
    		}
    	}
	}
	
    private static String selecionarPessoaPorDRE(String dre) throws SQLException{
    	String query = "SELECT nome FROM Pessoa JOIN Aluno ON Aluno.cpf=Pessoa.CPF WHERE Aluno.dre = '"+dre+"'";
    	st = connection.createStatement();
    	rs = st.executeQuery(query);
    	while (rs.next()){
    		return rs.getString(1);
    	}
    	return null;
    }
}
