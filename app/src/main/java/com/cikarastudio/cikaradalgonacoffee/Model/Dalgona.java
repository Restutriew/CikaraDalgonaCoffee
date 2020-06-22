package com.cikarastudio.cikaradalgonacoffee.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Dalgona implements Parcelable {
    private String judul;
    private String deskripsi;
    private Integer image;
    private Integer image2;

    public Dalgona() {

    }

    public Dalgona(String judul, String deskripsi, Integer image, Integer image2) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.image = image;
        this.image2 = image2;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public Integer getImage2() {
        return image2;
    }

    public void setImage2(Integer image2) {
        this.image2 = image2;
    }

    public static Creator<Dalgona> getCREATOR() {
        return CREATOR;
    }

    protected Dalgona(Parcel in) {
        judul = in.readString();
        deskripsi = in.readString();
        if (in.readByte() == 0) {
            image = null;
        } else {
            image = in.readInt();
        }
        if (in.readByte() == 0) {
            image2 = null;
        } else {
            image2 = in.readInt();
        }
    }

    public static final Creator<Dalgona> CREATOR = new Creator<Dalgona>() {
        @Override
        public Dalgona createFromParcel(Parcel in) {
            return new Dalgona(in);
        }

        @Override
        public Dalgona[] newArray(int size) {
            return new Dalgona[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(judul);
        parcel.writeString(deskripsi);
        if (image == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(image);
        }
        if (image2 == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(image2);
        }
    }
}
