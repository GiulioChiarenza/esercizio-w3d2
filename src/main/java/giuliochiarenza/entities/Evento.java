package giuliochiarenza.entities;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "events")
@Inheritance(strategy = InheritanceType.JOINED)
public class Evento {
    @Id
    @GeneratedValue
    private long evento_id;
    @Column(name="titolo")
    private String titolo;
    @Column(name="data_evento")
    private String dataEvento;
    @Column(name="descrizione")
    private String descrizione;
    @Column(name="tipo_evento")
    @Enumerated(EnumType.STRING)
    private EventoType eventoType;
    @Column(name="numero_massimo_partecipanti")
    private int numeroMassimoPartecipanti;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.REMOVE)
    private List<Partecipazione> listaPartecipazioni;
    @ManyToOne
    @JoinColumn(name="location_id",referencedColumnName = "location_id", nullable = false)
    private Location location;


    public Evento(){

    }
    public Evento(String titolo, String dataEvento, String descrizione, EventoType eventoType, int numeroMassimoPartecipanti){
        this.titolo= titolo;
        this.dataEvento= dataEvento;
        this.descrizione= descrizione;
        this.eventoType= eventoType;
        this.numeroMassimoPartecipanti= numeroMassimoPartecipanti;

    }

    public long getId() {return evento_id;}

    public void setId(long id) {
        this.evento_id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(String dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public EventoType getEventoType() {
        return eventoType;
    }

    public void setEventoType(EventoType eventoType) {
        this.eventoType = eventoType;
    }

    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + evento_id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", eventoType=" + eventoType +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                '}';
    }
}
