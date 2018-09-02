package mankind;

import mankind.constants.ConditionsForNamesSalaryAndWorkHours;
import mankind.constants.ExceptionMessages;


public class Human {
    static final String NEW_LINE = System.lineSeparator();

    private String firstName;
    private String lastName;

    public Human(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    private void setFirstName(String firstName) {
        if (!isCapitalLetter(firstName)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_FIRST_NAME_FORMAT_EXCEPTION_MESSAGE);
        } else if (firstName.length() < ConditionsForNamesSalaryAndWorkHours.MIN_FIRST_NAME_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_FIRST_NAME_LENGTH_EXCEPTION_MESSAGE);
        }
        this.firstName = firstName;
    }

    protected void setLastName(String lastName) {
        if (!isCapitalLetter(lastName)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_LAST_NAME_FORMAT_EXCEPTION_MESSAGE);
        } else if (lastName.length() < ConditionsForNamesSalaryAndWorkHours.LAST_NAME_MIN_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_LAST_NAME_LENGTH_EXCEPTION_MESSAGE);
        }
        this.lastName = lastName;
    }

    private boolean isCapitalLetter(String name) {
        if (Character.isUpperCase(name.charAt(0))) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder human = new StringBuilder();

        human.append("First Name: ").append(this.firstName)
                .append(NEW_LINE)
                .append("Last Name: ").append(this.lastName);
        return human.toString();
    }
}
