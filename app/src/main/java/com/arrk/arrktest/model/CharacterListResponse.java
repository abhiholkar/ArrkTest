package com.arrk.arrktest.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CharacterListResponse implements Parcelable {

    public static final Parcelable.Creator<CharacterListResponse> CREATOR = new Parcelable.Creator<CharacterListResponse>() {
        @Override
        public CharacterListResponse createFromParcel(Parcel source) {
            return new CharacterListResponse(source);
        }

        @Override
        public CharacterListResponse[] newArray(int size) {
            return new CharacterListResponse[size];
        }
    };
    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("next")
    @Expose
    private String next;
    @SerializedName("previous")
    @Expose
    private String previous;
    @SerializedName("results")
    @Expose
    private List<StarWarCharacter> results = null;

    public CharacterListResponse() {
    }

    protected CharacterListResponse(Parcel in) {
        this.count = in.readInt();
        this.next = in.readString();
        this.previous = in.readString();
        this.results = new ArrayList<>();
        in.readList(this.results, StarWarCharacter.class.getClassLoader());
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<StarWarCharacter> getResults() {
        return results;
    }

    public void setResults(List<StarWarCharacter> results) {
        this.results = results;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.count);
        dest.writeString(this.next);
        dest.writeString(this.previous);
        dest.writeList(this.results);
    }
}