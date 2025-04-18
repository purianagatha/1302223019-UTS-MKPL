public class Employee {
    
    private String employeeId;
    private String firstName;
    private String lastName;
    private String idNumber;
    private String address;
    private boolean isForeigner;
    private boolean gender; 
    
    private DateInformation dateInformation;
    
    private Salary salary;
    private Spouse spouse;
    private List<Child> children;
    
    public Employee(String employeeId, String firstName, String lastName, String idNumber, String address, boolean isForeigner, boolean gender) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.address = address;
        this.isForeigner = isForeigner;
        this.gender = gender;
        
        this.salary = new Salary();
        this.spouse = new Spouse();
        this.children = new LinkedList<Child>();
    }
    
    public void setMonthlySalary(int grade) {
        this.salary.setMonthlySalary(grade, isForeigner);
    }
    
    public void setAnnualDeductible(int deductible) {
        this.salary.setAnnualDeductible(deductible);
    }
    
    public void setAdditionalIncome(int income) {
        this.salary.setAdditionalIncome(income);
    }
    
    public void setSpouse(String spouseName, String spouseIdNumber) {
        this.spouse.setSpouse(spouseName, spouseIdNumber);
    }
    
    public void addChild(String childName, String childIdNumber) {
        this.children.add(new Child(childName, childIdNumber));
    }
    
    public int getAnnualIncomeTax() {
        return TaxFunction.calculateTax(salary.getMonthlySalary(), salary.getOtherMonthlyIncome(), salary.getMonthWorkingInYear(), salary.getAnnualDeductible(), spouse.isSpouseEmpty(), children.size());
    }
}
