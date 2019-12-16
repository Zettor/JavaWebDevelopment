package com.company;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class Main {

    static void method1(int... i){
        System.out.println("int");
    }
    static void method1(Integer... i){
        System.out.println("Integer");
    }
    static void method1(Number... i){
        System.out.println("Number");
    }
    static void method1(Object... i){
        System.out.println("Object");
    }

    public static void main(String[] args) {




        String password="sayan2013";
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        Formatter formatter = new Formatter();
        for (int i = 0; i < salt.length; i++) {
            formatter.format("%02X", salt[i]);
        }

        System.out.println(formatter.toString());

//        System.out.println(formatter.toString());
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = factory.generateSecret(spec).getEncoded();
            System.out.println(hash);
            formatter = new Formatter();
            for (int i = 0; i < hash.length; i++) {
                formatter.format("%02X", hash[i]);
            }
            System.out.println(formatter.toString());
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }

    }
}
