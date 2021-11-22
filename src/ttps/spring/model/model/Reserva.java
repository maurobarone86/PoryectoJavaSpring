package ttps.spring.model.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="reservas")
public class Reserva implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_reserva")
	private Long id;
	
	@Column
	private String formaPago;
	
	@Column
	private String email;
	
	@Column
	private Long telefono;
	
	@ManyToOne
	@JoinColumn(name="id_evento")
	private Evento evento;
	
	@OneToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="id_servicio")
	private Servicio servicio;
	
	@Column
	private Boolean activo = true;
	
	@OneToOne
	private Estado estado;
	
		
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
		
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	
	public String getFormaPago() {
		return formaPago;
	}
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getTelefono() {
		return telefono;
	}
	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Servicio getServicio() {
		return servicio;
	}
	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	@Override
	public String toString() {
		return "Reserva [formaPago=" + formaPago + ", email=" + email + ", telefono=" + telefono + ", evento=" + evento
				+ ", usuario=" + usuario + ", servicio=" + servicio + ", activo=" + activo + ", estado=" + estado
				+ ", id=" + id + "]";
	}
	public Reserva(String formaPago, String email, Long telefono, Evento evento, Usuario usuario, Servicio servicio,
			Boolean activo, Estado estado, Long id) {
		super();
		this.formaPago = formaPago;
		this.email = email;
		this.telefono = telefono;
		this.evento = evento;
		this.usuario = usuario;
		this.servicio = servicio;
		this.activo = activo;
		this.estado = estado;
		this.id = id;
	}
	
	public Reserva(String formaPago, String email, Long telefono, Evento evento, Usuario usuario, Servicio servicio, Estado estado) {
		super();
		this.formaPago = formaPago;
		this.email = email;
		this.telefono = telefono;
		this.evento = evento;
		this.usuario = usuario;
		this.servicio = servicio;
		this.estado = estado;
	}
	
	public Reserva() {
		
	}
	

}
