package oracrud;

public class ListColumnMahasiswa {
    private String nim,nama,alamat;
    public void SetNim(String nim){
        this.nim = nim;
    }
    public String GetNim(){
        return this.nim;
    }

    public void SetNama(String nama){
        this.nama = nama;
    }
    public String GetNama(){
        return this.nama;
    }

    public void SetAlamat(String alamat){
        this.alamat = alamat;
    }
    public String GetAlamat(){
        return this.alamat;
    }
}
