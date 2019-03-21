package org.sid.web;

import java.util.List;

import org.sid.dao.EmployeRepository;
import org.sid.entities.Employe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.style.DefaultValueStyler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class AuthRestService {
	@Autowired
	private EmployeRepository employeRepository;


	@RequestMapping(value="/connect", method=RequestMethod.GET)
	public Employe connect(@RequestParam(name="login", defaultValue="") String login, @RequestParam(name="password", defaultValue="") String password)
	{
		if(employeRepository.connect(login, password).getIdUtilisateur() != null) 
		{
		return employeRepository.connect(login, password);
		}
		else return null;
	}
	
}
