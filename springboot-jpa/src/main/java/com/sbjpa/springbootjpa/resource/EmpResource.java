package com.sbjpa.springbootjpa.resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbjpa.springbootjpa.exception.CustomDataException;
import com.sbjpa.springbootjpa.exception.CustomException;
import com.sbjpa.springbootjpa.model.Employee;
import com.sbjpa.springbootjpa.repository.EmpRepository;
import com.sbjpa.springbootjpa.service.EmpService;

@RestController
@RequestMapping(value = "/rest/emp")
public class EmpResource {
	
	private static final Logger logger = LoggerFactory.getLogger(EmpResource.class);
	
	@Autowired
	EmpRepository empRepository;
	@Autowired
	EmpService empService;

	@GetMapping(value = "/getAll")
	public List<Employee> getAllEmployee() {
		return empRepository.findAll();
	}

	@PostMapping(value = "/post")
	public List<Employee> persit(@RequestBody final Employee emp) {
		empRepository.save(emp);
		return empRepository.findAll();
	}

	@GetMapping(value = "/byName/{name}")
	public List<Employee> byName(@PathVariable final String name) {
		return (List<Employee>) empRepository.findByName(name);

	}
	
	@GetMapping(value = "/test/{name}")
	public String empService(@PathVariable final String name) throws CustomException  {
		if(empService.findByName(name)==null){
			
//			logger.info("exceptoin occured");
			logger.error("excetion", new CustomException("emp not found"));
//			throw new CustomException("employee not found");
			return null;
		}
		else{
			return  empService.findByName(name);
		}

	}

}
