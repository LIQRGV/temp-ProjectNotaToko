package projectnotatoko;

// Import Package Scanner, dan Format Mata Uang
import projectnotatoko.helper.CurrencyFormatter;
import projectnotatoko.model.Barang;
import projectnotatoko.model.Pesanan;

import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class MainNota {
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) throws Exception {
        Barang susu = new Barang("Susu", 5000);
        Barang kopi = new Barang("Kopi", 3000);
        Barang teh = new Barang("Teh", 4000);
        Barang jus = new Barang("Jus", 10000);
        Barang sosis = new Barang("Sosis", 5000);
        Barang mieInstant = new Barang("Mie Instant", 8000);
        Barang nasiGoreng = new Barang("Nasi Goreng", 15000);
        Barang kerupuk = new Barang("Kerupuk", 2000);

        Barang[] listBarang = new Barang[]{
                susu,
                kopi,
                teh,
                jus,
                sosis,
                mieInstant,
                nasiGoreng,
                kerupuk,
        };

        header();
        informasiBarang(listBarang);
        Pesanan[] daftarPesanan = prosesBelanja(listBarang);

        jumlahHarga(daftarPesanan);
    }
    
    public static void informasiBarang(Barang[] listBarang){
        System.out.println("Kode Barang   ||  Harga Barang");

        int index = 1;
        int c = 11;
        for (Barang barang: listBarang) {
            System.out.printf("%d. %-" + c + "s||  %s%n", index, barang.getNama(), CurrencyFormatter.format(barang.getHarga()));
            index++;
        }
        System.out.println("------------------------------");
    }
    
    public static void header(){
        
        System.out.println("        TOKO MAJU JAYA");
        System.out.println("   PT. MAJU JAYA PRICOPALO");
        System.out.println("   JL. KH. SULAIMAN NO. 48");
        System.out.println("GEMURUNG - GEDANGAN - SIDOARJO");
        System.out.println("------------------------------");
        
    }
    
    public static Pesanan[] prosesBelanja(Barang[] listBarang) throws Exception {
        System.out.print("Masukkan Jumlah Barang : ");
        int jumlahData = input.nextInt();
        System.out.println();
        Pesanan[] orders = new Pesanan[jumlahData];

        for (int i = 1; i <= jumlahData; i++) {
            System.out.printf("Masukkan Kode Barang ke-%d     : ", i);
            int inputBarang = input.nextInt();
            System.out.printf("Masukkan Quantity Barang ke-%d : ", i);
            int inputQty = input.nextInt();
            System.out.println("------------------------------");

            if (i < 1 || listBarang.length + 1 < i) {
                throw new Exception("Ga ada barangnya");
            }

            Barang barangPilihan = listBarang[inputBarang - 1];
            Pesanan order = new Pesanan(barangPilihan, inputQty);
            orders[i - 1] = order;
            System.out.printf(
                    "%s %s x %d = %s%n",
                    barangPilihan.getNama(),
                    CurrencyFormatter.format(barangPilihan.getHarga()),
                    order.getKuantitas(),
                    CurrencyFormatter.format(barangPilihan.getHarga() * order.getKuantitas())
            );
        }
        return orders;
    }

    public static void jumlahHarga(Pesanan[] daftarPesanan) {
        int yangDibayar = 0;
        for (Pesanan pesanan: daftarPesanan) {
            yangDibayar += pesanan.getJumlahBayar();
        }

        System.out.printf("Yang dibayar sebesar: %s%n", CurrencyFormatter.format(yangDibayar));
    }
}
