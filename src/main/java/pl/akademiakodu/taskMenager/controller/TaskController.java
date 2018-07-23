package pl.akademiakodu.taskMenager.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        return "tasks/all";
    }


}
