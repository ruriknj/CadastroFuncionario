package entidade;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Funcionario")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "funcionario_id")
	private Integer id;
	private String nome;
	private String sobrenome;

	@OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
	private List<Telefone> telefones;

	@OneToOne
	@JoinColumn(name = "endereco_id", referencedColumnName = "endereco_id")
	private Endereco endereco;

	public Funcionario() {
	}

	public Funcionario(Integer id, String nome, String sobrenome) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		//this.endereco = endereco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", telefones=" + telefones
				+ "]";
	}

	
}

