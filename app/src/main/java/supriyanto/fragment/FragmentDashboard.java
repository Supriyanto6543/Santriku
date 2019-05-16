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
 * Created by SUPRIYANTO on 20/04/2019.
 */

public class FragmentDashboard extends Fragment{

    private FrameLayout dashboard_frame_layout;
    private View view;
    private FragmentManager manager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        dashboard_frame_layout = view.findViewById(R.id.dashboard_frame_layout);
        manager = getFragmentManager();
        FragmentHome home = new FragmentHome();
        loadFragment(home, getString(R.string.home));

        return view;
    }

    private void loadFragment(Fragment fragment, String name) {

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

        if (name.equals(getString(R.string.search))){
            transaction.hide(manager.getFragments().get(manager.getBackStackEntryCount()));
            transaction.add(R.id.dashboard_frame_layout, fragment, name);
            transaction.addToBackStack(name);
        }else{
            transaction.replace(R.id.dashboard_frame_layout, fragment, name);
        }

        transaction.commit();
//        ((MainActivity) getActivity()).getSupportActionBar().setTitle(name);
    }
}
