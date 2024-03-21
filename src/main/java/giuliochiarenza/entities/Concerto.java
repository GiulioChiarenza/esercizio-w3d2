package giuliochiarenza.entities;

import jakarta.persistence.Entity;

@Entity
public class Concerto extends Evento {
    private Genere Genere;
    private boolean InStreaming;

    public Concerto(String titolo, String dataEvento, String descrizione, EventoType eventoType, int numeroMassimoPartecipanti, giuliochiarenza.entities.Genere genere, boolean inStreaming) {
        super(titolo, dataEvento, descrizione, eventoType, numeroMassimoPartecipanti);
        Genere = genere;
        InStreaming = inStreaming;
    }

    public giuliochiarenza.entities.Genere getGenere() {
        return Genere;
    }

    public void setGenere(giuliochiarenza.entities.Genere genere) {
        Genere = genere;
    }

    public boolean isInStreaming() {
        return InStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        InStreaming = inStreaming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "Genere=" + Genere +
                ", InStreaming=" + InStreaming +
                '}';
    }
}
