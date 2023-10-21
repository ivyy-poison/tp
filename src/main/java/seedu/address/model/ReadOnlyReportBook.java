package seedu.address.model;

import javafx.collections.ObservableList;
import seedu.address.model.report.Report;

/**
 * Unmodifiable view of an address book
 */
public interface ReadOnlyReportBook {

    /**
     * Returns an unmodifiable view of the persons list.
     * This list will not contain any duplicate persons.
     */
    ObservableList<Report> getReportList();

}
