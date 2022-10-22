package re.tsvetkov.exams.fitness;

import java.time.LocalDate;
import java.time.LocalTime;

public class SeasonTicket {

    // свойства
    private String typeTicket;
    private LocalDate dateRegistr;
    private LocalDate dateEndRegiste;
    private Client client;
    private String[] ticketPermission;
    private LocalTime startPermission;
    private LocalTime endPermission;


    // конструктор
    public SeasonTicket(String typeTicket, Client client, LocalDate dateEndRegiste ){

        if (typeTicket == null && !typeTicket.equals("Разовый") && !typeTicket.equals("Дневной") && !typeTicket.equals("Полный")){
            throw new IllegalArgumentException("Не верно введён тип абонемента " + typeTicket);
        }
        if (client == null){
            throw new IllegalArgumentException("Клиент не может быть пустым");
        }
        this.typeTicket = typeTicket;
        this.client = client;
        dateRegistr = LocalDate.now();
        setDateEndRegiste(dateEndRegiste);
        ticketPermission(typeTicket);

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

    public LocalTime getStartPermission() {
        return startPermission;
    }

    public LocalTime getEndPermission() {
        return endPermission;
    }
    public String[] getTicketPermissions(){
        return ticketPermission;
    }

    // клиент может продлить текущий абонимент
    public void setDateEndRegiste(LocalDate dateEndRegiste) {
        if (LocalDate.now().isAfter(dateEndRegiste) || dateEndRegiste.equals(LocalDate.now())){
            throw new IllegalArgumentException("Дата окончания действия сертификата не может быть меньше текущей");
        }
        this.dateEndRegiste = dateEndRegiste;
    }

    // методы
    private void ticketPermission(String typeTicket){
        if (typeTicket.equals("Разовый")){
            ticketPermission =  new String[] {"бассейн" , "тренажерный зал"};
            startPermission = LocalTime.of(8,00);
            endPermission = LocalTime.of(22,00);
        }
        if (typeTicket.equals("Дневной")){
            ticketPermission =  new String[] {"тренажерный зал" , "групповые занятия"};
            startPermission = LocalTime.of(8,00);
            endPermission = LocalTime.of(16,00);
        }
        ticketPermission =  new String[] {"тренажерный зал" , "бассейн", "групповые занятия"};
        startPermission = LocalTime.of(8,00);
        endPermission = LocalTime.of(22,00);
    }

    // методы
    public String getTicketPermission(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Абонимент '").append(getTypeTicket()).append("' позволяет посещать:");
        for (int i = 0; i < ticketPermission.length; i++) {
            stringBuilder.append(" ").append(ticketPermission[i]).append(",");
        }
        stringBuilder.append( "с " ).append(startPermission).append(" до ").append(endPermission);
        return stringBuilder.toString();
    }

    // переопределённые методы

    @Override
    public String toString() {
        return "{" + "Клиент=" + client.getName() +" " + client.getSurnema() +
                ", тип билета='" + typeTicket + '\'' +
                ", дата окончания действия билета=" + dateEndRegiste +
                                '}';
    }
}
