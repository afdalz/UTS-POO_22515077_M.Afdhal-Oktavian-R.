public class Pelanggan {
    private String idPelanggan;
    private String namaPelanggan;
    private String nomorTelepon;

    public Pelanggan(String idPelanggan, String namaPelanggan, String nomorTelepon) {
        this.idPelanggan = idPelanggan;
        this.namaPelanggan = namaPelanggan;
        this.nomorTelepon = nomorTelepon;
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

    public void tampilkanInfoPelanggan() {
        System.out.println("ID Pelanggan: " + idPelanggan + " | Nama: " + namaPelanggan + " | Telp: " + nomorTelepon);
    }
}
