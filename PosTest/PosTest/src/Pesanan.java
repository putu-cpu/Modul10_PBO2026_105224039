public class Pesanan {
    private String namaPemesan;
    private Film film;
    private String kodeKursi;

    public Pesanan(String namaPemesan, Film film, String kodeKursi) {
        this.namaPemesan = namaPemesan;
        this.film = film;
        this.kodeKursi = kodeKursi;
    }

    public void cetakDetail() {
        System.out.printf("- Pemesan: %-10s | Film: %-20s | Kursi: %-3s | Harga: Rp %,d\n", 
                namaPemesan, film.getJudul(), kodeKursi, film.getHarga());
    }
}



