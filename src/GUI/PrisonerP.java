/*
 *
 */

package GUI;

import Prisoner.Prisoner;
import java.awt.Image;
import java.io.Serializable;

/**
 * Classe per tenir emmagatzemar el nom del jugador (presoner).
 * @since 2.0
 * @author Ramses - RLL862
 */
public class PrisonerP implements Prisoner,Serializable {

    private String name_prisoner;

    /**
     * Constructor de PrisonerP.
     * @param name_prisoner 
     */
    public PrisonerP(String name_prisoner) {
        this.name_prisoner = name_prisoner;
    }

    @Override
    public Action decision() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNewOpponent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setOpponentDecision(Action decision) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPrisonerName() {
        return name_prisoner;
    }

    @Override
    public Image getPrisonerImage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
