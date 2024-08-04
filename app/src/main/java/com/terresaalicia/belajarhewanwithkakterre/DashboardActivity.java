package com.terresaalicia.belajarhewanwithkakterre;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.terresaalicia.belajarhewanwithkakterre.Adapter.HewanAdapter;
import com.terresaalicia.belajarhewanwithkakterre.helpers.BaseActivity;
import com.terresaalicia.belajarhewanwithkakterre.models.Hewan;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DashboardActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private HewanAdapter hewanAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        SetupViews();
    }

    @Override
    protected void SetupViews() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Hewan> daftarHewan = new ArrayList<>();
        daftarHewan.add(new Hewan("Kucing", "Meong", R.raw.cat, R.drawable.cat));
        daftarHewan.add(new Hewan("Anjing", "Guk Guk", R.raw.dog, R.drawable.dog));
//        daftarHewan.add(new Hewan("Domba", "Mbeek", R.raw.goat));

        hewanAdapter = new HewanAdapter(daftarHewan, this);
        recyclerView.setAdapter(hewanAdapter);
    }
}
