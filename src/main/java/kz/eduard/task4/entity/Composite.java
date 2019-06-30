package kz.eduard.task4.entity;

import java.util.List;

public class Composite implements TextComponent {
    private List<TextComponent> componentList;
    private Type type;

    public Composite(Type type){
        this.type = type;
    }

    @Override
    public void add(TextComponent component) {
        componentList.add(component);
    }

    @Override
    public TextComponent getChild(int index) {
        return componentList.get(index);
    }

    @Override
    public void remove(TextComponent component) {
        componentList.remove(component);
    }

    @Override
    public int size() {
        return componentList.size();
    }

    public Type getType() {
        return type;
    }
}
