package seedu.address.model.report;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.BOB;
import static seedu.address.testutil.TypicalReports.ALICE_REPORT;
import static seedu.address.testutil.TypicalReports.BOB_REPORT;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.ReportBuilder;

public class ReportTest {

    @Test
    public void equals() {
        // same values -> returns true
        Report aliceCopy = new ReportBuilder(ALICE_REPORT).build();
        assertTrue(ALICE_REPORT.equals(aliceCopy));

        // same object -> returns true
        assertTrue(ALICE_REPORT.equals(ALICE_REPORT));

        // null -> returns false
        assertFalse(ALICE_REPORT.equals(null));

        // different type -> returns false
        assertFalse(ALICE_REPORT.equals(5));

        // different report -> returns false
        assertFalse(ALICE_REPORT.equals(BOB_REPORT));

        // different employee -> returns false
        Report editedAliceReport = new Report(BOB, "Alice's Report", "Alice's Report Description");
        assertFalse(ALICE_REPORT.equals(editedAliceReport));

        // different title -> returns false
        editedAliceReport = new Report(ALICE, "Bob's Report", "Alice's Report Description");
        assertFalse(ALICE_REPORT.equals(editedAliceReport));

        // different description -> returns false
        editedAliceReport = new Report(ALICE, "Alice's Report", "Bob's Report Description");
        assertFalse(ALICE_REPORT.equals(editedAliceReport));
    }

    @Test
    public void toStringMethod() {
        String expectedString = "Report ID: " + ALICE_REPORT.getReportId()
                + " Employee: " + ALICE_REPORT.getEmployee()
                + " Title: " + ALICE_REPORT.getTitle()
                + " Modified: " + ALICE_REPORT.getLastModified();

        assertEquals(expectedString, ALICE_REPORT.toString());
    }

    @Test
    public void belongsTo() {
        // same employee -> returns true
        assertTrue(ALICE_REPORT.belongsTo(ALICE));

        // different employee -> returns false
        assertFalse(ALICE_REPORT.belongsTo(BOB));
    }

    @Test
    public void constructorRequiresNonNull() {
        assertThrows(NullPointerException.class, () -> new Report(
                null, "Alice's Report", "Alice's Report Description"));
        assertThrows(NullPointerException.class, () -> new Report(
                ALICE, null, "Alice's Report Description"));
        assertThrows(NullPointerException.class, () -> new Report(
                ALICE, "Alice's Report", null));
    }
}
