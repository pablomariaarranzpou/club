/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.vista;

/**
 *
 * @author Pablo
 */
public class ExcepcioClub extends Exception {

    /**
     * Exepció prinicipal quer farem servir a tot el programa,
     * @param msj
     */
    public ExcepcioClub(String msj) {
        super(msj);
    }
    
}
