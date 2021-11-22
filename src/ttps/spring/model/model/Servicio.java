package ttps.spring.model.model;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
@Entity
@Table(name="servicios")
public class Servicio implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_servicio")
	private Long id;
	
	@Column
	private String nombre;
	@OneToOne
	private TipoServicio tipo;
	@Column
	private String descripcion;
	@Column
	private String url;
	@Column
	private Long whatsapp;
	@Column
	private String instagram;
	@Column
	private String twiter;
	
	
	@OneToMany(mappedBy="servicio", fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Valoracion> valoraciones;
	
	
	@OneToMany(mappedBy="servicio", fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Imagen> imagenes;
	
	
	@OneToMany(mappedBy="servicio", fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Reserva> reservas;
	@Column
	private Boolean activo = true;
	
		
	
	
	public TipoServicio getTipo() {
		return tipo;
	}
	public void setTipo(TipoServicio tipo) {
		this.tipo = tipo;
	}
	public List<Valoracion> getValoraciones() {
		return valoraciones;
	}
	public void setValoraciones(List<Valoracion> valoraciones) {
		this.valoraciones = valoraciones;
	}
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
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Long getWhatsapp() {
		return whatsapp;
	}
	public void setWhatsapp(Long whatsapp) {
		this.whatsapp = whatsapp;
	}
	public String getInstagram() {
		return instagram;
	}
	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}
	public String getTwiter() {
		return twiter;
	}
	public void setTwiter(String twiter) {
		this.twiter = twiter;
	}
	
	public List<Imagen> getImagenes() {
		return imagenes;
	}
	public void setImagenes(List<Imagen> imagenes) {
		this.imagenes = imagenes;
	}
	public List<Reserva> getReservas() {
		return reservas;
	}
	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
	
	public Servicio() {
		
	}
	@Override
	public String toString() {
		return "Servicio [nombre=" + nombre + ", tipo=" + tipo + ", descripcion=" + descripcion + ", url=" + url
				+ ", whatsapp=" + whatsapp + ", instagram=" + instagram + ", twiter=" + twiter + ", valoraciones="
				+ valoraciones + ", imagenes=" + imagenes + ", reservas=" + reservas + ", activo=" + activo + ", id="
				+ id + "]";
	}
	public Servicio(String nombre, TipoServicio tipo, String descripcion, String url, Long whatsapp, String instagram,
			String twiter, List<Valoracion> valoraciones, List<Imagen> imagenes, List<Reserva> reservas, Boolean activo,
			Long id) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.url = url;
		this.whatsapp = whatsapp;
		this.instagram = instagram;
		this.twiter = twiter;
		this.valoraciones = valoraciones;
		this.imagenes = imagenes;
		this.reservas = reservas;
		this.activo = activo;
		this.id = id;
	}
	
	public Servicio(String nombre, TipoServicio tipo, String descripcion, String url, Long whatsapp, String instagram,
			String twiter) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.url = url;
		this.whatsapp = whatsapp;
		this.instagram = instagram;
		this.twiter = twiter;
	}
	
	
	
	

}
