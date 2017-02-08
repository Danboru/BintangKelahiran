package gulajava.bintangkuapa.presenters;

import android.content.Context;

import java.util.List;

import gulajava.bintangkuapa.databases.RepoBookmark;
import gulajava.bintangkuapa.databases.model.RMDataLahiran;
import gulajava.bintangkuapa.viewcontract.HalBookmarkContract;

/**
 * Created by Gulajava Ministudio on 7/28/16.
 */
public class BookmarkPresenters implements HalBookmarkContract.Presenter {

    private HalBookmarkContract.View mView;

    private Context mContext;

    private RepoBookmark mRepoBookmark;

    public BookmarkPresenters(HalBookmarkContract.View view) {
        mView = view;
    }

    public void setContext(Context context) {
        mContext = context;
    }


    @Override
    public void aktifkanRealm() {

        mRepoBookmark = new RepoBookmark(BookmarkPresenters.this);
        mRepoBookmark.setContext(mContext);
        mRepoBookmark.aktifkanRealm();
    }

    @Override
    public void hentikanRealm() {

        mRepoBookmark.hentikanRealm();
    }

    @Override
    public void ambilDataDatabase() {

        mRepoBookmark.ambilDatabase();

    }

    @Override
    public void setelDataTampilan(List<RMDataLahiran> list) {

        mView.addDataBaruDatabase(list);
    }

    @Override
    public void hapusDataDatabase() {

        mRepoBookmark.hapusSemuaDatabase();
    }

    @Override
    public void hapusSatuDataDatabase(RMDataLahiran rmDataLahiran) {

        mRepoBookmark.hapusSatuDataDatabase(rmDataLahiran);
    }

    @Override
    public void tampilPesanPeringatanView(int resID) {

        mView.tampilPesanPeringatanView(resID);
    }
}
