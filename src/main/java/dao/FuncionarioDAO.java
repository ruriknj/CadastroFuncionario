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

	public Telefone removerTelefone(int id);

}
