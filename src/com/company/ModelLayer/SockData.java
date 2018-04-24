package com.company.ModelLayer;

import javax.activation.UnsupportedDataTypeException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 1111 on 05.04.2018.
 */
public class SockData implements ISock,Comparable {

    String type;
    String color;
    int size;
    int id;
    Map<String, String> sockMap;

    public  SockData()
    {
        this.type = "";
        this.color = "";
        this.size = 0;
        this.id = -1;
        sockMap = new HashMap<>();
    }

    public  SockData(String type, String color, int size)
    {
        this.type = type;
        this.color = color;
        this.size = size;
        this.id = -1;
        sockMap = new HashMap<>();
    }

    public  SockData(String type, String color, int size, int id)
    {
        this.type = type;
        this.color = color;
        this.size = size;
        this.id = id;
    }

    public  SockData(int id, ISock sock)
        {
        this.type = sock.getType();
        this.color = sock.getColor();
        this.size = sock.getSize();
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

    @Override
    public int compareTo(Object o) {
        if (o instanceof ISock)
        {
            if (this.getId() > ((ISock)o).getId()) return  1;
            if (this.getId() < ((ISock)o).getId()) return  -1;
        }
        return 0;
    }

}






//    public boolean createSockMap(ISock sock){
//        sockMap.put("type", sock.getType());
//        sockMap.put("color", sock.getColor());
//        sockMap.put("size", String.valueOf(sock.getSize()));
//        return true;
//    }
//
//    public String showSockMap(){
//        StringBuilder sb = new StringBuilder("");
//        sb.append("Type: " + sockMap.get("type") + "\n");
//        sb.append("Color: " + sockMap.get("color") + "\n");
//        sb.append("Size: " + sockMap.get("size") + "\n");
//        return sb.toString();
//    }
//
//    public boolean updateSockMap(String key, String value){
//        if (value =="" || value == null){
//            return false;
//        }
//        sockMap.put(key, value);
//        return true;
//    }
//
//    public ISock getSockMap(ISock sock){
//        if (null == sock){
//            return sock;
//        }
//        sock.setType(sockMap.get("type"));
//        sock.setColor(sockMap.get("color"));
//        sock.setSize(Integer.parseInt(sockMap.get("type")));
//        System.out.println("Saved...");
//        return sock;
//    }