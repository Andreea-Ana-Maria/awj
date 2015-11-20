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
public class ProdusController {
  private List<Produs> produse = new ArrayList<Produs>();

  ProdusController() {
    Produs pr1 = new Produs(1, "inghetata" ,"dulciuri", 10);
    Produs pr2 = new Produs(2, "suc" , "bauturi" , 5);
    Produs pr3 = new Produs(3, "portocala" , "fructe" , 5);
    Produs pr4 = new Produs(4, "mar" , "fructe" , 2);

    produse.add(pr1);
    produse.add(pr2);
    produse.add(pr3);
  }

  @RequestMapping(value="/produse", method = RequestMethod.GET)
  public List<Produs> index() {
    return this.produse;
  }

  @RequestMapping(value="/produse/{id}", method = RequestMethod.GET) 
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Produs prod : this.produse) {
      if(prod.getId() == id) {
        return new ResponseEntity<Produs>(prod, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/produse/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Produs prod : this.produse) {
      if(prod.getId() == id) {
        this.produse.remove(prod);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  
   //Update
  @RequestMapping(value="/produse/{id}/{denumire}/{tip}/{pret}", method = RequestMethod.PUT)
  public ResponseEntity update(@PathVariable("id") int id, @PathVariable("denumire") String denumireprod , @PathVariable("tip") String tipprodus , @PathVariable("pret") int pretprodus) {

      for(Produs prod : this.produse) {
      if(prod.getId() == id) {
          prod.setDenumire(denumireprod);
          prod.setTip(tipprodus);
          prod.setPret(pretprodus);
    return new ResponseEntity<Produs>(prod, new HttpHeaders(), HttpStatus.OK);
        }
      }
      return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
    
        
   }


  @RequestMapping(value="/produse/{denumire}/{tip}/{pret}", method = RequestMethod.POST)
  public ResponseEntity create(@PathVariable("denumire") String denumireprod , @PathVariable("tip") String tipprodus, @PathVariable("pret") int pretprodus) {
        Produs prodnew = new Produs(produse.size()+1, denumireprod, tipprodus, pretprodus);
       this.produse.add(prodnew);  
       return new ResponseEntity<Produs>(prodnew, new HttpHeaders(), HttpStatus.OK);

  }


}