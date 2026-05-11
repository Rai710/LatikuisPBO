/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kopikita;

public class KopiSpesial extends PesananKopi implements Refill {

    public KopiSpesial(double hargaDasar) throws DataPesananTidakValidException  {
        super("Kopi Spesial", hargaDasar);
    }
    
    @Override
    public double hitungTotalHarga() {
        return hargaDasar + 10000;
    }

    @Override
    public void cetakInfoRefill() {
        System.out.println("Gratis Refill Sekali KopiKita");
    }
}
