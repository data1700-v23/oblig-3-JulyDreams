package oslomet.webprog.sql1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
@Repository
public class BiletterRepository {
    @Autowired //autowired det betyr at det er spring som gjør 'new' på den slik at db er tilgjengelig for oss i denne klassen
    private JdbcTemplate db; // er en klasse

    //under har vi tre metoder
    public void lagreBilett(Biletter innBilett){
        String sql = "INSERT INTO Biletter (velgfilm, antall, fornavn, etternavn, telefonnr, epost) VALUES (?,?,?,?,?,?)";
        db.update(sql, innBilett.getVelgfilm(), innBilett.getAntall(), innBilett.getFornavn(), innBilett.getEtternavn(), innBilett.getTelefonnr(), innBilett.getEpost()); //utfører server kallet, først sql også parameterne
    //første argument er sql spørringen også de andre argumentene lister vi opp verdiene som skal erstattes i sql spørringen.
    }
    public List<Biletter> hentAlleBiletter(){
        String sql= "SELECT * FROM Biletter"; //er det sånn jeg kan sortere på etternavn????
        List<Biletter> alleBiletter = db.query(sql, new BeanPropertyRowMapper(Biletter.class)); //vi tar altså new på denne klassen og dette blir et objekt som vi kan kalle med biletter3 definisjonen
        //det den gjør er at den mapper kolonnene i tabellen til den klassen Biletter3. Det betyr at kolonnene i tabellen må hete det samme som biletter3 attributtene
        Collections.sort(alleBiletter);
    return alleBiletter;
    }
    public void slettAlleBiletter(){
        String sql = "DELETE FROM Biletter";
        db.update(sql);
    }
}
