/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

/**
 *
 * @author arran
 */
public class SociJunior extends Soci {

    /**
     *
     * @param nom
     * @param dni
     */
    public SociJunior(String nom, String dni) {
        super(nom, dni);
    }

    @Override
    public float calculaPreuExcursio(float baseExcursio) {
        return 0;
    }

    @Override
    public float calculaQuota(float quotaBase) {
        return quotaBase;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Nom: " + this.getNom() + ", DNI: " + this.getDNI();
    }

}
