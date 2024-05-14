package ifsp.edu.br.deuquadra.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.annotation.ComponentScan;

import java.io.Serializable;
import java.util.List;


@ComponentScan("ifsp.edu.br.deuquadra.*")
@Entity
@Data
@Table(name="tb_quadra", schema = "public")
public class CourtsModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idQuadra")
    private Integer idQuadra;

    @Column(name = "nome")
    private String nome;

    @Column(name = "imagemUrl")
    private String imagemUrl;

    @Column(name = "preco")
    private String preco;

    @Column(name = "descricao")
    private String descricao;

    @JoinColumn(name="id_empresa", nullable=false)
    //private CompaniesModel companiesModel;
    private Integer idEmpresa;

    public CourtsModel() {
    }
}
