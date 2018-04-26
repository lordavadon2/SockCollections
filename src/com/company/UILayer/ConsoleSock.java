package com.company.UILayer;

import com.company.ModelLayer.*;
import java.util.Scanner;
import java.util.List;
import static com.company.UILayer.ConsoleStrings.*;

/**
 * Created by 1111 on 05.04.2018.
 */
public class ConsoleSock implements IUISock {

    ISockModel sockModel;
    Scanner scn;
    ISockMap sockMap;


    public ConsoleSock(ISockModel sockModel) {
        this.sockModel = sockModel;
        scn = new Scanner(System.in);
        sockMap = new SockMap();
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
        System.out.println(ENTVAL);
        System.out.println(sockMap.updateSockMap(value, scn.nextLine()) ?
                PARAMS : WRONGVAL);
    }

    @Override
    public ISock updateSock(ISock sock){
        System.out.println("Sock update menu");
        sockMap.createSockMap(sock);
        while (true) {
            System.out.println(GETUPDATEMENUTEXT);
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
                    System.out.println(WARNING);
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
           System.out.println(GETMAINMENUTEXT);
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
                  default:
                      System.out.println(WARNING);
           }
       }
    }
}
