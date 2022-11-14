package test;

import com.stackoverflow.model.*;

import java.util.List;

public class StackOverFlow {
    public static void main(String[] args) {

        Member admin = new Member("Admin","Admin","admin@gmail.com");
        admin.promoteToAdmin();
        Member questionAsker = new Member("QuestionAsker","QuestionAsker","questionAsker@gmail.com");
        Member respondent1 = new Member("Respondent1","Respondent1","respondent1@gmail.com");
        Member respondent2 = new Member("Respondent2","Respondent2","respondent2@gmail.com");
        Member moderator = new Member("Moderator","Moderator","moderator@gmail.com");
        moderator.promoteToModerator();
        Member commentor = new Member("Commentor","Commentor","commentor@gmail.com");

        Member upVoter1 = new Member("UpVoter1","UpVoter1","upVoter1@gmail.com");
        Member upVoter2 = new Member("UpVoter2","UpVoter2","upVoter2@gmail.com");
        Member downVoter1 = new Member("DownVoter1","DownVoter1","downVoter1@gmail.com");
        Member downVoter2 = new Member("DownVoter2","DownVoter2","downVoter2@gmail.com");
        // Question 1 -----
        List<Photo> photos = List.of(new Photo(questionAsker,"/path1"), new Photo(questionAsker,"/path2"));
        Bounty bounty = new Bounty(500,System.currentTimeMillis()+ 100000);
        List<String> tags = List.of("Art","Psychology");
        Question question = new Question("Question 1","Explain what is question 1",questionAsker,photos,tags,bounty);
        question.addComment(new Comment("Can you be more more descriptive", commentor,null));

        System.out.println(question.toString());

        question.upVote(upVoter1.getId());
        question.upVote(upVoter2.getId());
        System.out.println("Members who upvoted Question ID : "+ question.getId() +" are as below : ");
        System.out.println(question.getMembersWhoUpVotedThisEntity());

        question.upVote(upVoter1.getId());
        System.out.println("Members who upvoted Question ID : "+ question.getId() +" are as below : ");
        System.out.println(question.getMembersWhoUpVotedThisEntity());

        question.downVote(downVoter1.getId());
        question.downVote(upVoter2.getId());
        System.out.println("Members who downvoted Question ID : "+ question.getId() +" are as below : ");
        System.out.println(question.getMembersWhoDownVotedThisEntity());

        question.report();
        question.report();
        System.out.println("Total Number of Members who reported Question ID : "+ question.getId() +" are : " + question.getNumberOfUsersReportedThisEntity());

        Answer answer1 = new Answer("this is an answer1 to question",respondent1,null);
        Answer answer2 = new Answer("this is an answer2 to question",respondent2,null);
        question.addAnswer(answer1);
        question.addAnswer(answer2);
        answer2.markAsSolution();

        System.out.println(question.toString());

        System.out.println("Question asker details before giving reputation:");
        System.out.println(questionAsker);

        System.out.println("Respondent 2 details before gaining reputation:");
        System.out.println(respondent2);

        questionAsker.receiveBounty(1000); // Add bounty to question answer
        questionAsker.giveBountyTo(question.getBounty().getReputation(),respondent2); // give full bounty

        System.out.println("Question asker details with decreasing reputation:");
        System.out.println(questionAsker);

        System.out.println("Respondent 2 details with gaining reputation:");
        System.out.println(respondent2);

    }
}