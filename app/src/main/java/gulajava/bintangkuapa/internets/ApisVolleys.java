package gulajava.bintangkuapa.internets;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;

import java.util.HashMap;
import java.util.Map;

import gulajava.bintangkuapa.Konstan;
import gulajava.bintangkuapa.internets.models.Lahiran;
import gulajava.bintangkuapa.internets.volleys.FastJsonRequest;
import gulajava.bintangkuapa.internets.volleys.LinkParsers;

/**
 * Created by Gulajava Ministudio on 7/23/16.
 */
public class ApisVolleys {

    //timeout dengan jumlah percobaan
    public static int JUMLAH_TIMEOUT = 15000;
    public static int JUMLAH_COBA = 2;
    public static float PENGALI_TIMEOUT = 1;
    public static final String TAG_HEADERCONTENTIPE = "Content-Type";
    public static final String HEADER_FORMTYPE = "application/json;charset=utf-8";


    public ApisVolleys() {
    }

    private static DefaultRetryPolicy getRetryPolicy() {
        return new DefaultRetryPolicy(JUMLAH_TIMEOUT, JUMLAH_COBA, PENGALI_TIMEOUT);
    }

    //http://ibacor.com/api/zodiak?nama=Bubu Mon&tgl=16-07-1988
    public static FastJsonRequest<Lahiran> getDataKelahiran(
            String namalengkap,
            String tanggalLahir,
            Response.Listener<Lahiran> listener,
            Response.ErrorListener errorListener
    ) {

        Map<String, String> mapHeaders = new HashMap<>();
        mapHeaders.put(TAG_HEADERCONTENTIPE, HEADER_FORMTYPE);

        Map<String, String> mapParams = new HashMap<>();
        mapParams.put("nama", namalengkap);
        mapParams.put("tgl", tanggalLahir);

        String urlParamsLinks = LinkParsers.setParamsLinks(mapParams);
        String urls = Konstan.ALAMAT_SERVER + "/api/zodiak?" + urlParamsLinks;

        FastJsonRequest<Lahiran> fastJsonRequest = new FastJsonRequest<>(
                Request.Method.GET,
                urls,
                Lahiran.class,
                mapHeaders,
                mapParams,
                listener,
                errorListener
        );

        fastJsonRequest.setRetryPolicy(getRetryPolicy());

        return fastJsonRequest;
    }

}
