package hash;

import java.util.ArrayList;
import static hash.HashMap.hash;

public class HashSet {

    private static ArrayList<Set> initList() {
        int max = 2048;
        ArrayList<Set> s = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            s.add(new Set()); // or null, but this can cause some problems ... (try to find an empty representation for an "activity" instance)
        }
        return s;
    }

    ArrayList<Set> array = initList();

    public void add(String s){
        int hashValue = hash(s);
        array.get(hashValue).add(s);
    }

    public boolean contains(String s){
        int hashValue = hash(s);
        return array.get(hashValue).contains(s);
    }

    public void clear(){
        array = initList();
    }
}



