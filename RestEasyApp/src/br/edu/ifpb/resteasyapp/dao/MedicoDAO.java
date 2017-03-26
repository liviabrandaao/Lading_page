package br.edu.ifpb.resteasyapp.dao;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifpb.resteasyapp.entidade.Medico;

public class MedicoDAO extends GenericDao<Integer, Medico>{

	private static MedicoDAO instance;
	
	public static MedicoDAO getInstance() {		
		instance = new MedicoDAO();		
		return instance;
	}
	
	@Override
	public List<Medico> getAll() throws SQLException {
		return super.getAll("Medico.getAll");
	}

	@Override
	public Class<?> getEntityClass() {
		return Medico.class;
	}

	@Override
	public Medico find(Medico entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
