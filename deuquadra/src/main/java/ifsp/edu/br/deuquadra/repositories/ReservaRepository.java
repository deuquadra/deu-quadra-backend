package ifsp.edu.br.deuquadra.repositories;

import ifsp.edu.br.deuquadra.models.CourtsModel;
import ifsp.edu.br.deuquadra.models.ReservaModel;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@ComponentScan("api.culturaprincipal.*")
@Repository
public interface ReservaRepository extends JpaRepository<ReservaModel, Integer> {

    @Query("SELECT r FROM ReservaModel r WHERE r.idQuadra = :idQuadra")
    List<ReservaModel> findReservaByQuadra(@Param("idQuadra") Integer idQuadra);

    @Query("SELECT r FROM ReservaModel r WHERE r.locatarioId = :locatarioId")
    List<ReservaModel> findReservaByLocatario(@Param("locatarioId")Integer id);
}
