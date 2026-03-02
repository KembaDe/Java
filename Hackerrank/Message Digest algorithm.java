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
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(input.getBytes());

            byte[] digest = md.digest();

            StringBuilder hexString = new StringBuilder();

            for (byte b : digest) {
                hexString.append(String.format("%02x", b));
            }

            System.out.println(hexString.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
