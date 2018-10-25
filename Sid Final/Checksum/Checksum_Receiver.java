import java.net.*; 
import java.io.*;

public class Checksum_Receiver
{
    public static void main(String args[]) throws IOException
    {
        InetAddress addr = InetAddress.getByName("192.168.0.102");
        Socket s = new Socket(addr, 1234);

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        int n = dis.readInt();
        System.out.println("N = "+n);
        int sum = 0;
        int curr;
        for(int i=0; i<n; i++)
        {
            curr = dis.readInt();
            System.out.println("element = "+curr);
            sum += curr;
        }
        int check = dis.readInt();
        System.out.println("check = "+check);
        sum += check;

        System.out.println("CheckSum is : "+sum);

        int res = sum & (sum+1);

        if(res == 0)
            System.out.println("Valid");
        else
            System.out.println("Invalid");
    }
}