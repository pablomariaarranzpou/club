/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

/**
 * Classe filla de Soci.
 *
 * @author arran
 */
public class SociJunior extends Soci {

    /**
     * Cosntructor de la Classe Junior
     *
     * @param nom
     * @param dni
     */
    public SociJunior(String nom, String dni) {
        super(nom, dni);
    }

    /**
     * Calcul preu per excursio del soci junior
     *
     * @param baseExcursio
     * @return
     */
    @Override
    public float calculaPreuExcursio(float baseExcursio) {
        return 0;
    }

    /**
     * Calcul de la quota del soci junior
     *
     * @param quotaBase
     * @return
     */
    @Override
    public float calculaQuota(float quotaBase) {
        return quotaBase;
    }

    /**
     * Retorna la informaci del soci junir a una String
     *
     * @return
     */
    @Override
    public String toString() {
        return "Nom: " + this.getNom() + ", DNI: " + this.getDNI();
    }

}
