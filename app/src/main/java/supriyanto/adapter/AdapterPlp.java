package supriyanto.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.crowdfire.cfalertdialog.CFAlertDialog;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import supriyanto.modal.ItemPlp;
import supriyanto.santriku.R;

/**
 * Created by SUPRIYANTO on 21/04/2019.
 */

public class AdapterPlp extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private ArrayList<ItemPlp> plpArrayList;

    public AdapterPlp(Context context, ArrayList<ItemPlp> plpArrayList) {
        this.context = context;
        this.plpArrayList = plpArrayList;
    }

    public class myAdapterPlp extends RecyclerView.ViewHolder{

        private RoundedImageView plp_image;
        private TextView plp_name;
        private RelativeLayout plp_click;

        public myAdapterPlp(View itemView) {
            super(itemView);

            plp_image = itemView.findViewById(R.id.plp_image);
            plp_name = itemView.findViewById(R.id.plp_name);
            plp_click = itemView.findViewById(R.id.plp_click);

        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_plp, parent, false);

        return new myAdapterPlp(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        final ItemPlp plp = plpArrayList.get(position);
        Picasso.get().load(plp.getImage()).into(((myAdapterPlp) holder).plp_image);
        ((myAdapterPlp) holder).plp_name.setText(plp.getPlp());
        ((myAdapterPlp) holder).plp_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(context);
//
//                View view = LayoutInflater.from(context).inflate(R.layout.pop_up, null);
//
//                TextView title = (TextView) view.findViewById(R.id.title);
//                TextView description = (TextView) view.findViewById(R.id.description);
//
//                title.setText(plp.getPlp());
//                description.setText(plp.getPlp_description());
//
//                builder.setView(view);
//                builder.show();

                CFAlertDialog.Builder builder = new CFAlertDialog.Builder(context)
                        .setDialogStyle(CFAlertDialog.CFAlertStyle.NOTIFICATION)
                        .setTitle(plp.getPlp())
                        .setMessage(plp.getPlp_description());
                builder.show();


            }
        });

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return plpArrayList.size();
    }
}
