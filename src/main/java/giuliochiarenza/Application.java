package giuliochiarenza;

import com.github.javafaker.Faker;
import giuliochiarenza.dao.EventoDAO;
import giuliochiarenza.dao.LocationDao;
import giuliochiarenza.dao.PartecipazioneDAO;
import giuliochiarenza.dao.PersonaDAO;
import giuliochiarenza.entities.*;
import giuliochiarenza.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
    public static void main(String[] args) {
        Faker faker = new Faker(Locale.ITALY);
        Random rndm = new Random();
        EntityManager em = emf.createEntityManager();
        EventoDAO ev = new EventoDAO(em);
        LocationDao locationsDAO= new LocationDao(em);
        PersonaDAO personaDAO= new PersonaDAO(em);
        PartecipazioneDAO partecipazioneDAO= new PartecipazioneDAO(em);
        System.out.println("Hello World!");
        PersonaDAO pe =new PersonaDAO(em);

        Evento natale= new Evento("Natale", "25-12", "Nascita di Gesù", EventoType.PRIVATO, 100);
        Evento capodanno= new Evento("Capodanno", "1-01", "Inizio del nuovo anno", EventoType.PUBBLICO, 10000 );
        Evento pasqua= new Evento("Pasqua", "31-03-2024", "Resurrezione di Gesù", EventoType.PRIVATO, 1);
        Evento prova= new Evento("prova","01-01","prova delete", EventoType.PRIVATO, 10);

       // ev.save(natale);
       // ev.save(capodanno);
        //ev.save(pasqua);
       // ev.save(prova);

        try{
            Evento findPasqua = ev.findById(2);
            System.out.println(pasqua);
        }catch (NotFoundException ex){
            System.out.println(ex.getMessage());
        }
        try {
            ev.findByIdAndDelete(4);
        }catch (NotFoundException ex){
            System.out.println(ex.getMessage());
        }


        // esercizio w3d3

        Location location1= new Location(faker.address().city(), faker.address().cityName());
        locationsDAO.save(location1);
        Location location2 = new Location(faker.address().city(), faker.address().cityName());
        locationsDAO.save(location2);
        Persona persona1 = new Persona(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(),  "01-01-1900", Sesso.M);
        pe.save(persona1);

    }
}
