package seedu.address.testutil;

import static seedu.address.testutil.TypicalPersons.ALICE;

import seedu.address.model.person.Person;
import seedu.address.model.report.Report;

/**
 * A utility class to help with building Report objects.
 */
public class ReportBuilder {

    public static final String DEFAULT_TITLE = "Alice's Report";
    public static final String DEFAULT_DESCRIPTION = "Alice's Report Description";
    public static final Person DEFAULT_PERSON = ALICE;

    private String title;
    private String description;
    private Person employee;

    /**
    * Creates a {@code ReportBuilder} with the default details.
    */
    public ReportBuilder() {
        title = DEFAULT_TITLE;
        description = DEFAULT_DESCRIPTION;
        employee = DEFAULT_PERSON;
    }

    /**
    * Initializes the ReportBuilder with the data of {@code reportToCopy}.
    */
    public ReportBuilder(Report reportToCopy) {
        employee = reportToCopy.getEmployee();
        title = reportToCopy.getTitle();
        description = reportToCopy.getDescription();
    }

    /**
    * Sets the {@code Title} of the {@code Report} that we are building.
    */
    public ReportBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    /**
    * Sets the {@code Description} of the {@code Report} that we are building.
    */
    public ReportBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public Report build() {
        return new Report(employee, title, description);
    }

}
