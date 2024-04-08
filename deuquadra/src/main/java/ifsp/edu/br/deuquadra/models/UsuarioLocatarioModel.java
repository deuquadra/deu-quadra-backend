package ifsp.edu.br.deuquadra.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.annotation.ComponentScan;

//cliente
@ComponentScan("ifsp.edu.br.deuquadra.*")
@Entity
@Data
@Table(name="tb_usuario_locatario", schema = "public")
public class UsuarioLocatarioModel {
    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    @Column(name = "idUsuarioLocatario")
    protected Integer idUsuarioLocatario;

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
