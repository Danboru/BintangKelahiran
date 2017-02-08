package gulajava.bintangkuapa.viewcontract;

import java.util.List;

import gulajava.bintangkuapa.databases.model.RMDataLahiran;

/**
 * Created by Gulajava Ministudio on 7/28/16.
 */
public interface HalBookmarkContract {

    interface View {

        //INISIALISASI DATA AWAL
        void inisialisasiDataAwal();

        //INISIALISASI TAMPILAN
        void inisialisasiTampilan();

        //INISIALISASI LISTENER
        void inisialiasiListener();

        //TAMBAH DATA BARU DARI DATABASE
        void addDataBaruDatabase(List<RMDataLahiran> list);

        //HAPUS DATA DATABASE
        void hapusDataDatabase();

        //HAPUS SATU DATA DATABASE
        void hapusSatuDataDatabase();

        //TAMPIL PESAN PERINGATAN
        void tampilPesanPeringatanView(int resID);

    }

    interface Presenter {

        //AKTIFKAN REALM
        void aktifkanRealm();

        //HENTIKAN REALM
        void hentikanRealm();

        //AMBIL DATA DARI DATABASE
        void ambilDataDatabase();

        //SETEL DATA KE TAMPILAN
        void setelDataTampilan(List<RMDataLahiran> list);

        //HAPUS DATA DATABASE
        void hapusDataDatabase();

        //HAPUS SATU DATA DATABASE
        void hapusSatuDataDatabase(RMDataLahiran rmDataLahiran);

        //TAMPIL PESAN PERINGATAN
        void tampilPesanPeringatanView(int resID);

    }

}
