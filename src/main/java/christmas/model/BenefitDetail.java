package christmas.model;

import christmas.config.EventType;

public class BenefitDetail {
    private final EventType eventType;
    private final int benefitAmount;

    public BenefitDetail(EventType eventType, int benefitAmount) {
        this.eventType = eventType;
        this.benefitAmount = benefitAmount;
    }

    public EventType getEventType() {
        return eventType;
    }

    public int getBenefitAmount() {
        return benefitAmount;
    }

}
