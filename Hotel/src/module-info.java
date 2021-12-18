module Hotel {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.sql;
	
	opens cafe to javafx.graphics, javafx.fxml;
}
