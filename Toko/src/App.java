import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Membuat daftar barang (Polimorphisme)
        ArrayList<Barang> daftarBarang = new ArrayList<>();
        daftarBarang.add(new Elektronik());
        daftarBarang.add(new NonElektronik());

        // Menampilkan list barang
        System.out.println(" ");
        System.out.println("=======List Barang======");
        for (Barang barang : daftarBarang) {
            barang.tampilkanInfo();
        }

        //Exception Handling
        try {
            // Memasukkan data pelanggan
            System.out.print("\nNama Pelanggan: ");
            String namaPelanggan = scanner.nextLine();

            // Memasukkan data barang yang dibeli
            Map<Barang, Integer> keranjangBelanja = new HashMap<>();

            while (true) {
                System.out.print("Nama Barang (atau ketik '-' untuk menyelesaikan pesanan): ");
                String namaBarang = scanner.nextLine();

                if (namaBarang.equalsIgnoreCase("-")) {
                    break;
                }

                // Mencari barang yang sesuai dengan input
                Barang barangDibeli = null;
                for (Barang barang : daftarBarang) {
                    if (barang.nama.equalsIgnoreCase(namaBarang)) {
                        barangDibeli = barang;
                        break;
                    }
                }

                // Jika barang ditemukan, memasukkan ke dalam keranjang belanja
                if (barangDibeli != null) {
                    System.out.print("Jumlah Beli: ");
                    int jumlahBeli = scanner.nextInt();
                    scanner.nextLine(); // Membuang newline

                    keranjangBelanja.put(barangDibeli, jumlahBeli);
                } else {
                    throw new InputException("Barang tidak ditemukan.");
                }
            }

            // Menampilkan output
            System.out.println("\nOutput:");
            System.out.println("No. Faktur: " + System.currentTimeMillis());
            System.out.println("Nama Pelanggan: " + namaPelanggan);

            long totalBayar = 0;

            for (Map.Entry<Barang, Integer> entry : keranjangBelanja.entrySet()) {
                Barang barang = entry.getKey();
                int jumlahBeli = entry.getValue();

                System.out.println("\nDetail Barang:");
                System.out.println("Nama Barang: " + barang.nama);
                System.out.println("Harga Barang: Rp. " + barang.harga);
                System.out.println("Jumlah Beli: " + jumlahBeli);

                long totalBayarBarang = barang.hitungTotalBayar(jumlahBeli);
                System.out.println("Total Bayar untuk Barang Ini: Rp. " + totalBayarBarang);

                totalBayar += totalBayarBarang;
            }

            double totalBayarKeseluruhan = (double) totalBayar;  // Konversi ke double untuk akurasi
            System.out.println("\nTotal Bayar Keseluruhan: Rp. " + totalBayarKeseluruhan);
            System.out.println(" ");

        } catch (InputException | java.util.InputMismatchException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}