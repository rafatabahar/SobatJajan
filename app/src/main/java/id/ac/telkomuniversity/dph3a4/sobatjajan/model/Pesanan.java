package id.ac.telkomuniversity.dph3a4.sobatjajan.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Pesanan implements Parcelable {
    private Vendor vendor;
    private String status;
    private List<Menu> menuList;

    public Pesanan(Vendor vendor, String status, List<Menu> menuList) {
        this.vendor = vendor;
        this.status = status;
        this.menuList = menuList;
    }

    public Pesanan(Vendor vendor, String status) {
        this.vendor = vendor;
        this.status = status;
    }

    public Pesanan() {
    }


    protected Pesanan(Parcel in) {
        vendor = in.readParcelable(Vendor.class.getClassLoader());
        status = in.readString();
        menuList = in.createTypedArrayList(Menu.CREATOR);
    }

    public static final Creator<Pesanan> CREATOR = new Creator<Pesanan>() {
        @Override
        public Pesanan createFromParcel(Parcel in) {
            return new Pesanan(in);
        }

        @Override
        public Pesanan[] newArray(int size) {
            return new Pesanan[size];
        }
    };

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(vendor, i);
        parcel.writeString(status);
        parcel.writeTypedList(menuList);
    }
}
