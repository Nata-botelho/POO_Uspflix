package videolibrary;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class IOManager {

    // leitura dos dados de pessoas (diretores e atores)
    public static ArrayList<Person> readPerson(ArrayList<Person> personList)
            throws FileNotFoundException, ParseException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(Util.PERSONFILE));
        System.setIn(in);

        // inicializa scanner
        Scanner scnr = new Scanner(System.in);

        // auxiliares
        Person auxPerson;
        String auxName, auxCountry, auxBirth;
        int personRole;

        do {
            personRole = Integer.parseInt(scnr.nextLine());
            auxName = scnr.nextLine();
            auxCountry = scnr.nextLine();
            auxBirth = scnr.nextLine();

            if (personRole == 1) // checa se e diretor ou ator
                auxPerson = new Director(auxName, auxCountry, auxBirth);
            else
                auxPerson = new Actor(auxName, auxCountry, auxBirth);

            personList.add(auxPerson);
        } while (scnr.hasNextLine());

        scnr.close();

        return personList;
    }

    private static void readMovie(ArrayList<Media> mediaList, ArrayList<Person> personList, Scanner scnr) {
        // auxiliares
        Movie auxMovie;
        Director auxDirector;
        Util.ageRatingsEnum auxAgeRating;
        ArrayList<Util.genresEnum> auxGenreList;
        ArrayList<Actor> auxActorList;
        String auxName;
        int auxNItems, directorIndex, actorIndex;

        auxName = scnr.nextLine();

        directorIndex = Integer.parseInt(scnr.nextLine());
        auxDirector = (Director) personList.get(directorIndex);

        auxAgeRating = (Util.ageRatingsEnum.valueOf(scnr.nextLine()));
        auxNItems = Integer.parseInt(scnr.nextLine());

        auxGenreList = new ArrayList<>();

        if (auxNItems > 0) {
            for (int i = 0; i < auxNItems; ++i) {
                auxGenreList.add(Util.genresEnum.valueOf(scnr.nextLine()));
            }
        }

        auxNItems = Integer.parseInt(scnr.nextLine());
        auxActorList = new ArrayList<Actor>();

        if (auxNItems > 0) {
            for (int i = 0; i < auxNItems; ++i) {
                actorIndex = Integer.parseInt(scnr.nextLine());
                auxActorList.add((Actor) personList.get(actorIndex));
            }
        }
        else{
            auxActorList = null;
        }

        auxMovie = new Movie(auxName, auxDirector, auxAgeRating, auxGenreList, auxActorList);

        mediaList.add(auxMovie);
    }

    private static void readSerie(ArrayList<Media> mediaList, ArrayList<Person> personList, Scanner scnr) {
        // auxiliares
        Serie auxSerie;
        Director auxDirector;
        Episode auxEpisode;
        Util.ageRatingsEnum auxAgeRating;
        ArrayList<Util.genresEnum> auxGenreList;
        ArrayList<Actor> auxActorList;
        String auxName, auxEpiName;
        int auxNItems, auxNEpisodes, auxNActors, directorIndex, actorIndex;

        auxName = scnr.nextLine();

        auxAgeRating = (Util.ageRatingsEnum.valueOf(scnr.nextLine()));
        auxNItems = Integer.parseInt(scnr.nextLine());

        auxGenreList = new ArrayList<>();
        if (auxNItems > 0) {
            for (int i = 0; i < auxNItems; ++i)
                auxGenreList.add(Util.genresEnum.valueOf(scnr.nextLine()));
        }

        auxSerie = new Serie(auxName, auxAgeRating, auxGenreList);
        auxNItems = Integer.parseInt(scnr.nextLine());
        auxActorList = new ArrayList<>();

        for (int i = 0; i < auxNItems; i++) {
            auxNEpisodes = Integer.parseInt(scnr.nextLine());

            for (int j = 0; j < auxNEpisodes; j++) {
                auxEpiName = scnr.nextLine();
                directorIndex = Integer.parseInt(scnr.nextLine());
                auxDirector = (Director) personList.get(directorIndex);
                auxNActors = Integer.parseInt(scnr.nextLine());

                if (auxNActors >= 0) {
                    auxActorList = new ArrayList<Actor>();

                    for (int k = 0; k < auxNActors; k++) {
                        actorIndex = Integer.parseInt(scnr.nextLine());
                        auxActorList.add((Actor) personList.get(actorIndex));
                    }
                }

                // incializa novo episodio e adiciona ele na temporada
                auxEpisode = new Episode(auxEpiName, auxDirector, auxAgeRating, auxGenreList, auxActorList, j, i);
                auxSerie.AddEpisode(auxEpisode, i);
            }
        }

        mediaList.add(auxSerie);
    }

    // leitura dos dados de Midias (midia ou serie)
    public static ArrayList<Media> readMedia(ArrayList<Media> mediaList, ArrayList<Person> personList)
            throws FileNotFoundException, ParseException {
        int mediaClass;

        BufferedInputStream in = new BufferedInputStream(new FileInputStream(Util.MEDIAFILE));
        System.setIn(in);

        Scanner scnr = new Scanner(System.in);

        do {
            mediaClass = Integer.parseInt(scnr.nextLine());

            if (mediaClass == 1) {
                readMovie(mediaList, personList, scnr);
            } else if (mediaClass == 2) {
                readSerie(mediaList, personList, scnr);
            } else {
                System.out.println("INVALID MEDIA CLASS");
            }
        } while (scnr.hasNextLine() && (mediaClass == 1 || mediaClass == 2));

        scnr.close();

        return mediaList;
    }

    // imprime lista de pessoas
    public static void printPerson(ArrayList<Person> personList) {
        for (Person aux : personList) {
            if (aux instanceof Director) {
                System.out.println("Director Name: " + aux.GetName());
                System.out.println("Director Country: " + aux.GetCountry());
                System.out.println("Director Birthdate: " + aux.GetBirthday());
                System.out.println("Director Age: " + aux.GetAge());
                System.out.println("");
            } else if (aux instanceof Actor) {
                System.out.println("Actor Name: " + aux.GetName());
                System.out.println("Actor Country: " + aux.GetCountry());
                System.out.println("Actor Birthdate: " + aux.GetBirthday());
                System.out.println("Actor Age: " + aux.GetAge());
                System.out.println("");
            }
        }
    }

    // imprime lista de midias
    public static void printMedia(ArrayList<Media> mediaList) {
        for (Media aux : mediaList) {
            if (aux instanceof Movie) {
                System.out.println("Movie Name: " + aux.GetName());
                System.out.println("Movie Age Rating: " + aux.GetAgeRating());
                if (aux.GetGenres() == null)
                    System.out.println("Genre: Não foi passado nenhum gênero");
                else {
                    for (Util.genresEnum Genre : aux.GetGenres()) {
                        System.out.println("Genre: " + Genre);
                    }
                }
            } else if (aux instanceof Serie) {
                System.out.println("Serie Name: " + aux.GetName());
                System.out.println("Serie Age Rating: " + aux.GetAgeRating());
                if (aux.GetGenres() == null)
                    System.out.println("Genre: Não foi passado nenhum gênero");
                else {
                    for (Util.genresEnum Genre : aux.GetGenres()) {
                        System.out.println("Genre: " + Genre);
                    }
                }
                System.out.println("Number of Seasons: " + ((Serie) aux).getNSeasons());
                for (int i = 0; i < ((Serie) aux).getNSeasons(); i++) {
                    System.out.println(
                            "Number of Episodes of Season " + (i + 1) + ": " + ((Serie) aux).getNEpisodesSeason(i));
                }
            } else {
                System.out.println("INVALID INSTANCE");
            }
            System.out.println("");
        }
    }
}