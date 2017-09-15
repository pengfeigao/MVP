package cn.imeina.mvpdemo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by gaopengfei on 2017/9/11.
 */

public class Girl implements Parcelable{

    /**
     * 头像地址
     */
    private String avatarUrl;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private int age;
    /**
     * 籍贯
     */
    private String address;

    public Girl() {
    }

    protected Girl(Parcel in) {
        avatarUrl = in.readString();
        name = in.readString();
        age = in.readInt();
        address = in.readString();
    }

    public static final Creator<Girl> CREATOR = new Creator<Girl>() {
        @Override
        public Girl createFromParcel(Parcel in) {
            return new Girl(in);
        }

        @Override
        public Girl[] newArray(int size) {
            return new Girl[size];
        }
    };

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "avatarUrl='" + avatarUrl + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(avatarUrl);
        parcel.writeString(name);
        parcel.writeInt(age);
        parcel.writeString(address);
    }
}
