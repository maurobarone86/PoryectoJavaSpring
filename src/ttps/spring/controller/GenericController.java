package ttps.spring.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.databind.ObjectMapper;



abstract public class GenericController<T> {
	protected Class<T> controllerClass;

	public  ResponseEntity<T> getEntity(Long Id){
		 if (existe(Id)) {
	    	T entity = buscar(Id);
	        return new ResponseEntity<T>(entity,HttpStatus.OK);
	    }else {
	    	return new ResponseEntity<T> ( HttpStatus.NO_CONTENT);
	    }
	}
	public  ResponseEntity<T> setActivoEntity(Long Id, Boolean cambio){
		 if (existe(Id)) {
	    	T entity = buscar(Id);
	    	setActivo(entity,cambio);
	       	return new ResponseEntity<T>(entity,HttpStatus.OK);
	        	}
	    else {
	    	return new ResponseEntity<T> ( HttpStatus.NO_CONTENT);
	    	}
	}
	
		
	abstract public void setActivo(T entity, Boolean cambio);
		
	protected abstract T buscar(Long id);

	abstract public Boolean existe(Long id);
	
	
	
	
	
	
	
	
	
	
}
