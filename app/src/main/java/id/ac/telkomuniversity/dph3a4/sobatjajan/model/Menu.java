package id.ac.telkomuniversity.dph3a4.sobatjajan.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Menu implements Parcelable {
    private int id;
    private String nama;
    private String deskripsi;
    private String foto;
    private int harga;
    private int porsi;

    public Menu(int id, String nama, String deskripsi, String foto, int harga) {
        this.id = id;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.foto = foto;
        this.harga = harga;
    }

    public Menu(int id, String nama, String deskripsi, String foto, int harga, int porsi) {
        this.id = id;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.foto = foto;
        this.harga = harga;
        this.porsi = porsi;
    }

    public Menu(int id, String nama, String deskripsi, String foto) {
        this.id = id;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.foto = foto;
    }

    public Menu() {
    }

    protected Menu(Parcel in) {
        id = in.readInt();
        nama = in.readString();
        deskripsi = in.readString();
        foto = in.readString();
        harga = in.readInt();
        porsi = in.readInt();
    }

    public static final Creator<Menu> CREATOR = new Creator<Menu>() {
        @Override
        public Menu createFromParcel(Parcel in) {
            return new Menu(in);
        }

        @Override
        public Menu[] newArray(int size) {
            return new Menu[size];
        }
    };

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getPorsi() {
        return porsi;
    }

    public void setPorsi(int porsi) {
        this.porsi = porsi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(nama);
        parcel.writeString(deskripsi);
        parcel.writeString(foto);
        parcel.writeInt(harga);
        parcel.writeInt(porsi);
    }
}
