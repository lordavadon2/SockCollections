package com.company.UILayer;

import com.company.DAOLayer.DAOFileSock;
import com.company.DAOLayer.IDAOSock;
import com.company.ModelLayer.*;

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
    SockMap sockMap;
    private String entVal = "Enter value: ";
    private String wrongVal = "Failed: wrong value";
    private String params = "The parametres was changed";


    public ConsoleSock(ISockModel sockModel) {
        this.sockModel = sockModel;
        scn = new Scanner(System.in);
        sockMap = new SockMap();
    }

    private static String getMainMenuText() {
        return "Show all: 0\nAdd new item: 1\nUpdate item: 2\n"
                + "Delete item: 3\nExit : 4\nPlease choice option: ";
    }

    private static String getUpdateMenuText() {
        return "Show sock parametres: 0\nChange type: 1\n" +
                "Change color: 2\nChange size: 3\nSave & exit: 4\n" +
                "Exit without saving: 5\n";
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
    private void changeParams(String value){
        System.out.println(entVal);
        System.out.println(sockMap.updateSockMap(value, scn.nextLine()) ?
                params : wrongVal);
    }

    @Override
    public ISock updateSock(ISock sock){
        System.out.println("Sock update menu");
        sockMap.createSockMap(sock);
        while (true) {
            System.out.println(getUpdateMenuText());
            Integer fieldIndex = Integer.parseInt(scn.nextLine());
            switch (fieldIndex) {
                case 0:
                    System.out.println(sockMap.showSockMap());
                    break;
                case 1:
                    changeParams("type");
                    break;
                case 2:
                    changeParams("color");
                    break;
                case 3:
                    changeParams("size");
                    break;
                case 4:
                    return sockMap.getSockMap(sock);
                case 5:
                    return sock;
                default:
                    System.out.println("Wrong command!");
            }
        }
    }

    @Override
    public void deleteSock()
    {
        showSock(sockModel.getAllSocks());
        System.out.println("Please enter sock number for delete: ");
        int id = Integer.parseInt(scn.nextLine());
        if (sockModel.deleteSock(id)) {
            System.out.println("Removed.");
        }
        else {
            System.out.println("Removing error.");
        }
    }

    private void sockUpdate() {
        showSock(sockModel.getAllSocks());
        System.out.println("Please enter sock number: ");
        Integer sockId = Integer.parseInt(scn.nextLine());
        ISock sock = sockModel.getSockById(sockId);
        sock = updateSock(sock);
        sockModel.updateSock(sock);
    }

    @Override
    public boolean mainMenu() {
       while(true) {
           System.out.println(getMainMenuText());
           Integer res = Integer.parseInt(scn.nextLine());
           switch (res) {
               case 0:
                   showSock(sockModel.getAllSocks());
                   return true;
               case 1:
                   sockModel.addSock(getSockFromUser());
                   return true;
               case 2:
                   sockUpdate();
                   return true;
               case 3:
                   deleteSock();
                   return true;
               case  4:
                  return false;
           }
       }
    }
}
