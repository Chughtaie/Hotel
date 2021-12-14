module Hotel {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	
	opens cafe to javafx.graphics, javafx.fxml;
}
