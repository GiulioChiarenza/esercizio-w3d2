package giuliochiarenza.entities;

import jakarta.persistence.Entity;

import java.util.List;
@Entity
public class GaraDiAtletica extends Evento{
    private List<Persona> SetAtleti;
    private Persona Vincitore;

    public GaraDiAtletica(String titolo, String dataEvento, String descrizione, EventoType eventoType, int numeroMassimoPartecipanti, List<Persona> setAtleti, Persona vincitore) {
        super(titolo, dataEvento, descrizione, eventoType, numeroMassimoPartecipanti);
        SetAtleti = setAtleti;
        Vincitore = vincitore;
    }

    public List<Persona> getSetAtleti() {
        return SetAtleti;
    }

    public void setSetAtleti(List<Persona> setAtleti) {
        SetAtleti = setAtleti;
    }

    public Persona getVincitore() {
        return Vincitore;
    }

    public void setVincitore(Persona vincitore) {
        Vincitore = vincitore;
    }

    @Override
    public String toString() {
        return "GaraDiAtletica{" +
                "SetAtleti=" + SetAtleti +
                ", Vincitore=" + Vincitore +
                '}';
    }
}
