package gulajava.bintangkuapa.internets.volleys;

import java.net.URLEncoder;
import java.util.Map;

/**
 * Created by Gulajava Ministudio on 7/23/16.
 */
public class LinkParsers {

    public LinkParsers() {
    }


    //UBAH PARAMETER KE BENTUK LINK QUERY UNTUK REQUEST TIPE GET
    public static String setParamsLinks(Map<String, String> mapParams) {

        String urlLinks = "";
        StringBuilder stringBuilder = new StringBuilder();

        if (mapParams != null) {

            for (String key : mapParams.keySet()) {

                Object value = mapParams.get(key);
                if (value != null) {

                    try {

                        String valuesLink = URLEncoder.encode(String.valueOf(value), "UTF-8");
                        if (stringBuilder.length() > 0) {
                            stringBuilder.append("&");
                        }

                        stringBuilder.append(key);
                        stringBuilder.append("=");
                        stringBuilder.append(valuesLink);

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
            }

            urlLinks = stringBuilder.toString();
        }

        return urlLinks;
    }
}
