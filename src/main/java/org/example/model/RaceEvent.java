package org.example.model;

public class RaceEvent implements HasID{
    private Integer id;
    private Integer fahrerId;
    private EventType typ;
    private int basePoints;
    private int lap;

    public RaceEvent(){}

    public RaceEvent(Integer id, Integer fahrerId, EventType typ, int basePoints, int lap) {
        this.id = id;
        this.fahrerId = fahrerId;
        this.typ = typ;
        this.basePoints = basePoints;
        this.lap = lap;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFahrerId() {
        return fahrerId;
    }

    public void setFahrerId(Integer fahrerId) {
        this.fahrerId = fahrerId;
    }

    public EventType getTyp() {
        return typ;
    }

    public void setTyp(EventType typ) {
        this.typ = typ;
    }

    public int getBasePoints() {
        return basePoints;
    }

    public void setBasePoints(int basePoints) {
        this.basePoints = basePoints;
    }

    public int getLap() {
        return lap;
    }

    public void setLap(int lap) {
        this.lap = lap;
    }

    @Override
    public String toString() {
        return "RaceEvents:" + id + ", " + fahrerId + ", " + typ + ", " + basePoints + ", " + lap;
    }
}
