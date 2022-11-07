package com.stackoverflow.model;

import lombok.NonNull;

import java.util.List;
import java.util.UUID;

public class Comment extends Entity{
    public Comment(@NonNull String text, @NonNull Member creater, List<Photo> photos) {
        super(UUID.randomUUID().toString(), text, creater, photos);
    }
}
