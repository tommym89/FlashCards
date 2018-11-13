package com.mcneelat.flashcards;

import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FXMLController implements Initializable {

    @FXML
    private Button loadFileButton;

    @FXML
    private AnchorPane appPane;

    @FXML
    private Pane currentCardPane;

    @FXML
    private Label currentCardMessage;

    private List<String[]> cardsList = new LinkedList<>();

    private boolean displayQuestion = true;

    private int currentCardIndex = -1;
    private String[] currentCard;

    @FXML
    private void loadFileButtonAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Flashcards JSON File");
        File inputFile = fileChooser.showOpenDialog(new Stage());
        this.loadFlashcards(inputFile);
    }

    private void loadFlashcards(File inputFile) {
        try {
            JSONObject jsonObject = (JSONObject) new JSONParser().parse(new FileReader(inputFile));
            JSONArray cards = (JSONArray) jsonObject.get("cards");
            Iterator<Object> iterator = cards.iterator();
            while (iterator.hasNext()) {
                JSONObject obj = (JSONObject) iterator.next();
                String[] qa = new String[]{(String) obj.get("question"), (String) obj.get("answer")};
                cardsList.add(qa);
            }
            currentCardPane.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    @FXML
    private void displayNextCard(ActionEvent event) {
        if (displayQuestion) {
            currentCardIndex++;
            if (currentCardIndex >= cardsList.size()) {
                currentCardIndex = 0;
            }
            currentCard = cardsList.get(currentCardIndex);
            currentCardMessage.setText(currentCard[0]);
        } else {
            currentCardMessage.setText(currentCard[1]);
        }
        displayQuestion = !displayQuestion;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
