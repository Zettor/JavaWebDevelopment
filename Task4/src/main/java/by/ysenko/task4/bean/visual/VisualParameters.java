package by.ysenko.task4.bean.visual;

public class VisualParameters {

    private String stemColor;

    private double size;

    public String getStemColor() {
        return stemColor;
    }

    public void setStemColor(String stemColor) {
        this.stemColor = stemColor;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "VisualParameters{" +
                "stemColor='" + stemColor + '\'' +
                ", size=" + size +
                '}';
    }
}
