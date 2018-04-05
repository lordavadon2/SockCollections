package com.company.DAOLayer;

import com.company.ModelLayer.ISock;
import com.company.ModelLayer.SockData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by 1111 on 05.04.2018.
 */
public class DAOFileSock implements IDAOSock {

    List<String> data ;
    public  DAOFileSock() throws IOException
    {
        Path path = Paths.get("testDataFile.txt");
        data =  Files.readAllLines(path);
    }

    @Override
    public boolean addSock(ISock sock) {
        return false;
    }

    @Override
    public boolean addSock(ISock[] sock) {
        return false;
    }


    ISock stringToSock(String str)
    {
        String []fields = str.split("|");
        int id = Integer.parseInt( fields[0]);
        String type = fields[1];
        String color = fields[2];
        int size = Integer.parseInt( fields[3]);
        return new SockData(type,color,size,id);
    }

    @Override
    public ISock[] readSock() {

        return new ISock[0];
    }

    @Override
    public ISock readSock(int id) {
        return null;
    }

    @Override
    public boolean updateSock(ISock changedSock) {
        return false;
    }

    @Override
    public boolean deleteSock(int id) {
        return false;
    }

    @Override
    public boolean deleteSock(int[] id) {
        return false;
    }
}
