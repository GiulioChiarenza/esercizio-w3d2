package giuliochiarenza.entities;

import jakarta.persistence.*;

@Entity
@Table(name= "partecipazione")
public class Partecipazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private PartecipazioneStato partecipazioneStato;

    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;

    @ManyToOne
    @JoinColumn(name="evento_id", nullable = false)
    private Evento evento;

    public Partecipazione( PartecipazioneStato partecipazioneStato, Persona persona, Evento evento) {

        this.partecipazioneStato = partecipazioneStato;
        this.persona = persona;
        this.evento = evento;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PartecipazioneStato getPartecipazioneStato() {
        return partecipazioneStato;
    }

    public void setPartecipazioneStato(PartecipazioneStato partecipazioneStato) {
        this.partecipazioneStato = partecipazioneStato;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}