package by.ysenko.task4.bean.visual;

public class BlossomVisualParameters extends VisualParameters {


    String leafColor;

    public String getLeafColor() {
        return leafColor;
    }

    public void setLeafColor(String leafColor) {
        this.leafColor = leafColor;
    }

    @Override
    public String toString() {
        return "BlossomVisualParameters{" +
                "leafColor='" + leafColor + '\'' +
                '}';
    }
}
