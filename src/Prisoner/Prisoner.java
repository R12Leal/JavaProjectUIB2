/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Prisoner;

import java.awt.Image;

/**
 * La interface Prisoner especifica els mètodes abstractes que hauran
 * d'implementar les classes que defineixin els jugadors del joc. Defineix les
 * desicions del presones, i els mètodes per demanar-li una desició, avisar-lo
 * que té un nou oponent, un mètode per informar-lo de la darrera desició del
 * seu oponent, un getter per obtenir el nom del presoner i un per obtenir la
 * imatge
 * @author Antoni Jaume-i-Capó
 */
public interface Prisoner {

    /**
     * Aquesta enumeració representa l'acció del presoner cooperar o trair
     */
    public enum Action{cooperate,betray}

    /**
     * Retorna la desició presa pel presoner (cooperate o betray)
     * @return enum Action{cooperate,betray}
     */
    public Action decision();

    /**
     * Avisa al preseoner que comença a jugar amb un nou oponent.
     * Aquet mètode permet al presoner a iniciar un historial del nou oponent
     */
    public void setNewOpponent();

    /**
     * Indica al presoner la desició presa per l'oponent. El mètode permet que el
     * presoner faci un historial de les accions de l'oponent
     * @param decision indicarà la desició de l'oponent en el darrer joc
     */
    public void setOpponentDecision(Action decision);

    /**
     * getter per obtenir el nom del presoner
     * @return String amb el nom del presoner
     */
    public String getPrisonerName();

    /**
     * getter per obtenir la imatge del presoner
     * @return Imatge del presoner
     */
    public Image getPrisonerImage();

}
