package com.furb.br.doarvidas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.furb.br.doarvidas.model.BasicEntity;
import com.furb.br.doarvidas.repository.BasicRepository;

/**
 * Base endpoint for the basic CRUD operations
 * 
 * @author marcelo.wippel
 * @param <P> some class that extends from {@link BasicEntity}
 */
public abstract class AbstractCRUDEndPointImpl<E extends BasicEntity> implements AbstractCRUDEndPoint<E> {

	protected abstract BasicRepository<E> getStorage();
	
	@Override
	public ResponseEntity<?> save(@RequestBody E pojo) {
		return null;
	}

	@Override
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
		return null;
	}

}
