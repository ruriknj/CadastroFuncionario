package controle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.FuncionarioDAO;
import dao.FuncionarioDAOImp;
import entidade.Endereco;
import entidade.Funcionario;
import entidade.Telefone;

@SessionScoped
@ManagedBean(name = "FuncionarioBean")
public class FuncionarioBean {

	private Funcionario funcionario;
	private Endereco endereco;
	private FuncionarioDAO funcionarioDAO;
	private Telefone telefoneNovo;
	private List<Telefone> telefones;

	public FuncionarioBean() {

		this.funcionario = new Funcionario();
		this.endereco = new Endereco();
		this.funcionarioDAO = new FuncionarioDAOImp();
		this.telefoneNovo = new Telefone();
		this.funcionario.setTelefones(new ArrayList<Telefone>());
		this.telefoneNovo.setFuncionario(this.funcionario);
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
			// mensagem item já existe na lista
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

}
