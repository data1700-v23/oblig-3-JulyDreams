package oslomet.webprog.sql1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BiletterController {
    @Autowired
    BiletterRepository rep; //slik får vi tak i biletter repository klassen

    @GetMapping("/lagre")
    public void lagreBilett(Biletter innBilett){
        rep.lagreBilett(innBilett);
    }
    @PostMapping("/hentAlle")
    public List<Biletter> hentAlle(){
        return rep.hentAlleBiletter();
    }
    @GetMapping("/slettAlt")
    public void slettAlt(){
        rep.slettAlleBiletter();
    }
}