package com.example.todolist.Controller;

import com.example.todolist.Model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {

    List<Task> taskList = new ArrayList<>();

    @GetMapping("/listTodo")
    public String index(Model model, @RequestParam Integer limit) {
        // Trả về đối tượng todoList.
        // Nếu người dùng gửi lên param limit thì trả về sublist của todoList
        model.addAttribute("taskList", limit != null ? taskList.subList(0, limit) : taskList);

        // Trả về template "listTodo.html"
        return "listTodo";
    }


    @GetMapping("/addTodo")
    public String addTodo(Model model) {
        model.addAttribute("task", new Task());
        return "addTodo";
    }

    @PostMapping("/addTodo")
    public String addTodo(@ModelAttribute Task task) {
        taskList.add(task);
        return "success";
    }


}
