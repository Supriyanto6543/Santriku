package supriyanto.async;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import supriyanto.api.Constant;
import supriyanto.listener.HomeListener;
import supriyanto.modal.ItemPlp;
import supriyanto.modal.ItemPortfolio;
import supriyanto.modal.ItemRecordSantri;
import supriyanto.modal.ItemSantri;
import supriyanto.utils.UtilsJson;

/**
 * Created by SUPRIYANTO on 20/04/2019.
 */

public class LoadHome extends AsyncTask<String, String, String>{

    private ArrayList<ItemRecordSantri> recordSantriArrayList = new ArrayList<>();
    private ArrayList<ItemPlp> plpArrayList = new ArrayList<>();
    private ArrayList<ItemSantri> santriArrayList = new ArrayList<>();
    private ArrayList<ItemPortfolio> portfolioArrayList = new ArrayList<>();
    private HomeListener homeListener;

    public LoadHome(HomeListener homeListener) {
        this.homeListener = homeListener;
    }

    @Override
    protected void onPreExecute() {
        homeListener.onStart();
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {

        try {
            JSONObject object = new JSONObject(UtilsJson.okHttpGet(strings[0]));
            JSONObject objJson = object.getJSONObject(Constant.ROOT_JSON);

            JSONArray record = objJson.getJSONArray("record");
            for (int i = 0; i < record.length(); i++){

                JSONObject object1 = record.getJSONObject(i);

                String plp_name = object1.getString(Constant.PLP_RECORD_NAME);
                String plp_image = object1.getString(Constant.PLP_REOCRD_IMAGE);

                ItemRecordSantri itemRecordSantri = new ItemRecordSantri(plp_name, plp_image);
                recordSantriArrayList.add(itemRecordSantri);

                Log.d("record_santri", plp_image);

            }

            JSONArray plp = objJson.getJSONArray("plp");
            for (int i = 0; i < plp.length(); i++){

                JSONObject object1 = plp.getJSONObject(i);

                String plp_name = object1.getString(Constant.PLP_NAME);
                String plp_image = object1.getString(Constant.PLP_IMAGE);

                ItemPlp itemPlp = new ItemPlp(plp_name, plp_image);
                plpArrayList.add(itemPlp);

            }

            JSONArray santri = objJson.getJSONArray("santri");
            for (int i = 0; i<santri.length(); i++){

                JSONObject objSantri = santri.getJSONObject(i);

                String santri_name = objSantri.getString(Constant.SANTRI_NAME);
                String santri_alamat = objSantri.getString(Constant.SANTRI_ALAMAT);
                String santri_kelas = objSantri.getString(Constant.SANTRI_KELAS);
                String santri_ttl = objSantri.getString(Constant.SANTRI_TTL);
                String santri_images = objSantri.getString(Constant.SANTRI_IMAGES);

                ItemSantri itemSantri = new ItemSantri(santri_name, santri_images);
                santriArrayList.add(itemSantri);
            }

            JSONArray portfolio = objJson.getJSONArray("portfolio");
            for (int i = 0; i<portfolio.length(); i++){
                JSONObject object1 = portfolio.getJSONObject(i);

                String portfolio_name = object1.getString(Constant.SANTRI_PORTFOLIO_NAME);
                String portfolio_description = object1.getString(Constant.SANTRI_PORTFOLIO_DESCRIPTION);
                String portfolio_images = object1.getString(Constant.SANTRI_PORTFOLIO_IMAGES);

                ItemPortfolio portfolios = new ItemPortfolio(portfolio_name, portfolio_images);
                portfolioArrayList.add(portfolios);

                Log.d("portfolio", portfolio_images);

            }

            return "1";

        } catch (JSONException e) {
            e.printStackTrace();
            return "0";
        }

    }

    @Override
    protected void onPostExecute(String s) {
        homeListener.onEnd(s, recordSantriArrayList, plpArrayList, santriArrayList, portfolioArrayList);
        super.onPostExecute(s);
    }
}
