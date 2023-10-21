package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.ObservableList;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.report.Report;
import seedu.address.model.report.UniqueReportList;

/**
 * Wraps all data at the report-book level
* Duplicates are not allowed (by .isSameReport comparison)
 */
public class ReportBook implements ReadOnlyReportBook {

    private final UniqueReportList reports;

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        reports = new UniqueReportList();
    }

    public ReportBook() {}

    /**
     * Creates an ReportBook using the Reports in the {@code toBeCopied}
     */
    public ReportBook(ReadOnlyReportBook toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    //// list overwrite operations
    
    /**
     * Replaces the contents of the report list with {@code reports}.
     * {@code reports} must not contain duplicate reports.
     */
    public void setReports(List<Report> reports) {
        this.reports.setReports(reports);
    }

    /**
     * Resets the existing data of this {@code ReportBook} with {@code newData}.
     */
    public void resetData(ReadOnlyReportBook newData) {
        requireNonNull(newData);

        setReports(newData.getReportList());
    }

    //// report-level operations

    /**
     * Returns true if a report with the same identity as {@code report} exists in the report book.
     */
    public boolean hasReport(Report report) {
        requireNonNull(report);
        return reports.contains(report);
    }

    /**
     * Adds a report to the report book.
     * The report must not already exist in the report book.
     */
    public void addReport(Report r) {
        reports.add(r);
    }

    /**
     * Replaces the given report {@code target} in the list with {@code editedReport}.
     * {@code target} must exist in the report book.
     * The report identity of {@code editedReport} must not be the same as another existing report in the report book.
     */
    public void setReport(Report target, Report editedReport) {
        requireNonNull(editedReport);

        reports.setReport(target, editedReport);
    }

    /**
     * Removes {@code key} from this {@code ReportBook}.
     * {@code key} must exist in the report book.
     */
    public void removeReport(Report key) {
        reports.remove(key);
    }

    //// util methods

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("reports", reports.asUnmodifiableObservableList())
                .toString();
    }

    @Override
    public ObservableList<Report> getReportList() {
        return reports.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals (Object other) {
        return other == this // short circuit if same object
                || (other instanceof ReportBook // instanceof handles nulls
                && reports.equals(((ReportBook) other).reports));
    }

    @Override
    public int hashCode() {
        return reports.hashCode();
    }

}
