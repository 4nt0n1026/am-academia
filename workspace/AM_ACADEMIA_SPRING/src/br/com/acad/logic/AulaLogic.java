package br.com.acad.logic;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.acad.dao.horario.interf.HorarioAulaDAO;
import br.com.acad.model.horario.Aula;
import br.com.acad.model.horario.HorarioAula;

public class AulaLogic
{

    /**
     * Percorre todas os horarios de uma determinada aula e retorna uma String para exibição na tela
     * 
     * @param aula
     * @param horarioAulaDAO
     * @return string dos horarios
     */
    public static String getHorarios(Aula aula, HorarioAulaDAO horarioAulaDAO)
    {
        SimpleDateFormat df = new SimpleDateFormat("hh:mm");
        List<HorarioAula> horarios = horarioAulaDAO.buscarPorAula(aula);

        // Mapa de separacao de horarios por unidade
        Map<String, String> unidadeHorario = new HashMap<String, String>();

        // Percorre todos horarios para fazer separacao
        for (HorarioAula horario : horarios)
        {
            String strHorario = new String();
            if (unidadeHorario.get(horario.getUnidade().getNome()) == null)
            {
                unidadeHorario.put(horario.getUnidade().getNome(), "<h3>" + horario.getUnidade().getNome() + "</h3>");
            }
            strHorario = unidadeHorario.get(horario.getUnidade().getNome());
            strHorario += horario.getDiasSemana() + " - " + df.format(horario.getHora().getTime()) + "(" + horario.getProfessor().getNome()
                    + ")<br/>";
            unidadeHorario.put(horario.getUnidade().getNome(), strHorario);
        }

        StringBuilder strFinal = new StringBuilder();
        // Cria String a partir da separacao
        for (String unidade : unidadeHorario.keySet())
        {
            strFinal.append(unidadeHorario.get(unidade));
        }

        return strFinal.toString();
    }

}
