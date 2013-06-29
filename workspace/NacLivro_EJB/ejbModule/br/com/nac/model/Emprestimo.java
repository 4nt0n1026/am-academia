package br.com.nac.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name="seqEmprestimo", sequenceName="SEQ_EMPRESTIMO", allocationSize=1)
public class Emprestimo implements Serializable {
	
	@Id
	@GeneratedValue(generator="seqEmprestimo", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATA_EMPRESTIMO", nullable=false)
	private Calendar dtEmprestimo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATA_RETORNO", nullable=false)
	private Calendar dtRetorno;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="ID_USUARIO", nullable=false)
	private Usuario usuario;

	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="EMPRESTIMO_EXEMPLAR", 
	joinColumns={@JoinColumn(name="EMPRESTIMO_ID")},
	inverseJoinColumns={@JoinColumn(name="EXEMPLAR_ID")})
	private List<Exemplar> exemplares;
	
	
	public List<Exemplar> getExemplares() {
		return exemplares;
	}

	public void setExemplares(List<Exemplar> exemplares) {
		this.exemplares = exemplares;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getDtEmprestimo() {
		return dtEmprestimo;
	}

	public void setDtEmprestimo(Calendar dtEmprestimo) {
		this.dtEmprestimo = dtEmprestimo;
	}

	public Calendar getDtRetorno() {
		return dtRetorno;
	}

	public void setDtRetorno(Calendar dtRetorno) {
		this.dtRetorno = dtRetorno;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
