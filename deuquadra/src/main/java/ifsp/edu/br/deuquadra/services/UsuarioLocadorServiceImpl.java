package ifsp.edu.br.deuquadra.services;

import ifsp.edu.br.deuquadra.models.UsuarioLocadorModel;
import ifsp.edu.br.deuquadra.repositories.UsuarioLocadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@ComponentScan( "ifsp.edu.br.deuquadra.*" )
@Service
public class UsuarioLocadorServiceImpl implements UsuarioLocadorService {
    @Autowired
    private UsuarioLocadorRepository usuarioLocadorRepository;

    public UsuarioLocadorModel register(UsuarioLocadorModel usuarioLocadorModel) {
        return usuarioLocadorRepository.save(usuarioLocadorModel);
    }

    public UsuarioLocadorModel findByEmail(String email) {
        return usuarioLocadorRepository.findByEmail(email);
    }

    @Override
    @Transactional
   public UsuarioLocadorModel update(UsuarioLocadorModel usuarioLocadorModel) {
        Optional<UsuarioLocadorModel> optionalUser = usuarioLocadorRepository.findById(usuarioLocadorModel.getIdUsuarioLocador());
        if (optionalUser.isPresent()) {
            return usuarioLocadorRepository.save(usuarioLocadorModel);
        } else {
            throw new RuntimeException("Usuario não encontrado " );
        }
    }

    @Override
    public Optional<UsuarioLocadorModel> findById(Integer id) {
        return usuarioLocadorRepository.findById(id);
    }


}
