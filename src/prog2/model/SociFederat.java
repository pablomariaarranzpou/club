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
     * @param federacio
     * @throws ExcepcioClub
     */
    public SociFederat(String nom, String dni, Federacio federacio) throws ExcepcioClub {
        super(nom, dni);
        comprova(federacio.getPreu());
        _federacio = federacio;
    }
    /**
     * 
     * @param baseExcursio
     * @return 
     */
    @Override
    public float calculaPreuExcursio(float baseExcursio) {
        return baseExcursio - (baseExcursio * DESCOMPTE_EXCURSIO);
    }
    /**
     * 
     * @param quotaBase
     * @return 
     */
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
     * Retorna la federació d´un soci en concret
     * @return Federació
     */
    public Federacio getFederacio() {
        return _federacio;
    }

    /**
     * Setter de la federacio d´un soci
     * @param federacio
     */
    public void setFederacio(Federacio federacio) {
        _federacio = federacio;
    }

    /**
     * Getter del tipus de federació d´un soci
     * @return
     */
    public String getTipusFederacio() {
        return _tipusFederacio;
    }

    /**
     * Setter del tipus de federació d´un soci
     * @param tipus_federacio
     */
    public void setTipusFederacio(String tipus_federacio) {
        _tipusFederacio = tipus_federacio;
    }
    
    /**
     * Conmprova que no fa més exucrsions diaries que dies te com a máxim un mes.
     * @param preu
     * @throws ExcepcioClub 
     */
    private void comprova(float preu) throws ExcepcioClub {
        if (preu < 100) {
            throw new ExcepcioClub("PREU DE FEDERACIÓ INVÀLID");
        }
    }
}
