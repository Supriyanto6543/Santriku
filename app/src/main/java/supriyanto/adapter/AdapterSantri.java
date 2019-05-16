package supriyanto.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.crowdfire.cfalertdialog.CFAlertDialog;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import supriyanto.modal.ItemSantri;
import supriyanto.santriku.R;

/**
 * Created by SUPRIYANTO on 21/04/2019.
 */

public class AdapterSantri extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<ItemSantri> itemSantris;

    public AdapterSantri(Context context, ArrayList<ItemSantri> itemSantris) {
        this.context = context;
        this.itemSantris = itemSantris;
    }

    public class mySantriAdapter extends RecyclerView.ViewHolder{

        private RoundedImageView santri_image;
        private TextView santri_name, santri_alamat, number;
        private LinearLayout detail_santri;

        public mySantriAdapter(View itemView) {
            super(itemView);

            santri_image = itemView.findViewById(R.id.santri_image);
            santri_name = itemView.findViewById(R.id.santri_name);
            santri_alamat = itemView.findViewById(R.id.santri_alamat);
            number = itemView.findViewById(R.id.number);
            detail_santri = itemView.findViewById(R.id.detail_santri);

        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_santri_list, parent, false);

        return new mySantriAdapter(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ItemSantri santri = itemSantris.get(position);


        Picasso.get().load(santri.getImages_santri()).into(((mySantriAdapter) holder).santri_image);
        ((mySantriAdapter) holder).santri_name.setText(santri.getName());
        ((mySantriAdapter) holder).santri_alamat.setText(santri.getAlamat());
        ((mySantriAdapter) holder).number.setText(santri.getNomor());
        ((mySantriAdapter) holder).detail_santri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CFAlertDialog.Builder builder = new CFAlertDialog.Builder(context)
                        .setDialogStyle(CFAlertDialog.CFAlertStyle.NOTIFICATION)
                        .setTitle("Nama: " + santri.getName())
                        .setMessage("Kelas: " + santri.getKelas() + "\n" + "Alamat: " + santri.getAlamat() + "\n" + "Plp: " + santri.getPlp());
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
        return itemSantris.size();
    }
}
