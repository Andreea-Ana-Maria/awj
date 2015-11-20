package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;


@RestController
public class AngajatController {
  private List<Angajat> angajati = new ArrayList<Angajat>();

  AngajatController() {
    Angajat a1 = new Angajat(1, "Tudose" , "Maria" , 1);
    Angajat a2 = new Angajat(2, "Marcu" , "Alin" , 2);
    Angajat a3 = new Angajat(3, "Mihalcea" , "Simona", 1);
    Angajat a4 = new Angajat(4, "Ilinca" , "Marius", 2);

    angajati.add(a1);
    angajati.add(a2);
    angajati.add(a3);
  }

  @RequestMapping(value="/angajati", method = RequestMethod.GET)
  public List<Angajat> index() {
    return this.angajati;
  }

  @RequestMapping(value="/angajati/{id}", method = RequestMethod.GET) 
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Angajat a : this.angajati) {
      if(a.getId() == id) {
        return new ResponseEntity<Angajat>(a, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/angajati/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Angajat a : this.angajati) {
      if(a.getId() == id) {
        this.angajati.remove(a);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  
   //Update
  @RequestMapping(value="/angajati/{id}/{nume}/{prenume}/{iddepartament}", method = RequestMethod.PUT)
  public ResponseEntity update(@PathVariable("id") int id, @PathVariable("nume") String name , @PathVariable("prenume") String prenume , @PathVariable("iddepartament") int iddep) {

      for(Angajat a : this.angajati) {
      if(a.getId() == id) {
           a.setNume(name);
           a.setPrenume(prenume);
           a.setIdDep(iddep);
    return new ResponseEntity<Angajat>(a, new HttpHeaders(), HttpStatus.OK);
        }
      }
      return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
    
        
   }


  @RequestMapping(value="/angajati/{nume}/{prenume}/{iddepartament}", method = RequestMethod.POST)
  public ResponseEntity create(@PathVariable("nume") String name, @PathVariable("prenume") String prenume, @PathVariable("iddepartament") int iddep) {
     Angajat anew = new Angajat(angajati.size()+1, name , prenume , iddep);
       this.angajati.add(anew);  
       return new ResponseEntity<Angajat>(anew, new HttpHeaders(), HttpStatus.OK);

  }

}