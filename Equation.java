import expression.*;

public abstract class Equation {
    protected class Solution {
        public static enum Type {
            ONE_SOLUTION, NO_SOLUTION, INFINITELY_SOLUTIONS, HOLDING, NOT_HOLDING
        }

        private Type type;
        private double solution;

        public Solution(Type type, double solution) {
            this.type = type;
            this.solution = solution;
        }

        public double getSolution() {
            return solution;
        }

        public Type getType() {
            return type;
        }

        @Override
        public String toString() {
            switch (type) {
                case INFINITELY_SOLUTIONS:
                    return "The equation has infinitely many solutions";
                case NO_SOLUTION:
                    return "The equation has no solutions";
                case ONE_SOLUTION:
                    return "Solution is: " + solution;
                case HOLDING:
                    return "The equation holds";
                default:
                    return "The equation does not hold";
            }
        }

        public void print() {
            System.out.println(toString());
        }
    }

    private Expression leftHandSide;
    private Expression rightHandSide;

    public Equation(String eq) {
        String[] eqSplitted = eq.split("=");
        leftHandSide = (new ExpressionConstructor(eqSplitted[0])).evaluate();
        rightHandSide = (new ExpressionConstructor(eqSplitted[1])).evaluate();
    }

    protected Expression getLeftHandSide(){
        return leftHandSide;
    }

    protected Expression getRightHandSide(){
        return rightHandSide;
    }

    public abstract Solution solve();
}