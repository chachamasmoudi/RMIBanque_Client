package rmiClient;

import javax.naming.InitialContext;

import metier.Compte;
import rmiService.IBanque;

public class BanqueClient {

    public static void main(String[] args) {
        try {
            // Contexte JNDI chargé automatiquement depuis jndi.properties
            InitialContext ctx = new InitialContext();

            // Recherche (lookup) de l'objet distant via JNDI
            IBanque banque = (IBanque) ctx.lookup("banque");

            // Création d'un compte
            System.out.println(banque.creerCompte(new Compte(1, 5000)));

            // Tentative de création avec un code déjà existant
            System.out.println(banque.creerCompte(new Compte(1, 200)));

            // Consultation d'un compte existant
            System.out.println(banque.getInfoCompte(1));

            // Consultation d'un compte inexistant
            System.out.println(banque.getInfoCompte(99));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}