package dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entidade.Usuario;
import util.JpaUtil;

public class UsuarioDAOImp implements UsuarioDAO {
		
		public void inserir(Usuario usuario) {

			EntityManager ent = JpaUtil.getEntityManager();
			EntityTransaction tx = ent.getTransaction();
			tx.begin();

			ent.persist(usuario);

			tx.commit();
			ent.close();

		}
		
		public List<Usuario> listarTodos() {

			EntityManager ent = JpaUtil.getEntityManager();

			Query query = ent.createQuery("from Usuario u");

			List<Usuario> usuarios = query.getResultList();

			return usuarios;

		}

	}



