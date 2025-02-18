package view;

import controller.Controller;
import model.Charakter;
import model.Produkt;
import repository.IRepository;
import repository.InMemoryRepository;

import java.util.Scanner;

public class UI {
    private final Scanner scanner = new Scanner(System.in);
    private final Controller controller;

    public UI() {
        IRepository<Charakter> charakterRepo = new InMemoryRepository<>();
        IRepository<Produkt> produktRepo = new InMemoryRepository<>();
        this.controller = new Controller(charakterRepo, produktRepo);
        mainMenu();
    }

    public void mainMenu() {
        while (true) {
            System.out.println("\n1. Produktverwaltung");
            System.out.println("2. Charakterverwaltung");
            System.out.println("0. Beenden");

            System.out.print("Wahl: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> productMenu();
                //case 2 -> characterMenu();
                case 0 -> System.exit(0);
                default -> System.out.println("Ungultige Option!");
            }
        }
    }

    public void productMenu() {
        System.out.println("\n1. Produkt hinzufugen");
        System.out.println("2. Produkte anzeigen");
        System.out.println("3. Produkt loschen");
        System.out.println("0. Zuruck");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> {
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Preis: ");
                double preis = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Universum: ");
                String universum = scanner.nextLine();
                controller.createProdukt(name, preis, universum);
            }
            case 2 -> controller.getAllProdukte().forEach(System.out::println);
            case 3 -> {
                System.out.print("Produkt-ID: ");
                int id = scanner.nextInt();
                controller.deleteProdukt(id);
            }
            case 0 -> mainMenu();
            default -> System.out.println("Ungultige Option!");
        }
    }

    public static void main(String[] args) {
        new UI();
    }
}
