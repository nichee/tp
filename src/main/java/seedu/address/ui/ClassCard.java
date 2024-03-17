package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.person.Classes;
import seedu.address.model.person.Person;

import java.util.Comparator;

public class ClassCard extends UiPart<Region> {

    private static final String FXML = "ClassListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Classes classes;

    @javafx.fxml.FXML
    private HBox cardPane;
    @FXML
    private Label id;
    @FXML
    private Label courseCode;

    /**
     * Creates a {@code PersonCode} with the given {@code Person} and index to display.
     */
    public ClassCard(Classes classes, int displayedIndex) {
        super(FXML);
        this.classes = classes;
        id.setText(displayedIndex + ". ");
        courseCode.setText(classes.getCourseCode().courseCode);
    }
}
