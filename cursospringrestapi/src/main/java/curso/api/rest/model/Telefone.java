package curso.api.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Telefone {

	@Id
	@SequenceGenerator(name="telefone_seq", sequenceName="telefone_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="telefone_seq")
	private Long id;
	
	private String numero;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "usuario_id") // nome da coluna no banco
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	
}
