package rva.ctrls;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import rva.jpa.Proizvod;
import rva.jpa.Proizvodjac;
import rva.jpa.Racun;
import rva.repository.ProizvodRepository;
import rva.repository.ProizvodjacRepository;

@CrossOrigin 
@RestController
@Api(tags = {"Proizvodjac CRUD operacije"})
public class ProizvodjacRestController {

	@Autowired
	private ProizvodjacRepository proizvodjacRepository;
	private ProizvodRepository proizvodRepository;
	
	//dodatak za sql naredbe u sts
	@Autowired 
	private JdbcTemplate jdbcTemplate;
	
	//svi
	
	
	@GetMapping("proizvodjac")
	public Collection<Proizvodjac> getProizvodjaci(){
		return proizvodjacRepository.findAll();
	};
	
	//jedan
	
	@GetMapping("proizvodjac/{id}")
	public Proizvodjac getProizvodjaci(@PathVariable ("id") Integer id) {
		return proizvodjacRepository.getOne(id);
	}
	
	@GetMapping("proizvodjacNaziv/{naziv}")
	public Collection<Proizvodjac> getProizvodjacByNaziv(@PathVariable("naziv") String naziv) {
		return proizvodjacRepository.findByNazivContainingIgnoreCase(naziv);
	}
	
	
	/*@GetMapping("racunNacinPlacanja/{NacinPlacanja}")
	public Collection<Racun> getracunByNacinplacanja(@PathVariable("NacinPlacanja") String NacinPlacanja) {
		return racunRepository.findByNacinPlacanjaContainingIgnoreCase(NacinPlacanja);
	}*/
	
	
	@PostMapping("proizvodjac")
	public ResponseEntity<Proizvodjac> insertProizvodjac(@RequestBody Proizvodjac proizvodjac){
		if(!proizvodjacRepository.existsById(proizvodjac.getId())) {
			proizvodjacRepository.save(proizvodjac);
			return new ResponseEntity<Proizvodjac>(HttpStatus.OK);
		}
		return new ResponseEntity<Proizvodjac>(HttpStatus.CONFLICT);
	}
	
	@PutMapping("proizvodjac")
	public ResponseEntity<Proizvodjac> updateProizvod(@RequestBody Proizvodjac proizvodjac) {
		if (!proizvodjacRepository.existsById(proizvodjac.getId())) {
		return new ResponseEntity<Proizvodjac>(HttpStatus.NO_CONTENT);
		}
		proizvodjacRepository.save(proizvodjac);
		return new ResponseEntity<Proizvodjac>(HttpStatus.OK);
		}	

	//brisanje
	
	@Transactional
	@DeleteMapping("proizvodjac/{id}")
	public ResponseEntity<Proizvodjac> deleteProizvod(@PathVariable("id") Integer id){
		if (!proizvodjacRepository.existsById(id))
			return new ResponseEntity<Proizvodjac>(HttpStatus.NO_CONTENT);
		jdbcTemplate.execute("DELETE FROM proizvod WHERE proizvodjac=" + id);
		proizvodjacRepository.deleteById(id);
		if (id == -100)
			jdbcTemplate.execute("INSERT INTO \"proizvodjac\" (\"id\", \"naziv\", \"adresa\", \"kontakt\")"
					+ "VALUES (-100, 'Test naziv', 'Test Adresa', 'Test kontakt')");
		return new ResponseEntity<Proizvodjac>(HttpStatus.OK);
	}
}
	
