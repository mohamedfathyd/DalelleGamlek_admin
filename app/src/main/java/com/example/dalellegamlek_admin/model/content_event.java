package com.example.dalellegamlek_admin.model;

import com.google.gson.annotations.SerializedName;

public class content_event {
    @SerializedName("id_sender")
    int id_sender;
    @SerializedName("id_recevier")
    int id_recevier;
    @SerializedName("point")
    int point;

    public int getId_sender() {
        return id_sender;
    }

    public void setId_sender(int id_sender) {
        this.id_sender = id_sender;
    }

    public int getId_recevier() {
        return id_recevier;
    }

    public void setId_recevier(int id_recevier) {
        this.id_recevier = id_recevier;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
