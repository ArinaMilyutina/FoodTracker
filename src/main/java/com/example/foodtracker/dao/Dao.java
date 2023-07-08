package com.example.foodtracker.dao;

import java.util.List;

public interface Dao<T> {
    void save(T value);

}
