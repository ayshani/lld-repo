package com.stackoverflow.model;

import com.stackoverflow.common.Status;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Entity is an abstract class
// since we will not be creating an object of this class
// without specifying if this is a question, answer or comment.
// No Setter is being used. few methods exposed to update attributes.
// Mandatory methods are passed via constructor
@Getter
public abstract class Entity {

    protected String id;
    protected String text;
    protected long creationDateTime; // conversion is easy in long than in LocalDateTime
    protected long lastUpdated;
    protected Member creater;
    protected List<Photo> photos;
    protected Set<String> membersWhoDownVotedThisEntity;
    protected Set<String> membersWhoUpVotedThisEntity;
    protected int numberOfUsersReportedThisEntity; // members reported as spam or abuse
    protected Status status;

    public Entity(@NonNull final String id, @NonNull final String text, @NonNull final Member creater, List<Photo> photos) {
        this.id = id;
        this.text = text;
        this.creater = creater;
        this.status = Status.DEFAULT;
        this.photos = new ArrayList<>();
        if (photos != null) {
            this.photos = photos;
        }

        this.membersWhoDownVotedThisEntity = new HashSet<>();
        this.membersWhoUpVotedThisEntity = new HashSet<>();
        long currentTime = System.currentTimeMillis();
        this.creationDateTime = currentTime;
        this.lastUpdated = currentTime;
        this.numberOfUsersReportedThisEntity = 0;
    }

    public boolean equals(Object that) {
        if (that instanceof Entity) {
            return this.id.equals(((Entity) that).id);
        }
        return false;
    }

    //The docs are pretty clear on this: HashSet.add doesn't replace:
    //But HashMap.put will replace:
    //https://stackoverflow.com/questions/12940663/does-adding-a-duplicate-value-to-a-hashset-hashmap-replace-the-previous-value
    public void upVote(String memberId) {
        // a member cannot upvote a comment that he/she has already upvoted
        if (membersWhoUpVotedThisEntity.add(memberId)) {
            // if the member has downvoted this comment in past then upvoting it once just
            // cancels the downvote
            membersWhoDownVotedThisEntity.remove(memberId);
        }
    }

    public void downVote(String memberId) {
        // a member cannot downvote a comment that he/she has already downvoted
        if (membersWhoDownVotedThisEntity.add(memberId)) {
            // if the member has upvoted this comment in past then downvoting it once just
            // cancels the upvote
            membersWhoUpVotedThisEntity.remove(memberId);
        }
    }

    // report as abuse or spam
    public void report() {
        this.numberOfUsersReportedThisEntity++;
    }

    public void updateText(String text) {
        this.text = text;
        this.lastUpdated = System.currentTimeMillis();
    }

    public void removePhotos(List<Photo> photosToBeDeleted) {
        this.photos.removeAll(photosToBeDeleted);
        this.lastUpdated = System.currentTimeMillis();
    }

    public void addPhotos(List<Photo> photosToBeAdded) {
        this.photos.addAll(photosToBeAdded);
        this.lastUpdated = System.currentTimeMillis();
    }

    public void delete() {
        this.status = Status.DELETED;
    }

}
