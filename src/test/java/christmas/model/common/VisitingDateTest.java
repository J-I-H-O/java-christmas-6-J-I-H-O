package christmas.model.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class VisitingDateTest {
    @Test
    void 예상_방문_날짜가_null인_경우_예외발생() {
        String dateInput = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> new VisitingDate(dateInput));
    }

    @Test
    void 예상_방문_날짜가_빈문자열인_경우_예외발생() {
        String dateInput = "";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new VisitingDate(dateInput));
    }
    
    @Test
    void 예상_방문_날짜가_1보다_작은_경우_예외발생() {
        String dateInput = "0";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new VisitingDate(dateInput));
    }

    @Test
    void 예상_방문_날짜가_31보다_큰_경우_예외발생() {
        String dateInput = "32";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new VisitingDate(dateInput));
    }

    @Test
    void 예상_방문_날짜가_음수인_경우_예외발생() {
        String dateInput = "-1";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new VisitingDate(dateInput));
    }

    @Test
    void 예상_방문_날짜가_숫자가_아닌_경우_예외발생() {
        String dateInput = "a";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new VisitingDate(dateInput));
    }
}