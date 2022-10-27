package org.cricinfo.model.person;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.cricinfo.model.common.Contact;
import org.cricinfo.model.common.PersonInfo;

@Getter
@Setter
@ToString
public class Person {
    private String name;
    private PersonInfo personInfo;
    private Contact contact;

    public Person(String name) {
        this.name = name;
    }
}
