package by.ysenko.task3.bean;

public final class Word extends Composite {

    @Override
    public String getString() {
        String response = "";

        for (Component letter : components) {
            response += letter.getString();
        }
        return response;
    }
}
