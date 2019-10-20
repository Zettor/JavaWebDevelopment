package by.ysenko.task3.bean;

import by.ysenko.task3.bean.exception.BeanException;

import java.util.ArrayList;

public abstract class Composite implements Component {

    /**
     * List of components within this object.
     */
     protected ArrayList<Component> components;

    /**
     * Constructor for creating object.
     */
    protected Composite() {
        components = new ArrayList<>();
    }

    public ArrayList<Component> getUnit(final Class type) throws BeanException {

        if (type == components.get(0).getClass()) {
            return new ArrayList<Component>(components);
        }

        ArrayList<Component> componentList = new ArrayList<>();
        for (Component component : components) {
            componentList.addAll(component.getUnit(type));
        }
        return componentList;
    }

    @Override
    public void add(final Component component) {

        components.add(component);
    }


    @Override
    public void remove(final int index) {
        components.remove(index);
    }

    @Override
    public Component getComponent(final int index) {
        return components.get(index);
    }

}
