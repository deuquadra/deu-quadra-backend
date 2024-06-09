package ifsp.edu.br.deuquadra.services;

import ifsp.edu.br.deuquadra.models.UsuarioLocadorModel;
import ifsp.edu.br.deuquadra.models.UsuarioLocatarioModel;
import ifsp.edu.br.deuquadra.repositories.UsuarioLocadorRepository;
import ifsp.edu.br.deuquadra.repositories.UsuarioLocatarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@ComponentScan( "ifsp.edu.br.deuquadra.*" )
@Service
public class UsuarioLocatarioServiceImpl implements UsuarioLocatarioService {

    @Autowired
    UsuarioLocatarioRepository usuarioLocatarioRepository;

    @Override
    public UsuarioLocatarioModel register(UsuarioLocatarioModel usuarioLocatarioModel) {
        return usuarioLocatarioRepository.save(usuarioLocatarioModel);
    }

    @Override
    public UsuarioLocatarioModel findByEmail(String email) {
        return usuarioLocatarioRepository.findByEmail(email);
    }



    @Transactional
    public UsuarioLocatarioModel update(UsuarioLocatarioModel usuarioLocatarioModel) {
        Optional<UsuarioLocatarioModel> optionalUser = usuarioLocatarioRepository.findById(usuarioLocatarioModel.getIdUsuarioLocatario());
        if (optionalUser.isPresent()) {
            return usuarioLocatarioRepository.save(usuarioLocatarioModel);
        } else {
            throw new RuntimeException("Usuario não encontrado " );
        }
    }
}
