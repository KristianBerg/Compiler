package lang.ast;

import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.HashMap;
/**
 * @ast class
 * @declaredat ASTNode$State:2
 */
public class ASTNode$State extends java.lang.Object {
  
  /** @apilevel internal */
  protected static class CircularValue {
    Object value;
    Cycle cycle;
  }

  

  /**
   * Instances of this class are used to uniquely identify circular evaluation cycles.
   * @apilevel internal
   */
  protected static class Cycle {
  }

  

  /** The cycle ID used outside of circular evaluation. */
  public static final Cycle NON_CYCLE = new Cycle();

  

  /**
   * Tracks the state of the current circular evaluation. This class defines a
   * stack structure where the next element on the stack is pointed to by the
   * {@code next} field.
   * @apilevel internal
   */
  protected static class CircleState {
    final CircleState next;
    boolean inCircle = false;
    boolean change = false;

    /** Evaluation depth of lazy attributes. */
    int lazyAttribute = 0;

    boolean lastCycle = false;

    /** Cycle ID of the latest cycle in this circular evaluation. */
    Cycle cycle = NON_CYCLE;

    protected CircleState(CircleState next) {
      this.next = next;
    }
  }

  

  /** Sentinel circle state representing non-circular evaluation. */
  private static final CircleState CIRCLE_BOTTOM = new CircleState(null);

  

  /**
   * Current circular state.
   * @apilevel internal
   */
  private CircleState circle = CIRCLE_BOTTOM;

  

  /** @apilevel internal */
  protected boolean inCircle() {
    return circle.inCircle;
  }

  

  /** @apilevel internal */
  protected boolean calledByLazyAttribute() {
    return circle.lazyAttribute > 0;
  }

  

  /** @apilevel internal */
  protected void enterLazyAttribute() {
    circle.lazyAttribute += 1;
  }

  

  /** @apilevel internal */
  protected void leaveLazyAttribute() {
    circle.lazyAttribute -= 1;
  }

  

  /** @apilevel internal */
  protected void enterCircle() {
    CircleState next = new CircleState(circle);
    next.inCircle = true;
    circle = next;
  }

  

  /** @apilevel internal */
  protected void leaveCircle() {
    circle = circle.next;
  }

  

  /** @apilevel internal */
  protected Cycle nextCycle() {
    Cycle cycle = new Cycle();
    circle.cycle = cycle;
    return cycle;
  }

  

  /** @apilevel internal */
  protected Cycle cycle() {
    return circle.cycle;
  }

  

  /** @apilevel internal */
  protected CircleState currentCircle() {
    return circle;
  }

  


  /** @apilevel internal */
  protected void setChangeInCycle() {
    circle.change = true;
  }

  

  /** @apilevel internal */
  protected boolean testAndClearChangeInCycle() {
    boolean change = circle.change;
    circle.change = false;
    return change;
  }

  

  /** @apilevel internal */
  protected boolean changeInCycle() {
    return circle.change;
  }

  

  /** @apilevel internal */
  protected boolean lastCycle() {
    return circle.lastCycle;
  }

  

  /** @apilevel internal */
  protected void startLastCycle() {
    circle.lastCycle = true;
  }

  

  protected ASTNode$State() {
  }

  public void reset() {
    // Reset circular evaluation state.
    circle = CIRCLE_BOTTOM;
  }


}
