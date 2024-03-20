package giuliochiarenza.dao;

import giuliochiarenza.entities.Partecipazione;
import giuliochiarenza.entities.Persona;
import giuliochiarenza.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PartecipazioneDAO {
    private final EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazione partecipazione){
        EntityTransaction transaction= em.getTransaction();
        transaction.begin();
        em.persist(partecipazione);
        transaction.commit();
        System.out.println("Evento " + partecipazione.getId() + " salvato!");
    }

    public Partecipazione findById(long partecipazioneId){
        Partecipazione partecipazione = em.find(Partecipazione.class, partecipazioneId);
        if(partecipazione == null) throw new NotFoundException(partecipazioneId);
        return partecipazione;
    }

    public void findByIdAndDelete(long partecipazioneId){
        Partecipazione found = this.findById(partecipazioneId);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("Partecipazione con id " + found.getId() + " eliminato!");
    }
}
