package by.ysenko.task4.bean;

import by.ysenko.task4.bean.visual.VisualParameters;

public class Cactus extends Flower {

    private String subfamily;

    public Cactus(){
        setVisualParameters(new VisualParameters());
    }

    public String getSubfamily() {
        return subfamily;
    }

    public void setSubfamily(String subfamily) {
        this.subfamily = subfamily;
    }


}
