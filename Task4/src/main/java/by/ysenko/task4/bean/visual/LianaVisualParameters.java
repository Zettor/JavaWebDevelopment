package by.ysenko.task4.bean.visual;

public class LianaVisualParameters extends VisualParameters {

    String leafType;

    public String getLeafType() {
        return leafType;
    }

    public void setLeafType(String leafType) {
        this.leafType = leafType;
    }

    @Override
    public String toString() {
        return "LianaVisualParameters{" +
                "leafType='" + leafType + '\'' +
                '}';
    }
}
