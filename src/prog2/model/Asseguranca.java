/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.Serializable;

/**
 * Classe Assegurnça implementa serializable per poder guardar-se
 *
 * @author arran
 */
public class Asseguranca implements Serializable {

    private String _tipus;
    private float _preu;

    /**
     * Constructor Classe Assegurança
     *
     * @param tipus
     * @param preu
     */
    public Asseguranca(String tipus, float preu) {
        _tipus = tipus;
        _preu = preu;
    }

    /**
     * Getter del tipus d´assegurança
     *
     * @return
     */
    public String getTipus() {
        return _tipus;
    }

    /**
     * Setter del tipus d´assegurança
     *
     * @param tipus
     */
    public void setTipus(String tipus) {
        _tipus = tipus;
    }

    /**
     * Getter del preu de l´assegurança
     *
     * @return
     */
    public float getPreu() {
        return _preu;
    }

    /**
     * Setter del preu de l´assegurança
     *
     * @param preu
     */
    public void setPreu(float preu) {
        _preu = preu;
    }

    /**
     * Métode toString de la classe assegurança
     *
     * @return
     */
    @Override
    public String toString() {
        return "Assegurança: Tipus= " + _tipus + ", Preu= " + _preu;
    }

}
