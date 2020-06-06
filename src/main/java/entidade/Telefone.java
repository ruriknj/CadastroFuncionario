package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Telefone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "telefone_id")
	private int id;
	private String codigoArea;
	private String numero;
	private String tipo;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", referencedColumnName = "funcionario_id")
	Funcionario funcionario;

	public Telefone() {
	}

	public Telefone(int id, String codigoArea, String numero, String tipo) {
		super();
		this.id = id;
		this.codigoArea = codigoArea;
		this.numero = numero;
		this.tipo = tipo;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigoArea() {
		return codigoArea;
	}

	public void setCodigoArea(String codigoArea) {
		this.codigoArea = codigoArea;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public String toString() {
		return "Telefone: [id=" + id + ", CodigoArea: " + codigoArea + ", N�mero: " + numero + ", Tipo: " + tipo + "]";
	}

}
