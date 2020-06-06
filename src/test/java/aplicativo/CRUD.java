package aplicativo;

import java.util.Arrays;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import entidade.Endereco;
import entidade.Funcionario;
import entidade.Telefone;
import entidade.Usuario;
import util.JpaUtil;


public class CRUD {

	public static void main(String[] args) {

		//salvar();
		//listarContato();
		//remover();
		listarTodos();

	}

	public static void salvar() {
		// Relação: OnetoOne
		Funcionario fun1 = new Funcionario();
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

	public static void listarContato() {
		EntityManager ent = JpaUtil.getEntityManager();
		// EntityTransaction tm = ent.getTransaction();

		Query query = ent.createQuery("from Funcionario f");
		List<Funcionario> funcionarios = query.getResultList();

		System.out.println("===== Entrou Consulta: ====");
		System.out.println(funcionarios);

	}
	
	public static void remover() {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tm = ent.getTransaction();

		Funcionario funcionario = ent.find(Funcionario.class, 6);

		System.out.println("Remover Feira Mensal : " + funcionario);

		tm.begin();
		ent.remove(funcionario);
		tm.commit();

	}
	
	public static List<Usuario> listarTodos() {

		EntityManager ent = JpaUtil.getEntityManager();

		Query query = ent.createQuery("from Usuario u");

		List<Usuario> usuarios = query.getResultList();
		
		System.out.println("Lista todos usuarios: " + usuarios);

		return usuarios;

	}
}
