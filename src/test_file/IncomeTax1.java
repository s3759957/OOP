 class IncomeTax {
    private double income;

    IncomeTax() {
        income = 0;

    }
    IncomeTax(double income) {
        this.income = income;

    }
    public double marriedIndividualsFilingJointly() {
        double a = 19750 * 0.1;
        double b = 80250 * 0.12;
        double c = 171050 * 0.22;
        double d = 326600 * 0.24;
        double e = 414700 * 0.32;
        double f = 622050 * 0.35;
        if (income <= 19750) {
            return income * 0.1;
        } else if (income <= 80250) {
            return a + (income - a) * 0.12;
        } else if (income <= 171050) {
            return a + b + (income - a - b) * 0.22;
        } else if (income <= 326600) {
            return a + b + c + (income - a - b - c) * 0.24;
        } else if (income <= 414700) {
            return a + b + c + d + (income - a - b - c - d) * 0.32;
        } else if (income <= 622050) {
            return a + b + c + d + e + (income - a - b - c - d - e) * 0.35;
        } else {
            return a + b + c + d + e + f + (income - a - b - c - d - e - f) * 0.37;
        }
    }

        public double unmarriedIndividuals() {
            double a1 = 9875 * 0.1;
            double b1 = 40125 * 0.12;
            double c1 = 85525 * 0.22;
            double d1 = 163300 * 0.24;
            double e1 = 207350 * 0.32;
            double f1 = 518400 * 0.35;
            if (income <= 9875) {
                return income * 0.1;
            } else if (income <= 9875) {
                return a1 + (income - a1) * 0.12;
            } else if (income <= 40125) {
                return a1 + b1 + (income - a1 - b1) * 0.22;
            } else if (income <= 85525) {
                return a1 + b1 + c1 + (income - a1 - b1 - c1) * 0.24;
            } else if (income <= 207350) {
                return a1 + b1 + c1 + d1 + (income - a1 - b1 - c1 - d1) * 0.32;
            } else if (income <= 518400) {
                return a1 + b1 + c1 + d1 + e1 + (income - a1 - b1 - c1 - d1 - e1) * 0.35;
            } else {
                return a1 + b1 + c1 + d1 + e1 + f1 + (income - a1 - b1 - c1 - d1 - e1 - f1) * 0.37;
            }
        }
    public double headsOfHouseholds() {
        double a = 14100 * 0.1;
        double b = 53700 * 0.12;
        double c = 85500 * 0.22;
        double d = 163300 * 0.24;
        double e = 207350 * 0.32;
        double f = 518400 * 0.35;
        if (income <= 14100) {
            return income * 0.1;
        } else if (income <= 53700) {
            return a + (income - a) * 0.12;
        } else if (income <= 85500) {
            return a + b + (income - a - b) * 0.22;
        } else if (income <= 163300) {
            return a + b + c + (income - a - b - c) * 0.24;
        } else if (income <= 207350) {
            return a + b + c + d + (income - a - b - c - d) * 0.32;
        } else if (income <= 518400) {
            return a + b + c + d + e + (income - a - b - c - d - e) * 0.35;
        } else {
            return a + b + c + d + e + f + (income - a - b - c - d - e - f) * 0.37;
        }
    }
    public double MarriedIndividualsFilingSeparetely() {
        double a = 9875 * 0.1;
        double b = 40125 * 0.12;
        double c = 85525 * 0.22;
        double d = 163300 * 0.24;
        double e = 207350 * 0.32;
        double f = 311025 * 0.35;
        if (income <= 9875) {
            return income * 0.1;
        } else if (income <= 40125) {
            return a + (income - a) * 0.12;
        } else if (income <= 85500) {
            return a + b + (income - a - b) * 0.22;
        } else if (income <= 163300) {
            return a + b + c + (income - a - b - c) * 0.24;
        } else if (income <= 207350) {
            return a + b + c + d + (income - a - b - c - d) * 0.32;
        } else if (income <= 311025) {
            return a + b + c + d + e + (income - a - b - c - d - e) * 0.35;
        } else {
            return a + b + c + d + e + f + (income - a - b - c - d - e - f) * 0.37;
        }
    }
}

 public class IncomeTax1{
     public static void main(String[] args) {
         IncomeTax [] tax = new IncomeTax[10];
         for (int i = 0; i <10;i++) {
             tax[i] = new IncomeTax(10000 * (i+1));
         }
         for (int i = 0; i< 10;i++){
             System.out.printf("%10d %10.2f %10.2f %10.2f %10.2f\n",(i+1)*10000,tax[i].unmarriedIndividuals(),tax[i].MarriedIndividualsFilingSeparetely(),tax[i].marriedIndividualsFilingJointly(),tax[i].headsOfHouseholds());
         }
     }
 }
