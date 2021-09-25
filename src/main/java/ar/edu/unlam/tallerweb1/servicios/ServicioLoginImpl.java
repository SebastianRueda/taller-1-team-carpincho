package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.Date;

// Implelemtacion del Servicio de usuarios, la anotacion @Service indica a Spring que esta clase es un componente que debe
// ser manejado por el framework, debe indicarse en applicationContext que busque en el paquete ar.edu.unlam.tallerweb1.servicios
// para encontrar esta clase.
// La anotacion @Transactional indica que se debe iniciar una transaccion de base de datos ante la invocacion de cada metodo del servicio,
// dicha transaccion esta asociada al transaction manager definido en el archivo spring-servlet.xml y el mismo asociado al session factory definido
// en hibernateCOntext.xml. De esta manera todos los metodos de cualquier dao invocados dentro de un servicio se ejecutan en la misma transaccion
@Service("servicioLogin")
@Transactional
public class ServicioLoginImpl implements ServicioLogin {

	private RepositorioUsuario repositorioUsuario;

	@Autowired
	public ServicioLoginImpl(RepositorioUsuario servicioLoginDao){
		this.repositorioUsuario = servicioLoginDao;
	}

	@Override
	public Usuario consultarUsuario (String email, String password) {
		return repositorioUsuario.buscarUsuario(email, password);
	}

	@Override
	public Usuario registrar(String email, String password) throws Exception{
		Usuario buscado = repositorioUsuario.buscar(email);
		if(buscado != null)
			throw new Exception();
		Usuario nuevo = new Usuario();
		nuevo.setEmail(email);
		nuevo.setPassword(password);
		Cuenta cuenta = new Cuenta();
		cuenta.setCreada(new Date());
		nuevo.setCuenta(cuenta);
		repositorioUsuario.guardar(nuevo);
		return nuevo;
	}

}
