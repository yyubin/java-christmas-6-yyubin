package christmas.model;

public class BenefitDetail {
    private final String benefitName;
    private final int benefitAmount;

    public BenefitDetail(String benefitName, int benefitAmount) {
        this.benefitName = benefitName;
        this.benefitAmount = benefitAmount;
    }

    public String getBenefitName() {
        return benefitName;
    }

    public int getBenefitAmount() {
        return benefitAmount;
    }
}
