package com.stackoverflow.model;

import com.stackoverflow.common.Status;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// No Setter is being used. few methods exposed to update attributes.
// Mandatory methods are passed via constructor
@Getter
public class Question extends Entity{
    private String title;
    private Status status;
    private Bounty bounty;

    private List<Tag> tags;
    private List<Comment> comments;
    private List<Answer> answers;

    public Question(@NonNull String title, @NonNull String text, @NonNull Member askingMember, List<Photo> photos, List tags, Bounty bounty) {
        super(UUID.randomUUID().toString(), text, askingMember, photos);
        this.status = Status.OPEN;
        this.bounty = bounty;
        if(null != tags){
            this.tags = tags;
        } else{
            this.tags = new ArrayList<>();
        }
        this.comments = new ArrayList<>();
        this.answers = new ArrayList<>();
    }

    // Question Asker or Admin can close a question due to various reasons like a solution has been found
    // or due to inactivity of users or certain other reaons
    public void close(){
        this.status =Status.CLOSED;
    }

    public void addComment(Comment comment){
        comments.add(comment);
    }

    public void addAnswer(Answer answer){
        answers.add(answer);
    }
}
