package by.ysenko.task4.bean.tips;

public class GrovingTips {

    private int temperature;

    private boolean lighting;

    private double watering;

    public int getTemperature() {
        return temperature;
    }

    public boolean isLighting() {
        return lighting;
    }

    public double getWatering() {
        return watering;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void setLighting(boolean lighting) {
        this.lighting = lighting;
    }

    public void setWatering(double watering) {
        this.watering = watering;
    }

    @Override
    public String toString() {
        return "GrovingTips{" +
                "temperature=" + temperature +
                ", lighting=" + lighting +
                ", watering=" + watering +
                '}';
    }


}
