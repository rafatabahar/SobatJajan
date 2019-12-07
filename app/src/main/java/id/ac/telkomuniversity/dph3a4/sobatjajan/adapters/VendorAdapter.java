package id.ac.telkomuniversity.dph3a4.sobatjajan.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import id.ac.telkomuniversity.dph3a4.sobatjajan.R;
import id.ac.telkomuniversity.dph3a4.sobatjajan.model.Vendor;

public class VendorAdapter extends BaseAdapter {

    private Context context;
    private List<Vendor> vendorList;

    public VendorAdapter(Context context, List<Vendor> vendorList) {
        this.context = context;
        this.vendorList = vendorList;
    }

    @Override
    public int getCount() {
        return vendorList.size();
    }

    @Override
    public Object getItem(int i) {
        return vendorList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.card_vendor,viewGroup,false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = view.findViewById(R.id.card_vendor_foto);
            viewHolder.nama = view.findViewById(R.id.card_vendor_nama);
            viewHolder.kategori = view.findViewById(R.id.card_vendor_kategori);
            viewHolder.jarak = view.findViewById(R.id.card_vendor_jarak);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.nama.setText(vendorList.get(i).getNama());
        viewHolder.kategori.setText(vendorList.get(i).getKategori());
        viewHolder.jarak.setText(vendorList.get(i).getJarak()+" KM");

        return view;
    }

    public static class ViewHolder{
        ImageView imageView;
        TextView nama,kategori,jarak;
    }
}
