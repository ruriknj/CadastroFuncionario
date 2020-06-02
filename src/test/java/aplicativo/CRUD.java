package aplicativo;

import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import entidade.Endereco;
import entidade.Funcionario;
import entidade.Telefone;
import util.JpaUtil;

public class CRUD {

	public static void main(String[] args) {

		//salvar();
		pesquisar();

	}

	public static void salvar() {
		// Relação: OnetoOne
		Funcionario fun1 = new Funcionario(null, "Flavio", "Gomes");
		Endereco end1 = new Endereco(null, "Rua B", "Bairro B", "cidade B", "estado B", "1111-11");
		fun1.setEndereco(end1);
		// =========================================================================================
		// Relação: OnetoMany
		System.out.println("Lista de endereço 1: " + fun1);
		Telefone tel1 = new Telefone(null, "81", "233323", "fixo");
		tel1.setFuncionario(fun1);
		System.out.println("Saida de dados: " + tel1);
		fun1.getTelefones().addAll(Arrays.asList(tel1));

		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tm = ent.getTransaction();

		tm.begin();
		ent.persist(fun1);
		tm.commit();
		ent.close();
	}

	public static void pesquisar() {
		EntityManager ent = JpaUtil.getEntityManager();
		// EntityTransaction tm = ent.getTransaction();

		Query query = ent.createQuery("from Funcionario u");
		List<Funcionario> funcionarios = query.getResultList();

		System.out.println("Entrou PEsquisar ====");
		System.out.println(funcionarios);

	}
}
