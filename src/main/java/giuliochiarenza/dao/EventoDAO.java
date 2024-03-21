package giuliochiarenza.dao;

import giuliochiarenza.entities.Concerto;
import giuliochiarenza.entities.Evento;
import giuliochiarenza.entities.Genere;
import giuliochiarenza.entities.PartitaDiCalcio;
import giuliochiarenza.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;

public class EventoDAO {
    private final EntityManager em;

    public EventoDAO(EntityManager em) {this.em = em;}


    public void save(Evento evento){
        EntityTransaction transaction= em.getTransaction();
        transaction.begin();
        em.persist(evento);
        transaction.commit();
        System.out.println("Evento " + evento.getTitolo() + " salvato!");
    }
    public Evento findById(long evento_Id){
        Evento evento = em.find(Evento.class, evento_Id);
        if(evento == null) throw new NotFoundException(evento_Id);
        return evento;
    }
    public void findByIdAndDelete(long eventoId){
        Evento found = this.findById(eventoId);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("Evento con id " + found.getId() + " eliminato!");
    }

    public List<Concerto> getConcertiInStreaming(boolean inStreaming) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Query query = em.createQuery("SELECT c FROM Concerto c WHERE c.inStreaming = :inStreaming", Concerto.class);
        query.setParameter("inStreaming", inStreaming);
        List<Concerto> concertiInStreaming = query.getResultList();
        transaction.commit();
        return concertiInStreaming;
    }
    public List<Concerto> getConcertiPerGenere(Genere genere) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Query query = em.createQuery("SELECT c FROM Concerto c WHERE c.genere = :genere", Concerto.class);
        query.setParameter("genere", genere);
        List<Concerto> concertiPerGenere = query.getResultList();
        transaction.commit();
        return concertiPerGenere;
    }
    public List<PartitaDiCalcio> getPartiteVinteInCasa() {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Query query = em.createQuery("SELECT p FROM PartitaDiCalcio p WHERE p.SquadraDiCasa = p.SquadraVincente", PartitaDiCalcio.class);
        List<PartitaDiCalcio> partiteVinteInCasa = query.getResultList();

        transaction.commit();

        return partiteVinteInCasa;
    }
    public List<PartitaDiCalcio> getPartiteVinteInTrasferta() {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Query query = em.createQuery("SELECT p FROM PartitaDiCalcio p WHERE p.SquadraOspite = p.SquadraVincente", PartitaDiCalcio.class);
        List<PartitaDiCalcio> partiteVinteInTrasferta = query.getResultList();

        transaction.commit();

        return partiteVinteInTrasferta;
    }
}
