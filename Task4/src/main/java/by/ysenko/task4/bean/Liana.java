package by.ysenko.task4.bean;

import by.ysenko.task4.bean.visual.LianaVisualParameters;

public class Liana extends Flower {

    private String type;

    public Liana(){
        setVisualParameters(new LianaVisualParameters());
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
