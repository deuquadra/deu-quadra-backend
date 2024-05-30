package ifsp.edu.br.deuquadra.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDateTime;

@ComponentScan("ifsp.edu.br.deuquadra.*")
@Entity
@Data
@Table(name="tb_reserva", schema = "public")
public class ReservaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReserva")
    private Integer idReserva;

    @Column(name = "nome")
    private String nome;

    @Column(name = "startDate")
    private LocalDateTime startDate;

    @Column(name = "endDate")
    private LocalDateTime endDate;

    @Column(name = "locatarioId")
    private String locatarioId;

    @Column(name = "idQuadra")
    private Integer idQuadra;
}
