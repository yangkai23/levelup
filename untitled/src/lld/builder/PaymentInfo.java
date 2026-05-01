package lld.builder;

/**
 * @author Anirudh
 * @since 01/05/26
 */
public class PaymentInfo {

    private final String paymentType;
    private final String username;
    private final long mobileNumber;
    private final String couponCode;
    private final double amount;

    public PaymentInfo(PaymentInfoBuilder paymentInfoBuilder) {
        this.paymentType = paymentInfoBuilder.paymentType;
        this.username = paymentInfoBuilder.username;
        this.mobileNumber = paymentInfoBuilder.mobileNumber;
        this.couponCode = paymentInfoBuilder.couponCode;
        this.amount = paymentInfoBuilder.amount;
    }

    public static class PaymentInfoBuilder {
        private final String paymentType;
        private final String username;
        private long mobileNumber;
        private String couponCode;
        private final double amount;


        public PaymentInfoBuilder(String paymentType, String username, double amount) {
            this.paymentType = paymentType;
            this.username = username;
            this.amount = amount;
        }

        public PaymentInfoBuilder mobileNumber(long mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }

        public PaymentInfoBuilder couponCode(String couponCode) {
            this.couponCode = couponCode;
            return this;
        }

        public PaymentInfo build() {
            return new PaymentInfo(this);
        }


    }


}
