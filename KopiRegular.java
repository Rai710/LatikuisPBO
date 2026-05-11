/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kopikita;

public class KopiRegular extends PesananKopi {

    public KopiRegular(double hargaDasar) throws DataPesananTidakValidException {
        super("Kopi Regular", hargaDasar);
    }

    @Override
    public double hitungTotalHarga() {
        return hargaDasar;
    }
}
