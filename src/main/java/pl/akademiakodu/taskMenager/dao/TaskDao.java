package pl.akademiakodu.taskMenager.dao;

import pl.akademiakodu.taskMenager.model.Task;

import java.util.List;


public interface TaskDao {

    List<Task> findAll();
    List<Task> finished();
    List<Task> unfinished();
    void add(Task task);
    Task findById(int id);
    void deleteById(int id);
    void update(Task task);



}
