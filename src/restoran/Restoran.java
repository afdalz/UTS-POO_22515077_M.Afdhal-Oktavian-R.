package restoran;
import java.util.ArrayList;
import java.util.List;

public class Restoran {
    private String namaRestoran;
    private String alamatRestoran;
    private List<Menu> listMenu;
    private List<Pelanggan> listPelanggan;

    // 1. Konstruktor (Menerima 2 parameter: Nama dan Alamat Restoran)
    public Restoran(String namaRestoran, String alamatRestoran) {
        this.namaRestoran = namaRestoran;
        this.alamatRestoran = alamatRestoran;
        this.listMenu = new ArrayList<>();
        this.listPelanggan = new ArrayList<>();
    }

    // Method untuk menambah menu
    public void tambahMenu(Menu menu) {
        listMenu.add(menu);
    }

    // Method untuk menambah pelanggan
    public void tambahPelanggan(Pelanggan pelanggan) {
        listPelanggan.add(pelanggan);
    }

    // 2. TAMBAHKAN INI: Method untuk mencari Menu berdasarkan kodeMenu
    public Menu cariMenu(String kodeMenu) {
        for (Menu m : listMenu) {
            if (m.getKodeMenu().equalsIgnoreCase(kodeMenu)) {
                return m; // Ketemu, kembalikan objek Menu
            }
        }
        return null; // Jika tidak ketemu
    }

    // 3. TAMBAHKAN INI: Method untuk mencari Pelanggan berdasarkan idPelanggan
    public Pelanggan cariPelanggan(String idPelanggan) {
        for (Pelanggan p : listPelanggan) {
            if (p.getIdPelanggan().equalsIgnoreCase(idPelanggan)) {
                return p; // Ketemu, kembalikan objek Pelanggan
            }
        }
        return null; // Jika tidak ketemu
    }

    // Method untuk menampilkan semua menu
    public void tampilkanSemuaMenu() {
        System.out.println("\n=== DAFTAR MENU " + namaRestoran.toUpperCase() + " ===");
        if (listMenu.isEmpty()) {
            System.out.println("Belum ada menu yang tersedia.");
        } else {
            for (Menu m : listMenu) {
                m.tampilkanInfoMenu();
            }
        }
    }

    // Method untuk menampilkan semua pelanggan
    public void tampilkanSemuaPelanggan() {
        System.out.println("\n=== DAFTAR PELANGGAN " + namaRestoran.toUpperCase() + " ===");
        if (listPelanggan.isEmpty()) {
            System.out.println("Belum ada data pelanggan.");
        } else {
            for (Pelanggan p : listPelanggan) {
                p.tampilkanInfoPelanggan();
            }
        }
    }
}