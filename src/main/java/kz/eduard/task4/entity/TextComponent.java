package kz.eduard.task4.entity;

public interface TextComponent {

    void add(TextComponent component);

    TextComponent getChild(int index);

    void remove(TextComponent component);

    int size();

    String print();

    // can add some operation that will be called on every TextComponent
}
