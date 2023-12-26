class FuzzyNumber implements Pair {
    double x;
    double e1;
    double e2;

    // Конструктор класса FuzzyNumber
    public FuzzyNumber(double x, double e1, double e2) {
        this.x = x;
        this.e1 = e1;
        this.e2 = e2;
    }

    // Реализация методов арифметических операций из интерфейса Pair
    public Pair add(Pair other) {
        FuzzyNumber fn = (FuzzyNumber) other;
        double newX = this.x + fn.x - this.e1 - fn.e1;
        double newE1 = this.x + fn.x;
        double newE2 = this.e2 + fn.e2;
        return new FuzzyNumber(newX, newE1, newE2);
    }

    public Pair subtract(Pair other) {
        FuzzyNumber fn = (FuzzyNumber) other;
        double newX = this.x - fn.x - this.e1 - fn.e1;
        double newE1 = this.x - fn.x;
        double newE2 = this.e2 + fn.e2;
        return new FuzzyNumber(newX, newE1, newE2);
    }

    public Pair multiply(Pair other) {
        FuzzyNumber fn = (FuzzyNumber) other;
        double newX = this.x * fn.x - fn.x * this.e1 - this.x * fn.e1 + this.e1 * fn.e1;
        double newE1 = this.x * fn.x;
        double newE2 = this.e2 * fn.e2 + this.x * fn.e2 + this.e2 * fn.x + this.e2 * fn.e2;
        return new FuzzyNumber(newX, newE1, newE2);
    }

    public Pair divide(Pair other) {
        FuzzyNumber fn = (FuzzyNumber) other;
        double newX1 = (this.x - this.e1) / (fn.x + fn.e2);
        double newX2 = (this.x + this.e2) / (fn.x - fn.e1);
        return new FuzzyNumber(newX1, newX2, 0);
    }

    // Метод toString для вывода значений
    @Override
    public String toString() {
        return "(" + (x - e1) + ", " + x + ", " + (x + e2) + ")";
    }
    public void print(){
        System.out.println("Chisla+"+x+" "+e1+" "+e2);
    }

}
