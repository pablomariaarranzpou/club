/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import prog2.vista.ExcepcioClub;

import static prog2.model.ClubUB.DESCOMPTE_QUOTA;
import static prog2.model.ClubUB.DESCOMPTE_EXCURSIO;

/**
 *
 * @author arran
 */
public class SociFederat extends Soci {

    private Federacio _federacio;
    private String _tipusFederacio;

    /**
     *
     * @param nom
     * @param dni
     * @param preu
     * @param nom_federacio
     * @throws ExcepcioClub
     */
    public SociFederat(String nom, String dni, float preu, String nom_federacio) throws ExcepcioClub {
        super(nom, dni);
        comprova(preu);
        _federacio = new Federacio(nom_federacio, preu);
    }

    @Override
    public float calculaPreuExcursio(float baseExcursio) {
        return baseExcursio - (baseExcursio * DESCOMPTE_EXCURSIO);
    }

    @Override
    public float calculaQuota(float quotaBase) {
        return quotaBase - (quotaBase * DESCOMPTE_QUOTA);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Nom: " + this.getNom() + ", DNI: " + this.getDNI() + ", " + _federacio.toString();
    }

    /**
     *
     * @return
     */
    public Federacio getFederacio() {
        return _federacio;
    }

    /**
     *
     * @param federacio
     */
    public void setFederacio(Federacio federacio) {
        _federacio = federacio;
    }

    /**
     *
     * @return
     */
    public String getTipusFederacio() {
        return _tipusFederacio;
    }

    /**
     *
     * @param tipus_federacio
     */
    public void setTipusFederacio(String tipus_federacio) {
        _tipusFederacio = tipus_federacio;
    }

    private void comprova(float preu) throws ExcepcioClub {
        if (preu < 100) {
            throw new ExcepcioClub("PREU DE FEDERACIÓ INVÀLID");
        }
    }
}
