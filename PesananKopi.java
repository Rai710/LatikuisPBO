/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kopikita; 

public abstract class PesananKopi {
    
    protected String namaKopi;
    protected double hargaDasar;

    public PesananKopi(String namaKopi, double hargaDasar) throws DataPesananTidakValidException {
        if (hargaDasar <= 0) {
            throw new DataPesananTidakValidException("[ERROR] Harga dasar harus lebih dari 0!");
        }
        this.namaKopi = namaKopi;
        this.hargaDasar = hargaDasar;
    }

    public String getNamaKopi() {
        return namaKopi;
    }

    public abstract double hitungTotalHarga();
}