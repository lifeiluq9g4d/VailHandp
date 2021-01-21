/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author Ressa Fatah
 */
public class TempatWisata implements Serializable{
    private static int countTW = 1;
    
    private final String idTempatWisata;
    private String namaWisata;
    private String lokasiWisata;

    // Constructor
    public TempatWisata(String namaWisata, String lokasiWisata) {
        idTempatWisata = "TW-" + (countTW++);
        this.namaWisata = namaWisata;
        this.lokasiWisata = lokasiWisata;
    }

    // Setter and Getter
    public String getIdTempatWisata() {
        return idTempatWisata;
    }
    
    public String getNamaWisata() {
        return namaWisata;
    }

    public void setNamaWisata(String namaWisata) {
        this.namaWisata = namaWisata;
    }

    public String getLokasiWisata() {
        return lokasiWisata;
    }

    public void setLokasiWisata(String lokasiWisata) {
        this.lokasiWisata = lokasiWisata;
    }

    @Override
    public String toString() {
        return "idTempatWisata : " + idTempatWisata + "\n" +
               "namaWisata     : " + namaWisata + "\n" +
               "lokasiWisata   : " + lokasiWisata;
    }
    
    public String toStringAll() {
        return idTempatWisata + " , " + namaWisata + " , " + lokasiWisata;
    }
}
