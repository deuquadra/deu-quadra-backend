package ifsp.edu.br.deuquadra.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.annotation.ComponentScan;

//dono de quadra
@ComponentScan("ifsp.edu.br.deuquadra.*")
@Entity
@Data
@Table(name="tb_usuario_locador", schema = "public")
public class UsuarioLocadorModel
{
    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    @Column(name = "idUsuarioLocador")
    protected Integer idUsuarioLocador;

    @Column(name = "identificador")
    protected String identificador;

    @Column(name = "nome")
    protected String nome;

    @Column(name = "email", unique = true)
    protected String email;

    @Column(name = "password")
    protected String password;

    @Column(name = "avatarUrl", nullable = true)
    protected String avatarUrl;

     @Column(name = "numero")
    protected String numero;

    @Column(name = "rua")
    protected String rua;

    @Column(name = "bairro")
    protected String bairro;
}