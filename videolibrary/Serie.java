package videolibrary;

import java.util.ArrayList;

public class Serie extends Media{

    /*------------VARIAVEIS-------------*/

    private ArrayList<ArrayList<Episode>> seasons;

    /*------------CONSTRUTOR-------------*/

    public Serie(String _name, Util.ageRatingsEnum _agerating, ArrayList<Util.genresEnum> _genres){
        
        super(_name, _agerating, _genres);
        
        this.seasons = new ArrayList<ArrayList<Episode>>();
    }

    /*--------------GETTERS-------------*/
    public ArrayList<ArrayList<Episode>> GetAllSeasons(){
        ArrayList<ArrayList<Episode>> copy_all_seasons = (ArrayList<ArrayList<Episode>>) Util.CopyArray(this.seasons);
        return copy_all_seasons;
    }

    public ArrayList<Episode> GetSeason(int season){
        ArrayList<Episode> copy_season = (ArrayList<Episode>) Util.CopyArray(this.seasons.get(season));
        return copy_season;
    }

    public Episode GetEpisode(int season, int epiIndex){
        Episode episode = seasons.get(season).get(epiIndex);
        return episode;
    }

    public int getNSeasons(){
        return this.seasons.size();
    }

    public int getNEpisodesSeason(int _season){
        return this.seasons.get(_season).size();
    }

    /*--------------SETTERS-------------*/
    public void IncrementViews(int episode, int season){

        IncrementViews();
        this.seasons.get(season).get(episode).IncrementViews();
    }

    public void AddUserRating(float _userRating, int episode, int season){

        AddUserRating(_userRating);
        this.seasons.get(season).get(episode).AddUserRating(_userRating);
    }

    public void AddEpisode(Episode episode, int season){

        if(this.seasons.size() < season+1){
            ArrayList<Episode> new_season = new ArrayList<Episode>();
            this.seasons.add(new_season);
        }
        this.seasons.get(season).add(episode);
    }

    public void AddSeason(ArrayList<Episode> _season){
        this.seasons.add(_season);
    }
}