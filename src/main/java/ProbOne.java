import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProbOne {

    public static void main(String[] args) {

        // 0 => valeur
        // 1 => poid
        int[][] objs= {{22,10},{20,5},{20,5}};
        System.out.println(valeurMax(objs,10));

    }

    public static int valeurMax(int[][]  objets, int M ) {
        // 0 => valeur
        // 1 => poid
        int valuerMax = 0;
        List<Integer> range = IntStream.rangeClosed(0, objets.length - 1)
                .boxed().collect(Collectors.toList());
        List<List<Integer>> indexes = new ArrayList<>();
        for(int i = 1 ; i <= objets.length ; i++)
            indexes.addAll(combine(range,range, i));

        for(List<Integer> idxs : indexes) {
            int valeur = 0;
            int poid = 0;
            for(int i : idxs) {
                valeur += objets[i][0];
                poid += objets[i][1];
            }
            if(poid <= M && valeur > valuerMax)
                valuerMax = valeur;
        }

        return  valuerMax;
    }

    public static List<List<Integer>> combine(List<Integer> list,List<Integer> lastList, int Longeur) {
        List<List<Integer>> resultat = new ArrayList<>();

        for (Integer s : list) {
            if (Longeur == 1) {
                List<Integer> l = new ArrayList<Integer>();
                l.add(s);
                resultat.add(l);
            } else {
                for(List<Integer> last : combine(list, lastList, Longeur - 1)) {
                    boolean flag = false;
                    List<Integer> l = new ArrayList<>();
                    l.addAll(last);
                    l.add(s);
                    for(List<Integer> res : resultat) {
                        Collections.sort(res);
                        Collections.sort(l);
                        if(res.equals(l)) {
                            flag = true;
                        }
                    }
                    if (!flag)
                        resultat.add(l);
                }
           }
        }
        boolean flag = false;
        do {
            flag = false;
            int k = 0;
            for( k = 0; k < resultat.size() && !flag ; k++) {
                for(int i = 0 ; i< resultat.get(k).size() && !flag ; i++)
                    for(int j = i + 1 ; j< resultat.get(k).size() && !flag ; j++) {
                        if(resultat.get(k).get(i).equals(resultat.get(k).get(j))) {
                            flag = true;
                        }
                    }
            }
            if(flag)
            resultat.remove(k - 1);


        } while (flag);

        return resultat;
    }


}
