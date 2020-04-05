public class MessageInstruction {
    final static String SEPARATOR_CODE = ":";
    public static final String MESSAGE_CODE = "M";

    private String order;

    public MessageInstruction(String order) {
        this.order = order;
    }

     String make() {
         return MESSAGE_CODE + SEPARATOR_CODE + order;
    }
}
