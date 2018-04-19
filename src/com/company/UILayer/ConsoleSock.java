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
    @Override
    public ISock updateSock(ISock sock)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Data to change:");
        System.out.println("Field 1: " + sock.getType());
        System.out.println("Field 2: " + sock.getColor());
        System.out.println("Field 3: " + sock.getSize());
        System.out.println("Press 0 for exit");
        boolean continueEdit = true;
        while (continueEdit) {
            System.out.println("Please input field number for change:");
            Integer fieldIndex = Integer.parseInt(sc.nextLine());
            System.out.println("Please input new value:");
            String newValue = sc.nextLine();

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

}
