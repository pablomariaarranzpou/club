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

    private Asseguranca _asseguranca;
    private float _preu;

    public SociEstandard(String nom, String dni, String tipus_asse, float preu) throws ExcepcioClub {
        super(nom, dni);
        comprovaAsseguranca(tipus_asse);
        _asseguranca = new Asseguranca(tipus_asse, preu);
    }

    @Override
    public float calculaQuota(float quotaBase) throws ExcepcioClub {
        return quotaBase;
    }

    @Override
    public float calculaPreuExcursio(float preuExcursioBase) throws ExcepcioClub {
        return preuExcursioBase + _preu;
    }

    @Override
    public String toString() {
        return "Nom: " + this.getNom() + ", DNI: " + this.getDNI() + ", " + _asseguranca.toString();
    }

    public Asseguranca getAsseguranca() {
        return _asseguranca;
    }

    public void setAsseguranca(Asseguranca asseguranca) {
        _asseguranca = asseguranca;
    }

    public float getPreu() {
        return _preu;
    }

    public void setPreu(float preu) {
        _preu = preu;
    }

    public void comprovaAsseguranca(String asse) throws ExcepcioClub {
        if (!asse.equals("Completa") && !asse.equals("Completa")) {
            throw new ExcepcioClub("El tipus d'assegurança no és correcte.");
        }
    }
}
