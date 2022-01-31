package videolibrary;

import java.util.ArrayList;

public class Episode extends Video {

    /*------------VARIAVEIS-------------*/

    private final int number;
    private final int season;

    /*-------------CONSTRUTOR------------*/

    public Episode(String _name, Director _director, Util.ageRatingsEnum _agerating, ArrayList<Util.genresEnum> _genres, ArrayList<Actor> _actors, int _number, int _season){
        super(_name, _director, _agerating, _genres, _actors);
        this.number = _number;
        this.season = _season;
    }

    //Construtor de copia
    public Episode(Episode epi){
        super(epi);
        number = epi.number;
        season = epi.season;
    }

    /*--------------GETTERS-------------*/
    
    public int GetNumber(){
        return this.number;
    }

    public int GetSeason(){
        return this.season;
    }
}