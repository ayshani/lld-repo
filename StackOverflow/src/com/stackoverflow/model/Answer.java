package com.stackoverflow.model;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/*
Answer:
Answer entity will have below properties:
Answer entity has a creator who wrote the answer.
Answer will have some text.
Answer will be associated with creation date time indicating when it was created,
    and it should also have last updated date time indicating if the member editted the answer and when.
Answer entity can optinally have photos.
Members can upvote or downvote an Answer.
The creator can delete an Answer.
An Answer can be marked as a solution to a question if the Answer satisfied the asker of the question
    to which this Answer is associated to.
People can also comment on an Answer to give their own opinion on that answer.
People can report a comment for abuse or spam.
If an answer satisfies the question asker and gets a bounty, then the creator of the answer gets the bounty.
 */
@Getter
public class Answer extends Entity{
    private boolean solvedProblem;
    private List<Comment> comments;
    public Answer(@NonNull String text, @NonNull Member creater, List<Photo> photos) {
        super(UUID.randomUUID().toString(), text, creater, photos);

        this.comments = new ArrayList<>();
    }

    public void markAsSolution(){
        this.solvedProblem = true;
    }

    public void updateText(String text){
        this.text = text;
        lastUpdated = System.currentTimeMillis();
    }

    public void addComment(Comment comment){
        this.comments.add(comment);
    }

    public void receiveBounty(int reputation){
        creater.receiveBounty(reputation);
    }
}
