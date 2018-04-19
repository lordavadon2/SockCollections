import com.company.DAOLayer.DAOFileSock;
import com.company.ModelLayer.ISock;
import com.company.ModelLayer.SockData;
import com.company.UILayer.ConsoleSock;
import com.company.UILayer.IUISock;

import java.io.IOException;


public class Main {

    public static void main(String[] args) {

       IUISock socInput = new ConsoleSock();

      // ISock sock = socInput.getSockFromUser();
        try {
            DAOFileSock daoObject = new DAOFileSock();

            ISock sock = socInput.updateSock(daoObject.readSock(0));
            daoObject.updateSock(sock);



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
