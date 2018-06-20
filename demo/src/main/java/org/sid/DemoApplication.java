package org.sid;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.sid.dao.ContactRepository;
import org.sid.entities.Contacts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private ContactRepository contactRepository;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Override
	public void run(String... arg0) throws Exception {
		DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
		contactRepository.save(new Contacts("Yassine","Bouhamed",df.parse("29/02/1992"),"yassine@gmail.com",20250500,"Yassine.png"));
		contactRepository.save(new Contacts("Mahdi","Bouhamed",df.parse("15/01/1988"),"mahdi@gmail.com",20250500,"Mahdi.png"));
		contactRepository.save(new Contacts("Manel","Bouhamed",df.parse("18/06/1984"),"manel@gmail.com",20250500,"Manel.png"));
		contactRepository.findAll().forEach(c->{
		System.out.println(c.getNom());
		});;
	}
}
