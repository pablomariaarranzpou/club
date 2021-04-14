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
public class ClubUB {
    
    private String nomClub;
    private LlistaSocis _llistaSocis;
    
    // Constants
    public static final float PREU_PER_EXCURSIO = 20;
    public static final float QUOTA_MENSUAL = 25;
    public static final float DESCOMPTE_EXCURSIO = 0.2f;
    public static final float DESCOMPTE_QUOTA = 0.3f;
    
    public ClubUB(String nom) {
        this.nomClub = nom;
        this._llistaSocis = new LlistaSocis();
    }
    
    public String getNomClub() {
        return nomClub;
    }

    public void setNomClub(String nomClub) {
        this.nomClub = nomClub;
    }

    public LlistaSocis getLlistaSocis() {
        return _llistaSocis;
    }

    public void setLlistaSocis(LlistaSocis _llistaSocis) {
        this._llistaSocis = _llistaSocis;
    }

    
    
    
    
  
    
}
