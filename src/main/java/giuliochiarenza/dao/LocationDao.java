package giuliochiarenza.dao;

import giuliochiarenza.entities.Location;
import giuliochiarenza.entities.Persona;
import giuliochiarenza.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LocationDao {
    private final EntityManager em;

    public LocationDao(EntityManager em) {
        this.em = em;
    }

    public void save(Location location){
        EntityTransaction transaction= em.getTransaction();
        transaction.begin();
        em.persist(location);
        transaction.commit();
        System.out.println("Evento " + location.getNome() + " salvato!");
    }

    public Location findById(long locationId){
        Location location = em.find(Location.class, locationId);
        if(location == null) throw new NotFoundException(locationId);
        return location;
    }

    public void findByIdAndDelete(long locationId){
        Location found = this.findById(locationId);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("Location con id " + found.getId() + " eliminato!");
    }
}
