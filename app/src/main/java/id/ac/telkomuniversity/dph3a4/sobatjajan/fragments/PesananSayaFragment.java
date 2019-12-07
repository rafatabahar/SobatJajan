package id.ac.telkomuniversity.dph3a4.sobatjajan.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import id.ac.telkomuniversity.dph3a4.sobatjajan.R;
import id.ac.telkomuniversity.dph3a4.sobatjajan.activities.DetailPesananSayaActivity;
import id.ac.telkomuniversity.dph3a4.sobatjajan.adapters.PesananSayaAdapter;
import id.ac.telkomuniversity.dph3a4.sobatjajan.model.Menu;
import id.ac.telkomuniversity.dph3a4.sobatjajan.model.Pesanan;
import id.ac.telkomuniversity.dph3a4.sobatjajan.model.Vendor;

public class PesananSayaFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_pesanan_saya, container, false);

        final Context context = root.getContext();

        ListView listView = root.findViewById(R.id.pesanan_saya_listview);
        PesananSayaAdapter adapter = new PesananSayaAdapter(root.getContext(),getDataPesanan());

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("VENDOR DIPILIH",getDataPesanan().get(i).getMenuList().get(0).getNama());
                Intent intent = new Intent(getContext(), DetailPesananSayaActivity.class);
                intent.putExtra("data_pesanan",getDataPesanan().get(i));
                startActivity(intent);
            }
        });

        listView.setAdapter(adapter);

        return root;
    }

    public List<Pesanan> getDataPesanan(){
        List<Pesanan> list = new ArrayList<>();

        Vendor vendor = new Vendor("Podomoro Warteg","","Makanan dan Minuman","0.08");

        list.add(new Pesanan(vendor,"Selesai",getDataMenu()));
        list.add(new Pesanan(vendor,"Sedang Diproses",getDataMenu()));
        list.add(new Pesanan(vendor,"Dibatalkan",getDataMenu()));
        list.add(new Pesanan(vendor,"Selesai",getDataMenu()));
        list.add(new Pesanan(vendor,"Selesai",getDataMenu()));

        return list;
    }

    private List<Menu> getDataMenu(){
        List<Menu> list= new ArrayList<>();
        list.add(new Menu(1,"Ayam Geprek","Ayam grprek enak","",13000,2));
        list.add(new Menu(2,"Ayam Geprek","Ayam grprek enak","",14000,1));

        return list;

    }
}