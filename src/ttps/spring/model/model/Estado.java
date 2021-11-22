package ttps.spring.model.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estados")
public class Estado implements java.io.Serializable{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@Id @GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="id_estado")
		private Long id;
		@Column
		private String nombre;
		@Column
		private Boolean activo = true;
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
		@Override
		public String toString() {
			return "Estado [id=" + id + ", nombre=" + nombre + ", activado=" + activo + "]";
		}
		public Estado(Long id, String nombre, Boolean activo) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.activo = activo;
		}
		public Estado(String nombre) {
			this.nombre=nombre;
		}
		public Estado() {
			
		}

		
		
		
}


