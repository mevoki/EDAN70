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
 * A parameter declaration as used in either method parameter lists
 * or as a catch clause parameter.
 * @ast node
 * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/grammar/Java.ast:90
 * @production ParameterDeclaration : {@link ASTNode} ::= <span class="component">{@link Modifiers}</span> <span class="component">TypeAccess:{@link Access}</span> <span class="component">&lt;ID:String&gt;</span>;

 */
public class ParameterDeclaration extends ASTNode<ASTNode> implements Cloneable, Variable, SimpleSet<Variable> {
  /**
   * @aspect Java4PrettyPrint
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/PrettyPrint.jadd:533
   */
  public void prettyPrint(PrettyPrinter out) {
    out.print(getModifiers());
    out.print(getTypeAccess());
    out.print(" ");
    out.print(getID());
  }
  /**
   * @aspect NodeConstructors
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/NodeConstructors.jrag:32
   */
  public ParameterDeclaration(Access type, String name) {
    this(new Modifiers(new List()), type, name);
  }
  /**
   * @aspect NodeConstructors
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/NodeConstructors.jrag:36
   */
  public ParameterDeclaration(TypeDecl type, String name) {
    this(new Modifiers(new List()), type.createQualifiedAccess(), name);
  }
  /**
   * @aspect DataStructures
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/DataStructures.jrag:369
   */
  @Override
  public int size() {
    return 1;
  }
  /**
   * @aspect DataStructures
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/DataStructures.jrag:374
   */
  @Override
  public boolean isEmpty() {
    return false;
  }
  /**
   * @aspect DataStructures
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/DataStructures.jrag:379
   */
  @Override
  public SimpleSet<Variable> add(Variable o) {
    return new SimpleSetImpl<Variable>(this, o);
  }
  /**
   * @aspect DataStructures
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/DataStructures.jrag:384
   */
  @Override
  public boolean contains(Object o) {
    return this == o;
  }
  /**
   * @aspect DataStructures
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/DataStructures.jrag:389
   */
  @Override
  public boolean isSingleton() {
    return true;
  }
  /**
   * @aspect DataStructures
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/DataStructures.jrag:394
   */
  @Override
  public boolean isSingleton(Variable o) {
    return contains(o);
  }
  /**
   * @aspect DataStructures
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/DataStructures.jrag:399
   */
  @Override
  public Variable singletonValue() {
    return this;
  }
  /**
   * @aspect DataStructures
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/DataStructures.jrag:404
   */
  @Override
  public Iterator<Variable> iterator() {
    return new SingleItemIterator(this);
  }
  /**
   * @declaredat ASTNode:1
   */
  public ParameterDeclaration() {
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
    children = new ASTNode[2];
  }
  /**
   * @declaredat ASTNode:13
   */
  public ParameterDeclaration(Modifiers p0, Access p1, String p2) {
    setChild(p0, 0);
    setChild(p1, 1);
    setID(p2);
  }
  /**
   * @declaredat ASTNode:18
   */
  public ParameterDeclaration(Modifiers p0, Access p1, beaver.Symbol p2) {
    setChild(p0, 0);
    setChild(p1, 1);
    setID(p2);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:24
   */
  protected int numChildren() {
    return 2;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:30
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:34
   */
  public void flushAttrCache() {
    super.flushAttrCache();
    type_reset();
    throwTypes_reset();
    inferredReferenceAccess_TypeAccess_reset();
    enclosingLambda_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:42
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:46
   */
  public ParameterDeclaration clone() throws CloneNotSupportedException {
    ParameterDeclaration node = (ParameterDeclaration) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:51
   */
  public ParameterDeclaration copy() {
    try {
      ParameterDeclaration node = (ParameterDeclaration) clone();
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
   * @declaredat ASTNode:70
   */
  @Deprecated
  public ParameterDeclaration fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:80
   */
  public ParameterDeclaration treeCopyNoTransform() {
    ParameterDeclaration tree = (ParameterDeclaration) copy();
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
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
   * @declaredat ASTNode:100
   */
  public ParameterDeclaration treeCopy() {
    ParameterDeclaration tree = (ParameterDeclaration) copy();
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
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
   * @declaredat ASTNode:114
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node) && (tokenString_ID == ((ParameterDeclaration) node).tokenString_ID);    
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
   * Replaces the TypeAccess child.
   * @param node The new node to replace the TypeAccess child.
   * @apilevel high-level
   */
  public void setTypeAccess(Access node) {
    setChild(node, 1);
  }
  /**
   * Retrieves the TypeAccess child.
   * @return The current node used as the TypeAccess child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="TypeAccess")
  public Access getTypeAccess() {
    return (Access) getChild(1);
  }
  /**
   * Retrieves the TypeAccess child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the TypeAccess child.
   * @apilevel low-level
   */
  public Access getTypeAccessNoTransform() {
    return (Access) getChildNoTransform(1);
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
   * @attribute syn
   * @aspect Variables
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:73
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Variables", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:73")
  public boolean isParameter() {
    boolean isParameter_value = true;
    return isParameter_value;
  }
  /**
   * @attribute syn
   * @aspect Variables
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:75
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Variables", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:75")
  public boolean isConstant() {
    boolean isConstant_value = false;
    return isConstant_value;
  }
  /**
   * @attribute syn
   * @aspect Variables
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:76
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Variables", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:76")
  public boolean isPublic() {
    boolean isPublic_value = false;
    return isPublic_value;
  }
  /**
   * @attribute syn
   * @aspect Variables
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:77
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Variables", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:77")
  public boolean accessibleFrom(TypeDecl type) {
    boolean accessibleFrom_TypeDecl_value = false;
    return accessibleFrom_TypeDecl_value;
  }
  /**
   * @attribute syn
   * @aspect Variables
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:80
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Variables", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:80")
  public boolean isClassVariable() {
    boolean isClassVariable_value = false;
    return isClassVariable_value;
  }
  /**
   * @attribute syn
   * @aspect Variables
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:81
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Variables", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:81")
  public boolean isInstanceVariable() {
    boolean isInstanceVariable_value = false;
    return isInstanceVariable_value;
  }
  /**
   * @attribute syn
   * @aspect Variables
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:85
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Variables", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:85")
  public boolean isLocalVariable() {
    boolean isLocalVariable_value = false;
    return isLocalVariable_value;
  }
  /**
   * @attribute syn
   * @aspect Variables
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:86
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Variables", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:86")
  public boolean isField() {
    boolean isField_value = false;
    return isField_value;
  }
  /**
   * @attribute syn
   * @aspect Variables
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:104
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Variables", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:104")
  public boolean isFinal() {
    boolean isFinal_value = getModifiers().isFinal();
    return isFinal_value;
  }
  /**
   * @attribute syn
   * @aspect Variables
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:105
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Variables", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:105")
  public boolean isVolatile() {
    boolean isVolatile_value = getModifiers().isVolatile();
    return isVolatile_value;
  }
  /**
   * @attribute syn
   * @aspect Variables
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:106
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Variables", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:106")
  public boolean isBlank() {
    boolean isBlank_value = true;
    return isBlank_value;
  }
  /**
   * @attribute syn
   * @aspect Variables
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:107
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Variables", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:107")
  public boolean isStatic() {
    boolean isStatic_value = false;
    return isStatic_value;
  }
  /**
   * @attribute syn
   * @aspect Variables
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:109
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Variables", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:109")
  public String name() {
    String name_value = getID();
    return name_value;
  }
  /**
   * @attribute syn
   * @aspect Variables
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:111
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Variables", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:111")
  public boolean hasInit() {
    boolean hasInit_value = false;
    return hasInit_value;
  }
  /**
   * @attribute syn
   * @aspect Variables
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:112
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Variables", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:112")
  public Expr getInit() {
    {
        throw new UnsupportedOperationException();
      }
  }
  /**
   * @attribute syn
   * @aspect Variables
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:115
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Variables", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:115")
  public Constant constant() {
    {
        throw new UnsupportedOperationException();
      }
  }
  /**
   * @attribute syn
   * @aspect NameCheck
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/NameCheck.jrag:465
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="NameCheck", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/NameCheck.jrag:465")
  public Collection<Problem> nameProblems() {
    {
        Collection<Problem> problems = new LinkedList<Problem>();
        SimpleSet<Variable> decls = outerScope().lookupVariable(name());
        for (Variable var : decls) {
          if (var instanceof VariableDeclarator) {
            VariableDeclarator decl = (VariableDeclarator) var;
            if (decl.enclosingBodyDecl() == enclosingBodyDecl()) {
              problems.add(errorf("duplicate declaration of parameter %s", name()));
            }
          } else if (var instanceof ParameterDeclaration) {
            ParameterDeclaration decl = (ParameterDeclaration) var;
            if (decl.enclosingBodyDecl() == enclosingBodyDecl()) {
              problems.add(errorf("duplicate declaration of parameter %s", name()));
            }
          } else if (var instanceof InferredParameterDeclaration) {
            InferredParameterDeclaration decl = (InferredParameterDeclaration) var;
            if (decl.enclosingBodyDecl() == enclosingBodyDecl()) {
              problems.add(errorf("duplicate declaration of parameter %s", name()));
            }
          } else if (var instanceof CatchParameterDeclaration) {
            CatchParameterDeclaration decl = (CatchParameterDeclaration) var;
            if (decl.enclosingBodyDecl() == enclosingBodyDecl()) {
              problems.add(errorf("duplicate declaration of parameter %s", name()));
            }
          }
        }
    
        // 8.4.1
        if (!lookupVariable(name()).contains(this)) {
          problems.add(errorf("duplicate declaration of parameter %s", name()));
        }
        return problems;
      }
  }
  /**
   * @attribute syn
   * @aspect PrettyPrintUtil
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/PrettyPrintUtil.jrag:225
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="PrettyPrintUtil", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/PrettyPrintUtil.jrag:225")
  public boolean hasModifiers() {
    boolean hasModifiers_value = getModifiers().getNumModifier() > 0;
    return hasModifiers_value;
  }
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/Modifiers.jrag:255
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Modifiers", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/Modifiers.jrag:255")
  public boolean isSynthetic() {
    boolean isSynthetic_value = getModifiers().isSynthetic();
    return isSynthetic_value;
  }
  /** @apilevel internal */
  private void type_reset() {
    type_computed = null;
    type_value = null;
  }
  /** @apilevel internal */
  protected ASTNode$State.Cycle type_computed = null;

  /** @apilevel internal */
  protected TypeDecl type_value;

  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/TypeAnalysis.jrag:273
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/TypeAnalysis.jrag:273")
  public TypeDecl type() {
    ASTNode$State state = state();
    if (type_computed == ASTNode$State.NON_CYCLE || type_computed == state().cycle()) {
      return type_value;
    }
    type_value = getTypeAccess().type();
    if (state().inCircle()) {
      type_computed = state().cycle();
    
    } else {
      type_computed = ASTNode$State.NON_CYCLE;
    
    }
    return type_value;
  }
  /**
   * @attribute syn
   * @aspect VariableArityParameters
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/VariableArityParameters.jrag:59
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="VariableArityParameters", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/VariableArityParameters.jrag:59")
  public boolean isVariableArity() {
    boolean isVariableArity_value = false;
    return isVariableArity_value;
  }
  /**
   * Creates a copy of this parameter declaration where parameterized types have been erased.
   * @attribute syn
   * @aspect LookupParTypeDecl
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/Generics.jrag:1475
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="LookupParTypeDecl", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/Generics.jrag:1475")
  public ParameterDeclaration erasedCopy() {
    ParameterDeclaration erasedCopy_value = new ParameterDeclaration(
              getModifiers().treeCopyNoTransform(),
              getTypeAccess().erasedCopy(),
              getID());
    return erasedCopy_value;
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
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java7/frontend/PreciseRethrow.jrag:47
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="PreciseRethrow", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java7/frontend/PreciseRethrow.jrag:47")
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
      if (isCatchParam() && isEffectivelyFinal()) {
        // The catch parameter must be final to refine the throw type.
        return catchClause().caughtExceptions();
      } else {
        return Collections.singleton(type());
      }
    }
  /**
   * Note: this attribute deviates from what the JLS says about "effectively final",
   * simply because the attribute name would be too confusing if it did not return true
   * when the variable was explicitly declared final. The JLS considers declared final
   * and effectively final to be mutually exclusive, we don't.
   * @attribute syn
   * @aspect PreciseRethrow
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java7/frontend/PreciseRethrow.jrag:65
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="PreciseRethrow", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java7/frontend/PreciseRethrow.jrag:65")
  public boolean isEffectivelyFinal() {
    boolean isEffectivelyFinal_value = isFinal() || !inhModifiedInScope(this);
    return isEffectivelyFinal_value;
  }
  /**
   * Builds a copy of this ParameterDeclaration node where all occurrences
   * of type variables in the original type parameter list have been replaced
   * by the substitution type parameters.
   * 
   * @return the substituted ParameterDeclaration node
   * @attribute syn
   * @aspect Diamond
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java7/frontend/Diamond.jrag:355
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Diamond", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java7/frontend/Diamond.jrag:355")
  public ParameterDeclaration substituted(Collection<TypeVariable> original, List<TypeVariable> substitution) {
    ParameterDeclaration substituted_Collection_TypeVariable__List_TypeVariable__value = new ParameterDeclaration(
            (Modifiers) getModifiers().treeCopyNoTransform(),
            getTypeAccess().substituted(original, substitution),
            getID());
    return substituted_Collection_TypeVariable__List_TypeVariable__value;
  }
  /** @apilevel internal */
  private void inferredReferenceAccess_TypeAccess_reset() {
    inferredReferenceAccess_TypeAccess_values = null;
    inferredReferenceAccess_TypeAccess_list = null;
  }
  /** @apilevel internal */
  protected List inferredReferenceAccess_TypeAccess_list;
  /** @apilevel internal */
  protected java.util.Map inferredReferenceAccess_TypeAccess_values;

  /**
   * @attribute syn
   * @aspect MethodReference
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/MethodReference.jrag:106
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="MethodReference", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/MethodReference.jrag:106")
  public ParTypeAccess inferredReferenceAccess(TypeAccess typeAccess) {
    Object _parameters = typeAccess;
    if (inferredReferenceAccess_TypeAccess_values == null) inferredReferenceAccess_TypeAccess_values = new java.util.HashMap(4);
    ASTNode$State state = state();
    if (inferredReferenceAccess_TypeAccess_values.containsKey(_parameters)) {
      return (ParTypeAccess) inferredReferenceAccess_TypeAccess_values.get(_parameters);
    }
    state().enterLazyAttribute();
    ParTypeAccess inferredReferenceAccess_TypeAccess_value = inferredReferenceAccess_compute(typeAccess);
    if (inferredReferenceAccess_TypeAccess_list == null) {
      inferredReferenceAccess_TypeAccess_list = new List();
      inferredReferenceAccess_TypeAccess_list.setParent(this);
    }
    inferredReferenceAccess_TypeAccess_list.add(inferredReferenceAccess_TypeAccess_value);
    if (inferredReferenceAccess_TypeAccess_value != null) {
      inferredReferenceAccess_TypeAccess_value = (ParTypeAccess) inferredReferenceAccess_TypeAccess_list.getChild(inferredReferenceAccess_TypeAccess_list.numChildren - 1);
    }
    inferredReferenceAccess_TypeAccess_values.put(_parameters, inferredReferenceAccess_TypeAccess_value);
    state().leaveLazyAttribute();
    return inferredReferenceAccess_TypeAccess_value;
  }
  /** @apilevel internal */
  private ParTypeAccess inferredReferenceAccess_compute(TypeAccess typeAccess) {
      if (!(getTypeAccess() instanceof ParTypeAccess)) {
        return new ParTypeAccess((TypeAccess) typeAccess.treeCopy(), new List<Access>());
      }
      ParTypeAccess parTypeAccess = (ParTypeAccess) getTypeAccess();
      return new ParTypeAccess((TypeAccess) typeAccess.treeCopy(),
          (List<Access>) parTypeAccess.getTypeArgumentList().treeCopy());
    }
  /**
   * @attribute syn
   * @aspect UnusedImports
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/src/jastadd/UnusedImports.jrag:8
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="UnusedImports", declaredAt="/home/felix/edan70final/EDAN70/extension-base/src/jastadd/UnusedImports.jrag:8")
  public String accessType() {
    String accessType_value = getTypeAccess().nodeType();
    return accessType_value;
  }
  /**
   * @attribute syn
   * @aspect UnusedImports
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/src/jastadd/UnusedImports.jrag:10
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="UnusedImports", declaredAt="/home/felix/edan70final/EDAN70/extension-base/src/jastadd/UnusedImports.jrag:10")
  public String variableTypeName() {
    String variableTypeName_value = getTypeAccess().myTypeName();
    return variableTypeName_value;
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
  /**
   * @attribute inh
   * @aspect Variables
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:82
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="Variables", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:82")
  public boolean isMethodParameter() {
    boolean isMethodParameter_value = getParent().Define_isMethodParameter(this, null);
    return isMethodParameter_value;
  }
  /**
   * @attribute inh
   * @aspect Variables
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:83
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="Variables", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:83")
  public boolean isConstructorParameter() {
    boolean isConstructorParameter_value = getParent().Define_isConstructorParameter(this, null);
    return isConstructorParameter_value;
  }
  /**
   * @attribute inh
   * @aspect Variables
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:84
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="Variables", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/VariableDeclaration.jrag:84")
  public boolean isExceptionHandlerParameter() {
    boolean isExceptionHandlerParameter_value = getParent().Define_isExceptionHandlerParameter(this, null);
    return isExceptionHandlerParameter_value;
  }
  /**
   * @attribute inh
   * @aspect NameCheck
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/NameCheck.jrag:420
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="NameCheck", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/NameCheck.jrag:420")
  public VariableScope outerScope() {
    VariableScope outerScope_value = getParent().Define_outerScope(this, null);
    return outerScope_value;
  }
  /**
   * @attribute inh
   * @aspect NameCheck
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/NameCheck.jrag:489
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="NameCheck", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/NameCheck.jrag:489")
  public BodyDecl enclosingBodyDecl() {
    BodyDecl enclosingBodyDecl_value = getParent().Define_enclosingBodyDecl(this, null);
    return enclosingBodyDecl_value;
  }
  /**
   * @attribute inh
   * @aspect VariableScope
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/LookupVariable.jrag:46
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="VariableScope", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/LookupVariable.jrag:46")
  public SimpleSet<Variable> lookupVariable(String name) {
    SimpleSet<Variable> lookupVariable_String_value = getParent().Define_lookupVariable(this, null, name);
    return lookupVariable_String_value;
  }
  /**
   * @attribute inh
   * @aspect NestedTypes
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/TypeAnalysis.jrag:652
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="NestedTypes", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/TypeAnalysis.jrag:652")
  public TypeDecl hostType() {
    TypeDecl hostType_value = getParent().Define_hostType(this, null);
    return hostType_value;
  }
  /**
   * @return true if the variable var is modified in the local scope
   * @attribute inh
   * @aspect PreciseRethrow
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java7/frontend/PreciseRethrow.jrag:70
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="PreciseRethrow", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java7/frontend/PreciseRethrow.jrag:70")
  public boolean inhModifiedInScope(Variable var) {
    boolean inhModifiedInScope_Variable_value = getParent().Define_inhModifiedInScope(this, null, var);
    return inhModifiedInScope_Variable_value;
  }
  /**
   * @return true if this is the parameter declaration of a catch clause
   * @attribute inh
   * @aspect PreciseRethrow
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java7/frontend/PreciseRethrow.jrag:202
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="PreciseRethrow", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java7/frontend/PreciseRethrow.jrag:202")
  public boolean isCatchParam() {
    boolean isCatchParam_value = getParent().Define_isCatchParam(this, null);
    return isCatchParam_value;
  }
  /**
   * @attribute inh
   * @aspect PreciseRethrow
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java7/frontend/PreciseRethrow.jrag:208
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="PreciseRethrow", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java7/frontend/PreciseRethrow.jrag:208")
  public CatchClause catchClause() {
    CatchClause catchClause_value = getParent().Define_catchClause(this, null);
    return catchClause_value;
  }
  /**
   * @attribute inh
   * @aspect EnclosingLambda
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/EnclosingLambda.jrag:34
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="EnclosingLambda", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/EnclosingLambda.jrag:34")
  public LambdaExpr enclosingLambda() {
    ASTNode$State state = state();
    if (enclosingLambda_computed == ASTNode$State.NON_CYCLE || enclosingLambda_computed == state().cycle()) {
      return enclosingLambda_value;
    }
    enclosingLambda_value = getParent().Define_enclosingLambda(this, null);
    if (state().inCircle()) {
      enclosingLambda_computed = state().cycle();
    
    } else {
      enclosingLambda_computed = ASTNode$State.NON_CYCLE;
    
    }
    return enclosingLambda_value;
  }
  /** @apilevel internal */
  private void enclosingLambda_reset() {
    enclosingLambda_computed = null;
    enclosingLambda_value = null;
  }
  /** @apilevel internal */
  protected ASTNode$State.Cycle enclosingLambda_computed = null;

  /** @apilevel internal */
  protected LambdaExpr enclosingLambda_value;

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
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/Modifiers.jrag:437
   * @apilevel internal
   */
  public boolean Define_mayBeFinal(ASTNode _callerNode, ASTNode _childNode) {
    if (getModifiersNoTransform() != null && _callerNode == getModifiers()) {
      // @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/Modifiers.jrag:342
      return true;
    }
    else {
      return getParent().Define_mayBeFinal(this, _callerNode);
    }
  }
  protected boolean canDefine_mayBeFinal(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/SyntacticClassification.jrag:36
   * @apilevel internal
   */
  public NameType Define_nameType(ASTNode _callerNode, ASTNode _childNode) {
    if (getTypeAccessNoTransform() != null && _callerNode == getTypeAccess()) {
      // @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/Enums.jrag:99
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
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/Annotations.jrag:131
   * @apilevel internal
   */
  public boolean Define_mayUseAnnotationTarget(ASTNode _callerNode, ASTNode _childNode, String name) {
    if (getModifiersNoTransform() != null && _callerNode == getModifiers()) {
      // @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/Annotations.jrag:150
      return name.equals("PARAMETER");
    }
    else {
      return getParent().Define_mayUseAnnotationTarget(this, _callerNode, name);
    }
  }
  protected boolean canDefine_mayUseAnnotationTarget(ASTNode _callerNode, ASTNode _childNode, String name) {
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
    // @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/NameCheck.jrag:463
    {
      java.util.Set<ASTNode> contributors = _map.get(_root);
      if (contributors == null) {
        contributors = new java.util.LinkedHashSet<ASTNode>();
        _map.put((ASTNode) _root, contributors);
      }
      contributors.add(this);
    }
    super.collect_contributors_CompilationUnit_problems(_root, _map);
  }
  protected void collect_contributors_CompilationUnit_usedTypes(CompilationUnit _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
    // @declaredat /home/felix/edan70final/EDAN70/extension-base/src/jastadd/UnusedImports.jrag:40
    if (getTypeAccess().nodeType().equals("ParTypeAccess")) {
      {
        CompilationUnit target = (CompilationUnit) (compilationUnit());
        java.util.Set<ASTNode> contributors = _map.get(target);
        if (contributors == null) {
          contributors = new java.util.LinkedHashSet<ASTNode>();
          _map.put((ASTNode) target, contributors);
        }
        contributors.add(this);
      }
    }
    // @declaredat /home/felix/edan70final/EDAN70/extension-base/src/jastadd/UnusedImports.jrag:68
    if (getTypeAccess().nodeType().equals("TypeAccess")) {
      {
        CompilationUnit target = (CompilationUnit) (compilationUnit());
        java.util.Set<ASTNode> contributors = _map.get(target);
        if (contributors == null) {
          contributors = new java.util.LinkedHashSet<ASTNode>();
          _map.put((ASTNode) target, contributors);
        }
        contributors.add(this);
      }
    }
    super.collect_contributors_CompilationUnit_usedTypes(_root, _map);
  }
  protected void contributeTo_CompilationUnit_problems(LinkedList<Problem> collection) {
    super.contributeTo_CompilationUnit_problems(collection);
    for (Problem value : nameProblems()) {
      collection.add(value);
    }
  }
  protected void contributeTo_CompilationUnit_usedTypes(HashSet<String> collection) {
    super.contributeTo_CompilationUnit_usedTypes(collection);
    if (getTypeAccess().nodeType().equals("ParTypeAccess")) {
      collection.add(variableTypeName());
    }
    if (getTypeAccess().nodeType().equals("TypeAccess")) {
      collection.add(variableTypeName());
    }
  }
}
