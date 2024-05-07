package artemtsmyg.ru.DZ_Spring_sem_8.controller;

import artemtsmyg.ru.DZ_Spring_sem_8.domen.User;
import artemtsmyg.ru.DZ_Spring_sem_8.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Контроллер для управления пользователями.
 */
@Controller
public class UserController {
    private final UserService userService;

    /**
     * Конструктор класса UserController.
     * @param userService сервис для работы с пользователями
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Метод для отображения списка пользователей.
     * @param model модель для передачи данных в представление
     * @return представление с списком пользователей
     */
    @GetMapping("/users")
    public String findAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }

    /**
     * Метод для отображения формы создания пользователя.
     * @param user объект пользователя
     * @return представление для создания пользователя
     */
    @GetMapping("/user-create")
    public String createUserForm(User user){
        return "user-create";
    }

    /**
     * Метод для создания нового пользователя.
     * @param user объект пользователя
     * @return перенаправление на страницу списка пользователей
     */
    @PostMapping("/user-create")
    public String createUser(User user){
        userService.saveUser(user);
        return "redirect:/users";
    }

    /**
     * Метод для удаления пользователя по его ID.
     * @param id ID пользователя
     * @return перенаправление на страницу списка пользователей
     */
    @GetMapping("user-delete/{id}")
    String deleteUser(@PathVariable("id") int id){
        userService.deleteById(id);
        return "redirect:/users";
    }

    /**
     * Метод для отображения формы редактирования пользователя.
     * @param id ID пользователя
     * @param model модель для передачи данных в представление
     * @return представление для редактирования пользователя
     */
    @GetMapping("/user-update/{id}")
    String getOne(@PathVariable("id") int id, Model model){
        User user = userService.getOne(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    /**
     * Метод для обновления информации о пользователе.
     * @param user объект пользователя
     * @return перенаправление на страницу списка пользователей
     */
    @PostMapping("/user-update")
    String updateUser(User user){
        userService.updateUser(user);
        return "redirect:/users";
    }
}