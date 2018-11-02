package com.test.demos.demos;

import android.os.Parcel;
import android.os.Parcelable;

public class Message implements Parcelable {
    private String name;
    private String code;
    private int num;

    protected Message(Parcel in) {
        name = in.readString();
        code = in.readString();
        num = in.readInt();
    }

    public Message(String name,String code){
        this.name = name;
        this.code = code;
        num = 5;
    }

    public String toString(){
        return "name :" + name + " code : " + code + " num : " + num;
    }

    public static final Creator<Message> CREATOR = new Creator<Message>() {
        @Override
        public Message createFromParcel(Parcel in) {
            return new Message(in);
        }

        @Override
        public Message[] newArray(int size) {
            return new Message[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }



    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(code);
        dest.writeInt(num);
    }
}
