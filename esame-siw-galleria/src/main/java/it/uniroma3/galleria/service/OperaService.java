package it.uniroma3.galleria.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import it.uniroma3.galleria.model.Opera;
import it.uniroma3.galleria.repository.OperaRepository;

@Service
@Transactional
public class OperaService {

	@Autowired
	private OperaRepository operaRepository;
	
	@PreAuthorize("hasRole('RUOLO_AMMINISTRATORE')")
	public void save(Opera opera){
		operaRepository.save(opera);
	}
	
	@PreAuthorize("hasRole('RUOLO_AMMINISTRATORE')")
	public void delete(long id){
		operaRepository.delete(id);
	}
	
	@PreAuthorize("hasRole('RUOLO_AMMINISTRATORE')")
	public void delete(Opera opera) {
		operaRepository.delete(opera);
		
	}
	
	public List<Opera> findAll(){
		return operaRepository.findAll();
	}
	
	public Opera findOne(long id){
		return operaRepository.findOne(id);
	}
	
	public Opera findByTitolo(String titolo){
		return operaRepository.findByTitolo(titolo);
	}
	
	public List<Opera> findByAnno(String dataAnno){
		Integer anno = Integer.parseInt(dataAnno);
		return operaRepository.findByAnno(anno);
	}

}
