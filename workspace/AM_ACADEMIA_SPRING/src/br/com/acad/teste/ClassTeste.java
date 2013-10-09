package br.com.acad.teste;

import br.com.acad.annotation.Show;
import br.com.acad.annotation.View;

@View(labels = { "Todos Registro", "Respondidos" }, queries = { "", "where respondido=true" })
public class ClassTeste
{
    @Show(order = true, label = "Nome da teste")
    private String nome;

    private int idade;

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public int getIdade()
    {
        return idade;
    }

    public void setIdade(int idade)
    {
        this.idade = idade;
    }

}
