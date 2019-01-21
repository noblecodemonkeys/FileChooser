package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.awt.*;
import java.io.Console;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class Controller implements Initializable
{
    @FXML
    VBox vbMenu;


    FileChooser fileChooser = new FileChooser();

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        fileChooser.setInitialDirectory(new File("C:\\temp"));
    }


    @FXML
    private void handleSaveClicked(ActionEvent event)
    {
        Window stage = vbMenu.getScene().getWindow();
        fileChooser.setTitle("Save Dialog");
        fileChooser.setInitialFileName("mysave");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("text file", "*.txt"),
                new FileChooser.ExtensionFilter("pdf", "*.pdf"));


        try
        {
            File file = fileChooser.showSaveDialog(stage);
            fileChooser.setInitialDirectory(file.getParentFile());//save the chosen directory
            //TODO save file
        }
        catch (Exception ex)
        {

        }
    }

    @FXML
    private void handleLoadClicked(ActionEvent event)
    {
        Window stage = vbMenu.getScene().getWindow();
        fileChooser.setTitle("Load Dialog");

        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("text file", "*.txt", "*.docx", "*.doc"),
                new FileChooser.ExtensionFilter("pdf", "*.pdf"),
                new FileChooser.ExtensionFilter("images", "*.jpg", "*.png", "*.gif"));


        try
        {
            File file = fileChooser.showOpenDialog(stage);

            //TODO load file

            if (file != null)
            {
                File loadFile = file.getParentFile();
                fileChooser.setInitialDirectory(loadFile);
                String name = file.getName();
                String[] n = name.split("\\.");
                if (!n[0].isEmpty())
                {
                    //handle loading the file appropriately.

                }


            }
        }
        catch (Exception ex)
        {

        }
        //alternately, you could allow the user to select multiple files.
//        List<File> files = fileChooser.showOpenMultipleDialog(stage);
//        {
//            if(files != null)
//            {
//                for(File f :files)
//                {
//                    //open files
//                }
//            }
//        }

    }
}
