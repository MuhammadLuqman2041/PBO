package data;

import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class map{

    private static final String GOOGLE_MAPS_URL = "https://widya-bahana-suara.perpusnas.go.id/live?type=http&nocache=1";

    public void mapPerpus(){

        Stage Mapstage = new Stage();
        Mapstage.setTitle("UMM Library - Admin Menu");
        WebView webView = new WebView();
        webView.getEngine().load(GOOGLE_MAPS_URL);

        Scene scene =  new Scene(webView,1280,720);
        Mapstage.setScene(scene);
        Mapstage.show();
    }
}
