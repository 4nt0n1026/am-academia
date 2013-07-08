package br.com.acad.model.dieta;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("serial")
@Entity
@SequenceGenerator(name="seqDiaDieta", sequenceName="SEQ_DIA_DIETA", allocationSize=1)
@Table(name="ACAD_DIA_DIETA")
public class DiaDieta implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqDiaDieta")
	@Column(name="ID_DIA_DIETA")
	private int id;
	
	@Column(length=255, nullable=false)
	private String nome;
	
	@OneToMany
	@JoinColumn(name="DIA_DIETA_ID")
	private Set<Refeicao> refeicoes = new HashSet<Refeicao>();
	
	public DiaDieta(){}

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

	public Set<Refeicao> getRefeicoes() {
		return refeicoes;
	}

	public void setRefeicoes(Set<Refeicao> refeicoes) {
		this.refeicoes = refeicoes;
	}
	
	
	
}
