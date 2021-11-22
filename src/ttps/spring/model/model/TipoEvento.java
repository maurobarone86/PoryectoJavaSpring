package ttps.spring.model.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipoEvento")
public class TipoEvento implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_tipoEvento")
	private Long id;
	@Column
	private String nombre;
	@Column
	private Boolean activo=true;
	@Column
	private Boolean publico;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	public Boolean getPublico() {
		return publico;
	}
	public void setPublico(Boolean publico) {
		this.publico = publico;
	}
	@Override
	public String toString() {
		return "TipoEvento [id=" + id + ", nombre=" + nombre + ", activo=" + activo + ", publico=" + publico + "]";
	}
	public TipoEvento(Long id, String nombre, Boolean activo, Boolean publico) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.activo = activo;
		this.publico = publico;
	}
	public TipoEvento(String nombre, Boolean publico) {
		this.nombre=nombre;
		this.publico=publico;
	}
	public TipoEvento() {
		
	}
	
	
	
	

}
