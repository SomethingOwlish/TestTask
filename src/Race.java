import java.util.HashMap;

public class Race {
    //переменная заложена для сбора данных о типах из файла и корректного определения программой.
    static HashMap<String, Integer> ListofRace = new HashMap<String, Integer>();


    static int counter = 0;
    static void makeRace(String name){
        counter++;
        ListofRace.put(name, counter);
    }


    static int findType(String name){

        return ListofRace.get(name);
    }

}
