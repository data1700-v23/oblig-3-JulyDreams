function regBilett(){
    let velgfilm = $("#velgfilm").val();
    let antall = $("#antall").val();
    let fornavn = $("#fornavn").val();
    let etternavn = $("#etternavn").val();
    let telefonnr = $("#telefonnr").val();
    let epost = $("#epost").val();

    const bilett = {
        velgfilm : velgfilm,
        antall : antall,
        fornavn : fornavn,
        etternavn : etternavn,
        telefonnr : telefonnr,
        epost : epost
    };
    $("#velgfilm").val("Velg film her");
    $("#antall").val("");
    $("#fornavn").val("");
    $("#etternavn").val("");
    $("#telefonnr").val("");
    $("#epost").val("");

    let feil = "Må skrive noe inn i ";
    let teller = 0;

    if (velgfilm =="Velg film her"){
        teller++;
        $("#feilVelgFilm").html("Du må velge en film.");
    }else{
        $("#feilVelgFilm").html("");//nullstiller span
    }
    if (isNaN(antall) || antall === "") {
        teller++;
        $("#feilAntall").html("Antall må være et tall");
    }else{
        $("#feilAntall").html("");
    }
    if (!fornavn){
        teller++;
        $("#feilFornavn").html(feil+"fornavn.");
    }else{
        $("#feilFornavn").html("");
    }
    if (!etternavn){
        teller++;
        $("#feilEtternavn").html(feil+"etternavn.");
    }else{
        $("#feilEtternavn").html("");
    }
    if (telefonnr.length!=8 || !telefonnr){
        teller++;
        $("#feilTelefonnr").html("Telefonnummer må ha 8 siffer");
    }else{
        $("#feilTelefonnr").html("");
    }
    if (!epost){
        teller++;
        $("#feilEpost").html(feil+"epost.");
    }else{
        $("#feilEpost").html("");
    }

    if(teller == 0) {
        $.get("/lagre", bilett, function () { //bilett blir gjort om til json
            hentAlle(); //for å kjøre denne trengs function() nested
        });
    }

}

function hentAlle(){ //funksjonen kaller server metoden /hentAlle
    $.post("/hentAlle", function (data){ //varibelen data mottar data fra server
        formaterData(data); //kaller på funksjonen formaterData()
    });

}
//funksjonen under er laget for å ikke ha for mye kode inne i selve ajax-kallet.
function formaterData(biletter){ //er laget for å lettere lese koden, biletter variabelen skal inneholde listen av bilett-objekter fra serveren mottatt fra kallet /hentAlle
    let ut = "<table class='table'><tr>" +  //vi har variabelen ut for å bygge en streng som formaterer en tabell.
        "<th>Film</th><th>Antall</th><th>Fornavn</th>" +
        "<th>Etternavn</th><th>Telefonnr</th><th>Epost</th>"+
        "</tr>";
    for (const i of biletter){
        ut+="<tr>";
        ut+="<td>"+i.velgfilm+"</td>"+"<td>"+i.antall+"</td><td>"+i.fornavn+"</td><td>"+
            i.etternavn+"</td><td>"+i.telefonnr+"</td><td>"+i.epost+"</td>";
        ut+="</tr>";
    }
    $("#alleBillettene").html(ut);
}
function slettAlt(){
    $.get("/slettAlt", function(data){
        hentAlle();
    });
}