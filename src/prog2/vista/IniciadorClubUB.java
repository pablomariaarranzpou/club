/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.vista;

import java.io.IOException;

/**
 *
 * @author arran
 */
public class IniciadorClubUB {

    public static void main(String[] args) throws ExcepcioClub, IOException, ClassNotFoundException {
        // Atributs necessaris pel Club
        String nomClub = "ClubUB";

        // Creem l'objecte de la vista amb els atributs necessàris
        VistaClubUB vistaClub = new VistaClubUB(nomClub);

        // Inicialitzem l'execució de la vista
        vistaClub.gestioClubUB();
    }
}
