package com.javarush.popelo.quest.repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

public class PersistantRepository<K, T> extends Repository<K, T>{

    public PersistantRepository(String filename) {
        try {
            this.load(filename);

        } catch (Exception ex) {
            repository = new HashMap<>();
        }
    }

    private void load(String filename) throws Exception {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
            try {
                this.repository = (Map) objectInputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                throw e;
            }
        }
    }


}
