package videolibrary;

import java.text.ParseException;
import java.util.ArrayList;

public abstract class Video extends Media {
    /*------------VARIAVEIS-------------*/

    private static int counter = 0;
    private final Director director;
    private final int id;
    private final ArrayList<Actor> actors;
    private int lenght;

    /*-------------CONSTRUTOR------------*/

    public Video(String _name, Director _director, Util.ageRatingsEnum _agerating, ArrayList<Util.genresEnum> _genres,
            ArrayList<Actor> _actors) {
        super(_name, _agerating, _genres);
        this.director = _director;
        this.id = counter++;
        this.lenght = -1;

        {
            if (_actors == null || _actors.size() <= 0) {
                this.actors = null;
            } else {
                this.actors = new ArrayList<Actor>();

                if (_actors.size() > 3)
                    System.out.println("Foram passados mais de 3 atores!");

                for (int i = 0; (i < 3) && (i < _actors.size()); ++i)
                    this.actors.add(_actors.get(i));
            }
        }
    }

    //Construtor de copia
    Video (Video vid){
        super(vid);
        director = vid.director;
        actors = vid.actors;
        id = vid.id;
        lenght = vid.lenght;
    }
    /*--------------GETTERS-------------*/

    public Director GetDirector() {
        return director;
    }

    public int GetID() {
        return this.id;
    }

    public int GetLength() {
        return lenght;
    }

    public ArrayList<Actor> GetActors() {
        ArrayList<Actor> copy_actors = (ArrayList<Actor>) Util.CopyArray(this.actors);
        return copy_actors;
    }

    /*--------------SETTERS-------------*/

    public void SetLength(int _length) {
        this.lenght = _length;
    }

    public void AddActor(String _name, String _country, String _birthday) throws ParseException {
        Actor newActor = new Actor(_name, _country, _birthday);
        actors.add(newActor);
    }
}