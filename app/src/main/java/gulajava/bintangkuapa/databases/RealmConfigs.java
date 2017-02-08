package gulajava.bintangkuapa.databases;

import android.content.Context;

import io.realm.RealmConfiguration;

/**
 * Created by Gulajava Ministudio on 7/26/16.
 */
public class RealmConfigs {


    public RealmConfigs() {
    }

    public static RealmConfiguration getRealmConfigs(Context context) {

        RealmConfiguration.Builder builder = new RealmConfiguration.Builder(context);
        builder.schemaVersion(1);
        builder.deleteRealmIfMigrationNeeded();

        return builder.build();
    }
}
