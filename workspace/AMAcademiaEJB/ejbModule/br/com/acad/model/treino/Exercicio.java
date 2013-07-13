package br.com.acad.model.treino;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import br.com.acad.dao.treino.interf.ParteCorpoDAO;




@SuppressWarnings("serial")
@Entity
@SequenceGenerator(name="seqExercicio", sequenceName="SEQ_EXERCICIO", allocationSize=1)
@Table(name="ACAD_EXERCICIO")
public class Exercicio implements Serializable {
	
	
	public static final String[] STATIC_FIELDS = {"nome"};

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
	
	@ManyToMany()
	@JoinTable(name="ACAD_EXERC_CORPO_PRIMARIO", 
				joinColumns={@JoinColumn(name="EXERCICIO_ID")},
				inverseJoinColumns={@JoinColumn(name="PARTE_CORPO_ID")})
	private Set<ParteCorpo> parteCorpoPrimaria = new HashSet<ParteCorpo>();
	
	@ManyToMany()
	@JoinTable(name="ACAD_EXERC_CORPO_SECUNDARIO", 
				joinColumns={@JoinColumn(name="EXERCICIO_ID")},
				inverseJoinColumns={@JoinColumn(name="PARTE_CORPO_ID")})
	private Set<ParteCorpo> parteCorpoSecundaria = new HashSet<ParteCorpo>();
	
	
	//metodos
	/**
	 * Apaga listas de partes de corpo Primarias e Secundarias
	 */
	public void zeraPartesCorpos(){
		this.zeraParteCorpoPrimaria();
		this.zeraParteCorpoSecundaria();
	}
	
	/**
	 * Apaga lista de ParteCorpoPrimaria
	 */
	public void zeraParteCorpoPrimaria(){
		this.parteCorpoPrimaria = new HashSet<ParteCorpo>();
	}
	
	/**
	 * Apaga lista de ParteCorpoSecundaria
	 */
	public void zeraParteCorpoSecundaria(){
		this.parteCorpoSecundaria = new HashSet<ParteCorpo>();
	}
	
	/**
	 * Inclui ParteCorpo para lista de parteCorpoPrimaria
	 * @param parte
	 * @return booleano se incluiu ou nao
	 */
	public boolean addParteCorpoPrimaria(ParteCorpo parte){
		return this.parteCorpoPrimaria.add(parte);
	}
	
	/**
	 * Inclui ParteCorpo para lista de parteCorpoSecundaria
	 * @param parte
	 * @return booleano se incluiu ou nao
	 */
	public boolean addParteCorpoSecundaria(ParteCorpo parte){
		return this.parteCorpoSecundaria.add(parte);
	}
	
	/**
	 * remove ParteCorpo para lista de parteCorpoPrimaria
	 * @param parte
	 * @return booleano se removeu ou nao
	 */
	public boolean removeParteCorpoPrimaria(ParteCorpo parte){
		return this.parteCorpoPrimaria.remove(parte);
	}
	
	/**
	 * remove ParteCorpo para lista de parteCorpoSecundaria
	 * @param parte
	 * @return booleano se removeu ou nao
	 */
	public boolean removeParteCorpoSecundaria(ParteCorpo parte){
		return this.parteCorpoSecundaria.remove(parte);
	}
	
	//Gets com DAO
	public List<ParteCorpo> getParteCorpoPrimaria(ParteCorpoDAO dao){
		return dao.buscarPartesPrimarias(this);
	}
	
	public List<ParteCorpo> getParteCorpoSecundaria(ParteCorpoDAO dao){
		return dao.buscarPartesSecundaria(this);
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

	public Set<ParteCorpo> getParteCorpoPrimaria() {
		return parteCorpoPrimaria;
	}

	public void setParteCorpoPrimaria(Set<ParteCorpo> parteCorpoPrimaria) {
		this.parteCorpoPrimaria = parteCorpoPrimaria;
	}

	public Set<ParteCorpo> getParteCorpoSecundaria() {
		return parteCorpoSecundaria;
	}

	public void setParteCorpoSecundaria(Set<ParteCorpo> parteCorpoSecundaria) {
		this.parteCorpoSecundaria = parteCorpoSecundaria;
	}

	
	//ToString
	@Override
	public String toString() {
		return id + "";
	}

	
	
	

	
	
	
	
}
