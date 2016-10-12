package Dao;

import Models.Family;

import java.util.List;

public interface QueueDao {

    Family find();

    void save();

    List<Family> findAll();

}
