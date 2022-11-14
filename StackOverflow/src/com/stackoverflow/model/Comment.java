package com.stackoverflow.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Getter
public class Comment extends Entity{
    public Comment(@NonNull String text, @NonNull Member creater, List<Photo> photos) {
        super(UUID.randomUUID().toString(), text, creater, photos);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "text='" + text + '\'' +
                ", creater=" + creater +
                ", photos=" + photos +
                '}';
    }
}
