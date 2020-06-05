package dao;

import java.util.List;

import entidade.Endereco;
import entidade.Funcionario;
import entidade.Telefone;


public interface FuncionarioDAO {
	
	public void inserir(Funcionario funcionario);

	public void alterar(Funcionario funcionario);

	public Funcionario removerFuncionario(int id);

	public Funcionario pesquisar(int id);

	public List<Funcionario> listarTodos();

	public void removerItem(Telefone telefone);

	public Funcionario ListaFeira(String nomeFeiraSelecionado);
	
	public Endereco pesquisarItem(Integer id);

	}



