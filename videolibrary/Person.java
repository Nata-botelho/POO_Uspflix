package videolibrary;

import java.time.LocalDate;
import java.time.Period;

public abstract class Person
{
    /*------------VARIAVEIS-------------*/

    private final String name;
    private final String country;
    private final LocalDate birthday;
    private int age;

    /*-------------CONSTRUTOR------------*/
    public Person(String _name, String _country, String _birthday)
    {
        this.name = _name;
        this.country = _country;
        this.birthday = LocalDate.parse(_birthday);
        updateAge();
    }

    /*------------FUNCOES----------------*/
    public void updateAge(){
        Period diff = Period.between(this.birthday, LocalDate.now());
        age = diff.getYears();    
    }
    /*--------------GETTERS-------------*/

    public String GetName(){
        return this.name;
    }

    public String GetCountry(){
        return this.country;
    }

    public String GetBirthday(){
        return this.birthday.toString();
    }

    public int GetAge(){
        return this.age;
    }
}