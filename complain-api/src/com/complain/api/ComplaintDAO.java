package com.complain.api;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ComplaintDAO {
	
	Connection connection=null; 
	public Connection openConnection() throws Exception
	{
		String url= "jdbc:oracle:thin:@10.10.20.3:1781:bduat";
		String user= "bdtraining";
		String password= "bdtraining123";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			 connection = DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		return connection;
	}
	

	
	public void closeConnection(Connection connection)
	{
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


	
	public List<ComplaintModel> getAllComplaints() throws Exception
	{
		List<ComplaintModel> p = new ArrayList<ComplaintModel>();
		connection=openConnection();		
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM RE_COMPLAINT");
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next())
		{
			ComplaintModel cm = new ComplaintModel();
			cm.setComplaintID(rs.getInt(1));
			cm.setTransactionID(rs.getInt(2));
			cm.setCategory(rs.getString(3));
			cm.setComplaintStatus(rs.getString(4));
			cm.setDescription(rs.getString(5));
			p.add(cm);
		}		
		closeConnection(connection);
		return p;
	}	
	
	
	public int CreateComplaint (ComplaintModel complaintModel)throws Exception
	{
		connection=openConnection();
	
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO RE_COMPLAINT" + " VALUES(id_seq.nextval,?,?,?,?)");
		//preparedStatement.setInt(1, complaintModel.getComplaintID());
		preparedStatement.setInt(1, complaintModel.getTransactionID());
		preparedStatement.setString(2, complaintModel.getCategory());
		preparedStatement.setString(3,"Assigned");

	//	preparedStatement.setString(4, complaintModel.getComplaintStatus());
		preparedStatement.setString(4, complaintModel.getDescription());
		preparedStatement.executeUpdate();
		PreparedStatement preparedStatement2 = connection.prepareStatement("SELECT MAX(COMPLAINT_ID) FROM RE_COMPLAINT");
		ResultSet rs = preparedStatement2.executeQuery();
		int cid = 0;
		while(rs.next())
		{
			cid = rs.getInt(1);
		}
		
		
		closeConnection(connection);	
		return cid;
	}
	
	

	public ComplaintModel getComplaintDetails(ComplaintModel complaintId) throws Exception
	{
		connection=openConnection();	
		ComplaintModel cm = new ComplaintModel();
		
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM RE_COMPLAINT WHERE COMPLAINT_ID = ?");
		preparedStatement.setInt(1, complaintId.getComplaintID());
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next())
		{
			
			cm.setComplaintID(rs.getInt(1));
			cm.setTransactionID(rs.getInt(2));
			cm.setCategory(rs.getString(3));
			cm.setComplaintStatus(rs.getString(4));
			cm.setDescription(rs.getString(5));
			
		}		
		closeConnection(connection);
		return cm;
		
		
	}

}