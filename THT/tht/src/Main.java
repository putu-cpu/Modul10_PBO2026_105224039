public class Main {

    public static void main(String[] args) {

        SistemGudang gudang = new SistemGudang();

        // Daftarkan minimal 3 barang
        gudang.tambahBarangBaru("B01", "Laptop", "Elektronik", 10);
        gudang.tambahBarangBaru("B02", "Mouse", "Elektronik", 20);
        gudang.tambahBarangBaru("B03", "Meja", "Furniture", 5);

        // Tambah stok berhasil
        gudang.tambahStok("B01", 5);

        // Kurangi stok berhasil
        gudang.kurangiStok("B02", 10);

        // Kurangi stok gagal
        gudang.kurangiStok("B03", 20);

        // Cetak laporan
        gudang.cetakLaporan();
    }
}