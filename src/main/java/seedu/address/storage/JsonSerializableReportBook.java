package seedu.address.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.ReportBook;
import seedu.address.model.ReadOnlyReportBook;
import seedu.address.model.report.Report;

/**
 * An Immutable ReportBook that is serializable to JSON format.
 */
@JsonRootName(value = "reportbook")
class JsonSerializableReportBook {

    public static final String MESSAGE_DUPLICATE_REPORT = "Reports list contains duplicate report(s).";

    private final List<JsonAdaptedReport> reports = new ArrayList<>();
    
    /**
     * Constructs a {@code JsonSerializableReportBook} with the given reports.
     */
    @JsonCreator
    public JsonSerializableReportBook(@JsonProperty("reports") List<JsonAdaptedReport> reports) {
        this.reports.addAll(reports);
    }

    /**
     * Converts a given {@code ReadOnlyReportBook} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableReportBook}.
     */
    public JsonSerializableReportBook(ReadOnlyReportBook source) {
        reports.addAll(source.getReportList().stream().map(JsonAdaptedReport::new).collect(Collectors.toList()));
    }

    /**
     * Converts this report book into the model's {@code ReportBook} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public ReportBook toModelType() throws IllegalValueException {
        ReportBook reportBook = new ReportBook();
        for (JsonAdaptedReport jsonAdaptedReport : reports) {
            Report report = jsonAdaptedReport.toModelType();
            // reportBook.addReport(employee, title, description);
        }
        return reportBook;
    }
}
