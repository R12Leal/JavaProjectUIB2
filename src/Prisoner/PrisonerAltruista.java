/**
 * 
 */

package Prisoner;
import java.awt.Image;

/**
 * Class PrisonerAltruista, presoner amb decisió cooperate.
 * @since  2.0
 * @author Ramses - RLL862
 */
public class PrisonerAltruista implements Prisoner {
    
    private final String name_prisoner;
    
    /** 
     * Constructor de clase.
     * @param name_prisoner String amb el nom del presoner. 
    */
    public PrisonerAltruista(String name_prisoner) {
        this.name_prisoner = name_prisoner;
    }
    
    @Override
    public Action decision() {
        return Action.cooperate;
    }

    @Override
    public void setNewOpponent() {}

    @Override
    public void setOpponentDecision(Action decision) {}

    @Override
    public String getPrisonerName() {
        return this.name_prisoner;
    }

    @Override
    public Image getPrisonerImage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Obtenir informació del presoner: nom i decisió.
     * @return String - Informació del presoner. 
     */
    @Override
    public String toString() {
        return "Presoner: " + this.name_prisoner + ", Decisió: " + this.decision();
    }
     
}
