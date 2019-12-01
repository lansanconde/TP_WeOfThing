package com.lansanalatty.wot.web;




import java.awt.List;
import java.util.ArrayList;

import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Resource;







public class ConvertRestToJson {

	
	
	public ConvertRestToJson() {
		
	}
	
	public ArrayList<Entites>   getJsonObject(ResultSet results){
		 ArrayList<Entites> list = new ArrayList<Entites>();
		 System.out.println("-------------------------------Resource ---------");
		while (results.hasNext()) {
            QuerySolution soln = results.nextSolution();
            Resource x = soln.getResource("type");
            System.out.println("-------------------------------Resource ---------");
            System.out.println(x);
            Entites r = new Entites();
            r.setStart(x.toString());
            list.add(r);
        }
		return list;
	}
	
		
}
