package ttps.spring.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.databind.ObjectMapper;



abstract public class GenericController<T> {
	protected Class<T> controllerClass;

	public  ResponseEntity<String> getEntity(Long Id){
		 if (existe(Id)) {
	    	T entity = buscar(Id);
	    	ObjectMapper mapper = new ObjectMapper();
	        String jsonInString= null;
	        try {
	        	jsonInString = mapper.writeValueAsString(entity);
	        	return new ResponseEntity<String>(jsonInString,HttpStatus.OK);
	        	}
	        catch (Exception e) {
	        	return new ResponseEntity<String> (HttpStatus.INTERNAL_SERVER_ERROR);
	        	}
	    }
	    else {
	    	return new ResponseEntity<String> ( HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
	    	}
	}
	protected abstract T buscar(Long id);

	abstract public Boolean existe(Long id);
	
	
	
	
	
	
	
	
	
	
}
