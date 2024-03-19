package giuliochiarenza;

import giuliochiarenza.dao.EventoDAO;
import giuliochiarenza.entities.Evento;
import giuliochiarenza.entities.EventoType;
import giuliochiarenza.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventoDAO ev = new EventoDAO(em);
        System.out.println("Hello World!");

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
            ev.findByIdAndDelete(3);
        }catch (NotFoundException ex){
            System.out.println(ex.getMessage());
        }
        em.close();
        emf.close();

    }
}
