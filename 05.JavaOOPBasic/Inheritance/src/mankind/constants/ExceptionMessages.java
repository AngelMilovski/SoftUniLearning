package mankind.constants;

public final class ExceptionMessages {
    public static final String INVALID_FIRST_NAME_FORMAT_EXCEPTION_MESSAGE = "Expected upper case letter!Argument: firstName";
    public static final String INVALID_FIRST_NAME_LENGTH_EXCEPTION_MESSAGE = "Expected length at least 4 symbols!Argument: firstName";
    public static final String INVALID_LAST_NAME_FORMAT_EXCEPTION_MESSAGE = "Expected upper case letter!Argument: lastName";
    public static final String INVALID_LAST_NAME_LENGTH_EXCEPTION_MESSAGE = "Expected length at least 3 symbols!Argument: lastName";
    public static final String INVALID_FACULTY_NUMBER_LENGTH_EXCEPTION_MESSAGE = "Invalid faculty number!";
    public static final String INVALID_WORKER_LAST_NAME_EXCEPTION_MESSAGE = "Expected length more than 3 symbols!Argument: lastName";
    public static final String INVALID_WEEK_SALARY_EXCEPTION_MESSAGE = "Expected value mismatch!Argument: weekSalary";
    public static final String INVALID_WORKING_HOURS_EXCEPTION_MESSAGE = "Expected value mismatch!Argument: workHoursPerDay";

    private ExceptionMessages() {
    }

}
