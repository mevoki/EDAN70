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
 * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/grammar/Generics.ast:18
 * @production ParInterfaceDecl : {@link InterfaceDecl} ::= <span class="component">TypeParameter:{@link TypeVariable}*</span> <span class="component">&lt;Parameterization:Parameterization&gt;</span> <span class="component">SuperInterface:{@link Access}*</span> <span class="component">{@link BodyDecl}*</span>;

 */
public class ParInterfaceDecl extends InterfaceDecl implements Cloneable, ParTypeDecl, MemberSubstitutor {
  /**
   * @aspect GenericsParTypeDecl
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/GenericsParTypeDecl.jrag:107
   */
  public Access createQualifiedAccess() {
    List typeArgumentList = new List();
    for (TypeDecl arg : getParameterization().args) {
      typeArgumentList.add(arg.createQualifiedAccess());
    }
    if (!isTopLevelType()) {
      if (isRawType()) {
        return enclosingType().createQualifiedAccess()
            .qualifiesAccess(new TypeAccess("", getID()));
      } else {
        return enclosingType().createQualifiedAccess()
            .qualifiesAccess(new ParTypeAccess(new TypeAccess("", getID()), typeArgumentList));
      }
    } else {
      if (isRawType()) {
        return new TypeAccess(packageName(), getID());
      } else {
        return new ParTypeAccess(new TypeAccess(packageName(), getID()), typeArgumentList);
      }
    }
  }
  /**
   * @aspect LookupParTypeDecl
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/Generics.jrag:1134
   */
  public int numTypeParameter() {
    return ((GenericTypeDecl) original()).getNumTypeParameter();
  }
  /**
   * @aspect LookupParTypeDecl
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/Generics.jrag:1138
   */
  public TypeVariable typeParameter(int index) {
    return ((GenericTypeDecl) original()).getTypeParameter(index);
  }
  /**
   * @declaredat ASTNode:1
   */
  public ParInterfaceDecl() {
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
    children = new ASTNode[4];
    setChild(new List(), 1);
    setChild(new List(), 2);
    setChild(new List(), 3);
  }
  /**
   * @declaredat ASTNode:16
   */
  public ParInterfaceDecl(Modifiers p0, String p1, List<TypeVariable> p2, Parameterization p3, List<Access> p4, List<BodyDecl> p5) {
    setChild(p0, 0);
    setID(p1);
    setChild(p2, 1);
    setParameterization(p3);
    setChild(p4, 2);
    setChild(p5, 3);
  }
  /**
   * @declaredat ASTNode:24
   */
  public ParInterfaceDecl(Modifiers p0, beaver.Symbol p1, List<TypeVariable> p2, Parameterization p3, List<Access> p4, List<BodyDecl> p5) {
    setChild(p0, 0);
    setID(p1);
    setChild(p2, 1);
    setParameterization(p3);
    setChild(p4, 2);
    setChild(p5, 3);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:33
   */
  protected int numChildren() {
    return 4;
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
    involvesTypeParameters_reset();
    subtype_TypeDecl_reset();
    sameStructure_TypeDecl_reset();
    instanceOf_TypeDecl_reset();
    erasure_reset();
    strictSubtype_TypeDecl_reset();
    isFunctional_reset();
    fullName_reset();
    typeName_reset();
    unimplementedMethods_reset();
    sameSignature_java_util_List_TypeDecl__reset();
    usesTypeVariable_reset();
    sourceTypeDecl_reset();
    firstTypeArgument_reset();
    localMethodsSignatureMap_reset();
    localFields_String_reset();
    localTypeDecls_String_reset();
    genericDecl_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:65
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:69
   */
  public ParInterfaceDecl clone() throws CloneNotSupportedException {
    ParInterfaceDecl node = (ParInterfaceDecl) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:74
   */
  public ParInterfaceDecl copy() {
    try {
      ParInterfaceDecl node = (ParInterfaceDecl) clone();
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
   * @declaredat ASTNode:93
   */
  @Deprecated
  public ParInterfaceDecl fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:103
   */
  public ParInterfaceDecl treeCopyNoTransform() {
    ParInterfaceDecl tree = (ParInterfaceDecl) copy();
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
   * @declaredat ASTNode:123
   */
  public ParInterfaceDecl treeCopy() {
    ParInterfaceDecl tree = (ParInterfaceDecl) copy();
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
   * @declaredat ASTNode:137
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node) && (tokenString_ID == ((ParInterfaceDecl) node).tokenString_ID) && (tokenParameterization_Parameterization == ((ParInterfaceDecl) node).tokenParameterization_Parameterization);    
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
   * Replaces the TypeParameter list.
   * @param list The new list node to be used as the TypeParameter list.
   * @apilevel high-level
   */
  public void setTypeParameterList(List<TypeVariable> list) {
    setChild(list, 1);
  }
  /**
   * Retrieves the number of children in the TypeParameter list.
   * @return Number of children in the TypeParameter list.
   * @apilevel high-level
   */
  public int getNumTypeParameter() {
    return getTypeParameterList().getNumChild();
  }
  /**
   * Retrieves the number of children in the TypeParameter list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the TypeParameter list.
   * @apilevel low-level
   */
  public int getNumTypeParameterNoTransform() {
    return getTypeParameterListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the TypeParameter list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the TypeParameter list.
   * @apilevel high-level
   */
  public TypeVariable getTypeParameter(int i) {
    return (TypeVariable) getTypeParameterList().getChild(i);
  }
  /**
   * Check whether the TypeParameter list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasTypeParameter() {
    return getTypeParameterList().getNumChild() != 0;
  }
  /**
   * Append an element to the TypeParameter list.
   * @param node The element to append to the TypeParameter list.
   * @apilevel high-level
   */
  public void addTypeParameter(TypeVariable node) {
    List<TypeVariable> list = (parent == null) ? getTypeParameterListNoTransform() : getTypeParameterList();
    list.addChild(node);
  }
  /** @apilevel low-level 
   */
  public void addTypeParameterNoTransform(TypeVariable node) {
    List<TypeVariable> list = getTypeParameterListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the TypeParameter list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setTypeParameter(TypeVariable node, int i) {
    List<TypeVariable> list = getTypeParameterList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the TypeParameter list.
   * @return The node representing the TypeParameter list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="TypeParameter")
  public List<TypeVariable> getTypeParameterList() {
    List<TypeVariable> list = (List<TypeVariable>) getChild(1);
    return list;
  }
  /**
   * Retrieves the TypeParameter list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the TypeParameter list.
   * @apilevel low-level
   */
  public List<TypeVariable> getTypeParameterListNoTransform() {
    return (List<TypeVariable>) getChildNoTransform(1);
  }
  /**
   * @return the element at index {@code i} in the TypeParameter list without
   * triggering rewrites.
   */
  public TypeVariable getTypeParameterNoTransform(int i) {
    return (TypeVariable) getTypeParameterListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the TypeParameter list.
   * @return The node representing the TypeParameter list.
   * @apilevel high-level
   */
  public List<TypeVariable> getTypeParameters() {
    return getTypeParameterList();
  }
  /**
   * Retrieves the TypeParameter list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the TypeParameter list.
   * @apilevel low-level
   */
  public List<TypeVariable> getTypeParametersNoTransform() {
    return getTypeParameterListNoTransform();
  }
  /**
   * Replaces the lexeme Parameterization.
   * @param value The new value for the lexeme Parameterization.
   * @apilevel high-level
   */
  public void setParameterization(Parameterization value) {
    tokenParameterization_Parameterization = value;
  }
  /** @apilevel internal 
   */
  protected Parameterization tokenParameterization_Parameterization;
  /**
   * Retrieves the value for the lexeme Parameterization.
   * @return The value for the lexeme Parameterization.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="Parameterization")
  public Parameterization getParameterization() {
    return tokenParameterization_Parameterization;
  }
  /**
   * Replaces the SuperInterface list.
   * @param list The new list node to be used as the SuperInterface list.
   * @apilevel high-level
   */
  public void setSuperInterfaceList(List<Access> list) {
    setChild(list, 2);
  }
  /**
   * Retrieves the number of children in the SuperInterface list.
   * @return Number of children in the SuperInterface list.
   * @apilevel high-level
   */
  public int getNumSuperInterface() {
    return getSuperInterfaceList().getNumChild();
  }
  /**
   * Retrieves the number of children in the SuperInterface list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the SuperInterface list.
   * @apilevel low-level
   */
  public int getNumSuperInterfaceNoTransform() {
    return getSuperInterfaceListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the SuperInterface list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the SuperInterface list.
   * @apilevel high-level
   */
  public Access getSuperInterface(int i) {
    return (Access) getSuperInterfaceList().getChild(i);
  }
  /**
   * Check whether the SuperInterface list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasSuperInterface() {
    return getSuperInterfaceList().getNumChild() != 0;
  }
  /**
   * Append an element to the SuperInterface list.
   * @param node The element to append to the SuperInterface list.
   * @apilevel high-level
   */
  public void addSuperInterface(Access node) {
    List<Access> list = (parent == null) ? getSuperInterfaceListNoTransform() : getSuperInterfaceList();
    list.addChild(node);
  }
  /** @apilevel low-level 
   */
  public void addSuperInterfaceNoTransform(Access node) {
    List<Access> list = getSuperInterfaceListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the SuperInterface list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setSuperInterface(Access node, int i) {
    List<Access> list = getSuperInterfaceList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the SuperInterface list.
   * @return The node representing the SuperInterface list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="SuperInterface")
  public List<Access> getSuperInterfaceList() {
    List<Access> list = (List<Access>) getChild(2);
    return list;
  }
  /**
   * Retrieves the SuperInterface list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the SuperInterface list.
   * @apilevel low-level
   */
  public List<Access> getSuperInterfaceListNoTransform() {
    return (List<Access>) getChildNoTransform(2);
  }
  /**
   * @return the element at index {@code i} in the SuperInterface list without
   * triggering rewrites.
   */
  public Access getSuperInterfaceNoTransform(int i) {
    return (Access) getSuperInterfaceListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the SuperInterface list.
   * @return The node representing the SuperInterface list.
   * @apilevel high-level
   */
  public List<Access> getSuperInterfaces() {
    return getSuperInterfaceList();
  }
  /**
   * Retrieves the SuperInterface list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the SuperInterface list.
   * @apilevel low-level
   */
  public List<Access> getSuperInterfacesNoTransform() {
    return getSuperInterfaceListNoTransform();
  }
  /**
   * Replaces the BodyDecl list.
   * @param list The new list node to be used as the BodyDecl list.
   * @apilevel high-level
   */
  public void setBodyDeclList(List<BodyDecl> list) {
    setChild(list, 3);
  }
  /**
   * Retrieves the number of children in the BodyDecl list.
   * @return Number of children in the BodyDecl list.
   * @apilevel high-level
   */
  public int getNumBodyDecl() {
    return getBodyDeclList().getNumChild();
  }
  /**
   * Retrieves the number of children in the BodyDecl list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the BodyDecl list.
   * @apilevel low-level
   */
  public int getNumBodyDeclNoTransform() {
    return getBodyDeclListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the BodyDecl list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the BodyDecl list.
   * @apilevel high-level
   */
  public BodyDecl getBodyDecl(int i) {
    return (BodyDecl) getBodyDeclList().getChild(i);
  }
  /**
   * Check whether the BodyDecl list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasBodyDecl() {
    return getBodyDeclList().getNumChild() != 0;
  }
  /**
   * Append an element to the BodyDecl list.
   * @param node The element to append to the BodyDecl list.
   * @apilevel high-level
   */
  public void addBodyDecl(BodyDecl node) {
    List<BodyDecl> list = (parent == null) ? getBodyDeclListNoTransform() : getBodyDeclList();
    list.addChild(node);
  }
  /** @apilevel low-level 
   */
  public void addBodyDeclNoTransform(BodyDecl node) {
    List<BodyDecl> list = getBodyDeclListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the BodyDecl list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setBodyDecl(BodyDecl node, int i) {
    List<BodyDecl> list = getBodyDeclList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the BodyDecl list.
   * @return The node representing the BodyDecl list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="BodyDecl")
  public List<BodyDecl> getBodyDeclList() {
    List<BodyDecl> list = (List<BodyDecl>) getChild(3);
    return list;
  }
  /**
   * Retrieves the BodyDecl list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the BodyDecl list.
   * @apilevel low-level
   */
  public List<BodyDecl> getBodyDeclListNoTransform() {
    return (List<BodyDecl>) getChildNoTransform(3);
  }
  /**
   * @return the element at index {@code i} in the BodyDecl list without
   * triggering rewrites.
   */
  public BodyDecl getBodyDeclNoTransform(int i) {
    return (BodyDecl) getBodyDeclListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the BodyDecl list.
   * @return The node representing the BodyDecl list.
   * @apilevel high-level
   */
  public List<BodyDecl> getBodyDecls() {
    return getBodyDeclList();
  }
  /**
   * Retrieves the BodyDecl list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the BodyDecl list.
   * @apilevel low-level
   */
  public List<BodyDecl> getBodyDeclsNoTransform() {
    return getBodyDeclListNoTransform();
  }
/** @apilevel internal */
protected ASTNode$State.Cycle involvesTypeParameters_cycle = null;
  /** @apilevel internal */
  private void involvesTypeParameters_reset() {
    involvesTypeParameters_computed = false;
    involvesTypeParameters_initialized = false;
    involvesTypeParameters_cycle = null;
  }
  /** @apilevel internal */
  protected boolean involvesTypeParameters_computed = false;

  /** @apilevel internal */
  protected boolean involvesTypeParameters_value;
  /** @apilevel internal */
  protected boolean involvesTypeParameters_initialized = false;
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isCircular=true)
  @ASTNodeAnnotation.Source(aspect="GenericMethodsInference", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/GenericMethodsInference.jrag:37")
  public boolean involvesTypeParameters() {
    if (involvesTypeParameters_computed) {
      return involvesTypeParameters_value;
    }
    ASTNode$State state = state();
    if (!involvesTypeParameters_initialized) {
      involvesTypeParameters_initialized = true;
      involvesTypeParameters_value = false;
    }
    if (!state.inCircle() || state.calledByLazyAttribute()) {
      state.enterCircle();
      do {
        involvesTypeParameters_cycle = state.nextCycle();
        boolean new_involvesTypeParameters_value = involvesTypeParameters_compute();
        if (new_involvesTypeParameters_value != involvesTypeParameters_value) {
          state.setChangeInCycle();
        }
        involvesTypeParameters_value = new_involvesTypeParameters_value;
      } while (state.testAndClearChangeInCycle());
      involvesTypeParameters_computed = true;

      state.leaveCircle();
    } else if (involvesTypeParameters_cycle != state.cycle()) {
      involvesTypeParameters_cycle = state.cycle();
      boolean new_involvesTypeParameters_value = involvesTypeParameters_compute();
      if (new_involvesTypeParameters_value != involvesTypeParameters_value) {
        state.setChangeInCycle();
      }
      involvesTypeParameters_value = new_involvesTypeParameters_value;
    } else {
    }
    return involvesTypeParameters_value;
  }
  /** @apilevel internal */
  private boolean involvesTypeParameters_compute() {
      for (TypeDecl arg : getParameterization().args) {
        if (arg.involvesTypeParameters()) {
          return true;
        }
      }
      return false;
    }
  /**
   * @attribute syn
   * @aspect GenericsSubtype
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/GenericsSubtype.jrag:37
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="GenericsSubtype", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/GenericsSubtype.jrag:37")
  public boolean supertypeGenericClassDecl(GenericClassDecl type) {
    boolean supertypeGenericClassDecl_GenericClassDecl_value = type.subtype(genericDecl().original());
    return supertypeGenericClassDecl_GenericClassDecl_value;
  }
  /**
   * @attribute syn
   * @aspect GenericsSubtype
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/GenericsSubtype.jrag:43
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="GenericsSubtype", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/GenericsSubtype.jrag:43")
  public boolean supertypeGenericInterfaceDecl(GenericInterfaceDecl type) {
    boolean supertypeGenericInterfaceDecl_GenericInterfaceDecl_value = type.subtype(genericDecl().original());
    return supertypeGenericInterfaceDecl_GenericInterfaceDecl_value;
  }
  /**
   * @attribute syn
   * @aspect GenericsSubtype
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/GenericsSubtype.jrag:505
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="GenericsSubtype", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/GenericsSubtype.jrag:505")
  public boolean supertypeClassDecl(ClassDecl type) {
    boolean supertypeClassDecl_ClassDecl_value = super.supertypeClassDecl(type);
    return supertypeClassDecl_ClassDecl_value;
  }
  /** @apilevel internal */
  private void subtype_TypeDecl_reset() {
    subtype_TypeDecl_values = null;
  }
  protected java.util.Map subtype_TypeDecl_values;
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isCircular=true)
  @ASTNodeAnnotation.Source(aspect="GenericsSubtype", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/GenericsSubtype.jrag:490")
  public boolean subtype(TypeDecl type) {
    Object _parameters = type;
    if (subtype_TypeDecl_values == null) subtype_TypeDecl_values = new java.util.HashMap(4);
    ASTNode$State.CircularValue _value;
    if (subtype_TypeDecl_values.containsKey(_parameters)) {
      Object _cache = subtype_TypeDecl_values.get(_parameters);
      if (!(_cache instanceof ASTNode$State.CircularValue)) {
        return (Boolean) _cache;
      } else {
        _value = (ASTNode$State.CircularValue) _cache;
      }
    } else {
      _value = new ASTNode$State.CircularValue();
      subtype_TypeDecl_values.put(_parameters, _value);
      _value.value = true;
    }
    ASTNode$State state = state();
    if (!state.inCircle() || state.calledByLazyAttribute()) {
      state.enterCircle();
      boolean new_subtype_TypeDecl_value;
      do {
        _value.cycle = state.nextCycle();
        new_subtype_TypeDecl_value = type.supertypeParInterfaceDecl(this);
        if (new_subtype_TypeDecl_value != ((Boolean)_value.value)) {
          state.setChangeInCycle();
          _value.value = new_subtype_TypeDecl_value;
        }
      } while (state.testAndClearChangeInCycle());
      subtype_TypeDecl_values.put(_parameters, new_subtype_TypeDecl_value);

      state.leaveCircle();
      return new_subtype_TypeDecl_value;
    } else if (_value.cycle != state.cycle()) {
      _value.cycle = state.cycle();
      boolean new_subtype_TypeDecl_value = type.supertypeParInterfaceDecl(this);
      if (new_subtype_TypeDecl_value != ((Boolean)_value.value)) {
        state.setChangeInCycle();
        _value.value = new_subtype_TypeDecl_value;
      }
      return new_subtype_TypeDecl_value;
    } else {
      return (Boolean) _value.value;
    }
  }
  /**
   * @attribute syn
   * @aspect GenericsSubtype
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/GenericsSubtype.jrag:49
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="GenericsSubtype", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/GenericsSubtype.jrag:49")
  public boolean supertypeRawClassDecl(RawClassDecl type) {
    boolean supertypeRawClassDecl_RawClassDecl_value = type.genericDecl().original().subtype(genericDecl().original());
    return supertypeRawClassDecl_RawClassDecl_value;
  }
  /**
   * @attribute syn
   * @aspect GenericsSubtype
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/GenericsSubtype.jrag:53
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="GenericsSubtype", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/GenericsSubtype.jrag:53")
  public boolean supertypeRawInterfaceDecl(RawInterfaceDecl type) {
    boolean supertypeRawInterfaceDecl_RawInterfaceDecl_value = type.genericDecl().original().subtype(genericDecl().original());
    return supertypeRawInterfaceDecl_RawInterfaceDecl_value;
  }
  /** @apilevel internal */
  private void sameStructure_TypeDecl_reset() {
    sameStructure_TypeDecl_values = null;
  }
  protected java.util.Map sameStructure_TypeDecl_values;
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isCircular=true)
  @ASTNodeAnnotation.Source(aspect="GenericsSubtype", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/GenericsSubtype.jrag:216")
  public boolean sameStructure(TypeDecl t) {
    Object _parameters = t;
    if (sameStructure_TypeDecl_values == null) sameStructure_TypeDecl_values = new java.util.HashMap(4);
    ASTNode$State.CircularValue _value;
    if (sameStructure_TypeDecl_values.containsKey(_parameters)) {
      Object _cache = sameStructure_TypeDecl_values.get(_parameters);
      if (!(_cache instanceof ASTNode$State.CircularValue)) {
        return (Boolean) _cache;
      } else {
        _value = (ASTNode$State.CircularValue) _cache;
      }
    } else {
      _value = new ASTNode$State.CircularValue();
      sameStructure_TypeDecl_values.put(_parameters, _value);
      _value.value = true;
    }
    ASTNode$State state = state();
    if (!state.inCircle() || state.calledByLazyAttribute()) {
      state.enterCircle();
      boolean new_sameStructure_TypeDecl_value;
      do {
        _value.cycle = state.nextCycle();
        new_sameStructure_TypeDecl_value = sameStructure_compute(t);
        if (new_sameStructure_TypeDecl_value != ((Boolean)_value.value)) {
          state.setChangeInCycle();
          _value.value = new_sameStructure_TypeDecl_value;
        }
      } while (state.testAndClearChangeInCycle());
      sameStructure_TypeDecl_values.put(_parameters, new_sameStructure_TypeDecl_value);

      state.leaveCircle();
      return new_sameStructure_TypeDecl_value;
    } else if (_value.cycle != state.cycle()) {
      _value.cycle = state.cycle();
      boolean new_sameStructure_TypeDecl_value = sameStructure_compute(t);
      if (new_sameStructure_TypeDecl_value != ((Boolean)_value.value)) {
        state.setChangeInCycle();
        _value.value = new_sameStructure_TypeDecl_value;
      }
      return new_sameStructure_TypeDecl_value;
    } else {
      return (Boolean) _value.value;
    }
  }
  /** @apilevel internal */
  private boolean sameStructure_compute(TypeDecl t) {
      if (!(t instanceof ParInterfaceDecl)) {
        return false;
      }
      ParInterfaceDecl type = (ParInterfaceDecl) t;
      if (type.genericDecl().original() == genericDecl().original()) {
        if (!getParameterization().compare(type.getParameterization(),
            Parameterization.SAME_STRUCTURE)) {
          return false;
        }
        if (isNestedType() && type.isNestedType()) {
          return type.enclosingType().sameStructure(enclosingType());
        }
        return true;
      }
      return false;
    }
  /**
   * @attribute syn
   * @aspect GenericsSubtype
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/GenericsSubtype.jrag:146
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="GenericsSubtype", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/GenericsSubtype.jrag:146")
  public boolean supertypeParClassDecl(ParClassDecl type) {
    {
        if (type.genericDecl().original() == genericDecl().original()) {
          if (!type.getParameterization().compare(getParameterization(),
              Parameterization.CONTAINED_IN)) {
            return false;
          }
          if (isNestedType() && type.isNestedType()) {
            return type.enclosingType().subtype(enclosingType());
          }
          return true;
        }
        return supertypeClassDecl(type);
      }
  }
  /**
   * @attribute syn
   * @aspect GenericsSubtype
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/GenericsSubtype.jrag:150
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="GenericsSubtype", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/GenericsSubtype.jrag:150")
  public boolean supertypeParInterfaceDecl(ParInterfaceDecl type) {
    {
        if (type.genericDecl().original() == genericDecl().original()) {
          if (!type.getParameterization().compare(getParameterization(),
              Parameterization.CONTAINED_IN)) {
            return false;
          }
          if (isNestedType() && type.isNestedType()) {
            return type.enclosingType().subtype(enclosingType());
          }
          return true;
        }
        return supertypeInterfaceDecl(type);
      }
  }
  /** @apilevel internal */
  private void instanceOf_TypeDecl_reset() {
    instanceOf_TypeDecl_computed = new java.util.HashMap(4);
    instanceOf_TypeDecl_values = null;
  }
  /** @apilevel internal */
  protected java.util.Map instanceOf_TypeDecl_values;
  /** @apilevel internal */
  protected java.util.Map instanceOf_TypeDecl_computed;
  /**
   * @attribute syn
   * @aspect TypeWideningAndIdentity
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/TypeAnalysis.jrag:443
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeWideningAndIdentity", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/TypeAnalysis.jrag:443")
  public boolean instanceOf(TypeDecl type) {
    Object _parameters = type;
    if (instanceOf_TypeDecl_computed == null) instanceOf_TypeDecl_computed = new java.util.HashMap(4);
    if (instanceOf_TypeDecl_values == null) instanceOf_TypeDecl_values = new java.util.HashMap(4);
    ASTNode$State state = state();
    if (instanceOf_TypeDecl_values.containsKey(_parameters) && instanceOf_TypeDecl_computed != null
        && instanceOf_TypeDecl_computed.containsKey(_parameters)
        && (instanceOf_TypeDecl_computed.get(_parameters) == ASTNode$State.NON_CYCLE || instanceOf_TypeDecl_computed.get(_parameters) == state().cycle())) {
      return (Boolean) instanceOf_TypeDecl_values.get(_parameters);
    }
    boolean instanceOf_TypeDecl_value = subtype(type);
    if (state().inCircle()) {
      instanceOf_TypeDecl_values.put(_parameters, instanceOf_TypeDecl_value);
      instanceOf_TypeDecl_computed.put(_parameters, state().cycle());
    
    } else {
      instanceOf_TypeDecl_values.put(_parameters, instanceOf_TypeDecl_value);
      instanceOf_TypeDecl_computed.put(_parameters, ASTNode$State.NON_CYCLE);
    
    }
    return instanceOf_TypeDecl_value;
  }
  /**
   * A type is reifiable if it either refers to a non-parameterized type,
   * is a raw type, is a parameterized type with only unbound wildcard
   * parameters or is an array type with a reifiable type parameter.
   * 
   * @see "JLS SE7 &sect;4.7"
   * @attribute syn
   * @aspect ReifiableTypes
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/ReifiableTypes.jrag:39
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="ReifiableTypes", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/ReifiableTypes.jrag:39")
  public boolean isReifiable() {
    {
        for (TypeDecl argument : getParameterization().args) {
          if (!argument.isWildcard()) {
            return false;
          }
        }
        return true;
      }
  }
  /**
   * @attribute syn
   * @aspect NestedTypes
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/TypeAnalysis.jrag:635
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="NestedTypes", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/TypeAnalysis.jrag:635")
  public TypeDecl hostType() {
    TypeDecl hostType_value = original();
    return hostType_value;
  }
  /**
   * @attribute syn
   * @aspect Generics
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/Generics.jrag:300
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Generics", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/Generics.jrag:300")
  public boolean isRawType() {
    boolean isRawType_value = isNestedType() && enclosingType().isRawType();
    return isRawType_value;
  }
  /** @apilevel internal */
  private void erasure_reset() {
    erasure_computed = null;
    erasure_value = null;
  }
  /** @apilevel internal */
  protected ASTNode$State.Cycle erasure_computed = null;

  /** @apilevel internal */
  protected TypeDecl erasure_value;

  /**
   * @attribute syn
   * @aspect GenericsErasure
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/Generics.jrag:418
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="GenericsErasure", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/Generics.jrag:418")
  public TypeDecl erasure() {
    ASTNode$State state = state();
    if (erasure_computed == ASTNode$State.NON_CYCLE || erasure_computed == state().cycle()) {
      return erasure_value;
    }
    erasure_value = genericDecl();
    if (state().inCircle()) {
      erasure_computed = state().cycle();
    
    } else {
      erasure_computed = ASTNode$State.NON_CYCLE;
    
    }
    return erasure_value;
  }
  /**
   * @attribute syn
   * @aspect StrictSubtype
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/GenericsSubtype.jrag:39
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="StrictSubtype", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/GenericsSubtype.jrag:39")
  public boolean strictSupertypeGenericClassDecl(GenericClassDecl type) {
    boolean strictSupertypeGenericClassDecl_GenericClassDecl_value = type.strictSubtype(genericDecl().original());
    return strictSupertypeGenericClassDecl_GenericClassDecl_value;
  }
  /**
   * @attribute syn
   * @aspect StrictSubtype
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/GenericsSubtype.jrag:46
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="StrictSubtype", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/GenericsSubtype.jrag:46")
  public boolean strictSupertypeGenericInterfaceDecl(GenericInterfaceDecl type) {
    boolean strictSupertypeGenericInterfaceDecl_GenericInterfaceDecl_value = type.strictSubtype(genericDecl().original());
    return strictSupertypeGenericInterfaceDecl_GenericInterfaceDecl_value;
  }
  /**
   * @attribute syn
   * @aspect StrictSubtype
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/GenericsSubtype.jrag:378
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="StrictSubtype", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/GenericsSubtype.jrag:378")
  public boolean strictSupertypeClassDecl(ClassDecl type) {
    boolean strictSupertypeClassDecl_ClassDecl_value = super.strictSupertypeClassDecl(type);
    return strictSupertypeClassDecl_ClassDecl_value;
  }
  /** @apilevel internal */
  private void strictSubtype_TypeDecl_reset() {
    strictSubtype_TypeDecl_values = null;
  }
  protected java.util.Map strictSubtype_TypeDecl_values;
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isCircular=true)
  @ASTNodeAnnotation.Source(aspect="StrictSubtype", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/GenericsSubtype.jrag:363")
  public boolean strictSubtype(TypeDecl type) {
    Object _parameters = type;
    if (strictSubtype_TypeDecl_values == null) strictSubtype_TypeDecl_values = new java.util.HashMap(4);
    ASTNode$State.CircularValue _value;
    if (strictSubtype_TypeDecl_values.containsKey(_parameters)) {
      Object _cache = strictSubtype_TypeDecl_values.get(_parameters);
      if (!(_cache instanceof ASTNode$State.CircularValue)) {
        return (Boolean) _cache;
      } else {
        _value = (ASTNode$State.CircularValue) _cache;
      }
    } else {
      _value = new ASTNode$State.CircularValue();
      strictSubtype_TypeDecl_values.put(_parameters, _value);
      _value.value = true;
    }
    ASTNode$State state = state();
    if (!state.inCircle() || state.calledByLazyAttribute()) {
      state.enterCircle();
      boolean new_strictSubtype_TypeDecl_value;
      do {
        _value.cycle = state.nextCycle();
        new_strictSubtype_TypeDecl_value = type.strictSupertypeParInterfaceDecl(this);
        if (new_strictSubtype_TypeDecl_value != ((Boolean)_value.value)) {
          state.setChangeInCycle();
          _value.value = new_strictSubtype_TypeDecl_value;
        }
      } while (state.testAndClearChangeInCycle());
      strictSubtype_TypeDecl_values.put(_parameters, new_strictSubtype_TypeDecl_value);

      state.leaveCircle();
      return new_strictSubtype_TypeDecl_value;
    } else if (_value.cycle != state.cycle()) {
      _value.cycle = state.cycle();
      boolean new_strictSubtype_TypeDecl_value = type.strictSupertypeParInterfaceDecl(this);
      if (new_strictSubtype_TypeDecl_value != ((Boolean)_value.value)) {
        state.setChangeInCycle();
        _value.value = new_strictSubtype_TypeDecl_value;
      }
      return new_strictSubtype_TypeDecl_value;
    } else {
      return (Boolean) _value.value;
    }
  }
  /**
   * @attribute syn
   * @aspect StrictSubtype
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/GenericsSubtype.jrag:52
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="StrictSubtype", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/GenericsSubtype.jrag:52")
  public boolean strictSupertypeRawClassDecl(RawClassDecl type) {
    boolean strictSupertypeRawClassDecl_RawClassDecl_value = type.genericDecl().original().strictSubtype(genericDecl().original());
    return strictSupertypeRawClassDecl_RawClassDecl_value;
  }
  /**
   * @attribute syn
   * @aspect StrictSubtype
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/GenericsSubtype.jrag:56
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="StrictSubtype", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/GenericsSubtype.jrag:56")
  public boolean strictSupertypeRawInterfaceDecl(RawInterfaceDecl type) {
    boolean strictSupertypeRawInterfaceDecl_RawInterfaceDecl_value = type.genericDecl().original().strictSubtype(genericDecl().original());
    return strictSupertypeRawInterfaceDecl_RawInterfaceDecl_value;
  }
  /**
   * @attribute syn
   * @aspect StrictSubtype
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/GenericsSubtype.jrag:149
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="StrictSubtype", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/GenericsSubtype.jrag:149")
  public boolean strictSupertypeParClassDecl(ParClassDecl type) {
    {
        if (isRawType()) {
          return true;
        }
        if (type.genericDecl().original() == genericDecl().original()) {
          if (!type.getParameterization().compare(getParameterization(),
              Parameterization.STRICT_CONTAINED_IN)) {
            return false;
          }
          if (isNestedType() && type.isNestedType()) {
            return type.enclosingType().strictSubtype(enclosingType());
          }
          return true;
        }
        return strictSupertypeClassDecl(type);
      }
  }
  /**
   * @attribute syn
   * @aspect StrictSubtype
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/GenericsSubtype.jrag:153
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="StrictSubtype", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/GenericsSubtype.jrag:153")
  public boolean strictSupertypeParInterfaceDecl(ParInterfaceDecl type) {
    {
        if (isRawType()) {
          return true;
        }
        if (type.genericDecl().original() == genericDecl().original()) {
          if (!type.getParameterization().compare(getParameterization(),
              Parameterization.STRICT_CONTAINED_IN)) {
            return false;
          }
          if (isNestedType() && type.isNestedType()) {
            return type.enclosingType().strictSubtype(enclosingType());
          }
          return true;
        }
        return strictSupertypeInterfaceDecl(type);
      }
  }
  /** @apilevel internal */
  private void isFunctional_reset() {
    isFunctional_computed = null;
  }
  /** @apilevel internal */
  protected ASTNode$State.Cycle isFunctional_computed = null;

  /** @apilevel internal */
  protected boolean isFunctional_value;

  /**
   * @attribute syn
   * @aspect FunctionalInterface
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/FunctionalInterface.jrag:33
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="FunctionalInterface", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/FunctionalInterface.jrag:33")
  public boolean isFunctional() {
    ASTNode$State state = state();
    if (isFunctional_computed == ASTNode$State.NON_CYCLE || isFunctional_computed == state().cycle()) {
      return isFunctional_value;
    }
    isFunctional_value = ((InterfaceDecl) original()).isFunctional();
    if (state().inCircle()) {
      isFunctional_computed = state().cycle();
    
    } else {
      isFunctional_computed = ASTNode$State.NON_CYCLE;
    
    }
    return isFunctional_value;
  }
  /** @apilevel internal */
  private void fullName_reset() {
    fullName_computed = null;
    fullName_value = null;
  }
  /** @apilevel internal */
  protected ASTNode$State.Cycle fullName_computed = null;

  /** @apilevel internal */
  protected String fullName_value;

  /**
   * @attribute syn
   * @aspect TypeName
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/QualifiedNames.jrag:84
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeName", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/QualifiedNames.jrag:84")
  public String fullName() {
    ASTNode$State state = state();
    if (fullName_computed == ASTNode$State.NON_CYCLE || fullName_computed == state().cycle()) {
      return fullName_value;
    }
    fullName_value = fullName_compute();
    if (state().inCircle()) {
      fullName_computed = state().cycle();
    
    } else {
      fullName_computed = ASTNode$State.NON_CYCLE;
    
    }
    return fullName_value;
  }
  /** @apilevel internal */
  private String fullName_compute() {
      if (isNestedType()) {
        return enclosingType().fullName() + "." + nameWithArgs();
      }
      String packageName = packageName();
      if (packageName.equals("")) {
        return nameWithArgs();
      }
      return packageName + "." + nameWithArgs();
    }
  /** @apilevel internal */
  private void typeName_reset() {
    typeName_computed = null;
    typeName_value = null;
  }
  /** @apilevel internal */
  protected ASTNode$State.Cycle typeName_computed = null;

  /** @apilevel internal */
  protected String typeName_value;

  /**
   * @attribute syn
   * @aspect TypeName
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/QualifiedNames.jrag:95
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeName", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/QualifiedNames.jrag:95")
  public String typeName() {
    ASTNode$State state = state();
    if (typeName_computed == ASTNode$State.NON_CYCLE || typeName_computed == state().cycle()) {
      return typeName_value;
    }
    typeName_value = typeName_compute();
    if (state().inCircle()) {
      typeName_computed = state().cycle();
    
    } else {
      typeName_computed = ASTNode$State.NON_CYCLE;
    
    }
    return typeName_value;
  }
  /** @apilevel internal */
  private String typeName_compute() {
      if (isNestedType()) {
        return enclosingType().typeName() + "." + nameWithArgs();
      }
      String packageName = packageName();
      if (packageName.equals("") || packageName.equals(PRIMITIVE_PACKAGE_NAME)) {
        return nameWithArgs();
      }
      return packageName + "." + nameWithArgs();
    }
  /**
   * @attribute syn
   * @aspect GenericsParTypeDecl
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/GenericsParTypeDecl.jrag:55
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="GenericsParTypeDecl", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/GenericsParTypeDecl.jrag:55")
  public String nameWithArgs() {
    {
        java.util.List<TypeDecl> args = getParameterization().args;
        StringBuilder sb = new StringBuilder();
        sb.append(name());
        sb.append("<");
        for (int i = 0; i < args.size(); i++) {
          if (i != 0) {
            sb.append(", ");
          }
          sb.append(args.get(i).typeName());
        }
        sb.append(">");
        return sb.toString();
      }
  }
  /**
   * @attribute syn
   * @aspect TypeScopePropagation
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/LookupType.jrag:492
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeScopePropagation", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/LookupType.jrag:492")
  public SimpleSet<TypeDecl> localLookupType(String name) {
    {
        SimpleSet<TypeDecl> result = memberTypes(name);
        if (!result.isEmpty()) {
          return result;
        }
        if (name().equals(name)) {
          return genericDecl(); // Type lookups for this type resolve to the generic type.
        }
    
        result = lookupType(name);
        // 8.5.2
        if (isClassDecl() && isStatic() && !isTopLevelType()) {
          SimpleSet<TypeDecl> newSet = emptySet();
          for (TypeDecl type : result) {
            newSet = newSet.add(type);
          }
          result = newSet;
        }
        return result;
      }
  }
  /** @apilevel internal */
  private void unimplementedMethods_reset() {
    unimplementedMethods_computed = null;
    unimplementedMethods_value = null;
  }
  /** @apilevel internal */
  protected ASTNode$State.Cycle unimplementedMethods_computed = null;

  /** @apilevel internal */
  protected Collection<MethodDecl> unimplementedMethods_value;

  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/Modifiers.jrag:35
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Modifiers", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/Modifiers.jrag:35")
  public Collection<MethodDecl> unimplementedMethods() {
    ASTNode$State state = state();
    if (unimplementedMethods_computed == ASTNode$State.NON_CYCLE || unimplementedMethods_computed == state().cycle()) {
      return unimplementedMethods_value;
    }
    unimplementedMethods_value = unimplementedMethods_compute();
    if (state().inCircle()) {
      unimplementedMethods_computed = state().cycle();
    
    } else {
      unimplementedMethods_computed = ASTNode$State.NON_CYCLE;
    
    }
    return unimplementedMethods_value;
  }
  /** @apilevel internal */
  private Collection<MethodDecl> unimplementedMethods_compute() {
      Collection<MethodDecl> set = new HashSet<MethodDecl>();
      Collection<MethodDecl> result = new HashSet<MethodDecl>();
      for (MethodDecl m : genericDecl().unimplementedMethods()) {
        set.add(m.sourceMethodDecl());
      }
      for (MethodDecl m : super.unimplementedMethods()) {
        if (set.contains(m.sourceMethodDecl())) {
          result.add(m);
        }
      }
      return result;
    }
  /**
   * @attribute syn
   * @aspect Generics
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/Generics.jrag:299
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Generics", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/Generics.jrag:299")
  public boolean isParameterizedType() {
    boolean isParameterizedType_value = true;
    return isParameterizedType_value;
  }
  /**
   * @attribute syn
   * @aspect GenericsTypeCheck
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/Generics.jrag:600
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="GenericsTypeCheck", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/Generics.jrag:600")
  public boolean sameArguments(ParTypeDecl decl) {
    {
        if (this == decl) {
          return true;
        }
        if (genericDecl() != decl.genericDecl()) {
          return false;
        }
        return getParameterization().sameArguments(decl.getParameterization());
      }
  }
  /**
   * @attribute syn
   * @aspect LookupParTypeDecl
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/Generics.jrag:813
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="LookupParTypeDecl", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/Generics.jrag:813")
  public boolean sameSignature(Access a) {
    {
        if (a instanceof ParTypeAccess) {
          ParTypeAccess ta = (ParTypeAccess) a;
          if (genericDecl() != ta.genericDecl()) {
            return false;
          }
          Parameterization par = getParameterization();
          if (par.args.size() != ta.getNumTypeArgument()) {
            return false;
          }
          for (int i = 0; i < par.args.size(); i++) {
            if (!par.args.get(i).sameSignature(ta.getTypeArgument(i))) {
              return false;
            }
          }
          return true;
        } else if (a instanceof TypeAccess && ((TypeAccess) a).isRaw()) {
          return false;
        }
        return super.sameSignature(a);
      }
  }
  /** @apilevel internal */
  private void sameSignature_java_util_List_TypeDecl__reset() {
    sameSignature_java_util_List_TypeDecl__values = null;
  }
  protected java.util.Map sameSignature_java_util_List_TypeDecl__values;
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isCircular=true)
  @ASTNodeAnnotation.Source(aspect="LookupParTypeDecl", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/Generics.jrag:860")
  public boolean sameSignature(java.util.List<TypeDecl> list) {
    Object _parameters = list;
    if (sameSignature_java_util_List_TypeDecl__values == null) sameSignature_java_util_List_TypeDecl__values = new java.util.HashMap(4);
    ASTNode$State.CircularValue _value;
    if (sameSignature_java_util_List_TypeDecl__values.containsKey(_parameters)) {
      Object _cache = sameSignature_java_util_List_TypeDecl__values.get(_parameters);
      if (!(_cache instanceof ASTNode$State.CircularValue)) {
        return (Boolean) _cache;
      } else {
        _value = (ASTNode$State.CircularValue) _cache;
      }
    } else {
      _value = new ASTNode$State.CircularValue();
      sameSignature_java_util_List_TypeDecl__values.put(_parameters, _value);
      _value.value = true;
    }
    ASTNode$State state = state();
    if (!state.inCircle() || state.calledByLazyAttribute()) {
      state.enterCircle();
      boolean new_sameSignature_java_util_List_TypeDecl__value;
      do {
        _value.cycle = state.nextCycle();
        new_sameSignature_java_util_List_TypeDecl__value = sameSignature_compute(list);
        if (new_sameSignature_java_util_List_TypeDecl__value != ((Boolean)_value.value)) {
          state.setChangeInCycle();
          _value.value = new_sameSignature_java_util_List_TypeDecl__value;
        }
      } while (state.testAndClearChangeInCycle());
      sameSignature_java_util_List_TypeDecl__values.put(_parameters, new_sameSignature_java_util_List_TypeDecl__value);

      state.leaveCircle();
      return new_sameSignature_java_util_List_TypeDecl__value;
    } else if (_value.cycle != state.cycle()) {
      _value.cycle = state.cycle();
      boolean new_sameSignature_java_util_List_TypeDecl__value = sameSignature_compute(list);
      if (new_sameSignature_java_util_List_TypeDecl__value != ((Boolean)_value.value)) {
        state.setChangeInCycle();
        _value.value = new_sameSignature_java_util_List_TypeDecl__value;
      }
      return new_sameSignature_java_util_List_TypeDecl__value;
    } else {
      return (Boolean) _value.value;
    }
  }
  /** @apilevel internal */
  private boolean sameSignature_compute(java.util.List<TypeDecl> list) {
      Parameterization par = getParameterization();
      if (par.args.size() != list.size()) {
        return false;
      }
      for (int i = 0; i < list.size(); i++) {
        if (par.args.get(i) != list.get(i)) {
          return false;
        }
      }
      return true;
    }
/** @apilevel internal */
protected ASTNode$State.Cycle usesTypeVariable_cycle = null;
  /** @apilevel internal */
  private void usesTypeVariable_reset() {
    usesTypeVariable_computed = false;
    usesTypeVariable_initialized = false;
    usesTypeVariable_cycle = null;
  }
  /** @apilevel internal */
  protected boolean usesTypeVariable_computed = false;

  /** @apilevel internal */
  protected boolean usesTypeVariable_value;
  /** @apilevel internal */
  protected boolean usesTypeVariable_initialized = false;
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isCircular=true)
  @ASTNodeAnnotation.Source(aspect="LookupParTypeDecl", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/Generics.jrag:1189")
  public boolean usesTypeVariable() {
    if (usesTypeVariable_computed) {
      return usesTypeVariable_value;
    }
    ASTNode$State state = state();
    if (!usesTypeVariable_initialized) {
      usesTypeVariable_initialized = true;
      usesTypeVariable_value = false;
    }
    if (!state.inCircle() || state.calledByLazyAttribute()) {
      state.enterCircle();
      do {
        usesTypeVariable_cycle = state.nextCycle();
        boolean new_usesTypeVariable_value = usesTypeVariable_compute();
        if (new_usesTypeVariable_value != usesTypeVariable_value) {
          state.setChangeInCycle();
        }
        usesTypeVariable_value = new_usesTypeVariable_value;
      } while (state.testAndClearChangeInCycle());
      usesTypeVariable_computed = true;

      state.leaveCircle();
    } else if (usesTypeVariable_cycle != state.cycle()) {
      usesTypeVariable_cycle = state.cycle();
      boolean new_usesTypeVariable_value = usesTypeVariable_compute();
      if (new_usesTypeVariable_value != usesTypeVariable_value) {
        state.setChangeInCycle();
      }
      usesTypeVariable_value = new_usesTypeVariable_value;
    } else {
    }
    return usesTypeVariable_value;
  }
  /** @apilevel internal */
  private boolean usesTypeVariable_compute() {
      if (super.usesTypeVariable()) {
        return true;
      }
      for (TypeDecl argument : getParameterization().args) {
        if (argument.usesTypeVariable()) {
          return true;
        }
      }
      return false;
    }
  /**
   * @attribute syn
   * @aspect LookupParTypeDecl
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/Generics.jrag:1530
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="LookupParTypeDecl", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/Generics.jrag:1530")
  public TypeDecl original() {
    TypeDecl original_value = genericDecl().original();
    return original_value;
  }
  /** @apilevel internal */
  private void sourceTypeDecl_reset() {
    sourceTypeDecl_computed = null;
    sourceTypeDecl_value = null;
  }
  /** @apilevel internal */
  protected ASTNode$State.Cycle sourceTypeDecl_computed = null;

  /** @apilevel internal */
  protected TypeDecl sourceTypeDecl_value;

  /**
   * @attribute syn
   * @aspect SourceDeclarations
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/Generics.jrag:1722
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="SourceDeclarations", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/Generics.jrag:1722")
  public TypeDecl sourceTypeDecl() {
    ASTNode$State state = state();
    if (sourceTypeDecl_computed == ASTNode$State.NON_CYCLE || sourceTypeDecl_computed == state().cycle()) {
      return sourceTypeDecl_value;
    }
    sourceTypeDecl_value = genericDecl().original().sourceTypeDecl();
    if (state().inCircle()) {
      sourceTypeDecl_computed = state().cycle();
    
    } else {
      sourceTypeDecl_computed = ASTNode$State.NON_CYCLE;
    
    }
    return sourceTypeDecl_value;
  }
  /** @apilevel internal */
  private void firstTypeArgument_reset() {
    firstTypeArgument_computed = null;
    firstTypeArgument_value = null;
  }
  /** @apilevel internal */
  protected ASTNode$State.Cycle firstTypeArgument_computed = null;

  /** @apilevel internal */
  protected TypeDecl firstTypeArgument_value;

  /**
   * Returns the first type argument of this type, if it is parameterized, otherwise returns
   * java.lang.Object.
   * @attribute syn
   * @aspect EnhancedFor
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/EnhancedFor.jrag:117
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="EnhancedFor", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/EnhancedFor.jrag:117")
  public TypeDecl firstTypeArgument() {
    ASTNode$State state = state();
    if (firstTypeArgument_computed == ASTNode$State.NON_CYCLE || firstTypeArgument_computed == state().cycle()) {
      return firstTypeArgument_value;
    }
    firstTypeArgument_value = getParameterization().args.get(0);
    if (state().inCircle()) {
      firstTypeArgument_computed = state().cycle();
    
    } else {
      firstTypeArgument_computed = ASTNode$State.NON_CYCLE;
    
    }
    return firstTypeArgument_value;
  }
  /** @apilevel internal */
  private void localMethodsSignatureMap_reset() {
    localMethodsSignatureMap_computed = null;
    localMethodsSignatureMap_value = null;
  }
  /** @apilevel internal */
  protected ASTNode$State.Cycle localMethodsSignatureMap_computed = null;

  /** @apilevel internal */
  protected Map<String, SimpleSet<MethodDecl>> localMethodsSignatureMap_value;

  /**
   * @attribute syn
   * @aspect LookupParTypeDecl
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/Generics.jrag:1211
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="LookupParTypeDecl", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/Generics.jrag:1211")
  public Map<String, SimpleSet<MethodDecl>> localMethodsSignatureMap() {
    ASTNode$State state = state();
    if (localMethodsSignatureMap_computed == ASTNode$State.NON_CYCLE || localMethodsSignatureMap_computed == state().cycle()) {
      return localMethodsSignatureMap_value;
    }
    localMethodsSignatureMap_value = localMethodsSignatureMap_compute();
    if (state().inCircle()) {
      localMethodsSignatureMap_computed = state().cycle();
    
    } else {
      localMethodsSignatureMap_computed = ASTNode$State.NON_CYCLE;
    
    }
    return localMethodsSignatureMap_value;
  }
  /** @apilevel internal */
  private Map<String, SimpleSet<MethodDecl>> localMethodsSignatureMap_compute() {
      Map<String, SimpleSet<MethodDecl>> map = new HashMap<String, SimpleSet<MethodDecl>>();
      for (Iterator<MethodDecl> iter = original().localMethodsIterator(); iter.hasNext(); ) {
        MethodDecl decl = iter.next();
        if (!decl.isSubstitutable()) {
          putSimpleSetElement(map, decl.signature(), decl);
        }
      }
      for (BodyDecl decl : getBodyDeclList()) {
        if (decl instanceof MethodDecl) {
          MethodDecl method = (MethodDecl) decl;
          putSimpleSetElement(map, method.signature(), method);
        }
      }
      return map;
    }
  /** @apilevel internal */
  private void localFields_String_reset() {
    localFields_String_computed = new java.util.HashMap(4);
    localFields_String_values = null;
  }
  /** @apilevel internal */
  protected java.util.Map localFields_String_values;
  /** @apilevel internal */
  protected java.util.Map localFields_String_computed;
  /**
   * @attribute syn
   * @aspect LookupParTypeDecl
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/Generics.jrag:1228
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="LookupParTypeDecl", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/Generics.jrag:1228")
  public SimpleSet<Variable> localFields(String name) {
    Object _parameters = name;
    if (localFields_String_computed == null) localFields_String_computed = new java.util.HashMap(4);
    if (localFields_String_values == null) localFields_String_values = new java.util.HashMap(4);
    ASTNode$State state = state();
    if (localFields_String_values.containsKey(_parameters) && localFields_String_computed != null
        && localFields_String_computed.containsKey(_parameters)
        && (localFields_String_computed.get(_parameters) == ASTNode$State.NON_CYCLE || localFields_String_computed.get(_parameters) == state().cycle())) {
      return (SimpleSet<Variable>) localFields_String_values.get(_parameters);
    }
    SimpleSet<Variable> localFields_String_value = localFields_compute(name);
    if (state().inCircle()) {
      localFields_String_values.put(_parameters, localFields_String_value);
      localFields_String_computed.put(_parameters, state().cycle());
    
    } else {
      localFields_String_values.put(_parameters, localFields_String_value);
      localFields_String_computed.put(_parameters, ASTNode$State.NON_CYCLE);
    
    }
    return localFields_String_value;
  }
  /** @apilevel internal */
  private SimpleSet<Variable> localFields_compute(String name) {
      SimpleSet<Variable> set = emptySet();
      for (Variable field : original().localFields(name)) {
        if (field.name().equals(name)
            && field.fieldDecl() != null && !field.fieldDecl().isSubstitutable()) {
          set = set.add(field);
        }
      }
      for (BodyDecl decl : getBodyDeclList()) {
        if (decl instanceof FieldDecl) {
          FieldDecl field = (FieldDecl) decl;
          for (FieldDeclarator f : field.getDeclaratorList()) {
            if (f.name().equals(name)) {
              set = set.add(f);
            }
          }
        }
      }
      return set;
    }
  /** @apilevel internal */
  private void localTypeDecls_String_reset() {
    localTypeDecls_String_values = null;
  }
  protected java.util.Map localTypeDecls_String_values;
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isCircular=true)
  @ASTNodeAnnotation.Source(aspect="LookupParTypeDecl", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/Generics.jrag:1259")
  public SimpleSet<TypeDecl> localTypeDecls(String name) {
    Object _parameters = name;
    if (localTypeDecls_String_values == null) localTypeDecls_String_values = new java.util.HashMap(4);
    ASTNode$State.CircularValue _value;
    if (localTypeDecls_String_values.containsKey(_parameters)) {
      Object _cache = localTypeDecls_String_values.get(_parameters);
      if (!(_cache instanceof ASTNode$State.CircularValue)) {
        return (SimpleSet<TypeDecl>) _cache;
      } else {
        _value = (ASTNode$State.CircularValue) _cache;
      }
    } else {
      _value = new ASTNode$State.CircularValue();
      localTypeDecls_String_values.put(_parameters, _value);
      _value.value = emptySet();
    }
    ASTNode$State state = state();
    if (!state.inCircle() || state.calledByLazyAttribute()) {
      state.enterCircle();
      SimpleSet<TypeDecl> new_localTypeDecls_String_value;
      do {
        _value.cycle = state.nextCycle();
        new_localTypeDecls_String_value = localTypeDecls_compute(name);
        if ((new_localTypeDecls_String_value == null && ((SimpleSet<TypeDecl>)_value.value) != null) || (new_localTypeDecls_String_value != null && !new_localTypeDecls_String_value.equals(((SimpleSet<TypeDecl>)_value.value)))) {
          state.setChangeInCycle();
          _value.value = new_localTypeDecls_String_value;
        }
      } while (state.testAndClearChangeInCycle());
      localTypeDecls_String_values.put(_parameters, new_localTypeDecls_String_value);

      state.leaveCircle();
      return new_localTypeDecls_String_value;
    } else if (_value.cycle != state.cycle()) {
      _value.cycle = state.cycle();
      SimpleSet<TypeDecl> new_localTypeDecls_String_value = localTypeDecls_compute(name);
      if ((new_localTypeDecls_String_value == null && ((SimpleSet<TypeDecl>)_value.value) != null) || (new_localTypeDecls_String_value != null && !new_localTypeDecls_String_value.equals(((SimpleSet<TypeDecl>)_value.value)))) {
        state.setChangeInCycle();
        _value.value = new_localTypeDecls_String_value;
      }
      return new_localTypeDecls_String_value;
    } else {
      return (SimpleSet<TypeDecl>) _value.value;
    }
  }
  /** @apilevel internal */
  private SimpleSet<TypeDecl> localTypeDecls_compute(String name) {
      SimpleSet<TypeDecl> set = emptySet();
      for (TypeDecl type : original().localTypeDecls(name)) {
        if (type.isStatic()) {
          set = set.add(type);
        }
      }
      for (BodyDecl decl : getBodyDeclList()) {
        if (decl instanceof MemberClassDecl) {
          ClassDecl typeDecl = ((MemberClassDecl) decl).getClassDecl();
          if (typeDecl.name().equals(name)) {
            set = set.add(typeDecl);
          }
        }
      }
      return set;
    }
  /**
   * @attribute inh
   * @aspect GenericsParTypeDecl
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/GenericsParTypeDecl.jrag:74
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="GenericsParTypeDecl", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/GenericsParTypeDecl.jrag:74")
  public TypeDecl genericDecl() {
    ASTNode$State state = state();
    if (genericDecl_computed == ASTNode$State.NON_CYCLE || genericDecl_computed == state().cycle()) {
      return genericDecl_value;
    }
    genericDecl_value = getParent().Define_genericDecl(this, null);
    if (state().inCircle()) {
      genericDecl_computed = state().cycle();
    
    } else {
      genericDecl_computed = ASTNode$State.NON_CYCLE;
    
    }
    return genericDecl_value;
  }
  /** @apilevel internal */
  private void genericDecl_reset() {
    genericDecl_computed = null;
    genericDecl_value = null;
  }
  /** @apilevel internal */
  protected ASTNode$State.Cycle genericDecl_computed = null;

  /** @apilevel internal */
  protected TypeDecl genericDecl_value;

  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/GenericsParTypeDecl.jrag:74
   * @apilevel internal
   */
  public TypeDecl Define_genericDecl(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getBodyDeclListNoTransform()) {
      // @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/GenericsParTypeDecl.jrag:90
      int index = _callerNode.getIndexOfChild(_childNode);
      {
          if (getBodyDecl(index) instanceof MemberTypeDecl) {
            MemberTypeDecl m = (MemberTypeDecl) getBodyDecl(index);
            return extractSingleType(genericDecl().memberTypes(m.typeDecl().name()));
          }
          return genericDecl();
        }
    }
    else {
      return getParent().Define_genericDecl(this, _callerNode);
    }
  }
  protected boolean canDefine_genericDecl(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/GenericMethods.jrag:225
   * @apilevel internal
   */
  public SimpleSet<TypeDecl> Define_lookupType(ASTNode _callerNode, ASTNode _childNode, String name) {
    if (_callerNode == getBodyDeclListNoTransform()) {
      // @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/Generics.jrag:937
      int childIndex = _callerNode.getIndexOfChild(_childNode);
      {
          TypeDecl paramType = getParameterization().substitute(name);
          if (paramType != null) {
            return paramType;
          }
          return localLookupType(name);
        }
    }
    else {
      int childIndex = this.getIndexOfChild(_callerNode);
      {
          TypeDecl paramType = getParameterization().substitute(name);
          if (paramType != null) {
            return paramType;
          }
          return lookupType(name);
        }
    }
  }
  protected boolean canDefine_lookupType(ASTNode _callerNode, ASTNode _childNode, String name) {
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
}
