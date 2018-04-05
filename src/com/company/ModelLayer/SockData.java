package com.company.ModelLayer;

/**
 * Created by 1111 on 05.04.2018.
 */
public class SockData implements ISock {

    String type;
    String color;
    int size;
    int id;

    public  SockData()
    {
        this.type = "";
        this.color = "";
        this.size = 0;
        this.id = -1;
    }

    public  SockData(String type, String color, int size)
    {
        this.type = type;
        this.color = color;
        this.size = size;
        this.id = -1;
    }

    public  SockData(String type, String color, int size, int id)
    {
        this.type = type;
        this.color = color;
        this.size = size;
        this.id = id;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("");
        sb.append(this.id);
        sb.append("|" + this.type);
        sb.append("|" + this.color);
        sb.append("|" + this.size);
        return  sb.toString();
    }
}
