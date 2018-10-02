package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's timetable in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidTimetable(String)}
 */
public class Timetable {

    public static final String EXAMPLE = "Fri 9am";
    public static final String MESSAGE_TIMETABLE_CONSTRAINTS =
            "Person timetable should be 2 numeric strings separated by a whitespace";
    public static final String TIMETABLE_VALIDATION_REGEX = ".+";
    // https://stackoverflow.com/questions/16048148/regex-to-check-if-whitespace-present
    // /\s/

    public final String value;
    private boolean isPrivate;

    /**
     * Validates given timetable command.
     *
     * @throws IllegalValueException if given timetable string is invalid.
     */
    public Timetable(String timetable, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        timetable = timetable.trim();
        if (!isValidTimetable(timetable)) {
            throw new IllegalValueException(MESSAGE_TIMETABLE_CONSTRAINTS);
        }
        this.value = timetable;
    }

    /**
     * Checks if a given string is a valid person timetable.
     */
    public static boolean isValidTimetable(String test) {
        return test.matches(TIMETABLE_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Timetable // instanceof handles nulls
                && this.value.equals(((Timetable) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }


    public boolean isPrivate() {
        return isPrivate;
    }
}