package co.udea.proyecto.api.service.impl;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import co.udea.proyecto.api.service.ProyectoService;
import co.udea.proyecto.api.model.Proyecto;
import co.udea.proyecto.api.repository.ProyectoRepository;



@Service
public class ProyectoServiceImpl implements ProyectoService {
	
	private final ProyectoRepository proyectoRepository;

	public ProyectoServiceImpl(ProyectoRepository proyectoRepository) {
		this.proyectoRepository = proyectoRepository;
	}
	
	@Override
	public List<Proyecto> getProyectos(){
		List<Proyecto> proyectos= proyectoRepository.findAll();
		return proyectos;
	}
	
	@Override
	public List<Proyecto> searchProyectos2(String estado) {
		List<Proyecto>  proyectosActivos= proyectoRepository.findAllByIdEstado(estado);
		
		return proyectosActivos;
	}
	
	@Override
	public Proyecto searchProyectos(String estado) {
		Optional<Proyecto> proyectosActivos= proyectoRepository.findByIdEstado(estado);
		
		return proyectosActivos.get();
	}
	
	@Override
	public Proyecto addProyectos(Proyecto proyecto) {
		return proyectoRepository.save(proyecto);
	}
	
	@Override
	public Proyecto updateProyecto(Proyecto newProyecto) {
		return proyectoRepository.save(newProyecto);
	}
	
	@Override
	public Proyecto proyectoActualizar(Integer radicado) {
		Optional<Proyecto> proyecto= proyectoRepository.findByRadicado(radicado);
		
		return proyecto.get();
	}
	
	@Override
	public Proyecto getProyecto(Integer radicado) {
		Optional<Proyecto> proyecto= proyectoRepository.findByRadicado(radicado);
		
		return proyecto.get();
	}
	
	@Override
	public void deleteProyecto(Proyecto proyecto) {
		proyectoRepository.delete(proyecto);
	}
}
