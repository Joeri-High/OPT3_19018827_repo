package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import sample.ViewNavigator;
import sample.db.db_helper;
import sample.models.*;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ReservationScreenController implements Initializable {

    db_helper db_helper = new db_helper();

    @FXML
    private TableView<Room> roomsTable;

    @FXML
    private TableColumn<Room, Integer> roomNumber;

    @FXML
    private TableColumn<Room, String> luxeRoom;

    @FXML
    private TableColumn<Room, String> seaView;

    @FXML
    private TextField stayingDays;

    @FXML
    private TextField selectRoomNumber;

    @FXML
    private TextField emailAdres;

    @FXML
    private CheckBox breakfastIncluded;

    public ReservationScreenController()
    {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        roomNumber.setCellValueFactory(new PropertyValueFactory<Room, Integer>("roomNumber"));
        luxeRoom.setCellValueFactory(new PropertyValueFactory<Room, String>("luxeRoom"));
        seaView.setCellValueFactory(new PropertyValueFactory<Room, String>("seaView"));

        try {
            roomsTable.getItems().setAll(parseRoomList());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private List<Room> parseRoomList() throws SQLException
    {
        List<Room> rooms = new ArrayList<Room>();
        try {
            ResultSet resultSet = db_helper.getResultSetFromDB("SELECT roomNumber, luxeRoom, seaView FROM room");
            int i = 0;
            while (resultSet.next())
            {
                Hotel hotel = new Hotel();
                Room room = new Room(true, true, hotel);
                room.setRoomNumber(resultSet.getInt(1));
                room.setLuxeRoom(resultSet.getBoolean(2));
                room.setSeaView(resultSet.getBoolean(3));
                rooms.add(room);
                i++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rooms;
    }

    @FXML
    private void makeReservation()
    {
        int stayingDays = Integer.parseInt(this.stayingDays.getText());
        int roomNumber = Integer.parseInt(this.selectRoomNumber.getText());
        boolean breakfast = true;
        if (!breakfastIncluded.isSelected())
        {
            breakfast = false;
        }
//        Reservation reservation = new Reservation(,)
    }
}
