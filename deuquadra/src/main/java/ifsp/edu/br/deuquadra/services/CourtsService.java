package ifsp.edu.br.deuquadra.services;

import ifsp.edu.br.deuquadra.models.CompaniesModel;
import ifsp.edu.br.deuquadra.models.CourtsModel;

import java.util.List;
import java.util.Optional;

public interface CourtsService {

    CourtsModel save(CourtsModel courtsModel);

    List<CourtsModel> findAll();

    Optional<CourtsModel> findById(Integer id);

    CourtsModel update(CourtsModel courtsModel);

    void deleteById(Integer id);

   List<CourtsModel> findByProximity(Double minLat, Double maxLat, Double minLon, Double maxLon);


}
