package kz.eduard.task4.action;

import kz.eduard.task4.entity.TextComponent;

import java.util.Arrays;
import java.util.Comparator;

public class SortBySize implements SortTextComponents{
    @Override
    public void sort(TextComponent component) {
        TextComponent[] array = new TextComponent[component.size()];
        Comparator<TextComponent> componentComparator = (TextComponent b1, TextComponent b2) -> (b1.size() - b2.size());
        for (int i = 0; i < component.size(); i++) {
            array[i] = component.getChild(i);
        }
        Arrays.sort(array, componentComparator);
        for (int i = 0; i < array.length; i++) {
            component.remove(array[i]);
        }
        for (int i = 0; i < array.length; i++) {
            component.add(array[i]);
        }
    }
}
