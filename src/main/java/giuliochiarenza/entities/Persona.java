package giuliochiarenza.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name= "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long persona_id;
    private String nome;
    private String cognome;
    private String email;
    private String data_di_nascita;
    private Sesso sesso;


    @OneToMany(mappedBy = "persona")
    private List<Partecipazione> lista_partrcipazione;


    public Persona(){}

    public Persona( String nome, String cognome, String email, String data_di_nascita, Sesso sesso) {

        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.data_di_nascita = data_di_nascita;
        this.sesso = sesso;


    }


    public long getId() {
        return persona_id;
    }

    public void setId(long id) {
        this.persona_id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getData_di_nascita() {
        return data_di_nascita;
    }

    public void setData_di_nascita(String data_di_nascita) {
        this.data_di_nascita = data_di_nascita;
    }

    public Sesso getSesso() {
        return sesso;
    }

    public void setSesso(Sesso sesso) {
        this.sesso = sesso;
    }



}
