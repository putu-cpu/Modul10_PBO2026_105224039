import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set; 

public class Main {
    public static void main(String[] args) {
       
        // no 1
        Map<String, Buku> katalogBuku = new HashMap<>(); 

     Buku buku1 = new Buku  ("1234-567-89-190", "Harry Potter");
        Buku buku2 = new Buku("0987-76-543-130", "Narnia"); 
        Buku buku3 = new Buku("2567-76-887-098", "Lord Of The Rings"); 

        katalogBuku.put (buku1.getIsbn(), buku1); 
        katalogBuku.put(buku2.getIsbn(), buku2); 
        katalogBuku.put(buku3.getIsbn(), buku3); 

     
        // no2
      
        Set<Anggota> daftarAnggota = new HashSet<>(); 

       daftarAnggota.add(new Anggota ("101", "Lucy", "Mahasiswa")); 
        daftarAnggota.add(new Anggota  ("102", "Budi", "Dosen"));
        daftarAnggota.add(new Anggota ("103", "Emi", "Mahasiswa"));  
        

        System.out.println("=== DATA KATALOG BUKU ===");
        for (Buku bk : katalogBuku.values()) {
            System.out.println("- [" + bk.getIsbn() + "] " + bk.getJudul());
        }
        System.out.println("Total Buku di Katalog: " + katalogBuku.size());
        
        System.out.println(); 

        System.out.println("=== DATA ANGGOTA PERPUSTAKAAN ===");
        for (Anggota agt : daftarAnggota) {
            System.out.println("- [" + agt.getIdAnggota() + "] " + agt.getNama() + " (" + agt.getTipe() + ")");
        }
        System.out.println("Total Anggota Terdaftar (Tanpa Duplikat): " + daftarAnggota.size());

  
        // no 3
      
        LinkedList<String> antreanPinjam = new LinkedList<>();

        System.out.println("\n=== PROSES MASUK ANTREAN ===");

        // 1
            String data1 = "101#1234-567-89-190";
        System.out.println("Masuk: " + data1 + " (Mahasiswa -> Belakang)");
        antreanPinjam.addLast(data1);

        // 2
        String data2 = "103#0987-76-543-130";
         System.out.println("Masuk: " + data2 + " (Mahasiswa -> Belakang)");
        antreanPinjam.addLast(data2);

        // 3
        String data3 = "102#2567-76-887-098";
        System.out.println("Masuk  : " + data3 + " (Dosen -> POTONG KE DEPAN)");
        antreanPinjam.addFirst(data3);

        // 4
        String data4 = "101#0987-76-543-130";
        System.out.println("Masuk : " + data4 + " (Mahasiswa -> Belakang)");
        antreanPinjam.addLast(data4);

       
        System.out.println("\n=== KONDISI AKHIR ANTREAN PINJAM ===");
        int nomor = 1;
        for (String antrean : antreanPinjam) {
            System.out.println(nomor + ". " + antrean);
            nomor++;
        }


        System.out.println("\n=== PROSES EKSEKUSI/MELAYANI ANTREAN ===");
    //no 4 (collection)
        Set<String> bukuDipinjam = new HashSet<>();

        while (!antreanPinjam.isEmpty()) {
            String dataDilayani = antreanPinjam.pollFirst(); 
            
           String[] dataPecah = dataDilayani.split("#");
            String idAnggota = dataPecah[0];
            String isbnBuku   = dataPecah[1];

            System.out.println("\nMemproses Antrean -> ID: " + idAnggota + ", ISBN: " + isbnBuku);

            // Cek id Anggota terdaftar di HashSet Soal 2
            boolean anggotaValid = false;
            String namaAnggota = "";
            for (Anggota agt : daftarAnggota) {
                if (agt.getIdAnggota().equals(idAnggota)) {
                    anggotaValid = true;
                    namaAnggota = agt.getNama();
                     break;
                }
            }

            //  Cek isbn terdaftar di HashMap Katalog Soal 1
            boolean isbnValid = katalogBuku.containsKey(isbnBuku);

            // Eksekusi Logika Validasi
            if (!anggotaValid) {
                System.out.println("   [GAGAL] ID Anggota '" + idAnggota + "' tidak terdaftar di sistem.");
            } 
            else if(!isbnValid) {
                System.out.println("   [GAGAL] Buku dengan ISBN '" + isbnBuku + "' tidak ada di katalog.");
            } 
            // Cek apakah sedang dipinjam orang lain
            else if (bukuDipinjam.contains(isbnBuku)) {
                System.out.println("   [GAGAL] Buku '" + katalogBuku.get(isbnBuku).getJudul() + "' sedang dipinjam orang lain.");
            } 

            //kalo lolos
            else {

                bukuDipinjam.add(isbnBuku); // Catat ke collection khusus
                System.out.println("   [BERHASIL] " + namaAnggota + " berhasil meminjam buku '" + katalogBuku.get(isbnBuku).getJudul() + "'");
            }
        }

    //no 5 bonus
     System.out.println  ("\n=== DAFTAR ISBN BUKU YANG SEDANG DIPINJAM ===");
        System.out.println (bukuDipinjam);

            System.out.println("\n=== LAPORAN BUKU SEDANG DIPINJAM (A-Z) ===");

        //treeset
        Set<String> laporanTerurut = new java.util.TreeSet<>();
             for (String isbn : bukuDipinjam) {
           //cari objek
            Buku buku = katalogBuku.get(isbn);
            if (buku != null) {
                //simpan
        laporanTerurut.add(buku.getJudul() + " - [" + isbn + "]");
            }
        }

        for (String barisLaporan : laporanTerurut) {
            System.out.println("- " + barisLaporan);
        }
    }
}
