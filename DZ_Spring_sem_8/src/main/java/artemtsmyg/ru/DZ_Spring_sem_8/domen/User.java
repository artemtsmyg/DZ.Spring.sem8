package artemtsmyg.ru.DZ_Spring_sem_8.domen;

import java.util.Objects;

/**
 * Класс, представляющий пользователя
 */
public class User {
    private int id;
    private String firstName;
    private String lastName;

    /**
     * Получить идентификатор пользователя
     * @return идентификатор пользователя
     */
    public int getId() {
        return id;
    }

    /**
     * Получить имя пользователя
     * @return имя пользователя
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * Получить фамилию пользователя
     * @return фамилия пользователя
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Установить идентификатор пользователя
     * @param id идентификатор пользователя
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Установить имя пользователя
     * @param firstName имя пользователя
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Установить фамилию пользователя
     * @param lastName фамилия пользователя
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }
}