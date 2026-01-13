package org.example.service;

import com.fasterxml.jackson.core.type.TypeReference;
import org.example.model.Driver;
import org.example.model.DriverStatus;
import org.example.model.Penalty;
import org.example.model.RaceEvent;
import org.example.repository.AbstractFileRepository;
import org.example.repository.IRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DriverService extends AbstractService<Driver> {
    public DriverService(IRepository<Driver> repository) {
        super(repository);
    }

    public List<Driver> filterByTeamAndStatus(String team ) {
        return repository.getAll().stream()
                .filter(driver -> driver.getTeam().equalsIgnoreCase(team) && driver.getStatus().equals(DriverStatus.ACTIVE))
                .toList();
    }

    public List<Driver> sortBySkill(){
        return repository.getAll().stream()
                .sorted(Comparator.comparingInt(Driver::getSkillLevel).reversed()
                        .thenComparing(Driver::getName))
                .toList();
    }

    public void exportDriversBySkill(){
        List<Driver> sortedDrivers = sortBySkill();
        StringBuilder sb = new StringBuilder();
        for (Driver driver : sortedDrivers) {
            sb.append(driver).append("\n");
        }

        try {
            Files.write(Path.of("drivers_sorted.txt"), sb.toString().getBytes());
            System.out.println("Saved in " + "drivers_sorted.txt");
        } catch (IOException e) {
            System.err.println("Error " + e.getMessage());
        }


    }


    public void printRanking(List<RaceEvent> events, List<Penalty> penalties, RaceEventService eventService) {

        Map<Driver, Integer> driverScores = repository.getAll().stream()
                .collect(Collectors.toMap(
                        d -> d,
                        d -> {
                            int eventScore = events.stream()
                                    .filter(e -> e.getFahrerId() == d.getId())
                                    .mapToInt(eventService::calculatePoints)
                                    .sum();

                            int penaltyScore = penalties.stream()
                                    .filter(g -> g.getFahrerId() == d.getId())
                                    .mapToInt(Penalty::getSeconds)
                                    .sum();

                            return eventScore - penaltyScore;
                        }
                ));

        driverScores.entrySet().stream().sorted((e1, e2) -> {
            int res = Integer.compare(e2.getValue(), e1.getValue());
            return (res != 0) ? res : e1.getKey().getName().compareTo(e2.getKey().getName());
        }).limit(5)
        .forEach(e -> System.out.println(e.getKey().getName() + " (" + e.getKey().getTeam() + ") -> " + e.getValue()));



        System.out.println("\nWinning team: " +
            driverScores.entrySet().stream()
                .collect(Collectors.groupingBy(
                    e -> e.getKey().getTeam(),
                    Collectors.summingInt(Map.Entry::getValue)
                ))
                .entrySet().stream()
                .max((e1, e2) -> {
                    int res = Integer.compare(e1.getValue(), e2.getValue());
                    return (res != 0) ? res : e1.getKey().compareTo(e2.getKey());
                })
                .map(Map.Entry::getKey)
                .orElse("No teams")
        );


    }


}
