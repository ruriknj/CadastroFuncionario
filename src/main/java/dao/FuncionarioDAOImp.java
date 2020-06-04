package dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entidade.Endereco;
import entidade.Funcionario;
import entidade.Telefone;
import util.JpaUtil;

public class FuncionarioDAOImp implements FuncionarioDAO {

	@Override
	public void inserir(Funcionario funcionario) {
		
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tm = ent.getTransaction();

		tm.begin();
		ent.persist(funcionario);
		tm.commit();
		ent.close();

	}

	@Override
	public void alterar(Funcionario funcionario) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remover(Funcionario funcionario) {
		// TODO Auto-generated method stub

	}

	@Override
	public Funcionario pesquisar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removerItem(Telefone telefone) {
		// TODO Auto-generated method stub

	}

	@Override
	public Funcionario ListaFeira(String nomeFeiraSelecionado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Endereco pesquisarItem(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
