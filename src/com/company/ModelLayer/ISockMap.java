package com.company.ModelLayer;

public interface ISockMap {
    boolean createSockMap(ISock sock);

    String showSockMap();

    boolean updateSockMap(String key, String value);

    ISock getSockMap(ISock sock);

    String getSockParam(String key);
}
