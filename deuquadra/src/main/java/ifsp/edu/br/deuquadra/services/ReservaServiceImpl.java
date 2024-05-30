package ifsp.edu.br.deuquadra.services;

import ifsp.edu.br.deuquadra.models.ReservaModel;
import ifsp.edu.br.deuquadra.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@ComponentScan( "ifsp.edu.br.deuquadra.*" )
@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Override
    public ReservaModel save(ReservaModel reservaModel) {
        return reservaRepository.save(reservaModel);
    }

    @Override
    public Optional<ReservaModel> findById(Integer id) {
        return reservaRepository.findById(id);
    }

    @Override
    public ReservaModel update(ReservaModel reservaModel) {
        return reservaRepository.save(reservaModel);
    }

    @Override
    public void deleteById(Integer id) {
        reservaRepository.deleteById(id);
    }

    @Override
    public List<ReservaModel> findReservaByQuadra(Integer id) {
        return reservaRepository.findReservaByQuadra(id);
    }

    @Override
    public List<ReservaModel> findReservaByLocatario(Integer id) {
        return reservaRepository.findReservaByLocatario(id);
    }
}
