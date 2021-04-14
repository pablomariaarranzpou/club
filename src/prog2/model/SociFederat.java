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
public class SociFederat extends Soci{
    private Federacio federacio;
    private float preu;
    private String tipus_federacio;
    
    
    public SociFederat(String nom, String dni, float preu, String nom_federacio) throws ExcepcioClub {
        super(nom, dni);
        comprova(preu);
        this.federacio = new Federacio(nom_federacio, preu);
    }

    @Override
    public float calculaPreuExcursio(float baseExcursio) {
        return baseExcursio;
    }
    
    @Override
    public float calculaQuota(float quotaBase){        
        return quotaBase;
    }

    @Override
    public String toString() {
        return "Nom: " + this.getNom() + ", DNI: " + this.getDNI() + ", " + federacio.toString();
    }
    
    public void comprova(float preu) throws ExcepcioClub {
        
        if(preu < 100){
            throw new ExcepcioClub("PREU DE FEDERACIÓ INVÀLID");
        }
    }

    public Federacio getFederacio() {
        return federacio;
    }

    public void setFederacio(Federacio federacio) {
        this.federacio = federacio;
    }

    public float getPreu() {
        return preu;
    }

    public void setPreu(float preu) {
        this.preu = preu;
    }

    public String getTipus_federacio() {
        return tipus_federacio;
    }

    public void setTipus_federacio(String tipus_federacio) {
        this.tipus_federacio = tipus_federacio;
    }
    
    
}
