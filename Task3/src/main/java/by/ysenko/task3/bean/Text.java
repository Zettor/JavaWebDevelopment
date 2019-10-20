package by.ysenko.task3.bean;

import by.ysenko.task3.service.specifications.Specification;

import java.util.ArrayList;

public final class Text extends Composite {

    @Override
    public String getString() {
        String response = "";

        for (Component paragraph : components) {
            response += " " + paragraph.getString();
        }
        return response;
    }

    /**
     * Method for work with text.
     *
     * @param specification - one of specification classes.
     * @return special ArrayList of components.
     */
    public ArrayList<Component> querry(final Specification specification) {
        return specification.querry();
    }



}
