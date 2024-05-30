package ifsp.edu.br.deuquadra.services;

import ifsp.edu.br.deuquadra.models.ReservaModel;

import java.util.List;
import java.util.Optional;

public interface ReservaService {

    ReservaModel save(ReservaModel reservaModel);

    Optional<ReservaModel> findById(Integer id);

    ReservaModel update(ReservaModel reservaModel);

    void deleteById(Integer id);

    List<ReservaModel> findReservaByQuadra(Integer id);

    List<ReservaModel> findReservaByLocatario(Integer id);
}
