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
public class StudentController {
  private List<Student> studenti = new ArrayList<Student>();

  StudentController() {
    Student s1 = new Student(1, "Popescu" , "Stefan", 2);
    Student s2 = new Student(2, "Ionescu","George", 3);
    Student s3 = new Student(3, "Gheorghe" , "Laura", 1);
    Student s4 = new Student(4, "Marin" ,"Andrei", 3);

    studenti.add(s1);
    studenti.add(s2);
    studenti.add(s3);
  }

  @RequestMapping(value="/studenti", method = RequestMethod.GET)
  public List<Student> index() {
    return this.studenti;
  }

  @RequestMapping(value="/studenti/{id}", method = RequestMethod.GET) 
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Student s : this.studenti) {
      if(s.getId() == id) {
        return new ResponseEntity<Student>(s, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/studenti/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Student s : this.studenti) {
      if(s.getId() == id) {
        this.studenti.remove(s);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  
  //Update
  @RequestMapping(value="/studenti/{id}/{nume}/{prenume}/{anstudiu}", method = RequestMethod.PUT)
  public ResponseEntity update(@PathVariable("id") int id, @PathVariable("nume") String name, @PathVariable("prenume") String firstname,@PathVariable("anstudiu") int year) {
      for(Student s : this.studenti) {
        if(s.getId() == id) {
           s.setNume(name);
           s.setPrenume(firstname);
           s.setAn(year);
           return new ResponseEntity<Student>(s, new HttpHeaders(), HttpStatus.OK);
        }
      }
      return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
    
        
   }


  @RequestMapping(value="/studenti/{nume}/{prenume}/{anstudiu}", method = RequestMethod.POST)
  public ResponseEntity create(@PathVariable("nume") String name, @PathVariable("prenume") String firstname,@PathVariable("anstudiu") int year) {
        Student snew = new Student(studenti.size()+1, name, firstname, year);
       this.studenti.add(snew);  
       return new ResponseEntity<Student>(snew, new HttpHeaders(), HttpStatus.OK);

  }


}