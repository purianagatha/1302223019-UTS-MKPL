public class Salary {
    private int monthlySalary;
    private int otherMonthlyIncome;
    private int annualDeductible;

    public void setMonthlySalary(int grade, boolean isForeigner) {
        if (grade == 1) {
            monthlySalary = 3000000;
        } else if (grade == 2) {
            monthlySalary = 5000000;
        } else if (grade == 3) {
            monthlySalary = 7000000;
        }

        if (isForeigner) {
            monthlySalary = (int) (monthlySalary * 1.5);
        }
    }

    public void setAnnualDeductible(int deductible) {
        this.annualDeductible = deductible;
    }

    public void setAdditionalIncome(int income) {
        this.otherMonthlyIncome = income;
    }

    public int getMonthlySalary() {
        return monthlySalary;
    }

    public int getOtherMonthlyIncome() {
        return otherMonthlyIncome;
    }

    public int getMonthWorkingInYear() {
        return 12; 
    }

    public int getAnnualDeductible() {
        return annualDeductible;
    }
}
