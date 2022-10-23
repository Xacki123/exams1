package re.tsvetkov.exams.fitness;

import java.time.LocalDate;
import java.time.LocalTime;

public class SeasonTicket {

    // свойства
    private String typeTicket;
    private LocalDate dateRegistr;
    private LocalDate dateEndRegiste;
    private Client client;
    private TicketPermission ticketPermission;


    // конструктор
    public SeasonTicket(String typeTicket, Client client, LocalDate dateEndRegiste) {

        if (typeTicket == null || (!typeTicket.equals("Разовый") && !typeTicket.equals("Дневной") && !typeTicket.equals("Полный"))) {
            throw new IllegalArgumentException("Не верно введён тип абонемента " + typeTicket);
        }
        if (client == null) {
            throw new IllegalArgumentException("Клиент не может быть пустым");
        }
        this.typeTicket = typeTicket;
        this.client = client;
        dateRegistr = LocalDate.now();
        setDateEndRegiste(dateEndRegiste);

        this.ticketPermission = ticketPermission(typeTicket);

    }

    // геттеры и сеттер
    public String getTypeTicket() {
        return typeTicket;
    }

    public LocalDate getDateRegistr() {
        return dateRegistr;
    }

    public LocalDate getDateEndRegiste() {
        return dateEndRegiste;
    }

    public Client getClient() {
        return client;
    }


    public TicketPermission getTicketPermissions(){
        return ticketPermission;
    }

    // клиент может продлить текущий абонимент
    public void setDateEndRegiste(LocalDate dateEndRegiste) {
        if (LocalDate.now().isAfter(dateEndRegiste) || dateEndRegiste.equals(LocalDate.now())) {
            throw new IllegalArgumentException("Дата окончания действия сертификата не может быть меньше текущей");
        }
        this.dateEndRegiste = dateEndRegiste;
    }

    // методы
    private TicketPermission ticketPermission(String typeTicket) {
        if (typeTicket.equals("Разовый")) {
            return TicketPermission.РАЗОВЫЙ;
        }
        if (typeTicket.equals("Дневной")) {
            return TicketPermission.ДНЕВНОЙ;
        }
        return TicketPermission.ПОЛНЫЙ;
    }

    // методы
    public String getTicketPermission() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Абанимент '").append(ticketPermission.getName()).append("' позволяет посещать: ");
        for (int i = 0; i < ticketPermission.getTicketPermission().length; i++) {
            stringBuilder.append(ticketPermission.getTicketPermission()[i]).append(", ");
        }
        stringBuilder.append(" с ").append(ticketPermission.getStartPermission()).append(" до ").append(ticketPermission.getEndPermission());
        return stringBuilder.toString();
    }

    // переопределённые методы

    @Override
    public String toString() {
        return "{" + "Клиент=" + client.getName() + " " + client.getSurnema() +
                ", тип билета='" + typeTicket + '\'' +
                ", дата окончания действия билета=" + dateEndRegiste +
                '}';
    }
}
