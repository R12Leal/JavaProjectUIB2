/*
 *
 */
package Prisoner;

import java.io.Serializable;
import java.util.Date;

/**
 * Classe per emmagatzemar les puntuacions de cada presoner.
 *
 * @since 2.0
 * @author Ramses - RLL862
 */
public class Puntuacions implements Serializable, Comparable {

    private Prisoner p;
    private int punts;
    private Date data;

    /**
     * Constructor classe Puntuacions.
     *
     * @param p Objecte Prisoner (presoner)
     */
    public Puntuacions(Prisoner p, Date data) {
        this.p = p;
        this.data = data;
        this.punts = 0;
    }

    // Getters - Setters
    /**
     * Retorna el presoner de les puntuacions.
     *
     * @return Objecte Prisoner (presoner).
     */
    public Prisoner getPresoner() {
        return p;
    }

    public Date getData() {
        return data;
    }
    
    /**
     * Suma els punts, indicats per paràmetre, a la puntuació del presoner.
     *
     * @param punts (punts per sumar a la puntuació del presoner).
     */
    public void setPunts(int punts) {
        this.punts += punts;
    }

    /**
     * Retorna els punts totals del presoner.
     *
     * @return punts (punts totals del presoner).
     */
    public int getPunts() {
        return punts;
    }

    @Override
    public int compareTo(Object o) {

        Puntuacions points = (Puntuacions) o;
        return (this.punts < points.punts) ? -1 : (this.punts > points.punts) ? 1 : 0;

    }

}
