package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.sampleprj.dao.ItemDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.TipoItemDAO;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.entities.TipoItem;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import java.sql.Date;
import java.util.List;
import java.time.LocalDate;
import java.util.Calendar;

import org.mybatis.guice.transactional.Transactional;

@Singleton
public class ServiciosAlquilerImpl implements ServiciosAlquiler{
	   @Inject
	   private ItemDAO itemDAO;
	   @Inject
	   private ClienteDAO clienteDAO;
	   @Inject
	   private TipoItemDAO tipoItemDAO;
	   
	

	@Override
	public int valorMultaRetrasoxDia(int itemId) {
		return (int) itemDAO.load(itemId).getTarifaxDia();

	}

	@Override
	public Cliente consultarCliente(long docu) throws ExcepcionServiciosAlquiler {
		// TODO Auto-generated method stub
		//System.out.println(clienteDAO);
		try {
			return clienteDAO.load(docu);
		}
		
		 catch (PersistenceException ex) {
	           throw new ExcepcionServiciosAlquiler("Error al consultar el cliente "+docu,ex);
	       }
		
	}

	@Override
	public List<ItemRentado> consultarItemsCliente(long idcliente) throws ExcepcionServiciosAlquiler {
		try {
			return clienteDAO.load((int) idcliente).getRentados();
		}
		catch(org.apache.ibatis.exceptions.PersistenceException ex){
			throw new ExcepcionServiciosAlquiler("Error al consultar los Items rentados por el cliente"+idcliente,ex);
		}
		// TODO Auto-generated method stub
		  //throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public List<Cliente> consultarClientes() throws ExcepcionServiciosAlquiler {
		try {
		 return clienteDAO.consultarClientes();
		}
		catch(org.apache.ibatis.exceptions.PersistenceException ex) {
			throw new ExcepcionServiciosAlquiler("Error al consultar los clientes",ex);
		}
	}

	@Override
	public Item consultarItem(int id) throws ExcepcionServiciosAlquiler {
		// TODO Auto-generated method stub
		try {
	           return itemDAO.load(id);
	       } catch (PersistenceException ex) {
	           throw new ExcepcionServiciosAlquiler("Error al consultar el item "+id,ex);
	       }
	}

	@Override
	public List<Item> consultarItemsDisponibles() {
		// TODO Auto-generated method stub
		 return itemDAO.consultarItemsDisponibles();
	}

	//@Override
	/*public long consultarMultaAlquiler(int iditem, Date fechaDevolucion) throws ExcepcionServiciosAlquiler {
		// TODO Auto-generated method stub
		 throw new UnsupportedOperationException("Not supported yet.");
	}*/

	@Override
	public TipoItem consultarTipoItem(int id) throws ExcepcionServiciosAlquiler {
		try {
			return tipoItemDAO.load(id);
		}
		catch(PersistenceException ex) {
			throw new ExcepcionServiciosAlquiler("Error al consultar el Tipo de Item "+id,ex);
			
		}
			
		
	}

	/*@Override
	public List<TipoItem> consultarTiposItem() throws ExcepcionServiciosAlquiler {
		// TODO Auto-generated method stub
		 return tipoItemDAO.consultarTiposItem();
	}*/
	
    @Transactional 
	@Override
	   public void registrarAlquilerCliente(Date date, long docu, Item item, int numdias) throws ExcepcionServiciosAlquiler {
	       throw new UnsupportedOperationException("Not supported yet.");
	   }
       @Transactional
	   @Override
	   public void registrarCliente(Cliente c) throws ExcepcionServiciosAlquiler {
    	  
    		   clienteDAO.agregarCliente(c);
    	   
	   }

	   /*@Override
	   public long consultarCostoAlquiler(int iditem, int numdias) throws ExcepcionServiciosAlquiler {
	       throw new UnsupportedOperationException("Not supported yet.");
	   }*/
	   /*@Transactional
	   @Override
	   public void actualizarTarifaItem(int id, long tarifa) throws ExcepcionServiciosAlquiler {
	       throw new UnsupportedOperationException("Not supported yet.");
	   }*/
	   @Transactional
	   @Override
	   public void registrarItem(Item i) throws ExcepcionServiciosAlquiler {
	       try {
	    	   itemDAO.save(i);
	    	}
	       catch(org.apache.ibatis.exceptions.PersistenceException ex) {
	    	   throw new ExcepcionServiciosAlquiler("Error al registrar el Item",ex);
	       }
	   }
      /* @Transactional 
	   @Override
	   public void vetarCliente(long docu, boolean estado) throws ExcepcionServiciosAlquiler {
	       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	   }
	}*/

	@Override
	public long consultarMultaAlquiler(int iditem, Date fechaDevolucion) throws ExcepcionServiciosAlquiler {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TipoItem> consultarTiposItem() throws ExcepcionServiciosAlquiler {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long consultarCostoAlquiler(int iditem, int numdias) throws ExcepcionServiciosAlquiler {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void actualizarTarifaItem(int id, long tarifa) throws ExcepcionServiciosAlquiler {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vetarCliente(long docu, boolean estado) throws ExcepcionServiciosAlquiler {
		// TODO Auto-generated method stub
		
	}
}