package gulajava.bintangkuapa.utilans;

import android.content.Context;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.inputmethod.InputMethodManager;

import java.lang.reflect.Field;
import java.util.Locale;

/**
 * Created by Gulajava Ministudio on 2/11/16.
 */
public class UtilanView {


    //MENAMPILKAN MENU ACTION BAR
    public static void munculMenuAction(Context context) {

        try {
            ViewConfiguration config = ViewConfiguration.get(context);
            Field menuKey = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");

            if (menuKey != null) {
                menuKey.setAccessible(true);
                menuKey.setBoolean(config, false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //SEMBUNYIKAN KEYBOARD
    public static void sembunyikeyboard(Context context, View view) {
        InputMethodManager manager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        manager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);
    }


    //TEXTVIEW SEPARATOR
    public static String formatAngkaPisah(String angkastr) {

        String bilanganpisah;

        try {
            int intangka = Integer.valueOf(angkastr);
//          bilanganpisah = String.format(Locale.getDefault(), "%,d", angkastr).replace(",", ".");
            bilanganpisah = String.format(Locale.getDefault(), "%,d", intangka);
        } catch (Exception e) {
            e.printStackTrace();
            bilanganpisah = "" + angkastr;
        }

        return bilanganpisah;
    }

}
