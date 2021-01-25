/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Database.FileDatabase;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * Nama     : Jeremiah Hasudungan
 * NIM      : 1301154287 
 */
public class Aplikasi {
    private ArrayList<Petugas> daftarPetugas;
    private ArrayList<Pelanggan> daftarPelanggan;
    private ArrayList<Perjalanan> daftarPerjalanan;
    private ArrayList<PaketWisata> daftarPaketWisata;
    private ArrayList<TempatWisata> daftarTempatWisata;
    private FileDatabase save;
    
    // Method fungsi utama
    public Aplikasi(){
        daftarPetugas = new ArrayList();
        daftarPelanggan = new ArrayList();
        daftarPerjalanan = new ArrayList();
        daftarPaketWisata = new ArrayList();
        daftarTempatWisata = new ArrayList();
        save = new FileDatabase();
    }
    
    // Method Petugas --------------------
    public void createPetugas (double gaji, String jabatan, String nama, String noHp, String alamat, String jenisKelamin, String tglLahir){
        daftarPetugas.add(new Petugas(gaji, jabatan, nama, noHp, alamat, jenisKelamin, tglLahir));
    }
    
    public Petugas getPetugas (String id){
        return daftarPetugas.stream()
                .filter(e -> e.getIdPetugas().equals(id))
                .findFirst().orElse(null);
    }
 
    public Petugas getPetugas (int index){
        Petugas e = daftarPetugas.get(index);
        return e;
    }
    
    public void removePetugas(String id){
        for (Petugas e : daftarPetugas){
            if (e.getIdPetugas().equals(id)){
                daftarPetugas.remove(e);
            }
        }
    }
    
    // Method Pelanggan --------------------
    public void createPelanggan (String pekerjaan, String nama, String noHp, String alamat, String jenisKelamin, String tglLahir){
        daftarPelanggan.add(new Pelanggan(pekerjaan, nama, noHp, alamat, jenisKelamin, tglLahir));
    }
    
    public Pelanggan getPelanggan (String id){
        return daftarPelanggan.stream()
                .filter(e -> e.getIdPelanggan().equals(id))
                .findFirst().orElse(null);
    }
 
    public Pelanggan getPelanggan (int index){
        Pelanggan e = daftarPelanggan.get(index);
        return e;
    }
    
    public void removePelanggan(String id){
        for (Pelanggan e : daftarPelanggan){
            if (e.getIdPelanggan().equals(id)){
                daftarPelanggan.remove(e);
            }
        }
    }
        
    // Method Tempat Wisata --------------------
    public void createTempatWisata (String namaWisata, String lokasiWisata){
        daftarTempatWisata.add(new TempatWisata(namaWisata, lokasiWisata));
    }
    
    
    public TempatWisata getTempatWisata (String id){
        return daftarTempatWisata.stream()
                .filter(e -> e.getIdTempatWisata().equals(id))
                .findFirst().orElse(null);
    }
 
    public TempatWisata getTempatWisata (int index){
        TempatWisata tw = daftarTempatWisata.get(index);
        return tw;
    }
    
    public void removeTempatWisata(String id){
        for (TempatWisata e : daftarTempatWisata){
            if (e.getIdTempatWisata().equals(id)){
                daftarTempatWisata.remove(e);
            }
        }
    }
    
    // Method Paket Wisata --------------------
    public void createPaketWisata (String namaPaket, String durasi, String domisili, double harga, int maxPelanggan){
        daftarPaketWisata.add(new PaketWisata(namaPaket, durasi, domisili, harga, maxPelanggan));
    }
    
    public PaketWisata getPaketWisata (String id){
        return daftarPaketWisata.stream()
                .filter(e -> e.getIdPaket().equals(id))
                .findFirst().orElse(null);
    }
    
    public void removePaketWisata(String id){
        for (PaketWisata e : daftarPaketWisata){
            if (e.getIdPaket().equals(id)){
                daftarPaketWisata.remove(e);
            }
        }
    }
    
    public PaketWisata getSetPaket(String id) {
        PaketWisata i = getPaketWisata(id);
        if ((i != null) && (i instanceof PaketWisata)) {
            return i;
        } else {
            throw new IllegalStateException("Paket wisata tidak ada");
        }
    }
    
    
    public void assignTempatWisata(String idPW, String idTW){
        PaketWisata pw, pwCek;
        pwCek = getPaketWisata(idPW);
        if ((pwCek != null) && (pwCek instanceof PaketWisata)){
            pw = pwCek;
        } else {
            throw new IllegalStateException("Paket wisata tidak ada");
        }
    
        TempatWisata tw = getTempatWisata(idTW);
        if ((tw != null) && (tw instanceof TempatWisata)){
            if (pw.getTempatWisata(idTW) == null){
                pw.addTempatWisata(tw);
            } else {
                throw new IllegalStateException("Tempat wisata sudah ada");
            }
        } else {
            throw new IllegalStateException("Tempat wisata tidak ada");
        }
    }
    
    public void unassignTempatWisata (String idPW, String idTW){
        PaketWisata pw, pwCek;
        pwCek = getPaketWisata(idPW);
        if ((pwCek != null) && (pwCek instanceof PaketWisata)) {
            pw = pwCek;
        } else {
            throw new IllegalStateException("Paket wisata tidak ada");
        }
        pw.removeTempatWisata(idTW);
    }
 
    public String getListTujuanWisata(String idPW){
        PaketWisata pw, pwCek;
        String s = "";
        pwCek = getPaketWisata(idPW);
        if ((pwCek != null) && (pwCek instanceof PaketWisata)){
            pw = pwCek;
            s = pw.getListTujuanWisata();
            return s;
        } else {
            throw new IllegalStateException("Paket wisata tidak ada");
        }
    }
        
        
        // Method Perjalanan --------------------
    public void createPerjalanan (String tanggal, PaketWisata paket){
        daftarPerjalanan.add(new Perjalanan(tanggal, paket));
    }
    
    public Perjalanan getPerjalanan (String id){
        return daftarPerjalanan.stream()
                .filter(e -> e.getIdPerjalanan().equals(id))
                .findFirst().orElse(null);
    }
 
    public Perjalanan getPerjalanan (int index){
        Perjalanan p = daftarPerjalanan.get(index);
        return p;
    }
    
    public void removePerjalanan(String id){
        for (Perjalanan e : daftarPerjalanan){
            if (e.getIdPerjalanan().equals(id)){
                daftarPerjalanan.remove(e);
            }
        }
    }
    
    public void assignPelanggan (String idP, String idM){
        Perjalanan pl, plCek;
        plCek = getPerjalanan(idP);
        if ((plCek != null) && (plCek instanceof Perjalanan)){
            pl = plCek;
        } else {
            throw new IllegalStateException("Paket wisata tidak ada");
        }
        
        
        Pelanggan Mem = getPelanggan(idM);
        if ((Mem != null) && (Mem instanceof Pelanggan)){
            if (pl.getPelanggan(idM) == null){
                pl.addPelanggan(Mem);
            } else {
                throw new IllegalStateException("Pelanggan sudah ada");
            }
        } else {
            throw new IllegalStateException("pelanggan tidak ada");
        }
    }
    
    public void unassignPelanggan (String idP, String idM){
        Perjalanan pl, plCek;
        plCek = getPerjalanan(idP);
        if ((plCek != null) && (plCek instanceof Perjalanan)) {
            pl = plCek;
        } else {
            throw new IllegalStateException("Perjalanan tidak ada");
        }
        pl.removePelanggan(idM);
    }
    
    public String getListPelangganA(String idPW){
        Perjalanan p, pCek;
        String s = "";
        pCek = getPerjalanan(idPW);
        if ((pCek != null) && (pCek instanceof Perjalanan)){
            p = pCek;
            s = p.getListPelangganA();
            return s;
        } else {
            throw new IllegalStateException("Paket wisata tidak ada");
        }
    }
    
    
    //Tambahan 
    
    // View All Array
    public void viewListConsole(String[] list) {
        Arrays.stream(list).forEach(System.out::println);
    }
    
    public String[] getListPelanggan() {
        List idPel = daftarPelanggan.stream()
                .map(e -> e.toStringAll()).collect(Collectors.toList());
        return (String[]) idPel.stream().toArray(size -> new String[size]);
    }
    
    public String[] getListPetugas() {
        List idPet = daftarPetugas.stream()
                .map(e -> e.toStringAll()).collect(Collectors.toList());
        return (String[]) idPet.stream().toArray(size -> new String[size]);
    }
    
    public String[] getListTempatWisata() {
        List idTw = daftarTempatWisata.stream()
                .map(e -> e.toStringAll()).collect(Collectors.toList());
        return (String[]) idTw.stream().toArray(size -> new String[size]);
    }
    
    public String[] getListPaketWisata() {
        List idPw = daftarPaketWisata.stream()
                .map(e -> e.toStringAll()).collect(Collectors.toList());
        return (String[]) idPw.stream().toArray(size -> new String[size]);
    }
    
    public String[] getListPerjalanan() {
        List idP = daftarPerjalanan.stream()
                .map(e -> e.toStringAll()).collect(Collectors.toList());
        return (String[]) idP.stream().toArray(size -> new String[size]);
    }
    
    // View List Id
    public String viewIdPelanggan() {
        String s = "";
        for (Pelanggan m : daftarPelanggan) {
            s += m.getIdPelanggan()+ "\n";
        }
        return s;
    }
    
    public String viewIdPetugas() {
        String s = "";
        for (Petugas m : daftarPetugas) {
            s += m.getIdPetugas()+ "\n";
        }
        return s;
    }
    
    public String viewIdTempatWisata() {
        String s = "";
        for (TempatWisata m : daftarTempatWisata) {
            s += m.getIdTempatWisata()+ "\n";
        }
        return s;
    }
    
    public String viewIdPaketWisata() {
        String s = "";
        for (PaketWisata m : daftarPaketWisata) {
            s += m.getIdPaket()+ "\n";
        }
        return s;
    }
    
    public String viewIdPerjalanan() {
        String s = "";
        for (Perjalanan m : daftarPerjalanan) {
            s += m.getIdPerjalanan()+ "\n";
        }
        return s;
    }
    
    
    // Database Pelanggan
    public void loadPelanggan() throws FileNotFoundException, IOException {
        try {
            daftarPelanggan = (ArrayList<Pelanggan>) save.getObject("FilePelanggan.dat");
        } catch (FileNotFoundException ex) {
            File f = new File("FilePelanggan.dat");
            f.createNewFile();
        } catch (EOFException ex) {
            daftarPelanggan = new ArrayList<>();
        } catch (IOException | ClassNotFoundException ex) {
            throw new IOException("error " + ex.getMessage());
        }
    }

    public void savePelanggan() throws FileNotFoundException, IOException {
        try {
            save.saveObject(daftarPelanggan, "FilePelanggan.dat");
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException("file not found");
        } catch (IOException ex) {
            throw new IOException("error " + ex.getMessage());
        }
    }
    
    // Database Petugas    
    public void loadPetugas() throws FileNotFoundException, IOException {
        try {
            daftarPetugas = (ArrayList<Petugas>) save.getObject("FilePetugas.dat");
        } catch (FileNotFoundException ex) {
            File f = new File("FilePetugas.dat");
            f.createNewFile();
        } catch (EOFException ex) {
            daftarPetugas = new ArrayList<>();
        } catch (IOException | ClassNotFoundException ex) {
            throw new IOException("error " + ex.getMessage());
        }
    }

    public void savePetugas() throws FileNotFoundException, IOException {
        try {
            save.saveObject(daftarPetugas, "FilePetugas.dat");
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException("file not found");
        } catch (IOException ex) {
            throw new IOException("error " + ex.getMessage());
        }
    }
    
    // Database Tempat Wisata
    public void loadTempatWisata() throws FileNotFoundException, IOException {
        try {
            daftarTempatWisata = (ArrayList<TempatWisata>) save.getObject("FileTempatWisata.dat");
        } catch (FileNotFoundException ex) {
            File f = new File("FileTempatWisata.dat");
            f.createNewFile();
        } catch (EOFException ex) {
            daftarTempatWisata = new ArrayList<>();
        } catch (IOException | ClassNotFoundException ex) {
            throw new IOException("error " + ex.getMessage());
        }
    }

    public void saveTempatWisata() throws FileNotFoundException, IOException {
        try {
            save.saveObject(daftarTempatWisata, "FileTempatWisata.dat");
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException("file not found");
        } catch (IOException ex) {
            throw new IOException("error " + ex.getMessage());
        }
    }
    
    // Database Paket Wisata
    public void loadPaketWisata() throws FileNotFoundException, IOException {
        try {
            daftarPaketWisata = (ArrayList<PaketWisata>) save.getObject("FilePaketWisata.dat");
        } catch (FileNotFoundException ex) {
            File f = new File("FilePaketWisata.dat");
            f.createNewFile();
        } catch (EOFException ex) {
            daftarPaketWisata = new ArrayList<>();
        } catch (IOException | ClassNotFoundException ex) {
            throw new IOException("error " + ex.getMessage());
        }
    }

    public void savePaketWisata() throws FileNotFoundException, IOException {
        try {
            save.saveObject(daftarPaketWisata, "FilePaketWisata.dat");
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException("file not found");
        } catch (IOException ex) {
            throw new IOException("error " + ex.getMessage());
        }
    }
    
    // Database Perjalanan
    public void loadPerjalanan() throws FileNotFoundException, IOException {
        try {
            daftarPerjalanan = (ArrayList<Perjalanan>) save.getObject("FilePerjalanan.dat");
        } catch (FileNotFoundException ex) {
            File f = new File("FilePerjalanan.dat");
            f.createNewFile();
        } catch (EOFException ex) {
            daftarPerjalanan = new ArrayList<>();
        } catch (IOException | ClassNotFoundException ex) {
            throw new IOException("error " + ex.getMessage());
        }
    }

    public void savePerjalanan() throws FileNotFoundException, IOException {
        try {
            save.saveObject(daftarPerjalanan, "FilePerjalanan.dat");
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException("file not found");
        } catch (IOException ex) {
            throw new IOException("error " + ex.getMessage());
        }
    }
}
