package com.p2.dao;

import com.p2.model.Logins;

public class LoginsDAO {
	
	private static LoginsDAO loginsDAO;
	private LoginsDAO() {
		super();
	}

	
	public static LoginsDAO getLoginsDAO() {
		if (loginsDAO == null) {
			loginsDAO = new LoginsDAO();
		}
		return loginsDAO;
	}
	
	public Logins findByUserId(int id) {
		
		}
	
	
}
