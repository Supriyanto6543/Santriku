package supriyanto.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import supriyanto.modal.ItemPortfolio;
import supriyanto.santriku.R;

/**
 * Created by SUPRIYANTO on 21/04/2019.
 */

public class AdapterPortfolio extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private ArrayList<ItemPortfolio> portfolioArrayList;

    public AdapterPortfolio(Context context, ArrayList<ItemPortfolio> portfolioArrayList) {
        this.context = context;
        this.portfolioArrayList = portfolioArrayList;
    }

    public class myAdapterPortfolio extends RecyclerView.ViewHolder{

        private RoundedImageView record_image;
        private TextView record_name;

        public myAdapterPortfolio(View itemView) {
            super(itemView);

            record_image = itemView.findViewById(R.id.record_image);
            record_name = itemView.findViewById(R.id.record_name);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_record_santri, parent, false);

        return new myAdapterPortfolio(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ItemPortfolio portfolio = portfolioArrayList.get(position);
        Picasso.get().load(portfolio.getPortfolio_images()).into(((myAdapterPortfolio) holder).record_image);
        ((myAdapterPortfolio) holder).record_name.setText(portfolio.getPortfolio_name());

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return portfolioArrayList.size();
    }
}
