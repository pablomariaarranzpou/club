/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.vista;

import java.util.Scanner;
import prog2.model.ClubUB;

/**
 *
 * @author arran
 */
public class VistaClubUB {

    private ClubUB _club;

    public VistaClubUB() {
        _club = new ClubUB("Club_1");
    }

    public void gestioClubUB() throws ExcepcioClub {
        Scanner sc = new Scanner(System.in);
        gestioMenu(sc);
    }

    private static enum OpcionesMenu {
        M_Opcion_1_Alta,
        M_Opcion_2_Mostar,
        M_Opcion_3_Eliminar,
        M_Opcion_4_Factures,
        M_Opcion_5_ModificarNom,
        M_Opcion_6_ModificarAsseguranca,
        M_Opcion_7_Guardar,
        M_Opcion_8_Recuperar,
        M_Opcion_9_Sortir

    };
    private static enum OpcionesMenuSecundari {
        M_Opcion_1_AfegirFederat,
        M_Opcion_2_AfegirEstandard,
        M_Opcion_3_AfegirJunior,
        M_Opcion_4_MenúAnterior
    };
    

    // Descripcion de las opciones del menu principal
    private static final String[] descMenu = {
        "Donar d’alta un nou soci", // Mostra un menú per tal d’afegir un soci a la llista de socis.
        "Mostrar llista de socis",// Mostra el contingut de la llista de socis del ClubUB mostrant davant de cada soci, el nombre de la seva posició a la llista començant per 1.
        "Eliminar soci", // Elimina un soci de la llista indicant la seva posició a la llista.
        "Mostrar factura", // Mostra el total que ha de pagar un soci determinat en la factura d’un mes, indicant el seu DNI i el número d’excursions que ha fet aquell mateix mes."
        "Modificar nom soci", // Permet canviar el nom d’un soci per un altre.
        "Modificar tipus assegurança soci", //Permet canviar el tipus d’assegurança d’un soci indicant el seu DNI i el nou tipus d’assegurança (“Bàsica” o “Completa”).
        "Guardar llista", //Guarda el contingut de la llista en un fitxer." 
        "Recuperar llista", //Carrega el contingut"
        "Sortir" // Fi del programa
    };
    
    // Descripcio de les opcions del menú secundari
    private static final String[] descMenuSecundari = {
        "Afegir soci federat", // Opcion 1
        "Afegir soci estàndard",  // Opcion 2
        "Afegir soci junior",  // Opcion 3
        "Menú anterior"     // Opcion 4
    };

    // Funcions que gestiona el menu principal de l'aplicació
    // Tiene 3 pasos principales:
    //   1. Crear el objeto que representa (contiene) el menu
    //   2. Asignar las descripciones del menu
    //   3. Bucle donde se trata la opcion seleccionada por el usuario
    public void gestioMenu(Scanner sc) throws ExcepcioClub {
        // Creación del objeto que representa el menu. El primer argumento del contructor es el nombre del menu
        Menu<OpcionesMenu> menu = new Menu<>("Menu " + _club.getNomClub(), OpcionesMenu.values());
        //Menu<OpcionesMenu> menuEstacio = new Menu<>("Menu " + estacio.getNomEstacio(), OpcionesMenu.values());

        // Assignar una descripción a cada una de las opciones
        //  - OPCIONAL - Por defecto enseña el nombre de la opción
        menu.setDescripcions(descMenu);

        // Variable (de tipo enumerado igual a las opciones del menu) que contiene la opcion escogida
        OpcionesMenu opcionMenu;

        // Lanzar el bucle principal de la aplicación
        do {
            menu.mostrarMenu();
            opcionMenu = menu.getOpcio(sc);

            switch (opcionMenu) {
                case M_Opcion_1_Alta:
                    gestioMenuSecundari(sc);
                    break;
                case M_Opcion_2_Mostar:

                    break;
                case M_Opcion_3_Eliminar:

                    break;
                case M_Opcion_4_Factures:

                    break;
                case M_Opcion_5_ModificarNom:

                    break;
                case M_Opcion_6_ModificarAsseguranca:

                    break;
                case M_Opcion_8_Recuperar:
                    break;
                case M_Opcion_9_Sortir:
                    System.out.println("Fins aviat!");
                    break;
                default:
                    System.out.println("Aquesta no és una opció vàlida.");
            }

        } while (opcionMenu != OpcionesMenu.M_Opcion_9_Sortir);
    }
    public void gestioMenuSecundari(Scanner sc) throws ExcepcioClub {
        // Creación del objeto que representa el menu. El primer argumento del contructor es el nombre del menu
        Menu<OpcionesMenuSecundari> menuGestio = new Menu<>("Menu Secundari", OpcionesMenuSecundari.values());
        //Menu<OpcionesMenu> menuEstacio = new Menu<>("Menu " + estacio.getNomEstacio(), OpcionesMenu.values());
        
        // Assignar una descripción a cada una de las opciones
        //  - OPCIONAL - Por defecto enseña el nombre de la opción
        menuGestio.setDescripcions(descMenuSecundari);
        
        // Variable (de tipo enumerado igual a las opciones del menu) que contiene la opcion escogida
        OpcionesMenuSecundari opcionMenu;
        
        // Lançar el bucle principal de la aplicación
        do {
            menuGestio.mostrarMenu();
            opcionMenu = menuGestio.getOpcio(sc);  

            switch(opcionMenu) {
                case M_Opcion_1_AfegirFederat:
                   
                    break;
                case M_Opcion_2_AfegirEstandard:
                    
                    break;
                case M_Opcion_3_AfegirJunior:
                    
                    break;                               
            }
            
        } while(opcionMenu != OpcionesMenuSecundari.M_Opcion_4_MenúAnterior);
    }

}
