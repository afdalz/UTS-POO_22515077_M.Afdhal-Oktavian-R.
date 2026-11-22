public class Menu {
    private String kodeMenu;
    private String namaMenu;
    private double harga;

    public Menu(String kodeMenu, String namaMenu, double harga) {
        this.kodeMenu = kodeMenu;
        this.namaMenu = namaMenu;
        setHarga(harga);
    }

    public String getKodeMenu() {
        return kodeMenu;
    }

    public void setKodeMenu(String kodeMenu) {
        this.kodeMenu = kodeMenu;
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public void setNamaMenu(String namaMenu) {
        this.namaMenu = namaMenu;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        if (harga > 0) {
            this.harga = harga;
        } else {
            System.out.println("Peringatan: Harga harus lebih besar dari 0!");
        }
    }

    public void tampilkanInfoMenu() {
        System.out.println("Kode: " + kodeMenu + " | Nama: " + namaMenu + " | Harga: Rp " + harga);
    }
}