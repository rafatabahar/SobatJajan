package id.ac.telkomuniversity.dph3a4.sobatjajan.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import id.ac.telkomuniversity.dph3a4.sobatjajan.R;

public class CartAdapter extends BaseAdapter {

    private Context context;

    public CartAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final ViewHolder viewHolder;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.card_keranjang,viewGroup,false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = view.findViewById(R.id.cart_foto);
            viewHolder.nama = view.findViewById(R.id.cart_nama_item);
            viewHolder.deskripsi = view.findViewById(R.id.cart_deskripsi);
            viewHolder.harga = view.findViewById(R.id.cart_harga);
            viewHolder.plus = view.findViewById(R.id.cart_plus);
            viewHolder.minus = view.findViewById(R.id.cart_minus);
            viewHolder.quantity = view.findViewById(R.id.cart_quantity);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }


        viewHolder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int q = Integer.parseInt(viewHolder.quantity.getText().toString());
                viewHolder.quantity.setText(""+(q+1));
            }
        });

        viewHolder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int q = Integer.parseInt(viewHolder.quantity.getText().toString());
                viewHolder.quantity.setText(""+(q-1));
            }
        });

        return view;
    }

    public static class ViewHolder{
        ImageView imageView;
        TextView nama, deskripsi,harga, quantity;
        Button plus, minus;
    }
}
