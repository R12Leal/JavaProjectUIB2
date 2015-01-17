/*
 *
 */

package Prisoner;

import java.awt.Image;
import java.awt.Toolkit;

/**
 * Class PrisonerTitForTat (Estratègia de prova: Tit For Tat); L'estratègia és simplement cooperar 
 * en la primera iteració del joc i, posteriorment, fer allò que l'oponent 
 * ha fet en la iteració anterior...  
 * @since  2.0
 * @author Ramses - RLL862
 */
public class PrisonerTitForTat implements Prisoner {

    private final String name_prisoner;
    private Action decision_opponent;
    private Image img;
    private boolean first_decision = true;  

    public PrisonerTitForTat(String name_prisoner,String image) {
        this.name_prisoner = name_prisoner;
        this.img = Toolkit.getDefaultToolkit().getImage(image);
    }
    
    @Override
    public Action decision() {
        
        if (!first_decision) {
            return decision_opponent;
        } else {
            first_decision = false;
            return Action.cooperate;
        }
    }    
    
    @Override
    public void setNewOpponent() {
        first_decision = true;
    }

    @Override
    public void setOpponentDecision(Action decision) {
        decision_opponent = decision;
    }

    @Override
    public String getPrisonerName() {
        return this.name_prisoner;
    }

    @Override
    public Image getPrisonerImage() {
        return img;
    }
    
}
