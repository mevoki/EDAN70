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
 * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/grammar/Java.ast:72
 * @production ConstructorDecl : {@link BodyDecl} ::= <span class="component">{@link Modifiers}</span> <span class="component">&lt;ID:String&gt;</span> <span class="component">Parameter:{@link ParameterDeclaration}*</span> <span class="component">Exception:{@link Access}*</span> <span class="component">[ParsedConstructorInvocation:{@link Stmt}]</span> <span class="component">{@link Block}</span> <span class="component">ImplicitConstructorInvocation:{@link Stmt}</span>;

 */
public class ConstructorDecl extends BodyDecl implements Cloneable {
  /**
   * @aspect Java4PrettyPrint
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/PrettyPrint.jadd:269
   */
  public void prettyPrint(PrettyPrinter out) {
    if (!isImplicitConstructor()) {
      if (hasDocComment()) {
        out.print(docComment());
      }
      if (!out.isNewLine()) {
        out.println();
      }
      out.print(getModifiers());
      out.print(getID());
      out.print("(");
      out.join(getParameterList(), new PrettyPrinter.Joiner() {
        @Override
        public void printSeparator(PrettyPrinter out) {
          out.print(", ");
        }
      });
      out.print(")");
      if (hasExceptions()) {
        out.print(" throws ");
        out.join(getExceptionList(), new PrettyPrinter.Joiner() {
          @Override
          public void printSeparator(PrettyPrinter out) {
            out.print(", ");
          }
        });
      }
      out.print(" {");
      out.println();
      out.indent(1);
      out.print(getParsedConstructorInvocationOpt());
      if (!out.isNewLine()) {
        out.println();
      }
      out.indent(1);
      out.join(blockStmts(), new PrettyPrinter.Joiner() {
        @Override
        public void printSeparator(PrettyPrinter out) {
          out.println();
        }
      });
      if (!out.isNewLine()) {
        out.println();
      }
      out.print("}");
    }
  }
  /**
   * @aspect ConstructorDecl
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/LookupConstructor.jrag:202
   */
  public boolean applicable(List<Expr> argList) {
    if (getNumParameter() != argList.getNumChild()) {
      return false;
    }
    for (int i = 0; i < getNumParameter(); i++) {
      TypeDecl arg = argList.getChild(i).type();
      TypeDecl parameter = getParameter(i).type();
      if (!arg.instanceOf(parameter)) {
        return false;
      }
    }
    return true;
  }
  /**
   * Flag to indicate if this constructor is an auto-generated
   * default constructor. Implicit constructors are not pretty
   * printed.
   * @aspect ImplicitConstructor
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/LookupConstructor.jrag:233
   */
  private boolean isImplicitConstructor = false;
  /**
   * Set the default constructor flag. Causes this constructor
   * to not be pretty printed.
   * @aspect ImplicitConstructor
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/LookupConstructor.jrag:239
   */
  public void setImplicitConstructor() {
    isImplicitConstructor = true;
  }
  /**
   * @aspect LookupParTypeDecl
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java5/frontend/Generics.jrag:1313
   */
  public BodyDecl signatureCopy() {
    return new ConstructorDeclSubstituted(
        getModifiers().treeCopyNoTransform(),
        getID(),
        getParameterList().treeCopyNoTransform(),
        getExceptionList().treeCopyNoTransform(),
        new Opt(),
        new Block(),
        this);
  }
  /**
   * @aspect LookupParTypeDecl
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java5/frontend/Generics.jrag:1410
   */
  public BodyDecl erasedCopy() {
    return new ConstructorDeclSubstituted(
        getModifiers().treeCopyNoTransform(),
        getID(),
        erasedParameterList(getParameterList()),
        erasedAccessList(getExceptionList()),
        new Opt<Stmt>(),
        new Block(),
        this);
  }
  /**
   * @declaredat ASTNode:1
   */
  public ConstructorDecl() {
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
    children = new ASTNode[6];
    setChild(new List(), 1);
    setChild(new List(), 2);
    setChild(new Opt(), 3);
  }
  /**
   * @declaredat ASTNode:16
   */
  public ConstructorDecl(Modifiers p0, String p1, List<ParameterDeclaration> p2, List<Access> p3, Opt<Stmt> p4, Block p5) {
    setChild(p0, 0);
    setID(p1);
    setChild(p2, 1);
    setChild(p3, 2);
    setChild(p4, 3);
    setChild(p5, 4);
  }
  /**
   * @declaredat ASTNode:24
   */
  public ConstructorDecl(Modifiers p0, beaver.Symbol p1, List<ParameterDeclaration> p2, List<Access> p3, Opt<Stmt> p4, Block p5) {
    setChild(p0, 0);
    setID(p1);
    setChild(p2, 1);
    setChild(p3, 2);
    setChild(p4, 3);
    setChild(p5, 4);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:33
   */
  protected int numChildren() {
    return 5;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:39
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:43
   */
  public void flushAttrCache() {
    super.flushAttrCache();
    circularThisInvocation_ConstructorDecl_reset();
    assignedAfter_Variable_reset();
    unassignedAfter_Variable_reset();
    name_reset();
    signature_reset();
    sameSignature_ConstructorDecl_reset();
    lessSpecificThan_ConstructorDecl_reset();
    getImplicitConstructorInvocation_reset();
    throwsException_TypeDecl_reset();
    parameterDeclaration_String_reset();
    accessibleFrom_TypeDecl_reset();
    transformed_reset();
    transformedEnumConstructor_reset();
    sourceConstructorDecl_reset();
    handlesException_TypeDecl_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:62
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:66
   */
  public ConstructorDecl clone() throws CloneNotSupportedException {
    ConstructorDecl node = (ConstructorDecl) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:71
   */
  public ConstructorDecl copy() {
    try {
      ConstructorDecl node = (ConstructorDecl) clone();
      node.parent = null;
      if (children != null) {
        node.children = (ASTNode[]) children.clone();
      }
      return node;
    } catch (CloneNotSupportedException e) {
      throw new Error("Error: clone not supported for " + getClass().getName());
    }
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @deprecated Please use treeCopy or treeCopyNoTransform instead
   * @declaredat ASTNode:90
   */
  @Deprecated
  public ConstructorDecl fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:100
   */
  public ConstructorDecl treeCopyNoTransform() {
    ConstructorDecl tree = (ConstructorDecl) copy();
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        switch (i) {
        case 5:
          tree.children[i] = null;
          continue;
        }
        ASTNode child = (ASTNode) children[i];
        if (child != null) {
          child = child.treeCopyNoTransform();
          tree.setChild(child, i);
        }
      }
    }
    return tree;
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The subtree of this node is traversed to trigger rewrites before copy.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:125
   */
  public ConstructorDecl treeCopy() {
    ConstructorDecl tree = (ConstructorDecl) copy();
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        switch (i) {
        case 5:
          tree.children[i] = null;
          continue;
        }
        ASTNode child = (ASTNode) getChild(i);
        if (child != null) {
          child = child.treeCopy();
          tree.setChild(child, i);
        }
      }
    }
    return tree;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:144
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node) && (tokenString_ID == ((ConstructorDecl) node).tokenString_ID);    
  }
  /**
   * Replaces the Modifiers child.
   * @param node The new node to replace the Modifiers child.
   * @apilevel high-level
   */
  public void setModifiers(Modifiers node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the Modifiers child.
   * @return The current node used as the Modifiers child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Modifiers")
  public Modifiers getModifiers() {
    return (Modifiers) getChild(0);
  }
  /**
   * Retrieves the Modifiers child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Modifiers child.
   * @apilevel low-level
   */
  public Modifiers getModifiersNoTransform() {
    return (Modifiers) getChildNoTransform(0);
  }
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
   * Replaces the Parameter list.
   * @param list The new list node to be used as the Parameter list.
   * @apilevel high-level
   */
  public void setParameterList(List<ParameterDeclaration> list) {
    setChild(list, 1);
  }
  /**
   * Retrieves the number of children in the Parameter list.
   * @return Number of children in the Parameter list.
   * @apilevel high-level
   */
  public int getNumParameter() {
    return getParameterList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Parameter list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Parameter list.
   * @apilevel low-level
   */
  public int getNumParameterNoTransform() {
    return getParameterListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Parameter list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Parameter list.
   * @apilevel high-level
   */
  public ParameterDeclaration getParameter(int i) {
    return (ParameterDeclaration) getParameterList().getChild(i);
  }
  /**
   * Check whether the Parameter list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasParameter() {
    return getParameterList().getNumChild() != 0;
  }
  /**
   * Append an element to the Parameter list.
   * @param node The element to append to the Parameter list.
   * @apilevel high-level
   */
  public void addParameter(ParameterDeclaration node) {
    List<ParameterDeclaration> list = (parent == null) ? getParameterListNoTransform() : getParameterList();
    list.addChild(node);
  }
  /** @apilevel low-level 
   */
  public void addParameterNoTransform(ParameterDeclaration node) {
    List<ParameterDeclaration> list = getParameterListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Parameter list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setParameter(ParameterDeclaration node, int i) {
    List<ParameterDeclaration> list = getParameterList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the Parameter list.
   * @return The node representing the Parameter list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Parameter")
  public List<ParameterDeclaration> getParameterList() {
    List<ParameterDeclaration> list = (List<ParameterDeclaration>) getChild(1);
    return list;
  }
  /**
   * Retrieves the Parameter list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Parameter list.
   * @apilevel low-level
   */
  public List<ParameterDeclaration> getParameterListNoTransform() {
    return (List<ParameterDeclaration>) getChildNoTransform(1);
  }
  /**
   * @return the element at index {@code i} in the Parameter list without
   * triggering rewrites.
   */
  public ParameterDeclaration getParameterNoTransform(int i) {
    return (ParameterDeclaration) getParameterListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the Parameter list.
   * @return The node representing the Parameter list.
   * @apilevel high-level
   */
  public List<ParameterDeclaration> getParameters() {
    return getParameterList();
  }
  /**
   * Retrieves the Parameter list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Parameter list.
   * @apilevel low-level
   */
  public List<ParameterDeclaration> getParametersNoTransform() {
    return getParameterListNoTransform();
  }
  /**
   * Replaces the Exception list.
   * @param list The new list node to be used as the Exception list.
   * @apilevel high-level
   */
  public void setExceptionList(List<Access> list) {
    setChild(list, 2);
  }
  /**
   * Retrieves the number of children in the Exception list.
   * @return Number of children in the Exception list.
   * @apilevel high-level
   */
  public int getNumException() {
    return getExceptionList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Exception list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Exception list.
   * @apilevel low-level
   */
  public int getNumExceptionNoTransform() {
    return getExceptionListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Exception list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Exception list.
   * @apilevel high-level
   */
  public Access getException(int i) {
    return (Access) getExceptionList().getChild(i);
  }
  /**
   * Check whether the Exception list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasException() {
    return getExceptionList().getNumChild() != 0;
  }
  /**
   * Append an element to the Exception list.
   * @param node The element to append to the Exception list.
   * @apilevel high-level
   */
  public void addException(Access node) {
    List<Access> list = (parent == null) ? getExceptionListNoTransform() : getExceptionList();
    list.addChild(node);
  }
  /** @apilevel low-level 
   */
  public void addExceptionNoTransform(Access node) {
    List<Access> list = getExceptionListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Exception list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setException(Access node, int i) {
    List<Access> list = getExceptionList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the Exception list.
   * @return The node representing the Exception list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Exception")
  public List<Access> getExceptionList() {
    List<Access> list = (List<Access>) getChild(2);
    return list;
  }
  /**
   * Retrieves the Exception list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Exception list.
   * @apilevel low-level
   */
  public List<Access> getExceptionListNoTransform() {
    return (List<Access>) getChildNoTransform(2);
  }
  /**
   * @return the element at index {@code i} in the Exception list without
   * triggering rewrites.
   */
  public Access getExceptionNoTransform(int i) {
    return (Access) getExceptionListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the Exception list.
   * @return The node representing the Exception list.
   * @apilevel high-level
   */
  public List<Access> getExceptions() {
    return getExceptionList();
  }
  /**
   * Retrieves the Exception list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Exception list.
   * @apilevel low-level
   */
  public List<Access> getExceptionsNoTransform() {
    return getExceptionListNoTransform();
  }
  /**
   * Replaces the optional node for the ParsedConstructorInvocation child. This is the <code>Opt</code>
   * node containing the child ParsedConstructorInvocation, not the actual child!
   * @param opt The new node to be used as the optional node for the ParsedConstructorInvocation child.
   * @apilevel low-level
   */
  public void setParsedConstructorInvocationOpt(Opt<Stmt> opt) {
    setChild(opt, 3);
  }
  /**
   * Replaces the (optional) ParsedConstructorInvocation child.
   * @param node The new node to be used as the ParsedConstructorInvocation child.
   * @apilevel high-level
   */
  public void setParsedConstructorInvocation(Stmt node) {
    getParsedConstructorInvocationOpt().setChild(node, 0);
  }
  /**
   * Check whether the optional ParsedConstructorInvocation child exists.
   * @return {@code true} if the optional ParsedConstructorInvocation child exists, {@code false} if it does not.
   * @apilevel high-level
   */
  public boolean hasParsedConstructorInvocation() {
    return getParsedConstructorInvocationOpt().getNumChild() != 0;
  }
  /**
   * Retrieves the (optional) ParsedConstructorInvocation child.
   * @return The ParsedConstructorInvocation child, if it exists. Returns {@code null} otherwise.
   * @apilevel low-level
   */
  public Stmt getParsedConstructorInvocation() {
    return (Stmt) getParsedConstructorInvocationOpt().getChild(0);
  }
  /**
   * Retrieves the optional node for the ParsedConstructorInvocation child. This is the <code>Opt</code> node containing the child ParsedConstructorInvocation, not the actual child!
   * @return The optional node for child the ParsedConstructorInvocation child.
   * @apilevel low-level
   */
  @ASTNodeAnnotation.OptChild(name="ParsedConstructorInvocation")
  public Opt<Stmt> getParsedConstructorInvocationOpt() {
    return (Opt<Stmt>) getChild(3);
  }
  /**
   * Retrieves the optional node for child ParsedConstructorInvocation. This is the <code>Opt</code> node containing the child ParsedConstructorInvocation, not the actual child!
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The optional node for child ParsedConstructorInvocation.
   * @apilevel low-level
   */
  public Opt<Stmt> getParsedConstructorInvocationOptNoTransform() {
    return (Opt<Stmt>) getChildNoTransform(3);
  }
  /**
   * Replaces the Block child.
   * @param node The new node to replace the Block child.
   * @apilevel high-level
   */
  public void setBlock(Block node) {
    setChild(node, 4);
  }
  /**
   * Retrieves the Block child.
   * @return The current node used as the Block child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Block")
  public Block getBlock() {
    return (Block) getChild(4);
  }
  /**
   * Retrieves the Block child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Block child.
   * @apilevel low-level
   */
  public Block getBlockNoTransform() {
    return (Block) getChildNoTransform(4);
  }
  /**
   * Retrieves the ImplicitConstructorInvocation child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the ImplicitConstructorInvocation child.
   * @apilevel low-level
   */
  public Stmt getImplicitConstructorInvocationNoTransform() {
    return (Stmt) getChildNoTransform(5);
  }
  /**
   * Retrieves the child position of the optional child ImplicitConstructorInvocation.
   * @return The the child position of the optional child ImplicitConstructorInvocation.
   * @apilevel low-level
   */
  protected int getImplicitConstructorInvocationChildPosition() {
    return 5;
  }
  /**
   * @aspect ErrorCheck
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/ErrorCheck.jrag:315
   */
  private boolean refined_ErrorCheck_ConstructorDecl_checkImplicitConstructorInvocation()
{ return !hasParsedConstructorInvocation() && !hostType().isObject(); }
  /**
   * @attribute syn
   * @aspect NameCheck
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/NameCheck.jrag:106
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="NameCheck", declaredAt="/home/felix/EDAN70/extension-base/extendj/java4/frontend/NameCheck.jrag:106")
  public Collection<Problem> nameProblems() {
    {
        Collection<Problem> problems = new LinkedList<Problem>();
        // 8.8
        if (!hostType().name().equals(name())) {
          problems.add(errorf(
              "constructor %s does not have the same name as the simple name of the host class %s",
              name(), hostType().name()));
        }
    
        // 8.8.2
        if (hostType().lookupConstructor(this) != this) {
          problems.add(errorf("constructor with signature %s is multiply declared in type %s",
              signature(), hostType().typeName()));
        }
    
        if (circularThisInvocation(this)) {
          problems.add(errorf("The constructor %s may not directly or indirectly invoke itself",
              signature()));
        }
        return problems;
      }
  }
  /** @apilevel internal */
  private void circularThisInvocation_ConstructorDecl_reset() {
    circularThisInvocation_ConstructorDecl_computed = new java.util.HashMap(4);
    circularThisInvocation_ConstructorDecl_values = null;
  }
  /** @apilevel internal */
  protected java.util.Map circularThisInvocation_ConstructorDecl_values;
  /** @apilevel internal */
  protected java.util.Map circularThisInvocation_ConstructorDecl_computed;
  /**
   * @return {@code true} if this constructor (possibly indirectly) calls the given constructor.
   * @attribute syn
   * @aspect NameCheck
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/NameCheck.jrag:131
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="NameCheck", declaredAt="/home/felix/EDAN70/extension-base/extendj/java4/frontend/NameCheck.jrag:131")
  public boolean circularThisInvocation(ConstructorDecl decl) {
    Object _parameters = decl;
    if (circularThisInvocation_ConstructorDecl_computed == null) circularThisInvocation_ConstructorDecl_computed = new java.util.HashMap(4);
    if (circularThisInvocation_ConstructorDecl_values == null) circularThisInvocation_ConstructorDecl_values = new java.util.HashMap(4);
    ASTNode$State state = state();
    if (circularThisInvocation_ConstructorDecl_values.containsKey(_parameters) && circularThisInvocation_ConstructorDecl_computed != null
        && circularThisInvocation_ConstructorDecl_computed.containsKey(_parameters)
        && (circularThisInvocation_ConstructorDecl_computed.get(_parameters) == ASTNode$State.NON_CYCLE || circularThisInvocation_ConstructorDecl_computed.get(_parameters) == state().cycle())) {
      return (Boolean) circularThisInvocation_ConstructorDecl_values.get(_parameters);
    }
    boolean circularThisInvocation_ConstructorDecl_value = circularThisInvocation_compute(decl);
    if (state().inCircle()) {
      circularThisInvocation_ConstructorDecl_values.put(_parameters, circularThisInvocation_ConstructorDecl_value);
      circularThisInvocation_ConstructorDecl_computed.put(_parameters, state().cycle());
    
    } else {
      circularThisInvocation_ConstructorDecl_values.put(_parameters, circularThisInvocation_ConstructorDecl_value);
      circularThisInvocation_ConstructorDecl_computed.put(_parameters, ASTNode$State.NON_CYCLE);
    
    }
    return circularThisInvocation_ConstructorDecl_value;
  }
  /** @apilevel internal */
  private boolean circularThisInvocation_compute(ConstructorDecl decl) {
      if (hasConstructorInvocation()) {
        Expr e = ((ExprStmt) getConstructorInvocation()).getExpr();
        if (e instanceof ConstructorAccess) {
          ConstructorDecl constructorDecl = ((ConstructorAccess) e).decl();
          if (constructorDecl == decl) {
            return true;
          }
          return constructorDecl.circularThisInvocation(decl);
        }
      }
      return false;
    }
  /** @apilevel internal */
  private void assignedAfter_Variable_reset() {
    assignedAfter_Variable_values = null;
  }
  protected java.util.Map assignedAfter_Variable_values;
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isCircular=true)
  @ASTNodeAnnotation.Source(aspect="DefiniteAssignment", declaredAt="/home/felix/EDAN70/extension-base/extendj/java4/frontend/DefiniteAssignment.jrag:272")
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
        new_assignedAfter_Variable_value = getBlock().assignedAfter(v) && getBlock().assignedAfterReturn(v);
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
      boolean new_assignedAfter_Variable_value = getBlock().assignedAfter(v) && getBlock().assignedAfterReturn(v);
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
  private void unassignedAfter_Variable_reset() {
    unassignedAfter_Variable_values = null;
  }
  protected java.util.Map unassignedAfter_Variable_values;
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isCircular=true)
  @ASTNodeAnnotation.Source(aspect="DefiniteUnassignment", declaredAt="/home/felix/EDAN70/extension-base/extendj/java4/frontend/DefiniteAssignment.jrag:915")
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
        new_unassignedAfter_Variable_value = getBlock().unassignedAfter(v) && getBlock().unassignedAfterReturn(v);
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
      boolean new_unassignedAfter_Variable_value = getBlock().unassignedAfter(v) && getBlock().unassignedAfterReturn(v);
      if (new_unassignedAfter_Variable_value != ((Boolean)_value.value)) {
        state.setChangeInCycle();
        _value.value = new_unassignedAfter_Variable_value;
      }
      return new_unassignedAfter_Variable_value;
    } else {
      return (Boolean) _value.value;
    }
  }
  /**
   * Attribute to determine if the implicit constructor invocation should
   * be checked for semantic errors.
   * 
   * @return {@code true} if this constructor declaration has an implicit
   * constructor invocation
   * @attribute syn
   * @aspect ErrorCheck
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/ErrorCheck.jrag:315
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="ErrorCheck", declaredAt="/home/felix/EDAN70/extension-base/extendj/java4/frontend/ErrorCheck.jrag:315")
  public boolean checkImplicitConstructorInvocation() {
    boolean checkImplicitConstructorInvocation_value = !isOriginalEnumConstructor() && refined_ErrorCheck_ConstructorDecl_checkImplicitConstructorInvocation();
    return checkImplicitConstructorInvocation_value;
  }
  /**
   * @attribute syn
   * @aspect TypeCheck
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/TypeCheck.jrag:566
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeCheck", declaredAt="/home/felix/EDAN70/extension-base/extendj/java4/frontend/TypeCheck.jrag:566")
  public Collection<Problem> typeProblems() {
    {
        Collection<Problem> problems = new LinkedList<Problem>();
        // 8.8.4 (8.4.4)
        TypeDecl exceptionType = typeThrowable();
        for (int i = 0; i < getNumException(); i++) {
          TypeDecl typeDecl = getException(i).type();
          if (!typeDecl.instanceOf(exceptionType)) {
            problems.add(errorf("%s throws non throwable type %s", signature(), typeDecl.fullName()));
          }
        }
        return problems;
      }
  }
  /**
   * @attribute syn
   * @aspect PrettyPrintUtil
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/PrettyPrintUtil.jrag:217
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="PrettyPrintUtil", declaredAt="/home/felix/EDAN70/extension-base/extendj/java4/frontend/PrettyPrintUtil.jrag:217")
  public boolean hasModifiers() {
    boolean hasModifiers_value = getModifiers().getNumModifier() > 0;
    return hasModifiers_value;
  }
  /**
   * @attribute syn
   * @aspect PrettyPrintUtil
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/PrettyPrintUtil.jrag:227
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="PrettyPrintUtil", declaredAt="/home/felix/EDAN70/extension-base/extendj/java4/frontend/PrettyPrintUtil.jrag:227")
  public boolean hasExceptions() {
    boolean hasExceptions_value = getNumException() > 0;
    return hasExceptions_value;
  }
  /**
   * @attribute syn
   * @aspect PrettyPrintUtil
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/PrettyPrintUtil.jrag:229
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="PrettyPrintUtil", declaredAt="/home/felix/EDAN70/extension-base/extendj/java4/frontend/PrettyPrintUtil.jrag:229")
  public List<Stmt> blockStmts() {
    List<Stmt> blockStmts_value = getBlock().getStmtList();
    return blockStmts_value;
  }
  /** @apilevel internal */
  private void name_reset() {
    name_computed = null;
    name_value = null;
  }
  /** @apilevel internal */
  protected ASTNode$State.Cycle name_computed = null;

  /** @apilevel internal */
  protected String name_value;

  /**
   * @attribute syn
   * @aspect ConstructorDecl
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/LookupConstructor.jrag:159
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="ConstructorDecl", declaredAt="/home/felix/EDAN70/extension-base/extendj/java4/frontend/LookupConstructor.jrag:159")
  public String name() {
    ASTNode$State state = state();
    if (name_computed == ASTNode$State.NON_CYCLE || name_computed == state().cycle()) {
      return name_value;
    }
    name_value = getID();
    if (state().inCircle()) {
      name_computed = state().cycle();
    
    } else {
      name_computed = ASTNode$State.NON_CYCLE;
    
    }
    return name_value;
  }
  /** @apilevel internal */
  private void signature_reset() {
    signature_computed = null;
    signature_value = null;
  }
  /** @apilevel internal */
  protected ASTNode$State.Cycle signature_computed = null;

  /** @apilevel internal */
  protected String signature_value;

  /**
   * @attribute syn
   * @aspect ConstructorDecl
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/LookupConstructor.jrag:161
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="ConstructorDecl", declaredAt="/home/felix/EDAN70/extension-base/extendj/java4/frontend/LookupConstructor.jrag:161")
  public String signature() {
    ASTNode$State state = state();
    if (signature_computed == ASTNode$State.NON_CYCLE || signature_computed == state().cycle()) {
      return signature_value;
    }
    signature_value = signature_compute();
    if (state().inCircle()) {
      signature_computed = state().cycle();
    
    } else {
      signature_computed = ASTNode$State.NON_CYCLE;
    
    }
    return signature_value;
  }
  /** @apilevel internal */
  private String signature_compute() {
      StringBuffer s = new StringBuffer();
      s.append(name() + "(");
      for (int i = 0; i < getNumParameter(); i++) {
        s.append(getParameter(i).type().typeName());
        if (i != getNumParameter() - 1) {
          s.append(", ");
        }
      }
      s.append(")");
      return s.toString();
    }
  /** @apilevel internal */
  private void sameSignature_ConstructorDecl_reset() {
    sameSignature_ConstructorDecl_computed = new java.util.HashMap(4);
    sameSignature_ConstructorDecl_values = null;
  }
  /** @apilevel internal */
  protected java.util.Map sameSignature_ConstructorDecl_values;
  /** @apilevel internal */
  protected java.util.Map sameSignature_ConstructorDecl_computed;
  /**
   * @attribute syn
   * @aspect ConstructorDecl
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/LookupConstructor.jrag:175
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="ConstructorDecl", declaredAt="/home/felix/EDAN70/extension-base/extendj/java4/frontend/LookupConstructor.jrag:175")
  public boolean sameSignature(ConstructorDecl c) {
    Object _parameters = c;
    if (sameSignature_ConstructorDecl_computed == null) sameSignature_ConstructorDecl_computed = new java.util.HashMap(4);
    if (sameSignature_ConstructorDecl_values == null) sameSignature_ConstructorDecl_values = new java.util.HashMap(4);
    ASTNode$State state = state();
    if (sameSignature_ConstructorDecl_values.containsKey(_parameters) && sameSignature_ConstructorDecl_computed != null
        && sameSignature_ConstructorDecl_computed.containsKey(_parameters)
        && (sameSignature_ConstructorDecl_computed.get(_parameters) == ASTNode$State.NON_CYCLE || sameSignature_ConstructorDecl_computed.get(_parameters) == state().cycle())) {
      return (Boolean) sameSignature_ConstructorDecl_values.get(_parameters);
    }
    boolean sameSignature_ConstructorDecl_value = sameSignature_compute(c);
    if (state().inCircle()) {
      sameSignature_ConstructorDecl_values.put(_parameters, sameSignature_ConstructorDecl_value);
      sameSignature_ConstructorDecl_computed.put(_parameters, state().cycle());
    
    } else {
      sameSignature_ConstructorDecl_values.put(_parameters, sameSignature_ConstructorDecl_value);
      sameSignature_ConstructorDecl_computed.put(_parameters, ASTNode$State.NON_CYCLE);
    
    }
    return sameSignature_ConstructorDecl_value;
  }
  /** @apilevel internal */
  private boolean sameSignature_compute(ConstructorDecl c) {
      if (!name().equals(c.name())) {
        return false;
      }
      if (c.getNumParameter() != getNumParameter()) {
        return false;
      }
      for (int i = 0; i < getNumParameter(); i++) {
        if (!c.getParameter(i).type().equals(getParameter(i).type())) {
          return false;
        }
      }
      return true;
    }
  /**
   * @attribute syn
   * @aspect ConstructorDecl
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/LookupConstructor.jrag:190
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="ConstructorDecl", declaredAt="/home/felix/EDAN70/extension-base/extendj/java4/frontend/LookupConstructor.jrag:190")
  public boolean moreSpecificThan(ConstructorDecl m) {
    boolean moreSpecificThan_ConstructorDecl_value = m.lessSpecificThan(this) && !this.lessSpecificThan(m);
    return moreSpecificThan_ConstructorDecl_value;
  }
  /** @apilevel internal */
  private void lessSpecificThan_ConstructorDecl_reset() {
    lessSpecificThan_ConstructorDecl_computed = new java.util.HashMap(4);
    lessSpecificThan_ConstructorDecl_values = null;
  }
  /** @apilevel internal */
  protected java.util.Map lessSpecificThan_ConstructorDecl_values;
  /** @apilevel internal */
  protected java.util.Map lessSpecificThan_ConstructorDecl_computed;
  /**
   * @attribute syn
   * @aspect ConstructorDecl
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/LookupConstructor.jrag:193
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="ConstructorDecl", declaredAt="/home/felix/EDAN70/extension-base/extendj/java4/frontend/LookupConstructor.jrag:193")
  public boolean lessSpecificThan(ConstructorDecl m) {
    Object _parameters = m;
    if (lessSpecificThan_ConstructorDecl_computed == null) lessSpecificThan_ConstructorDecl_computed = new java.util.HashMap(4);
    if (lessSpecificThan_ConstructorDecl_values == null) lessSpecificThan_ConstructorDecl_values = new java.util.HashMap(4);
    ASTNode$State state = state();
    if (lessSpecificThan_ConstructorDecl_values.containsKey(_parameters) && lessSpecificThan_ConstructorDecl_computed != null
        && lessSpecificThan_ConstructorDecl_computed.containsKey(_parameters)
        && (lessSpecificThan_ConstructorDecl_computed.get(_parameters) == ASTNode$State.NON_CYCLE || lessSpecificThan_ConstructorDecl_computed.get(_parameters) == state().cycle())) {
      return (Boolean) lessSpecificThan_ConstructorDecl_values.get(_parameters);
    }
    boolean lessSpecificThan_ConstructorDecl_value = lessSpecificThan_compute(m);
    if (state().inCircle()) {
      lessSpecificThan_ConstructorDecl_values.put(_parameters, lessSpecificThan_ConstructorDecl_value);
      lessSpecificThan_ConstructorDecl_computed.put(_parameters, state().cycle());
    
    } else {
      lessSpecificThan_ConstructorDecl_values.put(_parameters, lessSpecificThan_ConstructorDecl_value);
      lessSpecificThan_ConstructorDecl_computed.put(_parameters, ASTNode$State.NON_CYCLE);
    
    }
    return lessSpecificThan_ConstructorDecl_value;
  }
  /** @apilevel internal */
  private boolean lessSpecificThan_compute(ConstructorDecl m) {
      int numA = getNumParameter();
      int numB = m.getNumParameter();
      int num = Math.max(numA, numB);
      for (int i = 0; i < num; i++) {
        TypeDecl t1 = getParameter(Math.min(i, numA - 1)).type();
        TypeDecl t2 = m.getParameter(Math.min(i, numB - 1)).type();
        if (!t1.instanceOf(t2) && !t1.withinBounds(t2)) {
          return true;
        }
      }
      return false;
    }
  /**
   * @return true if this is an auto-generated default constructor
   * @attribute syn
   * @aspect ImplicitConstructor
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/LookupConstructor.jrag:246
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="ImplicitConstructor", declaredAt="/home/felix/EDAN70/extension-base/extendj/java4/frontend/LookupConstructor.jrag:246")
  public boolean isImplicitConstructor() {
    boolean isImplicitConstructor_value = isImplicitConstructor;
    return isImplicitConstructor_value;
  }
  /** @apilevel internal */
  private void getImplicitConstructorInvocation_reset() {
    getImplicitConstructorInvocation_computed = false;
    
    getImplicitConstructorInvocation_value = null;
  }
  /** @apilevel internal */
  protected boolean getImplicitConstructorInvocation_computed = false;

  /** @apilevel internal */
  protected Stmt getImplicitConstructorInvocation_value;

  /**
   * Nonterminal attribute for implicit constructor invocation.
   * This is used when an explicit constructor invocation is missing
   * in a constructor declaration.
   * 
   * The implicit constructor invocation used to be inserted in the
   * same node where the parsed constructor declaration was stored.
   * This meant that it was impossible to distinguish a parsed constructor
   * from an implicit one.
   * @attribute syn nta
   * @aspect ImplicitConstructor
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/LookupConstructor.jrag:353
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="ImplicitConstructor", declaredAt="/home/felix/EDAN70/extension-base/extendj/java4/frontend/LookupConstructor.jrag:353")
  public Stmt getImplicitConstructorInvocation() {
    ASTNode$State state = state();
    if (getImplicitConstructorInvocation_computed) {
      return (Stmt) getChild(getImplicitConstructorInvocationChildPosition());
    }
    state().enterLazyAttribute();
    getImplicitConstructorInvocation_value = new ExprStmt(new SuperConstructorAccess("super", new List<Expr>()));
    setChild(getImplicitConstructorInvocation_value, getImplicitConstructorInvocationChildPosition());
    getImplicitConstructorInvocation_computed = true;
    state().leaveLazyAttribute();
    Stmt node = (Stmt) this.getChild(getImplicitConstructorInvocationChildPosition());
    return node;
  }
  /**
   * Test if there is an explicit or implicit constructor invocation available.
   * This should be false only if the host type is java.lang.Object.
   * @return {@code true} if there is a constructor invocation.
   * @attribute syn
   * @aspect ImplicitConstructor
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/LookupConstructor.jrag:361
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="ImplicitConstructor", declaredAt="/home/felix/EDAN70/extension-base/extendj/java4/frontend/LookupConstructor.jrag:361")
  public boolean hasConstructorInvocation() {
    boolean hasConstructorInvocation_value = hasParsedConstructorInvocation() || !hostType().isObject();
    return hasConstructorInvocation_value;
  }
  /**
   * @attribute syn
   * @aspect ImplicitConstructor
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/LookupConstructor.jrag:364
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="ImplicitConstructor", declaredAt="/home/felix/EDAN70/extension-base/extendj/java4/frontend/LookupConstructor.jrag:364")
  public Stmt getConstructorInvocation() {
    {
        if (hasParsedConstructorInvocation()) {
          return getParsedConstructorInvocation();
        } else {
          return getImplicitConstructorInvocation();
        }
      }
  }
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/Modifiers.jrag:252
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Modifiers", declaredAt="/home/felix/EDAN70/extension-base/extendj/java4/frontend/Modifiers.jrag:252")
  public boolean isSynthetic() {
    boolean isSynthetic_value = getModifiers().isSynthetic();
    return isSynthetic_value;
  }
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/Modifiers.jrag:272
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Modifiers", declaredAt="/home/felix/EDAN70/extension-base/extendj/java4/frontend/Modifiers.jrag:272")
  public boolean isPublic() {
    boolean isPublic_value = getModifiers().isPublic();
    return isPublic_value;
  }
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/Modifiers.jrag:273
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Modifiers", declaredAt="/home/felix/EDAN70/extension-base/extendj/java4/frontend/Modifiers.jrag:273")
  public boolean isPrivate() {
    boolean isPrivate_value = getModifiers().isPrivate();
    return isPrivate_value;
  }
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/Modifiers.jrag:274
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Modifiers", declaredAt="/home/felix/EDAN70/extension-base/extendj/java4/frontend/Modifiers.jrag:274")
  public boolean isProtected() {
    boolean isProtected_value = getModifiers().isProtected();
    return isProtected_value;
  }
  /** @apilevel internal */
  private void throwsException_TypeDecl_reset() {
    throwsException_TypeDecl_computed = new java.util.HashMap(4);
    throwsException_TypeDecl_values = null;
  }
  /** @apilevel internal */
  protected java.util.Map throwsException_TypeDecl_values;
  /** @apilevel internal */
  protected java.util.Map throwsException_TypeDecl_computed;
  /**
   * @attribute syn
   * @aspect ExceptionHandling
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/ExceptionHandling.jrag:222
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="ExceptionHandling", declaredAt="/home/felix/EDAN70/extension-base/extendj/java4/frontend/ExceptionHandling.jrag:222")
  public boolean throwsException(TypeDecl exceptionType) {
    Object _parameters = exceptionType;
    if (throwsException_TypeDecl_computed == null) throwsException_TypeDecl_computed = new java.util.HashMap(4);
    if (throwsException_TypeDecl_values == null) throwsException_TypeDecl_values = new java.util.HashMap(4);
    ASTNode$State state = state();
    if (throwsException_TypeDecl_values.containsKey(_parameters) && throwsException_TypeDecl_computed != null
        && throwsException_TypeDecl_computed.containsKey(_parameters)
        && (throwsException_TypeDecl_computed.get(_parameters) == ASTNode$State.NON_CYCLE || throwsException_TypeDecl_computed.get(_parameters) == state().cycle())) {
      return (Boolean) throwsException_TypeDecl_values.get(_parameters);
    }
    boolean throwsException_TypeDecl_value = throwsException_compute(exceptionType);
    if (state().inCircle()) {
      throwsException_TypeDecl_values.put(_parameters, throwsException_TypeDecl_value);
      throwsException_TypeDecl_computed.put(_parameters, state().cycle());
    
    } else {
      throwsException_TypeDecl_values.put(_parameters, throwsException_TypeDecl_value);
      throwsException_TypeDecl_computed.put(_parameters, ASTNode$State.NON_CYCLE);
    
    }
    return throwsException_TypeDecl_value;
  }
  /** @apilevel internal */
  private boolean throwsException_compute(TypeDecl exceptionType) {
      for (Access exception : getExceptionList()) {
        if (exceptionType.instanceOf(exception.type())) {
          return true;
        }
      }
      return false;
    }
  /** @apilevel internal */
  private void parameterDeclaration_String_reset() {
    parameterDeclaration_String_computed = new java.util.HashMap(4);
    parameterDeclaration_String_values = null;
  }
  /** @apilevel internal */
  protected java.util.Map parameterDeclaration_String_values;
  /** @apilevel internal */
  protected java.util.Map parameterDeclaration_String_computed;
  /**
   * @attribute syn
   * @aspect VariableScope
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/LookupVariable.jrag:183
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="VariableScope", declaredAt="/home/felix/EDAN70/extension-base/extendj/java4/frontend/LookupVariable.jrag:183")
  public SimpleSet<Variable> parameterDeclaration(String name) {
    Object _parameters = name;
    if (parameterDeclaration_String_computed == null) parameterDeclaration_String_computed = new java.util.HashMap(4);
    if (parameterDeclaration_String_values == null) parameterDeclaration_String_values = new java.util.HashMap(4);
    ASTNode$State state = state();
    if (parameterDeclaration_String_values.containsKey(_parameters) && parameterDeclaration_String_computed != null
        && parameterDeclaration_String_computed.containsKey(_parameters)
        && (parameterDeclaration_String_computed.get(_parameters) == ASTNode$State.NON_CYCLE || parameterDeclaration_String_computed.get(_parameters) == state().cycle())) {
      return (SimpleSet<Variable>) parameterDeclaration_String_values.get(_parameters);
    }
    SimpleSet<Variable> parameterDeclaration_String_value = parameterDeclaration_compute(name);
    if (state().inCircle()) {
      parameterDeclaration_String_values.put(_parameters, parameterDeclaration_String_value);
      parameterDeclaration_String_computed.put(_parameters, state().cycle());
    
    } else {
      parameterDeclaration_String_values.put(_parameters, parameterDeclaration_String_value);
      parameterDeclaration_String_computed.put(_parameters, ASTNode$State.NON_CYCLE);
    
    }
    return parameterDeclaration_String_value;
  }
  /** @apilevel internal */
  private SimpleSet<Variable> parameterDeclaration_compute(String name) {
      for (int i = 0; i < getNumParameter(); i++) {
        if (getParameter(i).name().equals(name)) {
          return (ParameterDeclaration) getParameter(i);
        }
      }
      return emptySet();
    }
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/TypeAnalysis.jrag:289
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/home/felix/EDAN70/extension-base/extendj/java4/frontend/TypeAnalysis.jrag:289")
  public TypeDecl type() {
    TypeDecl type_value = unknownType();
    return type_value;
  }
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/TypeAnalysis.jrag:292
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/home/felix/EDAN70/extension-base/extendj/java4/frontend/TypeAnalysis.jrag:292")
  public boolean isVoid() {
    boolean isVoid_value = true;
    return isVoid_value;
  }
  /** @apilevel internal */
  private void accessibleFrom_TypeDecl_reset() {
    accessibleFrom_TypeDecl_computed = new java.util.HashMap(4);
    accessibleFrom_TypeDecl_values = null;
  }
  /** @apilevel internal */
  protected java.util.Map accessibleFrom_TypeDecl_values;
  /** @apilevel internal */
  protected java.util.Map accessibleFrom_TypeDecl_computed;
  /**
   * @attribute syn
   * @aspect AccessControl
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/AccessControl.jrag:122
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="AccessControl", declaredAt="/home/felix/EDAN70/extension-base/extendj/java4/frontend/AccessControl.jrag:122")
  public boolean accessibleFrom(TypeDecl type) {
    Object _parameters = type;
    if (accessibleFrom_TypeDecl_computed == null) accessibleFrom_TypeDecl_computed = new java.util.HashMap(4);
    if (accessibleFrom_TypeDecl_values == null) accessibleFrom_TypeDecl_values = new java.util.HashMap(4);
    ASTNode$State state = state();
    if (accessibleFrom_TypeDecl_values.containsKey(_parameters) && accessibleFrom_TypeDecl_computed != null
        && accessibleFrom_TypeDecl_computed.containsKey(_parameters)
        && (accessibleFrom_TypeDecl_computed.get(_parameters) == ASTNode$State.NON_CYCLE || accessibleFrom_TypeDecl_computed.get(_parameters) == state().cycle())) {
      return (Boolean) accessibleFrom_TypeDecl_values.get(_parameters);
    }
    boolean accessibleFrom_TypeDecl_value = accessibleFrom_compute(type);
    if (state().inCircle()) {
      accessibleFrom_TypeDecl_values.put(_parameters, accessibleFrom_TypeDecl_value);
      accessibleFrom_TypeDecl_computed.put(_parameters, state().cycle());
    
    } else {
      accessibleFrom_TypeDecl_values.put(_parameters, accessibleFrom_TypeDecl_value);
      accessibleFrom_TypeDecl_computed.put(_parameters, ASTNode$State.NON_CYCLE);
    
    }
    return accessibleFrom_TypeDecl_value;
  }
  /** @apilevel internal */
  private boolean accessibleFrom_compute(TypeDecl type) {
      if (!hostType().accessibleFrom(type)) {
        return false;
      } else if (isPublic()) {
        return true;
      } else if (isProtected()) {
        return true;
      } else if (isPrivate()) {
        return hostType().topLevelType() == type.topLevelType();
      } else {
        return hostPackage().equals(type.hostPackage());
      }
    }
  /** @apilevel internal */
  private void transformed_reset() {
    transformed_computed = null;
    transformed_value = null;
  }
  /** @apilevel internal */
  protected ASTNode$State.Cycle transformed_computed = null;

  /** @apilevel internal */
  protected ConstructorDecl transformed_value;

  /**
   * @attribute syn
   * @aspect Enums
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java5/frontend/Enums.jrag:141
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Enums", declaredAt="/home/felix/EDAN70/extension-base/extendj/java5/frontend/Enums.jrag:141")
  public ConstructorDecl transformed() {
    ASTNode$State state = state();
    if (transformed_computed == ASTNode$State.NON_CYCLE || transformed_computed == state().cycle()) {
      return transformed_value;
    }
    transformed_value = transformed_compute();
    if (state().inCircle()) {
      transformed_computed = state().cycle();
    
    } else {
      transformed_computed = ASTNode$State.NON_CYCLE;
    
    }
    return transformed_value;
  }
  /** @apilevel internal */
  private ConstructorDecl transformed_compute() {
      if (isOriginalEnumConstructor()) {
        return transformedEnumConstructor();
      } else {
        return this;
      }
    }
  /** @apilevel internal */
  private void transformedEnumConstructor_reset() {
    transformedEnumConstructor_computed = false;
    
    transformedEnumConstructor_value = null;
  }
  /** @apilevel internal */
  protected boolean transformedEnumConstructor_computed = false;

  /** @apilevel internal */
  protected ConstructorDecl transformedEnumConstructor_value;

  /**
   * @attribute syn
   * @aspect Enums
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java5/frontend/Enums.jrag:149
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="Enums", declaredAt="/home/felix/EDAN70/extension-base/extendj/java5/frontend/Enums.jrag:149")
  public ConstructorDecl transformedEnumConstructor() {
    ASTNode$State state = state();
    if (transformedEnumConstructor_computed) {
      return transformedEnumConstructor_value;
    }
    state().enterLazyAttribute();
    transformedEnumConstructor_value = transformedEnumConstructor_compute();
    transformedEnumConstructor_value.setParent(this);
    transformedEnumConstructor_computed = true;
    state().leaveLazyAttribute();
    return transformedEnumConstructor_value;
  }
  /** @apilevel internal */
  private ConstructorDecl transformedEnumConstructor_compute() {
      List<ParameterDeclaration> parameters = new List<ParameterDeclaration>();
      parameters.add(new ParameterDeclaration(new TypeAccess("java.lang", "String"), "@p0"));
      parameters.add(new ParameterDeclaration(new TypeAccess("int"), "@p1"));
      for (ParameterDeclaration param : getParameterList()) {
        parameters.add(param.treeCopyNoTransform());
      }
      ConstructorAccess constructorInvocation;
      List<Expr> args = new List<Expr>();
      args.add(new VarAccess("@p0"));
      args.add(new VarAccess("@p1"));
      if (hasParsedConstructorInvocation()) {
        ExprStmt invocation = (ExprStmt) getParsedConstructorInvocation();
        ConstructorAccess access = (ConstructorAccess) invocation.getExpr();
        for (Expr arg : access.getArgList()) {
          args.add(arg.treeCopyNoTransform());
        }
        if (access instanceof SuperConstructorAccess) {
          constructorInvocation = new SuperConstructorAccess("super", args);
        } else {
          constructorInvocation = new ConstructorAccess(access.getID(), args);
        }
      } else {
        constructorInvocation = new SuperConstructorAccess("super", args);
      }
      return new ConstructorDecl(
          getModifiers().treeCopyNoTransform(),
          getID(),
          parameters,
          getExceptionList().treeCopyNoTransform(),
          new Opt<Stmt>(new ExprStmt(constructorInvocation)),
          getBlock().treeCopyNoTransform());
    }
  /**
   * Check if the enum constructor has an incorrect access modifier
   * @attribute syn
   * @aspect Enums
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java5/frontend/Enums.jrag:593
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Enums", declaredAt="/home/felix/EDAN70/extension-base/extendj/java5/frontend/Enums.jrag:593")
  public Collection<Problem> enumProblems() {
    {
        Collection<Problem> problems = new LinkedList<Problem>();
        if (hostType().isEnumDecl()) {
          if (isPublic()) {
            problems.add(error("enum constructors can not be declared public"));
          } else if (isProtected()) {
            problems.add(error("enum constructors can not be declared public"));
          }
    
          if (hasParsedConstructorInvocation()) {
            ExprStmt invocation = (ExprStmt) getParsedConstructorInvocation();
            if (invocation.getExpr() instanceof SuperConstructorAccess) {
              problems.add(error("can not call super() in enum constructor"));
            }
          }
        }
        return problems;
      }
  }
  /**
   * @attribute syn
   * @aspect Annotations
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java5/frontend/Annotations.jrag:428
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Annotations", declaredAt="/home/felix/EDAN70/extension-base/extendj/java5/frontend/Annotations.jrag:428")
  public boolean hasAnnotationSuppressWarnings(String annot) {
    boolean hasAnnotationSuppressWarnings_String_value = getModifiers().hasAnnotationSuppressWarnings(annot);
    return hasAnnotationSuppressWarnings_String_value;
  }
  /**
   * @attribute syn
   * @aspect Annotations
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java5/frontend/Annotations.jrag:487
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Annotations", declaredAt="/home/felix/EDAN70/extension-base/extendj/java5/frontend/Annotations.jrag:487")
  public boolean isDeprecated() {
    boolean isDeprecated_value = getModifiers().hasDeprecatedAnnotation();
    return isDeprecated_value;
  }
  /**
   * @attribute syn
   * @aspect VariableArityParameters
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java5/frontend/VariableArityParameters.jrag:56
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="VariableArityParameters", declaredAt="/home/felix/EDAN70/extension-base/extendj/java5/frontend/VariableArityParameters.jrag:56")
  public boolean isVariableArity() {
    boolean isVariableArity_value = getNumParameter() == 0 ? false : getParameter(getNumParameter() - 1).isVariableArity();
    return isVariableArity_value;
  }
  /**
   * @attribute syn
   * @aspect VariableArityParameters
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java5/frontend/VariableArityParameters.jrag:95
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="VariableArityParameters", declaredAt="/home/felix/EDAN70/extension-base/extendj/java5/frontend/VariableArityParameters.jrag:95")
  public ParameterDeclaration lastParameter() {
    ParameterDeclaration lastParameter_value = getParameter(getNumParameter() - 1);
    return lastParameter_value;
  }
  /**
   * @attribute syn
   * @aspect MethodSignature15
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java5/frontend/MethodSignature.jrag:251
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="MethodSignature15", declaredAt="/home/felix/EDAN70/extension-base/extendj/java5/frontend/MethodSignature.jrag:251")
  public boolean applicableBySubtyping(List<Expr> argList) {
    {
        if (getNumParameter() != argList.getNumChild()) {
          return false;
        }
        for (int i = 0; i < getNumParameter(); i++) {
          TypeDecl arg = argList.getChild(i).type();
          TypeDecl param = getParameter(i).type();
          if (!arg.subtype(param)) {
            return false;
          }
        }
        return true;
      }
  }
  /**
   * @attribute syn
   * @aspect MethodSignature15
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java5/frontend/MethodSignature.jrag:277
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="MethodSignature15", declaredAt="/home/felix/EDAN70/extension-base/extendj/java5/frontend/MethodSignature.jrag:277")
  public boolean applicableByMethodInvocationConversion(List<Expr> argList) {
    {
        if (getNumParameter() != argList.getNumChild()) {
          return false;
        }
        for (int i = 0; i < getNumParameter(); i++) {
          TypeDecl arg = argList.getChild(i).type();
          if (!arg.methodInvocationConversionTo(getParameter(i).type())) {
            return false;
          }
        }
        return true;
      }
  }
  /**
   * @attribute syn
   * @aspect MethodSignature15
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java5/frontend/MethodSignature.jrag:305
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="MethodSignature15", declaredAt="/home/felix/EDAN70/extension-base/extendj/java5/frontend/MethodSignature.jrag:305")
  public boolean applicableVariableArity(List argList) {
    {
        for (int i = 0; i < getNumParameter() - 1; i++) {
          TypeDecl arg = ((Expr) argList.getChild(i)).type();
          if (!arg.methodInvocationConversionTo(getParameter(i).type())) {
            return false;
          }
        }
        for (int i = getNumParameter() - 1; i < argList.getNumChild(); i++) {
          TypeDecl arg = ((Expr) argList.getChild(i)).type();
          if (!arg.methodInvocationConversionTo(lastParameter().type().componentType())) {
            return false;
          }
        }
        return true;
      }
  }
  /**
   * Note: isGeneric must be called first to check if this declaration is generic.
   * Otherwise this attribute will throw an error!
   * @return original generic declaration of this constructor.
   * @attribute syn
   * @aspect MethodSignature15
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java5/frontend/MethodSignature.jrag:347
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="MethodSignature15", declaredAt="/home/felix/EDAN70/extension-base/extendj/java5/frontend/MethodSignature.jrag:347")
  public GenericConstructorDecl genericDecl() {
    {
        throw new Error("can not evaulate generic declaration of non-generic constructor");
      }
  }
  /**
   * @attribute syn
   * @aspect MethodSignature15
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java5/frontend/MethodSignature.jrag:487
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="MethodSignature15", declaredAt="/home/felix/EDAN70/extension-base/extendj/java5/frontend/MethodSignature.jrag:487")
  public boolean potentiallyApplicable(List<Expr> argList) {
    {
        int argArity = argList.getNumChild();
        if (!isVariableArity()) {
          if (argArity != arity()) {
            return false;
          }
          for (int i = 0; i < argArity; i++) {
            Expr expr = argList.getChild(i);
            if (!expr.potentiallyCompatible(getParameter(i).type(), this)) {
              return false;
            }
          }
        } else {
        //if (isVariableArity()) {
          if (!(argArity >= arity() - 1)) {
            return false;
          }
          for (int i = 0; i < arity() - 2; i++) {
            Expr expr = argList.getChild(i);
            if (!expr.potentiallyCompatible(getParameter(i).type(), this)) {
              return false;
            }
          }
          TypeDecl varArgType = getParameter(arity() - 1).type();
          if (argArity == arity()) {
            Expr expr = argList.getChild(argArity - 1);
            if (!expr.potentiallyCompatible(varArgType, this)
                && !expr.potentiallyCompatible(varArgType.componentType(), this)) {
              return false;
            }
          } else if (argArity > arity()) {
            for (int i = arity() - 1; i < argArity; i++) {
              Expr expr = argList.getChild(i);
              if (!expr.potentiallyCompatible(varArgType.componentType(), this)) {
                return false;
              }
            }
          }
        }
    
        return true;
      }
  }
  /**
   * @attribute syn
   * @aspect MethodSignature15
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java5/frontend/MethodSignature.jrag:497
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="MethodSignature15", declaredAt="/home/felix/EDAN70/extension-base/extendj/java5/frontend/MethodSignature.jrag:497")
  public int arity() {
    int arity_value = getNumParameter();
    return arity_value;
  }
  /**
   * @attribute syn
   * @aspect LookupParTypeDecl
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java5/frontend/Generics.jrag:1563
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="LookupParTypeDecl", declaredAt="/home/felix/EDAN70/extension-base/extendj/java5/frontend/Generics.jrag:1563")
  public boolean isSubstitutable() {
    boolean isSubstitutable_value = true;
    return isSubstitutable_value;
  }
  /** @apilevel internal */
  private void sourceConstructorDecl_reset() {
    sourceConstructorDecl_computed = null;
    sourceConstructorDecl_value = null;
  }
  /** @apilevel internal */
  protected ASTNode$State.Cycle sourceConstructorDecl_computed = null;

  /** @apilevel internal */
  protected ConstructorDecl sourceConstructorDecl_value;

  /**
   * @attribute syn
   * @aspect SourceDeclarations
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java5/frontend/Generics.jrag:1733
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="SourceDeclarations", declaredAt="/home/felix/EDAN70/extension-base/extendj/java5/frontend/Generics.jrag:1733")
  public ConstructorDecl sourceConstructorDecl() {
    ASTNode$State state = state();
    if (sourceConstructorDecl_computed == ASTNode$State.NON_CYCLE || sourceConstructorDecl_computed == state().cycle()) {
      return sourceConstructorDecl_value;
    }
    sourceConstructorDecl_value = this;
    if (state().inCircle()) {
      sourceConstructorDecl_computed = state().cycle();
    
    } else {
      sourceConstructorDecl_computed = ASTNode$State.NON_CYCLE;
    
    }
    return sourceConstructorDecl_value;
  }
  /**
   * @return true if the modifier list includes the SafeVarargs annotation
   * @attribute syn
   * @aspect SafeVarargs
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java7/frontend/SafeVarargs.jrag:41
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="SafeVarargs", declaredAt="/home/felix/EDAN70/extension-base/extendj/java7/frontend/SafeVarargs.jrag:41")
  public boolean hasAnnotationSafeVarargs() {
    boolean hasAnnotationSafeVarargs_value = getModifiers().hasAnnotationSafeVarargs();
    return hasAnnotationSafeVarargs_value;
  }
  /**
   * It is an error if the SafeVarargs annotation is used on something
   * that is not a variable arity method or constructor.
   * @attribute syn
   * @aspect SafeVarargs
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java7/frontend/SafeVarargs.jrag:72
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="SafeVarargs", declaredAt="/home/felix/EDAN70/extension-base/extendj/java7/frontend/SafeVarargs.jrag:72")
  public boolean hasIllegalAnnotationSafeVarargs() {
    boolean hasIllegalAnnotationSafeVarargs_value = hasAnnotationSafeVarargs() && !isVariableArity();
    return hasIllegalAnnotationSafeVarargs_value;
  }
  /**
   * @attribute syn
   * @aspect PreciseRethrow
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java8/frontend/EffectivelyFinal.jrag:40
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="PreciseRethrow", declaredAt="/home/felix/EDAN70/extension-base/extendj/java8/frontend/EffectivelyFinal.jrag:40")
  public boolean modifiedInScope(Variable var) {
    boolean modifiedInScope_Variable_value = getBlock().modifiedInScope(var);
    return modifiedInScope_Variable_value;
  }
  /**
   * @attribute syn
   * @aspect MethodSignature18
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java8/frontend/MethodSignature.jrag:934
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="MethodSignature18", declaredAt="/home/felix/EDAN70/extension-base/extendj/java8/frontend/MethodSignature.jrag:934")
  public boolean applicableByStrictInvocation(Expr expr, List<Expr> argList) {
    {
        if (getNumParameter() != argList.getNumChild()) {
          return false;
        }
        for (int i = 0; i < getNumParameter(); i++) {
          Expr arg = argList.getChild(i);
          if (!arg.pertinentToApplicability(expr, this, i)) {
            continue;
          }
          if (!arg.compatibleStrictContext(getParameter(i).type())) {
            return false;
          }
        }
        return true;
      }
  }
  /**
   * @attribute syn
   * @aspect MethodSignature18
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java8/frontend/MethodSignature.jrag:950
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="MethodSignature18", declaredAt="/home/felix/EDAN70/extension-base/extendj/java8/frontend/MethodSignature.jrag:950")
  public boolean applicableByLooseInvocation(Expr expr, List<Expr> argList) {
    {
        if (getNumParameter() != argList.getNumChild()) {
          return false;
        }
        for (int i = 0; i < getNumParameter(); i++) {
          Expr arg = argList.getChild(i);
          if (!arg.pertinentToApplicability(expr, this, i)) {
            continue;
          }
          if (!arg.compatibleLooseContext(getParameter(i).type())) {
            return false;
          }
        }
        return true;
      }
  }
  /**
   * @attribute syn
   * @aspect MethodSignature18
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java8/frontend/MethodSignature.jrag:966
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="MethodSignature18", declaredAt="/home/felix/EDAN70/extension-base/extendj/java8/frontend/MethodSignature.jrag:966")
  public boolean applicableByVariableArityInvocation(Expr expr, List<Expr> argList) {
    {
        for (int i = 0; i < getNumParameter() - 1; i++) {
          Expr arg = argList.getChild(i);
          if (!arg.pertinentToApplicability(expr, this, i)) {
            continue;
          }
          if (!arg.compatibleLooseContext(getParameter(i).type())) {
            return false;
          }
        }
        for (int i = getNumParameter() - 1; i < argList.getNumChild(); i++) {
          Expr arg = argList.getChild(i);
          if (!arg.pertinentToApplicability(expr, this, i)) {
            continue;
          }
          if (!arg.compatibleLooseContext(lastParameter().type().componentType())) {
            return false;
          }
        }
        return true;
      }
  }
  /**
   * @attribute inh
   * @aspect ExceptionHandling
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/ExceptionHandling.jrag:94
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="ExceptionHandling", declaredAt="/home/felix/EDAN70/extension-base/extendj/java4/frontend/ExceptionHandling.jrag:94")
  public boolean handlesException(TypeDecl exceptionType) {
    Object _parameters = exceptionType;
    if (handlesException_TypeDecl_computed == null) handlesException_TypeDecl_computed = new java.util.HashMap(4);
    if (handlesException_TypeDecl_values == null) handlesException_TypeDecl_values = new java.util.HashMap(4);
    ASTNode$State state = state();
    if (handlesException_TypeDecl_values.containsKey(_parameters) && handlesException_TypeDecl_computed != null
        && handlesException_TypeDecl_computed.containsKey(_parameters)
        && (handlesException_TypeDecl_computed.get(_parameters) == ASTNode$State.NON_CYCLE || handlesException_TypeDecl_computed.get(_parameters) == state().cycle())) {
      return (Boolean) handlesException_TypeDecl_values.get(_parameters);
    }
    boolean handlesException_TypeDecl_value = getParent().Define_handlesException(this, null, exceptionType);
    if (state().inCircle()) {
      handlesException_TypeDecl_values.put(_parameters, handlesException_TypeDecl_value);
      handlesException_TypeDecl_computed.put(_parameters, state().cycle());
    
    } else {
      handlesException_TypeDecl_values.put(_parameters, handlesException_TypeDecl_value);
      handlesException_TypeDecl_computed.put(_parameters, ASTNode$State.NON_CYCLE);
    
    }
    return handlesException_TypeDecl_value;
  }
  /** @apilevel internal */
  private void handlesException_TypeDecl_reset() {
    handlesException_TypeDecl_computed = new java.util.HashMap(4);
    handlesException_TypeDecl_values = null;
  }
  /** @apilevel internal */
  protected java.util.Map handlesException_TypeDecl_values;
  /** @apilevel internal */
  protected java.util.Map handlesException_TypeDecl_computed;
  /**
   * @attribute inh
   * @aspect TypeAnalysis
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/TypeAnalysis.jrag:288
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/home/felix/EDAN70/extension-base/extendj/java4/frontend/TypeAnalysis.jrag:288")
  public TypeDecl unknownType() {
    TypeDecl unknownType_value = getParent().Define_unknownType(this, null);
    return unknownType_value;
  }
  /**
   * @attribute inh
   * @aspect Enums
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java5/frontend/Enums.jrag:130
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="Enums", declaredAt="/home/felix/EDAN70/extension-base/extendj/java5/frontend/Enums.jrag:130")
  public boolean isOriginalEnumConstructor() {
    boolean isOriginalEnumConstructor_value = getParent().Define_isOriginalEnumConstructor(this, null);
    return isOriginalEnumConstructor_value;
  }
  /**
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/LookupMethod.jrag:52
   * @apilevel internal
   */
  public Collection<MethodDecl> Define_lookupMethod(ASTNode _callerNode, ASTNode _childNode, String name) {
    if (getImplicitConstructorInvocationNoTransform() != null && _callerNode == getImplicitConstructorInvocation()) {
      // @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/LookupMethod.jrag:93
      {
          Collection<MethodDecl> methods = new ArrayList<MethodDecl>();
          for (MethodDecl m : lookupMethod(name)) {
            if (!hostType().memberMethods(name).contains(m) || m.isStatic()) {
              methods.add(m);
            }
          }
          return methods;
        }
    }
    else if (_callerNode == getParsedConstructorInvocationOptNoTransform()) {
      // @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/LookupMethod.jrag:83
      {
          Collection<MethodDecl> methods = new ArrayList<MethodDecl>();
          for (MethodDecl m : lookupMethod(name)) {
            if (!hostType().memberMethods(name).contains(m) || m.isStatic()) {
              methods.add(m);
            }
          }
          return methods;
        }
    }
    else {
      return getParent().Define_lookupMethod(this, _callerNode, name);
    }
  }
  protected boolean canDefine_lookupMethod(ASTNode _callerNode, ASTNode _childNode, String name) {
    return true;
  }
  /**
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java7/frontend/MultiCatch.jrag:44
   * @apilevel internal
   */
  public boolean Define_isMethodParameter(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getParameterListNoTransform()) {
      // @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:89
      int childIndex = _callerNode.getIndexOfChild(_childNode);
      return false;
    }
    else {
      return getParent().Define_isMethodParameter(this, _callerNode);
    }
  }
  protected boolean canDefine_isMethodParameter(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java7/frontend/MultiCatch.jrag:45
   * @apilevel internal
   */
  public boolean Define_isConstructorParameter(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getParameterListNoTransform()) {
      // @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:90
      int childIndex = _callerNode.getIndexOfChild(_childNode);
      return true;
    }
    else {
      return getParent().Define_isConstructorParameter(this, _callerNode);
    }
  }
  protected boolean canDefine_isConstructorParameter(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java7/frontend/MultiCatch.jrag:46
   * @apilevel internal
   */
  public boolean Define_isExceptionHandlerParameter(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getParameterListNoTransform()) {
      // @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:91
      int childIndex = _callerNode.getIndexOfChild(_childNode);
      return false;
    }
    else {
      return getParent().Define_isExceptionHandlerParameter(this, _callerNode);
    }
  }
  protected boolean canDefine_isExceptionHandlerParameter(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/NameCheck.jrag:356
   * @apilevel internal
   */
  public ASTNode Define_enclosingBlock(ASTNode _callerNode, ASTNode _childNode) {
    if (getBlockNoTransform() != null && _callerNode == getBlock()) {
      // @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/NameCheck.jrag:358
      return this;
    }
    else {
      return getParent().Define_enclosingBlock(this, _callerNode);
    }
  }
  protected boolean canDefine_enclosingBlock(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/DefiniteAssignment.jrag:256
   * @apilevel internal
   */
  public boolean Define_assignedBefore(ASTNode _callerNode, ASTNode _childNode, Variable v) {
    if (getBlockNoTransform() != null && _callerNode == getBlock()) {
      // @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/DefiniteAssignment.jrag:349
      return getConstructorInvocation().assignedAfter(v);
    }
    else {
      return super.Define_assignedBefore(_callerNode, _childNode, v);
    }
  }
  protected boolean canDefine_assignedBefore(ASTNode _callerNode, ASTNode _childNode, Variable v) {
    return true;
  }
  /**
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/DefiniteAssignment.jrag:891
   * @apilevel internal
   */
  public boolean Define_unassignedBefore(ASTNode _callerNode, ASTNode _childNode, Variable v) {
    if (getBlockNoTransform() != null && _callerNode == getBlock()) {
      // @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/DefiniteAssignment.jrag:977
      return getConstructorInvocation().unassignedAfter(v);
    }
    else {
      return super.Define_unassignedBefore(_callerNode, _childNode, v);
    }
  }
  protected boolean canDefine_unassignedBefore(ASTNode _callerNode, ASTNode _childNode, Variable v) {
    return true;
  }
  /**
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/SyntacticClassification.jrag:36
   * @apilevel internal
   */
  public NameType Define_nameType(ASTNode _callerNode, ASTNode _childNode) {
    if (getImplicitConstructorInvocationNoTransform() != null && _callerNode == getImplicitConstructorInvocation()) {
      // @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/SyntacticClassification.jrag:136
      return NameType.EXPRESSION_NAME;
    }
    else if (_callerNode == getParsedConstructorInvocationOptNoTransform()) {
      // @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/SyntacticClassification.jrag:135
      return NameType.EXPRESSION_NAME;
    }
    else if (_callerNode == getExceptionListNoTransform()) {
      // @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/SyntacticClassification.jrag:106
      int childIndex = _callerNode.getIndexOfChild(_childNode);
      return NameType.TYPE_NAME;
    }
    else if (_callerNode == getParameterListNoTransform()) {
      // @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/SyntacticClassification.jrag:105
      int childIndex = _callerNode.getIndexOfChild(_childNode);
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
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/UnreachableStatements.jrag:49
   * @apilevel internal
   */
  public boolean Define_reachable(ASTNode _callerNode, ASTNode _childNode) {
    if (getBlockNoTransform() != null && _callerNode == getBlock()) {
      // @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/UnreachableStatements.jrag:57
      return hasParsedConstructorInvocation()
            ? getParsedConstructorInvocation().canCompleteNormally()
            : true;
    }
    else if (getImplicitConstructorInvocationNoTransform() != null && _callerNode == getImplicitConstructorInvocation()) {
      // @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/UnreachableStatements.jrag:53
      return true;
    }
    else if (_callerNode == getParsedConstructorInvocationOptNoTransform()) {
      // @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/UnreachableStatements.jrag:52
      return true;
    }
    else {
      return getParent().Define_reachable(this, _callerNode);
    }
  }
  protected boolean canDefine_reachable(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/TypeCheck.jrag:667
   * @apilevel internal
   */
  public TypeDecl Define_enclosingInstance(ASTNode _callerNode, ASTNode _childNode) {
    if (getImplicitConstructorInvocationNoTransform() != null && _callerNode == getImplicitConstructorInvocation()) {
      // @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/TypeCheck.jrag:688
      return unknownType();
    }
    else if (_callerNode == getParsedConstructorInvocationOptNoTransform()) {
      // @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/TypeCheck.jrag:686
      return unknownType();
    }
    else {
      return getParent().Define_enclosingInstance(this, _callerNode);
    }
  }
  protected boolean canDefine_enclosingInstance(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/Modifiers.jrag:433
   * @apilevel internal
   */
  public boolean Define_mayBePublic(ASTNode _callerNode, ASTNode _childNode) {
    if (getModifiersNoTransform() != null && _callerNode == getModifiers()) {
      // @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/Modifiers.jrag:338
      return true;
    }
    else {
      return getParent().Define_mayBePublic(this, _callerNode);
    }
  }
  protected boolean canDefine_mayBePublic(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/Modifiers.jrag:435
   * @apilevel internal
   */
  public boolean Define_mayBeProtected(ASTNode _callerNode, ASTNode _childNode) {
    if (getModifiersNoTransform() != null && _callerNode == getModifiers()) {
      // @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/Modifiers.jrag:339
      return true;
    }
    else {
      return getParent().Define_mayBeProtected(this, _callerNode);
    }
  }
  protected boolean canDefine_mayBeProtected(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/Modifiers.jrag:434
   * @apilevel internal
   */
  public boolean Define_mayBePrivate(ASTNode _callerNode, ASTNode _childNode) {
    if (getModifiersNoTransform() != null && _callerNode == getModifiers()) {
      // @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/Modifiers.jrag:340
      return true;
    }
    else {
      return getParent().Define_mayBePrivate(this, _callerNode);
    }
  }
  protected boolean canDefine_mayBePrivate(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java7/frontend/TryWithResources.jrag:115
   * @apilevel internal
   */
  public boolean Define_handlesException(ASTNode _callerNode, ASTNode _childNode, TypeDecl exceptionType) {
    if (getImplicitConstructorInvocationNoTransform() != null && _callerNode == getImplicitConstructorInvocation()) {
      // @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/ExceptionHandling.jrag:219
      return throwsException(exceptionType);
    }
    else if (_callerNode == getParsedConstructorInvocationOptNoTransform()) {
      // @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/ExceptionHandling.jrag:216
      return throwsException(exceptionType);
    }
    else if (getBlockNoTransform() != null && _callerNode == getBlock()) {
      // @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/ExceptionHandling.jrag:213
      return throwsException(exceptionType);
    }
    else {
      return getParent().Define_handlesException(this, _callerNode, exceptionType);
    }
  }
  protected boolean canDefine_handlesException(ASTNode _callerNode, ASTNode _childNode, TypeDecl exceptionType) {
    return true;
  }
  /**
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java8/frontend/LookupVariable.jrag:30
   * @apilevel internal
   */
  public SimpleSet<Variable> Define_lookupVariable(ASTNode _callerNode, ASTNode _childNode, String name) {
    if (_callerNode == getParameterListNoTransform()) {
      // @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/LookupVariable.jrag:112
      int childIndex = _callerNode.getIndexOfChild(_childNode);
      return parameterDeclaration(name);
    }
    else if (getImplicitConstructorInvocationNoTransform() != null && _callerNode == getImplicitConstructorInvocation()) {
      // @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/LookupVariable.jrag:99
      {
          SimpleSet<Variable> result = parameterDeclaration(name);
          if (!result.isEmpty()) {
            return result;
          }
          for (Variable v : lookupVariable(name)) {
            if (!hostType().memberFields(name).contains(v) || v.isStatic()) {
              result = result.add(v);
            }
          }
          return result;
        }
    }
    else if (_callerNode == getParsedConstructorInvocationOptNoTransform()) {
      // @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/LookupVariable.jrag:86
      {
          SimpleSet<Variable> result = parameterDeclaration(name);
          if (!result.isEmpty()) {
            return result;
          }
          for (Variable v : lookupVariable(name)) {
            if (!hostType().memberFields(name).contains(v) || v.isStatic()) {
              result = result.add(v);
            }
          }
          return result;
        }
    }
    else if (getBlockNoTransform() != null && _callerNode == getBlock()) {
      // @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/LookupVariable.jrag:78
      {
          SimpleSet<Variable> result = parameterDeclaration(name);
          if (!result.isEmpty()) {
            return result;
          }
          return lookupVariable(name);
        }
    }
    else {
      return getParent().Define_lookupVariable(this, _callerNode, name);
    }
  }
  protected boolean canDefine_lookupVariable(ASTNode _callerNode, ASTNode _childNode, String name) {
    return true;
  }
  /**
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/TypeHierarchyCheck.jrag:189
   * @apilevel internal
   */
  public boolean Define_inExplicitConstructorInvocation(ASTNode _callerNode, ASTNode _childNode) {
    if (getImplicitConstructorInvocationNoTransform() != null && _callerNode == getImplicitConstructorInvocation()) {
      // @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/TypeHierarchyCheck.jrag:195
      return true;
    }
    else if (_callerNode == getParsedConstructorInvocationOptNoTransform()) {
      // @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/TypeHierarchyCheck.jrag:194
      return true;
    }
    else {
      return getParent().Define_inExplicitConstructorInvocation(this, _callerNode);
    }
  }
  protected boolean canDefine_inExplicitConstructorInvocation(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/TypeHierarchyCheck.jrag:197
   * @apilevel internal
   */
  public TypeDecl Define_enclosingExplicitConstructorHostType(ASTNode _callerNode, ASTNode _childNode) {
    if (getImplicitConstructorInvocationNoTransform() != null && _callerNode == getImplicitConstructorInvocation()) {
      // @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/TypeHierarchyCheck.jrag:205
      return hostType();
    }
    else if (_callerNode == getParsedConstructorInvocationOptNoTransform()) {
      // @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/TypeHierarchyCheck.jrag:203
      return hostType();
    }
    else {
      return getParent().Define_enclosingExplicitConstructorHostType(this, _callerNode);
    }
  }
  protected boolean canDefine_enclosingExplicitConstructorHostType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/TypeHierarchyCheck.jrag:208
   * @apilevel internal
   */
  public boolean Define_inStaticContext(ASTNode _callerNode, ASTNode _childNode) {
    if (getImplicitConstructorInvocationNoTransform() != null && _callerNode == getImplicitConstructorInvocation()) {
      // @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/TypeHierarchyCheck.jrag:219
      return false;
    }
    else if (_callerNode == getParsedConstructorInvocationOptNoTransform()) {
      // @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/TypeHierarchyCheck.jrag:218
      return false;
    }
    else if (getBlockNoTransform() != null && _callerNode == getBlock()) {
      // @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/TypeHierarchyCheck.jrag:217
      return false;
    }
    else {
      return getParent().Define_inStaticContext(this, _callerNode);
    }
  }
  protected boolean canDefine_inStaticContext(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java5/frontend/Enums.jrag:566
   * @apilevel internal
   */
  public boolean Define_inEnumInitializer(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return hostType().isEnumDecl();
  }
  protected boolean canDefine_inEnumInitializer(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java5/frontend/Annotations.jrag:131
   * @apilevel internal
   */
  public boolean Define_mayUseAnnotationTarget(ASTNode _callerNode, ASTNode _childNode, String name) {
    if (getModifiersNoTransform() != null && _callerNode == getModifiers()) {
      // @declaredat /home/felix/EDAN70/extension-base/extendj/java5/frontend/Annotations.jrag:158
      return name.equals("CONSTRUCTOR");
    }
    else {
      return getParent().Define_mayUseAnnotationTarget(this, _callerNode, name);
    }
  }
  protected boolean canDefine_mayUseAnnotationTarget(ASTNode _callerNode, ASTNode _childNode, String name) {
    return true;
  }
  /**
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java5/frontend/VariableArityParameters.jrag:46
   * @apilevel internal
   */
  public boolean Define_variableArityValid(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getParameterListNoTransform()) {
      // @declaredat /home/felix/EDAN70/extension-base/extendj/java5/frontend/VariableArityParameters.jrag:41
      int i = _callerNode.getIndexOfChild(_childNode);
      return i == getNumParameter() - 1;
    }
    else {
      return getParent().Define_variableArityValid(this, _callerNode);
    }
  }
  protected boolean canDefine_variableArityValid(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java5/frontend/Generics.jrag:789
   * @apilevel internal
   */
  public String Define_typeVariableContext(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return hostType().typeName() + "." + signature();
  }
  protected boolean canDefine_typeVariableContext(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java8/frontend/EffectivelyFinal.jrag:30
   * @apilevel internal
   */
  public boolean Define_inhModifiedInScope(ASTNode _callerNode, ASTNode _childNode, Variable var) {
    if (getImplicitConstructorInvocationNoTransform() != null && _callerNode == getImplicitConstructorInvocation()) {
      // @declaredat /home/felix/EDAN70/extension-base/extendj/java8/frontend/EffectivelyFinal.jrag:61
      return false;
    }
    else if (_callerNode == getParsedConstructorInvocationOptNoTransform()) {
      // @declaredat /home/felix/EDAN70/extension-base/extendj/java8/frontend/EffectivelyFinal.jrag:60
      return false;
    }
    else if (_callerNode == getParameterListNoTransform()) {
      // @declaredat /home/felix/EDAN70/extension-base/extendj/java8/frontend/EffectivelyFinal.jrag:110
      int childIndex = _callerNode.getIndexOfChild(_childNode);
      {
          return getBlock().modifiedInScope(var) || getConstructorInvocation().modifiedInScope(var);
        }
    }
    else {
      return getParent().Define_inhModifiedInScope(this, _callerNode, var);
    }
  }
  protected boolean canDefine_inhModifiedInScope(ASTNode _callerNode, ASTNode _childNode, Variable var) {
    return true;
  }
  /**
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java7/frontend/PreciseRethrow.jrag:202
   * @apilevel internal
   */
  public boolean Define_isCatchParam(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getParameterListNoTransform()) {
      // @declaredat /home/felix/EDAN70/extension-base/extendj/java7/frontend/PreciseRethrow.jrag:204
      int childIndex = _callerNode.getIndexOfChild(_childNode);
      return false;
    }
    else {
      return getParent().Define_isCatchParam(this, _callerNode);
    }
  }
  protected boolean canDefine_isCatchParam(ASTNode _callerNode, ASTNode _childNode) {
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
    // @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/NameCheck.jrag:104
    {
      java.util.Set<ASTNode> contributors = _map.get(_root);
      if (contributors == null) {
        contributors = new java.util.LinkedHashSet<ASTNode>();
        _map.put((ASTNode) _root, contributors);
      }
      contributors.add(this);
    }
    // @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/TypeCheck.jrag:564
    {
      java.util.Set<ASTNode> contributors = _map.get(_root);
      if (contributors == null) {
        contributors = new java.util.LinkedHashSet<ASTNode>();
        _map.put((ASTNode) _root, contributors);
      }
      contributors.add(this);
    }
    // @declaredat /home/felix/EDAN70/extension-base/extendj/java5/frontend/Enums.jrag:588
    {
      java.util.Set<ASTNode> contributors = _map.get(_root);
      if (contributors == null) {
        contributors = new java.util.LinkedHashSet<ASTNode>();
        _map.put((ASTNode) _root, contributors);
      }
      contributors.add(this);
    }


  // Add problem contributions from the implicit constructor invocation NTA.
  
{
    if (checkImplicitConstructorInvocation()) {
      getImplicitConstructorInvocation().collect_contributors_CompilationUnit_problems(_root, _map);
    }
    super.collect_contributors_CompilationUnit_problems(_root, _map);
  }
  }
  protected void contributeTo_CompilationUnit_problems(LinkedList<Problem> collection) {
    super.contributeTo_CompilationUnit_problems(collection);
    for (Problem value : nameProblems()) {
      collection.add(value);
    }
    for (Problem value : typeProblems()) {
      collection.add(value);
    }
    for (Problem value : enumProblems()) {
      collection.add(value);
    }
  }
}
