package com.lansanalatty.wot.web;

import org.apache.jena.query.ResultSet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lansanalatty.wot.jena.JenaRDF;

@RestController
@RequestMapping(path ="/", produces = "application/json")
public class JenaControleur {
	
	@GetMapping("streamEvent")
	public ResultSet HelloJson() {
		JenaRDF jenaRDF = new JenaRDF();
		jenaRDF.getStreamEvent();
		return jenaRDF.getStreamEvent();
	}
	
}
