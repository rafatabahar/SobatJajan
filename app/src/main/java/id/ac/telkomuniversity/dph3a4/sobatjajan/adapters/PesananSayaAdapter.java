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
import id.ac.telkomuniversity.dph3a4.sobatjajan.model.Pesanan;

public class PesananSayaAdapter extends BaseAdapter {

    private Context context;
    private List<Pesanan> pesananList;

    public PesananSayaAdapter(Context context, List<Pesanan> pesananList) {
        this.context = context;
        this.pesananList = pesananList;
    }

    @Override
    public int getCount() {
        return pesananList.size();
    }

    @Override
    public Object getItem(int i) {
        return pesananList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


        ViewHolder holder;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.card_pesanan_saya,viewGroup,false);
            holder = new ViewHolder();
            holder.imageView = view.findViewById(R.id.pesanan_saya_foto);
            holder.nameView = view.findViewById(R.id.pesanan_saya_menu);
            holder.kategoriView = view.findViewById(R.id.pesanan_saya_kategori);
            holder.statusView = view.findViewById(R.id.pesanan_saya_status);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }


        holder.nameView.setText(pesananList.get(i).getVendor().getNama());
        holder.kategoriView.setText(pesananList.get(i).getVendor().getKategori());
        if (pesananList.get(i).getStatus().equalsIgnoreCase("Sedang Diproses")){
            holder.statusView.setBackground(context.getDrawable(R.drawable.button_status_progress));
        }else if (pesananList.get(i).getStatus().equalsIgnoreCase("Dibatalkan")){
            holder.statusView.setBackground(context.getDrawable(R.drawable.button_status_canceled));
        }

        holder.statusView.setText(pesananList.get(i).getStatus());

        return view;
    }

    static class ViewHolder{
        ImageView imageView;
        TextView nameView, kategoriView;
        Button statusView;
    }
}
