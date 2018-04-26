package com.company.ModelLayer;

import java.util.HashMap;
import java.util.Map;

public class SockMap implements ISockMap {

    Map<String, String> sockMap;

    public SockMap() {
        this.sockMap = new HashMap<>();
    }

    @Override
    public boolean createSockMap(ISock sock){
        sockMap.put("type", sock.getType());
        sockMap.put("color", sock.getColor());
        sockMap.put("size", String.valueOf(sock.getSize()));
        return true;
    }

    @Override
    public String showSockMap(){
        StringBuilder sb = new StringBuilder("");
        sb.append("Type: " + sockMap.get("type") + "\n");
        sb.append("Color: " + sockMap.get("color") + "\n");
        sb.append("Size: " + sockMap.get("size") + "\n");
        return sb.toString();
    }

    @Override
    public boolean updateSockMap(String key, String value){
        if (value =="" || value == null){
            return false;
        }
        sockMap.put(key, value);
        return true;
    }

    @Override
    public ISock getSockMap(ISock sock){
        if (null == sock){
            return sock;
        }
        sock.setType(sockMap.get("type"));
        sock.setColor(sockMap.get("color"));
        sock.setSize(Integer.parseInt(sockMap.get("size")));
        System.out.println("Saved...");
        return sock;
    }

    @Override
    public String getSockParam(String key){
        return sockMap.get(key);
    }
}
