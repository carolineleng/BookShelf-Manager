package application.model;

import javafx.beans.property.*;

public class Book {

    private StringProperty title;
	private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty publisher;
    private IntegerProperty year;
    private StringProperty ISBN;
    private StringProperty type;
    private StringProperty price;
    private StringProperty grade;
    private IntegerProperty storage;
    private IntegerProperty available;
    private IntegerProperty total;
    private IntegerProperty missing;
    
    public Book(){
    	this(null,null, null, null, 0, null, null, 0, null, 0, 0, 0, 0);
    }

    public Book(String title, String firstName, String lastName, String publisher, int year, String ISBN, String type, double price, String grade, int storage, int available, int total, int missing) {
    	setTitle(title);
    	setFirstName(firstName);
    	setLastName(lastName);
    	setPublisher(publisher);
    	setYear(year);
    	setISBN(ISBN);
    	setType(type);
    	setPrice(price);
    	setGrade(grade);
    	setStorage(storage);
    	setAvailable(available);
    	setTotal(total);
    	setMissing(missing);
    }

	public String getTitle() {
		return title.get();
	}

	public void setTitle(String title) {
		this.title = new SimpleStringProperty(title);
	}
	
	public StringProperty titleProperty(){
		return title;
	}

	public String getFirstName() {
		return firstName.get();
	}

	public void setFirstName(String firstName) {
		this.firstName = new SimpleStringProperty(firstName);
	}
	
	public StringProperty firstNameProperty(){
		return firstName;
	}

	public String getLastName() {
		return lastName.get();
	}

	public void setLastName(String lastName) {
		this.lastName = new SimpleStringProperty(lastName);
	}

	public StringProperty lastNameProperty(){
		return lastName;
	}
	
	public String getPublisher() {
		return publisher.get();
	}

	public void setPublisher(String publisher) {
		this.publisher = new SimpleStringProperty(publisher);
	}
	
	public StringProperty publisherProperty(){
		return publisher;
	}

	public int getYear() {
		return year.get();
	}

	public void setYear(int year) {
		this.year = new SimpleIntegerProperty(year);
	}
	
	public IntegerProperty yearProperty(){
		return year;
	}

	public String getISBN() {
		return ISBN.get();
	}

	public void setISBN(String ISBN) {
		this.ISBN = new SimpleStringProperty(ISBN);
	}
	
	public StringProperty ISBNProperty(){
		return ISBN;
	}

	public String getType() {
		return type.get();
	}

	public void setType(String type) {
		this.type = new SimpleStringProperty(type);
	}
	
	public StringProperty typeProperty(){
		return type;
	}

	public String getPrice() {
		return price.get();
	}

	public void setPrice(double price) {
		this.price = new SimpleStringProperty("$"+price);
	}
	
	public StringProperty priceProperty(){
		return price;
	}

	public String getGrade() {
		return grade.get();
	}

	public void setGrade(String grade) {
		this.grade = new SimpleStringProperty(grade);
	}
	
	public StringProperty gradeProperty(){
		return grade;
	}

	public int getStorage() {
		return storage.get();
	}

	public void setStorage(int storage) {
		this.storage = new SimpleIntegerProperty(storage);
	}
	
	public IntegerProperty storageProperty(){
		return storage;
	}

	public int getAvailable() {
		return available.get();
	}

	public void setAvailable(int available) {
		this.available = new SimpleIntegerProperty(available);
	}
	
	public IntegerProperty availableProperty(){
		return available;
	}

	public int getTotal() {
		return total.get();
	}

	public void setTotal(int total) {
		this.total = new SimpleIntegerProperty(total);
	}
	
	public IntegerProperty totalProperty(){
		return total;
	}

	public int getMissing() {
		return missing.get();
	}

	public void setMissing(int missing) {
		this.missing = new SimpleIntegerProperty(missing);
	}
	
	public IntegerProperty missingProperty(){
		return missing;
	}
    
}