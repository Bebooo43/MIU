package book.composite;

import java.util.function.Consumer;

public abstract class Component {
    private String name;

    public Component(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void print();
    public abstract void forEach(Consumer<Component> action);//visitor design pattern
}
