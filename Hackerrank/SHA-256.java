import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.security.*;

public class Solution {

    public static void main(String[] args) {
        
          Scanner sc = new Scanner(System.in);
          String input = sc.nextLine();   
          
          try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            byte[] hash = md.digest(input.getBytes());

            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }

            System.out.println(hexString.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
