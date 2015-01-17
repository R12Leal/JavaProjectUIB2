/*
 *
 */
package Prisoner;

import Prisoner.Prisoner.Action;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

/**
 * Classe per a la gestió d'enfrontaments entre presoners.
 * @since 2.0
 * @author Ramses - RLL862
 */
public class Enfrontaments {

    private boolean eFNF;
    private Prisoner[] presoners;
    private Puntuacions[] puntuacions;
    private final String parametres_arxiu;
    private final int[] parametres;

    /**
     * Constructor Enfrontaments
     *
     * @param presoners Conjunts de dades (Array) amb els presoners.
     * @param parametres_arxiu (String) nom d'arxiu.
     */
    public Enfrontaments(Prisoner[] presoners, String parametres_arxiu) {

        this.parametres_arxiu = parametres_arxiu;
        this.parametres = new int[3];
        this.presoners = presoners;
        this.puntuacions = new Puntuacions[this.presoners.length];
        this.eFNF = true;
        iniPunts();
        
    }

    // Mètodes privats
    /**
     * Obtenció de paràmetres del joc mitjançant un arxiu de text.
     *
     * @param parametres String - Nom d'arxiu.
     */
    private void obtenirParametres(String parametres) {
        try {
            FileInputStream file = new FileInputStream(parametres);
            BufferedReader in = new BufferedReader(new InputStreamReader(file));

            for (int i = 0; i < this.parametres.length; i++) {
                this.parametres[i] = Integer.parseInt(in.readLine());
            }
            
            in.close();
        } catch (FileNotFoundException exFNF) {
            System.out.println("No existeix fitxer amb paràmetres, enfrontaments abortat.");
            eFNF = false;
        } catch (IOException ex) {
            ex.getMessage();
        }

    }

    /**
     * S'encarrega d'iniciar les puntuacions dels presoners.
     */
    private void iniPunts() {

        for (int i = 0; i < puntuacions.length; i++) {
            puntuacions[i] = new Puntuacions(presoners[i],new Date());
        }

    }

    /**
     * Enfrontament presoner vs presoner (forma individual).
     *
     * @param p1 (Prisoner) Objecte Prisoner
     * @param p2 (Prisoner) Objecte Prisoner
     */
    private void iniRonda(Prisoner p1, Prisoner p2) {
        // Paràmetres.
        int repeticions = parametres[0];
        int cooperacio = parametres[2];
        int traidor = parametres[1];
        Action p1_decision;
        Action p2_decision;

        // Indicam als presoners que s'enfronten a un nou oponent.
        p1.setNewOpponent();
        p2.setNewOpponent();

        // Enfrontament de presoners.
        for (int i = 0; i < repeticions; i++) {

            // Guardem decisions.
            p1_decision = p1.decision();
            p2_decision = p2.decision();

            if ((p1_decision == Action.cooperate) && (p2_decision == Action.cooperate)) {

                // System.out.println(p1.getPrisonerName() + " y " + p2.getPrisonerName() + " cooperan");
                puntuacions[trobarPresoner(p1)].setPunts(cooperacio);
                puntuacions[trobarPresoner(p2)].setPunts(cooperacio);

            } else if ((p1_decision == Action.betray) && (p2_decision == Action.cooperate)) {

                // System.out.println(p1.getPrisonerName() + " traiciona a " + p2.getPrisonerName());
                puntuacions[trobarPresoner(p1)].setPunts(traidor);

            } else if ((p1_decision == Action.cooperate) && (p2_decision == Action.betray)) {

                // System.out.println(p1.getPrisonerName() + " es traicionado por " + p2.getPrisonerName());
                puntuacions[trobarPresoner(p2)].setPunts(traidor);

            } else {

                // System.out.println(p1.getPrisonerName() + " y " + p2.getPrisonerName() + " se traicionan mutuamente");
            }

            p1.setOpponentDecision(p2_decision);
            p2.setOpponentDecision(p1_decision);

        }

    }

    /**
     * S'encarrega de trobar el presoner corresponent en array puntuacions.
     *
     * @param p1 (Prisoner) Objecte Prisoner.
     * @return posició del presoner en Puntuacions.
     */
    private int trobarPresoner(Prisoner p1) {

        boolean found = false;
        int posicio = 0;

        for (int i = 0; i < puntuacions.length && !found; i++) {
            if (p1.equals(puntuacions[i].getPresoner())) {
                found = true;
            }
            posicio = i;
        }

        return posicio;

    }

    // Mètodes publics
    /**
     * Inicia els enfrontaments entre tots els presoners.
     */
    public void iniciarJoc() {
        try {
            if (presoners.length <= 1) {
                throw new numPresoners("Mínim han de jugar 2 presoners.");
            } else {
                obtenirParametres(parametres_arxiu);
                int num_presoners = 0;
                Prisoner p1;
                Prisoner p2;

                for (int i = 0; i < presoners.length; i++) {
                    p1 = presoners[i];
                    num_presoners++;
                    for (int x = num_presoners; x < presoners.length; x++) {
                        p2 = presoners[x];
                        iniRonda(p1, p2);
                    }
                }
            }
        } catch (numPresoners numP) {
            System.out.println(numP.getMessage());
        }

    }

    /**
     * Mostra la classificació final dels presoners de forma ordenada.
     */
    public void classificacio() {
        if (!(presoners.length <= 1) && eFNF) {
            int posicio = 1;

            Arrays.sort(puntuacions, Collections.reverseOrder());

            int repeticions = parametres[0];
            int cooperacio = parametres[2];
            int traidor = parametres[1];

            System.out.println("====================================");
            System.out.println("PARÀMETRES");
            System.out.println("====================================");
            System.out.println("Iteracions: " + repeticions);
            System.out.println("Puntuació per cooperació mutua: " + cooperacio);
            System.out.println("Puntuació per traïció: " + traidor);
            System.out.println("====================================");

            for (int i = 0; i < puntuacions.length; i++) {
                System.out.println(posicio + "#  " + puntuacions[i].getPresoner().getPrisonerName() + " - " + puntuacions[i].getPunts());
                posicio++;
            }

            System.out.println("====================================");
        }
    }

    // Excepcions
    private static class numPresoners extends Exception {

        public numPresoners(String msg) {
            super(msg);
        }
    }

}
