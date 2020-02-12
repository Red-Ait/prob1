import org.chocosolver.solver.Model;
import org.chocosolver.solver.variables.*;

public class PobTow {
    public static void main(String[] args) {
        Model model = new Model("my first problem");

        int n = 6;
        IntVar[] vars = new IntVar[n];
        for (int j = 0; j < n ; j++) {
            vars[j] = model.intVar("X" + (j +1), 1, n); // x in [0,5]
        }
        for (int i = 0; i < n - 1 ; i++) {
            for (int j = i + 1; j < n ; j++) {
                model.allDifferent(vars[i], vars[j]).post();
                model.arithm(vars[i], "!=" , vars[j], "+", (j - i)).post();
                model.arithm(vars[i], "!=" , vars[j], "-", (j - i)).post();
            }
        }
        model.getSolver().solve();

        for (int i = 0; i < n ; i++) {
        for (int j = 0; j < n ; j++) {
            System.out.println(vars[j].getValue());
        }
        }
    }
}
