package ifsp.edu.br.deuquadra.repositories;

import ifsp.edu.br.deuquadra.models.ReservaModel;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@ComponentScan("api.culturaprincipal.*")
@Repository
public interface ReservaRepository extends JpaRepository<ReservaModel, Integer> {
}
