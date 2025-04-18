package lib;

public class TaxFunction {

	
	/**
	 * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus dibayarkan setahun.
	 * 
	 * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan) dikurangi penghasilan tidak kena pajak.
	 * 
	 * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak kena pajaknya adalah Rp 54.000.000.
	 * Jika pegawai sudah menikah maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000.
	 * Jika pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000 per anak sampai anak ketiga.
	 * 
	 */
	
	
	public class TaxFunction {
        private static final int BASIC_NON_TAXABLE_INCOME = 54000000;
        private static final int MARRIED_ADDITION = 4500000;
        private static final int CHILD_ADDITION = 1500000;
        private static final int MAX_CHILDREN_COUNT = 3;
        private static final double TAX_RATE = 0.05;

        public static int calculateTax(Income income, FamilyInfo family) {
            validateMonth(income.monthsWorked);
            int numberOfChildren = limitChildren(family.numberOfChildren);

            int yearlyIncome = calculateYearlyIncome(income);
            int nonTaxableIncome = calculateNonTaxableIncome(family.isMarried, numberOfChildren);
            int taxableIncome = yearlyIncome - income.deductible - nonTaxableIncome;

            return calculateFinalTax(taxableIncome);
        }

        private static void validateMonth(int monthsWorked) {
            if (monthsWorked > 12) {
                System.err.println("More than 12 month working per year");
            }
        }

        private static int limitChildren(int numberOfChildren) {
            return Math.min(numberOfChildren, MAX_CHILDREN_COUNT);
        }

        private static int calculateYearlyIncome(Income income) {
            return (income.monthlySalary + income.otherMonthlyIncome) * income.monthsWorked;
        }

        private static int calculateNonTaxableIncome(boolean isMarried, int numberOfChildren) {
            int result = BASIC_NON_TAXABLE_INCOME;
            if (isMarried) {
                result += MARRIED_ADDITION;
            }
            result += numberOfChildren * CHILD_ADDITION;
            return result;
        }

        private static int calculateFinalTax(int taxableIncome) {
            if (taxableIncome <= 0) return 0;
            return (int) Math.round(TAX_RATE * taxableIncome);
        }
    }	
}
