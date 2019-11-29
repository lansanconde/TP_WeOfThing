package com.lansanalatty.wot.jena;

import java.io.InputStream;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;

public class JenaRDF {
	
	Query query;
	QueryExecution qexec;
	ResultSet results;
	String inputFileName = "/home/lansana/eclipse-workspace/TPJena/sources/aarhus_parking.ttl";

	
	public String getinputFileName() {
		return this.inputFileName;
	}
	
	public Model getModel() {
		//String inputFileName = "/home/lansana/eclipse-workspace/TPJena/sources/aarhus_parking.ttl";
		 // create an empty model
		 Model model = ModelFactory.createDefaultModel();
		 // use the FileManager to find the input file
		 InputStream in = FileManager.get().open( getinputFileName() );
		if (in == null) {
		    throw new IllegalArgumentException(
		                                 "File: " + getinputFileName() + " not found");
		}
		// read the RDF/XML file
		model.read(in, null, "TURTLE");
		return model;
	}
	
	public ResultSet   getStreamEvent() {
		//Lobject (streamEvent) 
				String queryStringStreamEvent = "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
			              + "PREFIX  dc:<http://purl.org/dc/elements/1.1/> "
			              + "SELECT ?streamEvent "
			              + "WHERE  {<http://iot.ee.surrey.ac.uk/citypulse/datasets/parking/parkingDataStream> rdf:type ?streamEvent}  " ; 
				query = QueryFactory.create(queryStringStreamEvent) ; 
				qexec = QueryExecutionFactory.create(query, getModel()) ; 
				results = qexec.execSelect();
				ResultSetFormatter.out(System.out, results, query) ;
		return results;
	}

	      
}