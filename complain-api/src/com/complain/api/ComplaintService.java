package com.complain.api;

import java.util.*;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("complaints")
public class ComplaintService {
	ComplaintDAO com = new ComplaintDAO(); 
	
	
	@GET()
	@Produces(MediaType.APPLICATION_JSON)
	public List<ComplaintModel> allComplaints()throws Exception{
		return com.getAllComplaints();
		
	}
	
	@POST()
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response Save(ComplaintModel complaint)throws Exception {
		int cid = com.CreateComplaint(complaint);
		String str = "Your Complaint is registered with Complaint ID "+cid;
		return Response.status(Response.Status.OK).entity(str).type(MediaType.APPLICATION_JSON).build();
	}
	
    @POST()
    @Path("/get")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ComplaintModel retrieve(ComplaintModel complaintid) throws Exception{
		return com.getComplaintDetails(complaintid);
	}
}
