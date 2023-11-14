package christmas.service;

import christmas.config.BadgeType;
import christmas.config.EventType;
import christmas.model.BenefitDetail;
import christmas.model.Menu;
import christmas.model.OrderMenu;
import christmas.validator.EventValidator;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EventServiceTest {
    @Test
    void calculateTotalOrderAmount() {
        EventValidator eventValidator = new EventValidator();
        EventService eventService = new EventService(eventValidator);

        List<OrderMenu> orderMenus = List.of(
                new OrderMenu(Menu.TAPAS, 2),
                new OrderMenu(Menu.BBQ_RIBS, 3)
        );

        int totalAmount = eventService.calculateTotalOrderAmount(orderMenus);

        assertEquals(173000, totalAmount);
    }

    @Test
    void calculateBenefits() {
        EventValidator eventValidator = new EventValidator();
        EventService eventService = new EventService(eventValidator);

        List<OrderMenu> orderMenus = List.of(
                new OrderMenu(Menu.T_BONE_STEAK, 2),
                new OrderMenu(Menu.RED_WINE, 1)
        );

        EventValidator eventValidatorMock = mock(EventValidator.class);
        when(eventValidatorMock.validateTotalOrderAmount(anyInt())).thenReturn(true);

        List<BenefitDetail> benefitDetails = eventService.calculateBenefits(LocalDate.now(), orderMenus, 0);

        assertEquals(4, benefitDetails.size());
        assertEquals(EventType.CHRISTMAS_DDAY, benefitDetails.get(0).getEventType());
        assertEquals(EventType.WEEKDAY_DISCOUNT, benefitDetails.get(1).getEventType());
        assertEquals(EventType.SPECIAL_DISCOUNT, benefitDetails.get(2).getEventType());
        assertEquals(EventType.GIFT_EVENT, benefitDetails.get(3).getEventType());
    }

    @Test
    void calculateTotalBenefitsAmount() {
        EventValidator eventValidator = new EventValidator();
        EventService eventService = new EventService(eventValidator);

        List<BenefitDetail> benefitDetails = List.of(
                new BenefitDetail(EventType.CHRISTMAS_DDAY, 1000),
                new BenefitDetail(EventType.WEEKDAY_DISCOUNT, 500),
                new BenefitDetail(EventType.SPECIAL_DISCOUNT, 200),
                new BenefitDetail(EventType.GIFT_EVENT, 300)
        );

        int totalBenefitsAmount = eventService.calculateTotalBenefitsAmount(benefitDetails);

        assertEquals(1000 + 500 + 200 + 300, totalBenefitsAmount);
    }

    @Test
    void calculateEventBadge() {
        EventValidator eventValidator = new EventValidator();
        EventService eventService = new EventService(eventValidator);

        BadgeType badge1 = eventService.calculateEventBadge(100);
        BadgeType badge2 = eventService.calculateEventBadge(10000);
        BadgeType badge3 = eventService.calculateEventBadge(5000);

        assertEquals(BadgeType.NONE, badge1);
        assertEquals(BadgeType.TREE, badge2);
        assertEquals(BadgeType.STAR, badge3);
    }
}
