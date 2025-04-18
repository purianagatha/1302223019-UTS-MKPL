public class Spouse {
    private String spouseName;
    private String spouseIdNumber;

    public void setSpouse(String spouseName, String spouseIdNumber) {
        this.spouseName = spouseName;
        this.spouseIdNumber = spouseIdNumber;
    }

    public boolean isSpouseEmpty() {
        return spouseIdNumber == null || spouseIdNumber.isEmpty();
    }
}
