package by.ysenko.task3.service.specifications;

import by.ysenko.task3.bean.Component;

import java.util.ArrayList;

public interface Specification {

    /**
     * Method for different operation with text.
     * @return edit list of components.
     */
    ArrayList<Component> querry();
}
