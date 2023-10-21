package seedu.address.testutil;

import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.BOB;

import seedu.address.model.report.Report;
import seedu.address.model.ReportBook;

/**
 * A utility class containing a list of {@code Report} objects to be used in tests.
 */
public class TypicalReports {

    public static final Report ALICE_REPORT = new Report(ALICE, "Alice's Report", "Alice's Report Description");
    public static final Report BOB_REPORT = new Report(BOB, "Bob's Report", "Bob's Report Description");
    public static final Report ALICE_REPORT_2 = new Report(ALICE, "Alice's Report 2", "Alice's Report Description 2");

    private TypicalReports() {} // prevents instantiation

    /**
     * Returns an {@code ReportBook} with all the typical reports.
     */
    public static ReportBook getTypicalReportBook() {
        ReportBook rb = new ReportBook();
        for (Report report : getTypicalReports()) {
            rb.addReport(report);
        }
        return rb;
    }

    public static Report[] getTypicalReports() {
        return new Report[] {ALICE_REPORT, BOB_REPORT, ALICE_REPORT_2};
    }

}
