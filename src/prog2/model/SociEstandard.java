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
public class SociEstandard extends Soci {

    private Asseguranca asseguranca;
    private float preu;

    public SociEstandard(String nom, String dni, String tipus_asse, float preu) throws ExcepcioClub {
        super(nom, dni);
        comprova(tipus_asse);
        this.asseguranca = new Asseguranca(tipus_asse, preu);
    }

    @Override
    public float calculaQuota(float quotaBase) throws ExcepcioClub {
        return quotaBase;
    }

    @Override
    public float calculaPreuExcursio(float preuExcursioBase) throws ExcepcioClub {
        return preuExcursioBase + preu;
    }

    @Override
    public String toString() {
        return "Nom: " + this.getNom() + ", DNI: " + this.getDNI() + ", " + asseguranca.toString();
    }

    public void comprova(String asse) throws ExcepcioClub {
        if (!asse.equals("Completa") && !asse.equals("Completa")) {
            throw new ExcepcioClub("TIPUS D´ASSEGURANÇA NO VÀLID");
        }
    }

    public Asseguranca getAsseguranca() {
        return asseguranca;
    }

    public void setAsseguranca(Asseguranca asseguranca) {
        this.asseguranca = asseguranca;
    }

    public float getPreu() {
        return preu;
    }

    public void setPreu(float preu) {
        this.preu = preu;
    }
}
