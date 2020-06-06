package dao;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import entidade.Endereco;
import entidade.Funcionario;
import entidade.Telefone;
import util.JpaUtil;

public class FuncionarioDAOImp implements FuncionarioDAO {

	// Usando como inserir e atualizar objetos.
	@Override
	public void inserir(Funcionario funcionario) {

		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tm = ent.getTransaction();

		tm.begin();
		ent.merge(funcionario);
		tm.commit();
		ent.close();

	}

	@Override
	public void alterar(Funcionario funcionario) {

	}

	@Override
	public Funcionario removerFuncionario(int id) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();

		tx.begin();

		Funcionario achou = ent.find(Funcionario.class, id);
		ent.remove(achou);

		tx.commit();
		ent.close();

		return achou;
	}

	@Override
	public Funcionario pesquisar(int id) {

		EntityManager ent = JpaUtil.getEntityManager();
		Funcionario funcionario = ent.find(Funcionario.class, id);

		return funcionario;
	}

	@Override
	public List<Funcionario> listarTodos() {

		EntityManager ent = JpaUtil.getEntityManager();
		// EntityTransaction tm = ent.getTransaction();

		Query query = ent.createQuery("from Funcionario f");
		List<Funcionario> funcionarios = query.getResultList();

		System.out.println("===== Entrou Consulta: ====");
		System.out.println(funcionarios);

		return funcionarios;
	}

	@Override
	public Telefone removerTelefone(int id) {

		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();

		tx.begin();

		Telefone achou = ent.find(Telefone.class, id);
		ent.remove(achou);

		tx.commit();
		ent.close();

		return achou;

	}

}
