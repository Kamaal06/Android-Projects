package trial.of.storeret;

public class addition {

    String  artistID;
    String artName;
    String artGenre;

    public addition(){

    }

    public addition(String artistID, String artName, String artGenre) {
        this.artistID = artistID;
        this.artName = artName;
        this.artGenre = artGenre;
    }

    public String getArtistID() {
        return artistID;
    }

    public String getArtName() {
        return artName;
    }

    public String getArtGenre() {
        return artGenre;
    }
}
