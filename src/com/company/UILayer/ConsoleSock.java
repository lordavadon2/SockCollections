package com.company.UILayer;

import com.company.ModelLayer.SockData;
import com.company.ModelLayer.ISock;

import java.util.Scanner;

/**
 * Created by 1111 on 05.04.2018.
 */
public class ConsoleSock implements IUISock {
    @Override
    public ISock getSockFromUser() {
        Scanner sc = new Scanner(System.in);
        SockData result = new SockData();
        System.out.println("Please enter new sockData.");
        System.out.print("Type: ");
        result.setType(sc.nextLine());
        System.out.print("Size: ");
        result.setSize(Integer.parseInt(sc.nextLine()));
        System.out.print("Color: ");
        result.setColor(sc.nextLine());

        return result;
    }

    @Override
    public void showSock(ISock sock) {
        System.out.println(sock.toString());
    }

    @Override
    public void showSock(ISock[] socks) {
        for (ISock sock: socks) {
            showSock(sock);
        }
    }


}
