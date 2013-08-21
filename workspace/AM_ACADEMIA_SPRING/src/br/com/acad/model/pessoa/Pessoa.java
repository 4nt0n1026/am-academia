package br.com.acad.model.pessoa;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.acad.model.contato.Endereco;
import br.com.acad.model.contato.Telefone;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="ACAD_PESSOA") 
public abstract class Pessoa implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_PESSOA")
	private int id;
	
	@Column(length=255, nullable=false)
	private String nome;
	
	@Column(length=255, nullable=true, unique=true )
	private String email;
	
	@Column(length=255, nullable=true)
	private String senha;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATA_NASCIMENTO")
	private Calendar dataNascimento = new GregorianCalendar();
	
	@Column(length=20, nullable=true)
	private String cpf;
	
	@Column(length=20, nullable=true)
	private String rg;
	
	@OneToOne
	@JoinColumn(name="ENDERECO_ID", nullable=true)
	private Endereco endereco;
	
	@ManyToMany
	@JoinTable(name="ACAD_PESSOA_TELEFONE", 
				joinColumns={@JoinColumn(name="PESSOA_ID")},
				inverseJoinColumns={@JoinColumn(name="TELEFONE_ID")})
	private Set<Telefone> telefones = new HashSet<Telefone>();
	
	public Pessoa() {
		
	}
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Set<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(Set<Telefone> telefones) {
		this.telefones = telefones;
	}
}
