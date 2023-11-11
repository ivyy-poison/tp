package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.FindLeaveCommand;


public class FindLeaveCommandParserTest {
    private static final String MESSAGE_INVALID_FORMAT =
            String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindLeaveCommand.MESSAGE_USAGE);
    private FindLeaveCommandParser parser = new FindLeaveCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindLeaveCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsFindCommand() {
        Index targetIndex = INDEX_FIRST_PERSON;
        String userInput = String.valueOf(targetIndex.getOneBased());
        FindLeaveCommand expectedCommand = new FindLeaveCommand(targetIndex);
        assertParseSuccess(parser, userInput, expectedCommand);

        // ignore arguments being parsed as preamble
        userInput = targetIndex.getOneBased() + " some random string";
        assertParseSuccess(parser, userInput, expectedCommand);

        // ignore prefix being parsed as prea,ble
        userInput = targetIndex.getOneBased() + " i/ string";
        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_invalidTags_throwsParseException() {
        // negative index
        assertParseFailure(parser, "-5", MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);

        // zero index
        assertParseFailure(parser, "0", MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);

        // non-numeric indices
        assertParseFailure(parser, "abc", MESSAGE_INVALID_FORMAT);
        assertParseFailure(parser, "1abc", MESSAGE_INVALID_FORMAT);
        assertParseFailure(parser, "abc 10", MESSAGE_INVALID_FORMAT);

        // out-of-bound index
        String intMaxPlusOne = Long.toString((long) Integer.MAX_VALUE + 1);
        assertParseFailure(parser, intMaxPlusOne, MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
    }
}
