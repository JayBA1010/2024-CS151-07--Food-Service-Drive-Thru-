package core;
public class Payment {
    private String paymentType;  // "cash" or "credit"
    private double amount;
    private double tip;
    private double fee;
    private double totalAmount;

    public Payment(String paymentType, double amount) {
        this.paymentType = paymentType.toLowerCase();
        this.amount = amount;
        this.tip = 0;
        this.fee = 0;
        calculateFee();
        calculateTotal();
    }

    // Sets tip amount
    public void addTip(double tip) {
        if (tip < 0) {
            System.out.println("Tip amount cannot be negative.");
            return;
        }
        this.tip = tip;
        calculateTotal();
    }

    // Applies a minor fee if payment is by credit
    private void calculateFee() {
        if (paymentType.equals("credit")) {
            this.fee = amount * 0.02; // 2% fee, for example
        } else {
            this.fee = 0;
        }
    }

    // Calculates the total amount after applying fees and tips
    private void calculateTotal() {
        this.totalAmount = amount + fee + tip;
    }

    // Returns a summary of the payment
    public void displayPaymentSummary() {
        System.out.println("Payment Type: " + paymentType.toUpperCase());
        System.out.println("Base Amount: $" + amount);
        System.out.println("Fee: $" + fee);
        System.out.println("Tip: $" + tip);
        System.out.println("Total Amount: $" + totalAmount);
    }

    // Simulates processing the payment
    public void processPayment() {
        // Add additional logic if needed for processing
        displayPaymentSummary();
        System.out.println("Processing payment... Done!");
    }

    // Example main method to demonstrate usage
    public static void main(String[] args) {
        Payment payment1 = new Payment("credit", 50.00);
        payment1.addTip(5.00);
        payment1.processPayment();

        Payment payment2 = new Payment("cash", 30.00);
        payment2.processPayment();
    }
}
