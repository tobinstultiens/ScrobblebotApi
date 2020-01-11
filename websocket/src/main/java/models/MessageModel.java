package models;

import lombok.Getter;
import lombok.Setter;

public class MessageModel {
    @Getter @Setter
    private String Username;
    @Getter @Setter
    private String Message;

    public MessageModel() {
    }
}
