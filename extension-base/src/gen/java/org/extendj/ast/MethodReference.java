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
 * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/grammar/MethodReference.ast:1
 * @production MethodReference : {@link Expr} ::= <span class="component">TypeArgument:{@link Access}*</span> <span class="component">&lt;ID:String&gt;</span>;

 */
public abstract class MethodReference extends Expr implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public MethodReference() {
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
    setChild(new List(), 0);
  }
  /**
   * @declaredat ASTNode:14
   */
  public MethodReference(List<Access> p0, String p1) {
    setChild(p0, 0);
    setID(p1);
  }
  /**
   * @declaredat ASTNode:18
   */
  public MethodReference(List<Access> p0, beaver.Symbol p1) {
    setChild(p0, 0);
    setID(p1);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:23
   */
  protected int numChildren() {
    return 1;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:29
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:33
   */
  public void flushAttrCache() {
    super.flushAttrCache();
    isExact_reset();
    isPolyExpression_reset();
    assignConversionTo_TypeDecl_reset();
    type_reset();
    compatibleStrictContext_TypeDecl_reset();
    compatibleLooseContext_TypeDecl_reset();
    pertinentToApplicability_Expr_BodyDecl_int_reset();
    moreSpecificThan_TypeDecl_TypeDecl_reset();
    potentiallyCompatible_TypeDecl_BodyDecl_reset();
    targetInterface_reset();
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
  public MethodReference clone() throws CloneNotSupportedException {
    MethodReference node = (MethodReference) super.clone();
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
  public abstract MethodReference fullCopy();
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:70
   */
  public abstract MethodReference treeCopyNoTransform();
  /**
   * Create a deep copy of the AST subtree at this node.
   * The subtree of this node is traversed to trigger rewrites before copy.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:78
   */
  public abstract MethodReference treeCopy();
  /**
   * Replaces the TypeArgument list.
   * @param list The new list node to be used as the TypeArgument list.
   * @apilevel high-level
   */
  public void setTypeArgumentList(List<Access> list) {
    setChild(list, 0);
  }
  /**
   * Retrieves the number of children in the TypeArgument list.
   * @return Number of children in the TypeArgument list.
   * @apilevel high-level
   */
  public int getNumTypeArgument() {
    return getTypeArgumentList().getNumChild();
  }
  /**
   * Retrieves the number of children in the TypeArgument list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the TypeArgument list.
   * @apilevel low-level
   */
  public int getNumTypeArgumentNoTransform() {
    return getTypeArgumentListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the TypeArgument list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the TypeArgument list.
   * @apilevel high-level
   */
  public Access getTypeArgument(int i) {
    return (Access) getTypeArgumentList().getChild(i);
  }
  /**
   * Check whether the TypeArgument list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasTypeArgument() {
    return getTypeArgumentList().getNumChild() != 0;
  }
  /**
   * Append an element to the TypeArgument list.
   * @param node The element to append to the TypeArgument list.
   * @apilevel high-level
   */
  public void addTypeArgument(Access node) {
    List<Access> list = (parent == null) ? getTypeArgumentListNoTransform() : getTypeArgumentList();
    list.addChild(node);
  }
  /** @apilevel low-level 
   */
  public void addTypeArgumentNoTransform(Access node) {
    List<Access> list = getTypeArgumentListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the TypeArgument list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setTypeArgument(Access node, int i) {
    List<Access> list = getTypeArgumentList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the TypeArgument list.
   * @return The node representing the TypeArgument list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="TypeArgument")
  public List<Access> getTypeArgumentList() {
    List<Access> list = (List<Access>) getChild(0);
    return list;
  }
  /**
   * Retrieves the TypeArgument list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the TypeArgument list.
   * @apilevel low-level
   */
  public List<Access> getTypeArgumentListNoTransform() {
    return (List<Access>) getChildNoTransform(0);
  }
  /**
   * @return the element at index {@code i} in the TypeArgument list without
   * triggering rewrites.
   */
  public Access getTypeArgumentNoTransform(int i) {
    return (Access) getTypeArgumentListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the TypeArgument list.
   * @return The node representing the TypeArgument list.
   * @apilevel high-level
   */
  public List<Access> getTypeArguments() {
    return getTypeArgumentList();
  }
  /**
   * Retrieves the TypeArgument list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the TypeArgument list.
   * @apilevel low-level
   */
  public List<Access> getTypeArgumentsNoTransform() {
    return getTypeArgumentListNoTransform();
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
   * @aspect MethodReference
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/MethodReference.jrag:218
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="MethodReference", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/MethodReference.jrag:218")
  public abstract boolean congruentTo(FunctionDescriptor f);
  /**
   * @attribute syn
   * @aspect MethodReference
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/MethodReference.jrag:259
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="MethodReference", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/MethodReference.jrag:259")
  public abstract ArrayList<MethodDecl> potentiallyApplicableMethods(FunctionDescriptor f);
  /**
   * @attribute syn
   * @aspect MethodReference
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/MethodReference.jrag:314
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="MethodReference", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/MethodReference.jrag:314")
  public abstract MethodDecl exactCompileTimeDeclaration();
  /** @apilevel internal */
  private void isExact_reset() {
    isExact_computed = null;
  }
  /** @apilevel internal */
  protected ASTNode$State.Cycle isExact_computed = null;

  /** @apilevel internal */
  protected boolean isExact_value;

  /**
   * @attribute syn
   * @aspect MethodReference
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/MethodReference.jrag:313
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="MethodReference", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/MethodReference.jrag:313")
  public boolean isExact() {
    ASTNode$State state = state();
    if (isExact_computed == ASTNode$State.NON_CYCLE || isExact_computed == state().cycle()) {
      return isExact_value;
    }
    isExact_value = exactCompileTimeDeclaration() != unknownMethod();
    if (state().inCircle()) {
      isExact_computed = state().cycle();
    
    } else {
      isExact_computed = ASTNode$State.NON_CYCLE;
    
    }
    return isExact_value;
  }
  /**
   * @attribute syn
   * @aspect Java8NameCheck
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/NameCheck.jrag:505
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Java8NameCheck", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/NameCheck.jrag:505")
  public Collection<Problem> nameProblems() {
    {
        for (int i = 0; i < getNumTypeArgument(); i++) {
          if (getTypeArgument(i) instanceof AbstractWildcard) {
            return Collections.singletonList(
                error("Wildcard not allowed in method reference type argument lists"));
          }
        }
        return Collections.emptyList();
      }
  }
  /** @apilevel internal */
  private void isPolyExpression_reset() {
    isPolyExpression_computed = null;
  }
  /** @apilevel internal */
  protected ASTNode$State.Cycle isPolyExpression_computed = null;

  /** @apilevel internal */
  protected boolean isPolyExpression_value;

  /**
   * @attribute syn
   * @aspect PolyExpressions
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/PolyExpressions.jrag:86
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="PolyExpressions", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/PolyExpressions.jrag:86")
  public boolean isPolyExpression() {
    ASTNode$State state = state();
    if (isPolyExpression_computed == ASTNode$State.NON_CYCLE || isPolyExpression_computed == state().cycle()) {
      return isPolyExpression_value;
    }
    isPolyExpression_value = true;
    if (state().inCircle()) {
      isPolyExpression_computed = state().cycle();
    
    } else {
      isPolyExpression_computed = ASTNode$State.NON_CYCLE;
    
    }
    return isPolyExpression_value;
  }
  /** @apilevel internal */
  private void assignConversionTo_TypeDecl_reset() {
    assignConversionTo_TypeDecl_computed = new java.util.HashMap(4);
    assignConversionTo_TypeDecl_values = null;
  }
  /** @apilevel internal */
  protected java.util.Map assignConversionTo_TypeDecl_values;
  /** @apilevel internal */
  protected java.util.Map assignConversionTo_TypeDecl_computed;
  /**
   * @attribute syn
   * @aspect PolyExpressions
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/PolyExpressions.jrag:149
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="PolyExpressions", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/PolyExpressions.jrag:149")
  public boolean assignConversionTo(TypeDecl type) {
    Object _parameters = type;
    if (assignConversionTo_TypeDecl_computed == null) assignConversionTo_TypeDecl_computed = new java.util.HashMap(4);
    if (assignConversionTo_TypeDecl_values == null) assignConversionTo_TypeDecl_values = new java.util.HashMap(4);
    ASTNode$State state = state();
    if (assignConversionTo_TypeDecl_values.containsKey(_parameters) && assignConversionTo_TypeDecl_computed != null
        && assignConversionTo_TypeDecl_computed.containsKey(_parameters)
        && (assignConversionTo_TypeDecl_computed.get(_parameters) == ASTNode$State.NON_CYCLE || assignConversionTo_TypeDecl_computed.get(_parameters) == state().cycle())) {
      return (Boolean) assignConversionTo_TypeDecl_values.get(_parameters);
    }
    boolean assignConversionTo_TypeDecl_value = assignConversionTo_compute(type);
    if (state().inCircle()) {
      assignConversionTo_TypeDecl_values.put(_parameters, assignConversionTo_TypeDecl_value);
      assignConversionTo_TypeDecl_computed.put(_parameters, state().cycle());
    
    } else {
      assignConversionTo_TypeDecl_values.put(_parameters, assignConversionTo_TypeDecl_value);
      assignConversionTo_TypeDecl_computed.put(_parameters, ASTNode$State.NON_CYCLE);
    
    }
    return assignConversionTo_TypeDecl_value;
  }
  /** @apilevel internal */
  private boolean assignConversionTo_compute(TypeDecl type) {
      if (!type.isFunctionalInterface()) {
        return false;
      }
      FunctionDescriptor f = ((InterfaceDecl) type).functionDescriptor();
      return congruentTo(f);
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
   * @aspect TypeCheck
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/TypeCheck.jrag:76
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeCheck", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/TypeCheck.jrag:76")
  public TypeDecl type() {
    ASTNode$State state = state();
    if (type_computed == ASTNode$State.NON_CYCLE || type_computed == state().cycle()) {
      return type_value;
    }
    type_value = type_compute();
    if (state().inCircle()) {
      type_computed = state().cycle();
    
    } else {
      type_computed = ASTNode$State.NON_CYCLE;
    
    }
    return type_value;
  }
  /** @apilevel internal */
  private TypeDecl type_compute() {
      // 15.13.1
      if (!assignmentContext() && !castContext() && !invocationContext()) {
        return unknownType();
      }
      if (targetInterface() == null) {
        return unknownType();
      }
  
      InterfaceDecl iDecl = targetInterface();
      if (!iDecl.isFunctional()) {
        return unknownType();
      }
  
      if (congruentTo(iDecl.functionDescriptor())) {
        return iDecl;
      } else {
        return unknownType();
      }
    }
  /**
   * @attribute syn
   * @aspect TypeCheck
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/TypeCheck.jrag:234
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeCheck", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/TypeCheck.jrag:234")
  public Collection<Problem> typeProblems() {
    {
        Collection<Problem> problems = new LinkedList<Problem>();
        // 15.13.1
        if (!assignmentContext() && !castContext() && !invocationContext()) {
          problems.add(error("Method references must target a functional interface"));
          return problems;
        }
    
        // This means there was an error in the overload resolution, will be reported elsewhere.
        if (invocationContext() && targetType() == unknownType()) {
          return Collections.emptyList();
        }
    
        if (!targetType().isFunctionalInterface()) {
          problems.add(error("Method references must target a functional interface"));
          return problems;
        }
    
        InterfaceDecl iDecl = targetInterface();
    
        if (!iDecl.isFunctional()) {
          problems.add(errorf("Interface %s is not functional and can therefore not be targeted by a method reference",
              iDecl.typeName()));
          return problems;
        }
    
        MethodDecl found = null;
        FunctionDescriptor f = iDecl.functionDescriptor();
        // Lookup method here and check that one most specific can be found
        if (this instanceof ExprMethodReference) {
          ExprMethodReference ref = (ExprMethodReference) this;
          found = ref.targetMethod(f);
          if (unknownMethod() == found) {
            // 15.13.1
            problems.add(errorf("No method %s that is compatible with the method %s in the interface %s was found",
                name(), iDecl.functionDescriptor().method.fullSignature(), iDecl.typeName()));
          } else if (found.isStatic()) {
            problems.add(errorf("The method %s in type %s must be accessed in a static way",
                found.fullSignature(), found.hostType().typeName()));
          } else if (ref.getExpr() instanceof Access && ((Access) ref.getExpr()).lastAccess() instanceof SuperAccess) {
            // 15.13.2
            if (found.isAbstract()) {
              problems.add(errorf("Cannot directly invoke the abstract method %s in type %s",
                  found.fullSignature(), found.hostType().typeName()));
            }
    
            SuperAccess superAccess = (SuperAccess)((Access) ref.getExpr()).lastAccess();
            if (superAccess.isQualified() && superAccess.decl() instanceof InterfaceDecl) {
              if (hostType().isClassDecl()) {
                ClassDecl classDecl = (ClassDecl) hostType();
                if (classDecl.hasOverridingMethodInSuper(found)) {
                  problems.add(errorf(
                      "Cannot make a super reference to method %s, there is a more specific override",
                      found.fullSignature()));
                }
              } else if (hostType().isInterfaceDecl()) {
                InterfaceDecl interfaceDecl = (InterfaceDecl) hostType();
                if (interfaceDecl.hasOverridingMethodInSuper(found)) {
                  problems.add(errorf(
                      "Cannot make a super reference to method %s, there is a more specific override",
                      found.fullSignature()));
                }
              }
            }
    
          }
        } else if (this instanceof TypeMethodReference) {
          TypeMethodReference ref = (TypeMethodReference) this;
          MethodDecl staticMethod = ref.targetStaticMethod(f);
          MethodDecl instanceMethod = ref.targetInstanceMethod(f);
          if (ref.validStaticMethod(f) && ref.validInstanceMethod(f)) {
            problems.add(errorf("Ambiguity error: two possible methods %s was found",
                staticMethod.name()));
            return problems;
          } else if (unknownMethod() == staticMethod && unknownMethod() == instanceMethod) {
            problems.add(errorf(
                "No method %s that is compatible with the method %s in the interface %s was found",
                name(), iDecl.functionDescriptor().method.fullSignature(), iDecl.typeName()));
             return problems;
          } else if (ref.validStaticMethod(f)) {
            if (ref.getTypeAccess() instanceof ParTypeAccess) {
              problems.add(
                  error("Parameterized qualifier is not allowed for static method references"));
            } else {
              found = staticMethod;
            }
          } else if (ref.validInstanceMethod(f)) {
            found = instanceMethod;
          } else if (unknownMethod() != staticMethod && !staticMethod.isStatic()) {
            problems.add(errorf("Cannot make a static reference to the non-static method %s in type %s",
                staticMethod.fullSignature(), staticMethod.hostType().typeName()));
            return problems;
          } else if (instanceMethod.isStatic()) {
            problems.add(errorf("The method %s in type %s must be accessed in a static way",
                instanceMethod.fullSignature(), instanceMethod.hostType().typeName()));
            return problems;
          }
        }
    
        if (found != null && unknownMethod() != found) {
          // Check that found is compatible with the function descriptor
          if (!iDecl.functionDescriptor().method.type().isVoid()) {
            // 15.13.1
            if (found.type().isVoid()
                || !found.type().assignConversionTo(iDecl.functionDescriptor().method.type(), null)) {
              problems.add(errorf("Return type of referenced method %s is not compatible with method %s in interface %s",
                  found.fullSignature(), iDecl.functionDescriptor().method.fullSignature(),
                  iDecl.typeName()));
            }
          }
    
          for (int i = 0; i < found.getNumException(); i++) {
            TypeDecl exception = found.getException(i).type();
            if (exception.isUncheckedException()) {
              continue;
            }
    
            boolean legalException = false;
            for (TypeDecl descriptorThrows : iDecl.functionDescriptor().throwsList) {
              if (exception.strictSubtype(descriptorThrows)) {
                legalException = true;
                break;
              }
            }
            if (!legalException) {
              // 15.13.1
              problems.add(errorf("Referenced method %s throws unhandled exception type %s",
                  found.name(), exception.typeName()));
            }
          }
        }
        return problems;
      }
  }
  /**
   * @attribute syn
   * @aspect Names
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/QualifiedNames.jrag:30
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Names", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/QualifiedNames.jrag:30")
  public String name() {
    String name_value = getID();
    return name_value;
  }
  /** @apilevel internal */
  private void compatibleStrictContext_TypeDecl_reset() {
    compatibleStrictContext_TypeDecl_computed = new java.util.HashMap(4);
    compatibleStrictContext_TypeDecl_values = null;
  }
  /** @apilevel internal */
  protected java.util.Map compatibleStrictContext_TypeDecl_values;
  /** @apilevel internal */
  protected java.util.Map compatibleStrictContext_TypeDecl_computed;
  /**
   * @attribute syn
   * @aspect MethodSignature18
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/MethodSignature.jrag:32
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="MethodSignature18", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/MethodSignature.jrag:32")
  public boolean compatibleStrictContext(TypeDecl type) {
    Object _parameters = type;
    if (compatibleStrictContext_TypeDecl_computed == null) compatibleStrictContext_TypeDecl_computed = new java.util.HashMap(4);
    if (compatibleStrictContext_TypeDecl_values == null) compatibleStrictContext_TypeDecl_values = new java.util.HashMap(4);
    ASTNode$State state = state();
    if (compatibleStrictContext_TypeDecl_values.containsKey(_parameters) && compatibleStrictContext_TypeDecl_computed != null
        && compatibleStrictContext_TypeDecl_computed.containsKey(_parameters)
        && (compatibleStrictContext_TypeDecl_computed.get(_parameters) == ASTNode$State.NON_CYCLE || compatibleStrictContext_TypeDecl_computed.get(_parameters) == state().cycle())) {
      return (Boolean) compatibleStrictContext_TypeDecl_values.get(_parameters);
    }
    boolean compatibleStrictContext_TypeDecl_value = compatibleStrictContext_compute(type);
    if (state().inCircle()) {
      compatibleStrictContext_TypeDecl_values.put(_parameters, compatibleStrictContext_TypeDecl_value);
      compatibleStrictContext_TypeDecl_computed.put(_parameters, state().cycle());
    
    } else {
      compatibleStrictContext_TypeDecl_values.put(_parameters, compatibleStrictContext_TypeDecl_value);
      compatibleStrictContext_TypeDecl_computed.put(_parameters, ASTNode$State.NON_CYCLE);
    
    }
    return compatibleStrictContext_TypeDecl_value;
  }
  /** @apilevel internal */
  private boolean compatibleStrictContext_compute(TypeDecl type) {
      if (!type.isFunctionalInterface()) {
        return false;
      }
      InterfaceDecl iDecl = (InterfaceDecl) type;
      return congruentTo(iDecl.functionDescriptor());
    }
  /** @apilevel internal */
  private void compatibleLooseContext_TypeDecl_reset() {
    compatibleLooseContext_TypeDecl_computed = new java.util.HashMap(4);
    compatibleLooseContext_TypeDecl_values = null;
  }
  /** @apilevel internal */
  protected java.util.Map compatibleLooseContext_TypeDecl_values;
  /** @apilevel internal */
  protected java.util.Map compatibleLooseContext_TypeDecl_computed;
  /**
   * @attribute syn
   * @aspect MethodSignature18
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/MethodSignature.jrag:76
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="MethodSignature18", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/MethodSignature.jrag:76")
  public boolean compatibleLooseContext(TypeDecl type) {
    Object _parameters = type;
    if (compatibleLooseContext_TypeDecl_computed == null) compatibleLooseContext_TypeDecl_computed = new java.util.HashMap(4);
    if (compatibleLooseContext_TypeDecl_values == null) compatibleLooseContext_TypeDecl_values = new java.util.HashMap(4);
    ASTNode$State state = state();
    if (compatibleLooseContext_TypeDecl_values.containsKey(_parameters) && compatibleLooseContext_TypeDecl_computed != null
        && compatibleLooseContext_TypeDecl_computed.containsKey(_parameters)
        && (compatibleLooseContext_TypeDecl_computed.get(_parameters) == ASTNode$State.NON_CYCLE || compatibleLooseContext_TypeDecl_computed.get(_parameters) == state().cycle())) {
      return (Boolean) compatibleLooseContext_TypeDecl_values.get(_parameters);
    }
    boolean compatibleLooseContext_TypeDecl_value = compatibleStrictContext(type);
    if (state().inCircle()) {
      compatibleLooseContext_TypeDecl_values.put(_parameters, compatibleLooseContext_TypeDecl_value);
      compatibleLooseContext_TypeDecl_computed.put(_parameters, state().cycle());
    
    } else {
      compatibleLooseContext_TypeDecl_values.put(_parameters, compatibleLooseContext_TypeDecl_value);
      compatibleLooseContext_TypeDecl_computed.put(_parameters, ASTNode$State.NON_CYCLE);
    
    }
    return compatibleLooseContext_TypeDecl_value;
  }
  /** @apilevel internal */
  private void pertinentToApplicability_Expr_BodyDecl_int_reset() {
    pertinentToApplicability_Expr_BodyDecl_int_computed = new java.util.HashMap(4);
    pertinentToApplicability_Expr_BodyDecl_int_values = null;
  }
  /** @apilevel internal */
  protected java.util.Map pertinentToApplicability_Expr_BodyDecl_int_values;
  /** @apilevel internal */
  protected java.util.Map pertinentToApplicability_Expr_BodyDecl_int_computed;
  /**
   * @attribute syn
   * @aspect MethodSignature18
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/MethodSignature.jrag:104
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="MethodSignature18", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/MethodSignature.jrag:104")
  public boolean pertinentToApplicability(Expr access, BodyDecl decl, int argIndex) {
    java.util.List _parameters = new java.util.ArrayList(3);
    _parameters.add(access);
    _parameters.add(decl);
    _parameters.add(argIndex);
    if (pertinentToApplicability_Expr_BodyDecl_int_computed == null) pertinentToApplicability_Expr_BodyDecl_int_computed = new java.util.HashMap(4);
    if (pertinentToApplicability_Expr_BodyDecl_int_values == null) pertinentToApplicability_Expr_BodyDecl_int_values = new java.util.HashMap(4);
    ASTNode$State state = state();
    if (pertinentToApplicability_Expr_BodyDecl_int_values.containsKey(_parameters) && pertinentToApplicability_Expr_BodyDecl_int_computed != null
        && pertinentToApplicability_Expr_BodyDecl_int_computed.containsKey(_parameters)
        && (pertinentToApplicability_Expr_BodyDecl_int_computed.get(_parameters) == ASTNode$State.NON_CYCLE || pertinentToApplicability_Expr_BodyDecl_int_computed.get(_parameters) == state().cycle())) {
      return (Boolean) pertinentToApplicability_Expr_BodyDecl_int_values.get(_parameters);
    }
    boolean pertinentToApplicability_Expr_BodyDecl_int_value = pertinentToApplicability_compute(access, decl, argIndex);
    if (state().inCircle()) {
      pertinentToApplicability_Expr_BodyDecl_int_values.put(_parameters, pertinentToApplicability_Expr_BodyDecl_int_value);
      pertinentToApplicability_Expr_BodyDecl_int_computed.put(_parameters, state().cycle());
    
    } else {
      pertinentToApplicability_Expr_BodyDecl_int_values.put(_parameters, pertinentToApplicability_Expr_BodyDecl_int_value);
      pertinentToApplicability_Expr_BodyDecl_int_computed.put(_parameters, ASTNode$State.NON_CYCLE);
    
    }
    return pertinentToApplicability_Expr_BodyDecl_int_value;
  }
  /** @apilevel internal */
  private boolean pertinentToApplicability_compute(Expr access, BodyDecl decl, int argIndex) {
      if (!isExact()) {
        return false;
      }
      if (decl instanceof MethodDecl
          && decl.isGeneric()
          && !(access instanceof ParMethodAccess)
          && ((MethodDecl) decl).genericDecl().getParameter(argIndex).type().isTypeVariable()) {
        GenericMethodDecl genericDecl = ((MethodDecl) decl).genericDecl();
        TypeVariable typeVar = (TypeVariable) genericDecl.getParameter(argIndex).type();
        for (int i = 0; i < genericDecl.getNumTypeParameter(); i++) {
          if (typeVar == genericDecl.getTypeParameter(i)) {
            return false;
          }
        }
      } else if (decl instanceof ConstructorDecl
          && decl.isGeneric()
          && !(access instanceof ParConstructorAccess)
          && !(access instanceof ParSuperConstructorAccess)
          && !(access instanceof ParClassInstanceExpr)
          && ((ConstructorDecl) decl).genericDecl().getParameter(argIndex).type().isTypeVariable()) {
        GenericConstructorDecl genericDecl = ((ConstructorDecl) decl).genericDecl();
        TypeVariable typeVar = (TypeVariable) genericDecl.getParameter(argIndex).type();
        for (int i = 0; i < genericDecl.getNumTypeParameter(); i++) {
          if (typeVar == genericDecl.getTypeParameter(i)) {
            return false;
          }
        }
      }
      return true;
    }
  /** @apilevel internal */
  private void moreSpecificThan_TypeDecl_TypeDecl_reset() {
    moreSpecificThan_TypeDecl_TypeDecl_computed = new java.util.HashMap(4);
    moreSpecificThan_TypeDecl_TypeDecl_values = null;
  }
  /** @apilevel internal */
  protected java.util.Map moreSpecificThan_TypeDecl_TypeDecl_values;
  /** @apilevel internal */
  protected java.util.Map moreSpecificThan_TypeDecl_TypeDecl_computed;
  /**
   * Computes which type is more specific for a specific argument, as defined in 15.12.2.5
   * @param type1
   * @param type2
   * @return {@code true} if type1 is more specific than type2, {@code false} otherwise
   * @attribute syn
   * @aspect MethodSignature18
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/MethodSignature.jrag:230
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="MethodSignature18", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/MethodSignature.jrag:230")
  public boolean moreSpecificThan(TypeDecl type1, TypeDecl type2) {
    java.util.List _parameters = new java.util.ArrayList(2);
    _parameters.add(type1);
    _parameters.add(type2);
    if (moreSpecificThan_TypeDecl_TypeDecl_computed == null) moreSpecificThan_TypeDecl_TypeDecl_computed = new java.util.HashMap(4);
    if (moreSpecificThan_TypeDecl_TypeDecl_values == null) moreSpecificThan_TypeDecl_TypeDecl_values = new java.util.HashMap(4);
    ASTNode$State state = state();
    if (moreSpecificThan_TypeDecl_TypeDecl_values.containsKey(_parameters) && moreSpecificThan_TypeDecl_TypeDecl_computed != null
        && moreSpecificThan_TypeDecl_TypeDecl_computed.containsKey(_parameters)
        && (moreSpecificThan_TypeDecl_TypeDecl_computed.get(_parameters) == ASTNode$State.NON_CYCLE || moreSpecificThan_TypeDecl_TypeDecl_computed.get(_parameters) == state().cycle())) {
      return (Boolean) moreSpecificThan_TypeDecl_TypeDecl_values.get(_parameters);
    }
    boolean moreSpecificThan_TypeDecl_TypeDecl_value = moreSpecificThan_compute(type1, type2);
    if (state().inCircle()) {
      moreSpecificThan_TypeDecl_TypeDecl_values.put(_parameters, moreSpecificThan_TypeDecl_TypeDecl_value);
      moreSpecificThan_TypeDecl_TypeDecl_computed.put(_parameters, state().cycle());
    
    } else {
      moreSpecificThan_TypeDecl_TypeDecl_values.put(_parameters, moreSpecificThan_TypeDecl_TypeDecl_value);
      moreSpecificThan_TypeDecl_TypeDecl_computed.put(_parameters, ASTNode$State.NON_CYCLE);
    
    }
    return moreSpecificThan_TypeDecl_TypeDecl_value;
  }
  /** @apilevel internal */
  private boolean moreSpecificThan_compute(TypeDecl type1, TypeDecl type2) {
      if (super.moreSpecificThan(type1, type2)) {
        return true;
      }
      if (!type1.isFunctionalInterface() || !type2.isFunctionalInterface()) {
        return false;
      }
      if (type2.instanceOf(type1)) {
        return false;
      }
      InterfaceDecl iDecl1 = (InterfaceDecl) type1;
      InterfaceDecl iDecl2 = (InterfaceDecl) type2;
  
      if (!isExact()) {
        return false;
      }
  
      FunctionDescriptor f1 = iDecl1.functionDescriptor();
      FunctionDescriptor f2 = iDecl2.functionDescriptor();
  
      if (f1.method.arity() != f2.method.arity()) {
        return false;
      }
  
      for (int i = 0; i < f1.method.getNumParameter(); i++) {
        if (f1.method.getParameter(i).type() != f2.method.getParameter(i).type()) {
          return false;
        }
      }
  
      // First bullet
      if (f2.method.type().isVoid()) {
        return true;
      }
  
      // Second bullet
      if (f1.method.type().instanceOf(f2.method.type())) {
        return true;
      }
  
      // Third bullet
      if (f1.method.type().isPrimitiveType() && f2.method.type().isReferenceType()) {
        return exactCompileTimeDeclaration().type().isPrimitiveType();
      }
  
      // Fourth bullet
      if (f1.method.type().isReferenceType() && f2.method.type().isPrimitiveType()) {
        return exactCompileTimeDeclaration().type().isReferenceType();
      }
  
      return false;
    }
  /** @apilevel internal */
  private void potentiallyCompatible_TypeDecl_BodyDecl_reset() {
    potentiallyCompatible_TypeDecl_BodyDecl_computed = new java.util.HashMap(4);
    potentiallyCompatible_TypeDecl_BodyDecl_values = null;
  }
  /** @apilevel internal */
  protected java.util.Map potentiallyCompatible_TypeDecl_BodyDecl_values;
  /** @apilevel internal */
  protected java.util.Map potentiallyCompatible_TypeDecl_BodyDecl_computed;
  /**
   * @attribute syn
   * @aspect MethodSignature18
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/MethodSignature.jrag:465
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="MethodSignature18", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/MethodSignature.jrag:465")
  public boolean potentiallyCompatible(TypeDecl type, BodyDecl candidateDecl) {
    java.util.List _parameters = new java.util.ArrayList(2);
    _parameters.add(type);
    _parameters.add(candidateDecl);
    if (potentiallyCompatible_TypeDecl_BodyDecl_computed == null) potentiallyCompatible_TypeDecl_BodyDecl_computed = new java.util.HashMap(4);
    if (potentiallyCompatible_TypeDecl_BodyDecl_values == null) potentiallyCompatible_TypeDecl_BodyDecl_values = new java.util.HashMap(4);
    ASTNode$State state = state();
    if (potentiallyCompatible_TypeDecl_BodyDecl_values.containsKey(_parameters) && potentiallyCompatible_TypeDecl_BodyDecl_computed != null
        && potentiallyCompatible_TypeDecl_BodyDecl_computed.containsKey(_parameters)
        && (potentiallyCompatible_TypeDecl_BodyDecl_computed.get(_parameters) == ASTNode$State.NON_CYCLE || potentiallyCompatible_TypeDecl_BodyDecl_computed.get(_parameters) == state().cycle())) {
      return (Boolean) potentiallyCompatible_TypeDecl_BodyDecl_values.get(_parameters);
    }
    boolean potentiallyCompatible_TypeDecl_BodyDecl_value = potentiallyCompatible_compute(type, candidateDecl);
    if (state().inCircle()) {
      potentiallyCompatible_TypeDecl_BodyDecl_values.put(_parameters, potentiallyCompatible_TypeDecl_BodyDecl_value);
      potentiallyCompatible_TypeDecl_BodyDecl_computed.put(_parameters, state().cycle());
    
    } else {
      potentiallyCompatible_TypeDecl_BodyDecl_values.put(_parameters, potentiallyCompatible_TypeDecl_BodyDecl_value);
      potentiallyCompatible_TypeDecl_BodyDecl_computed.put(_parameters, ASTNode$State.NON_CYCLE);
    
    }
    return potentiallyCompatible_TypeDecl_BodyDecl_value;
  }
  /** @apilevel internal */
  private boolean potentiallyCompatible_compute(TypeDecl type, BodyDecl candidateDecl) {
      if (type.isTypeVariable()) {
        if (candidateDecl.isGeneric()) {
          boolean foundTypeVariable = false;
          List<TypeVariable> typeParams = candidateDecl.typeParameters();
          for (int i = 0; i < typeParams.getNumChild(); i++) {
            if (type == typeParams.getChild(i)) {
              foundTypeVariable = true;
              break;
            }
          }
          return foundTypeVariable;
        } else {
          return false;
        }
      }
  
      if (!type.isFunctionalInterface()) {
        return false;
      }
      return true;
    }
  /** @apilevel internal */
  private void targetInterface_reset() {
    targetInterface_computed = null;
    targetInterface_value = null;
  }
  /** @apilevel internal */
  protected ASTNode$State.Cycle targetInterface_computed = null;

  /** @apilevel internal */
  protected InterfaceDecl targetInterface_value;

  /**
   * @attribute syn
   * @aspect TargetType
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/TargetType.jrag:151
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TargetType", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/TargetType.jrag:151")
  public InterfaceDecl targetInterface() {
    ASTNode$State state = state();
    if (targetInterface_computed == ASTNode$State.NON_CYCLE || targetInterface_computed == state().cycle()) {
      return targetInterface_value;
    }
    targetInterface_value = targetInterface_compute();
    if (state().inCircle()) {
      targetInterface_computed = state().cycle();
    
    } else {
      targetInterface_computed = ASTNode$State.NON_CYCLE;
    
    }
    return targetInterface_value;
  }
  /** @apilevel internal */
  private InterfaceDecl targetInterface_compute() {
      if (targetType().isNull()) {
        return null;
      } else if (!(targetType() instanceof InterfaceDecl)) {
        return null;
      } else {
        return (InterfaceDecl) targetType();
      }
    }
  /**
   * @attribute inh
   * @aspect MethodReference
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/MethodReference.jrag:30
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="MethodReference", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/MethodReference.jrag:30")
  public MethodDecl unknownMethod() {
    MethodDecl unknownMethod_value = getParent().Define_unknownMethod(this, null);
    return unknownMethod_value;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/SyntacticClassification.jrag:36
   * @apilevel internal
   */
  public NameType Define_nameType(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getTypeArgumentListNoTransform()) {
      // @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/MethodReference.jrag:194
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
  /** @apilevel internal */
  public ASTNode rewriteTo() {
    return super.rewriteTo();
  }
  /** @apilevel internal */
  public boolean canRewrite() {
    return false;
  }
  protected void collect_contributors_CompilationUnit_problems(CompilationUnit _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
    // @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/NameCheck.jrag:503
    {
      java.util.Set<ASTNode> contributors = _map.get(_root);
      if (contributors == null) {
        contributors = new java.util.LinkedHashSet<ASTNode>();
        _map.put((ASTNode) _root, contributors);
      }
      contributors.add(this);
    }
    // @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/TypeCheck.jrag:232
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
  protected void contributeTo_CompilationUnit_problems(LinkedList<Problem> collection) {
    super.contributeTo_CompilationUnit_problems(collection);
    for (Problem value : nameProblems()) {
      collection.add(value);
    }
    for (Problem value : typeProblems()) {
      collection.add(value);
    }
  }
}
