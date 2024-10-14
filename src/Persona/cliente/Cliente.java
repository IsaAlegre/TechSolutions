package Persona.cliente;

import Persona.Persona;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {
    private String direccion;

    // Lista estática para almacenar los clientes
    public static List<Cliente> clientes = new ArrayList<>();

    public Cliente(String nombre, String apellido, String dni, String id, String fechaNacimiento, String direccion) {
        super(nombre, apellido, dni, id, fechaNacimiento);
        this.direccion = direccion;

        // Verificar si el cliente ya existe antes de agregarlo
        boolean clienteExistente = clientes.stream()
                .anyMatch(c -> c.getId().equals(id));

        if (!clienteExistente) {
            clientes.add(this);
        } else {
            System.out.println("El cliente con ID " + id + " ya está registrado.");
        }
    }

    // Getter y Setter
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }



    // Método para listar todos los clientes
    public static void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            System.out.println("===== Lista de Clientes Registrados =====");
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }
    }
}
