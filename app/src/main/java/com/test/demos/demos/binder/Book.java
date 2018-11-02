package com.test.demos.demos.binder;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {
    public int bookNo;
    public String bookName;

    public Book(int book, String bookName){
        this.bookNo =  book;
        this.bookName = bookName;
    }

    protected Book(Parcel in) {
        bookNo = in.readInt();
        bookName = in.readString();
    }

    public int getBookNo() {
        return bookNo;
    }

    public void setBookNo(int bookNo) {
        this.bookNo = bookNo;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
       dest.writeInt(bookNo);
       dest.writeString(bookName);
    }


}
