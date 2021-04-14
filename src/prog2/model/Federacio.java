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
public class Federacio implements Serializable{

    private String _nom;
    private float _preu;

    /**
     * Constructor federació
     * @param nom
     * @param preu
     */
    public Federacio(String nom, float preu) {
        _nom = nom;
        _preu = preu;
    }

    /**
     * Getter nom federació.
     * @return
     */
    public String getNom() {
        return _nom;
    }

    /**
     * Setter nom federacio
     * @param nom
     */
    public void setNom(String nom) {
        _nom = nom;
    }

    /**
     * Getter Preu federació
     * @return
     */
    public float getPreu() {
        return _preu;
    }

    /**
     * Setter preu federacio
     * @param preu
     */
    public void setPreu(float preu) {
        _preu = preu;
    }

    /**
     * toString de Federacio
     * @return
     */
    @Override
    public String toString() {
        return "Federació: Nom= " + _nom + ", Preu= " + _preu;
    }

}
