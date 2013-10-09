package br.com.acad.logic;

import java.util.ArrayList;
import java.util.List;

import br.com.acad.model.treino.ParteCorpo;

public class ParteCorpoLogic
{

    /**
     * Retorna em List de String os ids de um List de ParteCorpo
     * 
     * @param partes
     * @return
     */
    public static List<String> getIds(List<ParteCorpo> partes)
    {
        List<String> ids = new ArrayList<String>();

        for (ParteCorpo parte : partes)
        {
            ids.add(String.valueOf(parte.getId()));
        }

        return ids;
    }

}
