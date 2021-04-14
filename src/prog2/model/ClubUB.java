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
