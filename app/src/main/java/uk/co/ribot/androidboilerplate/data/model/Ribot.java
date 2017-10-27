package uk.co.ribot.androidboilerplate.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Ribot implements Parcelable {

    public Profile profile;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.profile, flags);
    }

    public Ribot() {
    }

    protected Ribot(Parcel in) {
        this.profile = in.readParcelable(Profile.class.getClassLoader());
    }

    public static final Parcelable.Creator<Ribot> CREATOR = new Parcelable.Creator<Ribot>() {
        @Override
        public Ribot createFromParcel(Parcel source) {
            return new Ribot(source);
        }

        @Override
        public Ribot[] newArray(int size) {
            return new Ribot[size];
        }
    };
}

