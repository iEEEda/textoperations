package kz.eduard.task4.action;

import kz.eduard.task4.entity.TextComponent;

public abstract class AbstractParser {
    public abstract TextComponent splitText(String text);
}
