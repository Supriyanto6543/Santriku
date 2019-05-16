package supriyanto.async;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import supriyanto.api.Constant;
import supriyanto.listener.SantriListener;
import supriyanto.modal.ItemSantri;
import supriyanto.utils.UtilsJson;

/**
 * Created by SUPRIYANTO on 23/04/2019.
 */

public class LoadSantri extends AsyncTask<String, String, String> {

    private ArrayList<ItemSantri> itemSantris = new ArrayList<>();
    private SantriListener santriListener;

    public LoadSantri(SantriListener santriListener) {
        this.santriListener = santriListener;
    }

    @Override
    protected void onPreExecute() {
        santriListener.onStart();
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {

        try {
            JSONObject object = new JSONObject(UtilsJson.okHttpGet(strings[0]));
            JSONArray object1 = object.getJSONArray(Constant.SANTRI_ALL_DATA);

            for (int i = 0; i<object1.length(); i++){

                JSONObject object2 = object1.getJSONObject(i);

                String name = object2.getString(Constant.SANTRI_ALL_NAME);
                String alamat = object2.getString(Constant.SANTRI_ALL_ALAMAT);
                String kelas = object2.getString(Constant.SANTRI_ALL_KELAS);
                String ttl = object2.getString(Constant.SANTRI_ALL_TTL);
                String images_santri = object2.getString(Constant.SANTRI_ALL_IMAGES);
                String plp = object2.getString(Constant.SANTRI_ALL_PLP);
                String plp_desc = object2.getString(Constant.SANTRI_ALL_PLP_DES);
                String nomor = object2.getString(Constant.SANTRI_ALL_NOMOR);
                String total = object2.getString(Constant.SANTRI_ALL_TOTAL);


                ItemSantri itemSantri = new ItemSantri(name, alamat, kelas, ttl, images_santri, plp, plp_desc, nomor, total);
                itemSantris.add(itemSantri);

            }

            return "1";

        } catch (JSONException e) {
            e.printStackTrace();
            return "0";
        }

    }

    @Override
    protected void onPostExecute(String s) {
        santriListener.onEnd(s, itemSantris);
        super.onPostExecute(s);
    }
}
