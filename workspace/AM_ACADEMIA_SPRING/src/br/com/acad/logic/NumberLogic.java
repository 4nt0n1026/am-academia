package br.com.acad.logic;

import java.util.Random;

public class NumberLogic
{

    /**
     * gera numero aleatorio passando a 1a e ultima posicao
     * 
     * @param start
     * @param aEnendd
     */
    public static int randomInteger(long start, long aEnendd)
    {
        Random aRandom = new Random();
        if (start > aEnendd)
        {
            throw new IllegalArgumentException("Start cannot exceed End.");
        }
        // get the range, casting to long to avoid overflow problems
        long range = (long) aEnendd - (long) start + 1;
        // compute a fraction of the range, 0 <= frac < range
        long fraction = (long) (range * aRandom.nextDouble());

        return (int) (fraction + start);
    }

    /**
     * gera numero double aleatorio passando a 1 e a ultima posicao
     * 
     * @param start
     * @param end
     * @return
     */
    public static double randomDouble(double start, double end)
    {
        Random r = new Random();
        return arredonda2casas(start + (end - start) * r.nextDouble());

    }

    /**
     * Arredonda um double para duas casas decimais
     * 
     * @param number
     * @return
     */
    public static double arredonda2casas(double number)
    {
        return Math.round(number * 100.0) / 100.0;
    }

}
