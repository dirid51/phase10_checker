package net.bhp.phase10;

public class Card {

    private Integer id;
    private Integer value;

    public Card() {

    }

    public Card(Integer id, Integer value) {
        this.id = id;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
