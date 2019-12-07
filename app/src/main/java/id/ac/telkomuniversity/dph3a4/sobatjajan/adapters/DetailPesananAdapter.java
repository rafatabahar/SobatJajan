package id.ac.telkomuniversity.dph3a4.sobatjajan.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import id.ac.telkomuniversity.dph3a4.sobatjajan.R;
import id.ac.telkomuniversity.dph3a4.sobatjajan.model.Menu;

public class DetailPesananAdapter extends BaseAdapter {

    Context context;
    List<Menu> menuList;

    public DetailPesananAdapter(Context context, List<Menu> menuList) {
        this.context = context;
        this.menuList = menuList;
    }

    public DetailPesananAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return menuList.size();
    }

    @Override
    public Object getItem(int i) {
        return menuList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final ViewHolder holder;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.card_menu_dipesan,viewGroup,false);
            holder = new ViewHolder();
            holder.imageView = view.findViewById(R.id.card_makanan_foto);
            holder.nama = view.findViewById(R.id.card_makanan_menu);
            holder.harga = view.findViewById(R.id.card_makanan_harga);
            holder.quantity = view.findViewById(R.id.card_makanan_porsi);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        holder.nama.setText(menuList.get(i).getNama());
        holder.quantity.setText(menuList.get(i).getPorsi()+" Porsi");
        holder.harga.setText("Rp."+menuList.get(i).getHarga());

        return view;
    }

    public static class ViewHolder{
        ImageView imageView;
        TextView nama, harga, quantity;
    }
}
