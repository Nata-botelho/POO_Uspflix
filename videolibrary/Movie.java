package videolibrary;

import java.util.ArrayList;

/*-------------CONSTRUTOR------------*/

public class Movie extends Video {
    public Movie(String _name, Director _director, Util.ageRatingsEnum _agerating, ArrayList<Util.genresEnum> _genres, ArrayList<Actor> _actors){
        super(_name, _director, _agerating, _genres, _actors);

    }

    public Movie(Movie mov){
        super(mov);
    }
}