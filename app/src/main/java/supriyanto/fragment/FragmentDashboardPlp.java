package supriyanto.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import supriyanto.santriku.R;

/**
 * Created by SUPRIYANTO on 27/04/2019.
 */

public class FragmentDashboardPlp extends Fragment {

    View view;
    FragmentManager manager;
    FrameLayout dashboard_frame_layout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        dashboard_frame_layout = view.findViewById(R.id.dashboard_frame_layout);

        manager = getFragmentManager();

        FragmentPlp plp = new FragmentPlp();
        loadFragment(plp, "");
        return view;

    }

    private void loadFragment(Fragment fs, String name){

        FragmentTransaction ft = manager.beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

        if (name.equals(getString(R.string.plp))){
            ft.hide(manager.getFragments().get(manager.getBackStackEntryCount()));
            ft.add(R.id.dashboard_frame_layout, fs, name);
            ft.addToBackStack(name);
        }else{
            ft.replace(R.id.dashboard_frame_layout, fs, name);
        }
        ft.commit();
    }
}
