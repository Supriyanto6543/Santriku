package supriyanto.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import supriyanto.adapter.AdapterPlp;
import supriyanto.api.Constant;
import supriyanto.async.LoadPlp;
import supriyanto.listener.PlpListener;
import supriyanto.modal.ItemPlp;
import supriyanto.santriku.R;
import supriyanto.utils.MethodJava;

/**
 * Created by SUPRIYANTO on 27/04/2019.
 */

public class FragmentPlp extends Fragment {

    View view;
    ArrayList<ItemPlp> itemPlps;
    RecyclerView rv_plp;
    TextView tv_plp;
    LinearLayout frame_layout_root;
    GridLayoutManager gridLayoutManager;
    MethodJava methodJava;
    AdapterPlp adapterPlp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_plp, container, false);

        itemPlps = new ArrayList<>();
        methodJava = new MethodJava(getActivity());

        rv_plp = (RecyclerView) view.findViewById(R.id.rv_plp);
        tv_plp = (TextView) view.findViewById(R.id.tv_plp);
        frame_layout_root = (LinearLayout) view.findViewById(R.id.frame_layout_root);
        gridLayoutManager = new GridLayoutManager(getActivity(), 2);

        rv_plp.setLayoutManager(gridLayoutManager);

        loadData();

        return view;
    }

    private void loadData(){

        if (methodJava.checkInternet()){
            LoadPlp loadPlp = new LoadPlp(new PlpListener() {
                @Override
                public void onStart() {

                }

                @Override
                public void onEnd(String success, ArrayList<ItemPlp> plps) {
                    if (getActivity() != null){
                        if (success.equals("1")){
                            itemPlps.addAll(plps);

                            adapterPlp = new AdapterPlp(getActivity(), plps);
                            rv_plp.setAdapter(adapterPlp);

                            setEmpty();
                        }
                    }
                }
            });
            loadPlp.execute(Constant.URL_PLP);
        }

    }

    private void setEmpty(){
        if (itemPlps.size() == 0){
            rv_plp.setVisibility(View.GONE);
            tv_plp.setVisibility(View.GONE);
        }else{
            rv_plp.setVisibility(View.VISIBLE);
            tv_plp.setVisibility(View.VISIBLE);
        }
    }
}
