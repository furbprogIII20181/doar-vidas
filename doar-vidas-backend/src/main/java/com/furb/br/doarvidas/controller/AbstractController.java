package com.furb.br.doarvidas.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.furb.br.doarvidas.model.pojo.BasicPojo;

/**
 * Class that have the common methods for all the application controllers
 *  
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
public abstract class AbstractController<P extends BasicPojo> {

	@RequestMapping(method = RequestMethod.PUT, value = "save", consumes=MediaType.APPLICATION_JSON_VALUE)
    public abstract ResponseEntity<?> save(@RequestBody P pojo);
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id:[0-9][0-9]*}")
    public abstract ResponseEntity<?> deleteById(@PathVariable("id") Integer id);

	@RequestMapping(method = RequestMethod.GET, value = "listAll", consumes = MediaType.APPLICATION_JSON_VALUE)
    public abstract ResponseEntity<?> listAll();
	
}
