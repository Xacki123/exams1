package re.tsvetkov.exams.fitness;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public class FitnessClub {
    // свойства
    private SeasonTicket[] gymArray = new SeasonTicket[20];
    private SeasonTicket[] poolArray = new SeasonTicket[20];
    private SeasonTicket[] groupArray = new SeasonTicket[20];

    // методы
    public void closeFitness() {
        Arrays.fill(groupArray, null);
        Arrays.fill(gymArray, null);
        Arrays.fill(poolArray, null);
    }

    // проверка на соответствие зоны
    public boolean zoneEquals(String zone, SeasonTicket seasonTicket) {
        for (int i = 0; i < seasonTicket.getTicketPermissions().getTicketPermission().length; i++) {
            if (zone.equals(seasonTicket.getTicketPermissions().getTicketPermission()[i])) return true;
        }
        return false;
    }

    // проверка на непросроченность абонимента
    public boolean dateEquals(SeasonTicket seasonTicket) {
        return (seasonTicket.getDateEndRegiste().isAfter(LocalDate.now()) || seasonTicket.getDateEndRegiste().isEqual(LocalDate.now()));
    }

    // проверка времени посещения
    public boolean timeEquals(SeasonTicket seasonTicket) {
        return ((!(seasonTicket.getTicketPermissions().getStartPermission().isAfter(LocalTime.now())) || seasonTicket.getTicketPermissions().getStartPermission().equals(LocalTime.now())) && !(seasonTicket.getTicketPermissions().getEndPermission().isBefore(LocalTime.now())) || seasonTicket.getTicketPermissions().getEndPermission().equals(LocalTime.now()));
    }

    // проверка заполненности зоны
    public boolean fullnessZone(SeasonTicket[] zoneArray) {
        for (int i = 0; i < zoneArray.length; i++) {
            if (zoneArray[i] == null) return true;

        }
        return false;
    }

    // проверка на вхождение в другую зону
    public boolean enterTicket(SeasonTicket[] seasonTickets, SeasonTicket seasonTicket) {
        for (int i = 0; i < seasonTickets.length; i++) {
            if (seasonTickets[i] == seasonTicket) return true;
        }
        return false;
    }

    public void comingFitness(String zone, SeasonTicket seasonTicket) {
        if (!zoneEquals(zone, seasonTicket)) {
            System.out.println("Вы не можете войти в эту зону");
            return;
        }
        if (!dateEquals(seasonTicket)) {
            System.out.println("Ваш абанимент просрочен");
            return;
        }
        if (!timeEquals(seasonTicket)) {
            System.out.println("Вы пришли не в то время");
            return;
        }
        if (zone.equals("бассейн")) {
            if (!fullnessZone(poolArray)) {
                System.out.println("Извините, зона переаолнена");
                return;
            }
            if (enterTicket(poolArray, seasonTicket) || enterTicket(gymArray, seasonTicket) || enterTicket(groupArray, seasonTicket)){
                System.out.println("Ваш абанимент зарегистрирован в другой зоне");
                return;
            }
            addZone(poolArray, seasonTicket, zone);
        } else if (zone.equals("тренажерный зал")) {
            if (!fullnessZone(gymArray)) {
                System.out.println("Извините, зона переаолнена");
                return;
            }
            if (enterTicket(poolArray, seasonTicket) || enterTicket(gymArray, seasonTicket) || enterTicket(groupArray, seasonTicket)){
                System.out.println("Ваш абанимент зарегистрирован в другой зоне");
                return;
            }
            addZone(gymArray, seasonTicket, zone);
        } else {
            if (!fullnessZone(groupArray)) {
                System.out.println("Извините, зона переаолнена");
                return;
            }
            if (enterTicket(poolArray, seasonTicket) || enterTicket(gymArray, seasonTicket) || enterTicket(groupArray, seasonTicket)){
                System.out.println("Ваш абанимент зарегистрирован в другой зоне");
                return;
            }
            addZone(groupArray, seasonTicket, zone);
        }
    }

    // добавление абанимента в зону
    public void addZone(SeasonTicket[] zone, SeasonTicket seasonTicket, String name) {
        for (int i = 0; i < zone.length; i++) {
            if (zone[i] == null) {
                zone[i] = seasonTicket;
                System.out.println("Посетитель " + seasonTicket.getClient().getSurnema() + " " + seasonTicket.getClient().getName() + " зарегистрирован в зоне '"+ name +"' " + LocalDate.now() + " в " + LocalTime.now());
                return;
            }
        }
    }

    public void getFitnessClub() {
        System.out.println("Посетители тренажерного зала: " + Arrays.toString(gymArray));
        System.out.println("Посетители бассейна: " + Arrays.toString(poolArray));
        System.out.println("Посетители групповых занятий: " + Arrays.toString(groupArray));
    }

}
