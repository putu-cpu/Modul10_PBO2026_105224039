public class Barang {
    private String idBarang;
    private String namaBarang;
    private String kategori;
    private int stok;

    public Barang(String idBarang, String namaBarang, String kategori, int stok) {
        this.idBarang = idBarang;
        this.namaBarang = namaBarang;
        this.kategori = kategori;
        this.stok = stok;
    }

    public String getIdBarang() {
        return idBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public String getKategori() {
        return kategori;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
}