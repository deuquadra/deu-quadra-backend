package ifsp.edu.br.deuquadra.services;

import ifsp.edu.br.deuquadra.models.UsuarioLocadorModel;
import ifsp.edu.br.deuquadra.models.UsuarioLocatarioModel;

public interface UsuarioLocatarioService {
    UsuarioLocatarioModel register(UsuarioLocatarioModel usuarioLocatarioModel);
    UsuarioLocatarioModel findByEmail(String email);
}
