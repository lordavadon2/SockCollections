package com.company;

import com.company.ModelLayer.ISock;
import com.company.UILayer.ConsoleSock;
import com.company.UILayer.IUISock;

public class Main {

    public static void main(String[] args) {

        IUISock socInput = new ConsoleSock();
        ISock sock = socInput.getSockFromUser();
        socInput.showSock(sock);
    }
}
