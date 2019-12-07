package id.ac.telkomuniversity.dph3a4.sobatjajan.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Vendor implements Parcelable {
    private int id;
    private String nama;
    private String foto;
    private String kategori;
    private String jarak;

    public Vendor(int id, String nama, String foto, String kategori, String jarak) {
        this.id = id;
        this.nama = nama;
        this.foto = foto;
        this.kategori = kategori;
        this.jarak = jarak;
    }

    public Vendor(String nama, String foto, String kategori, String jarak) {
        this.nama = nama;
        this.foto = foto;
        this.kategori = kategori;
        this.jarak = jarak;
    }

    public Vendor() {
    }

    protected Vendor(Parcel in) {
        id = in.readInt();
        nama = in.readString();
        foto = in.readString();
        kategori = in.readString();
        jarak = in.readString();
    }

    public static final Creator<Vendor> CREATOR = new Creator<Vendor>() {
        @Override
        public Vendor createFromParcel(Parcel in) {
            return new Vendor(in);
        }

        @Override
        public Vendor[] newArray(int size) {
            return new Vendor[size];
        }
    };

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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getJarak() {
        return jarak;
    }

    public void setJarak(String jarak) {
        this.jarak = jarak;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(nama);
        parcel.writeString(foto);
        parcel.writeString(kategori);
        parcel.writeString(jarak);
    }
}
