package edu.training.web.command;

/**
 * Created by Roman on 25.11.2016.
 */
public enum CommandEnum {
    PARSE {
        {
            this.command = new ParsingCommand();
        }
    },
    CHANGE_LANG {
        {
            this.command = new LanguageCommand();
        }
    },
    EMPTY {
        {
            this.command = new EmptyCommand();
        }
    },
    UPLOAD {
        {
            this.command = new UploadCommand();
        }
    };
    ActionCommand command;
    public ActionCommand getCurrentCommand() {
        return command;
    }

}
