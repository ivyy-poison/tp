package seedu.address.testutil;

import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.BOB;

import seedu.address.model.report.Report;

/**
 * A utility class containing a list of {@code Report} objects to be used in tests.
 */
public class TypicalReports {

    public static final Report ALICE_REPORT = new Report(ALICE, "Alice's Report", "Alice's Report Description");
    public static final Report BOB_REPORT = new Report(BOB, "Bob's Report", "Bob's Report Description");

}
