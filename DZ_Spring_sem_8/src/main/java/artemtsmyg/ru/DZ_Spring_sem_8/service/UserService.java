package artemtsmyg.ru.DZ_Spring_sem_8.service;

import artemtsmyg.ru.DZ_Spring_sem_8.aspect.TrackUserAction;
import artemtsmyg.ru.DZ_Spring_sem_8.domen.User;
import artemtsmyg.ru.DZ_Spring_sem_8.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис для работы с пользователями.
 */
@Service
public class UserService {
    private final UserRepository userRepository;

    /**
     * Конструктор класса UserService
     * @param userRepository
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Находит всех пользователей.
     * @return Список пользователей
     */
    @TrackUserAction
    public List<User> findAll(){
        return userRepository.findAll();
    }

    /**
     * Сохраняет пользователя.
     * @param user Пользователь для сохранения
     * @return Сохраненный пользователь
     */
    @TrackUserAction
    public User saveUser(User user){
        return userRepository.save(user);
    }

    /**
     * Удаляет пользователя по идентификатору.
     * @param id Идентификатор пользователя
     */
    public void deleteById(int id){
        userRepository.deleteById(id);
    }

    /**
     * Получает пользователя по идентификатору.
     * @param id Идентификатор пользователя
     * @return Найденный пользователь
     */
    @TrackUserAction
    public User getOne(int id){
        System.out.println("User service get id: "+id);
        return userRepository.getOne(id);
    }

    /**
     * Обновляет информацию о пользователе.
     * @param user Обновленные данные пользователя
     * @return Обновленный пользователь
     */
    public User updateUser(User user){
        return userRepository.update(user);
    }
}
