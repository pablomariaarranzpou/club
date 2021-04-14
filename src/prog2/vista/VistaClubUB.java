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

    public void gestioClubUB() {
        Scanner sc = new Scanner(System.in);
        gestioMenu(sc);
    }

    private static enum OpcionesMenu {
        M_Opcion_1_Alta,
        M_Opcion_2_Mostar,
        M_Opcion_3_Eliminar,
        M_Opcion_4_Factures,
        M_Opcion_5_ModificarNom,
        M_Opcion_6_ModificarAssegurança,
        M_Opcion_7_Guardar,
        M_Opcion_8_Recuperar,
        M_Opcion_9_Sortir,

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
        "Recuperar llista" //Carrega el contingut"
    };

    // Funcions que gestiona el menu principal de l'aplicació
    // Tiene 3 pasos principales:
    //   1. Crear el objeto que representa (contiene) el menu
    //   2. Asignar las descripciones del menu
    //   3. Bucle donde se trata la opcion seleccionada por el usuario
    public void gestioMenu(Scanner sc) {
        // Creación del objeto que representa el menu. El primer argumento del contructor es el nombre del menu
        Menu<OpcionesMenu> menuEstacio = new Menu<>("Menu " + _club.getNomClub(), OpcionesMenu.values());
        //Menu<OpcionesMenu> menuEstacio = new Menu<>("Menu " + estacio.getNomEstacio(), OpcionesMenu.values());

        // Assignar una descripción a cada una de las opciones
        //  - OPCIONAL - Por defecto enseña el nombre de la opción
        menuEstacio.setDescripcions(descMenu);

        // Variable (de tipo enumerado igual a las opciones del menu) que contiene la opcion escogida
        OpcionesMenu opcionMenu;

        // Lanzar el bucle principal de la aplicación
        do {
            menuEstacio.mostrarMenu();
            opcionMenu = menuEstacio.getOpcio(sc);

            switch (opcionMenu) {
                case M_Opcion_1_Alta:

                    break;
                case M_Opcion_2_Mostar:

                    break;
                case M_Opcion_3_Eliminar:

                    break;
                case M_Opcion_4_Factures:

                    break;
                case M_Opcion_5_ModificarNom:

                    break;
                case M_Opcion_6_ModificarAssegurança:

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

}
