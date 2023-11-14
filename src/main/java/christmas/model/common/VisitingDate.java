package christmas.model.common;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class VisitingDate {
    private static final String NOT_NUMERIC_ERROR_MESSAGE = "[ERROR] 숫자만 입력할 수 있습니다.";
    private static final String INVALID_DATE_ERROR_MESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private static final int START_DATE_OF_MONTH = 1;
    private static final int END_DATE_OF_MONTH = 31;
    private static final int EVENT_YEAR = 2023;
    private static final int EVENT_MONTH = 12;
    private static final List<Integer> SPECIAL_EVENT_DATES = Arrays.asList(new Integer[]{3, 10, 17, 24, 25, 31});

    private final int date;

    public VisitingDate(String dateInput) {
        validateNumeric(dateInput);
        int date = Integer.parseInt(dateInput);
        validateDateRange(date);

        this.date = date;
    }

    private void validateNumeric(String dateInput) {
        try {
            Integer.parseInt(dateInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC_ERROR_MESSAGE);
        }
    }

    private void validateDateRange(int date) {
        if (!(START_DATE_OF_MONTH <= date && date <= END_DATE_OF_MONTH)) {
            throw new IllegalArgumentException(INVALID_DATE_ERROR_MESSAGE);
        }
    }

    public boolean isWeekend() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(EVENT_YEAR, EVENT_MONTH - 1, date);

        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return (dayOfWeek == Calendar.FRIDAY || dayOfWeek == Calendar.SATURDAY);
    }

    public boolean isSpecialDay() {
        return SPECIAL_EVENT_DATES.contains(date);
    }

    public int getDate() {
        return date;
    }
}
