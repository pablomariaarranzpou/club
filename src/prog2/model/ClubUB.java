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

    public void CambiarNom(Soci soci, String nom) {
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
    public float CalculaQuota(Soci soci, int num) throws ExcepcioClub {
        if (soci instanceof SociFederat) {
            SociFederat sf = (SociFederat) soci;
            return (sf.calculaQuota(QUOTA_MENSUAL) * (DESCOMPTE_QUOTA) + sf.getFederacio().getPreu()) + num * (sf.calculaPreuExcursio(PREU_PER_EXCURSIO) * DESCOMPTE_EXCURSIO);
        } else if (soci instanceof SociEstandard) {
            SociEstandard se = (SociEstandard) soci;
            return (num * (se.calculaPreuExcursio(PREU_PER_EXCURSIO) + se.getAsseguranca().getPreu())) + se.calculaQuota(QUOTA_MENSUAL);
        } else {
            SociJunior sj = (SociJunior) soci;
            return sj.calculaQuota(QUOTA_MENSUAL);
        }
    }

    public void ModificarAsseguranca(Soci soci, String tipus) throws ExcepcioClub {
        if (soci instanceof SociEstandard) {
            SociEstandard se = (SociEstandard) soci;
            try {
                se.comprova(tipus);
                se.getAsseguranca().setTipus(tipus);

            } catch (ExcepcioClub e) {
                throw e;
            }
        } else {
            throw new ExcepcioClub("EL TIPUS DE SOCI ÉS INVÀLID");
        }

    }

    public void ComprovaNumeroExcursions(int numero) throws ExcepcioClub {
        if (numero > 31 || numero < 0) {
            throw new ExcepcioClub("NUMERO DE EXCURSIONS INCORRECTE");
        }
    }


    public void guardarDades(String cami) throws IOException {
        File fitxer = new File(cami);
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

    public LlistaSocis carregarDades(String camiOrigen) throws IOException, ClassNotFoundException {
        File fitxer = new File(camiOrigen);
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
