package gulajava.bintangkuapa.aktivitas;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import gulajava.bintangkuapa.R;
import gulajava.bintangkuapa.fragments.FragmentHalamanUtama;
import gulajava.bintangkuapa.utilans.UtilanView;

/**
 * Created by Gulajava Ministudio on 7/23/16.
 */
public class HalamanUtama extends AppCompatActivity {

    private Unbinder mUnbinder;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    private ActionBar mActionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_container);
        mUnbinder = ButterKnife.bind(HalamanUtama.this);
        UtilanView.munculMenuAction(HalamanUtama.this);

        HalamanUtama.this.setSupportActionBar(mToolbar);
        mActionBar = HalamanUtama.this.getSupportActionBar();
        assert mActionBar != null;
        mActionBar.setTitle(R.string.app_name);

        inisialiasiFragment();
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        HalamanUtama.this.getMenuInflater().inflate(R.menu.menu_halutama, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.menu_riwayatlahir:

                Intent intentRiwayat = new Intent(HalamanUtama.this, HalamanBookmarks.class);
                HalamanUtama.this.startActivity(intentRiwayat);
                return true;

            case R.id.menu_tentangaplikasi:

                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }


    //INISIALISASI FRAGMENT
    private void inisialiasiFragment() {

        FragmentHalamanUtama fragmentHalamanUtama = new FragmentHalamanUtama();
        FragmentTransaction fragmentTransaction = HalamanUtama.this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_fragment, fragmentHalamanUtama);
        fragmentTransaction.commit();
    }
}
