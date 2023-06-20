import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.KeyEvent;
import java.util.List;
import java.util.ArrayList;

public class GraphicsCalculator extends Application {
    Tokenizer tok = new Tokenizer();
    Label lb = new Label("");
    String s = "789+456-123*0.C/() =";
    
    public Button b(char b) {
    	Button but = new Button(String.valueOf(b));
    	but.setMinSize(30, 30);
    	but.setMaxSize(30, 30);
    	return but;    	
    }
    
    public void update(char c) {
    	if(c=='=') {
    		tok.readString(lb.getText()+c);
    		lb.setText(tok.calc.results.get(0).toString());
    	}
    	if(c=='C') {
    		tok.readString(lb.getText()+c);
    		lb.setText("");
    	}
    	else lb.setText(lb.getText()+c);
    }
        

    public void handlekey(KeyEvent e) {
    	if(s.contains(e.getCharacter())) {
    		if(e.getCharacter() != " ") {
    			update(e.getCharacter().charAt(0));
    		}
    	}
    }
    
    @Override
    public void start(Stage stage) {
    	 stage.setTitle("Fenetre");
     	stage.setHeight(400);
     	stage.setWidth(400);
    	stage.show();
        // TODO
        HBox hb1 = new HBox();
        HBox hb2 = new HBox();
        HBox hb3 = new HBox();
        HBox hb4 = new HBox();
        HBox hb5 = new HBox();
        
        List<HBox> boxlist = new ArrayList<>();
        boxlist.add(hb1);
        boxlist.add(hb2);
        boxlist.add(hb3);
        boxlist.add(hb4);
        boxlist.add(hb5);
        
        
        for(int i = 0; i< s.length(); i++) {  
        	final int j = i;
        	Button b = b(s.charAt(i));
        	if(s.charAt(j) == ' ') {
        		b.setOnAction(value -> update('\0'));	
        	}
        	else {
        		b.setOnAction(value -> update(s.charAt(j)));
        	}
        		boxlist.get(i/4).getChildren().add(b);        		
        	
        }        
        //scene.setOnKeyTyped(e      -> handlekey(e));
        
        Scene scene = new Scene(new VBox(new HBox(lb),hb1,hb2,hb3,hb4,hb5));
        
        scene.setOnKeyTyped(e -> handlekey(e));
        
        stage.setScene(scene);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}