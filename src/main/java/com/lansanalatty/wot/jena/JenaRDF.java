package com.lansanalatty.wot.jena;

import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.jena.atlas.json.JSON;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;
import org.springframework.boot.configurationprocessor.json.JSONArray;

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
	
	public List<String>  getStreamEvent() {
		//Lobject (streamEvent) 
				String queryStringStreamEvent = "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
			              + "PREFIX  dc:<http://purl.org/dc/elements/1.1/> "
			              + "SELECT ?streamEvent "
			              + "WHERE  {<http://iot.ee.surrey.ac.uk/citypulse/datasets/parking/parkingDataStream> rdf:type ?streamEvent}  " ; 
				query = QueryFactory.create(queryStringStreamEvent) ; 
				qexec = QueryExecutionFactory.create(query, getModel()) ; 
				results = qexec.execSelect();
				ResultSetFormatter.out(System.out, results, query) ;
				
				//ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

				//ResultSetFormatter.outputAsJSON(outputStream, results);

				// and turn that into a String
				//String json = new String(outputStream.toByteArray());

				//System.out.println(json);
				qexec.close();
		return results.getResultVars();
	}
	
	public ResultSet getStart() {
		//Lobject (Start) 
		String queryStringStart = "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
	              + "PREFIX  dc:<http://purl.org/dc/elements/1.1/> "
	              + "PREFIX ct: <http://www.insight-centre.org/citytraffic#>" 
	              + "PREFIX ns1: <http://purl.oclc.org/NET/ssnx/ssn#>" 
	              + "PREFIX prov: <http://purl.org/NET/provenance.owl#>" 
	              + "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" 
	              + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" 
	              + "PREFIX sao: <http://iot.ee.surrey.ac.uk/citypulse/resources/ontologies/sao.ttl>" 
	              + "PREFIX tl: <http://purl.org/NET/c4dm/timeline.owl#>" 
	              + "PREFIX xml: <http://www.w3.org/XML/1998/namespace>" 
	              + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>" 
	              + "PREFIX unit0: <http://purl.oclc.org/NET/muo/citypulse/unit/traffic>"
	              + "SELECT ?start "
	              + "WHERE  {?r a sao:streamEvent."
	              + "?p tl:start ?start.} "
	              + "LIMIT 20";
				query = QueryFactory.create(queryStringStart); 
				qexec = QueryExecutionFactory.create(query, getModel()) ; 
				results = qexec.execSelect();
				ResultSetFormatter.out(System.out, results, query) ;
				
     return results;
	}
	public ResultSet getEnd() {
		//Lobject (End) 
		String queryStringEnd = "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
	              + "PREFIX  dc:<http://purl.org/dc/elements/1.1/> "
	              + "PREFIX ct: <http://www.insight-centre.org/citytraffic#>" 
	              + "PREFIX ns1: <http://purl.oclc.org/NET/ssnx/ssn#>" 
	              + "PREFIX prov: <http://purl.org/NET/provenance.owl#>" 
	              + "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" 
	              + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" 
	              + "PREFIX sao: <http://iot.ee.surrey.ac.uk/citypulse/resources/ontologies/sao.ttl>" 
	              + "PREFIX tl: <http://purl.org/NET/c4dm/timeline.owl#>" 
	              + "PREFIX xml: <http://www.w3.org/XML/1998/namespace>" 
	              + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>" 
	              + "PREFIX unit0: <http://purl.oclc.org/NET/muo/citypulse/unit/traffic>"
	              + "SELECT DISTINCT ?end "
	              + "WHERE  {?r a sao:streamEvent."
	              + "?p tl:end ?end.} " ;
		query = QueryFactory.create(queryStringEnd) ;
		qexec = QueryExecutionFactory.create(query, getModel()) ; 
		results = qexec.execSelect();
		ResultSetFormatter.out(System.out, results, query) ;
return results;
	}
	
	public ResultSet getHasUnitOfMeasurement() {
		//Lobject (Start) 
		String queryStringHasUnitOfMeasurement = "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
	              + "PREFIX  dc:<http://purl.org/dc/elements/1.1/> "
	              + "PREFIX ct: <http://www.insight-centre.org/citytraffic#>" 
	              + "PREFIX ns1: <http://purl.oclc.org/NET/ssnx/ssn#>" 
	              + "PREFIX prov: <http://purl.org/NET/provenance.owl#>" 
	              + "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" 
	              + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" 
	              + "PREFIX sao: <http://iot.ee.surrey.ac.uk/citypulse/resources/ontologies/sao.ttl>" 
	              + "PREFIX tl: <http://purl.org/NET/c4dm/timeline.owl#>" 
	              + "PREFIX xml: <http://www.w3.org/XML/1998/namespace>" 
	              + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>" 
	              + "PREFIX unit0: <http://purl.oclc.org/NET/muo/citypulse/unit/traffic>"
	              + "SELECT ?unite "
	              + "WHERE {?r a sao:Point."
	              + "?p sao:hasUnitOfMeasurement ?unite.} "
	              + "LIMIT 10";
		query = QueryFactory.create(queryStringHasUnitOfMeasurement) ; 
		qexec = QueryExecutionFactory.create(query, getModel()) ; 
		results = qexec.execSelect();
		ResultSetFormatter.out(System.out, results, query) ;
		return results;
	}
	
	public ResultSet getTempObservation() {
		//L�object (tl:at) 
		String queryStringTempsObservation = "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
	              + "PREFIX  dc:<http://purl.org/dc/elements/1.1/> "
	              + "PREFIX ct: <http://www.insight-centre.org/citytraffic#>" 
	              + "PREFIX ns1: <http://purl.oclc.org/NET/ssnx/ssn#>" 
	              + "PREFIX prov: <http://purl.org/NET/provenance.owl#>" 
	              + "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" 
	              + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" 
	              + "PREFIX sao: <http://iot.ee.surrey.ac.uk/citypulse/resources/ontologies/sao.ttl>" 
	              + "PREFIX tl: <http://purl.org/NET/c4dm/timeline.owl#>" 
	              + "PREFIX xml: <http://www.w3.org/XML/1998/namespace>" 
	              + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>" 
	              + "PREFIX unit0: <http://purl.oclc.org/NET/muo/citypulse/unit/traffic>"
	              + "SELECT ?tempObservation "
	              + "WHERE {?r a sao:Point."
	              + "?s tl:at ?tempObservation.} "
	              + "LIMIT 20";
		query = QueryFactory.create(queryStringTempsObservation) ; 
		qexec = QueryExecutionFactory.create(query, getModel()) ; 
		results = qexec.execSelect();
		ResultSetFormatter.out(System.out, results, query) ;
		return results;
	}
	
	public ResultSet getHasLongitude() {
		//L�object (hasLongitude) 
		String queryStringHasLongitude = "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
	              + "PREFIX  dc:<http://purl.org/dc/elements/1.1/> "
	              + "PREFIX ct: <http://www.insight-centre.org/citytraffic#>" 
	              + "PREFIX ns1: <http://purl.oclc.org/NET/ssnx/ssn#>" 
	              + "PREFIX prov: <http://purl.org/NET/provenance.owl#>" 
	              + "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" 
	              + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" 
	              + "PREFIX sao: <http://iot.ee.surrey.ac.uk/citypulse/resources/ontologies/sao.ttl>" 
	              + "PREFIX tl: <http://purl.org/NET/c4dm/timeline.owl#>" 
	              + "PREFIX xml: <http://www.w3.org/XML/1998/namespace>" 
	              + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>" 
	              + "PREFIX unit0: <http://purl.oclc.org/NET/muo/citypulse/unit/traffic>"
	              + "SELECT DISTINCT ?longitude "
	              + "WHERE {?r a sao:FeatureOfInterest."
	              + "?r ct:hasFirstNode ?s."
	              + "?s ct:hasLongitude ?longitude.} "
	              + "LIMIT 20";
		query = QueryFactory.create(queryStringHasLongitude) ; 
		qexec = QueryExecutionFactory.create(query, getModel()) ; 
		results = qexec.execSelect();
		ResultSetFormatter.out(System.out, results, query) ;
		return results;
	}
	
	public ResultSet getHasLatitude() {
		//L�object (tl:at) 
		String queryStringHasLatitude = "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
	              + "PREFIX  dc:<http://purl.org/dc/elements/1.1/> "
	              + "PREFIX ct: <http://www.insight-centre.org/citytraffic#>" 
	              + "PREFIX ns1: <http://purl.oclc.org/NET/ssnx/ssn#>" 
	              + "PREFIX prov: <http://purl.org/NET/provenance.owl#>" 
	              + "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" 
	              + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" 
	              + "PREFIX sao: <http://iot.ee.surrey.ac.uk/citypulse/resources/ontologies/sao.ttl>" 
	              + "PREFIX tl: <http://purl.org/NET/c4dm/timeline.owl#>" 
	              + "PREFIX xml: <http://www.w3.org/XML/1998/namespace>" 
	              + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>" 
	              + "PREFIX unit0: <http://purl.oclc.org/NET/muo/citypulse/unit/traffic>"
	              + "SELECT DISTINCT ?latitude "
	              + "WHERE {?r a sao:FeatureOfInterest."
	              + "?r ct:hasFirstNode ?s."
	              + "?s ct:hasLatitude ?latitude.} "
	              + "LIMIT 20";
		query = QueryFactory.create(queryStringHasLatitude) ; 
		qexec = QueryExecutionFactory.create(query, getModel()) ; 
		results = qexec.execSelect();
		ResultSetFormatter.out(System.out, results, query) ;
		return results;
	}
	
	public ResultSet getHasNodeName() {
		//L�object (hasNodeName) 
		String queryStringHasNodeName = "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
	              + "PREFIX  dc:<http://purl.org/dc/elements/1.1/> "
	              + "PREFIX ct: <http://www.insight-centre.org/citytraffic#>" 
	              + "PREFIX ns1: <http://purl.oclc.org/NET/ssnx/ssn#>" 
	              + "PREFIX prov: <http://purl.org/NET/provenance.owl#>" 
	              + "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" 
	              + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" 
	              + "PREFIX sao: <http://iot.ee.surrey.ac.uk/citypulse/resources/ontologies/sao.ttl>" 
	              + "PREFIX tl: <http://purl.org/NET/c4dm/timeline.owl#>" 
	              + "PREFIX xml: <http://www.w3.org/XML/1998/namespace>" 
	              + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>" 
	              + "PREFIX unit0: <http://purl.oclc.org/NET/muo/citypulse/unit/traffic>"
	              + "SELECT DISTINCT ?hasNodeName "
	              + "WHERE {?r a sao:FeatureOfInterest."
	              + "?r ct:hasFirstNode ?s."
	              + "?s ct:hasNodeName ?hasNodeName.} "
	              + "LIMIT 20";
		query = QueryFactory.create(queryStringHasNodeName) ; 
		qexec = QueryExecutionFactory.create(query, getModel()) ; 
		results = qexec.execSelect();
		ResultSetFormatter.out(System.out, results, query) ;
		return results;
	}
	
	public ResultSet getValue() {
		//L�object (sao :value) 
		String queryStringValue = "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
	              + "PREFIX  dc:<http://purl.org/dc/elements/1.1/> "
	              + "PREFIX ct: <http://www.insight-centre.org/citytraffic#>" 
	              + "PREFIX ns1: <http://purl.oclc.org/NET/ssnx/ssn#>" 
	              + "PREFIX prov: <http://purl.org/NET/provenance.owl#>" 
	              + "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" 
	              + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" 
	              + "PREFIX sao: <http://iot.ee.surrey.ac.uk/citypulse/resources/ontologies/sao.ttl>" 
	              + "PREFIX tl: <http://purl.org/NET/c4dm/timeline.owl#>" 
	              + "PREFIX xml: <http://www.w3.org/XML/1998/namespace>" 
	              + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>" 
	              + "PREFIX unit0: <http://purl.oclc.org/NET/muo/citypulse/unit/traffic>"
	              + "SELECT DISTINCT ?value "
	              + "WHERE {?r a sao:Point."
	              + "?r sao:value ?value.} "
	              + "LIMIT 20";
		query = QueryFactory.create(queryStringValue) ; 
		qexec = QueryExecutionFactory.create(query, getModel()) ; 
		results = qexec.execSelect();
		ResultSetFormatter.out(System.out, results, query) ;
		return results;
	}
	public ResultSet getAll() {
		String queryStringValue = "prefix unit0: <http://purl.oclc.org/NET/muo/citypulse/unit/traffic>\n" + 
				"Prefix ct: <http://www.insight-centre.org/citytraffic#>\n" + 
				"Prefix ns1: <http://purl.oclc.org/NET/ssnx/ssn#>\n" + 
				"Prefix prov: <http://purl.org/NET/provenance.owl#>\n" + 
				"prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" + 
				"prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" + 
				"prefix sao: <http://iot.ee.surrey.ac.uk/citypulse/resources/ontologies/sao.ttl>\n" + 
				"prefix tl: <http://purl.org/NET/c4dm/timeline.owl#>\n" + 
				"prefix xml: <http://www.w3.org/XML/1998/namespace>\n" + 
				"prefix xsd: <http://www.w3.org/2001/XMLSchema#> \n" + 
				"\n" + 
				"SELECT distinct ?r ?interest ?unit ?value ?time ?longitude ?latitude\n" + 
				"WHERE {\n" + 
				"\n" + 
				"  \n" + 
				"  ?r ns1:featureOfInterest ?interest.\n" + 
				"  ?interest ct:hasFirstNode ?ref_pos.\n" + 
				"  ?ref_pos ct:hasLongitude ?longitude.\n" + 
				"  ?ref_pos ct:hasLatitude ?latitude.\n" + 
				"\n" + 
				"           \n" + 
				"  ?r a sao:Point.\n" + 
				"  ?r sao:hasUnitOfMeasurement ?unit.\n" + 
				"  ?r sao:value ?value.\n" + 
				"  ?r sao:time ?restTime.\n" + 
				"  ?restTime tl:at ?time.\n" + 
				"  \n" + 
				"            \n" + 
				"}\n" + 
				"Limit 20";
		query = QueryFactory.create(queryStringValue) ; 
		qexec = QueryExecutionFactory.create(query, getModel()) ; 
		results = qexec.execSelect();
		//ResultSetFormatter.out(System.out, results, query) ;
		return results;
		
				
	}
	public ResultSet getById(String str) {
		String queryStringValue = "prefix unit0: <http://purl.oclc.org/NET/muo/citypulse/unit/traffic>\n" + 
				"Prefix ct: <http://www.insight-centre.org/citytraffic#>\n" + 
				"Prefix ns1: <http://purl.oclc.org/NET/ssnx/ssn#>\n" + 
				"Prefix prov: <http://purl.org/NET/provenance.owl#>\n" + 
				"prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" + 
				"prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" + 
				"prefix sao: <http://iot.ee.surrey.ac.uk/citypulse/resources/ontologies/sao.ttl>\n" + 
				"prefix tl: <http://purl.org/NET/c4dm/timeline.owl#>\n" + 
				"prefix xml: <http://www.w3.org/XML/1998/namespace>\n" + 
				"prefix xsd: <http://www.w3.org/2001/XMLSchema#> \n" + 
				"\n" + 
				"SELECT distinct ?r ?interest ?unit ?value ?time ?longitude ?latitude\n" + 
				"WHERE {\n" + 
				"\n" + 
				"  \n" + 
				"  ?r ns1:featureOfInterest ?interest.\n" + 
				"  ?interest ct:hasFirstNode ?ref_pos.\n" + 
				"  ?ref_pos ct:hasLongitude ?longitude.\n" + 
				"  ?ref_pos ct:hasLatitude ?latitude.\n" + 
				"\n" + 
				"           \n" + 
				"  ?r a sao:Point.\n" + 
				"  ?r sao:hasUnitOfMeasurement ?unit.\n" + 
				"  ?r sao:value ?value.\n" + 
				"  ?r sao:time ?restTime.\n" + 
				"  ?restTime tl:at ?time.\n" + 
				String.format("FILTER (?restTime= %s)", str)+
				"  \n" + 
				"            \n" + 
				"}\n" + 
				"Limit 20";
		query = QueryFactory.create(queryStringValue) ; 
		qexec = QueryExecutionFactory.create(query, getModel()) ; 
		results = qexec.execSelect();
		//ResultSetFormatter.out(System.out, results, query) ;
		return results;
		
		//String.format("regex(str(?r), \"temp_%s$\")", Id);
		
		
		
				
	}
	
	      
}