import org.atm.ATM;
import org.atm.model.BankAccount;
import org.atm.model.Card;
import org.atm.model.TransactionType;
import org.atm.model.User;

import java.util.Date;

//https://gitlab.com/shrayansh8/interviewcodingpractise/-/blob/main/src/LowLevelDesign/DesignATM/ATMRoom.java
public class ATMRoom {
    ATM ATMInstance;
    User user;
    public static void main(String[] args) {
        System.out.println("Welcome to ATM!");

        ATMRoom atmRoom = new ATMRoom();

        atmRoom.init();

        atmRoom.ATMInstance.printCurrentATMBalnace();
        atmRoom.ATMInstance.getCurrentATMState().insertCard(atmRoom.user.getCard());
        atmRoom.ATMInstance.getCurrentATMState().authenticatePin(atmRoom.user.getCard(), 1234);
        atmRoom.ATMInstance.getCurrentATMState().selectOperation(atmRoom.user.getCard(), TransactionType.CASH_WITHDRAWAL);
        atmRoom.ATMInstance.getCurrentATMState().cashWithdrawal(atmRoom.user.getCard(),2700);
        atmRoom.ATMInstance.printCurrentATMBalnace();
    }

    private void init() {
        ATMInstance = ATM.getInstance();
        ATMInstance.setATMBalance(3500,1,2,5);
        this.user = createUser();
    }

    private User createUser() {
        User user = new User();
        BankAccount bankAccount =  new BankAccount(3000);
        user.setCard(createCard(bankAccount));
        user.setUserBankAccount(bankAccount);
        return user;
    }

    private Card createCard(BankAccount account) {

        Card card = new Card(23455, 345,new Date(),
                    "Geeks", 1234,account);
        return card;
    }
}