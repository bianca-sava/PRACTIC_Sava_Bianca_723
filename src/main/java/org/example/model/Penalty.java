package org.example.model;

public class Penalty implements HasID{

    private Integer id;
    private Integer fahrerId;
    private StrafeGround grund;
    private int seconds;
    private int lap;


    public Penalty() {
    }

    public Penalty(Integer id, Integer fahrerId, StrafeGround grund, int seconds, int lap) {
        this.id = id;
        this.fahrerId = fahrerId;
        this.grund = grund;
        this.seconds = seconds;
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

    public StrafeGround getGrund() {
        return grund;
    }

    public void setGrund(StrafeGround grund) {
        this.grund = grund;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getLap() {
        return lap;
    }

    public void setLap(int lap) {
        this.lap = lap;
    }

    @Override
    public String toString() {
        return "Penalty:" + id + ", " + fahrerId + ", " + grund + ", " + seconds + ", " + lap;
    }
}
