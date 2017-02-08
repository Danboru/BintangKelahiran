package gulajava.bintangkuapa.databases;

import android.content.Context;

import gulajava.bintangkuapa.R;
import gulajava.bintangkuapa.databases.model.RMDataLahiran;
import gulajava.bintangkuapa.internets.models.Lahiran;
import gulajava.bintangkuapa.viewcontract.HalUtamaContract;
import io.realm.Realm;
import io.realm.RealmAsyncTask;
import io.realm.RealmConfiguration;

/**
 * Created by Gulajava Ministudio on 7/25/16.
 */
public class RepoHalamanUtama implements RepositoryContract.HalUtamaRepos {

    private HalUtamaContract.Presenter mPresenter;
    private Context mContext;

    private Realm mRealm;
    private RealmAsyncTask mRealmAsyncTaskSimpan;
    private RealmConfiguration mRealmConfiguration;

    public RepoHalamanUtama(HalUtamaContract.Presenter presenter) {
        mPresenter = presenter;
    }

    public void setContext(Context context) {
        mContext = context;
    }

    @Override
    public void aktifkanRealm() {

        mRealmConfiguration = RealmConfigs.getRealmConfigs(mContext);

        if (mRealm == null) {
            mRealm = Realm.getInstance(mRealmConfiguration);
        } else {
            if (mRealm.isClosed()) {
                mRealm = Realm.getInstance(mRealmConfiguration);
            }
        }
    }

    @Override
    public void hentikanRealm() {

        if (mRealmAsyncTaskSimpan != null) {
            mRealmAsyncTaskSimpan.cancel();
        }

        if (mRealm != null) {
            mRealm.close();
        }
    }

    @Override
    public void simpanDataDatabase(final Lahiran lahiran) {

        mRealmAsyncTaskSimpan = mRealm.executeTransactionAsync(
                new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {

                        String nama = lahiran.getNama();
                        String lahir = lahiran.getLahir();
                        String usia = lahiran.getUsia();
                        String zodiak = lahiran.getZodiak();

                        String idlahiran = nama + lahir;

                        RMDataLahiran rmDataLahiran = new RMDataLahiran();
                        rmDataLahiran.setIdLahiran(idlahiran);
                        rmDataLahiran.setNama(nama);
                        rmDataLahiran.setLahir(lahir);
                        rmDataLahiran.setUsia(usia);
                        rmDataLahiran.setZodiak(zodiak);

                        realm.copyToRealmOrUpdate(rmDataLahiran);
                    }
                },
                new Realm.Transaction.OnSuccess() {
                    @Override
                    public void onSuccess() {

                        //kirim pesan peringatan ke dalam view
                        mPresenter.tampilPesanPeringatan(R.string.toast_data_disimpan);
                    }
                },
                new Realm.Transaction.OnError() {
                    @Override
                    public void onError(Throwable error) {

                        error.printStackTrace();

                        //kirim pesan peringatan ke dalam view
                        mPresenter.tampilPesanPeringatan(R.string.toast_data_gagal_simpan);
                    }
                }
        );

    }
}
