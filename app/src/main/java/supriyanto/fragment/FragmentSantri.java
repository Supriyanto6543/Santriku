package supriyanto.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import supriyanto.adapter.AdapterSantri;
import supriyanto.api.Constant;
import supriyanto.async.LoadSantri;
import supriyanto.listener.SantriListener;
import supriyanto.modal.ItemSantri;
import supriyanto.santriku.R;
import supriyanto.utils.MethodJava;

/**
 * Created by SUPRIYANTO on 23/04/2019.
 */

public class FragmentSantri extends Fragment{

    private TextView tv_santri;
    private RecyclerView rv_santri;
    private View view;
    private GridLayoutManager gridLayoutManager;
    private ArrayList<ItemSantri> santris;
    private MethodJava methodJava;
    private String message;
    private LinearLayout frame_layout_root;
    private AdapterSantri adapterSantri;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_santri, container, false);

        methodJava = new MethodJava(getActivity());

        santris = new ArrayList<>();
        frame_layout_root = view.findViewById(R.id.frame_layout_root);
        tv_santri = view.findViewById(R.id.tv_santri);

        rv_santri = view.findViewById(R.id.rv_santri);
        gridLayoutManager = new GridLayoutManager(getActivity(), 1);
        rv_santri.setLayoutManager(gridLayoutManager);
        rv_santri.setItemAnimator(new DefaultItemAnimator());
        rv_santri.setHasFixedSize(true);

        loadDataSantri();

        return view;
    }

    private void loadDataSantri(){
        if (methodJava.checkInternet()){
            LoadSantri loadSantri = new LoadSantri(new SantriListener() {
                @Override
                public void onStart() {
                    frame_layout_root.setVisibility(View.GONE);
                    rv_santri.setVisibility(View.GONE);
                }

                @Override
                public void onEnd(String success, ArrayList<ItemSantri> santriArrayList) {

                    if (getActivity() != null){

                        if (success.equals("1")){

                            santris.addAll(santriArrayList);

                            adapterSantri = new AdapterSantri(getActivity(), santris);
                            rv_santri.setAdapter(adapterSantri);
                            frame_layout_root.setVisibility(View.VISIBLE);
                            setEmpty();
                        }

                    }

                }
            });
            loadSantri.execute(Constant.URL_SANTRI);
        }else{
            message = getString(R.string.not_connected);
        }
    }

    private void setEmpty(){
        if (santris.size() == 0){
            frame_layout_root.setVisibility(View.GONE);
            tv_santri.setVisibility(View.GONE);
            rv_santri.setVisibility(View.GONE);
        }else{
            frame_layout_root.setVisibility(View.VISIBLE);
            tv_santri.setVisibility(View.VISIBLE);
            rv_santri.setVisibility(View.VISIBLE);
        }
    }

}
