package br.com.calcard.calsystem.ws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.calcard.calsystem.entity.Estabelecimento;
import br.com.calcard.calsystem.entity.Usuario;
import br.com.calcard.calsystem.service.EstabelecimentoService;
import br.com.calcard.calsystem.service.UsuarioService;
import br.com.calcard.calsystem.ws.dto.UsuarioDTO;

@RestController
@RequestMapping("/ws/usuarios")
public class UsuarioWS extends AbstractWS<UsuarioWS> {

	@Autowired
	UsuarioService usuarioService;

	public UsuarioWS() {
		super(UsuarioWS.class);
	}

	@RequestMapping(value = "/usuariosEstabelecimento", method = RequestMethod.GET, produces = "application/json")
	public List<UsuarioDTO> doGetUsuariosEstabelecimento(
			@RequestParam(value = "idEstabelecimento") int idEstabelecimento) {
		logger.info("Método: doGetUsuariosEstabelecimento");

		Estabelecimento e = (Estabelecimento) usuarioService.doFind(
				Estabelecimento.class, idEstabelecimento);

		List<Usuario> usuarios = usuarioService
				.doListUsuariosByEstabelecimento(e);

		List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();
		for (Usuario u : usuarios) {
			UsuarioDTO usu = new UsuarioDTO(u);
			usuariosDTO.add(usu);
		}

		return usuariosDTO;

	}
}
