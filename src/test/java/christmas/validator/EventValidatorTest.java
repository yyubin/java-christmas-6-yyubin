package christmas.validator;

import christmas.validator.EventValidator;
import christmas.config.TotalOrderAmount;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EventValidatorTest {

    @Test
    public void testValidateTotalOrderAmount() {
        EventValidator eventValidator = new EventValidator();

        assertFalse(eventValidator.validateTotalOrderAmount(TotalOrderAmount.EVENT_GIFT_THRESHOLD.getAmount() - 1));

        assertTrue(eventValidator.validateTotalOrderAmount(TotalOrderAmount.EVENT_GIFT_THRESHOLD.getAmount()));

        assertTrue(eventValidator.validateTotalOrderAmount(TotalOrderAmount.EVENT_GIFT_THRESHOLD.getAmount() + 1));
    }
}