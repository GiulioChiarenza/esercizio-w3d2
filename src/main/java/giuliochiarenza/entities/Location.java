package giuliochiarenza.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name= "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long location_id;
    private String nome;
    private String città;



    public Location(){}
    public Location( String nome, String città) {

        this.nome = nome;
        this.città = città;
    }




    public long getId() {
        return location_id;
    }

    public void setId(long id) {
        this.location_id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCittà() {
        return città;
    }

    public void setCittà(String città) {
        this.città = città;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + location_id +
                ", nome='" + nome + '\'' +
                ", città='" + città + '\'' +
                '}';
    }
}
