package com.datasol.entra.dao;

import java.util.List;

import com.datasol.entra.domain.Client;
import com.datasol.entra.exception.DaoException;

public interface ClientDao {
	
public List<Client> getClients() throws DaoException;
	
	public Client getClientByEmail(String email) throws DaoException;
	
	public void saveClient(Client client) throws DaoException;
	
	public void deleteClient(Client client) throws DaoException;

}
