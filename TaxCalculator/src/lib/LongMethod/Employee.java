Employee.java
package lib;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;

public class Employee {

	private String employeeId;
	private String firstName;
	private String lastName;
	private String idNumber;
	private String address;
	private boolean isForeigner;
	private boolean gender; //true = Laki-laki, false = Perempuan
	
	private DateInformation dateInformation;
	
	private int monthlySalary;
	private int otherMonthlyIncome;
	private int annualDeductible;
	
	private String spouseName;
	private String spouseIdNumber;

	private List<String> childNames;
	private List<String> childIdNumbers;
	
	public Employee(String employeeId, String firstName, String lastName, String idNumber, String address, int yearJoined, int monthJoined, int dayJoined, boolean isForeigner, boolean gender) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = idNumber;
		this.address = address;
		this.yearJoined = yearJoined;
		this.monthJoined = monthJoined;
		this.dayJoined = dayJoined;
		this.isForeigner = isForeigner;
		this.gender = gender;
		
		childNames = new LinkedList<String>();
		childIdNumbers = new LinkedList<String>();
	}
	
	/**
	 * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya (grade 1: 3.000.000 per bulan, grade 2: 5.000.000 per bulan, grade 3: 7.000.000 per bulan)
	 * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
	 */
	
	public void setMonthlySalary(int grade) {
        monthlySalary = getSalaryByGrade(grade);
        if (isForeigner) {
            monthlySalary = applyForeignersSalaryAdjustment(monthlySalary);
        }
    }

    private int getSalaryByGrade(int grade) {
        switch (grade) {
            case 1:
                return 3000000;
            case 2:
                return 5000000;
            case 3:
                return 7000000;
            default:
                throw new IllegalArgumentException("Invalid grade: " + grade);
        }
    }

private int applyForeignersSalaryAdjustment(int baseSalary) {
    return (int) (baseSalary * 1.5);
}

	
	public void setAnnualDeductible(int deductible) {	
		this.annualDeductible = deductible;
	}
	
	public void setAdditionalIncome(int income) {	
		this.otherMonthlyIncome = income;
	}
	
	public void setSpouse(String spouseName, String spouseIdNumber) {
		this.spouseName = spouseName;
		this.spouseIdNumber = idNumber;
	}
	
	public void addChild(String childName, String childIdNumber) {
		childNames.add(childName);
		childIdNumbers.add(childIdNumber);
	}
	
	public int getAnnualIncomeTax() {
    int monthsWorked = calculateMonthsWorkedInYear();
    return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthsWorked, annualDeductible, isSpouseEmpty(), childIdNumbers.size());
    }

    private int calculateMonthsWorkedInYear() {
        LocalDate date = LocalDate.now();

        if (date.getYear() == yearJoined) {
            return date.getMonthValue() - monthJoined;
        } else {
            return 12;
        }
    }

    private boolean isSpouseEmpty() {
        return spouseIdNumber.equals("");
    }

}