public class Spouse {
    private String name;
    private String idNumber;

    public Spouse(String name, String idNumber) {
        this.name = name;
        this.idNumber = idNumber;
    }

    public boolean isEmpty() {
        return idNumber == null || idNumber.isEmpty();
    }

    public String getName() {
        return name;
    }

    public String getIdNumber() {
        return idNumber;
    }
}
