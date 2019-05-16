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

import supriyanto.modal.ItemRecordSantri;
import supriyanto.santriku.R;

/**
 * Created by SUPRIYANTO on 21/04/2019.
 */

public class AdapterRecordSantri extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private ArrayList<ItemRecordSantri> recordSantriArrayList;

    public class myRecordSantri extends RecyclerView.ViewHolder{

        private RoundedImageView record_image;
        private TextView record_name;

        public myRecordSantri(View itemView) {
            super(itemView);

            record_image = itemView.findViewById(R.id.record_image);
            record_name = itemView.findViewById(R.id.record_name);

        }
    }

    public AdapterRecordSantri(Context context, ArrayList<ItemRecordSantri> recordSantriArrayList) {
        this.context = context;
        this.recordSantriArrayList = recordSantriArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_record_santri, parent, false);

        return new myRecordSantri(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ItemRecordSantri record = recordSantriArrayList.get(position);
        Picasso.get().load(record.getImage()).into(((myRecordSantri) holder).record_image);
        ((myRecordSantri) holder).record_name.setText(record.getPlp());

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return recordSantriArrayList.size();
    }
}
