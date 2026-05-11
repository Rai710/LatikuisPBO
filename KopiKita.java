/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package kopikita;

import java.util.Scanner;

public class KopiKita {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Array biasa sebagai keranjang kasir
        Pelanggan[] dataPelanggan = new Pelanggan[100];
        PesananKopi[] dataKopi = new PesananKopi[100];
        
        int jumlahPesanan = 0; 
        
        while (true) { 
            // Tampilkan menu utama [cite: 44]
            System.out.println("\n=== KASIR KopiKita ===");
            System.out.println("1. Tambah Pesanan\n2. Keluar");
            System.out.print("Pilih menu: ");
            String pilihan = input.nextLine();

            // Terus minta input sampai user memilih keluar [cite: 44]
            if (pilihan.equals("2")) break; 
            
            if (pilihan.equals("1")) {
                if (jumlahPesanan >= 100) {
                    System.out.println("[ERROR] Kapasitas pesanan penuh!");
                    continue;
                }

                try {
                    // Urutan input sesuai Aturan 6 [cite: 45-50]
                    System.out.print("Nama: ");
                    String nama = input.nextLine(); 
                    
                    System.out.print("Nomor Meja: ");
                    String meja = input.nextLine();
                    
                    // Validasi nomor meja langsung setelah diinput [cite: 48]
                    if (!meja.matches("\\d+")) {
                        throw new DataPesananTidakValidException("[ERROR] Nomor meja hanya boleh berisi angka!");
                    }

                    System.out.print("Harga Dasar: ");
                    double harga = Double.parseDouble(input.nextLine()); 
                    
                    System.out.print("Jenis Kopi (1. Regular / 2. Spesial): ");
                    String jenis = input.nextLine(); 

                    PesananKopi pesanan;
                    if (jenis.equals("1")) {
                        pesanan = new KopiRegular(harga);
                    } else if (jenis.equals("2")) {
                        pesanan = new KopiSpesial(harga);
                    } else {
                        System.out.println("[ERROR] Jenis salah!"); 
                        continue; 
                    }

                    // Masukkan ke array
                    dataPelanggan[jumlahPesanan] = new Pelanggan(nama, meja);
                    dataKopi[jumlahPesanan] = pesanan;
                    jumlahPesanan++; 
                    
                    System.out.println("[OK] Pesanan berhasil ditambahkan!");

                } catch (DataPesananTidakValidException e) {
                    // Jika ada data tidak valid: cetak error, program lanjut berjalan [cite: 51]
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println("[ERROR] Input salah/bukan angka!");
                }
            }
        }

        // Setelah user keluar, tampilkan rekap [cite: 52]
        System.out.println("\n=== REKAP PESANAN ===");
        for (int i = 0; i < jumlahPesanan; i++) {
            System.out.println("Pelanggan\t: " + dataPelanggan[i].getNama());
            System.out.println("Pesanan\t\t: " + dataKopi[i].getNamaKopi());
            System.out.println("Total\t\t: Rp " + (long) dataKopi[i].hitungTotalHarga());
            
            // Info refill khusus KopiSpesial [cite: 52]
            if (dataKopi[i] instanceof Refill) {
                ((Refill) dataKopi[i]).cetakInfoRefill();
            }
            System.out.println("-------------------------");
        }
        
        input.close();
    }
}