package org.example;

public class Main {
    public static void main(String[] args) {
        String url = "http://94.198.50.185:7081/api/users";
        Util util = new Util();
        User userToAdd = new User(3L, "James", "Brown", (byte) 34);
        System.out.println(util.save(userToAdd));
        System.out.println(util.getAll());
        User userToPatch = new User(3L, "Thomas", "Shelby", (byte) 34);
        System.out.println(util.patch(userToPatch));
        System.out.println(util.getAll());
        System.out.println(util.delete(3L));
        System.out.println(util.getAll());
    }
}