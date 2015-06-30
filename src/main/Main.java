package main;

import java.sql.SQLException;

public class Main {
	public static void main(String[] argv) throws SQLException {
		// Duas consultas:
		// Insere uma nova sala (codigo,numero,capacidade,codigo_bloco)
		Queries.inserirSala(5, 3, 600, "1");
		// Seleciona uma pessoa pelo seu CPF
		Queries.selecionarPessoaPorCPF("14256772740");
		// Consulta na view vprofessoras :
		Queries.selecionarProfessoras();
		// Chama a função seleciona_alunos_professores(), e descobre o nome desta pessoa
		Queries.descobreAlunosProfessores();
	}
}
