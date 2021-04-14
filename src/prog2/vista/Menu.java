/*
 * Universitat de Barcelona
 * Programació 2
 * Curs 2015-2016
 */
package prog2.vista;

import java.util.Scanner;

/**
 * Implements a text menu from a list of options.
 * @author Xavi Baró
 * @param <TEnum>
 */
public class Menu<TEnum> {
     /**
     * Llista de les opcions
     */
    TEnum[] _llistaOpcions=null;

    /**
     * Títol del menú
     */
    String _titol="";

    /**
     * Llista amb els missatges associats a les accions
     */
    String[] _descripcions=null;

    /**
     * Constructor per defecte. Se li ha de passar un enumeració de les opcions.
     * @param titol Títol del menú
     * @param llistaOpcions Enumeració amb les opcions
     */
    public Menu(String titol,TEnum[] llistaOpcions) {
        _titol=titol;
        _llistaOpcions=llistaOpcions;
    }

    /**
     * Permet assignar una descripció personalitzada a les opcions del menú
     * @param descripcions Llista de descripcions
     */
    public void setDescripcions(String[] descripcions) {
        if(descripcions.length!=_llistaOpcions.length) {
            _descripcions=null;
        } else {
            _descripcions=descripcions;
        }
    }
    
    /**
     * Mostra el menú d'opcions
     */
    public void mostrarMenu() {
        // Mostrem les opcions
        String lines="--------------";
        for(int i=0;i<getMaxLen();i++) {
            lines+="-";
        }
        System.out.println(lines);
        System.out.println(_titol.toUpperCase());
        System.out.println(lines);
        for(TEnum c : _llistaOpcions){
            
            // Mostrem la posició
            int pos=((Enum)c).ordinal();
            System.out.print("\t" + (pos+1) + ".- ");
            
            // Mostrem la descripció
            if(_descripcions!=null) {
                System.out.println(_descripcions[pos]);
            } else {
                System.out.println(c);
            }
        }
        System.out.println(lines);
    }

    /**
     * Demana una opció utilitzant la entrada passada per paràmetre.
     * @param sc Canal d'entrada utilitzat per a obtenir la opció
     * @return Opció seleccionada.
     */
    public TEnum getOpcio(Scanner sc) {
        TEnum opcio=null;

        // Demanem una opció assegurant que sigui correcta
        int opcioInt=-1;
        do {
            System.out.print("Entra una opcio >> ");
            opcioInt=sc.nextInt();
            sc.nextLine();

            if(opcioInt>0 && opcioInt<=_llistaOpcions.length) {
                // Passem de l'enter a una opcio i la retornem
                opcio=_llistaOpcions[opcioInt-1];
            } else {
                System.err.println("La opció seleccionada no és correcta. Selecciona una opció entre 1 i " + (_llistaOpcions.length));
            }
        } while(opcio==null);

        return opcio;
    }

    /**
     * Troba la longitud màxima en les descripcions de les opcions
     * @return Longitud de la descripció més llarga
     */
    private int getMaxLen() {
        int maxLen=0;

        for(TEnum c : _llistaOpcions){

            // Obtenim la posició
            int pos=((Enum)c).ordinal();

            // Mostrem la descripció
            if(_descripcions!=null) {
                maxLen=Math.max(maxLen, _descripcions[pos].length());
            } else {
                maxLen=Math.max(maxLen, c.toString().length());                
            }
        }

        return maxLen;
    }
}
