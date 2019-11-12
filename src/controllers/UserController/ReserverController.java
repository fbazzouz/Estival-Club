package controllers.UserController;

import animatefx.animation.BounceInDown;
import animatefx.animation.FadeIn;
import animatefx.animation.Pulse;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import com.jfoenix.controls.JFXComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;


public class ReserverController  {


    public String ReservationType = "";
    public String RestaurationType = "";
    public int ReservationPrix = 0;
    public int RestaurationPrix =0;
    public Label LB_Etape1;

    public AnchorPane AP_Appartement;
    public AnchorPane AP_Bongalow;
    public AnchorPane AP_Caravane;
    public AnchorPane AP_FormulaireReservation;

    public ImageView Img1 = new ImageView();
    public ImageView Img2 = new ImageView();
    public ImageView Img3 = new ImageView();

    public Button BTN_Appartement;
    public Button BTN_Bongalow;
    public Button BTN_Caravane;
    public Button BTN_SemiPension;
    public Button BTN_PensionComplete;
    public Button BTN_RestaurationPersonnelle;

    public JFXComboBox TF_TypeHebergement;
    public JFXComboBox TF_TypeRestauration;
    public JFXComboBox TF_NbPersonnes;

    public DatePicker DP_DateArrivee;
    public DatePicker DP_DateDepart;
    public Label LB_Etape4;
    public Label LB_Etape3;
    public Label LB_Etape2;
    public Label LB_total;
    public JFXComboBox TF_TypePaiement;
    public double total;
    public double taux=1;
    public Label LB_Paye;
    public int nbr;

    public void initialize() {
        TF_TypePaiement.valueProperty().addListener(new ChangeListener<String>() {
            @Override public void changed(ObservableValue ov, String t, String t1) {
                if(t1.equals("20% du Prix")) {
                    taux = 0.2;
                    LB_Paye.setText(Double.toString(total * taux));
                }
                else {
                    taux=1;
                    LB_Paye.setText(Double.toString(total * taux));
                }

            }
        });
        TF_NbPersonnes.valueProperty().addListener(new ChangeListener<String>() {
            @Override public void changed(ObservableValue ov, String t, String t1) {
                nbr=Integer.parseInt(t1);
                total=(ReservationPrix+RestaurationPrix)*nbr;
                LB_Paye.setText(Double.toString(total*taux));
            }
        });
        TF_TypeHebergement.valueProperty().addListener(new ChangeListener<String>() {
            @Override public void changed(ObservableValue ov, String t, String t1) {
                if(t1.equals("Bungalow")) {
                    ReservationPrix=400;
                    total = (ReservationPrix+RestaurationPrix)*nbr;
                    LB_Paye.setText(Double.toString(total*taux));
                }
                else if(t1.equals("Appartement")) {
                    ReservationPrix = 300;
                    total = (ReservationPrix + RestaurationPrix)*nbr ;
                    LB_Paye.setText(Double.toString(total*taux));
                }
                else if(t1.equals("Caravane")){
                    ReservationPrix = 350;
                    total = (ReservationPrix + RestaurationPrix)*nbr ;
                    LB_Paye.setText(Double.toString(total*taux));
                }
            }
        });
        TF_TypeRestauration.valueProperty().addListener(new ChangeListener<String>() {
            @Override public void changed(ObservableValue ov, String t, String t1) {
                if(t1.equals("Demi Pension")) {
                    RestaurationPrix=50;
                    total = (ReservationPrix+RestaurationPrix)*nbr ;
                    LB_Paye.setText(Double.toString(total*taux));
                }
                else if(t1.equals("Pension Complete")) {
                    RestaurationPrix = 100;
                    total = (ReservationPrix + RestaurationPrix)*nbr ;
                    LB_Paye.setText(Double.toString(total*taux));
                }
                else if(t1.equals("Restauration Personnelle")){
                    RestaurationPrix = 70;
                    total = (ReservationPrix + RestaurationPrix)*nbr ;
                    LB_Paye.setText(Double.toString(total*taux));
                }
            }
        });

    }
    public void BTN_Appartement_Clicked(ActionEvent actionEvent) {
        ReservationType = "Appartement";
        ReservationPrix = 300;
        etape2();


    }

    public void BTN_Bongalow_Clicked(ActionEvent actionEvent) {
        ReservationType = "Bungalow";
        ReservationPrix = 400;
        etape2();

    }

    public void BTN_Caravane_Clicked(ActionEvent actionEvent) {
        ReservationType = "Caravane";
        ReservationPrix = 350;
        etape2();

    }

    public void BTN_SemiPension_Clicked(ActionEvent actionEvent) {
        RestaurationType="Demi Pension";
        RestaurationPrix = 50;
        etape3();

    }

    public void BTN_PensionComplete_Clicked(ActionEvent actionEvent) {
        RestaurationType="Pension Complete";
        RestaurationPrix = 100;
        etape3();
    }
    public void BTN_RestaurationPersonnelle_Clicked(ActionEvent actionEvent) {
        RestaurationType="Restauration Personnelle";
        RestaurationPrix = 70;
        etape3();
    }

    public void etape3() {
        LB_Etape3.setTextFill(Color.web("#c49018"));
        LB_Etape2.setTextFill(Color.web("#ffffff"));
        new FadeIn(LB_total).play();
        LB_total.setText(Integer.toString(ReservationPrix+RestaurationPrix));
        AP_Caravane.setVisible(false);
        AP_Appartement.setVisible(false);
        AP_Bongalow.setVisible(false);
        new BounceInDown(AP_FormulaireReservation).play();
        AP_FormulaireReservation.setVisible(true);

        TF_TypeRestauration.setValue(RestaurationType);
        TF_TypeHebergement.setValue(ReservationType);
    }
    public void etape2() {
        LB_Etape2.setTextFill(Color.web("#c49018"));
        LB_Etape1.setTextFill(Color.web("#ffffff"));
        new FadeIn(LB_total).play();
        LB_total.setText(Integer.toString(ReservationPrix));
        Image image = new Image("file:src/images/petit_dejeuner.jpg");
        Img1.setImage(image);
        image = new Image("file:src/images/repas.png");
        Img2.setImage(image);
        image = new Image("file:src/images/roomservice.jpg");
        Img3.setImage(image);
        BTN_Appartement.setVisible(false);
        BTN_Bongalow.setVisible(false);
        BTN_Caravane.setVisible(false);
        BTN_SemiPension.setVisible(true);
        BTN_PensionComplete.setVisible(true);
        BTN_RestaurationPersonnelle.setVisible(true);
        new Pulse(AP_Appartement).play();
        new Pulse(AP_Caravane).play();
        new Pulse(AP_Bongalow).play();
        new Pulse(BTN_PensionComplete).play();
        new Pulse(BTN_SemiPension).play();
        new Pulse(BTN_RestaurationPersonnelle).play();
    }


    public void ChangerTypeHebergement(ActionEvent actionEvent) {
        ReservationType = TF_TypeHebergement.toString();
    }

    public void ChangerTypeRestauration(ActionEvent actionEvent) {
        RestaurationType = TF_TypeRestauration.toString();
    }

    public void BTN_Enregistrer(ActionEvent actionEvent) {
    }

    public void BTN_Réinitialiser(ActionEvent actionEvent) {

    }


}
