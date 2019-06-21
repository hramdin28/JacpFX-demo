package com.elca.fx.component;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.jacpfx.api.annotations.Resource;
import org.jacpfx.api.annotations.component.DeclarativeView;
import org.jacpfx.api.annotations.lifecycle.PostConstruct;
import org.jacpfx.api.message.Message;
import org.jacpfx.rcp.component.FXComponent;
import org.jacpfx.rcp.componentLayout.FXComponentLayout;
import org.jacpfx.rcp.components.managedFragment.ManagedFragmentHandler;
import org.jacpfx.rcp.context.Context;
import org.jacpfx.rcp.util.FXUtil;

import com.elca.fx.config.BaseConfig;
import com.elca.fx.fragment.FragmentBottom;
import com.elca.fx.fragment.FragmentMiddle;
import com.elca.fx.fragment.FragmentTop;
import com.elca.fx.grpc.HelloRequest;
import com.elca.fx.grpc.HelloResponse;
import com.elca.fx.grpc.HelloServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author bhr
 */
@DeclarativeView(id = BaseConfig.COMPONENT,
        name = BaseConfig.COMPONENT,
        active = true,
        resourceBundleLocation = "bundles.languageBundle",
        initialTargetLayoutId = BaseConfig.TARGET_CONTAINER,
        viewLocation = "/fxml/Component.fxml")
public class Component implements FXComponent {

    @FXML
    private VBox mainPane;
    @FXML
    private HBox topContent;
    @FXML
    private HBox middleContent;
    @FXML
    private HBox bottomContent;

    @FXML
    private TextArea textRespArea;

    @Resource
    private Context context;

    private TextField address;
    private CheckBox localChk;
    private TextField fNameTxt;
    private TextField lNameTxt;

    Map<String, String> data = new HashMap();

    @Override
    public Node handle(final Message message) {
        // runs in worker thread
        if (!message.messageBodyEquals(FXUtil.MessageUtil.INIT)) {
            data.putAll((Map<String, String>) message.getMessageBody());
        }
        return null;
    }

    @Override
    public Node postHandle(final Node arg0,
                           final Message message) {
        // runs in FX application thread
        return null;
    }

    @PostConstruct
    public void onStartComponent(final FXComponentLayout arg0,
                                 final ResourceBundle resourceBundle) {

        ManagedFragmentHandler<FragmentTop> fragmentTop = context.getManagedFragmentHandler(FragmentTop.class);
        ManagedFragmentHandler<FragmentMiddle> fragmentMiddle = context.getManagedFragmentHandler(FragmentMiddle.class);
        ManagedFragmentHandler<FragmentBottom> fragmentBottom = context.getManagedFragmentHandler(FragmentBottom.class);

        fragmentTop.getController().init();

        this.address = fragmentTop.getController().getAddress();
        this.fNameTxt = fragmentMiddle.getController().getfNameTxt();
        this.lNameTxt = fragmentMiddle.getController().getlNameTxt();
        this.localChk = fragmentBottom.getController().getLocalChk();

        topContent.getChildren().addAll(fragmentTop.getFragmentNode());
        middleContent.getChildren().addAll(fragmentMiddle.getFragmentNode());
        bottomContent.getChildren().addAll(fragmentBottom.getFragmentNode());

    }

    @FXML
    protected void sendAction(ActionEvent event) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub
                = HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
                .setFirstName(this.fNameTxt.getText())
                .setLastName(this.lNameTxt.getText())
                .setAddress(this.address.getText())
                .setLocal(this.localChk.getText())
                .build());

        textRespArea.setText(helloResponse.getGreeting());

        channel.shutdown();

    }


}
