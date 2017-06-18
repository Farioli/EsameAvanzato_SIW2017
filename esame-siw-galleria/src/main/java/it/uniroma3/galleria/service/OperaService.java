package it.uniroma3.galleria.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.galleria.model.Opera;
import it.uniroma3.galleria.repository.OperaRepository;

@Service
@Transactional
public class OperaService {

	@Autowired
	private OperaRepository operaRepository;
	
	public void save(Opera opera){
		operaRepository.save(opera);
	}
	
	public void delete(long id){
		operaRepository.delete(id);
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
	
	public List<Opera> findByAnno(int anno){
		return operaRepository.findByAnno(anno);
	}
}
