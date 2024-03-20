package giuliochiarenza.dao;

import giuliochiarenza.entities.Evento;
import giuliochiarenza.entities.Persona;
import giuliochiarenza.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PersonaDAO {
    private final EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Persona persona){
        EntityTransaction transaction= em.getTransaction();
        transaction.begin();
        em.persist(persona);
        transaction.commit();
        System.out.println("Evento " + persona.getNome() + " salvato!");
    }

    public Persona findById(long personaId){
        Persona persona = em.find(Persona.class, personaId);
        if(persona == null) throw new NotFoundException(personaId);
        return persona;
    }

    public void findByIdAndDelete(long personaId){
        Persona found = this.findById(personaId);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("Persona con id " + found.getId() + " eliminato!");
    }
}
