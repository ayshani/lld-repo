package org.cricinfo.model.match;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.cricinfo.model.person.Commentator;

@Getter
@Setter
@AllArgsConstructor
public class Commentary {
    private Commentator commentator;
    private String comment;

}
