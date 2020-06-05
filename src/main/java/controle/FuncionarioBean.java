package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.FuncionarioDAO;
import dao.FuncionarioDAOImp;
import entidade.Endereco;

import entidade.Funcionario;
import entidade.Telefone;
import util.JpaUtil;

@SessionScoped
@ManagedBean(name = "FuncionarioBean")
public class FuncionarioBean {

	private Funcionario funcionario;
	private Endereco endereco;
	private FuncionarioDAO funcionarioDAO;
	private Telefone telefoneNovo;
	private List<Telefone> telefones;
	private List<Funcionario> funcionarios;
	private int idFuncionarioSelecionado;
	private String nomeFeiraSelecionado;

	public FuncionarioBean() {

		this.funcionario = new Funcionario();
		this.endereco = new Endereco();
		this.funcionarioDAO = new FuncionarioDAOImp();
		this.telefoneNovo = new Telefone();
		this.funcionario.setTelefones(new ArrayList<Telefone>());
		// this.telefoneNovo.setFuncionario(this.funcionario);
		this.funcionarios = new ArrayList<Funcionario>();
		// this.funcionarios = this.funcionarioDAO.listarTodos();
	}

	public void listarTodos() {

		this.funcionarios = this.funcionarioDAO.listarTodos();

	}

	public void listarContato() {
		EntityManager ent = JpaUtil.getEntityManager();
		// EntityTransaction tm = ent.getTransaction();

		Query query = ent.createQuery("from Funcionario f");
		List<Funcionario> funcionarios = query.getResultList();

		System.out.println("===== Entrou Consulta: ====");
		System.out.println(funcionarios);
	}

	public Funcionario listaFeira() throws IOException {

		this.funcionario = this.funcionarioDAO.ListaFeira(nomeFeiraSelecionado);
		funcionario.setNome(nomeFeiraSelecionado);
		System.out.println("Feira Selecionada: " + nomeFeiraSelecionado + this.funcionario);
		abrirManterUsuario();

		if (funcionario.getId() != 0) {

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sucesso", "Feira existe!!!"));
		}
		return null;

	}

	public void abrirManterUsuario() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect("manterFuncionario.xhtml");
	}

	public void salvar() {

		this.funcionarioDAO.inserir(this.funcionario);
	}

	public void adicionarTelefone() {

		Telefone novo = new Telefone();

		novo.setFuncionario(this.funcionario);

		System.out.println("item digitado: " + this.telefoneNovo + novo.getCodigoArea());
		novo.setCodigoArea(this.telefoneNovo.getCodigoArea());
		novo.setNumero(this.telefoneNovo.getNumero());
		novo.setTipo(this.telefoneNovo.getTipo());

		System.out.println("Item novo 1: " + novo);
		boolean achou = false;
		for (Telefone fone : this.funcionario.getTelefones()) {
			if (fone.getCodigoArea().equalsIgnoreCase(this.telefoneNovo.getCodigoArea())
					&& (fone.getNumero().equalsIgnoreCase(this.telefoneNovo.getNumero()))) {
				achou = true;
				System.out.println("Item novo 2: " + novo);

			}
		}

		if (achou) {
			// mensagem item j� existe na lista
		} else {

			this.funcionario.getTelefones().add(novo);

		}

		// adicionar mensagem de sucesso.
		this.funcionario.setEndereco(this.endereco);
	}

	public void limpar() {

		this.funcionario = new Funcionario();
		this.funcionario.setTelefones(new ArrayList<Telefone>());
		this.telefoneNovo = new Telefone();
		this.endereco = new Endereco();

	}

	public String editarFuncionario() {
		
		System.out.println("Funcionario selecionado: " + idFuncionarioSelecionado);
			this.funcionario.setId(idFuncionarioSelecionado);
			this.funcionario.getId();
		Funcionario funcionarioRecuperado = this.funcionarioDAO.pesquisar(this.idFuncionarioSelecionado);
		System.out.println("Funcionario achado " + funcionarioRecuperado);
		if (funcionarioRecuperado != null) {
			this.funcionario = funcionarioRecuperado;
			return "manterFuncionario.xhtml";

		} else {
			// Manda erro,n�o achou
			return "";
		}
	}

	public void removerFuncinario() {
		
		System.out.println("Funcionario selecionado: " + idFuncionarioSelecionado);

		if (this.funcionario.getId() != 0) {

		this.funcionarioDAO.removerFuncionario(idFuncionarioSelecionado);
		}
		else {
		System.out.println("Funcionario novo: " + this.funcionario.getId());
		}
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Telefone getTelefoneNovo() {
		return telefoneNovo;
	}

	public void setTelefoneNovo(Telefone telefoneNovo) {
		this.telefoneNovo = telefoneNovo;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public int getIdFuncionarioSelecionado() {
		return idFuncionarioSelecionado;
	}

	public void setIdFuncionarioSelecionado(int idFuncionarioSelecionado) {
		this.idFuncionarioSelecionado = idFuncionarioSelecionado;
	}

	public String getNomeFeiraSelecionado() {
		return nomeFeiraSelecionado;
	}

	public void setNomeFeiraSelecionado(String nomeFeiraSelecionado) {
		this.nomeFeiraSelecionado = nomeFeiraSelecionado;
	}

}
