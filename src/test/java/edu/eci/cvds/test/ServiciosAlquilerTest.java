package edu.eci.cvds.test;
import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquilerFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.quicktheories.core.Gen;
import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.Generate.*;
import static org.quicktheories.generators.SourceDSL.*;
public class ServiciosAlquilerTest {
	  @Inject
	    private SqlSession sqlSession;

	    ServiciosAlquiler serviciosAlquiler;

	    public ServiciosAlquilerTest() {
	        serviciosAlquiler = ServiciosAlquilerFactory.getInstance().getServiciosAlquilerTesting();
	    }

	    @Before
	    public void setUp() {
	    }

	    
	    public static Gen<Cliente> clientes(){
	    	return nombre().zip(documento(),telefono(),direccion(),email(),(nombre,documento,telefono,direccion,email)
	    			-> new Cliente(nombre,documento,telefono,direccion,email));
	    }
	    	
	    	public static Gen<String> nombre(){
	    		return strings().basicLatinAlphabet().ofLengthBetween(10, 50);
	    		
	    	}
	    	
	    	public static Gen<Long> documento(){
	    		return longs().from(0).upToAndIncluding(1000000000);
	    	}
	    	
	    	public static Gen<String> telefono(){
	    		return strings().numericBetween(3000000, 10000000);
	    	} 
	    	public static Gen<String> direccion(){
	    		return strings().allPossible().ofLengthBetween(8, 30);
	    	}
	    	
	    	public static Gen<String> email(){
	    		return strings().allPossible().ofLengthBetween(5,50);
	    	}
	    	
	     public static Gen<java.util.List<Cliente>> GenClientes(){
	    	 return lists().of(clientes()).ofSizeBetween(5, 50);
	     
	    	
	     }
}


