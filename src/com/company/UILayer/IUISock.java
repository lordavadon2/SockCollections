package com.company.UILayer;

import com.company.ModelLayer.ISock;

/**
 * Created by 1111 on 05.04.2018.
 */
public interface IUISock {

    ISock getSockFromUser();
    void showSock(ISock sock);
    void showSock(ISock [] socks);
    public ISock updateSock(ISock sock);

}
