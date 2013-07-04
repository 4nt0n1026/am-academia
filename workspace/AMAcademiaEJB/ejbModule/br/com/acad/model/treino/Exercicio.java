package br.com.acad.model.treino;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@SequenceGenerator(name="seqExercicio", sequenceName="SEQ_EXERCICIO", allocationSize=1)
@Table(name="ACAD_EXERCICIO")
public class Exercicio implements Serializable {
	
	
	//Atributos
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqExercicio")
	@Column(name="ID_EXERCICIO")
	private int id;
	
	@Column(length=255, nullable=false)
	private String nome;
	
	@Column(length=500, nullable=true)
	private String descricao;
	
	@Column(length=500, nullable=true)
	private String fotoLocal;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="EXERCICIO_CORPO_PRIMARIO", 
				joinColumns={@JoinColumn(name="EXERCICIO_ID")},
				inverseJoinColumns={@JoinColumn(name="PARTE_CORPO_ID")})
	private List<ParteCorpo> parteCorpoPrimaria;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="EXERCICIO_CORPO_SECUNDARIO", 
				joinColumns={@JoinColumn(name="EXERCICIO_ID")},
				inverseJoinColumns={@JoinColumn(name="PARTE_CORPO_ID")})
	private List<ParteCorpo> parteCorpoSecundaria;
	
	
	//metodos
	/**
	 * Inclui um ParteCorpo para lista de parteCorpoPrimaria
	 * @param parte
	 */
	public void addParteCorpoPrimaria(ParteCorpo parte){
		if(this.parteCorpoPrimaria==null){
			this.parteCorpoPrimaria = new ArrayList<ParteCorpo>();
			this.parteCorpoPrimaria.add(parte);
		}else if(!this.parteCorpoPrimaria.contains(parte)){
			this.parteCorpoPrimaria.add(parte);
		}
	}
	
	/**
	 * Inclui um ParteCorpo para lista de parteCorpoSecundaria
	 * @param parte
	 */
	public void addParteCorpoSecundaria(ParteCorpo parte){
		if(this.parteCorpoSecundaria==null){
			this.parteCorpoSecundaria = new ArrayList<ParteCorpo>();
			this.parteCorpoSecundaria.add(parte);
		}else if(!this.parteCorpoSecundaria.contains(parte)){
			this.parteCorpoSecundaria.add(parte);
		}
	}
	
	
	//Construtores
	public Exercicio(){}
	
	public Exercicio(int id, String nome, String descricao, String fotoLocal) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.fotoLocal = fotoLocal;
	}

	
	//gets e sets
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getFotoLocal() {
		return fotoLocal;
	}

	public void setFotoLocal(String fotoLocal) {
		this.fotoLocal = fotoLocal;
	}

	public List<ParteCorpo> getParteCorpoPrimaria() {
		return parteCorpoPrimaria;
	}

	public void setParteCorpoPrimaria(List<ParteCorpo> parteCorpoPrimaria) {
		this.parteCorpoPrimaria = parteCorpoPrimaria;
	}

	public List<ParteCorpo> getParteCorpoSecundaria() {
		return parteCorpoSecundaria;
	}

	public void setParteCorpoSecundaria(List<ParteCorpo> parteCorpoSecundaria) {
		this.parteCorpoSecundaria = parteCorpoSecundaria;
	}

	
	
	

	
	
	
	
}
