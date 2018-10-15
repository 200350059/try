



        import javafx.fxml.FXML;
        import javafx.fxml.Initializable;
        import javafx.scene.control.TableColumn;
        import javafx.scene.control.TableView;
        import javafx.scene.control.TextField;
        import javafx.scene.control.cell.PropertyValueFactory;
        import javafx.scene.image.Image;

        import java.net.URL;
        import java.sql.Blob;
        import java.sql.SQLException;
        import java.util.ResourceBundle;

public class tableController implements Initializable {
    @FXML
    private TableView<TV> tableView;

    @FXML
    private TableColumn<TV, String> brandColumn;

    @FXML
    private TableColumn<TV, Integer> sizeColumn;

    @FXML
    private TableColumn<TV, Integer> priceColumn;

    @FXML
    private TableColumn<TV, Blob> imageColumn;

    @FXML
    private TextField searchBar;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // configure the table columns
        brandColumn.setCellValueFactory(new PropertyValueFactory<TV, String>("brand"));
        sizeColumn.setCellValueFactory(new PropertyValueFactory<TV, Integer>("size"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<TV, Integer>("price"));
        imageColumn.setCellValueFactory(new PropertyValueFactory<TV, Blob>("image"));


        try {
            tableView.getItems().addAll(DBConnect.getAllTV());
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void search() {

        //   try {
    //    brandColumn.setCellValueFactory(new PropertyValueFactory<TV, String>(""));
     //   sizeColumn.setCellValueFactory(new PropertyValueFactory<TV, Integer>(""));
     //   priceColumn.setCellValueFactory(new PropertyValueFactory<TV, Integer>(""));
 //       imageColumn.setCellValueFactory(new PropertyValueFactory<TV, Blob>(""));


        try {
            tableView.getItems().addAll(DBConnect.searchName(searchBar.getText()));
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        }
    }

