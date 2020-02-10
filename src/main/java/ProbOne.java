import java.util.ArrayList;
import java.util.List;

public class ProbOne {

    public static void main(String[] args) {
        int[][] objs= {{22,10},{20,5},{20,5}};

        valeurMax(objs, 10);

    }

    public static int valeurMax(int[][]  objets, int M ) {
        // 0 => valeur
        // 1 => poid
        int valuerMax = 0;
        int poid = 0;

        boolean flag = false;
        do {
            flag = false;
            for(int i = 0; i < objets.length - 1; i ++)  {
                if(objets[i][0] < objets[i + 1][0]){
                    int[] aux = objets[i];
                    objets[i] = objets[i + 1];
                    objets[i + 1] = aux;
                    flag = true;
                }
            }
        } while (flag);

        for(int i = 0; i < objets.length ; i ++)  {
            if((objets[i][1] + poid) <= M) {
                poid += objets[i][1];
                valuerMax += objets[i][0];
            }
        }
        return  valuerMax;
    }
/*    public static List<List<Obj>> combinations(List<Obj> motList, int Longeur) {
        List<List<Obj>> Resultat = new ArrayList<>();

      for (int i = 0; i < motList.size() ; i++) {
            System.out.println(i + 1    + "< >" + motList.size());
            if (Longeur == 1) {
                List<Obj> list = new ArrayList<>();
                list.add(motList.get(i));
                Resultat.add(list);
            }
            else {
                if(i + 1 <= motList.size() - (i +1 ))  {
                    List<Obj> ListIntermediaire = motList.subList(i + 1, motList.size() - (i +1 ));
                    List<List<Obj>> CombiList = combinations(ListIntermediaire, Longeur - 1);
                    for (List<Obj> s : CombiList) {
                        List<Obj> list = s;
                        list.add(motList.get(i));
                        Resultat.add(list);
                    }
                } else {
                    List<Obj> ListIntermediaire = motList.subList(motList.size() - (i +1 ),i + 1);
                    List<List<Obj>> CombiList = combinations(ListIntermediaire, Longeur - 1);
                    for (List<Obj> s : CombiList) {
                        List<Obj> list = s;
                        list.add(motList.get(i));
                        Resultat.add(list);
                    }
                }
            }
        }
        return Resultat;
    }
    private class Obj {
        public int poid;
        public int valeur;

        public Obj(int poid, int valeur) {
            this.poid = poid;
            this.valeur = valeur;
        }
    }
*/}
