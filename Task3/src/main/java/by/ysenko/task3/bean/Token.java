package by.ysenko.task3.bean;

public final class Token extends Composite {



    @Override
    public String getString() {
        String response = "";

        for (Component word : components) {
            response += word.getString();
        }
        return response;
    }

}
