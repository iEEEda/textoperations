package kz.eduard.task4.entity;

import java.util.ArrayList;
import java.util.List;

public class Composite implements TextComponent {
    private List<TextComponent> componentList;
    private Type type;

    public Composite(Type type){
        this.type = type;
        componentList = new ArrayList<TextComponent>();
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

    @Override
    public String print(){
        String res = "";
        for (TextComponent component: componentList) {
            res += component.print();
        }
        if(type == Type.LEXEME) {
            res += " ";
        } else if(type == Type.SENTENCE){
            char[] changed = res.toCharArray();
            changed[changed.length - 1] = '.';
            res = new String(changed);
            res += " ";
        } else if(type == Type.PARAGRAPH){
            res += "\n";
        }
        return res;
    }
}
