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

    public void canviarNomSoci(String dni, String nouNom) throws ExcepcioClub {
        Soci soci = _llistaSocis.getSoci(dni);
        soci.setNom(nouNom);
    }

    public float calculaFactura(String dni, int num) throws ExcepcioClub {
        Soci soci = _llistaSocis.getSoci(dni);
        return soci.calculaQuota(QUOTA_MENSUAL) + (num * soci.calculaPreuExcursio(PREU_PER_EXCURSIO));
    }

    public void modificarAsseguranca(String dni, String tipus) throws ExcepcioClub {
        Soci soci = _llistaSocis.getSoci(dni);

        if (soci instanceof SociEstandard) {
            SociEstandard se = (SociEstandard) soci;
            se.modificarAsseguranca(tipus);
        } else {
            throw new ExcepcioClub("El tipus de soci és invàlid.");
        }

    }

    public void comprovaNumeroExcursions(int n) throws ExcepcioClub {
        if (n < 0 || n > 31) {
            throw new ExcepcioClub("Número d'excursions incorrecte.");
        }
    }

    public void afegirSociFederat(String nom, String dni, float preu, String nom_fede) throws ExcepcioClub {
        Soci soci = new SociFederat(nom, dni, preu, nom_fede);
        _llistaSocis.addSoci(soci);
    }

    public void afegirSociEstandard(String nom, String dni, String tipus, float preu_asseg) throws ExcepcioClub {
        Soci soci = new SociEstandard(nom, dni, tipus, preu_asseg);
        _llistaSocis.addSoci(soci);
    }

    public void afegirSociJunior(String nom, String dni) throws ExcepcioClub {
        Soci soci = new SociJunior(nom, dni);
        _llistaSocis.addSoci(soci);
    }

    public void guardarDades(String path) throws IOException, ExcepcioClub {
        File fitxer = new File(path);
        FileOutputStream fout;
        ObjectOutputStream oos;

        fout = new FileOutputStream(fitxer);
        oos = new ObjectOutputStream(fout);
        oos.writeObject(_llistaSocis);
        oos.close();
        fout.close();
    }

    public LlistaSocis carregarDades(String path) throws IOException, ClassNotFoundException, ExcepcioClub {
        File fitxer = new File(path);
        FileInputStream fin;
        ObjectInputStream ois;

        fin = new FileInputStream(fitxer);
        ois = new ObjectInputStream(fin);
        _llistaSocis = (LlistaSocis) ois.readObject();
        fin.close();
        ois.close();

        return _llistaSocis;
    }

    public String llistaSocisToString() {
        return _llistaSocis.toString();
    }

    public void eliminarSoci(int posicio) throws ExcepcioClub {
        Soci soci = _llistaSocis.getAt(posicio);
        _llistaSocis.removeSoci(soci);
    }
}
