package re.tsvetkov.exams.fitness;

import java.time.LocalTime;

public enum TicketPermission {
    // Объекты
    РАЗОВЫЙ(new String[]{"бассейн" , "тренажерный зал"}, "Разовый", LocalTime.of(8,00), LocalTime.of(22,00)),
    ДНЕВНОЙ(new String[] {"тренажерный зал" , "групповые занятия"}, "Дневной", LocalTime.of(8,00), LocalTime.of(16,00)),
    ПОЛНЫЙ(new String[] {"тренажерный зал" , "бассейн", "групповые занятия"}, "Полный", LocalTime.of(8,00), LocalTime.of(22,00));

    // свойства
    private String[] ticketPermission;
    private String name;
    private LocalTime startPermission;
    private LocalTime endPermission;

    // конструктор
    TicketPermission(String[] ticketPermission, String name,LocalTime startPermission, LocalTime endPermission){
        this.name = name;
        this.ticketPermission = ticketPermission;
        this.startPermission = startPermission;
        this.endPermission = endPermission;
    }

    public String[] getTicketPermission() {
        return ticketPermission;
    }

    public String getName() {
        return name;
    }

    public LocalTime getStartPermission() {
        return startPermission;
    }

    public LocalTime getEndPermission() {
        return endPermission;
    }


}
