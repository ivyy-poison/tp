package seedu.address.model.report.exceptions;

/**
 * Signals that the operation will result in duplicate Reports (Reports are 
 * considered duplicates if they have the same identity).
 */
public class DuplicateReportException extends RuntimeException {
    public DuplicateReportException() {
        super("Operation would result in duplicate reports");
    }
}
