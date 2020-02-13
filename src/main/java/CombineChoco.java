import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;


public class CombineChoco {

    public static void main(String[] args) {

        Model model = new Model("ok");

        int n = 4;

        IntVar[] intVars = new IntVar[n];

        for(int i = 1 ; i <= n ; i ++) {
            intVars[i - 1] = model.intVar("var" + (i), 1, n);
        }
        model.allDifferent(intVars).post();
        Solver solver = model.getSolver();
        int i = 1;
        while (solver.solve()){
            System.out.print(i + " => ");
            i++;
            for(IntVar v : intVars)
                System.out.print(v.getValue() + " ");
            System.out.println();
        }

/*
        ParetoOptimizer po = new ParetoOptimizer(Model.MAXIMIZE,intVars);

        Solver solver = model.getSolver();
        solver.plugMonitor(po);

        while(solver.solve());

        List<Solution> paretoFront = po.getParetoFront();
        System.out.println("The pareto front has "+paretoFront.size()+" solutions : ");
        for(Solution s:paretoFront){
            for(IntVar v : intVars)
                System.out.print(v.getName() + " = " + s.getIntVal(v) + " ");
            System.out.println();
        }

  */      }
}
