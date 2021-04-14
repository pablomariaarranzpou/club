/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import prog2.vista.ExcepcioClub;

/**
 * Classe filla de Soci.
 *
 * @author arran
 */
public class SociEstandard extends Soci {

    private Asseguranca _asseguranca;

    /**
     * Constructor per defecte de la classe SociEstandard
     *
     * @param nom
     * @param dni
     * @param asseguranca
     * @throws ExcepcioClub
     */
    public SociEstandard(String nom, String dni, Asseguranca asseguranca) throws ExcepcioClub {
        super(nom, dni);
        comprova(asseguranca.getTipus());
        _asseguranca = asseguranca;
    }

    /**
     * Métode abstracte implmentat a les classes filles(explicaciói a classe
     * Soci)
     *
     * @param quotaBase
     * @return
     * @throws prog2.vista.ExcepcioClub
     */
    @Override
    public float calculaQuota(float quotaBase) throws ExcepcioClub {
        return quotaBase;
    }

    /**
     * Métode abstracte implmentat a les classes filles(explicaciói a classe
     * Soci)
     *
     * @param preuExcursioBase
     * @return
     * @throws prog2.vista.ExcepcioClub
     */
    @Override
    public float calculaPreuExcursio(float preuExcursioBase) throws ExcepcioClub {
        return preuExcursioBase + _asseguranca.getPreu();
    }

    /**
     * Retorna la informacio del soci a una string
     *
     * @return
     */
    @Override
    public String toString() {
        return "Nom: " + this.getNom() + ", DNI: " + this.getDNI() + ", " + _asseguranca.toString();
    }

    /**
     * Retorna l´assegurança del soci
     *
     * @return
     */
    public Asseguranca getAsseguranca() {
        return _asseguranca;
    }

    /**
     * Canvia l´assegurança del soci
     *
     * @param asseguranca
     */
    public void setAsseguranca(Asseguranca asseguranca) {
        _asseguranca = asseguranca;
    }

    /**
     * Modifica el tipus d´assegurança
     *
     * @param tipusAsseguranca
     * @throws ExcepcioClub
     */
    public void modificarAsseguranca(String tipusAsseguranca) throws ExcepcioClub {
        comprova(tipusAsseguranca);
        _asseguranca.setTipus(tipusAsseguranca);
    }

    /**
     * Comprova si el tipus de l´assegurança es vàlid
     *
     * @param tipusAsseguranca
     * @throws ExcepcioClub
     */
    private void comprova(String asse) throws ExcepcioClub {
        if (!asse.equals("Basica") && !asse.equals("Completa")) {
            throw new ExcepcioClub("El tipus d'assegurança no és correcte.");
        }
    }
}
