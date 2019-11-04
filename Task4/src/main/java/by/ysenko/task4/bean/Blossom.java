package by.ysenko.task4.bean;

import by.ysenko.task4.bean.visual.BlossomVisualParameters;

public class Blossom extends Flower {

   private boolean fruits;

    public Blossom(){
        setVisualParameters(new BlossomVisualParameters());
    }

    public boolean isFruits() {
        return fruits;
    }

    public void setFruits(boolean fruits) {
        this.fruits = fruits;
    }

}
