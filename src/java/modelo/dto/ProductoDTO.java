/* Implementación de los DTO, este paso consiste en mapear toda la base de datos realizando un DTO por cada tabla que
se encuentra en la base de datos y creando los respectivos constructores necesarios, los get y set para acceder a los
atributos privados y otros método como el equals y toString. */
package modelo.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author USER
 */
public class ProductoDTO implements Serializable{
    private int id;
    private String nombre, descripcion;
    private int unidades, valor;

    public ProductoDTO(int id, String nombre, String descripcion, int unidades, int valor) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.unidades = unidades;
        this.valor = valor;
    }

    public ProductoDTO(String nombre, String descripcion, int unidades, int valor) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.unidades = unidades;
        this.valor = valor;
    }

    public ProductoDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return this.id + " - " + this.nombre + " - " + this.descripcion + " - " + this.unidades + " - " + this.valor;
    }

    @Override
	public boolean equals(Object ob) {
		if (this == ob)
			return true;

		if (ob == null)
			return false;

		if (getClass() != ob.getClass())
			return false;

		final ProductoDTO other = (ProductoDTO) ob;
		if (this.id != other.id)
			return false;

		if (this.unidades != other.unidades)
			return false;

		if (this.valor != other.valor)
			return false;

		if (!Objects.equals(this.nombre, other.nombre))
			return false;

		if (!Objects.equals(this.descripcion, other.descripcion))
			return false;

		return true;

	}
    

    
}
