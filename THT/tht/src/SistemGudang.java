import java.util.*;

public class SistemGudang {

    // Database Barang
    private Map<String, Barang> databaseBarang;

    // Kategori unik
    private Set<String> kategoriUnik;

    // Riwayat transaksi
    private List<String> riwayat;

    public SistemGudang() {
        databaseBarang = new HashMap<>();
        kategoriUnik = new HashSet<>();
        riwayat = new ArrayList<>();
    }

    // Tambah barang baru
    public void tambahBarangBaru(String id, String nama, String kategori, int stok) {

        Barang barang = new Barang(id, nama, kategori, stok);

        databaseBarang.put(id, barang);
        kategoriUnik.add(kategori);

        riwayat.add("Barang Baru: " + id + " - " + nama +
                    " (" + kategori + ") stok awal " + stok);
    }

    // Tambah stok
    public void tambahStok(String id, int jumlah) {

        if (databaseBarang.containsKey(id)) {

            Barang barang = databaseBarang.get(id);

            barang.setStok(barang.getStok() + jumlah);

            riwayat.add("Barang Masuk: " + id +
                        " ditambah " + jumlah + " unit");

            System.out.println("Stok berhasil ditambah.");
        } else {
            System.out.println("ID barang tidak ditemukan!");
        }
    }

    // Kurangi stok
    public void kurangiStok(String id, int jumlah) {

        if (!databaseBarang.containsKey(id)) {
            System.out.println("ID barang tidak ditemukan!");
            return;
        }

        Barang barang = databaseBarang.get(id);

        if (barang.getStok() >= jumlah) {

            barang.setStok(barang.getStok() - jumlah);

            riwayat.add("Barang Keluar: " + id +
                        " dikurangi " + jumlah + " unit");

            System.out.println("Stok berhasil dikurangi.");
        } else {

            riwayat.add("Gagal Mengurangi Stok: " + id +
                        " (stok tidak mencukupi)");

            System.out.println("Gagal! Stok tidak mencukupi.");
        }
    }

    // Cetak laporan
    public void cetakLaporan() {

     System.out.println("\n===== LAPORAN GUDANG =====");

       System.out.println("\nDaftar Kategori:");
        for (String kategori : kategoriUnik) {
            System.out.println("- " + kategori);
     }

        System.out.println("\nData Barang:");
        for (Barang barang : databaseBarang.values()) {
            System.out.println(
                    barang.getIdBarang() + " | " +
                    barang.getNamaBarang() + " | " +
                    barang.getKategori() + " | Stok: " +
                    barang.getStok()
            );
        }

        System.out.println("\nRiwayat Transaksi:");
        for (String log : riwayat) {
            System.out.println(log);
        }
    }
}