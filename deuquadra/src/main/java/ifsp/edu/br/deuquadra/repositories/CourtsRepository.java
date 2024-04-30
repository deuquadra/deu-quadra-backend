package ifsp.edu.br.deuquadra.repositories;

import ifsp.edu.br.deuquadra.models.CompaniesModel;
import ifsp.edu.br.deuquadra.models.CourtsModel;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@ComponentScan("api.culturaprincipal.*")
@Repository
public interface CourtsRepository extends JpaRepository<CourtsModel, Integer> {
    @Query("FROM CourtsModel q LEFT JOIN CompaniesModel e ON q.idEmpresa = e.idEmpresa WHERE " +
            "(e.lat BETWEEN ?1 AND ?2) AND (e.lon BETWEEN ?3 AND ?4) ")
    List<CourtsModel> findByProximity(Double minLat, Double maxLat, Double minLon, Double maxLon);
}
