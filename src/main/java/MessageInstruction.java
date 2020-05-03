public class MessageInstruction extends Instruction {
    public static final String MESSAGE_CODE = "M";

    private String order;

    public MessageInstruction(String order) {
        this.order = order;
    }

    public MessageInstruction(Drink drink) {
        throw new UnsupportedOperationException();
    }

    @Override
     String make() {
         return MESSAGE_CODE + SEPARATOR_CODE + order;
    }
}
