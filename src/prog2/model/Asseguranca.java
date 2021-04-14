/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.Serializable;

/**
 *
 * @author arran
 */
public class Asseguranca implements Serializable{

    private String _tipus;
    private float _preu;

    public Asseguranca(String tipus, float preu) {
        _tipus = tipus;
        _preu = preu;
    }

    public String getTipus() {
        return _tipus;
    }

    public void setTipus(String tipus) {
        _tipus = tipus;
    }

    public float getPreu() {
        return _preu;
    }

    public void setPreu(float preu) {
        _preu = preu;
    }

    @Override
    public String toString() {
        return "Assegurança: Tipus= " + _tipus + ", Preu= " + _preu;
    }

}
