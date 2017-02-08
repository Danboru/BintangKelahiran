package gulajava.bintangkuapa.databases.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Gulajava Ministudio on 7/25/16.
 */
public class RMDataLahiran extends RealmObject {

    @PrimaryKey
    private String idLahiran;

    private String nama;
    private String lahir;
    private String usia;
    private String zodiak;

    public RMDataLahiran() {
    }

    public String getIdLahiran() {
        return idLahiran;
    }

    public void setIdLahiran(String idLahiran) {
        this.idLahiran = idLahiran;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getLahir() {
        return lahir;
    }

    public void setLahir(String lahir) {
        this.lahir = lahir;
    }

    public String getUsia() {
        return usia;
    }

    public void setUsia(String usia) {
        this.usia = usia;
    }

    public String getZodiak() {
        return zodiak;
    }

    public void setZodiak(String zodiak) {
        this.zodiak = zodiak;
    }
}
