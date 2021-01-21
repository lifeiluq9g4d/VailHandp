/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Kukuh Rahingga P
 */
public class Perjalanan implements Serializable{
    private static int countP = 1;
    
    private final String idPerjalanan;
    private String tanggal;
    private int slotPelanggan;
    private PaketWisata paket;
    private ArrayList<Pelanggan> listPelanggan;
    
    // Constructor
    public Perjalanan(String tanggal, PaketWisata paket) {
        idPerjalanan = "P-" + (countP++);
        this.tanggal = tanggal;
        this.paket = paket;
        listPelanggan = new ArrayList();
    }
    
    // Other
    public void addPelanggan (Pelanggan p){
            listPelanggan.add(p);
    }
    
    public Pelanggan getPelanggan(String id){
        for (Pelanggan p : listPelanggan){
            if (p.getIdPelanggan().equals(id)){
                return p;
            }
        }
        return null;
    }
        
    public void removePelanggan(String id){
        for (Pelanggan p : listPelanggan){
            if (p.getIdPelanggan().equals(id)){
                listPelanggan.remove(p);
            }
        }  
    }
    
    // Setter & getter

    public String getIdPerjalanan() {
        return idPerjalanan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public int getSlotPelanggan() {
        return slotPelanggan;
    }

    public void setSlotPelanggan(int slotPelanggan) {
        this.slotPelanggan = slotPelanggan;
    }
    
    public PaketWisata getPaket() {
        return paket;
    }

    public void setPaket(PaketWisata paket) {
        this.paket = paket;
    }

    public String getListPelangganA() {
        String s = "";
        for (int i = 0; i < listPelanggan.size(); i++) {
            s += listPelanggan.get(i).getIdPelanggan()+ "\n";
        }
        return s;
    }
    
    @Override
    public String toString() {
        return "idPerjalanan           : " + idPerjalanan + "\n" +
               "tanggal                : " + tanggal + "\n" +
               "slotPelanggan          : " + slotPelanggan + "\n" +
               "paket                  : " + paket + "\n" +
               "list id pelanggan      : ";
    }
    
    public String toStringAll() {
        return idPerjalanan + " , " + tanggal + " , " + slotPelanggan;
    }
}
