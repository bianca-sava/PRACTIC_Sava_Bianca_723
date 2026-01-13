package org.example.controller;

import org.example.model.Driver;
import org.example.repository.RaceEventRepo;
import org.example.service.DriverService;
import org.example.service.PenaltyService;
import org.example.service.RaceEventService;

import java.util.List;
import java.util.Scanner;

public class ConsoleController {
    private DriverService driverService;
    private RaceEventService raceEventService;
    private PenaltyService penaltyService;
    private Scanner scanner;

    public ConsoleController(DriverService driverService, RaceEventService raceEventService, PenaltyService penaltyService) {
        this.driverService = driverService;
        this.raceEventService = raceEventService;
        this.penaltyService = penaltyService;
        this.scanner = new Scanner(System.in);
    }


    public void start(){

        boolean running = true;
        while (running) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Ex 1 ");
            System.out.println("2. Ex 2 ");
            System.out.println("3. Ex 3 ");
            System.out.println("4. Ex 4 ");
            System.out.println("5. Ex 5 ");
            System.out.println("6. Ex 6 ");
            System.out.println("7. Ex 7 ");
            System.out.println("0. Exit");
            System.out.print("Choose one: ");
            String choice = scanner.nextLine();


            switch (choice) {
                case "1" -> runEx1();
                case "2" -> runEx2();
                case "3" -> runEx3();
                case "4" -> runEx4();
                case "5" -> runEx5();
//                case "6" -> runEx6();
                case "7" -> runEx7();
                case "0" -> running = false;
                default -> System.out.println("Invalid option.");
            }

        }

    }

    private void runEx1() {
        System.out.println("\n--- Ex 1 ---");
        System.out.println("Drivers loaded: " + driverService.getAll().size());
        System.out.println("Events loaded: " + raceEventService.getAll().size());
        System.out.println("Penalties loaded: " + penaltyService.getAll().size());
        System.out.println("");

        List<Driver> drivers = driverService.getAll();

        for (Driver driver : drivers) {

            System.out.println(driver);}
    }

    private void runEx2() {

        System.out.println("\n--- Ex 2 ---");
        String team = scanner.nextLine();
        List<Driver> filteredDrivers = driverService.filterByTeamAndStatus(team);

        for (Driver driver : filteredDrivers) {
            System.out.println(driver);
        }

    }

    private void runEx3() {

        System.out.println("\n--- Ex 3 ---");
        List<Driver> sortedDrivers = driverService.sortBySkill();

        for (Driver driver : sortedDrivers) {
            System.out.println(driver);
        }

    }

    private void runEx4() {
        System.out.println("\n--- Ex 4 ---");
        driverService.exportDriversBySkill();
    }

    private void runEx5() {
        System.out.println("\n--- Ex 5 ---");
        raceEventService.printPoints();
    }

    private void runEx7() {
        System.out.println("\n--- Ex 7 ---");

        raceEventService.exportReport();
    }

}
