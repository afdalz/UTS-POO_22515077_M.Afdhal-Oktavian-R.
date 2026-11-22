package restoran;
public class Pelanggan {
    private String idPelanggan;
    private String namaPelanggan;
    private String nomorTelepon;
    private String alamat; // Konvensi Java menggunakan huruf kecil di awal untuk variabel (alamat)

    // PERBAIKAN 1: Tambahkan String alamat di dalam parameter konstruktor
    public Pelanggan(String idPelanggan, String namaPelanggan, String nomorTelepon, String alamat) {
        this.idPelanggan = idPelanggan;
        this.namaPelanggan = namaPelanggan;
        this.nomorTelepon = nomorTelepon;
        this.alamat = alamat; // PERBAIKAN 2: Gunakan this.alamat agar data tersimpan dengan benar
    }

    public String getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(String idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public void setNomorTelepon(String nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void tampilkanInfoPelanggan() {
        System.out.println("ID Pelanggan: " + idPelanggan + " | Nama: " + namaPelanggan + " | Telp: " + nomorTelepon + " | Alamat: " + alamat);
    }
}