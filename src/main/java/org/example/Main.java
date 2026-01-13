package org.example;


import org.example.controller.ConsoleController;
import org.example.repository.DriverRepo;
import org.example.repository.PenaltyRepo;
import org.example.repository.RaceEventRepo;
import org.example.service.DriverService;
import org.example.service.PenaltyService;
import org.example.service.RaceEventService;

public class Main {
    public static void main(String[] args) {
        DriverRepo driverRepo = new DriverRepo("drivers.json");
        PenaltyRepo penaltyRepo = new PenaltyRepo("penalties.json");
        RaceEventRepo raceEventRepo = new RaceEventRepo("events.json");

        DriverService driverService = new DriverService(driverRepo);
        PenaltyService penaltyService = new PenaltyService(penaltyRepo);
        RaceEventService raceEventService = new RaceEventService(raceEventRepo);

        ConsoleController console = new ConsoleController(driverService, raceEventService, penaltyService);

        console.start();

    }
}