/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Ressa Fatah
 */
public class PaketWisata {
    private static int countPW = 1;
    
    private final String idPaket;
    private String namaPaket;
    private String durasi;
    private String domisili;
    private int maxPelanggan;
    private double harga;
    private ArrayList<TempatWisata> daftarTujuanWisata;

    public PaketWisata(String namaPaket, String durasi, String domisili, double harga, int maxPelanggan) {
        idPaket = "PW-" + (countPW++);
        this.namaPaket = namaPaket;
        this.durasi = durasi;
        this.domisili = domisili;
        this.harga = harga;
        this.maxPelanggan = maxPelanggan;
        daftarTujuanWisata = new ArrayList();
    }
 
    // Method
    public void addTempatWisata(TempatWisata tw){
            daftarTujuanWisata.add(tw);      
    }
    
    public TempatWisata getTempatWisata(String id){
        for (TempatWisata tw : daftarTujuanWisata) {
            if (tw.getIdTempatWisata().equals(id)) {
                return tw;
            }
        }
        return null;
    }
    
    public void removeTempatWisata(String id){
        for (TempatWisata tw : daftarTujuanWisata){
            if (tw.getIdTempatWisata().equals(id)){
                daftarTujuanWisata.remove(tw);
            }
        }
    }
    
    
    // setter & getter
    public String getIdPaket() {
        return idPaket;
    }
    
    public String getNamaPaket() {
        return namaPaket;
    }

    public void setNamaPaket(String namaPaket) {
        this.namaPaket = namaPaket;
    }

    public String getDomisili() {
        return domisili;
    }

    public void setDomisili(String domisili) {
        this.domisili = domisili;
    }

    public String getDurasi() {
        return durasi;
    }

    public void setDurasi(String durasi) {
        this.durasi = durasi;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    } 

    public int getMaxPelanggan() {
        return maxPelanggan;
    }

    public void setMaxPelanggan(int maxPelanggan) {
        this.maxPelanggan = maxPelanggan;
    }
    
    public String getListTujuanWisata() {
        String s = "";
        for (int i = 0; i < daftarTujuanWisata.size(); i++) {
            s += daftarTujuanWisata.get(i).getIdTempatWisata() + "\n";
        }
        return s;
    }
    
    @Override
    public String toString() {
         return "idPaket                : " + idPaket + "\n" +
                "namaPaket              : " + namaPaket + "\n" +
                "durasi                 : " + durasi + "\n" +
                "domisili               : " + domisili + "\n" +
                "maxPelanggan           : " + maxPelanggan + "\n" +
                "harga                  : " + harga;
    }
    
    public String toStringAll() {
        return idPaket + " , " + namaPaket + " , " + durasi + " , " + domisili + " , " + maxPelanggan + " , " + harga;
    }
}
