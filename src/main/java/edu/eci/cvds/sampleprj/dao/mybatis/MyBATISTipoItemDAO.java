package edu.eci.cvds.sampleprj.dao.mybatis;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import edu.eci.cvds.sampleprj.dao.TipoItemDAO;
import edu.eci.cvds.samples.entities.TipoItem;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.TipoItemMapper;

public class MyBATISTipoItemDAO {
	@Inject 
	private TipoItemMapper tipoItemMapper;
	
	public void save(TipoItem tipoItem)throws PersistenceException{
		try {
			tipoItemMapper.addTipoItem(tipoItem.getDescripcion());
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al registar el Tipo Item"  + tipoItem.toString(),e);
		}
	}
	
	public TipoItem load(int id) throws PersistenceException{
		try {
			return tipoItemMapper.getTipoItem(id);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al cargar el Tipo Item"+id, e);
		}
	}
	
	public List<TipoItem> getTiposItems()throws PersistenceException{
		try {
			return tipoItemMapper.getTiposItems();
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al consultar los tipos Items",e);
		}
	}

}
