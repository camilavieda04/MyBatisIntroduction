package edu.eci.cvds.sampleprj.dao;

import java.util.List;

import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.TipoItem;

public interface TipoItemDAO {
	
	 public TipoItem load(int id) throws PersistenceException;
	 public List<TipoItem> consultarTiposItem() throws PersistenceException;
	 public List<TipoItem> getTipostems() throws PersistenceException;
}
