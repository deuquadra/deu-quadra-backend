package ifsp.edu.br.deuquadra.services;

import ifsp.edu.br.deuquadra.models.UsuarioLocadorModel;

public interface UsuarioLocadorService {
    UsuarioLocadorModel register(UsuarioLocadorModel usuarioLocadorModel);
    UsuarioLocadorModel findByEmail(String email);
    UsuarioLocadorModel update(UsuarioLocadorModel usuarioLocadorModel);
}
