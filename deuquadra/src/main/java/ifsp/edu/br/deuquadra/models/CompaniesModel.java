package ifsp.edu.br.deuquadra.models;
import jakarta.persistence.*;

import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.context.annotation.ComponentScan;

import java.io.Serializable;
import java.util.List;

@ComponentScan("ifsp.edu.br.deuquadra.*")
@Entity
@Data
@Table(name="tb_empresa", schema = "public")
public class CompaniesModel implements Serializable {

    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    @Column(name = "idEmpresa")
    protected Integer idEmpresa;

    @Column(name = "nome")
    protected String nome;

    @Column(name = "rua")
    protected String rua;

    @Column(name = "bairro")
    protected String bairro;

    @Column(name = "numero")
    protected String numero;

    @Column(name = "idCidade")
    protected String idCidade;

    @Column(name = "lat")
    protected Double lat;

    @Column(name = "lon")
    protected Double lon;

    @OneToMany(mappedBy = "idEmpresa")
    protected List<CourtsModel> courtsModelList;

    public CompaniesModel() {
    }

}
