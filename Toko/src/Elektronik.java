// Kelas turunan dari Barang, menggunakan interface Harga
class Elektronik extends Barang implements Harga { //Inheritance
    public Elektronik() {
        super("Iphone 15", 24000000);
    }

    @Override
    public long hitungTotalBayar(long jumlah) {
        return (long) harga * jumlah;
    }
}

