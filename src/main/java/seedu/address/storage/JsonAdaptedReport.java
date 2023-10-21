package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.report.Report;

/**
 * Jackson-friendly version of {@link Report}.
 */
public class JsonAdaptedReport {
    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Report's %s field is missing!";

    private final int reportId;
    private final JsonAdaptedPerson employee;
    private final String title;
    private final String description;
    private final String lastModified;

    /**
     * Constructs a {@code JsonAdaptedReport} with the given report details.
     */
    @JsonCreator
    public JsonAdaptedReport(@JsonProperty("reportId") int reportId,
                             @JsonProperty("employee") JsonAdaptedPerson employee,
                             @JsonProperty("title") String title,
                             @JsonProperty("description") String description,
                             @JsonProperty("lastModified") String lastModified) {
        this.reportId = reportId;
        this.employee = employee;
        this.title = title;
        this.description = description;
        this.lastModified = lastModified;
    }

    /**
     * Converts a given {@code Report} into this class for Jackson use.
     */
    public JsonAdaptedReport(Report source) {
        reportId = source.getReportId();
        employee = new JsonAdaptedPerson(source.getEmployee());
        title = source.getTitle();
        description = source.getDescription();
        lastModified = source.getLastModified().toString();
    }

    /**
     * Converts this Jackson-friendly adapted report object into the model's {@code Report} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted report.
     */
    public Report toModelType() throws IllegalValueException {
        if (reportId < 1) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "reportId"));
        }
        if (employee == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "employee"));
        }
        if (lastModified == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "lastModified"));
        }
        if (title == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "title"));
        }
        return new Report(employee.toModelType(), title, description);
    }

}
