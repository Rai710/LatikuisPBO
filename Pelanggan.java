/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kopikita;


public class Pelanggan {
    private String idPelanggan;
    private String nama;
    private String nomorMeja;
    
    private static int counter = 1;
    public Pelanggan(String nama, String nomorMeja){
        this.idPelanggan = String.format("C%03d", counter++);
        this.nama = nama;
        this.nomorMeja = nomorMeja;
    }
    public String getNama() {
        return nama;
    }
    public void cetakInfo() {
        System.out.println("ID: " + idPelanggan + " | Nama: " + nama + " | Meja: " + nomorMeja);
    }
}
