package aplicativo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import entidade.Funcionario;
import util.JpaUtil;

public class CRUD {

	public static void main(String[] args) {

		salvar();

	}

	public static void salvar() {

		Funcionario fun1 = new Funcionario(null, "luiz", "Barroso");
		
	
		// Endereco end1 = new Endereco(null, "Rua A", "Bairro A", "cidade A", "estado
		// A", "1111-11");
		// fun1.setEndereco(end1);

		// Telefone tel1 = new Telefone(null, "21", "32322328", "celular");
		// fun1.getTelefones().addAll(Arrays.asList(tel1));

		System.out.println("Saida de dados: " + fun1 + ",");

		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tm = ent.getTransaction();

		tm.begin();
		ent.persist(fun1);
		tm.commit();
		ent.close();

	}

	public static void pesquisar() {
		EntityManager ent = JpaUtil.getEntityManager();

		Query query = ent.createQuery("from Funcionario u");
		List<Funcionario> funcionarios = query.getResultList();

	}

}
