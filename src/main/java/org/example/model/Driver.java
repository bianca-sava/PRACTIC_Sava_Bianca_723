package org.example.model;

public class Driver implements HasID{
    private Integer id;
    private String name;
    private String team;
    private DriverStatus status;
    private int skillLevel;


    public Driver() {
    }

    public Driver(Integer id, String name, String team, DriverStatus status, int skillLevel) {
        this.id = id;
        this.name = name;
        this.team = team;
        this.status = status;
        this.skillLevel = skillLevel;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public DriverStatus getStatus() {
        return status;
    }

    public void setStatus(DriverStatus status) {
        this.status = status;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }

    @Override
    public String toString() {
        return "["+id+"] " + name + " ( " + team + ") - " + status + ", skill= " + skillLevel;
    }
}
