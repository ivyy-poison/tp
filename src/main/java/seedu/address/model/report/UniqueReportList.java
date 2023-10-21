package seedu.address.model.report;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.report.exceptions.DuplicateReportException;
import seedu.address.model.person.exceptions.PersonNotFoundException;

public class UniqueReportList implements Iterable<Report> {
    private final ObservableList<Report> internalList = FXCollections.observableArrayList();
    private final ObservableList<Report> internalUnmodifiableList =
            FXCollections.unmodifiableObservableList(internalList);
    
    /**
     * Returns true if the list contains an equivalent report as the given argument.
     */
    public boolean contains(Report toCheck) {
        requireNonNull(toCheck);
        return internalList.stream().anyMatch(toCheck::isSameReport);
    }

    /**
     * Adds a report to the list.
     * The report must not already exist in the list.
     */
    public void add(Report toAdd) {
        requireNonNull(toAdd);
        if (contains(toAdd)) {
            throw new DuplicateReportException();
        }
        internalList.add(toAdd);
    }

    /**
     * Replaces the report {@code target} in the list with {@code editedReport}.
     * {@code target} must exist in the list.
     * The report identity of {@code editedReport} must not be the same as another existing report in the list.
     */
    public void setReport(Report target, Report editedReport) {
        requireAllNonNull(target, editedReport);

        int index = internalList.indexOf(target);
        if (index == -1) {
            throw new PersonNotFoundException();
        }

        if (!target.isSameReport(editedReport) && contains(editedReport)) {
            throw new DuplicateReportException();
        }

        internalList.set(index, editedReport);
    }

    public void setReports(UniqueReportList replacement) {
        requireNonNull(replacement);
        internalList.setAll(replacement.internalList);
    }

    /**
     * Replaces the contents of this list with {@code reports}.
     * {@code reports} must not contain duplicate reports.
     */
    public void setReports(List<Report> reports) {
        requireNonNull(reports);
        internalList.setAll(reports);
    }

    /**
     * Removes the equivalent report from the list.
     * The report must exist in the list.
     */
    public void remove(Report toRemove) {
        requireNonNull(toRemove);
        if (!internalList.remove(toRemove)) {
            throw new PersonNotFoundException();
        }
    }

    /**
     * Returns the backing list as an unmodifiable {@code ObservableList}.
     */
    public ObservableList<Report> asUnmodifiableObservableList() {
        return internalUnmodifiableList;
    }

    @Override
    public Iterator<Report> iterator() {
        return internalList.iterator();
    }

    @Override
    public int hashCode() {
        return internalList.hashCode();
    }

    /**
     * Returns true if {@code reports} contains only unique reports.
     */
    private boolean reportsAreUnique(List<Report> reports) {
        for (int i = 0; i < reports.size() - 1; i++) {
            for (int j = i + 1; j < reports.size(); j++) {
                if (reports.get(i).isSameReport(reports.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof UniqueReportList
                && internalList.equals(((UniqueReportList) other).internalList));
    }

    @Override
    public String toString() {
        return internalList.toString();
    }


}
