/* This file was generated with JastAdd2 (http://jastadd.org) version 2.2.2 */
package org.extendj.ast;
import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.IOException;
import java.util.Set;
import beaver.*;
import org.jastadd.util.*;
import org.jastadd.util.PrettyPrintable;
import org.jastadd.util.PrettyPrinter;
import java.util.zip.*;
import java.io.*;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
/**
 * @ast node
 * @declaredat /h/dc/q/stv10hjo/Documents/EDAN70/extension-base/extendj/java4/grammar/Java.ast:11
 * @production TypeImportOnDemandDecl : {@link ImportDecl};

 */
public class TypeImportOnDemandDecl extends ImportDecl implements Cloneable {
  /**
   * @aspect Java4PrettyPrint
   * @declaredat /h/dc/q/stv10hjo/Documents/EDAN70/extension-base/extendj/java4/frontend/PrettyPrint.jadd:615
   */
  public void prettyPrint(PrettyPrinter out) {
    out.print("import ");
    out.print(getAccess());
    out.print(".*;");
    out.println();
  }
  /**
   * @declaredat ASTNode:1
   */
  public TypeImportOnDemandDecl() {
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
  public TypeImportOnDemandDecl(Access p0) {
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
    importedTypes_String_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:32
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:36
   */
  public TypeImportOnDemandDecl clone() throws CloneNotSupportedException {
    TypeImportOnDemandDecl node = (TypeImportOnDemandDecl) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:41
   */
  public TypeImportOnDemandDecl copy() {
    try {
      TypeImportOnDemandDecl node = (TypeImportOnDemandDecl) clone();
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
   * @declaredat ASTNode:60
   */
  @Deprecated
  public TypeImportOnDemandDecl fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:70
   */
  public TypeImportOnDemandDecl treeCopyNoTransform() {
    TypeImportOnDemandDecl tree = (TypeImportOnDemandDecl) copy();
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
   * @declaredat ASTNode:90
   */
  public TypeImportOnDemandDecl treeCopy() {
    TypeImportOnDemandDecl tree = (TypeImportOnDemandDecl) copy();
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
   * @declaredat ASTNode:104
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node);    
  }
  /**
   * Replaces the Access child.
   * @param node The new node to replace the Access child.
   * @apilevel high-level
   */
  public void setAccess(Access node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the Access child.
   * @return The current node used as the Access child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Access")
  public Access getAccess() {
    return (Access) getChild(0);
  }
  /**
   * Retrieves the Access child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Access child.
   * @apilevel low-level
   */
  public Access getAccessNoTransform() {
    return (Access) getChildNoTransform(0);
  }
  /**
   * @attribute syn
   * @aspect NameCheck
   * @declaredat /h/dc/q/stv10hjo/Documents/EDAN70/extension-base/extendj/java4/frontend/NameCheck.jrag:56
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="NameCheck", declaredAt="/h/dc/q/stv10hjo/Documents/EDAN70/extension-base/extendj/java4/frontend/NameCheck.jrag:56")
  public Collection<Problem> nameProblems() {
    {
        Collection<Problem> problems = new LinkedList<Problem>();
        if (getAccess().lastAccess().isTypeAccess()
            && !getAccess().type().typeName().equals(typeName())) {
          problems.add(errorf("On demand type import %s.* is not the canonical name of type %s",
              typeName(), getAccess().type().typeName()));
        }
        return problems;
      }
  }
  /** @apilevel internal */
  private void importedTypes_String_reset() {
    importedTypes_String_values = null;
  }
  protected java.util.Map importedTypes_String_values;
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isCircular=true)
  @ASTNodeAnnotation.Source(aspect="TypeScopePropagation", declaredAt="/h/dc/q/stv10hjo/Documents/EDAN70/extension-base/extendj/java4/frontend/LookupType.jrag:457")
  public SimpleSet<TypeDecl> importedTypes(String name) {
    Object _parameters = name;
    if (importedTypes_String_values == null) importedTypes_String_values = new java.util.HashMap(4);
    ASTNode$State.CircularValue _value;
    if (importedTypes_String_values.containsKey(_parameters)) {
      Object _cache = importedTypes_String_values.get(_parameters);
      if (!(_cache instanceof ASTNode$State.CircularValue)) {
        return (SimpleSet<TypeDecl>) _cache;
      } else {
        _value = (ASTNode$State.CircularValue) _cache;
      }
    } else {
      _value = new ASTNode$State.CircularValue();
      importedTypes_String_values.put(_parameters, _value);
      _value.value = emptySet();
    }
    ASTNode$State state = state();
    if (!state.inCircle() || state.calledByLazyAttribute()) {
      state.enterCircle();
      SimpleSet<TypeDecl> new_importedTypes_String_value;
      do {
        _value.cycle = state.nextCycle();
        new_importedTypes_String_value = importedTypes_compute(name);
        if ((new_importedTypes_String_value == null && ((SimpleSet<TypeDecl>)_value.value) != null) || (new_importedTypes_String_value != null && !new_importedTypes_String_value.equals(((SimpleSet<TypeDecl>)_value.value)))) {
          state.setChangeInCycle();
          _value.value = new_importedTypes_String_value;
        }
      } while (state.testAndClearChangeInCycle());
      importedTypes_String_values.put(_parameters, new_importedTypes_String_value);

      state.leaveCircle();
      return new_importedTypes_String_value;
    } else if (_value.cycle != state.cycle()) {
      _value.cycle = state.cycle();
      SimpleSet<TypeDecl> new_importedTypes_String_value = importedTypes_compute(name);
      if ((new_importedTypes_String_value == null && ((SimpleSet<TypeDecl>)_value.value) != null) || (new_importedTypes_String_value != null && !new_importedTypes_String_value.equals(((SimpleSet<TypeDecl>)_value.value)))) {
        state.setChangeInCycle();
        _value.value = new_importedTypes_String_value;
      }
      return new_importedTypes_String_value;
    } else {
      return (SimpleSet<TypeDecl>) _value.value;
    }
  }
  /** @apilevel internal */
  private SimpleSet<TypeDecl> importedTypes_compute(String name) {
      SimpleSet<TypeDecl> result = emptySet();
      if (getAccess() instanceof PackageAccess) {
        String packageName = ((PackageAccess) getAccess()).getPackage();
        TypeDecl typeDecl = lookupType(packageName, name);
        if (typeDecl.accessibleFromPackage(packageName())
            && typeDecl.typeName().equals(packageName + "." + name)) {
          // Canonical names match.
          result = result.add(typeDecl);
        }
      } else {
        for (TypeDecl type : getAccess().type().memberTypes(name)) {
          if (type.accessibleFromPackage(packageName())
              && type.typeName().equals(getAccess().typeName() + "." + name)) {
            // Canonical names match.
            result = result.add(type);
          }
        }
      }
      return result;
    }
  /**
   * @attribute syn
   * @aspect TypeScopePropagation
   * @declaredat /h/dc/q/stv10hjo/Documents/EDAN70/extension-base/extendj/java4/frontend/LookupType.jrag:482
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeScopePropagation", declaredAt="/h/dc/q/stv10hjo/Documents/EDAN70/extension-base/extendj/java4/frontend/LookupType.jrag:482")
  public boolean isOnDemand() {
    boolean isOnDemand_value = true;
    return isOnDemand_value;
  }
  /**
   * @attribute syn
   * @aspect ImportOnDemand
   * @declaredat /h/dc/q/stv10hjo/Documents/EDAN70/extension-base/src/jastadd/ImportOnDemand.jrag:65
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="ImportOnDemand", declaredAt="/h/dc/q/stv10hjo/Documents/EDAN70/extension-base/src/jastadd/ImportOnDemand.jrag:65")
  public boolean isImportedAlready(String name) {
    {
            for(SingleTypeImportDecl s : compilationUnit().importTypes()) {
    
                    if(importedTypes(name).toString().equals("org.extendj.ast.GenericInterfaceDecl") ||
                     importedTypes(name).toString().equals("org.extendj.ast.ClassDecl") ||
                     importedTypes(name).toString().equals("org.extendj.ast.GenericClassDecl") ) {
                         if(s.getAccess().uberID().equals(name)){
                             return true;
                         }
    
                     }
    
             }
    
    
             return false;
        }
  }
  /**
   * @attribute inh
   * @aspect TypeScopePropagation
   * @declaredat /h/dc/q/stv10hjo/Documents/EDAN70/extension-base/extendj/java4/frontend/LookupType.jrag:479
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="TypeScopePropagation", declaredAt="/h/dc/q/stv10hjo/Documents/EDAN70/extension-base/extendj/java4/frontend/LookupType.jrag:479")
  public TypeDecl lookupType(String packageName, String typeName) {
    TypeDecl lookupType_String_String_value = getParent().Define_lookupType(this, null, packageName, typeName);
    return lookupType_String_String_value;
  }
  /**
   * @declaredat /h/dc/q/stv10hjo/Documents/EDAN70/extension-base/extendj/java4/frontend/SyntacticClassification.jrag:36
   * @apilevel internal
   */
  public NameType Define_nameType(ASTNode _callerNode, ASTNode _childNode) {
    if (getAccessNoTransform() != null && _callerNode == getAccess()) {
      // @declaredat /h/dc/q/stv10hjo/Documents/EDAN70/extension-base/extendj/java4/frontend/SyntacticClassification.jrag:127
      return NameType.PACKAGE_OR_TYPE_NAME;
    }
    else {
      return getParent().Define_nameType(this, _callerNode);
    }
  }
  protected boolean canDefine_nameType(ASTNode _callerNode, ASTNode _childNode) {
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
    // @declaredat /h/dc/q/stv10hjo/Documents/EDAN70/extension-base/extendj/java4/frontend/NameCheck.jrag:54
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
  protected void collect_contributors_CompilationUnit_onDemlines(CompilationUnit _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
    // @declaredat /h/dc/q/stv10hjo/Documents/EDAN70/extension-base/src/jastadd/ImportOnDemand.jrag:55
    if (isOnDemand()) {
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
    super.collect_contributors_CompilationUnit_onDemlines(_root, _map);
  }
  protected void contributeTo_CompilationUnit_problems(LinkedList<Problem> collection) {
    super.contributeTo_CompilationUnit_problems(collection);
    for (Problem value : nameProblems()) {
      collection.add(value);
    }
  }
  protected void contributeTo_CompilationUnit_onDemlines(HashSet<Integer> collection) {
    super.contributeTo_CompilationUnit_onDemlines(collection);
    if (isOnDemand()) {
      collection.add(lineNumber());
    }
  }
}
