/**
 * 
 */

package Prisoner;

/**
 * Class Main per fer proves.
 * @since  2.0
 * @author Ramses - RLL862
 */
public class Main {
    
    
    public static void main(String[] args) {
        
        PrisonerRandom p1 = new PrisonerRandom("Presoner1_Despistat", "img/usuario.jpg");
        PrisonerRandom p2 = new PrisonerRandom("Presoner2_Despistat", "img/usuario.jpg");
        PrisonerRandom p3 = new PrisonerRandom("Presoner3_Despistat", "img/usuario.jpg");
        PrisonerRandom p4 = new PrisonerRandom("Presoner4_Despistat", "img/usuario.jpg");
        PrisonerRandom p20 = new PrisonerRandom("TITFORTAT","img/usuario.jpg");
        PrisonerRLL862 p24 = new PrisonerRLL862("Ramsés","img/rll862.dat");
        PrisonerTitForTat p5 = new PrisonerTitForTat("Presoner5_Despistat", "img/usuario.jpg");
        PrisonerTitForTat p6 = new PrisonerTitForTat("Presoner6_Despistat", "img/usuario.jpg");
        PrisonerTitForTat p7 = new PrisonerTitForTat("Presoner7_Despistat", "img/usuario.jpg");
        PrisonerTitForTat p8 = new PrisonerTitForTat("Presoner8_Despistat", "img/usuario.jpg");
        PrisonerTitForTat p9 = new PrisonerTitForTat("Presoner9_Despistat", "img/usuario.jpg");
        PrisonerRandom p10 = new PrisonerRandom("Presoner10_Despistat", "img/usuario.jpg");
        PrisonerRandom p11 = new PrisonerRandom("Presoner11_Despistat", "img/usuario.jpg");
        
        // PrisonerAltruista p30 = new PrisonerAltruista("Prisoner30_Altruista");
        // PrisonerTraidor p31 = new PrisonerTraidor("Prisoner30_Traidor");
        
        Prisoner[] presoners = {p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p20,p24};  
        Enfrontaments dilema = new Enfrontaments(presoners,"parametres.txt");
        dilema.iniciarJoc();
        dilema.classificacio();
        
    }
    
}
