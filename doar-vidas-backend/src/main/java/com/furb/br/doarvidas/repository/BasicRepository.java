package com.furb.br.doarvidas.repository;

import org.springframework.data.repository.CrudRepository;

import com.furb.br.doarvidas.model.BasicEntity;

/**
 * Repositório de dados base da aplicação
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
public interface BasicRepository<T extends BasicEntity> extends CrudRepository<T, Integer> {

}
