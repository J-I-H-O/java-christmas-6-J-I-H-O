package christmas.model;

public class VisitingDate {
    private static final String INVALID_DATE_ERROR_MESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";

    private final int date;

    public VisitingDate(int date) {
        validateDate(date);
        this.date = date;
    }

    private void validateDate(int date) {
        if (!(1 <= date && date <= 31)) {
            throw new IllegalArgumentException(INVALID_DATE_ERROR_MESSAGE);
        }
    }
}
