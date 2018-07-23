package pl.akademiakodu.taskMenager.controller;


import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.akademiakodu.taskMenager.dao.TaskDao;
import pl.akademiakodu.taskMenager.model.Task;

@Controller
public class TaskController {
    @Autowired
    private TaskDao taskDao;


    @GetMapping("/add")
    public String add() {
        return "tasks/add";
    }

    @PostMapping("/add")
    public String addTask(@ModelAttribute Task task) {
        taskDao.add(task);
        return "redirect:/all";
    }

    @GetMapping("/all")
    public String all(ModelMap modelMap) {
        modelMap.put("tasks", taskDao.findAll());
        modelMap.put("description", "List wszystkich zadań");
        return "tasks/all";
    }
    @GetMapping("/finished")
    public  String finished(ModelMap modelMap){
        modelMap.put("tasks",taskDao.finished());
        modelMap.put("description", "Lista zadań ukończonych");
        return "tasks/all";
    }
    @GetMapping("/unfinished")
    public String unfinished(ModelMap modelMap){
        modelMap.put("tasks",taskDao.unfinished());
        modelMap.put("description", "Lista zadań nieukończonych");
        return "tasks/all";
    }
    @GetMapping("/tasks/{id}")
    public String getTask(@PathVariable Integer id, ModelMap modelMap){
        modelMap.put("task", taskDao.findById(id));
        return "tasks/show";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Task task){
        taskDao.update(task);
        return "redirect:/all";
    }

}
