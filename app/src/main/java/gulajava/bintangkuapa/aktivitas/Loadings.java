package gulajava.bintangkuapa.aktivitas;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import gulajava.bintangkuapa.R;

/**
 * Created by Gulajava Ministudio on 7/26/16.
 */
public class Loadings extends AppCompatActivity {


    private final Runnable mRunnable = new Runnable() {
        @Override
        public void run() {

            Intent intent = new Intent(Loadings.this, HalamanUtama.class);
            Loadings.this.startActivity(intent);
            Loadings.this.finish();
        }
    };

    

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loadinghalaman);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Handler handler = new Handler();
        handler.postDelayed(mRunnable, 1000);
    }
}
