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
 * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/grammar/Java.ast:98
 * @production MemberClassDecl : {@link MemberTypeDecl} ::= <span class="component">{@link ClassDecl}</span>;

 */
public class MemberClassDecl extends MemberTypeDecl implements Cloneable {
  /**
   * @aspect Java4PrettyPrint
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/PrettyPrint.jadd:454
   */
  public void prettyPrint(PrettyPrinter out) {
    out.print(getClassDecl());
  }
  /**
   * @aspect LookupParTypeDecl
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java5/frontend/Generics.jrag:1355
   */
  public BodyDecl signatureCopy() {
    return new MemberClassDecl(getClassDecl().signatureCopy());
  }
  /**
   * @aspect LookupParTypeDecl
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java5/frontend/Generics.jrag:1445
   */
  public BodyDecl erasedCopy() {
    return new MemberClassDecl(getClassDecl().erasedCopy());
  }
  /**
   * @declaredat ASTNode:1
   */
  public MemberClassDecl() {
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
    children = new ASTNode[1];
  }
  /**
   * @declaredat ASTNode:13
   */
  public MemberClassDecl(ClassDecl p0) {
    setChild(p0, 0);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:17
   */
  protected int numChildren() {
    return 1;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:23
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:27
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:31
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:35
   */
  public MemberClassDecl clone() throws CloneNotSupportedException {
    MemberClassDecl node = (MemberClassDecl) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:40
   */
  public MemberClassDecl copy() {
    try {
      MemberClassDecl node = (MemberClassDecl) clone();
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
   * @declaredat ASTNode:59
   */
  @Deprecated
  public MemberClassDecl fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:69
   */
  public MemberClassDecl treeCopyNoTransform() {
    MemberClassDecl tree = (MemberClassDecl) copy();
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
   * @declaredat ASTNode:89
   */
  public MemberClassDecl treeCopy() {
    MemberClassDecl tree = (MemberClassDecl) copy();
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
   * @declaredat ASTNode:103
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node);    
  }
  /**
   * Replaces the ClassDecl child.
   * @param node The new node to replace the ClassDecl child.
   * @apilevel high-level
   */
  public void setClassDecl(ClassDecl node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the ClassDecl child.
   * @return The current node used as the ClassDecl child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="ClassDecl")
  public ClassDecl getClassDecl() {
    return (ClassDecl) getChild(0);
  }
  /**
   * Retrieves the ClassDecl child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the ClassDecl child.
   * @apilevel low-level
   */
  public ClassDecl getClassDeclNoTransform() {
    return (ClassDecl) getChildNoTransform(0);
  }
  /**
   * @attribute syn
   * @aspect TypeScopePropagation
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/LookupType.jrag:613
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeScopePropagation", declaredAt="/home/felix/EDAN70/extension-base/extendj/java4/frontend/LookupType.jrag:613")
  public TypeDecl typeDecl() {
    TypeDecl typeDecl_value = getClassDecl();
    return typeDecl_value;
  }
  /**
   * @attribute syn
   * @aspect LookupParTypeDecl
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java5/frontend/Generics.jrag:1563
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="LookupParTypeDecl", declaredAt="/home/felix/EDAN70/extension-base/extendj/java5/frontend/Generics.jrag:1563")
  public boolean isSubstitutable() {
    boolean isSubstitutable_value = !isStatic();
    return isSubstitutable_value;
  }
  /**
   * @attribute syn
   * @aspect PreciseRethrow
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java8/frontend/EffectivelyFinal.jrag:40
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="PreciseRethrow", declaredAt="/home/felix/EDAN70/extension-base/extendj/java8/frontend/EffectivelyFinal.jrag:40")
  public boolean modifiedInScope(Variable var) {
    boolean modifiedInScope_Variable_value = getClassDecl().modifiedInScope(var);
    return modifiedInScope_Variable_value;
  }
  /**
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/TypeAnalysis.jrag:580
   * @apilevel internal
   */
  public boolean Define_isMemberType(ASTNode _callerNode, ASTNode _childNode) {
    if (getClassDeclNoTransform() != null && _callerNode == getClassDecl()) {
      // @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/TypeAnalysis.jrag:581
      return true;
    }
    else {
      return getParent().Define_isMemberType(this, _callerNode);
    }
  }
  protected boolean canDefine_isMemberType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/TypeHierarchyCheck.jrag:208
   * @apilevel internal
   */
  public boolean Define_inStaticContext(ASTNode _callerNode, ASTNode _childNode) {
    if (getClassDeclNoTransform() != null && _callerNode == getClassDecl()) {
      // @declaredat /home/felix/EDAN70/extension-base/extendj/java4/frontend/TypeHierarchyCheck.jrag:220
      return false;
    }
    else {
      return getParent().Define_inStaticContext(this, _callerNode);
    }
  }
  protected boolean canDefine_inStaticContext(ASTNode _callerNode, ASTNode _childNode) {
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
