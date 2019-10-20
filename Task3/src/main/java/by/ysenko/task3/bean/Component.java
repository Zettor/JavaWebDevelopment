package by.ysenko.task3.bean;

import by.ysenko.task3.bean.exception.BeanException;

import java.util.ArrayList;

public interface Component {

    /**
     * This method add component for collection of components.
     *
     * @param component - component for adding.
     * @throws BeanException - when calling in Letter.
     */
    void add(Component component) throws BeanException;

    /**
     * This method remove component from collection of components.
     *
     * @param index - index of component for removing.
     * @throws BeanException - when calling in Letter.
     */
    void remove(int index) throws BeanException;

    /**
     * This method get component from collection of components.
     *
     * @param index - index of component for getting.
     * @return component with right index.
     * @throws BeanException - when calling in Letter.
     */
    Component getComponent(int index) throws BeanException;

    /**
     * This method remove component from collection of components.
     *
     * @return String text from this component.
     */
    String getString();

    /**
     * This method return collection of components of special type.
     *
     * @param type - class of collection for getting.
     * @return collection of componentss of special type.
     * @throws BeanException - when calling in Letter.
     */
    ArrayList<Component> getUnit(Class type) throws BeanException;


}
