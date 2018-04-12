package com.company.DAOLayer;

import com.company.ModelLayer.ISock;

import java.util.List;

/**
 * Created by 1111 on 05.04.2018.
 */
public interface IDAOSock {

    int addSock(ISock sock);
    int[] addSock(ISock[] sock);

    List<ISock> readSock();
    ISock readSock(int id);

    boolean updateSock(ISock changedSock);

    boolean deleteSock(int id);
    boolean deleteSock(int[] id);
}
