import java.net.*; 
import java.io.*;
import java.util.*;

public class Checksum_Sender
{
    public static void main(String args[]) throws IOException
    {
        ServerSocket s = new ServerSocket(1234);
        Socket socket = s.accept();

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter no. of data : ");
        int n = sc.nextInt();
        dos.writeInt(n); 

        int checksum = 0;

        for(int i=0; i<n; i++)
        {
            int curr = sc.nextInt();
            checksum += (curr);
            dos.writeInt(curr); 
        }
        System.out.println("Checksum Calculated is : " + ~checksum); 
        dos.writeInt(~checksum);
    }
}