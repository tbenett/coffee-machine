public class Message {
    final static String SEPARATOR_CODE = ":";
    public static final String MESSAGE_CODE = "M";

    private String order;

    public Message(String order) {

        this.order = order;
    }

     String make() {

         return MESSAGE_CODE + SEPARATOR_CODE + order;
    }
}
