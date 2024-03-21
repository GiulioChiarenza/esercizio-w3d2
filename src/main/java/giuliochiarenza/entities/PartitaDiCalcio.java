package giuliochiarenza.entities;

import jakarta.persistence.Entity;

@Entity
public class PartitaDiCalcio extends Evento{
    private String SquadraDiCasa;
    private String SquadraOspite;
    private String SquadraVincente;
    private int GolSquadraDiCasa;
    private int GolSquadraOspite;

    public PartitaDiCalcio() {
    }

    public PartitaDiCalcio(String titolo, String dataEvento, String descrizione, EventoType eventoType, int numeroMassimoPartecipanti, String squadraDiCasa, String squadraOspite, String squadraVincente, int golSquadraDiCasa, int golSquadraOspite) {
        super(titolo, dataEvento, descrizione, eventoType, numeroMassimoPartecipanti);
        this.SquadraDiCasa = squadraDiCasa;
        this.SquadraOspite = squadraOspite;
        this.SquadraVincente = squadraVincente;
        this.GolSquadraDiCasa = golSquadraDiCasa;
        this.GolSquadraOspite = golSquadraOspite;
    }

    public String getSquadraDiCasa() {
        return SquadraDiCasa;
    }

    public void setSquadraDiCasa(String squadraDiCasa) {
        SquadraDiCasa = squadraDiCasa;
    }

    public String getSquadraOspite() {
        return SquadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        SquadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return SquadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        SquadraVincente = squadraVincente;
    }

    public int getGolSquadraDiCasa() {
        return GolSquadraDiCasa;
    }

    public void setGolSquadraDiCasa(int golSquadraDiCasa) {
        GolSquadraDiCasa = golSquadraDiCasa;
    }

    public int getGolSquadraOspite() {
        return GolSquadraOspite;
    }

    public void setGolSquadraOspite(int golSquadraOspite) {
        GolSquadraOspite = golSquadraOspite;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "SquadraDiCasa='" + SquadraDiCasa + '\'' +
                ", SquadraOspite='" + SquadraOspite + '\'' +
                ", SquadraVincente='" + SquadraVincente + '\'' +
                ", GolSquadraDiCasa=" + GolSquadraDiCasa +
                ", GolSquadraOspite=" + GolSquadraOspite +
                '}';
    }

}
