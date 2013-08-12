package br.com.acad.model.dieta;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.acad.model.pessoa.Aluno;

@SuppressWarnings("serial")
@Entity
@SequenceGenerator(name="seqSolicitacaoDieta", sequenceName="SEQ_SOLICITACAO_DIETA", allocationSize=1)
@Table(name="ACAD_SOLICITACAO_DIETA")
public class SolicitacaoDieta implements Serializable {

	public static final String[] STATIC_FIELDS = {"dataSolicitacao", "aluno.nome", "descricao" };
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqSolicitacaoDieta")
	@Column(name="ID_SOLICITACAO_DIETA")
	private int id;
	
	@Column(length=500, nullable=false)
	private String descricao;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATA_SOLICITACAO", nullable=false)
	private Calendar dataSolicitacao;
	
	@Column(nullable=false)
	private boolean respondido;
	
	@ManyToOne
	@JoinColumn(name="ALUNO_ID", nullable=false)
	private Aluno aluno;
	
	public SolicitacaoDieta(){}

	public SolicitacaoDieta(Integer id, Calendar data) {
		this.id = id;
		this.dataSolicitacao = data;
	}

	public int getId() {
		return id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Calendar dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public boolean isRespondido() {
		return respondido;
	}

	public void setRespondido(boolean respondido) {
		this.respondido = respondido;
	}
	
	
	
	
	
}
