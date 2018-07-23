package pl.akademiakodu.taskMenager.dao;

import org.springframework.stereotype.Component;
import pl.akademiakodu.taskMenager.model.Task;

import java.util.ArrayList;
import java.util.List;
@Component
public class TaskDaoImpl implements TaskDao{
    private static List<Task> tasks = new ArrayList<>();
    private static int id = 1;

    @Override
    public List<Task> findAll() {
        return tasks;
    }

    @Override
    public void add(Task task) {
        task.setId(id++);
        tasks.add(task);
    }

    @Override
    public Task findById(int id) {
        return tasks.stream().
                filter(task -> task.getId() == id).
                findFirst().get();
    }

    @Override
    public void deleteById(int id) {
        Task task = findById(id);
        tasks.remove(task);
    }
}
