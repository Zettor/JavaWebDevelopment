package by.ysenko.task3.bean;

public final class Paragraph extends Composite {


    @Override
    public String getString() {
        // String response = components.get(0).getString();
        String response = " ";
        for (int i = 0; i < components.size(); i++) {
            response += components.get(i).getString();
        }
        return response;
    }
}
