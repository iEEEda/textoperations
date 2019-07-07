package kz.eduard.task4.entity;

public class Leaf implements TextComponent {
    private String symbol;

    public Leaf(String symbol){
        this.symbol = symbol;
    }

    @Override
    public void add(TextComponent component) {}

    @Override
    public TextComponent getChild(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(TextComponent component) {}

    @Override
    public int size() {
        return 1;
    }

    @Override
    public String print() {
        return symbol;
    }
}
