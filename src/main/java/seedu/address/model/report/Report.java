package seedu.address.model.report;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.time.LocalDateTime;
import java.util.Objects;

import seedu.address.model.person.Person;



/**
 * Represents a Performance Report of an employee in the address book
 */
public class Report {

    private static int reportIdCounter = 1;

    private final int reportId;
    private final Person employee;
    private final String title;
    private final String description;
    private final LocalDateTime lastModified;

    /**
     * Constructor for Report object. Takes in a Person object, title and description.
     * Requires all fields to be non-null.
     *
     * @param employee
     * @param title
     * @param description
     */
    public Report(Person employee, String title, String description) {
        requireAllNonNull(employee, title, description);
        this.reportId = reportIdCounter;
        this.employee = employee;
        this.title = title;
        this.description = description;
        this.lastModified = LocalDateTime.now();
        reportIdCounter++;
    }

    public int getReportId() {
        return reportId;
    }

    public Person getEmployee() {
        return employee;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public boolean belongsTo(Person employee) {
        return this.employee.equals(employee);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Report)) {
            return false;
        }

        Report otherReport = (Report) other;
        return otherReport.getEmployee().equals(getEmployee())
                && otherReport.getTitle().equals(getTitle())
                && otherReport.getDescription().equals(getDescription());
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Report ID: ")
                .append(getReportId())
                .append(" Employee: ")
                .append(getEmployee())
                .append(" Title: ")
                .append(getTitle())
                .append(" Modified: ")
                .append(getLastModified());
        return builder.toString();
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(reportId, employee, title, description);
    }

}
