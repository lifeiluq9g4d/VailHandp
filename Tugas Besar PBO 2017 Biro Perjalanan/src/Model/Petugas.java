/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Jeremi 
 */
public class Petugas extends Orang{
    private static int countE = 1;
    
    private final String idPetugas;
    private double gaji;
    private String jabatan;

    public Petugas(double gaji, String jabatan, String nama, String noHp, String alamat, String jenisKelamin, String tglLahir) {
        super(nama, noHp, alamat, jenisKelamin, tglLahir);
        idPetugas = "P-" + (countE++);
        this.gaji = gaji;
        this.jabatan = jabatan;
    }
    
    public String getIdPetugas() {
        return idPetugas;
    }

    public double getGaji() {
        return gaji;
    }

    public void setGaji(double gaji) {
        this.gaji = gaji;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    @Override
    public String toString() {
        return  "idPetugas    : " + idPetugas + "\n" +
                "nama         : " + getNama() + "\n" + 
                "gaji         : " + gaji + "\n" +
                "jabatan      : " + jabatan + "\n" +
                "noHp         : " + getNoHp() + "\n" +
                "alamat       : " + getAlamat() + "\n" +
                "jenisKelamin : " + getJenisKelamin() + "\n" +
                "tglLahir     : " + getTglLahir();

    }
    
    public String toStringAll() {
        return idPetugas + " , " + getNama() + " , " + gaji + " , " + jabatan + " , " + getNoHp() + " , " + getAlamat() + " , " + getJenisKelamin() + " , " + getTglLahir();
    }
    
    
}