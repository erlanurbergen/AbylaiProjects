package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DBManager dbManager = new DBManager();
        while (true){
            System.out.println("[1] add user");
            System.out.println("[2] list user");
            System.out.println("[0] exit ");
            int choice = scanner.nextInt();

            if (choice == 1){
                System.out.println("[1] add student");
                System.out.println("[2] add staff");
                int choice2 = scanner.nextInt();
                if (choice2 == 1){
                   dbManager.addUser(new Student(new String[]{"java", "c++"}));
                } else if (choice2 == 2){
                    dbManager.addUser(new Staff(new String[]{"math", "oop"}));
                }

            } else if (choice == 2){
                System.out.println("[1] list student");
                System.out.println("[2] list staff");
                int choice2 = scanner.nextInt();
                if (choice2 == 1){
                    User[] users = dbManager.getUsers();
                    for (User user : users) {
                        if (user instanceof Student){
                            System.out.println(user.getData());
                        }
                    }
                } else if (choice2 == 2){
                    User[] users = dbManager.getUsers();
                    for (User user : users) {
                        if (user instanceof Staff){
                            System.out.println(user.getData());
                        }
                    }
                }
            } else if (choice == 0)
                break;
        }
    }
}

class User {
    private int id;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    public String getData() {
        return "User{" +
                "id=" + id +
                '}';
    }
}

class Student extends User{
    private String coruses[];

    public Student() {
    }

    public Student(String[] coruses) {
        this.coruses = coruses;
    }

    public Student(int id, String[] coruses) {
        super(id);
        this.coruses = coruses;
    }

    public String[] getCoruses() {
        return coruses;
    }

    @Override
    public String getData() {
        System.out.println(Arrays.toString(coruses));
        return super.getData();
    }
}

class Staff extends User{
    private String subjects[];

    public Staff() {
    }

    public Staff(String[] subjects) {
        this.subjects = subjects;
    }

    public Staff(int id, String[] subjects) {
        super(id);
        this.subjects = subjects;
    }

    public String[] getSubjects() {
        return subjects;
    }

    @Override
    public String getData() {
        System.out.println(Arrays.toString(subjects));
        return super.getData();
    }
}

class DBManager{
    User users[] = new User[100];
    int sizeOfusers = 0;

    void addUser(User user){
        users[sizeOfusers] = user;
        sizeOfusers++;
    }

    // list
    User[] getUsers(){
        return users;
    }
}
