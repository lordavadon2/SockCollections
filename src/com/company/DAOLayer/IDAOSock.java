package com.company.DAOLayer;

import com.company.ModelLayer.ISock;

/**
 * Created by 1111 on 05.04.2018.
 */
public interface IDAOSock {

    boolean addSock(ISock sock);
    boolean addSock(ISock[] sock);

    ISock [] readSock();
    ISock readSock(int id);

    boolean updateSock(ISock changedSock);

    boolean deleteSock(int id);
    boolean deleteSock(int[] id);
}
