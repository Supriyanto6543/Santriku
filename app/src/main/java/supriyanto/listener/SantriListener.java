package supriyanto.listener;

import java.util.ArrayList;

import supriyanto.modal.ItemSantri;

/**
 * Created by SUPRIYANTO on 23/04/2019.
 */

public interface SantriListener {
    void onStart();
    void onEnd(String success, ArrayList<ItemSantri> santriArrayList);
}
