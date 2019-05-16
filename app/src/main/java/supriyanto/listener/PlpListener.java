package supriyanto.listener;

import java.util.ArrayList;

import supriyanto.modal.ItemPlp;

/**
 * Created by SUPRIYANTO on 27/04/2019.
 */

public interface PlpListener {

    void onStart();
    void onEnd(String success, ArrayList<ItemPlp> plps);
}
