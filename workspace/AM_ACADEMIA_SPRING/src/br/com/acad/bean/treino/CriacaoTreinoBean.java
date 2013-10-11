package br.com.acad.bean.treino;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.acad.dao.treino.interf.ExercicioDAO;
import br.com.acad.dao.treino.interf.ExercicioTreinoDAO;
import br.com.acad.dao.treino.interf.TreinoEspecificoDAO;
import br.com.acad.dao.treino.interf.TreinoFixoDAO;
import br.com.acad.logic.MessagesLogic;
import br.com.acad.logic.TreinoLogic;
import br.com.acad.model.cat.TipoTreinoDieta;
import br.com.acad.model.treino.DiaTreino;
import br.com.acad.model.treino.Exercicio;
import br.com.acad.model.treino.ExercicioTreino;
import br.com.acad.model.treino.Serie;
import br.com.acad.model.treino.Treino;
import br.com.acad.model.treino.TreinoEspecifico;
import br.com.acad.model.treino.TreinoFixo;

@SuppressWarnings("serial")
@Component
@Scope(value = "view")
public class CriacaoTreinoBean implements Serializable
{

    /************************************************************************************************************/
    // ATRIBUTOS
    /************************************************************************************************************/

    @Autowired
    private TreinoFixoDAO treinoFixoDAO;
    @Autowired
    private TreinoEspecificoDAO treinoEspecificoDAO;
    @Autowired
    private ExercicioDAO exercicioDAO;
    @Autowired
    private ExercicioTreinoDAO exercicioTreinoDAO;

    // Inject outros beans
    // @ManagedProperty(value="#{treinoFixoBean}")
    @Autowired
    private TreinoFixoBean treinoFixoBean;
    // @ManagedProperty(value="#{treinoEspecificoBean}")
    @Autowired
    private TreinoEspecificoBean treinoEspecificoBean;
    // @ManagedProperty(value="#{solicitacaoTreinoBean}")
    @Autowired
    private SolicitacaoTreinoBean solicitacaoTreinoBean;

    private Treino treino;

    private DiaTreino diaTreino;
    private List<DiaTreino> dias;

    private boolean showExercicioTreino;
    private ExercicioTreino exercicioTreino;
    private List<ExercicioTreino> exercicios;

    private List<Serie> series = new ArrayList<Serie>();

    /************************************************************************************************************/
    // METODOS
    /************************************************************************************************************/

    @PostConstruct
    public void init()
    {
        showExercicioTreino = false;
        newExercicioTreino();
        dias = new ArrayList<DiaTreino>();
        exercicios = new ArrayList<ExercicioTreino>();
    }

    // Treino -------------------------------------------------------------------------------------------------------
    /**
     * Criacao de um novo treino fixo
     */
    public void newTreinoFixo()
    {
        treino = treinoFixoBean.getEntity();
        treino.setTipoTreino(TipoTreinoDieta.FIXO);
        dias = TreinoLogic.setToList(treino.getDiasTreino());
        diaTreino = new DiaTreino();
    }

    /**
     * Criacao de um novo treino especifico
     */
    public void newTreinoEspecifico()
    {
        treino = treinoEspecificoBean.getEntity();
        treino.setTipoTreino(TipoTreinoDieta.ESPECIFICO);
        dias = TreinoLogic.setToList(treino.getDiasTreino());
        diaTreino = new DiaTreino();
    }

    /**
     * Criacao de um novo treino especifico de resposta
     */
    public void newTreinoEspecificoResposta()
    {
        treino = solicitacaoTreinoBean.getTreino();
        treino.setTipoTreino(TipoTreinoDieta.ESPECIFICO);
        dias = TreinoLogic.setToList(treino.getDiasTreino());
        diaTreino = new DiaTreino();
    }

    /**
     * Salva os dias e os exercicios do treino fixo
     */
    public void salvarTreinoFixo()
    {
        organizaListasTreino();
        treinoFixoBean.setEntity((TreinoFixo) treino);
        treinoFixoBean.beforeSaveEntity();
    }

    /**
     * Salva os dias e os exercicios do treino especifico
     */
    public void salvarTreinoEspecifico()
    {
        organizaListasTreino();
        treinoEspecificoBean.setEntity((TreinoEspecifico) treino);
        treinoEspecificoBean.beforeSaveEntity();
    }

    /**
     * Salva os dias e os exercicios do treino de resposta
     */
    public void salvarTreinoEspecificoResposta()
    {
        organizaListasTreino();
        solicitacaoTreinoBean.setTreino((TreinoEspecifico) treino);
        solicitacaoTreinoBean.incluirTreinoResposta();
        ;
    }

    private void organizaListasTreino()
    {
        treino.resetDiasTreino();
        for (DiaTreino dia : dias)
        {
            dia.setOrdem(dias.indexOf(dia));
            treino.addDiaTreino(dia);
        }
    }

    // DiaTreino -------------------------------------------------------------------------------------------------------
    /**
     * Abre form de um novo DiaTreino
     */
    public void newDiaTreino()
    {
        diaTreino = new DiaTreino();
        showExercicioTreino = false;
    }

    /**
     * Inclui um DiaTreino a lista de dias
     */
    public void incluirDiaTreino()
    {
        showExercicioTreino = false;
        if (!dias.contains(diaTreino))
        {
            dias.add(diaTreino);
        }
        diaTreino = new DiaTreino();
    }

    /**
     * Exclui diaTreino da lista de dias
     */
    public void excluirDiaTreino()
    {
        if (diaTreino != null && diaTreino.getNome().length() > 1)
        {
            dias.remove(diaTreino);
        }
        else
        {
            MessagesLogic.addWarnMessage("Aviso", "Selecione um dia de treino antes de excluir");
        }
        showExercicioTreino = false;
        diaTreino = new DiaTreino();
    }

    /**
     * ao selecionar diaTreino da lista
     */
    public void onSelectDiaTreino()
    {
        showExercicioTreino = true;
        refreshExercicioTreino();
        newExercicioTreino();
    }

    /**
     * ao desselecionar diaTreino da lista
     */
    public void onUnselectDiaTreino()
    {
        showExercicioTreino = false;
    }

    // ExercicioTreino
    // -------------------------------------------------------------------------------------------------------
    /**
     * Abre form de um novo exercicioTreino
     */
    public void newExercicioTreino()
    {
        exercicioTreino = new ExercicioTreino();
        series = new ArrayList<Serie>();
    }

    /**
     * Atualiza os exercicios ao clicar em um diaTreino
     */
    public void refreshExercicioTreino()
    {
        exercicios = new ArrayList<ExercicioTreino>(diaTreino.getExerciciosTreino());
    }

    /**
     * Inclui um ExercicioTreino a lista de exercicios
     */
    public void incluirExercicioTreino()
    {
        if (exercicios.contains(exercicioTreino))
        {
            exercicios.remove(exercicioTreino);
            diaTreino.removeExercicioTreino(exercicioTreino);
        }
        exercicioTreino.setSeries(new HashSet<Serie>(series));
        exercicioTreino.setExercicio(exercicioDAO.searchById(exercicioTreino.getExercicio().getId()));
        diaTreino.addExercicioTreino(exercicioTreino);
        exercicios.add(exercicioTreino);
        newExercicioTreino();
    }

    /**
     * Exclui ExercicioTreino da lista de exercicios
     */
    public void excluirExercicioTreino()
    {
        if (exercicioTreino != null && exercicioTreino.getExercicio() != null)
        {
            exercicios.remove(exercicioTreino);
            diaTreino.removeExercicioTreino(exercicioTreino);
        }
        else
        {
            MessagesLogic.addWarnMessage("Aviso", "Selecione um exercicio antes de excluir");
        }
        exercicioTreino = new ExercicioTreino();

    }

    /**
     * ao selecionar exercicioTreino da lista
     */
    public void onSelectExercicioTreino()
    {
        series = TreinoLogic.setToListSerie(exercicioTreino.getSeries());
    }

    /**
     * ao selecionar exercicioTreino da lista
     */
    public void onUnselectExercicioTreino()
    {
    }

    // Series --------------------------------------------------------------------------------------------------------

    /**
     * Adciona um serie
     */
    public void addSerie()
    {
        Serie serie = new Serie();
        serie.setOrdem(series.size());
        series.add(serie);
    }

    /**
     * Reseta a lista de series
     */
    public void resetSeries()
    {
        series = new ArrayList<Serie>();
    }

    // Ordem treino
    // -------------------------------------------------------------------------------------------------------

    /**
     * desce uma posicao na lista de ordem de dias
     */
    public void sobeDiaTreino()
    {
        // Verifica se o diaTreino esta selecionado
        if (diaTreino == null || diaTreino.getNome() == null)
        {
            MessagesLogic.addErrorMessage("Erro", "Selecione um dia para alterar a ordem");
            return;
        }
        int posicaoAtual = dias.indexOf(diaTreino);
        int posicaoFutura = posicaoAtual - 1;
        // Busca na lista o diaTreino com uma unidade a mais do que a selecionada
        if (dias.indexOf(diaTreino) == 0)
        {
            MessagesLogic.addErrorMessage("Erro", "Esse dia já se encontra na primeira posicao");
            return;
        }
        DiaTreino diaTemp = dias.get(posicaoFutura);
        dias.set(posicaoFutura, diaTreino);
        dias.set(posicaoAtual, diaTemp);
    }

    /**
     * Sobe uma posicao na lista de ordem de dias
     */
    public void desceDiaTreino()
    {
        // Verifica se o diaTreino esta selecionado
        if (diaTreino == null || diaTreino.getNome() == null)
        {
            MessagesLogic.addErrorMessage("Erro", "Selecione um dia para alterar a ordem");
            return;
        }
        int posicaoAtual = dias.indexOf(diaTreino);
        int posicaoFutura = posicaoAtual + 1;
        // Busca na lista o diaTreino com uma unidade a mais do que a selecionada
        if (dias.size() == posicaoFutura)
        {
            MessagesLogic.addErrorMessage("Erro", "Esse dia já se encontra na ultima posicao");
            return;
        }
        DiaTreino diaTemp = dias.get(posicaoFutura);
        dias.set(posicaoFutura, diaTreino);
        dias.set(posicaoAtual, diaTemp);
    }

    /**
     * desce uma posicao na lista de ordem de exercicios
     */
    public void sobeExercicioTreino()
    {
        // Verifica se o exercicioTreino esta selecionado
        if (exercicioTreino == null || exercicioTreino.getExercicio() == null)
        {
            MessagesLogic.addErrorMessage("Erro", "Selecione um exercicio para alterar a ordem");
            return;
        }
        int posicaoAtual = exercicios.indexOf(exercicioTreino);
        int posicaoFutura = posicaoAtual - 1;
        // Busca na lista o exercicioTreino com uma unidade a mais do que a selecionada
        if (exercicios.indexOf(exercicioTreino) == 0)
        {
            MessagesLogic.addErrorMessage("Erro", "Esse exercicio já se encontra na primeira posicao");
            return;
        }
        ExercicioTreino exercicioTemp = exercicios.get(posicaoFutura);
        exercicios.set(posicaoFutura, exercicioTreino);
        exercicios.set(posicaoAtual, exercicioTemp);
        ;
    }

    /**
     * Sobe uma posicao na lista de ordem de exercicios
     */
    public void desceExercicioTreino()
    {
        // Verifica se o exercicioTreino esta selecionado
        if (exercicioTreino == null || exercicioTreino.getExercicio() == null)
        {
            MessagesLogic.addErrorMessage("Erro", "Selecione um exercicio para alterar a ordem");
            return;
        }
        int posicaoAtual = exercicios.indexOf(exercicioTreino);
        int posicaoFutura = posicaoAtual + 1;
        // Busca na lista o exercicioTreino com uma unidade a mais do que a selecionada
        if (exercicios.size() == posicaoFutura)
        {
            MessagesLogic.addErrorMessage("Erro", "Esse exercicio já se encontra na ultima posicao");
            return;
        }
        ExercicioTreino exercicioTemp = exercicios.get(posicaoFutura);
        exercicios.set(posicaoFutura, exercicioTreino);
        exercicios.set(posicaoAtual, exercicioTemp);
    }

    /************************************************************************************************************/
    // GET FIELDS
    /************************************************************************************************************/

    public List<Exercicio> getExerciciosField()
    {
        return exercicioDAO.buscarFieldNome();
    }

    /************************************************************************************************************/
    // GETS E SETS
    /************************************************************************************************************/

    public Treino getTreino()
    {
        return treino;
    }

    public void setTreino(Treino treino)
    {
        this.treino = treino;
    }

    public DiaTreino getDiaTreino()
    {
        return diaTreino;
    }

    public void setDiaTreino(DiaTreino diaTreino)
    {
        this.diaTreino = diaTreino;
    }

    public ExercicioTreino getExercicioTreino()
    {
        return exercicioTreino;
    }

    public void setExercicioTreino(ExercicioTreino exercicioTreino)
    {
        this.exercicioTreino = exercicioTreino;
    }

    public List<DiaTreino> getDias()
    {
        return dias;
    }

    public List<ExercicioTreino> getExercicios()
    {
        return exercicios;
    }

    public TreinoFixoBean getTreinoFixoBean()
    {
        return treinoFixoBean;
    }

    public void setTreinoFixoBean(TreinoFixoBean treinoFixoBean)
    {
        this.treinoFixoBean = treinoFixoBean;
    }

    public TreinoEspecificoBean getTreinoEspecificoBean()
    {
        return treinoEspecificoBean;
    }

    public void setTreinoEspecificoBean(TreinoEspecificoBean treinoEspecificoBean)
    {
        this.treinoEspecificoBean = treinoEspecificoBean;
    }

    public boolean getShowExercicioTreino()
    {
        return showExercicioTreino;
    }

    public List<Serie> getSeries()
    {
        return series;
    }

    public void setSeries(List<Serie> series)
    {
        this.series = series;
    }

    public SolicitacaoTreinoBean getSolicitacaoTreinoBean()
    {
        return solicitacaoTreinoBean;
    }

    public void setSolicitacaoTreinoBean(SolicitacaoTreinoBean solicitacaoTreinoBean)
    {
        this.solicitacaoTreinoBean = solicitacaoTreinoBean;
    }

}
