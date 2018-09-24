package com.furb.br.doarvidas.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.furb.br.doarvidas.model.BasicEntity;

public interface AbstractCRUDEndPoint<E extends BasicEntity> {

	/**
	 * Salva a entidade informada
	 * @param pojo - pojo que será transformado em entidade, e salvo posteriormente
	 * @return - uma {@link ResponseEntity} com a entidade salva
	 */
	@RequestMapping(method = RequestMethod.POST, value = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> save(@RequestBody E entity);

	/**
	 * Exclui uma entidade utilizando o id da mesma
	 * @param id - o id da entidade que será excluída
	 * @return - uma {@link ResponseEntity} com uma mensagem de retorno
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id:[0-9][0-9]*}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id);
	
}
