package ifsp.edu.br.deuquadra.repositories;

import ifsp.edu.br.deuquadra.models.CompaniesModel;
import ifsp.edu.br.deuquadra.models.CourtsModel;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@ComponentScan("api.culturaprincipal.*")
@Repository
public interface CompaniesRepository extends JpaRepository<CompaniesModel, Integer> {

//    @Query("SELECT c FROM CompaniesModel c WHERE c.userId = :userId")
//    List<CompaniesModel> findByIdUser(Integer id);

    @Query("SELECT c FROM CompaniesModel c WHERE c.idUsuario = :idUsuario")
    List<CompaniesModel> findByIdUser(@Param("idUsuario") Integer idUsuario);

}