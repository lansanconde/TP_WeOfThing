package com.lansanalatty.wot.web;









import java.util.HashSet;
import java.util.Set;

import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lansanalatty.wot.jena.JenaRDF;







@RestController
@RequestMapping(path ="/", produces = "application/json")
public class JenaControleur {
	
	
	
	@GetMapping("unit")
	public  Set<Entites> HelloJsonUnitOfMeasurement(){
		JenaRDF model = new JenaRDF();
		ResultSet results = model.getAll();
		Set<Entites> set = new HashSet<Entites>();
		while (results.hasNext()){
			Entites entite = new Entites();			
           QuerySolution soln = results.nextSolution(); 
           entite.setUnitOfMeasurement(soln.get("unit").toString());
           set.add(entite);
       }
		return set;  	
	}
	
	
	@GetMapping("value")
	public Set<Entites> HelloJsonTempObservation() {
		JenaRDF model = new JenaRDF();
		ResultSet results = model.getAll();
		Set<Entites> set = new HashSet<Entites>();
		while (results.hasNext()){
			Entites entite = new Entites();			
           QuerySolution soln = results.nextSolution(); 
           entite.setValue(soln.get("value").toString());
           set.add(entite);
       }
		return set;  
		
	}
	
	@GetMapping("id")
	public Set<Entites> HelloJsonId() {
		JenaRDF model = new JenaRDF();
		ResultSet results = model.getAll();
		Set<Entites> set = new HashSet<Entites>();
		while (results.hasNext()){
			Entites entite = new Entites();			
           QuerySolution soln = results.nextSolution(); 
           entite.setId(soln.get("r").toString());
           set.add(entite);
       }
		return set;  
		
	}
	
	@GetMapping("longitude")
	public Set<Entites> HelloJsonHasLongitude() {
		JenaRDF model = new JenaRDF();
		ResultSet results = model.getAll();
		Set<Entites> set = new HashSet<Entites>();
		while (results.hasNext()){
			Entites entite = new Entites();			
           QuerySolution soln = results.nextSolution(); 
           entite.setHasLongitude( soln.get("longitude").toString());
           set.add(entite);
       }
		return set;  		
	}
	
	@GetMapping("latitude")
	public Set<Entites> HelloJsonHasLatitude() {
		JenaRDF model = new JenaRDF();
		ResultSet results = model.getAll();
		Set<Entites> set = new HashSet<Entites>();
		while (results.hasNext()){
			Entites entite = new Entites();			
           QuerySolution soln = results.nextSolution(); 
           entite.setHasLatitude( soln.get("latitude").toString());
           set.add(entite);
       }
		return set;  
	}
	
	
	
	
}