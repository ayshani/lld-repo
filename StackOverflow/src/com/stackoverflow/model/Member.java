package com.stackoverflow.model;

import com.stackoverflow.common.AccountStatus;
import lombok.Getter;

import java.util.UUID;

/*
Member:
A Member has following properties:
Member has a Member ID, Name, Display Name or Username, and Email.
The account of the member can be in any of these states: ACTIVE, CLOSED, CANCELED, BLACKLISTED, BLOCKED
A member can earn reputation by giving high quality answers to open questions.
In addition a moderator can close a question, and an admin can close a question, and block or unblock a member.
 */
@Getter
public class Member {

    private String id;
    private AccountStatus accountStatus;
    private String name;
    private String displayName;
    private String email;
    private int reputation;
    private boolean isModerator;
    private boolean isAdmin;

    public Member(String name, String displayName, String email){
        this.id = UUID.randomUUID().toString();
        this.accountStatus = AccountStatus.ACTIVE;
        this.name = name;
        this.displayName = displayName;
        this.email = email;
    }

    public void closeAccount(){
        this.accountStatus = AccountStatus.CLOSED;
    }

    public void cancelAccount(){
        this.accountStatus = AccountStatus.CANCELLED;
    }

    public void blackListed(){
        this.accountStatus = AccountStatus.BLACKLISTED;
    }

    public void block(){
        this.accountStatus = AccountStatus.BLOCKED;
    }

    public boolean blockMember(Member member){
        if(isAdmin){
            member.block();
            return true;
        }
        return false;
    }

    public boolean unBlockMember(Member member){
        if(isAdmin){
            member.accountStatus = AccountStatus.ACTIVE;
            return true;
        }
         return false;
    }

    public boolean closeQuestion(Question question){
        // only moderator, admin or creator of the question can close a question
        if(isAdmin || isModerator || this.id.equals(question.getCreater().id)){
            question.close();
            return true;
        }
        return false;
    }

    public void promoteToAdmin(){
        this.isAdmin = true;
    }

    public void promoteToModerator(){
        this.isModerator = true;
    }

    // a question asker can give bounty to someone who has satisfactorily answered to his/her question
    public boolean giveBountyTo(int bountyReputation, Member receiver){
        if(bountyReputation <= reputation && !this.id.equals(receiver.id)){
            reputation-=bountyReputation;
            receiver.receiveBounty(bountyReputation);
            return true;
        }
        return false;
    }

    // a member receives bounty if his/her answer to a question
    // satisfies the question asker and the question asker gives the answerer the bounty
    public void receiveBounty(int bountyReputation) {
        this.reputation += bountyReputation;
    }
}
