package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.UsuarioDAO;
import dao.UsuarioDAOImp;
import entidade.Usuario;

@ManagedBean(name = "LoginBean")
@SessionScoped
public class LoginBean {

	private String txtCpf;
	private String txtSenha;

	private Usuario usuario;
	private List<Usuario> listaUsuarios;

	private UsuarioDAO usuarioDAO;

	public LoginBean() {
		this.usuario = new Usuario();
		this.listaUsuarios = new ArrayList<Usuario>();
		this.usuarioDAO = new UsuarioDAOImp();
	}

	/**
	 * Metodo utilizado para fazer o login e validar o usuario e senha
	 */
	public String entrar() {
		System.out.println("---------------------");

		for (Usuario u : listaUsuarios) {
			System.out.println(u.getCpf() + " - " + u.getSenha());
		}
		System.out.println("---------------------");

		boolean achou = false;

		this.listaUsuarios = this.usuarioDAO.listarTodos();

		for (Usuario usuarioLista : this.listaUsuarios) {
			if (usuarioLista.getCpf().equals(this.txtCpf) && usuarioLista.getSenha().equals(this.txtSenha)) {

				achou = true;

			}
		}

		if (achou) {
			return "Home.xhtml";
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Usuário invalido!!!"));
			return "";
		}
	}

	/**
	 * Metodo utilizado para salvar o usuario criado
	 */
	public void salvarUsuario() {

		Usuario novo = new Usuario();

		novo.setNome(this.usuario.getNome());
		novo.setCpf(this.usuario.getCpf());
		novo.setSenha(this.usuario.getSenha());

		System.out.println("Lista usuario: " + novo);
		//this.listaUsuarios.add(novo);
		this.usuarioDAO.inserir(novo);

		this.usuario = new Usuario();

	}

	public String getTxtCpf() {
		return txtCpf;
	}

	public void setTxtCpf(String txtCpf) {
		this.txtCpf = txtCpf;
	}

	public String getTxtSenha() {
		return txtSenha;
	}

	public void setTxtSenha(String txtSenha) {
		this.txtSenha = txtSenha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

}
