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
		// TODO Auto-generated method stub

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
	public void removerItem(Telefone telefone) {
		// TODO Auto-generated method stub

	}

	@Override
	public Endereco pesquisarItem(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Funcionario ListaFeira(String nomeFeiraSelecionado) {

		Funcionario funcionario = new Funcionario();

		EntityManager em = JpaUtil.getEntityManager();

		String hql = "SELECT u from Funcionario u WHERE u.nome like :nomeFeiraSelecionado";

		Query query = em.createQuery(hql);

		funcionario.setNome(nomeFeiraSelecionado);

		query.setParameter("nomeFeiraSelecionado", funcionario.getNome());

		try {
			funcionario = (Funcionario) query.getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Feira não existe!!!"));
		}

		return funcionario;
	}

}
