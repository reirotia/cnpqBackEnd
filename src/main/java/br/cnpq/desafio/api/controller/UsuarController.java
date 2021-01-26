package br.cnpq.desafio.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.cnpq.desafio.domain.UsuarioLogin;
import br.cnpq.desafio.domain.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios-login")
public class UsuarController {
	
	private UsuarioRepository repo;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioLogin salvar(@RequestBody UsuarioLogin usuario) {
		return repo.save(usuario);
	}

}
