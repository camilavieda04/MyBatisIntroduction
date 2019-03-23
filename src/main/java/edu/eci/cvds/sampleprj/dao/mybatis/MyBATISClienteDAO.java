package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.sampleprj.dao.ItemDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.cvds.samples.entities.TipoItem;
import java.sql.SQLException;
import java.util.List;

public class MyBATISClienteDAO implements ClienteDAO{
	
	@Inject 
	private ClienteMapper clienteMapper;

	@Override
	public Cliente load(long docu) throws PersistenceException {
		// TODO Auto-generated method stub
		try {
			return clienteMapper.consultarCliente(docu);
		}
		
		catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al consultar cliente "+docu,e);
		}
	}
	
	@Override
	public void save(Cliente cliente) throws PersistenceException{
		try {
			clienteMapper.insertarCliente(cliente);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al consultar el cliente"+cliente.toString(),e);
		}
	}
	public List<Cliente> consultarClientes() throws PersistenceException{
		try {
			return clienteMapper.consultarClientes();
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al consultar el cliente",e);
		}
	}

	@Override
	public void registrarCliente(long documento, String nombre, String telefono, String direccion, String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregarCliente(Cliente c) {
		// TODO Auto-generated method stub
		
	}
	

	
	
	

}
