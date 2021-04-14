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

    public Federacio(String nom, float preu) {
        _nom = nom;
        _preu = preu;
    }

    public String getNom() {
        return _nom;
    }

    public void setNom(String nom) {
        _nom = nom;
    }

    public float getPreu() {
        return _preu;
    }

    public void setPreu(float preu) {
        _preu = preu;
    }

    @Override
    public String toString() {
        return "Federació: Nom= " + _nom + ", Preu= " + _preu;
    }

}
