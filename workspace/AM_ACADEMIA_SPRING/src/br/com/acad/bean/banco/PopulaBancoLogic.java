package br.com.acad.bean.banco;

import java.util.HashSet;
import java.util.Set;

import br.com.acad.model.treino.ParteCorpo;

public abstract class PopulaBancoLogic
{

    public static final int BICEPS = 1;
    public static final int TRICEPS = 2;
    public static final int COSTAS = 3;
    public static final int LOMBAR = 4;
    public static final int PEITO = 5;
    public static final int PANTURRILHA = 6;
    public static final int COXAS = 7;
    public static final int GLUTEOS = 8;
    public static final int ABDOMEN = 9;
    public static final int ANTEBRACO = 10;
    public static final int TRAPEZIO = 11;
    public static final int OMBRO = 12;

    public static Set<ParteCorpo> getPartesCorpo(int... n)
    {
        Set<ParteCorpo> partes = new HashSet<ParteCorpo>();
        for (int i : n)
        {
            partes.add(new ParteCorpo(i));
        }
        return partes;
    }

}
