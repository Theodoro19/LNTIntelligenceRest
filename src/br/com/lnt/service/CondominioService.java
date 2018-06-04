package br.com.lnt.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.lnt.dao.CondominioDAO;
import br.com.lnt.model.util.bloco;
import br.com.lnt.model.util.condominio;

@Stateless
public class CondominioService {

	@Inject
	CondominioDAO dao;

	public List<condominio> listarCondominios() {
		return this.dao.listarCondominios();
	}

	public List<bloco> listarBlocos(int condominio) {
		return this.dao.listarBlocos(condominio);
	}
}
