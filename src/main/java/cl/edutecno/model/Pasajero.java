package cl.edutecno.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "SQ_PASAJERO", initialValue = 1, allocationSize = 1)
public class Pasajero {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PASAJERO")
	private Integer id;
	private String rut;
	private String nombre;
	private String apellido;
	private Integer edad;
	private String ciudadNatal;
	
	@OneToMany(cascade=CascadeType.ALL, targetEntity=Destino.class)
	@JoinColumn(name="id")
	private List<Destino> destino;

	

}
