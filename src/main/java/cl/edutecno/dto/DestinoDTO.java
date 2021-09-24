package cl.edutecno.dto;

import java.util.List;

import cl.edutecno.model.Destino;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DestinoDTO extends GenericDTO{

	public List<Destino>destinos;

	public DestinoDTO(List<Destino>destinos,String mensaje, String codigo) {
		super(mensaje, codigo);
		this.destinos=destinos;
	}
	
}
