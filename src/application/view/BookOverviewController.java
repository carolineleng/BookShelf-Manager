package application.view;

import application.Main;
import application.model.Book;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

public class BookOverviewController {
    @FXML
    private TableView<Book> bookTable;
    @FXML
    private TableColumn<Book, String> gradeColumn;
    @FXML
    private TableColumn<Book, String> titleColumn;
    @FXML
    private TableColumn<Book, String> authorColumn;
    @FXML
    private TableColumn<Book, Integer> roomColumn;
    @FXML
    private TableColumn<Book, Integer> availableColumn;
    @FXML
    private TableColumn<Book, Integer> totalColumn;

    @FXML
    private Label titleLabel;
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label publisherLabel;
    @FXML
    private Label yearLabel;
    @FXML
    private Label ISBNLabel;
    @FXML
    private Label typeLabel;
    @FXML
    private Label priceLabel;
    @FXML
    private Label gradeLabel;
    @FXML
    private Label storageLabel;
    @FXML
    private Label availableLabel;
    @FXML
    private Label totalLabel;
    @FXML
    private Label missingLabel;
    
    @FXML
    private Button edit;
    @FXML
    private Button delete;

    // Reference to the main application.
    private Main main;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public BookOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	// Disable edit and delete buttons when no book selected.
    	edit.disableProperty().bind(bookTable.getSelectionModel().selectedItemProperty().isNull());
    	delete.disableProperty().bind(bookTable.getSelectionModel().selectedItemProperty().isNull());
    	
        // Initialize the book table with its columns.
    	gradeColumn.setCellValueFactory(cellData -> cellData.getValue().gradeProperty());
        titleColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
        authorColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        roomColumn.setCellValueFactory(cellData -> cellData.getValue().storageProperty().asObject());
        availableColumn.setCellValueFactory(cellData -> cellData.getValue().availableProperty().asObject());
        totalColumn.setCellValueFactory(cellData -> cellData.getValue().totalProperty().asObject());
        
        // Clear book details.
        showBookDetails(null);

        // Listen for selection changes and show the book details when changed.
        bookTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showBookDetails(newValue));
    }
    
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param main
     */
    public void setMain(Main main) {
        this.main = main;

        // Add observable list data to the table
        bookTable.setItems(main.getBookData());
    }
    
    /**
     * Fills all text fields to show details about the book.
     * If the specified book is null, all text fields are cleared.
     * 
     * @param book the book or null
     */
    private void showBookDetails(Book book) {
        if (book != null) {
            // Fill the labels with info from the book object.
            titleLabel.setText(book.getTitle());
        	firstNameLabel.setText(book.getFirstName());
            lastNameLabel.setText(book.getLastName());
            publisherLabel.setText(book.getPublisher());
            yearLabel.setText(""+book.getYear());
            ISBNLabel.setText(book.getISBN());
            typeLabel.setText(book.getType());
            priceLabel.setText(book.getPrice());
            gradeLabel.setText(book.getGrade());
            storageLabel.setText(""+book.getStorage());
            availableLabel.setText(""+book.getAvailable());
            totalLabel.setText(""+book.getTotal());
            missingLabel.setText(""+book.getMissing());
        } else {
            // Book is null, remove all the text.
            titleLabel.setText("Book Title");
        	firstNameLabel.setText("");
            lastNameLabel.setText("");
            publisherLabel.setText("");
            yearLabel.setText("");
            ISBNLabel.setText("");
            typeLabel.setText("");
            priceLabel.setText("");
            gradeLabel.setText("");
            storageLabel.setText("");
            availableLabel.setText("");
            totalLabel.setText("");
            missingLabel.setText("");
        }
    }
    
    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeleteBook() {
        int selectedIndex = bookTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            bookTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Book Selected");
            alert.setContentText("Please select a book in the table.");

            alert.showAndWait();
        }

    }
}