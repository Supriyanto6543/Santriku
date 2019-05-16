package supriyanto.async;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import supriyanto.api.Constant;
import supriyanto.listener.PlpListener;
import supriyanto.modal.ItemPlp;
import supriyanto.utils.UtilsJson;

/**
 * Created by SUPRIYANTO on 27/04/2019.
 */

public class LoadPlp extends AsyncTask<String, String, String>{

    PlpListener listener;
    ArrayList<ItemPlp> itemPlps = new ArrayList<>();

    public LoadPlp(PlpListener listener) {
        this.listener = listener;
    }

    @Override
    protected void onPreExecute() {
        listener.onStart();
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {

        try {
            JSONObject object = new JSONObject(UtilsJson.okHttpGet(strings[0]));
            JSONArray array = object.getJSONArray(Constant.PLP_RECORD_NAME);

            for (int i = 0; i<array.length(); i++){
                JSONObject object1 = array.getJSONObject(i);

                String image = object1.getString(Constant.PLP_REOCRD_IMAGE);
                String plp = object1.getString(Constant.PLP_RECORD_NAME);
                String description = object1.getString(Constant.PLP_RECORD_DESCRIPTION);

                ItemPlp itemPlp = new ItemPlp(plp, image, description);
                itemPlps.add(itemPlp);

                Log.d("plpSantri", itemPlp + "");

            }

            return "1";
        } catch (JSONException e) {
            e.printStackTrace();
            return "0";
        }

    }

    @Override
    protected void onPostExecute(String s) {
        listener.onEnd(s, itemPlps);
        super.onPostExecute(s);
    }
}
