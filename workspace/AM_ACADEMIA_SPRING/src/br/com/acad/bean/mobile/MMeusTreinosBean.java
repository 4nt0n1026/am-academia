package br.com.acad.bean.mobile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.acad.dao.treino.interf.DiaTreinoDAO;
import br.com.acad.dao.treino.interf.ExercicioTreinoDAO;
import br.com.acad.dao.treino.interf.TreinoDAO;
import br.com.acad.model.pessoa.Aluno;
import br.com.acad.model.treino.DiaTreino;
import br.com.acad.model.treino.ExercicioTreino;
import br.com.acad.model.treino.Treino;

@SuppressWarnings("serial")
@Component(value = "mMeusTreinosBean")
@Scope(value = "view")
public class MMeusTreinosBean implements Serializable
{

    /************************************************************************************************************/
    // ATRIBUTOS
    /************************************************************************************************************/
    @Autowired
    private TreinoDAO treinoDAO;
    @Autowired
    DiaTreinoDAO diaTreinoDAO;
    @Autowired
    ExercicioTreinoDAO exercicioTreinoDAO;

    private List<Treino> meusTreinos;
    private List<DiaTreino> diasTreino;
    private List<ExercicioTreino> exerciciosTreino;

    private Treino treino;
    private DiaTreino diaTreino;

    private Aluno aluno;

    /************************************************************************************************************/
    // METODOS
    /************************************************************************************************************/
    public String init()
    {
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        aluno = (Aluno) sessionMap.get("aluno");
        meusTreinos = new ArrayList<Treino>();
        meusTreinos = treinoDAO.buscarPorAluno(aluno);
        return "pm:meusTreinos";
    }

    public String onSelectTreino()
    {
        diasTreino = diaTreinoDAO.buscaPorTreino(treino);
        return "pm:diasTreino";
    }

    public String onSelectDiaTreino()
    {
        exerciciosTreino = exercicioTreinoDAO.buscarPorDiaTreino(diaTreino);
        return "pm:exerciciosTreino";
    }

    /************************************************************************************************************/
    // GETs e SETs
    /************************************************************************************************************/

    public List<Treino> getMeusTreinos()
    {
        return meusTreinos;
    }

    public void setMeusTreinos(List<Treino> meusTreinos)
    {
        this.meusTreinos = meusTreinos;
    }

    public Treino getTreino()
    {
        return treino;
    }

    public void setTreino(Treino treino)
    {
        this.treino = treino;
    }

    public List<DiaTreino> getDiasTreino()
    {
        return diasTreino;
    }

    public void setDiasTreino(List<DiaTreino> diasTreino)
    {
        this.diasTreino = diasTreino;
    }

    public DiaTreino getDiaTreino()
    {
        return diaTreino;
    }

    public void setDiaTreino(DiaTreino diaTreino)
    {
        this.diaTreino = diaTreino;
    }

    public List<ExercicioTreino> getExerciciosTreino()
    {
        return exerciciosTreino;
    }

    public void setExerciciosTreino(List<ExercicioTreino> exerciciosTreino)
    {
        this.exerciciosTreino = exerciciosTreino;
    }

}
