package by.ysenko.task4.bean;

import by.ysenko.task4.bean.tips.GrovingTips;
import by.ysenko.task4.bean.visual.VisualParameters;

public abstract class Flower {

    private int id;

    private String name;

    private String soil;

    private String origin;

    private GrovingTips grovingTips;

    private String multiplying;

    private VisualParameters visualParameters;

    Flower() {
        grovingTips = new GrovingTips();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSoil() {
        return soil;
    }

    public void setSoil(String soil) {
        this.soil = soil;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public GrovingTips getGrovingTips() {
        return grovingTips;
    }

    public void setGrovingTips(GrovingTips grovingTips) {
        this.grovingTips = grovingTips;
    }

    public String getMultiplying() {
        return multiplying;
    }

    public void setMultiplying(String multiplying) {
        this.multiplying = multiplying;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VisualParameters getVisualParameters() {
        return visualParameters;
    }

    public void setVisualParameters(VisualParameters visualParameters) {
        this.visualParameters = visualParameters;
    }


}