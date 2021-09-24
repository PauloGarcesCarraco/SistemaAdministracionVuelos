package cl.edutecno.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "SQ_DESTINO", initialValue = 1, allocationSize = 1)
public class Destino {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DESTINO")
	private Integer id;
	private String ciudad;
	private String pais;
	private String fecha;
	
	@ManyToOne
	@JoinColumn(name="pasajero_id", referencedColumnName = "id")
	private Pasajero pasajero;
	

}
