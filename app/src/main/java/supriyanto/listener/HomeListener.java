package supriyanto.listener;

import java.util.ArrayList;

import supriyanto.modal.ItemPlp;
import supriyanto.modal.ItemPortfolio;
import supriyanto.modal.ItemRecordSantri;
import supriyanto.modal.ItemSantri;

/**
 * Created by SUPRIYANTO on 20/04/2019.
 */

public interface HomeListener {
    void onStart();
    void onEnd(String success, ArrayList<ItemRecordSantri> recordSantris, ArrayList<ItemPlp> plps, ArrayList<ItemSantri> santris, ArrayList<ItemPortfolio> portfolios);
}
