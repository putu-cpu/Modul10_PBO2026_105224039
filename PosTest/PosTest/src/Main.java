import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // data film 
        Map<String, Film> jadwalFilm = new HashMap<>();
        jadwalFilm.put("F01", new Film("Jumanji", 45000));
        jadwalFilm.put("F02", new Film("Fast and Furious", 40000));
        jadwalFilm.put("F03", new Film("Inception", 35000));

        // Set untuk validasi duplikasi kursi 
        Set<String> kursiTerisi = new HashSet<>();

        //List untuk Riwayat Transaksi Berurutan
        List<Pesanan> riwayatTransaksi = new ArrayList<>();

        System.out.println("=== SIMULASI PROSES PEMESANAN TIKET ===\n");

        //Nama, Kode Film, Kode Kursi
        String[][] simulasiInput = {
          {"Budi", "F01", "A1"},    
          {"Siti", "F01", "B4"},   
          {"Andi", "F02", "A1"},    
          {"Dewi", "F03", "C5"}     
        };

        // Proses Loop Simulasi
        for (String[] input : simulasiInput) {
            String nama = input[0];
            String kodeFilm = input[1];
         String kursi = input[2];

        System.out.println("Mencoba memesan: " + nama + " (" + kodeFilm + " - Kursi " + kursi + ")");

        //  Cek kode film di Map
            if (!jadwalFilm.containsKey(kodeFilm)) {
                System.out.println("-> GAGAL: Kode film tidak ditemukan!\n");
                continue;
            }

            Film filmDipilih = jadwalFilm.get(kodeFilm);

            // Cek keunikan kursi di Set
            if (!kursiTerisi.add(kursi)) {
                System.out.println("-> GAGAL: Kursi " + kursi + " sudah dipesan pelanggan lain!\n");
            } else {
                // Masukkan ke List jika sukses
                Pesanan pesananBaru = new Pesanan(nama, filmDipilih, kursi);
                riwayatTransaksi.add(pesananBaru);
                System.out.println("-> SUKSES: Tiket berhasil dipesan.\n");
            }
        }

        // Cetak Seluruh Riwayat Transaksi
        System.out.println("=== RIWAYAT TRANSAKSI BERURUTAN ===");
        if (riwayatTransaksi.isEmpty()) {
            System.out.println("Belum ada transaksi sukses.");
        } else {
            for (Pesanan p : riwayatTransaksi) {
                p.cetakDetail();
            }
        }
    }
}

