package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataLoadingException;
import seedu.address.model.ReadOnlyReportBook;

/**
 * Represents a storage for {@link seedu.address.model.ReportBook}.
 */
public interface ReportBookStorage {
    
    /**
    * Returns the file path of the data file.
    */
    Path getReportBookFilePath();

    /**
    * Returns ReportBook data as a {@link ReadOnlyReportBook}.
    * Returns {@code Optional.empty()} if storage file is not found.
    *
    * @throws DataLoadingException if loading the data from storage failed.
    */
    Optional<ReadOnlyReportBook> readReportBook() throws DataLoadingException;

    /**
    * @see #getReportBookFilePath()
    */
    Optional<ReadOnlyReportBook> readReportBook(Path filePath) throws DataLoadingException;

    /**
    * Saves the given {@link ReadOnlyReportBook} to the storage.
    * @param reportBook cannot be null.
    * @throws IOException if there was any problem writing to the file.
    */
    void saveReportBook(ReadOnlyReportBook reportBook) throws IOException;

    /**
    * @see #saveReportBook(ReadOnlyReportBook)
    */
    void saveReportBook(ReadOnlyReportBook reportBook, Path filePath) throws IOException;
    
}
