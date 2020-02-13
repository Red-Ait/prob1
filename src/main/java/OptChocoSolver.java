import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.objective.ParetoOptimizer;
import org.chocosolver.solver.variables.IntVar;

import java.util.List;

public class OptChocoSolver {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        Model model = new Model();

        // 0 > POID
        // 1 > VALEUR

        // {{122,10},{20,5},{201,5},{20,5},{201,5},{20,5},{20,5},{20,5},{20,5},{20,5}}
        int[][] objet = new int[][] { {10,5,32,12,20,30},{122,20,20,122,20,20 }};

        int[] poids = objet[0];
        IntVar[] poidVars = new IntVar[poids.length];

        int poidMax = 60;

        int valeurMax = 0;

        for(int i = 0; i < poids.length ; i ++) {
            poidVars[i] = model.intVar("poid " + (i+1), new int[]{0, poids[i]});
        }

        model.sum(poidVars, "<=", poidMax).post();

        ParetoOptimizer po = new ParetoOptimizer(Model.MAXIMIZE,poidVars);
        Solver solver = model.getSolver();
        solver.plugMonitor(po);

        while(solver.solve());
        List<Solution> paretoFront = po.getParetoFront();
        int len = 0 ;
        for(Solution s:paretoFront){
            int valeur = 0;
            for(int i = 0 ; i < poidVars.length ; i++ ) {
                if(s.getIntVal(poidVars[i]) != 0)
                valeur += objet[1][i];
            }
            if (valeur == valeurMax)
                len ++;
            if (valeur > valeurMax) {
                valeurMax = valeur;
                len = 1;
            }
        }
        System.out.println("Poid max: " + poidMax);
        System.out.println("The probleme has "+ len +" solutions : ");
        System.out.println("valeur max = " + valeurMax);

        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
    }
}
