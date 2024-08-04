package com.terresaalicia.belajarhewanwithkakterre.Adapter;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.terresaalicia.belajarhewanwithkakterre.R;
import com.terresaalicia.belajarhewanwithkakterre.DetailHewanActivity;
import com.terresaalicia.belajarhewanwithkakterre.models.Hewan;

import java.util.List;

public class HewanAdapter extends RecyclerView.Adapter<HewanAdapter.HewanViewHolder> {

    private List<Hewan> DaftarHewan;
    private Context context;

    public HewanAdapter(List<Hewan> DaftarHewan, Context context) {
        this.DaftarHewan = DaftarHewan;
        this.context = context;
    }

    @NonNull
    @Override
    public HewanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hewan, parent, false);
        return new HewanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HewanViewHolder holder, int position) {
        Hewan hewan = DaftarHewan.get(position);
        holder.bind(hewan);
    }

    @Override
    public int getItemCount() {
        return DaftarHewan.size();
    }

    class HewanViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
//        private Button playSoundButton;

        public HewanViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.animal_name);
//            playSoundButton = itemView.findViewById(R.id.ButtonNyalakanSuara);
        }

        public void bind(final Hewan hewan) {
            nameTextView.setText(hewan.GetNama());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DetailHewanActivity.class);
                    intent.putExtra("name", hewan.GetNama());
                    intent.putExtra("sound", hewan.GetSuara());
                    intent.putExtra("imageResId", hewan.GetGambarHewan());
                    intent.putExtra("soundResId", hewan.GetSuaraWavId());
                    context.startActivity(intent);
                }
            });


        }
    }
}
