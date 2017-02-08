package gulajava.bintangkuapa.databases;

import gulajava.bintangkuapa.databases.model.RMDataLahiran;
import gulajava.bintangkuapa.internets.models.Lahiran;

/**
 * Created by Gulajava Ministudio on 7/24/16.
 */
public interface RepositoryContract {

    interface HalUtamaRepos {

        //AKTIFKAN REALM
        void aktifkanRealm();

        //HENTIKAN REALM
        void hentikanRealm();

        //SIMPAN DATA KE DATABASE
        void simpanDataDatabase(Lahiran lahiran);

    }

    interface BookmarkRepos {

        //AKTIFKAN REALM
        void aktifkanRealm();

        //HENTIKAN REALM
        void hentikanRealm();

        //AMBIL DATABASE
        void ambilDatabase();

        //HAPUS DATABASE
        void hapusSemuaDatabase();

        //HAPUS SATU DATA DATABASE
        void hapusSatuDataDatabase(RMDataLahiran rmDataLahiran);
    }

}
