package br.com.acad.entity.treino;

import java.io.Serializable;

public class Treino implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nome;
	private String descricao;
	private String data;
	private String professor;
	
	private DiasSemanaCat diasSemanaCat;
	private DuracaoTreinoCat duracaoTreinoCat;
	private FaixaEtariaCat faixaEtariaCat;
	private ObjetivoCat objetivoCat;
	private SexoCat sexoCat;
	
	public Treino(String nome, String data){
		this.nome = nome;
		this.data = data;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}
	
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public DiasSemanaCat getDiasSemanaCat() {
		return diasSemanaCat;
	}
	public void setDiasSemanaCat(DiasSemanaCat diasSemanaCat) {
		this.diasSemanaCat = diasSemanaCat;
	}
	public DuracaoTreinoCat getDuracaoTreinoCat() {
		return duracaoTreinoCat;
	}
	public void setDuracaoTreinoCat(DuracaoTreinoCat duracaoTreinoCat) {
		this.duracaoTreinoCat = duracaoTreinoCat;
	}
	public FaixaEtariaCat getFaixaEtariaCat() {
		return faixaEtariaCat;
	}
	public void setFaixaEtariaCat(FaixaEtariaCat faixaEtariaCat) {
		this.faixaEtariaCat = faixaEtariaCat;
	}
	public ObjetivoCat getObjetivoCat() {
		return objetivoCat;
	}
	public void setObjetivoCat(ObjetivoCat objetivoCat) {
		this.objetivoCat = objetivoCat;
	}
	public SexoCat getSexoCat() {
		return sexoCat;
	}
	public void setSexoCat(SexoCat sexoCat) {
		this.sexoCat = sexoCat;
	}

	
}
