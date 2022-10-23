package re.tsvetkov.exams;


import re.tsvetkov.exams.fitness.Client;
import re.tsvetkov.exams.fitness.FitnessClub;
import re.tsvetkov.exams.fitness.SeasonTicket;

import java.time.LocalDate;
import java.time.LocalTime;

public class Application {
    public static void main(String[] args) {

        Client client1 = new Client("Алексей", "Цветков", LocalDate.of(1997, 07, 24));
        System.out.println(client1);
        Client client2 = new Client("Андрей", "Цветков", LocalDate.of(1997, 07, 24));
        System.out.println(client2);

        SeasonTicket seasonTicket1 = new SeasonTicket("Полный", client1, LocalDate.of(2022, 11, 19));
        System.out.println(seasonTicket1);

        SeasonTicket seasonTicket2 = new SeasonTicket("Дневной", client2, LocalDate.of(2022, 11, 19));
        System.out.println(seasonTicket2);

        System.out.println(seasonTicket1.getTicketPermission());

        FitnessClub fitnessClub = new FitnessClub();
         fitnessClub.comingFitness("групповые занятия", seasonTicket1);
        fitnessClub.comingFitness("тренажерный зал", seasonTicket2);
//        fitnessClub.comingFitness("бассейн", seasonTicket2);
//
        System.out.println("");
        fitnessClub.getFitnessClub();
    }
}
