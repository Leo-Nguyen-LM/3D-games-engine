package game_engine.Matrix_Vector_Manipulation;



public class InvalidExpressionException extends Exception {
/**
 * An custom exception error for matrix faults.
 * 
 * @author Leo Nguyen
 */
    private static final long serialVersionUID = 1L;
  
    /**
     * InvalidExpressionException for CalcController class.
     * 
     * @param errorMessage returns the selected error message.
     */
    public InvalidExpressionException(String errorMessage) {
      super(errorMessage);
    }
  }
  