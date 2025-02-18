package model;

import java.util.ArrayList;
import java.util.List;

public class Charakter {
    private int id;
    private String name;
    private String region;
    private List<Produkt> produkte;

    public Charakter(int id, String name, String region) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.produkte = new ArrayList<>();
    }

    public void kaufeProdukt(Produkt produkt) {
        produkte.add(produkt);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public List<Produkt> getProdukte() {
        return produkte;
    }

    @Override
    public String toString() {
        return id + ": " + name + " - " + region;
    }
}
