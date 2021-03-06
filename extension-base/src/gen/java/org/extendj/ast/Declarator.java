/* This file was generated with JastAdd2 (http://jastadd.org) version 2.2.2 */
package org.extendj.ast;
import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import org.jastadd.util.*;
import java.util.zip.*;
import java.io.*;
import org.jastadd.util.PrettyPrintable;
import org.jastadd.util.PrettyPrinter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.IOException;
import java.util.Set;
import beaver.*;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
/**
 * @ast node
 * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/grammar/Java.ast:80
 * @production Declarator : {@link ASTNode} ::= <span class="component">TypeAccess:{@link Access}</span> <span class="component">&lt;ID:String&gt;</span> <span class="component">{@link Dims}*</span> <span class="component">[Init:{@link Expr}]</span>;

 */
public abstract class Declarator extends ASTNode<ASTNode> implements Cloneable, Variable, SimpleSet<Variable> {
  /**
   * @aspect Java4PrettyPrint
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/PrettyPrint.jadd:324
   */
  public void prettyPrint(PrettyPrinter out) {
    out.print(getID());
    out.print(getDimsList());
    if (hasInit()) {
      out.print(" = ");
      out.print(getInit());
    }
  }
  /**
   * @aspect DataStructures
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/DataStructures.jrag:321
   */
  @Override
  public int size() {
    return 1;
  }
  /**
   * @aspect DataStructures
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/DataStructures.jrag:326
   */
  @Override
  public boolean isEmpty() {
    return false;
  }
  /**
   * @aspect DataStructures
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/DataStructures.jrag:331
   */
  @Override
  public SimpleSet<Variable> add(Variable o) {
    return new SimpleSetImpl<Variable>(this, o);
  }
  /**
   * @aspect DataStructures
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/DataStructures.jrag:336
   */
  @Override
  public boolean contains(Object o) {
    return this == o;
  }
  /**
   * @aspect DataStructures
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/DataStructures.jrag:341
   */
  @Override
  public boolean isSingleton() {
    return true;
  }
  /**
   * @aspect DataStructures
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/DataStructures.jrag:346
   */
  @Override
  public boolean isSingleton(Variable o) {
    return contains(o);
  }
  /**
   * @aspect DataStructures
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/DataStructures.jrag:351
   */
  @Override
  public Variable singletonValue() {
    return this;
  }
  /**
   * @aspect DataStructures
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/DataStructures.jrag:356
   */
  @Override
  public boolean equals(Object o) {
    return this == o;
  }
  /**
   * @aspect DataStructures
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/DataStructures.jrag:361
   */
  @Override
  public Iterator<Variable> iterator() {
    return new SingleItemIterator(this);
  }
  /**
   * @declaredat ASTNode:1
   */
  public Declarator() {
    super();
  }
  /**
   * Initializes the child array to the correct size.
   * Initializes List and Opt nta children.
   * @apilevel internal
   * @ast method
   * @declaredat ASTNode:10
   */
  public void init$Children() {
    children = new ASTNode[3];
    setChild(new List(), 0);
    setChild(new Opt(), 1);
  }
  /**
   * @declaredat ASTNode:15
   */
  public Declarator(String p0, List<Dims> p1, Opt<Expr> p2) {
    setID(p0);
    setChild(p1, 0);
    setChild(p2, 1);
  }
  /**
   * @declaredat ASTNode:20
   */
  public Declarator(beaver.Symbol p0, List<Dims> p1, Opt<Expr> p2) {
    setID(p0);
    setChild(p1, 0);
    setChild(p2, 1);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:26
   */
  protected int numChildren() {
    return 2;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:32
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:36
   */
  public void flushAttrCache() {
    super.flushAttrCache();
    getModifiers_reset();
    getTypeAccess_reset();
    assignedAfter_Variable_reset();
    unassignedAfter_Variable_reset();
    throwTypes_reset();
    declarationModifiers_reset();
    declarationType_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:47
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:51
   */
  public Declarator clone() throws CloneNotSupportedException {
    Declarator node = (Declarator) super.clone();
    return node;
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @deprecated Please use treeCopy or treeCopyNoTransform instead
   * @declaredat ASTNode:62
   */
  @Deprecated
  public abstract Declarator fullCopy();
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:70
   */
  public abstract Declarator treeCopyNoTransform();
  /**
   * Create a deep copy of the AST subtree at this node.
   * The subtree of this node is traversed to trigger rewrites before copy.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:78
   */
  public abstract Declarator treeCopy();
  /**
   * Replaces the lexeme ID.
   * @param value The new value for the lexeme ID.
   * @apilevel high-level
   */
  public void setID(String value) {
    tokenString_ID = value;
  }
  /** @apilevel internal 
   */
  protected String tokenString_ID;
  /**
   */
  public int IDstart;
  /**
   */
  public int IDend;
  /**
   * JastAdd-internal setter for lexeme ID using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme ID
   * @apilevel internal
   */
  public void setID(beaver.Symbol symbol) {
    if (symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setID is only valid for String lexemes");
    tokenString_ID = (String)symbol.value;
    IDstart = symbol.getStart();
    IDend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme ID.
   * @return The value for the lexeme ID.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="ID")
  public String getID() {
    return tokenString_ID != null ? tokenString_ID : "";
  }
  /**
   * Replaces the Dims list.
   * @param list The new list node to be used as the Dims list.
   * @apilevel high-level
   */
  public void setDimsList(List<Dims> list) {
    setChild(list, 0);
  }
  /**
   * Retrieves the number of children in the Dims list.
   * @return Number of children in the Dims list.
   * @apilevel high-level
   */
  public int getNumDims() {
    return getDimsList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Dims list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Dims list.
   * @apilevel low-level
   */
  public int getNumDimsNoTransform() {
    return getDimsListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Dims list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Dims list.
   * @apilevel high-level
   */
  public Dims getDims(int i) {
    return (Dims) getDimsList().getChild(i);
  }
  /**
   * Check whether the Dims list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasDims() {
    return getDimsList().getNumChild() != 0;
  }
  /**
   * Append an element to the Dims list.
   * @param node The element to append to the Dims list.
   * @apilevel high-level
   */
  public void addDims(Dims node) {
    List<Dims> list = (parent == null) ? getDimsListNoTransform() : getDimsList();
    list.addChild(node);
  }
  /** @apilevel low-level 
   */
  public void addDimsNoTransform(Dims node) {
    List<Dims> list = getDimsListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Dims list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setDims(Dims node, int i) {
    List<Dims> list = getDimsList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the Dims list.
   * @return The node representing the Dims list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Dims")
  public List<Dims> getDimsList() {
    List<Dims> list = (List<Dims>) getChild(0);
    return list;
  }
  /**
   * Retrieves the Dims list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Dims list.
   * @apilevel low-level
   */
  public List<Dims> getDimsListNoTransform() {
    return (List<Dims>) getChildNoTransform(0);
  }
  /**
   * @return the element at index {@code i} in the Dims list without
   * triggering rewrites.
   */
  public Dims getDimsNoTransform(int i) {
    return (Dims) getDimsListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the Dims list.
   * @return The node representing the Dims list.
   * @apilevel high-level
   */
  public List<Dims> getDimss() {
    return getDimsList();
  }
  /**
   * Retrieves the Dims list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Dims list.
   * @apilevel low-level
   */
  public List<Dims> getDimssNoTransform() {
    return getDimsListNoTransform();
  }
  /**
   * Replaces the optional node for the Init child. This is the <code>Opt</code>
   * node containing the child Init, not the actual child!
   * @param opt The new node to be used as the optional node for the Init child.
   * @apilevel low-level
   */
  public void setInitOpt(Opt<Expr> opt) {
    setChild(opt, 1);
  }
  /**
   * Replaces the (optional) Init child.
   * @param node The new node to be used as the Init child.
   * @apilevel high-level
   */
  public void setInit(Expr node) {
    getInitOpt().setChild(node, 0);
  }
  /**
   * Check whether the optional Init child exists.
   * @return {@code true} if the optional Init child exists, {@code false} if it does not.
   * @apilevel high-level
   */
  public boolean hasInit() {
    return getInitOpt().getNumChild() != 0;
  }
  /**
   * Retrieves the (optional) Init child.
   * @return The Init child, if it exists. Returns {@code null} otherwise.
   * @apilevel low-level
   */
  public Expr getInit() {
    return (Expr) getInitOpt().getChild(0);
  }
  /**
   * Retrieves the optional node for the Init child. This is the <code>Opt</code> node containing the child Init, not the actual child!
   * @return The optional node for child the Init child.
   * @apilevel low-level
   */
  @ASTNodeAnnotation.OptChild(name="Init")
  public Opt<Expr> getInitOpt() {
    return (Opt<Expr>) getChild(1);
  }
  /**
   * Retrieves the optional node for child Init. This is the <code>Opt</code> node containing the child Init, not the actual child!
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The optional node for child Init.
   * @apilevel low-level
   */
  public Opt<Expr> getInitOptNoTransform() {
    return (Opt<Expr>) getChildNoTransform(1);
  }
  /**
   * Retrieves the TypeAccess child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the TypeAccess child.
   * @apilevel low-level
   */
  public Access getTypeAccessNoTransform() {
    return (Access) getChildNoTransform(2);
  }
  /**
   * Retrieves the child position of the optional child TypeAccess.
   * @return The the child position of the optional child TypeAccess.
   * @apilevel low-level
   */
  protected int getTypeAccessChildPosition() {
    return 2;
  }
  /** @apilevel internal */
  private void getModifiers_reset() {
    getModifiers_computed = null;
    getModifiers_value = null;
  }
  /** @apilevel internal */
  protected ASTNode$State.Cycle getModifiers_computed = null;

  /** @apilevel internal */
  protected Modifiers getModifiers_value;

  /** Modifiers are same as the parent declaration (e.g. VarDeclStmt). 
   * @attribute syn
   * @aspect VariableDeclarationTransformation
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:130
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="VariableDeclarationTransformation", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:130")
  public Modifiers getModifiers() {
    ASTNode$State state = state();
    if (getModifiers_computed == ASTNode$State.NON_CYCLE || getModifiers_computed == state().cycle()) {
      return getModifiers_value;
    }
    getModifiers_value = declarationModifiers();
    if (state().inCircle()) {
      getModifiers_computed = state().cycle();
    
    } else {
      getModifiers_computed = ASTNode$State.NON_CYCLE;
    
    }
    return getModifiers_value;
  }
  /** @apilevel internal */
  private void getTypeAccess_reset() {
    getTypeAccess_computed = false;
    
    getTypeAccess_value = null;
  }
  /** @apilevel internal */
  protected boolean getTypeAccess_computed = false;

  /** @apilevel internal */
  protected Access getTypeAccess_value;

  /** Type access is copied from the parent declaration, with added array dimensions. 
   * @attribute syn nta
   * @aspect VariableDeclarationTransformation
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:140
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="VariableDeclarationTransformation", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:140")
  public Access getTypeAccess() {
    ASTNode$State state = state();
    if (getTypeAccess_computed) {
      return (Access) getChild(getTypeAccessChildPosition());
    }
    state().enterLazyAttribute();
    getTypeAccess_value = ((Access) declarationType().treeCopyNoTransform()).addArrayDims(getDimsList());
    setChild(getTypeAccess_value, getTypeAccessChildPosition());
    getTypeAccess_computed = true;
    state().leaveLazyAttribute();
    Access node = (Access) this.getChild(getTypeAccessChildPosition());
    return node;
  }
  /**
   * @attribute syn
   * @aspect DefiniteAssignment
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/DefiniteAssignment.jrag:104
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="DefiniteAssignment", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/DefiniteAssignment.jrag:104")
  public boolean isBlankFinal() {
    boolean isBlankFinal_value = isFinal() && (!hasInit() || !getInit().isConstant());
    return isBlankFinal_value;
  }
  /**
   * @attribute syn
   * @aspect DefiniteAssignment
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/DefiniteAssignment.jrag:107
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="DefiniteAssignment", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/DefiniteAssignment.jrag:107")
  public boolean isValue() {
    boolean isValue_value = isFinal() && hasInit() && getInit().isConstant();
    return isValue_value;
  }
  /** @apilevel internal */
  private void assignedAfter_Variable_reset() {
    assignedAfter_Variable_values = null;
  }
  protected java.util.Map assignedAfter_Variable_values;
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isCircular=true)
  @ASTNodeAnnotation.Source(aspect="DefiniteAssignment", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/DefiniteAssignment.jrag:636")
  public boolean assignedAfter(Variable v) {
    Object _parameters = v;
    if (assignedAfter_Variable_values == null) assignedAfter_Variable_values = new java.util.HashMap(4);
    ASTNode$State.CircularValue _value;
    if (assignedAfter_Variable_values.containsKey(_parameters)) {
      Object _cache = assignedAfter_Variable_values.get(_parameters);
      if (!(_cache instanceof ASTNode$State.CircularValue)) {
        return (Boolean) _cache;
      } else {
        _value = (ASTNode$State.CircularValue) _cache;
      }
    } else {
      _value = new ASTNode$State.CircularValue();
      assignedAfter_Variable_values.put(_parameters, _value);
      _value.value = true;
    }
    ASTNode$State state = state();
    if (!state.inCircle() || state.calledByLazyAttribute()) {
      state.enterCircle();
      boolean new_assignedAfter_Variable_value;
      do {
        _value.cycle = state.nextCycle();
        new_assignedAfter_Variable_value = assignedAfter_compute(v);
        if (new_assignedAfter_Variable_value != ((Boolean)_value.value)) {
          state.setChangeInCycle();
          _value.value = new_assignedAfter_Variable_value;
        }
      } while (state.testAndClearChangeInCycle());
      assignedAfter_Variable_values.put(_parameters, new_assignedAfter_Variable_value);

      state.leaveCircle();
      return new_assignedAfter_Variable_value;
    } else if (_value.cycle != state.cycle()) {
      _value.cycle = state.cycle();
      boolean new_assignedAfter_Variable_value = assignedAfter_compute(v);
      if (new_assignedAfter_Variable_value != ((Boolean)_value.value)) {
        state.setChangeInCycle();
        _value.value = new_assignedAfter_Variable_value;
      }
      return new_assignedAfter_Variable_value;
    } else {
      return (Boolean) _value.value;
    }
  }
  /** @apilevel internal */
  private boolean assignedAfter_compute(Variable v) {
      if (v == this) {
        return hasInit();
      } else {
        return hasInit() ? getInit().assignedAfter(v) : assignedBefore(v);
      }
    }
  /** @apilevel internal */
  private void unassignedAfter_Variable_reset() {
    unassignedAfter_Variable_values = null;
  }
  protected java.util.Map unassignedAfter_Variable_values;
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isCircular=true)
  @ASTNodeAnnotation.Source(aspect="DefiniteUnassignment", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/DefiniteAssignment.jrag:1184")
  public boolean unassignedAfter(Variable v) {
    Object _parameters = v;
    if (unassignedAfter_Variable_values == null) unassignedAfter_Variable_values = new java.util.HashMap(4);
    ASTNode$State.CircularValue _value;
    if (unassignedAfter_Variable_values.containsKey(_parameters)) {
      Object _cache = unassignedAfter_Variable_values.get(_parameters);
      if (!(_cache instanceof ASTNode$State.CircularValue)) {
        return (Boolean) _cache;
      } else {
        _value = (ASTNode$State.CircularValue) _cache;
      }
    } else {
      _value = new ASTNode$State.CircularValue();
      unassignedAfter_Variable_values.put(_parameters, _value);
      _value.value = true;
    }
    ASTNode$State state = state();
    if (!state.inCircle() || state.calledByLazyAttribute()) {
      state.enterCircle();
      boolean new_unassignedAfter_Variable_value;
      do {
        _value.cycle = state.nextCycle();
        new_unassignedAfter_Variable_value = unassignedAfter_compute(v);
        if (new_unassignedAfter_Variable_value != ((Boolean)_value.value)) {
          state.setChangeInCycle();
          _value.value = new_unassignedAfter_Variable_value;
        }
      } while (state.testAndClearChangeInCycle());
      unassignedAfter_Variable_values.put(_parameters, new_unassignedAfter_Variable_value);

      state.leaveCircle();
      return new_unassignedAfter_Variable_value;
    } else if (_value.cycle != state.cycle()) {
      _value.cycle = state.cycle();
      boolean new_unassignedAfter_Variable_value = unassignedAfter_compute(v);
      if (new_unassignedAfter_Variable_value != ((Boolean)_value.value)) {
        state.setChangeInCycle();
        _value.value = new_unassignedAfter_Variable_value;
      }
      return new_unassignedAfter_Variable_value;
    } else {
      return (Boolean) _value.value;
    }
  }
  /** @apilevel internal */
  private boolean unassignedAfter_compute(Variable v) {
      if (v == this) {
        return !hasInit();
      } else {
        return hasInit() ? getInit().unassignedAfter(v) : unassignedBefore(v);
      }
    }
  /**
   * @attribute syn
   * @aspect ConstantExpression
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/ConstantExpression.jrag:360
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="ConstantExpression", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/ConstantExpression.jrag:360")
  public boolean isConstant() {
    boolean isConstant_value = isFinal() && hasInit() && getInit().isConstant()
          && (type() instanceof PrimitiveType || type().isString());
    return isConstant_value;
  }
  /**
   * @attribute syn
   * @aspect PrettyPrintUtil
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/PrettyPrintUtil.jrag:223
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="PrettyPrintUtil", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/PrettyPrintUtil.jrag:223")
  public boolean hasModifiers() {
    boolean hasModifiers_value = getModifiers().getNumModifier() > 0;
    return hasModifiers_value;
  }
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/Modifiers.jrag:254
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Modifiers", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/Modifiers.jrag:254")
  public boolean isSynthetic() {
    boolean isSynthetic_value = getModifiers().isSynthetic();
    return isSynthetic_value;
  }
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/Modifiers.jrag:276
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Modifiers", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/Modifiers.jrag:276")
  public boolean isPublic() {
    boolean isPublic_value = false;
    return isPublic_value;
  }
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/TypeAnalysis.jrag:271
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/TypeAnalysis.jrag:271")
  public TypeDecl type() {
    TypeDecl type_value = getTypeAccess().type();
    return type_value;
  }
  /**
   * @attribute syn
   * @aspect AccessControl
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/AccessControl.jrag:136
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="AccessControl", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/AccessControl.jrag:136")
  public boolean accessibleFrom(TypeDecl type) {
    boolean accessibleFrom_TypeDecl_value = false;
    return accessibleFrom_TypeDecl_value;
  }
  /** @apilevel internal */
  private void throwTypes_reset() {
    throwTypes_computed = null;
    throwTypes_value = null;
  }
  /** @apilevel internal */
  protected ASTNode$State.Cycle throwTypes_computed = null;

  /** @apilevel internal */
  protected Collection<TypeDecl> throwTypes_value;

  /**
   * @attribute syn
   * @aspect PreciseRethrow
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java7/frontend/PreciseRethrow.jrag:41
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="PreciseRethrow", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java7/frontend/PreciseRethrow.jrag:41")
  public Collection<TypeDecl> throwTypes() {
    ASTNode$State state = state();
    if (throwTypes_computed == ASTNode$State.NON_CYCLE || throwTypes_computed == state().cycle()) {
      return throwTypes_value;
    }
    throwTypes_value = throwTypes_compute();
    if (state().inCircle()) {
      throwTypes_computed = state().cycle();
    
    } else {
      throwTypes_computed = ASTNode$State.NON_CYCLE;
    
    }
    return throwTypes_value;
  }
  /** @apilevel internal */
  private Collection<TypeDecl> throwTypes_compute() {
      Collection<TypeDecl> tts = new LinkedList<TypeDecl>();
      tts.add(type());
      return tts;
    }
  /**
   * @attribute syn
   * @aspect SuppressWarnings
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java7/frontend/SuppressWarnings.jrag:32
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="SuppressWarnings", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java7/frontend/SuppressWarnings.jrag:32")
  public boolean hasAnnotationSuppressWarnings(String annot) {
    boolean hasAnnotationSuppressWarnings_String_value = getModifiers().hasAnnotationSuppressWarnings(annot);
    return hasAnnotationSuppressWarnings_String_value;
  }
  /**
   * @attribute syn
   * @aspect SuppressWarnings
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java7/frontend/SuppressWarnings.jrag:41
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="SuppressWarnings", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java7/frontend/SuppressWarnings.jrag:41")
  public boolean suppressWarnings(String type) {
    boolean suppressWarnings_String_value = hasAnnotationSuppressWarnings(type) || withinSuppressWarnings(type);
    return suppressWarnings_String_value;
  }
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/Modifiers.jrag:281
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Modifiers", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/Modifiers.jrag:281")
  public boolean isProtected() {
    boolean isProtected_value = getModifiers().isProtected();
    return isProtected_value;
  }
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/Modifiers.jrag:283
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Modifiers", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/Modifiers.jrag:283")
  public boolean isPrivate() {
    boolean isPrivate_value = getModifiers().isPrivate();
    return isPrivate_value;
  }
  /** Inherited attribute computing the modifiers of the parent declaration. 
   * @attribute inh
   * @aspect VariableDeclarationTransformation
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:133
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="VariableDeclarationTransformation", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:133")
  public Modifiers declarationModifiers() {
    ASTNode$State state = state();
    if (declarationModifiers_computed == ASTNode$State.NON_CYCLE || declarationModifiers_computed == state().cycle()) {
      return declarationModifiers_value;
    }
    declarationModifiers_value = getParent().Define_declarationModifiers(this, null);
    if (state().inCircle()) {
      declarationModifiers_computed = state().cycle();
    
    } else {
      declarationModifiers_computed = ASTNode$State.NON_CYCLE;
    
    }
    return declarationModifiers_value;
  }
  /** @apilevel internal */
  private void declarationModifiers_reset() {
    declarationModifiers_computed = null;
    declarationModifiers_value = null;
  }
  /** @apilevel internal */
  protected ASTNode$State.Cycle declarationModifiers_computed = null;

  /** @apilevel internal */
  protected Modifiers declarationModifiers_value;

  /** Inherited attribute computing the type access of the parent declaration. 
   * @attribute inh
   * @aspect VariableDeclarationTransformation
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:144
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="VariableDeclarationTransformation", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:144")
  public Access declarationType() {
    ASTNode$State state = state();
    if (declarationType_computed == ASTNode$State.NON_CYCLE || declarationType_computed == state().cycle()) {
      return declarationType_value;
    }
    declarationType_value = getParent().Define_declarationType(this, null);
    if (state().inCircle()) {
      declarationType_computed = state().cycle();
    
    } else {
      declarationType_computed = ASTNode$State.NON_CYCLE;
    
    }
    return declarationType_value;
  }
  /** @apilevel internal */
  private void declarationType_reset() {
    declarationType_computed = null;
    declarationType_value = null;
  }
  /** @apilevel internal */
  protected ASTNode$State.Cycle declarationType_computed = null;

  /** @apilevel internal */
  protected Access declarationType_value;

  /**
   * @attribute inh
   * @aspect DefiniteAssignment
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/DefiniteAssignment.jrag:258
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="DefiniteAssignment", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/DefiniteAssignment.jrag:258")
  public boolean assignedBefore(Variable v) {
    boolean assignedBefore_Variable_value = getParent().Define_assignedBefore(this, null, v);
    return assignedBefore_Variable_value;
  }
  /**
   * @attribute inh
   * @aspect DefiniteUnassignment
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/DefiniteAssignment.jrag:893
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="DefiniteUnassignment", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/DefiniteAssignment.jrag:893")
  public boolean unassignedBefore(Variable v) {
    boolean unassignedBefore_Variable_value = getParent().Define_unassignedBefore(this, null, v);
    return unassignedBefore_Variable_value;
  }
  /**
   * @attribute inh
   * @aspect VariableScope
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/LookupVariable.jrag:45
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="VariableScope", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/LookupVariable.jrag:45")
  public SimpleSet<Variable> lookupVariable(String name) {
    SimpleSet<Variable> lookupVariable_String_value = getParent().Define_lookupVariable(this, null, name);
    return lookupVariable_String_value;
  }
  /**
   * @attribute inh
   * @aspect NestedTypes
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/TypeAnalysis.jrag:651
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="NestedTypes", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/TypeAnalysis.jrag:651")
  public TypeDecl hostType() {
    TypeDecl hostType_value = getParent().Define_hostType(this, null);
    return hostType_value;
  }
  /**
   * @attribute inh
   * @aspect SuppressWarnings
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java7/frontend/SuppressWarnings.jrag:35
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="SuppressWarnings", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java7/frontend/SuppressWarnings.jrag:35")
  public boolean withinSuppressWarnings(String annot) {
    boolean withinSuppressWarnings_String_value = getParent().Define_withinSuppressWarnings(this, null, annot);
    return withinSuppressWarnings_String_value;
  }
  /**
   * @attribute inh
   * @aspect NestedTypes
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/TypeAnalysis.jrag:633
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="NestedTypes", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/TypeAnalysis.jrag:633")
  public String hostPackage() {
    String hostPackage_value = getParent().Define_hostPackage(this, null);
    return hostPackage_value;
  }
  /**
   * @attribute inh
   * @aspect LookupParTypeDecl
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/Generics.jrag:1249
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="LookupParTypeDecl", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/Generics.jrag:1249")
  public FieldDecl fieldDecl() {
    FieldDecl fieldDecl_value = getParent().Define_fieldDecl(this, null);
    return fieldDecl_value;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/DefiniteAssignment.jrag:44
   * @apilevel internal
   */
  public boolean Define_isSource(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getInitOptNoTransform()) {
      // @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/DefiniteAssignment.jrag:58
      return true;
    }
    else {
      return getParent().Define_isSource(this, _callerNode);
    }
  }
  protected boolean canDefine_isSource(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/DefiniteAssignment.jrag:256
   * @apilevel internal
   */
  public boolean Define_assignedBefore(ASTNode _callerNode, ASTNode _childNode, Variable v) {
    if (_callerNode == getInitOptNoTransform()) {
      // @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/DefiniteAssignment.jrag:644
      return assignedBefore(v);
    }
    else {
      return getParent().Define_assignedBefore(this, _callerNode, v);
    }
  }
  protected boolean canDefine_assignedBefore(ASTNode _callerNode, ASTNode _childNode, Variable v) {
    return true;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/DefiniteAssignment.jrag:891
   * @apilevel internal
   */
  public boolean Define_unassignedBefore(ASTNode _callerNode, ASTNode _childNode, Variable v) {
    if (_callerNode == getInitOptNoTransform()) {
      // @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/DefiniteAssignment.jrag:1192
      return unassignedBefore(v);
    }
    else {
      return getParent().Define_unassignedBefore(this, _callerNode, v);
    }
  }
  protected boolean canDefine_unassignedBefore(ASTNode _callerNode, ASTNode _childNode, Variable v) {
    return true;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/SyntacticClassification.jrag:36
   * @apilevel internal
   */
  public NameType Define_nameType(ASTNode _callerNode, ASTNode _childNode) {
    if (getTypeAccessNoTransform() != null && _callerNode == getTypeAccess()) {
      // @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/SyntacticClassification.jrag:108
      return NameType.TYPE_NAME;
    }
    else {
      return getParent().Define_nameType(this, _callerNode);
    }
  }
  protected boolean canDefine_nameType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/ResolveAmbiguousNames.jrag:78
   * @apilevel internal
   */
  public boolean Define_isLeftChildOfDot(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return false;
  }
  protected boolean canDefine_isLeftChildOfDot(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/ResolveAmbiguousNames.jrag:93
   * @apilevel internal
   */
  public boolean Define_isRightChildOfDot(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return false;
  }
  protected boolean canDefine_isRightChildOfDot(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/ResolveAmbiguousNames.jrag:110
   * @apilevel internal
   */
  public Expr Define_prevExpr(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return prevExprError();
  }
  protected boolean canDefine_prevExpr(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/ResolveAmbiguousNames.jrag:134
   * @apilevel internal
   */
  public Access Define_nextAccess(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return nextAccessError();
  }
  protected boolean canDefine_nextAccess(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/Annotations.jrag:713
   * @apilevel internal
   */
  public TypeDecl Define_declType(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getInitOptNoTransform()) {
      // @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/TypeAnalysis.jrag:282
      return type();
    }
    else {
      return getParent().Define_declType(this, _callerNode);
    }
  }
  protected boolean canDefine_declType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/GenericMethodsInference.jrag:65
   * @apilevel internal
   */
  public TypeDecl Define_assignConvertedType(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getInitOptNoTransform()) {
      // @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/GenericMethodsInference.jrag:66
      return type();
    }
    else {
      return getParent().Define_assignConvertedType(this, _callerNode);
    }
  }
  protected boolean canDefine_assignConvertedType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/TargetType.jrag:30
   * @apilevel internal
   */
  public TypeDecl Define_targetType(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getInitOptNoTransform()) {
      // @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/TargetType.jrag:39
      return getTypeAccess().type();
    }
    else {
      return getParent().Define_targetType(this, _callerNode);
    }
  }
  protected boolean canDefine_targetType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/TargetType.jrag:195
   * @apilevel internal
   */
  public boolean Define_assignmentContext(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getInitOptNoTransform()) {
      // @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/TargetType.jrag:334
      return true;
    }
    else {
      return getParent().Define_assignmentContext(this, _callerNode);
    }
  }
  protected boolean canDefine_assignmentContext(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/TargetType.jrag:196
   * @apilevel internal
   */
  public boolean Define_invocationContext(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getInitOptNoTransform()) {
      // @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/TargetType.jrag:335
      return false;
    }
    else {
      return getParent().Define_invocationContext(this, _callerNode);
    }
  }
  protected boolean canDefine_invocationContext(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/TargetType.jrag:197
   * @apilevel internal
   */
  public boolean Define_castContext(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getInitOptNoTransform()) {
      // @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/TargetType.jrag:336
      return false;
    }
    else {
      return getParent().Define_castContext(this, _callerNode);
    }
  }
  protected boolean canDefine_castContext(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/TargetType.jrag:198
   * @apilevel internal
   */
  public boolean Define_stringContext(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getInitOptNoTransform()) {
      // @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/TargetType.jrag:337
      return false;
    }
    else {
      return getParent().Define_stringContext(this, _callerNode);
    }
  }
  protected boolean canDefine_stringContext(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/TargetType.jrag:199
   * @apilevel internal
   */
  public boolean Define_numericContext(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getInitOptNoTransform()) {
      // @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/TargetType.jrag:338
      return false;
    }
    else {
      return getParent().Define_numericContext(this, _callerNode);
    }
  }
  protected boolean canDefine_numericContext(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /** @apilevel internal */
  public ASTNode rewriteTo() {
    return super.rewriteTo();
  }
  /** @apilevel internal */
  public boolean canRewrite() {
    return false;
  }
  protected void collect_contributors_CompilationUnit_problems(CompilationUnit _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
    // @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java7/frontend/UncheckedConversion.jrag:41
    if (hasInit() && !suppressWarnings("unchecked")) {
      {
        java.util.Set<ASTNode> contributors = _map.get(_root);
        if (contributors == null) {
          contributors = new java.util.LinkedHashSet<ASTNode>();
          _map.put((ASTNode) _root, contributors);
        }
        contributors.add(this);
      }
    }
    super.collect_contributors_CompilationUnit_problems(_root, _map);
  }
  protected void contributeTo_CompilationUnit_problems(LinkedList<Problem> collection) {
    super.contributeTo_CompilationUnit_problems(collection);
    if (hasInit() && !suppressWarnings("unchecked")) {
      for (Problem value : uncheckedConversionWarnings(getInit().type(), type())) {
        collection.add(value);
      }
    }
  }
}
