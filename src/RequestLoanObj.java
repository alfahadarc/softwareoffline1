public class RequestLoanObj {
    private String name;
    private String type;
    private double amount;
    private boolean status; //1 for approved 0 for pending

    public RequestLoanObj(String name, String type, double amount, boolean status) {
        this.name = name;
        this.type = type;
        this.amount = amount;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
