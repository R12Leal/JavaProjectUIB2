/*
 *
 */
package Prisoner;

import java.awt.Image;
import java.awt.Toolkit;

/**
 * Estratègia alumne RLL862.
 * @since 2.0
 * @author Ramses - RLL862
 */
public class PrisonerRLL862 implements Prisoner {

    private final String name_prisoner;
    private Image img;
    private boolean first_decision;
    private Action back_decision;
    private Action back_decision_op;

    /**
     * Constructor classe PrisonerRLL862.
     * @param name_prisoner String amb el nom del presoner
     * @param image Imatge del presoner
     */
    public PrisonerRLL862(String name_prisoner, String image) {
        this.name_prisoner = name_prisoner;
        this.img = Toolkit.getDefaultToolkit().getImage(image);
        this.first_decision = true;
    }

    @Override
    public Action decision() {
        if (first_decision) {
            first_decision = false;
            back_decision = Action.cooperate;
            return Action.cooperate;
        } else if ((back_decision == Action.betray && back_decision_op == Action.cooperate) || (back_decision == Action.cooperate && back_decision_op == Action.cooperate)) {
            return back_decision;
        } else {
            if (back_decision.equals(Action.cooperate)) {
                back_decision = Action.betray;
                return Action.betray;
            } else {
                back_decision = Action.cooperate;
                return Action.cooperate;
            } 
        }
    }

    @Override
    public void setNewOpponent() {
        first_decision = true;
    }

    @Override
    public void setOpponentDecision(Action decision) {
        back_decision_op = decision;
    }

    @Override
    public String getPrisonerName() {
        return name_prisoner;
    }

    @Override
    public Image getPrisonerImage() {
        return img;
    }

}
