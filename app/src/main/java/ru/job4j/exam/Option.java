package ru.job4j.exam;

import java.util.Objects;

public class Option {
    private int id;
    private String text;

    public Option(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Option option = (Option) o;
        return id == option.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
