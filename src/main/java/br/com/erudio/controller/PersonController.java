package br.com.erudio.controller;

import br.com.erudio.model.Person;
import br.com.erudio.service.CalculadoraService;
import br.com.erudio.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonService personService;

	@RequestMapping(value = "/{id}",method = RequestMethod.GET,
	produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable String id){
		return personService.findById(id);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll(){
		return personService.findAll();
	}
}
