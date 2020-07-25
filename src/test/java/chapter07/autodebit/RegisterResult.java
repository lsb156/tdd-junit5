package chapter07.autodebit;

public class RegisterResult {

    public static RegisterResult error(CardValidity validity) {
        return null;
    }

    public static RegisterResult success() {
        return null;
    }

    public CardValidity getValidity() {
        return null;
    }

}
