package edu.eci.cvds.sampleprj.dao;
import java.util.List;

import edu.eci.cvds.samples.entities.Cliente;

public interface ClienteDAO {
	
	public Cliente load(long docu) throws PersistenceException;
	public List<Cliente> consultarClientes() throws PersistenceException;
	public void registrarCliente(long documento,String nombre,String telefono,String direccion,String email)throws PersistenceException;
    public void agregarCliente(Cliente c) throws PersistenceException;
    public void save(Cliente cliente) throws PersistenceException;
}
