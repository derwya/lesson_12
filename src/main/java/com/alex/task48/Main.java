package com.alex.task48;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class Main {
    private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private static ArrayList<User> users = new ArrayList<>();

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Choose way to add user:\n 1 - By File \n 2 - By URL\n Or type \"exit\" to exit or \"print\" for print all users");
            switch (reader.readLine()) {
                case "1":
                    System.out.println("Enter path to file:");
                    File file = new File(reader.readLine());
                    User user = OBJECT_MAPPER.readValue(file, User.class);
                    addUser(user);
                    break;
                case "2":
                    System.out.println("Enter URL:");
                    URL url = new URL(reader.readLine());
                    User user1 = OBJECT_MAPPER.readValue(url, User.class);
                    addUser(user1);
                    break;
                case "exit":
                    return;
                case "print":
                    users.forEach(System.out::println);
                    break;
                default:
                    System.out.println("ERROR: Cannot read input");
            }
            start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addUser(User user) {
        users.add(user);
        System.out.println("Added successful!");
    }

}