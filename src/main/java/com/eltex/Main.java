package com.eltex;



public class Main {

    public static void main(String[] args) {
        final var service = new WallService();
        service.like();
        service.setAuthor("Автор");
        System.out.println(service.getPost());
    }
}