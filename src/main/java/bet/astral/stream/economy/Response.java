package bet.astral.stream.economy;

import bet.astral.text.api.component.Component;

/**
 * Response of an economy call this can be thrown or be returned
 * @author Antritus
 * @since 1.0.0
 */
public class Response extends Throwable {
    /**
     * Creates a no implementation response with a reason
     * @param reason reason
     * @return no implementation response
     */
    public static Response noImpl(String reason) {
        return new Response(Type.ERROR, Component.text(reason), null, 0, 0);
    }

    /**
     * Creates a no implementation response with default implementation cause
     * @return no implementation response
     */
    public static Response noImpl(){
        return new Response(Type.ERROR, Component.text("This feature is currently not supported in this economy!"), null, 0, 0);
    }

    /**
     * Creates an error response
     * @param throwable throwable
     * @param balance balance
     * @return error response
     */
    public static Response error(Throwable throwable, double balance){
        return new Response(Type.ERROR, Component.throwable(throwable), null, balance, balance);
    }

    /**
     * Creates a failure response
     * @param failure failure cause
     * @param balance balance
     * @return failure response
     */
    public static Response failure(Component failure, double balance){
        return new Response(Type.FAILURE, failure, null, balance, balance);
    }
    /**
     * Creates a failure response
     * @param failure failure cause
     * @param balance balance
     * @param change change
     * @return failure response
     */
    public static Response failure(Component failure, double balance, double change){
        return new Response(Type.FAILURE, failure, null, balance, balance, change);
    }
    /**
     * Creates a success response
     * @param reason reason for transaction
     * @param before balance before
     * @param after balance after
     * @return success
     */
    public static Response success(String reason, double before, double after){
        return new Response(Type.SUCCESS, Component.text("Success"), Component.text(reason), before, after);
    }
    /**
     * Creates a success response
     * @param reason reason for transaction
     * @param before balance before
     * @param after balance after
     * @return success
     */
    public static Response success(Component reason, double before, double after){
        return new Response(Type.SUCCESS, Component.text("Success"), reason, before, after);
    }

    /**
     * Creates a default operation success with balance before, after and change set to 0
     * @return success
     */
    public static Response operationSuccess(){
        return new Response(Type.SUCCESS, Component.text("Operation executed successfully!"), Component.text("Success"), 0, 0);
    }
    private final Type type;
    private final Component errorMessage;
    private final Component reason;
    private final double balanceBefore;
    private final double balanceAfter;
    private final double amount;

    /**
     * Creates a new response instance
     * @param type type of response
     * @param errorMessage error message
     * @param reason reason for transaction
     * @param balanceBefore balance before
     * @param balanceAfter balance after
     */
    public Response(Type type, String errorMessage, String reason, double balanceBefore, double balanceAfter) {
        this(type, Component.text(errorMessage), Component.text(reason), balanceBefore, balanceAfter);
    }
    /**
     * Creates a new response instance
     * @param type type of response
     * @param errorMessage error message
     * @param reason reason for transaction
     * @param balanceBefore balance before
     * @param balanceAfter balance after
     */
    public Response(Type type, Component errorMessage, Component reason, double balanceBefore, double balanceAfter) {
        this.type = type;
        this.errorMessage = errorMessage;
        this.reason = reason;
        this.balanceBefore = balanceBefore;
        this.balanceAfter = balanceAfter;
        this.amount = balanceBefore-balanceAfter;
    }
    /**
     * Creates a new response instance
     * @param type type of response
     * @param errorMessage error message
     * @param reason reason for transaction
     * @param balanceBefore balance before
     * @param balanceAfter balance after
     * @param change amount of the balance
     */
    public Response(Type type, Component errorMessage, Component reason, double balanceBefore, double balanceAfter, double change) {
        this.type = type;
        this.errorMessage = errorMessage;
        this.reason = reason;
        this.balanceBefore = balanceBefore;
        this.balanceAfter = balanceAfter;
        this.amount = change;
    }
    /**
     * Returns the response type
     * @return type
     */
    public Type getType() {
        return type;
    }

    /**
     * Returns the error message as a string
     * @return error message
     */
    public String getErrorMessageText() {
        return errorMessage.getValue();
    }

    /**
     * Returns the error message as a component
     * @return error message
     */
    public Component getErrorMessage() {
        return errorMessage;
    }

    /**
     * Returns the reason of the transaction
     * @return reason
     */
    public String getReasonString() {
        if (reason == null){
            return null;
        }
        return reason.getValue();
    }

    /**
     * Returns the reason of the transaction
     * @return reason
     */
    public Component getReason() {
        return reason;
    }

    /**
     * Returns the balance before the transaction was made
     * @return balance before
     */
    public double getBalanceBefore() {
        return balanceBefore;
    }

    /**
     * Returns the balance after the transaction was made
     * @return balance after
     */
    public double getBalanceAfter() {
        return balanceAfter;
    }

    /**
     * Returns the amount of change between the balance before and after
     * @return amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Returns if this response is a success
     * @return true if a success
     */
    public boolean isSuccess(){
        return type == Type.SUCCESS;
    }

    /**
     * Returns if this response is a failure
     * @return true if a failure
     */
    public boolean isFailure() {
        return type == Type.NO_IMPLEMENTATION;
    }

    /**
     * Returns if this response is an error
     * @return true if an error
     */
    public boolean isError(){
        return type == Type.ERROR;
    }

    /**
     * Returns if this response is a no implementation error
     * @return true if no implementation error
     */
    public boolean isNoImplementation() {
        return type == Type.NO_IMPLEMENTATION;
    }

    /**
     * Response type
     */
    public enum Type {
        /**
         * Returned if the method had an exception
         */
        ERROR(-1),
        /**
         * Returned if the method is not implemented
         */
        NO_IMPLEMENTATION(-1),
        /**
         * Returned if the method was successful
         */
        SUCCESS(2),
        /**
         * Returned if the method was a failure/failed
         */
        FAILURE(1)
        ;

        private final int level;
        Type(int level){
            this.level = level;
        }

        /**
         * Returns true if this is a success
         * @return success
         */
        public boolean isSuccess(){
            return this == SUCCESS;
        }

        /**
         * Returns true if this is a failure
         * @return failure
         */
        public boolean isFailure() {
            return this == FAILURE;
        }

        /**
         * Returns true if this method is not a success
         * @return true, if this is not a success
         */
        public boolean isFailureOrError(){
            return level < 2;
        }

        /**
         * Returns the level of the response type
         * @return level
         */
        public int getLevel(){
            return level;
        }
    }
}
