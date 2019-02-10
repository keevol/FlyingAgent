import controllers.HomeController;
import jade.domain.FIPAException;
import javafx.application.Application;

import agents.ReceiverAgent;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;

import agents.MobileAgent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Launcher extends Application {

    private static final String MAIN_CONTAINER_HOST_IP = "192.168.137.188";
    private static final int MAIN_CONTAINER_PORT = 1099;
    private static final String PLATFORM_ID = "FlyingAgents";
    private static AgentContainer mc;

//    public Launcher() {
//
//        try {
//            // Get a hold on JADE runtime
//            Runtime rt = Runtime.instance();
//
//            // Exit the JVM when there are no more containers around
//            rt.setCloseVM(true);
//
//            // Launch a complete platform on the 8888 port
//            // create a default Profile
//            Profile pMain = new ProfileImpl(MAIN_CONTAINER_HOST_IP, MAIN_CONTAINER_PORT, PLATFORM_ID);
//
//            System.out.println("Launching a whole in-process platform..." + pMain);
//            mc = rt.createMainContainer(pMain);
//
//            AgentController receiverAgent = mc.createNewAgent(ReceiverAgent.NAME, ReceiverAgent.class.getName(), new Object[]{});
//            receiverAgent.start();
//
//            AgentController rma = mc.createNewAgent("rma", "jade.tools.rma.rma", new Object[0]);
//            rma.start();
//
//            AgentController mobileAgent = mc.createNewAgent("Service-Agent", MobileAgent.class.getName(), new Object[]{});
//            mobileAgent.start();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void start(Stage stage) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/views/Home.fxml"));
            Parent root = loader.load();
            stage.setScene(new Scene(root));

            HomeController homeController = loader.getController();
            List<String> data = new ArrayList<>();
            data.add("Houari");
            data.add("Younes");
            data.add("Ismail");
            data.add("Chenine");
            homeController.updateLocation(data);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        stage.setTitle("Flying Agent");
        stage.show();
        stage.setOnCloseRequest(e -> {
            try {
                mc.kill();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }


}