package videolibrary;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class Media {

    /*------------VARIAVEIS-------------*/

    private final String name;
    private final Util.ageRatingsEnum ageRating;
    private final ArrayList<Util.genresEnum> genres;
    private int year;
    private int nViews;
    private int nUserRatings;
    private float UserRating;

    /*-------------CONSTRUTOR------------*/

    public Media(String _name, Util.ageRatingsEnum _ageRating, ArrayList<Util.genresEnum> _genres){

        this.name = _name;
        this.ageRating = _ageRating;
        this.nViews = 0;
        this.nUserRatings = 0;
        this.UserRating = 0.0f;
        this.year = new GregorianCalendar().get(Calendar.YEAR);
        
        {
            if(_genres.size() <= 0 || _genres == null){
                System.out.println("Não foi adicionado nenhum genero");
                this.genres = null;
            }
            else{
                this.genres = new ArrayList<Util.genresEnum>();
                
                if(genres.size() > 3){
                    System.out.println("Foram passados mais de 3 generos!");
                }

                for (int i = 0; (i < 3) && (i < _genres.size()); ++i)
                    this.genres.add(_genres.get(i));
            }
        }
    }

    //Construtor de copia
    Media(Media med){
        name = med.name;
        ageRating = med.ageRating;
        genres = med.genres;
        year = med.year;
        nViews = med.nViews;
        UserRating = med.UserRating;
        nUserRatings = med.nUserRatings;
    }

    /*--------------GETTERS-------------*/

    public String GetName(){
        return name;
    }

    public Util.ageRatingsEnum GetAgeRating(){
        return ageRating;
    }

    public ArrayList<Util.genresEnum> GetGenres(){
        ArrayList<Util.genresEnum> genres_copy = (ArrayList<Util.genresEnum>) Util.CopyArray(this.genres);
        return genres_copy;
    }

    public int GetYear(){
        if(this.year == -1)
            System.out.println("Não foi atribuída uma duração para este filme!");

        return year;
    }

    public int GetnViews(){
        return nViews;
    }

    public int GetnUserRating(){
        return nUserRatings;
    }

    /*--------------SETTERS-------------*/
    
    public void SetYear(int _year){
        if(_year < 1878)
            System.out.println("Não existiam filmes antes de 1878!");
        else if(_year > new GregorianCalendar().get(Calendar.YEAR))
            System.out.println("O filme não pode ter data de lançamento maior que 1 ano a partir deste!");

        this.year = _year;
    }

    public void IncrementViews(){
        this.nViews++;
    }

    public void AddUserRating(float _userRating){
        this.nUserRatings++;

        UserRating += _userRating;
        UserRating = UserRating/nUserRatings;
    }
}