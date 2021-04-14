/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import prog2.vista.ExcepcioClub;

/**
 *
 * @author arran
 */
public class SociFederat extends Soci {

    private Federacio _federacio;
    private float _preu;
    private String _tipusFederacio;

    public SociFederat(String nom, String dni, float preu, String nom_federacio) throws ExcepcioClub {
        super(nom, dni);
        comprovaPreu(preu);
        _federacio = new Federacio(nom_federacio, preu);
    }

    @Override
    public float calculaPreuExcursio(float baseExcursio) {
        return baseExcursio;
    }

    @Override
    public float calculaQuota(float quotaBase) {
        return quotaBase;
    }

    @Override
    public String toString() {
        return "Nom: " + this.getNom() + ", DNI: " + this.getDNI() + ", " + _federacio.toString();
    }

    public Federacio getFederacio() {
        return _federacio;
    }

    public void setFederacio(Federacio federacio) {
        _federacio = federacio;
    }

    public float getPreu() {
        return _preu;
    }

    public void setPreu(float preu) {
        _preu = preu;
    }

    public String getTipusFederacio() {
        return _tipusFederacio;
    }

    public void setTipusFederacio(String tipus_federacio) {
        _tipusFederacio = tipus_federacio;
    }

    public void comprovaPreu(float preu) throws ExcepcioClub {
        if (preu < 100) {
            throw new ExcepcioClub("PREU DE FEDERACIÓ INVÀLID");
        }
    }
}
