package org.sid.web;

import java.util.List;

import org.sid.dao.ContactRepository;
import org.sid.entities.Contacts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class ContactRestService {
	//inversion de control avec Spring
	@Autowired
	private ContactRepository contactRepository;
	
	//----------  Methode Search all-------------
	@RequestMapping(value="/contacts",method=RequestMethod.GET)
	public List<Contacts> getContcats(){
		return contactRepository.findAll();
	}
	//----------  Methode Search by id -------------
	@RequestMapping(value="/contacts/{id}",method=RequestMethod.GET)
	public Contacts getContcat(@PathVariable Long id){
		return contactRepository.findOne(id);
	}
	//----------  Methode Search by mot clé -------------
		@RequestMapping(value="/chercheContact",method=RequestMethod.GET)
		public Page<Contacts> chercher(
				@RequestParam(name="mc",defaultValue="") String mc,
				@RequestParam(name="page",defaultValue="0") int page,
				@RequestParam(name="size",defaultValue="5") int size){
			return contactRepository.chercher("%"+mc+"%", new PageRequest(page, size)); 
			
		}
	//----------  Methode Save -------------
	@RequestMapping(value="/contacts",method=RequestMethod.POST)
	public Contacts save(@RequestBody Contacts c){
		return contactRepository.save(c);
	}
	//----------  Methode Delete -------------
	@RequestMapping(value="/contacts/{id}",method=RequestMethod.DELETE)
	public Boolean delete(@PathVariable Long id){
		contactRepository.delete(id);
		return true;
	}
	//----------  Methode Update -------------
	@RequestMapping(value="/contacts/{id}",method=RequestMethod.PUT)
	public Boolean update(@PathVariable Long id,@RequestBody Contacts c){
		c.setId(id);
		contactRepository.save(c);
		return true;
	}
}
