/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import prog2.vista.ExcepcioClub;

/**
 *
 * @author arran
 */
public class ClubUB {

    private String _nomClub;
    private LlistaSocis _llistaSocis;

    // Constants
    public static final float PREU_PER_EXCURSIO = 20;
    public static final float QUOTA_MENSUAL = 25;
    public static final float DESCOMPTE_EXCURSIO = 0.2f;
    public static final float DESCOMPTE_QUOTA = 0.3f;

    public ClubUB(String nom) {
        _nomClub = nom;
        _llistaSocis = new LlistaSocis();
    }

    public String getNomClub() {
        return _nomClub;
    }

    public void setNomClub(String nomClub) {
        _nomClub = nomClub;
    }

    public void cambiarNom(Soci soci, String nom) {
        if (soci instanceof SociFederat) {
            SociFederat s = (SociFederat) soci;
            s.setNom(nom);
        } else if (soci instanceof SociEstandard) {
            SociEstandard s = (SociEstandard) soci;
            s.setNom(nom);
        } else {
            SociJunior s = (SociJunior) soci;
            s.setNom(nom);
        }
    }
    public float calculaQuota(Soci soci, int num) throws ExcepcioClub {
        if (soci instanceof SociFederat) {
            SociFederat sf = (SociFederat) soci;
            return (sf.calculaQuota(QUOTA_MENSUAL) * (DESCOMPTE_QUOTA) + sf.getFederacio().getPreu()) + num * (sf.calculaPreuExcursio(PREU_PER_EXCURSIO) * DESCOMPTE_EXCURSIO);
        } else if (soci instanceof SociEstandard) {
            SociEstandard se = (SociEstandard) soci;
            return se.calculaQuota(QUOTA_MENSUAL) + (num * (se.calculaPreuExcursio(PREU_PER_EXCURSIO) + se.getAsseguranca().getPreu()));
        } else if (soci instanceof SociJunior){
            SociJunior sj = (SociJunior) soci;
            return sj.calculaQuota(QUOTA_MENSUAL);
        }else{
            throw new ExcepcioClub("ERROR AL RECONÈIXER EL TIPUS DE SOCI");
        }
    }

    public void modificarAsseguranca(String dni, String tipus) throws ExcepcioClub {
        
        Soci soci;
        boolean trobat = false;
        for (int i = 0; i < this._llistaSocis.getSize(); i++) {
            if (this._llistaSocis.getAt(i).getDNI().equals(dni)) {
                trobat = true;
                soci = this._llistaSocis.getAt(i);
                if (soci instanceof SociEstandard) {
                    SociEstandard se = (SociEstandard) soci;
                    se.comprova(tipus);
                    se.getAsseguranca().setTipus(tipus);

                } else {
                    throw new ExcepcioClub("EL TIPUS DE SOCI ÉS INVÀLID");
                }
            }
        }
    
        if(trobat == false){
            throw new ExcepcioClub("SOCI NO TROBAT");
        }
    }

    public void comprovaNumeroExcursions(int n) throws ExcepcioClub {
        if (n < 0 || n > 31) {
            throw new ExcepcioClub("NUMERO DE EXCURSIONS INCORRECTE");
        }
    }
    


    public void guardarDades(String path) throws IOException {
        File fitxer = new File(path);
        FileOutputStream fout;
        ObjectOutputStream oos;
        try {
            fout = new FileOutputStream(fitxer);
            oos = new ObjectOutputStream(fout);
            oos.writeObject(_llistaSocis);
        } catch (IOException e) {
            throw e = new IOException("ERROR AL GUARDAR EL FITXER");
        }
        oos.close();
        fout.close();

    }

    public LlistaSocis carregarDades(String path) throws IOException, ClassNotFoundException {
        File fitxer = new File(path);
        FileInputStream fin;
        ObjectInputStream ois;
        try {
            fin = new FileInputStream(fitxer);
            ois = new ObjectInputStream(fin);
            _llistaSocis = (LlistaSocis) ois.readObject();
        } catch (IOException e) {
            throw e = new IOException("ERROR AL RECUPERAR EL FITXER");
        }
        fin.close();
        ois.close();
        return _llistaSocis;

    }
    
    

}
