package seedu.address.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalReports.getTypicalReportBook;

import java.util.Collections;

import org.junit.jupiter.api.Test;

public class ReportBookTest {

    private final ReportBook reportBook = new ReportBook();

    @Test
    public void constructor() {
        assertEquals(Collections.emptyList(), reportBook.getReportList());
    }

    @Test
    public void resetData_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> reportBook.resetData(null));
    }

    @Test
    public void resetData_withValidReadOnlyReportBook_replacesData() {
        ReportBook newData = getTypicalReportBook();
        reportBook.resetData(newData);
        assertEquals(newData, reportBook);
    }
    
}
