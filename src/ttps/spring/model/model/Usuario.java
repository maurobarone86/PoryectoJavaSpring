package ttps.spring.model.model;


import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;



@Entity
@Table(name="usuarios")
public class Usuario implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_usuario")
	private Long id;
	
	@Column
	private String nombre;
	
	@Column
	private String apellido;
	
	@Column
	private Date fechaNac;
	
	@Column
	private String direccion;
	
	@Column
	private String nombreUsuario;
	
	@Column
	private String password;
	
	@Column
	private Boolean activo = true;
	
	@OneToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE},fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Evento> eventos;
	
	@OneToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE},fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Servicio> servicios;
	
	
	
	
		
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Date getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Evento> getEventos() {
		return eventos;
	}
	public void setEventos(List<Evento> eventos) {
		if (eventos!=null) {
			this.eventos = eventos;
		}
	}
	public void setEvento(Evento evento) {
		if (evento!=null) {
			this.eventos.add(evento);
		}
	}
	public List<Servicio> getServicios() {
		return servicios;
	}
	public void setServicios(List<Servicio> servicios) {
		if (servicios!=null) {
			this.servicios = servicios;
		}
	}
	public void setServicio(Servicio servicio) {
		if (servicio!=null) {
			this.servicios.add(servicio);
		}
	}
	public Usuario(String nombre, String apellido, Date fechaNac, String direccion, String nombreUsuario,
			String password,  List<Evento> eventos, List<Servicio> servicios) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNac = fechaNac;
		this.direccion = direccion;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		
		this.eventos = eventos;
		this.servicios = servicios;
	}
	public Usuario(String nombre, String apellido, Date fecha, String nombreUser) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.fechaNac=fecha;
		this.nombreUsuario=nombreUser;
	}
	public Usuario() {
		
	}
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellido=" + apellido + ", fechaNac=" + fechaNac + ", direccion="
				+ direccion + ", nombreUsuario=" + nombreUsuario + ", password=" + password + ", reservas=" +  ", eventos=" + eventos + ", servicios=" + servicios + ", activo=" + activo + ", id=" + id + "]";
	}
	
	
	
	

}
