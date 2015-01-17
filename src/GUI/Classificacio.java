/*
 *
 */
package GUI;

import Prisoner.Prisoner;
import Prisoner.Puntuacions;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 * Classe per gestionar les classificacions dels jugadors.
 * @since 2.0
 * @author Ramses - RLL862
 */
public class Classificacio {

    private static ArrayList<Puntuacions> ranking = new ArrayList<Puntuacions>();

    /**
     * Constructor Classificació: buit.
     */
    public Classificacio() {}

    /**
     * Mètode per mirar si el arxiu on es troben els objectes està buit.
     * @param arxiu
     * @return Boolean (true / false)
     */
    public static boolean es_buit(String arxiu) {
        File fichero = new File(arxiu);
        return fichero.length() == 0;
    }

    /**
     * Mètode per veure si un jugador-presoner es troba en la classificació.
     * @param p Nom del jugador-presoner
     * @param arxiu Arxiu on es troba la classificació emmagatzemada
     * @return Boolean (true / false)
     */
    public static boolean existeixPresoner(String p, String arxiu) {
        boolean trobat = false;
        if (!es_buit(arxiu)) {
            obtenirPresoner(arxiu);
            for (int i = 0; i < ranking.size() && !trobat; i++) {
                if (ranking.get(i).getPresoner().getPrisonerName().equals(p)) {
                    trobat = true;
                }
            }
            return trobat;
        } else {
            return trobat;
        }
    }

    /**
     * Mètode per afegir el jugador a la classificació.
     * @param name Nom del jugador-presoner
     * @param punts Punts aconseguits per el jugador
     * @param arxiu Arxiu on es troba la classificació emmagatzemada
     */
    public static void nouPresoner(String name, int punts, String arxiu) {
        try {
            FileOutputStream arxiuout = new FileOutputStream(arxiu);
            ObjectOutputStream out = new ObjectOutputStream(arxiuout);
            PrisonerP p = new PrisonerP(name);
            Puntuacions presoner_punts = new Puntuacions(p, new Date());
            presoner_punts.setPunts(punts);
            ranking.add(presoner_punts);
            Object o[] = ranking.toArray();
            Arrays.sort(o, Collections.reverseOrder());
            for (int i = 0; i < o.length; i++) {
                out.writeObject(o[i]);
            }
            out.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Classificacio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Classificacio.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Mètode per obtenir els objectes emmagatzemats en el arxiu de classificació.
     * @param arxiu Arxiu on es troba la classificació emmagatzemada
     */
    public static void obtenirPresoner(String arxiu) {
        ranking = new ArrayList<Puntuacions>();
        boolean eofile = false;
        try {
            FileInputStream entrada = new FileInputStream(arxiu);
            ObjectInputStream in = new ObjectInputStream(entrada);
            while (!eofile) {
                try {
                    ranking.add((Puntuacions) in.readObject());
                } catch (EOFException ex) {
                    eofile = true;
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Classificacio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            in.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Classificacio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Classificacio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Mètode per carregar un JDialog amb la classificació i la posició final del jugador-presoner.
     * @param p2 Nom del jugador-presoner
     */
    public static void ranking(String p2) {
        Classificacio_GUI classificacio = new Classificacio_GUI(new javax.swing.JFrame(), true);
        classificacio.setLocationRelativeTo(null);
        classificacio.presonerResultat(p2);
        classificacio.setVisible(true);
    }

    /**
     * Mètode per imprimir els 5 millos jugadors-presoners en un Jtable.
     * @param table Jtable on imprimir la classificació
     */
    public static void rankingTOP(DefaultTableModel table) {
        String[] dades = new String[4];
        int posicio = 1;
        for (int i = 0; i < ranking.size() && i < 5; i++) {
            dades[0] = "#" + posicio;
            dades[1] = ranking.get(i).getPresoner().getPrisonerName();
            dades[2] = String.valueOf(ranking.get(i).getPunts());
            table.addRow(dades);
            posicio++;

        }

    }

    /**
     * Mètode per imprimir la classificació total en un Jtable.
     * @param table Jtable on imprimir la classificació
     */
    public static void rankingAll(DefaultTableModel table) {
        String format = "dd/MM/yyyy";
        SimpleDateFormat format_data = new SimpleDateFormat(format);
        String[] dades = new String[4];
        int posicio = 1;
        for (int i = 0; i < ranking.size(); i++) {
            dades[0] = "#" + posicio;
            dades[1] = ranking.get(i).getPresoner().getPrisonerName();
            dades[2] = String.valueOf(ranking.get(i).getPunts());
            dades[3] = String.valueOf(format_data.format(ranking.get(i).getData()));
            table.addRow(dades);
            posicio++;
        }
    }

}
