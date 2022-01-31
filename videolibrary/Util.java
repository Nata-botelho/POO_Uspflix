package videolibrary;

import java.util.ArrayList;

public class Util
{
    /**
     * Como o rating de idade imprime uma descrição, faz mais sentido criarmos um método que retorna sua descrição ao invés de sobrescrevermos
     * seu método "toString", como abaixo em gênero.
     * Portanto, criamos uma String para conter a descrição e seu construtor para recebê-la. Assim como para cada variável do enum, já a declaramos chamando o construtor,
     * passando sua descrição.
     * O método getRatingDescription retorna a descrição de cada enum.
     * Assim, temos um método "limpo" que limita o usuário a colocar uma das das opções possíveis.
     * @author leotp
     */

    public static final String PERSONFILE = "person.in";
    public static final String MEDIAFILE = "media.in";

    public enum ageRatingsEnum {
        LIVRE("Livre Para Todos Os Públicos"), DEZ ("Não Recomendado Para Menores de Dez Anos"), DOZE ("Não Recomendado Para Menores de Catorze Anos"),
            CATORZE ("Não Recomendado Para Menores de Catorze Anos"), DEZESSEIS ("Não Recomendado Para Menores de Dezesseis Anos"),
            DEZOITO ("Não Recomendado Para Menores de Dezoito Anos");

        private String desc;

        ageRatingsEnum(String desc)
        {
            this.desc = desc;
        }

        public String getRatingDescription()
        {
            return desc;
        }
    }

    /**
     * Como os gêneros precisam apenas de seus nomes, não precisamos criar um método para devolver uma string de descrição como acima com os ratings de idade.
     * Podemos modificar (sobrescrever) o método toString, que originalmente retornaria a string com o nome da variável do enum, para sua versão gramaticalmente correta.
     * @author leotp
     */
    public enum genresEnum {
        ACAO{ public String toString() { return "Ação";} },
        AVENTURA{ public String toString() { return "Aventura";} },
        COMEDIA{ public String toString() { return "Comédia";} },
        ROMANCE{ public String toString() { return "Romance";} },
        FICCAO{ public String toString() { return "Ficção";} },
        TERROR{ public String toString() { return "Terror";} },
        SUSPENSE{ public String toString() { return "Suspense";} },
        POLICIAL{ public String toString() { return "Policial";} },
    }

    public static ArrayList<?> CopyArray(ArrayList<?> aList)
    {
        if(aList == null)
            return null;
        ArrayList arrayCopy = new ArrayList();
        for(int i = 0; i < aList.size(); ++i)
            arrayCopy.add(aList.get(i));
        return arrayCopy;
    }
}
