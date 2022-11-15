package OB.Ejercicios10_11_12.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String marca;
    private Boolean discoSolido;
    private Integer memRAM;
    private String Procesador;
    private Integer gbDisco;
    private Double pulgadasPant;

    public Laptop() {
    }

    public Laptop(Long id, String marca, Boolean discoSolido, Integer memRAM, String procesador, Integer gbDisco, Double pulgadasPant) {
        this.id = id;
        this.marca = marca;
        this.discoSolido = discoSolido;
        this.memRAM = memRAM;
        Procesador = procesador;
        this.gbDisco = gbDisco;
        this.pulgadasPant = pulgadasPant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Boolean getDiscoSolido() {
        return discoSolido;
    }

    public void setDiscoSolido(Boolean discoSolido) {
        this.discoSolido = discoSolido;
    }

    public Integer getMemRAM() {
        return memRAM;
    }

    public void setMemRAM(Integer memRAM) {
        this.memRAM = memRAM;
    }

    public String getProcesador() {
        return Procesador;
    }

    public void setProcesador(String procesador) {
        Procesador = procesador;
    }

    public Integer getGbDisco() {
        return gbDisco;
    }

    public void setGbDisco(Integer gbDisco) {
        this.gbDisco = gbDisco;
    }

    public Double getPulgadasPant() {
        return pulgadasPant;
    }

    public void setPulgadasPant(Double pulgadasPant) {
        this.pulgadasPant = pulgadasPant;
    }
}
