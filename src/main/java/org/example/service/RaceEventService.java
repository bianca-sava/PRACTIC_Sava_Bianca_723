package org.example.service;

import org.example.model.EventType;
import org.example.model.RaceEvent;
import org.example.repository.IRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RaceEventService extends AbstractService {

    public RaceEventService(IRepository repository) {
        super(repository);
    }

    public int calculatePoints(RaceEvent e) {
        return switch (e.getTyp()) {
            case OVERTAKE -> e.getBasePoints()+1;
            case FASTEST_LAP -> e.getBasePoints()+ 2 *(e.getLap() % 3);
            case TRACK_LIMITS -> e.getBasePoints() - 5;
            case COLLISION -> e.getBasePoints() - 10 - e.getLap();
            case PIT_STOP -> e.getLap() <= 10 ? e.getBasePoints() + 2 : e.getBasePoints();
        };
    }

    public void printPoints(){
        List<RaceEvent> events = repository.getAll();
        for (int i = 0; i < Math.min(5, events.size());){
            RaceEvent e = events.get(i);
            int computedPoints = calculatePoints(e);
            System.out.println("Event " + e.getId() + " -> raw=" + e.getBasePoints() + " -> computed=" + computedPoints);
            i++;
        }

    }

    public void exportReport(){
        Map<EventType, Long> reportMap = (Map<EventType, Long>) repository.getAll().stream()
                .collect(Collectors.groupingBy(
                        RaceEvent::getTyp,
                        Collectors.counting()
                ));
        StringBuilder sb = new StringBuilder();

        for (EventType type : EventType.values()) {
            Long count = reportMap.getOrDefault(type, 0L);
            sb.append(type).append(" -> ").append(count).append("\n");
        }

        try {
            Files.write(Path.of("race_report.txt"), sb.toString().getBytes());
            System.out.println("Saved in " + "race_report.txt");
        } catch (IOException e) {
            System.err.println("Error " + e.getMessage());
        }

    }




}
