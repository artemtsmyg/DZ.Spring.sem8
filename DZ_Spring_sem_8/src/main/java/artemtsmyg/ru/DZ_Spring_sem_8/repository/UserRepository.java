package artemtsmyg.ru.DZ_Spring_sem_8.repository;

import artemtsmyg.ru.DZ_Spring_sem_8.domen.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Репозиторий для работы с пользователями
 */
@Repository
public class UserRepository {
    private final JdbcTemplate jdbc;

    /**
     * Конструктор класса UserRepository
     * @param jdbc JdbcTemplate для работы с базой данных
     */
    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    /**
     * Находит всех пользователей
     * @return Список пользователей
     */
    public List<User> findAll(){
        String sql = "SELECT * FROM userTable";

        RowMapper<User> userRowMapper = (r, i)->{
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };
        return jdbc.query(sql, userRowMapper);
    }

    /**
     * Сохраняет пользователя
     * @param user Пользователь для сохранения
     * @return Сохраненный пользователь
     */
    public User save(User user){
        String sql = "INSERT INTO userTable (firstName, lastName) VALUES (?, ?)";
        jdbc.update(sql, user.getFirstName(), user.getLastName());
        return user;
    }

    /**
     * Удаляет пользователя по его идентификатору
     * @param id Идентификатор пользователя для удаления
     */
    public void deleteById(int id){
        String sql = "DELETE FROM userTable WHERE id=?";
        jdbc.update(sql, id);
    }

    /**
     * Получает информацию о пользователе по его идентификатору
     * @param id Идентификатор пользователя
     * @return Информация о пользователе
     */
    public User getOne(int id){
        String sql = "SELECT * FROM userTable WHERE id=?";
        RowMapper<User> userRowMapper = (r, i)->{
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };
        return jdbc.queryForObject(sql, userRowMapper, id);
    }

    /**
     * Обновляет информацию о пользователе
     * @param user Пользователь с обновленными данными
     * @return Обновленный пользователь
     */
    public User update(User user){
        String sql = "UPDATE userTable SET firstName=?, lastName=? WHERE id=?";
        jdbc.update(sql, user.getFirstName(), user.getLastName(), user.getId());
        return user;
    }
}