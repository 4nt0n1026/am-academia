package br.com.acad.model.pessoa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import br.com.acad.annotation.Show;
import br.com.acad.annotation.View;
import br.com.acad.logic.model.FieldType;

@SuppressWarnings("serial")
@Entity
@Table(name = "ACAD_PESSOA_PROFESSOR_FUNC")
@PrimaryKeyJoinColumn(name = "ID_PESSOA_PROFESSOR_FUNC")
@View(labels = { "Todos Registros", "Professores", "Funcionarios" }, queries = { "", "isProfessor=true", "isProfessor=false" })
public class ProfessorFunc extends Pessoa
{

    @Column(length = 500, nullable = true)
    private String fotoLocal;

    @Column(length = 500, nullable = true)
    private String formacao;

    @Column(nullable = false)
    @Show(label = "Professor", order = true, Type = FieldType.BOOLEAN)
    private boolean isProfessor;

    public ProfessorFunc()
    {
    }

    // Construtor para busca como field
    public ProfessorFunc(Integer id, String nome)
    {
        this.setId(id);
        this.setNome(nome);
    }

    public boolean getIsProfessor()
    {
        return isProfessor;
    }

    public void setIsProfessor(boolean isProfessor)
    {
        this.isProfessor = isProfessor;
    }

    public String getFotoLocal()
    {
        return fotoLocal;
    }

    public void setFotoLocal(String fotoLocal)
    {
        this.fotoLocal = fotoLocal;
    }

    public String getFormacao()
    {
        return formacao;
    }

    public void setFormacao(String formacao)
    {
        this.formacao = formacao;
    }
}
