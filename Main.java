import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import videolibrary.*;

public class Main {
    public static void main(String args[]) throws FileNotFoundException, ParseException {

        TopLevelDemo.teste();
        //inicializa arraylists
        ArrayList<Media> mediaList = new ArrayList<Media>();
        ArrayList<Person> personList = new ArrayList<Person>();

        //leitura dos arquivos de dados
        personList = IOManager.readPerson(personList);
        mediaList = IOManager.readMedia(mediaList, personList);

        //realiza uma copia de todos os episodios ou filmes na mediaList
        ArrayList<Media> copyMedia = new ArrayList<Media>();
        for(Media aux : mediaList){
            if(aux instanceof Movie){
                copyMedia.add(new Movie((Movie)aux));
            }
            else if(aux instanceof Serie){
                Serie auxSerie = (Serie)aux;
                for(int i = 0; i < auxSerie.getNSeasons(); i++){
                    for(int j = 0; j < auxSerie.getNEpisodesSeason(i); j++){
                        copyMedia.add(new Episode(auxSerie.GetEpisode(i, j)));
                    }
                } 
            }
        }

        //imprime os filmes ou episodios copiados anteriormente
        printCopy(copyMedia);

        //imprime dados lidos
        IOManager.printMedia(mediaList);
        IOManager.printPerson(personList);
    }

    private static void printCopy(ArrayList<Media> mediaList){
        for (Media aux : mediaList) {
            if (aux instanceof Movie) {
                System.out.println("Copied Movie Name: " + aux.GetName());
                if (aux.GetGenres() == null)
                    System.out.println("Copied Genre: Não foi passado nenhum gênero");
                else {
                    for (Util.genresEnum Genre : aux.GetGenres()) {
                        System.out.println("Copied Genre: " + Genre);
                    }
                }
                System.out.println("Copied Movie director: "+ ((Movie)aux).GetDirector().GetName());
                if(((Movie)aux).GetActors() != null){
                    for (int i = 0; i < ((Movie)aux).GetActors().size(); i++){
                        System.out.println("Copied Movie actor: "+ ((Movie)aux).GetActors().get(i).GetName());
                    }
                }
                else{   System.out.println("Copied Movie don't have actors assigned!");}
            } 
            else if (aux instanceof Episode) {
                System.out.println("Copied Episode Name: " + aux.GetName());
                if (aux.GetGenres() == null)
                    System.out.println("Copied Genre: Não foi passado nenhum gênero");
                else {
                    for (Util.genresEnum Genre : aux.GetGenres()) {
                        System.out.println("Copied Genre: " + Genre);
                    }
                }
                System.out.println("Copied Episode director: "+ ((Episode)aux).GetDirector().GetName());
                if(((Episode)aux).GetActors() != null){
                    for (int i = 0; i < ((Episode)aux).GetActors().size(); i++){
                        System.out.println("Copied Episode actor: "+ ((Episode)aux).GetActors().get(i).GetName());
                    }
                }
                else{   System.out.println("Copied Episode don't have actors assigned!");}
                
            } 
            else {
                System.out.println("INVALID INSTANCE");
            }
            System.out.println("");
        }
    }

}