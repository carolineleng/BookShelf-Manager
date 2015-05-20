package application;

import application.model.Book;
import application.view.BookOverviewController;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;


    /**
     * The data as an observable list of Books.
     */
    private ObservableList<Book> bookData = FXCollections.observableArrayList();

    /**
     * Constructor
     */
    public Main() {
        // Testing Data, here is where we will eventually put the code that reads in the excel
        bookData.add(new Book("Declaration of Independence", "Thomas","Jefferson","Colonials",1776,"123-456-78","Sheet",99.99,"10",28,10,16,0));
        bookData.add(new Book("Harry Potter and Sorcer Stone", "J.K.","Rowling","Scholastic",1992,"101-232-544","Hard Cover",18.99,"AP",33,24,48,3));
        bookData.add(new Book("Something", "Dumb","Boy","Pub",2015,"555-555-55","That",3.14,"01",33,44,55,0));
    }


    
    /**
     * Returns the data as an observable list of Books. 
     * @return
     */
    public ObservableList<Book> getBookData() {
        return bookData;
    }

    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("BookShelf Manager");

        // Set the application icon.
        this.primaryStage.getIcons().add(new Image("https://cdn2.iconfinder.com/data/icons/windows-8-metro-style/32/book_stack.png"));

        initRootLayout();

        showBookOverview();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the book overview inside the root layout.
     */
    public void showBookOverview() {
        try {
            // Load book overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/BookOverview.fxml"));
            AnchorPane bookOverview = (AnchorPane) loader.load();

            // Set book overview into the center of root layout.
            rootLayout.setCenter(bookOverview);

            // Give the controller access to the main class.
            BookOverviewController controller = loader.getController();
            controller.setMain(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}