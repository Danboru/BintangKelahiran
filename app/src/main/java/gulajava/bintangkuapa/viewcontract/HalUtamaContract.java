package gulajava.bintangkuapa.viewcontract;

import gulajava.bintangkuapa.internets.models.Lahiran;

/**
 * Created by Gulajava Ministudio on 7/23/16.
 */
public interface HalUtamaContract {

    interface View {

        //INISIALISASI DATA AWAL
        void inisialisasiDataAwal();

        //INISIALISASI TAMPILAN
        void inisialisasiTampilan();

        //INISIALISASI LISTENER
        void inisialiasiListener();

        //TAMPILKAN DIALOG PILIH TANGGAL
        void tampilDialogPilihTanggal();

        //SETEL DATA TANGGAL KE ISIAN TEKS TANGGAL
        void setelDataTanggalTeks();

        //AMBIL DATA ISIAN PENGGUNA
        void ambilDataIsianPengguna();

        //TAMPILKAN PESAN PERINGATAN
        void tampilPesanPeringatan(int resID);

        //TAMPILKAN HASIL CEK TANGGAL LAHIR
        void tampilkanHasilCekTanggalLahir(Lahiran lahiran);

        //TAMPILKAN DIALOG PROSES ATAU TIDAK
        void tampilDialogProses(boolean isProses);
    }

    interface Presenter {

        //AKTIFKAN REALM
        void aktifkanRealm();

        //HENTIKAN REALM
        void hentikanRealm();

        //HENTIKAN PROSES MUAT DATA
        void hentikanProsesMuatData();

        //SETEL TANGGAL LAHIR PENGGUNA
        void setDataIsianPengguna(String namaPengguna, String stringTanggalLahir);

        //CEK KONEKSI INTERNET
        void cekKoneksiInternet();

        //AMBIL DATA DARI INTERNET
        void ambilDataDariInternet();

        //CEK HASIL AMBIL DATA
        void cekHasilAmbilDataPengguna();

        //SETEL DATA KE TAMPILAN
        void setelDataTampilan();

        //SIMPAN DATA ISIAN HASIL AMBIL DATA
        void simpanDataIsianHasilAmbilData();


        //SET STATUS PENYEGARAN DATA
        void setStatusDisegarkanData(boolean isDisegarkan);

        //TAMPILKAN PESAN PERINGATAN KE VIEW
        void tampilPesanPeringatan(int resID);

        //SETEL TANGGAL TAMPILAN KE DALAM BENTUK FORMAT TERTENTU
        String setelTanggalTampilan(int tanggal, int intbulan, int inttahun);
    }
}
