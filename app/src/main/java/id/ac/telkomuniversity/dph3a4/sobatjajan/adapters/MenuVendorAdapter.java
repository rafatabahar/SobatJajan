package id.ac.telkomuniversity.dph3a4.sobatjajan.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.ac.telkomuniversity.dph3a4.sobatjajan.R;
import id.ac.telkomuniversity.dph3a4.sobatjajan.activities.CartActivity;
import id.ac.telkomuniversity.dph3a4.sobatjajan.model.Menu;

public class MenuVendorAdapter extends RecyclerView.Adapter<MenuVendorAdapter.ViewHolder> {

    private Context context;
    private List<Menu> menuList;

    public MenuVendorAdapter(List<Menu> menuList) {
        this.menuList = menuList;
    }

    @NonNull
    @Override
    public MenuVendorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_menu, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        Menu menu = menuList.get(i);
        holder.deskripsi.setText(menu.getDeskripsi());
        holder.namaMenu.setText(menu.getNama());
        holder.harga.setText("Rp."+menu.getHarga());


        holder.btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CartActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView fotoMenu;
        TextView namaMenu,deskripsi,harga;
        Button btnTambah;
        public ViewHolder(View view) {
            super(view);
            fotoMenu = view.findViewById(R.id.card_menu_foto);
            namaMenu = view.findViewById(R.id.card_menu_nama);
            deskripsi = view.findViewById(R.id.card_menu_deskripsi);
            btnTambah = view.findViewById(R.id.card_menu_tambah);
            harga = view.findViewById(R.id.card_menu_harga);
        }

    }
}

