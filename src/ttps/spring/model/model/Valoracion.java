package ttps.spring.model.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="valoracion")
public class Valoracion implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_valoracion")
	private Long id;
	
	@Column
	private String nombre;
	
	@Column
	private Boolean activo= true;
	
	@Column
	private Integer puntos=0;
	
	@ManyToOne
	@JoinColumn(name="id_servicio")
	private Servicio servicio;
	
	
	public Servicio getServicio() {
		return servicio;
	}
	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
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
	public Integer getPuntos() {
		return puntos;
	}
	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}
	@Override
	public String toString() {
		return "Valoracion [id=" + id + ", nombre=" + nombre + ", activo=" + activo + ", puntos=" + puntos + "]";
	}
	public Valoracion(Long id, String nombre, Boolean activo, Integer puntos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.activo = activo;
		this.puntos = puntos;
	}
	public Valoracion() {
		
	}
	
	

}
