package seedu.address.storage;

import static java.util.Objects.requireNonNull;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataLoadingException;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.commons.util.FileUtil;
import seedu.address.commons.util.JsonUtil;
import seedu.address.model.ReadOnlyReportBook;

/**
 * A class to access ReportBook data stored as a json file on the hard disk.
 */
public class JsonReportBookStorage implements ReportBookStorage {

    public final Logger logger = LogsCenter.getLogger(JsonReportBookStorage.class);

    private Path filePath;

    public JsonReportBookStorage(Path filePath) {
        this.filePath = filePath;
    }

    public Path getReportBookFilePath() {
        return filePath;
    }

    @Override
    public Optional<ReadOnlyReportBook> readReportBook() throws DataLoadingException {
        return readReportBook(filePath);
    }

    /**
     * Similar to {@link #readReportBook()}.
     *
     * @param filePath location of the data. Cannot be null.
     * @throws DataLoadingException if loading the data from storage failed.
     */
    public Optional<ReadOnlyReportBook> readReportBook(Path filePath) throws DataLoadingException {
        requireNonNull(filePath);

        Optional<JsonSerializableReportBook> jsonReportBook = JsonUtil.readJsonFile(
                filePath, JsonSerializableReportBook.class);
        if (jsonReportBook.isEmpty()) {
            return Optional.empty();
        }

        try {
            return Optional.of(jsonReportBook.get().toModelType());
        } catch (IllegalValueException ive) {
            logger.info("Illegal values found in " + filePath + ": " + ive.getMessage());
            throw new DataLoadingException(ive);
        }
    }

    @Override
    public void saveReportBook(ReadOnlyReportBook reportBook) throws IOException {
        saveReportBook(reportBook, filePath);
    }

    /**
     * Similar to {@link #saveReportBook(ReadOnlyReportBook)}.
     *
     * @param filePath location of the data. Cannot be null.
     */
    public void saveReportBook(ReadOnlyReportBook reportBook, Path filePath) throws IOException {
        requireNonNull(reportBook);
        requireNonNull(filePath);

        FileUtil.createIfMissing(filePath);
        JsonUtil.saveJsonFile(new JsonSerializableReportBook(reportBook), filePath);
    }
}
