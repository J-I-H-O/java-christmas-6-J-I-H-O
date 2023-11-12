package christmas.model;

public class VisitingDate {
    private static final String NOT_NUMERIC_ERROR_MESSAGE = "[ERROR] 숫자만 입력할 수 있습니다.";
    private static final String INVALID_DATE_ERROR_MESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";

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
        if (!(1 <= date && date <= 31)) {
            throw new IllegalArgumentException(INVALID_DATE_ERROR_MESSAGE);
        }
    }
}
