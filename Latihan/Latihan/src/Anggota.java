import java.util.Objects; 

public class Anggota {
    private String idAnggota; 
    private String nama; 
    private String tipe; 


public Anggota(String idAnggota, String nama, String tipe) {
    this.idAnggota = idAnggota; 
    this.nama = nama; 
    this.tipe = tipe; 
}

public String getIdAnggota() {
    return idAnggota; 
}

public String getNama() {
    return nama; 
}
 public String getTipe() {
    return tipe; 
 }

@Override 
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o .getClass()) return false; 
    Anggota anggota = (Anggota) o; 

    return Objects.equals (idAnggota, anggota.idAnggota);
}

 @Override
    public int hashCode() {
        return Objects.hash(idAnggota);
    }
}

