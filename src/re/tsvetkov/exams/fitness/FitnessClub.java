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
    public void closeFitness(){
        Arrays.fill(groupArray, null);
        Arrays.fill(gymArray, null);
        Arrays.fill(poolArray, null);
    }
    // проверка на соответствие зоны
    public boolean zoneEquals(String zone, SeasonTicket seasonTicket){
        for (int i = 0; i < seasonTicket.getTicketPermissions().length; i++) {
            if (zone.equals(seasonTicket.getTicketPermissions()[i])) return true;
        }
        return false;
    }
    // проверка на непросроченность абонимента
    public boolean dateEquals(SeasonTicket seasonTicket){
        return  (seasonTicket.getDateEndRegiste().isAfter(LocalDate.now()) || seasonTicket.getDateEndRegiste().isEqual(LocalDate.now()));
    }
    // проверка времени посещения
    public boolean timeEquals(SeasonTicket seasonTicket){
        return ((!(seasonTicket.getStartPermission().isAfter(LocalTime.now())) || seasonTicket.getStartPermission().equals(LocalTime.now())) && !(seasonTicket.getEndPermission().isBefore(LocalTime.now())) || seasonTicket.getEndPermission().equals(LocalTime.now()));
    }
    // проверка заполненности зоны
    public boolean fullnessZone(String zone){
        if (zone.equals("бассейн")){
            for (int i = 0; i < poolArray.length; i++) {
                if(poolArray[i] == null) return true;
            }
            return false;
        }
        if (zone.equals("тренажерный зал")){
            for (int i = 0; i < gymArray.length; i++) {
                if(gymArray[i] == null) return true;
            }
            return false;
        }
        for (int i = 0; i < groupArray.length; i++) {
            if(groupArray[i] == null) return true;
        }
        return false;
    }
    // проверка на вхождение в другую зону
    public boolean enterTicket(SeasonTicket seasonTicket){
        for (int i = 0; i < poolArray.length; i++) {
            if (poolArray[i] == seasonTicket) return false;
        }
        for (int i = 0; i < groupArray.length; i++) {
            if (groupArray[i] == seasonTicket) return false;
        }
        for (int i = 0; i < gymArray.length; i++) {
            if (gymArray[i] == seasonTicket) return false;
        }
        return true;
    }
    public void comingFitness(String zone, SeasonTicket seasonTicket){
        if (!zoneEquals(zone, seasonTicket)) {
            System.out.println("Вы не можете войти в эту зону");
            return;
        }
        if (!dateEquals(seasonTicket)){
            System.out.println("Ваш абонимент просрочен");
            return;
        }
        if (!timeEquals(seasonTicket)){
            System.out.println("Вы пришли не в то время");
            return;
        }
        if (!fullnessZone(zone)) {
            System.out.println("Извините, зона переаолнена");
            return;
        }
        if (!enterTicket(seasonTicket)){
            System.out.println("Ваш обонимент зарегистрирован в другой зоне");
            return;
        }
        addZone(zone,seasonTicket);


    }
    // добавление абанимента в зону
    public void addZone(String zone, SeasonTicket seasonTicket){
        if (zone.equals("бассейн")){
            for (int i = 0; i < poolArray.length; i++) {
                if(poolArray[i] == null) {
                    poolArray[i] = seasonTicket;
                    System.out.println("Посетитель "+ seasonTicket.getClient().getSurnema()+ " " + seasonTicket.getClient().getName()+ " зарегистрирован в зоне 'бассейн' " + LocalDate.now() +" в " + LocalTime.now());
                    return;
                }
            }

        }
        if (zone.equals("тренажерный зал")){
            for (int i = 0; i < gymArray.length; i++) {
                if(gymArray[i] == null) {
                    gymArray[i] = seasonTicket;
                    System.out.println("Посетитель "+ seasonTicket.getClient().getSurnema()+ " " + seasonTicket.getClient().getSurnema()+ " зарегистрирован в зоне 'тренажерный зал' " + LocalDate.now() +" в" + LocalTime.now());
                    return;
                }
            }

        }
        for (int i = 0; i < groupArray.length; i++) {
            if(groupArray[i] == null) {
                groupArray[i] = seasonTicket;
                System.out.println("Посетитель "+ seasonTicket.getClient().getSurnema()+ " " + seasonTicket.getClient().getSurnema()+ " зарегистрирован в зоне 'групповые занятия' " + LocalDate.now() +" в" + LocalTime.now());
                return;
            }
        }
    }

    public void getFitnessClub(){
        System.out.println("Посетители тренажерного зала: " + Arrays.toString(gymArray));
        System.out.println("Посетители бассейна: " +Arrays.toString(poolArray));
        System.out.println("Посетители групповых занятий: " +Arrays.toString(groupArray));
    }

}
