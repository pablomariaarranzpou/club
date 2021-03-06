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
 * Classe ClubUB això serà el pont entre la vista i les dades
 *
 * @author arran
 */
public class ClubUB {

    private String _nomClub;
    private LlistaSocis _llistaSocis;

    // CONSTANTS
    /**
     * CONSTANT DE PREU D´EXCURSIÓ
     */
    public static final float PREU_PER_EXCURSIO = 20;

    /**
     * CONSTANT DE QUOTA MENSUAL
     */
    public static final float QUOTA_MENSUAL = 25;

    /**
     * DESCOMPTE 20% EXCURSIONS
     */
    public static final float DESCOMPTE_EXCURSIO = 0.2f;

    /**
     * DESCOMPTE 30% QUOTA
     */
    public static final float DESCOMPTE_QUOTA = 0.3f;

    /**
     *
     * @param nom
     */
    public ClubUB(String nom) {
        _nomClub = nom;
        _llistaSocis = new LlistaSocis();
    }

    /**
     *
     * @return Nom del Club
     */
    public String getNomClub() {
        return _nomClub;
    }

    /**
     * Actualitza el nom del club
     *
     * @param nomClub
     */
    public void setNomClub(String nomClub) {
        _nomClub = nomClub;
    }

    /**
     * Canvia el nom d´un soci amb dni concret.
     *
     * @param dni
     * @param nouNom
     * @throws ExcepcioClub
     */
    public void canviarNomSoci(String dni, String nouNom) throws ExcepcioClub {
        Soci soci = _llistaSocis.getSoci(dni);
        soci.setNom(nouNom);
    }

    /**
     * Calcula la factura mensual d´un soci amb dni concret
     *
     * @param dni
     * @param num
     * @return
     * @throws ExcepcioClub
     */
    public float calculaFactura(String dni, int num) throws ExcepcioClub {
        Soci soci = _llistaSocis.getSoci(dni);
        return soci.calculaQuota(QUOTA_MENSUAL) + (num * soci.calculaPreuExcursio(PREU_PER_EXCURSIO));
    }

    /**
     * Modifica l´assegurança d´un soci amb un dni concret
     *
     * @param dni
     * @param tipus
     * @throws ExcepcioClub
     */
    public void modificarAsseguranca(String dni, String tipus) throws ExcepcioClub {
        Soci soci = _llistaSocis.getSoci(dni);

        if (soci instanceof SociEstandard) {
            SociEstandard se = (SociEstandard) soci;
            se.modificarAsseguranca(tipus);
        } else {
            throw new ExcepcioClub("El tipus de soci és invàlid.");
        }

    }

    /**
     * Comprova si fa més d´una excursio al dia en un mes.
     *
     * @param n
     * @throws ExcepcioClub
     */
    public void comprovaNumeroExcursions(int n) throws ExcepcioClub {
        if (n < 0 || n > 31) {
            throw new ExcepcioClub("Número d'excursions incorrecte.");
        }
    }

    /**
     * Afegeix Soci federat a llista socis.
     *
     * @param nom
     * @param dni
     * @param preu
     * @param nomFederacio
     * @throws ExcepcioClub
     */
    public void afegirSociFederat(String nom, String dni, float preu, String nomFederacio) throws ExcepcioClub {
        Federacio federacio = new Federacio(nomFederacio, preu);
        Soci soci = new SociFederat(nom, dni, federacio);
        _llistaSocis.addSoci(soci);
    }

    /**
     * Afegeix Soci estandard a llista socis.
     *
     * @param nom
     * @param dni
     * @param tipus
     * @param preu
     * @throws ExcepcioClub
     */
    public void afegirSociEstandard(String nom, String dni, String tipus, float preu) throws ExcepcioClub {
        Asseguranca asseguranca = new Asseguranca(tipus, preu);
        Soci soci = new SociEstandard(nom, dni, asseguranca);
        _llistaSocis.addSoci(soci);
    }

    /**
     * Afegeix Soci Junior a llista socis.
     *
     * @param nom
     * @param dni
     * @throws ExcepcioClub
     */
    public void afegirSociJunior(String nom, String dni) throws ExcepcioClub {
        Soci soci = new SociJunior(nom, dni);
        _llistaSocis.addSoci(soci);
    }

    /**
     * Guarda les dades a un fitxer.
     *
     * @param path
     * @throws IOException
     * @throws ExcepcioClub
     */
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

    /**
     * Recupera les dades d´un fitxer
     *
     * @param path
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws ExcepcioClub
     */
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

    /**
     * Retorna en una string la llista de socis
     *
     * @return
     */
    public String llistaSocisToString() {
        return _llistaSocis.toString();
    }

    /**
     * Elimina un soci d´una posició en concret
     *
     * @param posicio
     * @throws ExcepcioClub
     */
    public void eliminarSoci(int posicio) throws ExcepcioClub {
        _llistaSocis.removeSoci(_llistaSocis.getAt(posicio));
    }
}
