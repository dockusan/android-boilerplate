package uk.co.ribot.androidboilerplate.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

import java.util.Date;

public class Profile implements Parcelable {
    public Name name;
    public String email;
    public String hexColor;
    public Date dateOfBirth;
    @Nullable
    public String bio;
    @Nullable
    public String avatar;

    private Profile(Builder builder) {
        name = builder.name;
        email = builder.email;
        hexColor = builder.hexColor;
        dateOfBirth = builder.dateOfBirth;
        bio = builder.bio;
        avatar = builder.avatar;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.name, flags);
        dest.writeString(this.email);
        dest.writeString(this.hexColor);
        dest.writeLong(this.dateOfBirth != null ? this.dateOfBirth.getTime() : -1);
        dest.writeString(this.bio);
        dest.writeString(this.avatar);
    }

    protected Profile(Parcel in) {
        this.name = in.readParcelable(Name.class.getClassLoader());
        this.email = in.readString();
        this.hexColor = in.readString();
        long tmpDateOfBirth = in.readLong();
        this.dateOfBirth = tmpDateOfBirth == -1 ? null : new Date(tmpDateOfBirth);
        this.bio = in.readString();
        this.avatar = in.readString();
    }

    public static final Creator<Profile> CREATOR = new Creator<Profile>() {
        @Override
        public Profile createFromParcel(Parcel source) {
            return new Profile(source);
        }

        @Override
        public Profile[] newArray(int size) {
            return new Profile[size];
        }
    };

    public static final class Builder {
        private Name name;
        private String email;
        private String hexColor;
        private Date dateOfBirth;
        private String bio;
        private String avatar;

        public Builder() {
        }

        public Builder name(Name val) {
            name = val;
            return this;
        }

        public Builder email(String val) {
            email = val;
            return this;
        }

        public Builder hexColor(String val) {
            hexColor = val;
            return this;
        }

        public Builder dateOfBirth(Date val) {
            dateOfBirth = val;
            return this;
        }

        public Builder bio(String val) {
            bio = val;
            return this;
        }

        public Builder avatar(String val) {
            avatar = val;
            return this;
        }

        public Profile build() {
            return new Profile(this);
        }
    }
}
