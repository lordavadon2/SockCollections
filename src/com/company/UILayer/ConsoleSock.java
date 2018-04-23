package com.company.UILayer;

import com.company.DAOLayer.DAOFileSock;
import com.company.DAOLayer.IDAOSock;
import com.company.ModelLayer.ISockModel;
import com.company.ModelLayer.SockData;
import com.company.ModelLayer.ISock;
import com.company.ModelLayer.SockModel;

import java.io.Console;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;

/**
 * Created by 1111 on 05.04.2018.
 */
public class ConsoleSock implements IUISock {

    ISockModel sockModel;
    Scanner scn;
    public ConsoleSock(ISockModel sockModel)
    {
        this.sockModel = sockModel;
        scn = new Scanner(System.in);
    }

    private static String getMainMenuText()
    {
        return "Show all: 0\nAdd new item: 1\nUpdate item: 2\n"
                + "Delete item: 3\nExit : 4\nPlease choice option: ";
    }

    @Override
    public ISock getSockFromUser() {
        SockData result = new SockData();
        System.out.println("Please enter new sockData.");
        System.out.print("Type: ");
        result.setType(scn.nextLine());
        System.out.print("Size: ");
        result.setSize(Integer.parseInt(scn.nextLine()));
        System.out.print("Color: ");
        result.setColor(scn.nextLine());

        return result;
    }

    @Override
    public void showSock(ISock sock) {
        System.out.println(sock.toString());
    }

    @Override
    public void showSock(List<ISock> socks) {
        for (ISock sock: socks) {
            showSock(sock);
        }
    }
    @Override
    public ISock updateSock(ISock sock)
    {
        System.out.println("Data to change:");
        System.out.println("Field 1: " + sock.getType());
        System.out.println("Field 2: " + sock.getColor());
        System.out.println("Field 3: " + sock.getSize());
        System.out.println("Press 0 for exit");
        boolean continueEdit = true;
        while (continueEdit) {
            System.out.println("Please input field number for change:");
            Integer fieldIndex = Integer.parseInt(scn.nextLine());
            System.out.println("Please input new value:");
            String newValue = scn.nextLine();

            if (fieldIndex == 0) {
                return sock;
            }
            if (fieldIndex == 1) {
                sock.setType(newValue);
            }
            if (fieldIndex == 2) {
                sock.setColor(newValue);
            }
            if (fieldIndex == 3) {
                sock.setSize(Integer.parseInt(newValue));
            }
        }
        return  null;
    }

    @Override
    public void deleteSock()
    {
        showSock(sockModel.getAllSocks());
        System.out.println("Please enter sock number for delete: ");
        int id = Integer.parseInt(scn.nextLine());
        if (sockModel.deleteSock(id))
        {
            System.out.println("Removed.");
        }
        else
        {
            System.out.println("Removing error.");
        }
    }

    private void sockUpdate(int id)
    {
        ISock sock = sockModel.getSockById(id);
        sock = updateSock(sock);
        sockModel.updateSock(sock);
    }

    @Override
    public void mainMenu()
    {
       boolean continu = true;
       while(continu) {
           System.out.println(getMainMenuText());
           Integer res = Integer.parseInt(scn.nextLine());
           switch (res) {
               case 0:
                   showSock(sockModel.getAllSocks());
                   break;
               case 1:
                   ISock newSock = getSockFromUser();
                   sockModel.addSock(newSock);
                   break;
               case 2:
                   showSock(sockModel.getAllSocks());
                   System.out.println("Please enter sock number: ");
                   Integer sockId = Integer.parseInt(scn.nextLine());
                   sockUpdate(sockId);
                   break;
               case 3:
                   deleteSock();
                   break;
               case  4:
                   continu = false;
                   break;
           }
       }
    }
}
