module Hotel {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens cafe to javafx.graphics, javafx.fxml;
}
