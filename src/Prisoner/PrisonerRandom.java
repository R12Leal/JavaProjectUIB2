/**
 * 
 */

package Prisoner;
import java.awt.Image;
import java.awt.Toolkit;

/**
 * Class PrisonerRandom (Despistat), presoner amb decisió aleatòria.
 * @since  2.0
 * @author Ramses - RLL862
 */
public class PrisonerRandom implements Prisoner {

    private final String name_prisoner;
    private Image img;
    
    /** 
     * Constructor de clase.
     * @param name_prisoner String amb el nom del presoner 
     * @param image Imatge del presoner
    */
    public PrisonerRandom (String name_prisoner,String image) {
        this.name_prisoner = name_prisoner;
        this.img = Toolkit.getDefaultToolkit().getImage(image);
    }
    
    @Override
    public Action decision() {
        return Action.values()[(int) (Math.random() * Action.values().length)];
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
        return img;
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
