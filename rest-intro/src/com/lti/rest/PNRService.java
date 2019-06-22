package com.lti.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.lti.rest.PNR.Status;

@Path("/pnr")
public class PNRService {
	
	/*
	 * The URL will look like this : http://localhost:8181/rest-intro/pnr/status?pnrNo=12345 
	 * QueryParam instead of the getParameter used in servlets
	*/
	
	@GET
	@Path("/status")
	public PNR getStatus(@QueryParam("pnrNo") int pnrNo) {
		/*
		 * logic of executing the required method of 
		 * a DAO/or any other class will be here
		 * missing right now
		 */
		
		PNR pnr = new PNR();
		pnr.setPnrno(pnrNo);
		pnr.setTrainno(1111);
		pnr.setDate("26-june-2019");
		pnr.setStatus(Status.RAC);
		
		return pnr;
		
	}
}
