package controller;


import model.Produkt;
import model.Charakter;
import repository.IRepository;

import java.util.List;

public class Controller {
    private final IRepository<Charakter> charakterRepo;
    private final IRepository<Produkt> produktRepo;

    public Controller(IRepository<Charakter> charakterRepo, IRepository<Produkt> produktRepo) {
        this.charakterRepo = charakterRepo;
        this.produktRepo = produktRepo;
    }

    public void createProdukt(String name, double preis, String universum) {
        produktRepo.create(new Produkt(name, preis, universum));
    }

    public List<Produkt> getAllProdukte() {
        return produktRepo.getAll();
    }

    public void deleteProdukt(int id) {
        produktRepo.delete(id);
    }


    public void createCharakter(int id, String name, String region) {
        charakterRepo.create(new Charakter(id, name, region));
    }

    public List<Charakter> getAllCharaktere() {
        return charakterRepo.getAll();
    }

    public void deleteCharakter(int id) {
        charakterRepo.delete(id);
    }
}
