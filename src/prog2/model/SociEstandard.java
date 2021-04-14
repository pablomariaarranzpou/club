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

    public SociEstandard(String nom, String dni, String tipusAsseguranca, float preu) throws ExcepcioClub {
        super(nom, dni);
        comprova(tipusAsseguranca);
        _asseguranca = new Asseguranca(tipusAsseguranca, preu);
    }

    @Override
    public float calculaQuota(float quotaBase) throws ExcepcioClub {
        return quotaBase;
    }

    @Override
    public float calculaPreuExcursio(float preuExcursioBase) throws ExcepcioClub {
        return preuExcursioBase + _asseguranca.getPreu();
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
    
    public void modificarAsseguranca(String tipusAsseguranca) throws ExcepcioClub {
        comprova(tipusAsseguranca);
        _asseguranca.setTipus(tipusAsseguranca);
    }

    private void comprova(String asse) throws ExcepcioClub {
        if (!asse.equals("Basica") && !asse.equals("Completa")) {
            throw new ExcepcioClub("El tipus d'assegurança no és correcte.");
        }
    }
}
