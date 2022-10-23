package re.tsvetkov.exams.fitness;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Client {

    // свойства
    private String name;
    private String surname;
    private LocalDate dateBirth;

    // конструктор
    public Client(String name, String surname, LocalDate dateBirth){
        setName(name);
        setSurnema(surname);
        setDateBirth(dateBirth);
    }

    // геттеры и сетторы
    public String getName() {
        return name;
    }
    // может поменять имя
    public void setName(String name) {
        if (name == null || name.length() < 3  ){
            throw new IllegalArgumentException("Имя не может быть меньше 3 символов или пустым");
        }
        this.name = name;
    }

    public String getSurnema() {
        return surname;
    }
    // фамилия может быть изменена
    public void setSurnema(String surnema) {
        if (surnema == null || surnema.length() < 2){
            throw new IllegalArgumentException("Фамилия не может быть меньше 2 символов или пустым");
        }
        this.surname = surnema;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }
    // можно изменить дату рождения
    public void setDateBirth(LocalDate dateBirth) {
        if (ChronoUnit.YEARS.between(dateBirth, LocalDate.now()) < 14){
            throw new IllegalArgumentException("В зале могут заниматься с 14 лет");
        }
        this.dateBirth = dateBirth;
    }

    // переопределённые методы

    @Override
    public String toString() {
        return "Client{" +
                "Имя='" + name + '\'' +
                ", Фамилия='" + surname + '\'' +
                ", Дата рождения=" + dateBirth +
                '}';
    }
}
