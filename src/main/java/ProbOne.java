import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProbOne {

    public static void main(String[] args) {

        // 0 => valeur
        // 1 => poid
        int[][] objs= {{122,10},{20,5},{201,5},{20,5},{201,5},{20,5},{20,5},{20,5},{20,5},{20,5}};
        System.out.println(valeurMax(objs,50));
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.add(4);
        //System.out.println(combine(ints, 2));
    }

    public static int valeurMax(int[][]  objets, int M ) {
        // 0 => valeur
        // 1 => poid
        int valuerMax = 0;
        List<Integer> range = IntStream.rangeClosed(0, objets.length - 1)
                .boxed().collect(Collectors.toList());
        List<List<Integer>> indexes = new ArrayList<>();
        for(int i = 1 ; i <= objets.length ; i++) {
            System.out.println(combine(range, i));
            indexes.addAll(combine(range, i));
        }

//        System.out.println(indexes);
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

    public static List<List<Integer>> combine(List<Integer> list, int Longeur) {
        List<List<Integer>> resultat = new ArrayList<>();

        for (Integer s : list) {
            if (Longeur == 1) {
                List<Integer> l = new ArrayList<Integer>();
                l.add(s);
                resultat.add(l);
            } else {
                for(List<Integer> last : combine(list.subList(1, list.size() ), Longeur - 1)) {
                    boolean flag = false;
                    List<Integer> l = new ArrayList<>();
                    l.addAll(last);
                    l.add(s);
                    for(int i = 0 ; i < l.size(); i++)
                    for(int j = i + 1 ; j < l.size(); j++) {
                        if (l.get(i).equals(l.get(j))) {
                            flag = true;
                        }
                    }
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

        return resultat;
    }


}
