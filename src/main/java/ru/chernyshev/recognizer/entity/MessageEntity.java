package ru.chernyshev.recognizer.entity;


import ru.chernyshev.recognizer.model.MessageResult;
import ru.chernyshev.recognizer.model.MessageType;
import ru.chernyshev.recognizer.model.RecognizerType;

import javax.persistence.*;

@Entity
@Table(name = "MESSAGES")
public class MessageEntity extends AbstractTimestampEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,
            generator="SEQ_MESSAGES")
    @SequenceGenerator(name="SEQ_MESSAGES",
            sequenceName="SEQ_MESSAGES", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_chat")
    private ChatEntity chat;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MessageResult result = MessageResult.PREPARE;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MessageType messageType = MessageType.UNKNOWN;

    @Column
    @Enumerated(EnumType.STRING)
    private RecognizerType recognizerType;

    @Column
    private Integer duration;

    public MessageResult getResult() {
        return result;
    }

    public void setResult(MessageResult result) {
        this.result = result;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ChatEntity getChat() {
        return chat;
    }

    public void setChat(ChatEntity chat) {
        this.chat = chat;
    }

    public RecognizerType getRecognizerType() {
        return recognizerType;
    }

    public void setRecognizerType(RecognizerType recognizerType) {
        this.recognizerType = recognizerType;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

}
