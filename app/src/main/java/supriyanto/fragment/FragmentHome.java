package supriyanto.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import fr.castorflex.android.circularprogressbar.CircularProgressBar;
import supriyanto.adapter.AdapterPlp;
import supriyanto.adapter.AdapterPortfolio;
import supriyanto.adapter.AdapterRecordSantri;
import supriyanto.adapter.AdapterSantriHome;
import supriyanto.api.Constant;
import supriyanto.async.LoadHome;
import supriyanto.listener.HomeListener;
import supriyanto.modal.ItemPlp;
import supriyanto.modal.ItemPortfolio;
import supriyanto.modal.ItemRecordSantri;
import supriyanto.modal.ItemSantri;
import supriyanto.santriku.PlpActivity;
import supriyanto.santriku.R;
import supriyanto.santriku.RecordActivity;
import supriyanto.santriku.SantriActivity;
import supriyanto.utils.MethodJava;

/**
 * Created by SUPRIYANTO on 20/04/2019.
 */

public class FragmentHome extends Fragment {

    private MethodJava methodJava;
    private View view;
    private NestedScrollView nested_fragment;
    private TextView tv_record, tv_plp, tv_santri, tv_portfolio, record_view_all, plp_view_all, santri_view_all, portfolio_view_all;
    private RecyclerView rv_record, rv_plp, rv_santri, rv_portfolio;
    private ArrayList<ItemRecordSantri> arraylist_record;
    private ArrayList<ItemPlp> arraylist_plps;
    private ArrayList<ItemPortfolio> arraylist_portfolio;
    private ArrayList<ItemSantri> arraylist_santri;
    private AdapterRecordSantri adapterRecordSantri;
    private AdapterPlp adapterPlp;
    private AdapterSantriHome adapterSantri;
    private AdapterPortfolio adapterPortfolio;
    private FrameLayout f1_empty;
    private CircularProgressBar progress_bar;
    private LinearLayout frame_layout_root, record_title, plp_title, santri_title, portfolio_title;
    private String message;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_load_data, container, false);


        arraylist_record = new ArrayList<>();
        arraylist_plps = new ArrayList<>();
        arraylist_portfolio = new ArrayList<>();
        arraylist_santri = new ArrayList<>();

        methodJava = new MethodJava(getActivity());
        nested_fragment = (NestedScrollView) view.findViewById(R.id.nested_fragment);
        setHasOptionsMenu(true);

        //empty text
        tv_record = view.findViewById(R.id.tv_record);
        tv_plp = view.findViewById(R.id.tv_plp);
        tv_santri = view.findViewById(R.id.tv_santri);
        //tv_portfolio = view.findViewById(R.id.tv_portfolio);

        //view all text
        record_view_all = view.findViewById(R.id.record_view_all);
        plp_view_all = view.findViewById(R.id.plp_view_all);
        santri_view_all = view.findViewById(R.id.santri_view_all);
        //portfolio_view_all = view.findViewById(R.id.portfolio_view_all);

        //recycler view
        rv_record = view.findViewById(R.id.rv_record);
        rv_plp = view.findViewById(R.id.rv_plp);
        rv_santri = view.findViewById(R.id.rv_santri);
        //rv_portfolio = view.findViewById(R.id.rv_portfolio);

        //recycler view layout manager
        LinearLayoutManager record = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rv_record.setLayoutManager(record);
        rv_record.setItemAnimator(new DefaultItemAnimator());
        rv_record.setHasFixedSize(true);

        LinearLayoutManager plp = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rv_plp.setLayoutManager(plp);
        rv_plp.setItemAnimator(new DefaultItemAnimator());
        rv_plp.setHasFixedSize(true);

        LinearLayoutManager santri = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rv_santri.setLayoutManager(santri);
        rv_santri.setItemAnimator(new DefaultItemAnimator());
        rv_santri.setHasFixedSize(true);

        /*LinearLayoutManager portfolio = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rv_portfolio.setLayoutManager(portfolio);
        rv_portfolio.setItemAnimator(new DefaultItemAnimator());
        rv_portfolio.setHasFixedSize(true);*/

        frame_layout_root = view.findViewById(R.id.frame_layout_root);
        record_title = view.findViewById(R.id.record_title);
        plp_title = view.findViewById(R.id.plp_title);
        santri_title = view.findViewById(R.id.santri_title);
       // portfolio_title = view.findViewById(R.id.portfolio_title);

        //frame layout and circular progress
        f1_empty = view.findViewById(R.id.f1_empty);
        progress_bar = view.findViewById(R.id.progress_bar);

        LayoutInflater inflater1 = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View sview = inflater1.inflate(R.layout.inflanter_layout_no_internet, null);
        f1_empty.addView(sview);
        sview.findViewById(R.id.retry).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData();
            }
        });

        record_view_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RecordActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        plp_view_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PlpActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        santri_view_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SantriActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        loadData();

        return view;

    }

    private void loadData() {

        if (methodJava.checkInternet()){
            LoadHome loadHome = new LoadHome(new HomeListener() {
                @Override
                public void onStart() {
                    frame_layout_root.setVisibility(View.GONE);
                    progress_bar.setVisibility(View.GONE);
                    f1_empty.setVisibility(View.GONE);
                }

                @Override
                public void onEnd(String success, ArrayList<ItemRecordSantri> recordSantris, ArrayList<ItemPlp> plps, ArrayList<ItemSantri> santris, ArrayList<ItemPortfolio> portfolios) {

                    if (getActivity() != null){

                        if (success.equals("1")){
                            arraylist_record.addAll(recordSantris);
                            arraylist_plps.addAll(plps);
                            arraylist_santri.addAll(santris);
                            arraylist_portfolio.addAll(portfolios);

                            adapterRecordSantri = new AdapterRecordSantri(getActivity(), arraylist_record);
                            rv_record.setAdapter(adapterRecordSantri);

                            adapterPlp = new AdapterPlp(getActivity(), arraylist_plps);
                            rv_plp.setAdapter(adapterPlp);

                            adapterSantri = new AdapterSantriHome(getActivity(), arraylist_santri);
                            rv_santri.setAdapter(adapterSantri);

                            /*adapterPortfolio = new AdapterPortfolio(getActivity(), arraylist_portfolio);
                            rv_portfolio.setAdapter(adapterPortfolio);*/

                            frame_layout_root.setVisibility(View.VISIBLE);

                            setEmpty();

                        }else{
                            message = getString(R.string.server_error);
                        }

                        progress_bar.setVisibility(View.GONE);
                    }

                }
            });
            loadHome.execute(Constant.URL_HOME);
        }else{
            message = getString(R.string.not_connected);
            f1_empty.setVisibility(View.VISIBLE);
            progress_bar.setVisibility(View.GONE);
        }

    }

    private void setEmpty(){

        if (arraylist_record.size() == 0){
            record_title.setVisibility(View.GONE);
            tv_record.setVisibility(View.GONE);
            rv_record.setVisibility(View.GONE);
        }else{
            record_title.setVisibility(View.VISIBLE);
            rv_record.setVisibility(View.VISIBLE);
            tv_record.setVisibility(View.GONE);
        }

        if (arraylist_plps.size() == 0){
            plp_title.setVisibility(View.GONE);
            rv_plp.setVisibility(View.GONE);
            tv_plp.setVisibility(View.GONE);
        }else{
            rv_plp.setVisibility(View.VISIBLE);
            tv_plp.setVisibility(View.GONE);
            plp_title.setVisibility(View.VISIBLE);
        }

        if (arraylist_santri.size() == 0){
            santri_title.setVisibility(View.GONE);
            tv_santri.setVisibility(View.GONE);
            rv_santri.setVisibility(View.GONE);
        }else {
            santri_title.setVisibility(View.VISIBLE);
            tv_santri.setVisibility(View.GONE);
            rv_santri.setVisibility(View.VISIBLE);
        }

        /*if (arraylist_portfolio.size() == 0){
            portfolio_title.setVisibility(View.GONE);
            rv_portfolio.setVisibility(View.GONE);
            tv_portfolio.setVisibility(View.GONE);

        }else{
            portfolio_title.setVisibility(View.VISIBLE);
            rv_portfolio.setVisibility(View.VISIBLE);
            tv_portfolio.setVisibility(View.GONE);
        }*/


    }

}
