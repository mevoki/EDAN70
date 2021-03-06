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
 * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/grammar/Java.ast:4
 * @production CompilationUnit : {@link ASTNode} ::= <span class="component">&lt;PackageDecl:String&gt;</span> <span class="component">{@link ImportDecl}*</span> <span class="component">{@link TypeDecl}*</span>;

 */
public class CompilationUnit extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect Java4PrettyPrint
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/PrettyPrint.jadd:223
   */
  public void prettyPrint(PrettyPrinter out) {
    if (hasPackageDecl()) {
      out.print("package ");
      out.print(getPackageDecl());
      out.print(";");
      out.println();
    }
    if (!out.isNewLine()) {
      out.println();
    }
    out.print(getImportDeclList());
    if (!out.isNewLine()) {
      out.println();
    }
    out.println();
    out.join(getTypeDecls(), new PrettyPrinter.Joiner() {
      @Override
      public void printSeparator(PrettyPrinter out) {
        out.println();
        out.println();
      }
    });
  }
  /**
   * @aspect ErrorCheck
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/ErrorCheck.jrag:95
   */
  public Collection<Problem> parseErrors() {
    return parseErrors;
  }
  /**
   * @aspect ErrorCheck
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/ErrorCheck.jrag:99
   */
  public void addParseError(Problem msg) {
    parseErrors.add(msg);
  }
  /**
   * @aspect ErrorCheck
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/ErrorCheck.jrag:103
   */
  protected Collection<Problem> parseErrors = new ArrayList<Problem>();
  /**
   * @aspect ClassPath
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/ClassPath.jrag:435
   */
  private ClassSource classSource = ClassSource.NONE;
  /**
   * @aspect ClassPath
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/ClassPath.jrag:437
   */
  private boolean fromSource = false;
  /**
   * @aspect ClassPath
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/ClassPath.jrag:439
   */
  public void setClassSource(ClassSource source) {
    this.classSource = source;
  }
  /**
   * @aspect ClassPath
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/ClassPath.jrag:443
   */
  public ClassSource getClassSource() {
    return classSource;
  }
  /**
   * @aspect ClassPath
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/ClassPath.jrag:447
   */
  public void setFromSource(boolean value) {
    this.fromSource = value;
  }
  /**
   * @aspect RemoveImports
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/src/jastadd/RemoveImports.jrag:4
   */
  public void removeImports() {

    FileInputStream in = null;
    BufferedReader reader = null;
    FileWriter writer = null;

    try {
        writer = new FileWriter(pathName()+".cleaned");
        in = new FileInputStream(pathName());
        reader = new BufferedReader(new InputStreamReader(in));

        String line = reader.readLine();
        int lineNumber = 1;

        while(line != null){

            if(!killableLines().contains(lineNumber)){
                if(onDemlines().contains(lineNumber)){
                    String result = line.replaceAll("[*;]","");
                     result = result.replaceAll("import","");
                    result = result.replaceAll(" ","");
                    for(String s : importTypesOnDemand()){
                        if(s.contains(result)) {
                            writer.write("import " + s + ";");
                            writer.write("\n");
                        }
                    }

                } else if(staticOnDemlines().contains(lineNumber)){
                    String result = line.replaceAll("[*;]","");
                    result = result.replaceAll("import","");
                    result = result.replaceAll("static","");
                   result = result.replaceAll(" ","");
                   for(String s : staticImportsOnDemand()){
                       if(s.contains(result)) {
                           writer.write("import static " + s + ";");
                           writer.write("\n");
                       }
                   }

                } else {

                if(methodLinesWhereWeShouldAddOverrideAnnotation().contains(lineNumber)) {
                    writer.write("\t" + "@Override");
                    writer.write("\n");
                }

                writer.write(line);
                writer.write("\n");
            }
            }
            lineNumber++;
            line = reader.readLine();
        }



    }catch(Exception e){

    }finally {
            try {
                in.close();
            } catch (Exception e) {}

            try {
                reader.close();
            } catch (Exception e) {}

            try {
                writer.close();
            } catch (Exception e) {}



            //File f1 = new File(pathName());
            //f1.renameTo(new File(pathName() + ".old"));


            //File f2 = new File(pathName() + ".temp");
            //f2.renameTo(new File(pathName()));



    }
  }
  /**
   * @aspect ExtensionBase
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/src/jastadd/ExtensionBase.jrag:3
   */
  public void process() {
    System.out.println(pathName() + " contained no errors");
    
  }
  /**
   * @declaredat ASTNode:1
   */
  public CompilationUnit() {
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
    setChild(new List(), 0);
    setChild(new List(), 1);
  }
  /**
   * @declaredat ASTNode:15
   */
  public CompilationUnit(String p0, List<ImportDecl> p1, List<TypeDecl> p2) {
    setPackageDecl(p0);
    setChild(p1, 0);
    setChild(p2, 1);
  }
  /**
   * @declaredat ASTNode:20
   */
  public CompilationUnit(beaver.Symbol p0, List<ImportDecl> p1, List<TypeDecl> p2) {
    setPackageDecl(p0);
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
    packageName_reset();
    lookupType_String_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:42
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
    CompilationUnit_problems_computed = null;
    CompilationUnit_problems_value = null;
    CompilationUnit_onDemlines_computed = null;
    CompilationUnit_onDemlines_value = null;
    CompilationUnit_staticOnDemlines_computed = null;
    CompilationUnit_staticOnDemlines_value = null;
    CompilationUnit_usedTypes_computed = null;
    CompilationUnit_usedTypes_value = null;
    CompilationUnit_usedTypesList_computed = null;
    CompilationUnit_usedTypesList_value = null;
    CompilationUnit_importTypes_computed = null;
    CompilationUnit_importTypes_value = null;
    CompilationUnit_staticMethods_computed = null;
    CompilationUnit_staticMethods_value = null;
    CompilationUnit_variableAccess_computed = null;
    CompilationUnit_variableAccess_value = null;
    CompilationUnit_staticImports_computed = null;
    CompilationUnit_staticImports_value = null;
    CompilationUnit_methods_computed = null;
    CompilationUnit_methods_value = null;
    CompilationUnit_superClassMethods_computed = null;
    CompilationUnit_superClassMethods_value = null;
    contributorMap_CompilationUnit_problems = null;
    contributorMap_CompilationUnit_onDemlines = null;
    contributorMap_CompilationUnit_staticOnDemlines = null;
    contributorMap_CompilationUnit_usedTypes = null;
    contributorMap_CompilationUnit_usedTypesList = null;
    contributorMap_CompilationUnit_importTypes = null;
    contributorMap_CompilationUnit_staticMethods = null;
    contributorMap_CompilationUnit_variableAccess = null;
    contributorMap_CompilationUnit_staticImports = null;
    contributorMap_CompilationUnit_methods = null;
    contributorMap_CompilationUnit_superClassMethods = null;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:79
   */
  public CompilationUnit clone() throws CloneNotSupportedException {
    CompilationUnit node = (CompilationUnit) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:84
   */
  public CompilationUnit copy() {
    try {
      CompilationUnit node = (CompilationUnit) clone();
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
   * @declaredat ASTNode:103
   */
  @Deprecated
  public CompilationUnit fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:113
   */
  public CompilationUnit treeCopyNoTransform() {
    CompilationUnit tree = (CompilationUnit) copy();
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
   * @declaredat ASTNode:133
   */
  public CompilationUnit treeCopy() {
    CompilationUnit tree = (CompilationUnit) copy();
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
   * @declaredat ASTNode:147
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node) && (tokenString_PackageDecl == ((CompilationUnit) node).tokenString_PackageDecl);    
  }
  /**
   * Replaces the lexeme PackageDecl.
   * @param value The new value for the lexeme PackageDecl.
   * @apilevel high-level
   */
  public void setPackageDecl(String value) {
    tokenString_PackageDecl = value;
  }
  /** @apilevel internal 
   */
  protected String tokenString_PackageDecl;
  /**
   */
  public int PackageDeclstart;
  /**
   */
  public int PackageDeclend;
  /**
   * JastAdd-internal setter for lexeme PackageDecl using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme PackageDecl
   * @apilevel internal
   */
  public void setPackageDecl(beaver.Symbol symbol) {
    if (symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setPackageDecl is only valid for String lexemes");
    tokenString_PackageDecl = (String)symbol.value;
    PackageDeclstart = symbol.getStart();
    PackageDeclend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme PackageDecl.
   * @return The value for the lexeme PackageDecl.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="PackageDecl")
  public String getPackageDecl() {
    return tokenString_PackageDecl != null ? tokenString_PackageDecl : "";
  }
  /**
   * Replaces the ImportDecl list.
   * @param list The new list node to be used as the ImportDecl list.
   * @apilevel high-level
   */
  public void setImportDeclList(List<ImportDecl> list) {
    setChild(list, 0);
  }
  /**
   * Retrieves the number of children in the ImportDecl list.
   * @return Number of children in the ImportDecl list.
   * @apilevel high-level
   */
  public int getNumImportDecl() {
    return getImportDeclList().getNumChild();
  }
  /**
   * Retrieves the number of children in the ImportDecl list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the ImportDecl list.
   * @apilevel low-level
   */
  public int getNumImportDeclNoTransform() {
    return getImportDeclListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the ImportDecl list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the ImportDecl list.
   * @apilevel high-level
   */
  public ImportDecl getImportDecl(int i) {
    return (ImportDecl) getImportDeclList().getChild(i);
  }
  /**
   * Check whether the ImportDecl list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasImportDecl() {
    return getImportDeclList().getNumChild() != 0;
  }
  /**
   * Append an element to the ImportDecl list.
   * @param node The element to append to the ImportDecl list.
   * @apilevel high-level
   */
  public void addImportDecl(ImportDecl node) {
    List<ImportDecl> list = (parent == null) ? getImportDeclListNoTransform() : getImportDeclList();
    list.addChild(node);
  }
  /** @apilevel low-level 
   */
  public void addImportDeclNoTransform(ImportDecl node) {
    List<ImportDecl> list = getImportDeclListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the ImportDecl list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setImportDecl(ImportDecl node, int i) {
    List<ImportDecl> list = getImportDeclList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the ImportDecl list.
   * @return The node representing the ImportDecl list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="ImportDecl")
  public List<ImportDecl> getImportDeclList() {
    List<ImportDecl> list = (List<ImportDecl>) getChild(0);
    return list;
  }
  /**
   * Retrieves the ImportDecl list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the ImportDecl list.
   * @apilevel low-level
   */
  public List<ImportDecl> getImportDeclListNoTransform() {
    return (List<ImportDecl>) getChildNoTransform(0);
  }
  /**
   * @return the element at index {@code i} in the ImportDecl list without
   * triggering rewrites.
   */
  public ImportDecl getImportDeclNoTransform(int i) {
    return (ImportDecl) getImportDeclListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the ImportDecl list.
   * @return The node representing the ImportDecl list.
   * @apilevel high-level
   */
  public List<ImportDecl> getImportDecls() {
    return getImportDeclList();
  }
  /**
   * Retrieves the ImportDecl list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the ImportDecl list.
   * @apilevel low-level
   */
  public List<ImportDecl> getImportDeclsNoTransform() {
    return getImportDeclListNoTransform();
  }
  /**
   * Replaces the TypeDecl list.
   * @param list The new list node to be used as the TypeDecl list.
   * @apilevel high-level
   */
  public void setTypeDeclList(List<TypeDecl> list) {
    setChild(list, 1);
  }
  /**
   * Retrieves the number of children in the TypeDecl list.
   * @return Number of children in the TypeDecl list.
   * @apilevel high-level
   */
  public int getNumTypeDecl() {
    return getTypeDeclList().getNumChild();
  }
  /**
   * Retrieves the number of children in the TypeDecl list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the TypeDecl list.
   * @apilevel low-level
   */
  public int getNumTypeDeclNoTransform() {
    return getTypeDeclListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the TypeDecl list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the TypeDecl list.
   * @apilevel high-level
   */
  public TypeDecl getTypeDecl(int i) {
    return (TypeDecl) getTypeDeclList().getChild(i);
  }
  /**
   * Check whether the TypeDecl list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasTypeDecl() {
    return getTypeDeclList().getNumChild() != 0;
  }
  /**
   * Append an element to the TypeDecl list.
   * @param node The element to append to the TypeDecl list.
   * @apilevel high-level
   */
  public void addTypeDecl(TypeDecl node) {
    List<TypeDecl> list = (parent == null) ? getTypeDeclListNoTransform() : getTypeDeclList();
    list.addChild(node);
  }
  /** @apilevel low-level 
   */
  public void addTypeDeclNoTransform(TypeDecl node) {
    List<TypeDecl> list = getTypeDeclListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the TypeDecl list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setTypeDecl(TypeDecl node, int i) {
    List<TypeDecl> list = getTypeDeclList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the TypeDecl list.
   * @return The node representing the TypeDecl list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="TypeDecl")
  public List<TypeDecl> getTypeDeclList() {
    List<TypeDecl> list = (List<TypeDecl>) getChild(1);
    return list;
  }
  /**
   * Retrieves the TypeDecl list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the TypeDecl list.
   * @apilevel low-level
   */
  public List<TypeDecl> getTypeDeclListNoTransform() {
    return (List<TypeDecl>) getChildNoTransform(1);
  }
  /**
   * @return the element at index {@code i} in the TypeDecl list without
   * triggering rewrites.
   */
  public TypeDecl getTypeDeclNoTransform(int i) {
    return (TypeDecl) getTypeDeclListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the TypeDecl list.
   * @return The node representing the TypeDecl list.
   * @apilevel high-level
   */
  public List<TypeDecl> getTypeDecls() {
    return getTypeDeclList();
  }
  /**
   * Retrieves the TypeDecl list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the TypeDecl list.
   * @apilevel low-level
   */
  public List<TypeDecl> getTypeDeclsNoTransform() {
    return getTypeDeclListNoTransform();
  }
  /**
   * @aspect NameCheck
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/NameCheck.jrag:68
   */
  private Collection<Problem> refined_NameCheck_CompilationUnit_nameProblems()
{
    Collection<Problem> problems = new LinkedList<Problem>();
    for (int i = 0; i < getNumImportDecl(); i++) {
      ImportDecl decl = getImportDecl(i);
      if (!decl.isOnDemand()) {
        for (TypeDecl importedType : decl.importedTypes()) {
          for (TypeDecl local : localLookupType(importedType.name())) {
            if (local != importedType) {
              problems.add(errorf("imported type %s conflicts with visible type", decl.typeName()));
            }
          }
        }
      }
    }
    return problems;
  }
  /**
   * @aspect TypeScopePropagation
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/LookupType.jrag:361
   */
  private SimpleSet<TypeDecl> refined_TypeScopePropagation_CompilationUnit_Child_lookupType_String(String name)
{
    // Locally declared types in the compilation unit.
    SimpleSet<TypeDecl> result = localLookupType(name);
    if (!result.isEmpty()) {
      return result;
    }

    // Imported types.
    result = importedTypes(name);
    if (!result.isEmpty()) {
      return result;
    }

    // Types in the same package.
    TypeDecl pkgType = lookupType(packageName(), name);
    if (pkgType.accessibleFromPackage(packageName())) {
      return pkgType;
    }

    // Types imported on demand.
    result = importedTypesOnDemand(name);
    if (!result.isEmpty()) {
      return result;
    }

    // Include primitive types.
    TypeDecl primitiveType = lookupType(PRIMITIVE_PACKAGE_NAME, name);
    if (!primitiveType.isUnknown()) {
      return primitiveType;
    }

    // 7.5.5 Automatic Imports
    TypeDecl defaultType = lookupType("java.lang", name);
    if (defaultType.accessibleFromPackage(packageName())) {
      return defaultType;
    }
    return lookupType(name);
  }
  /**
   * @aspect <NoAspect>
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/ErrorCheck.jrag:278
   */
  protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_CompilationUnit_problems = null;

  protected void survey_CompilationUnit_problems() {
    if (contributorMap_CompilationUnit_problems == null) {
      contributorMap_CompilationUnit_problems = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
      collect_contributors_CompilationUnit_problems(this, contributorMap_CompilationUnit_problems);
    }
  }

  /**
   * @aspect <NoAspect>
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/src/jastadd/ImportOnDemand.jrag:4
   */
  protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_CompilationUnit_onDemlines = null;

  protected void survey_CompilationUnit_onDemlines() {
    if (contributorMap_CompilationUnit_onDemlines == null) {
      contributorMap_CompilationUnit_onDemlines = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
      collect_contributors_CompilationUnit_onDemlines(this, contributorMap_CompilationUnit_onDemlines);
    }
  }

  /**
   * @aspect <NoAspect>
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/src/jastadd/ImportOnDemand.jrag:5
   */
  protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_CompilationUnit_staticOnDemlines = null;

  protected void survey_CompilationUnit_staticOnDemlines() {
    if (contributorMap_CompilationUnit_staticOnDemlines == null) {
      contributorMap_CompilationUnit_staticOnDemlines = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
      collect_contributors_CompilationUnit_staticOnDemlines(this, contributorMap_CompilationUnit_staticOnDemlines);
    }
  }

  /**
   * @aspect <NoAspect>
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/src/jastadd/UnusedImports.jrag:25
   */
  protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_CompilationUnit_usedTypes = null;

  protected void survey_CompilationUnit_usedTypes() {
    if (contributorMap_CompilationUnit_usedTypes == null) {
      contributorMap_CompilationUnit_usedTypes = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
      collect_contributors_CompilationUnit_usedTypes(this, contributorMap_CompilationUnit_usedTypes);
    }
  }

  /**
   * @aspect <NoAspect>
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/src/jastadd/UnusedImports.jrag:26
   */
  protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_CompilationUnit_usedTypesList = null;

  protected void survey_CompilationUnit_usedTypesList() {
    if (contributorMap_CompilationUnit_usedTypesList == null) {
      contributorMap_CompilationUnit_usedTypesList = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
      collect_contributors_CompilationUnit_usedTypesList(this, contributorMap_CompilationUnit_usedTypesList);
    }
  }

  /**
   * @aspect <NoAspect>
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/src/jastadd/UnusedImports.jrag:27
   */
  protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_CompilationUnit_importTypes = null;

  protected void survey_CompilationUnit_importTypes() {
    if (contributorMap_CompilationUnit_importTypes == null) {
      contributorMap_CompilationUnit_importTypes = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
      collect_contributors_CompilationUnit_importTypes(this, contributorMap_CompilationUnit_importTypes);
    }
  }

  /**
   * @aspect <NoAspect>
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/src/jastadd/StaticStuff.jrag:7
   */
  protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_CompilationUnit_staticMethods = null;

  protected void survey_CompilationUnit_staticMethods() {
    if (contributorMap_CompilationUnit_staticMethods == null) {
      contributorMap_CompilationUnit_staticMethods = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
      collect_contributors_CompilationUnit_staticMethods(this, contributorMap_CompilationUnit_staticMethods);
    }
  }

  /**
   * @aspect <NoAspect>
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/src/jastadd/StaticStuff.jrag:8
   */
  protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_CompilationUnit_variableAccess = null;

  protected void survey_CompilationUnit_variableAccess() {
    if (contributorMap_CompilationUnit_variableAccess == null) {
      contributorMap_CompilationUnit_variableAccess = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
      collect_contributors_CompilationUnit_variableAccess(this, contributorMap_CompilationUnit_variableAccess);
    }
  }

  /**
   * @aspect <NoAspect>
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/src/jastadd/StaticStuff.jrag:9
   */
  protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_CompilationUnit_staticImports = null;

  protected void survey_CompilationUnit_staticImports() {
    if (contributorMap_CompilationUnit_staticImports == null) {
      contributorMap_CompilationUnit_staticImports = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
      collect_contributors_CompilationUnit_staticImports(this, contributorMap_CompilationUnit_staticImports);
    }
  }

  /**
   * @aspect <NoAspect>
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/src/jastadd/OverrideAnnotation.jrag:5
   */
  protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_CompilationUnit_methods = null;

  protected void survey_CompilationUnit_methods() {
    if (contributorMap_CompilationUnit_methods == null) {
      contributorMap_CompilationUnit_methods = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
      collect_contributors_CompilationUnit_methods(this, contributorMap_CompilationUnit_methods);
    }
  }

  /**
   * @aspect <NoAspect>
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/src/jastadd/OverrideAnnotation.jrag:6
   */
  protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_CompilationUnit_superClassMethods = null;

  protected void survey_CompilationUnit_superClassMethods() {
    if (contributorMap_CompilationUnit_superClassMethods == null) {
      contributorMap_CompilationUnit_superClassMethods = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
      collect_contributors_CompilationUnit_superClassMethods(this, contributorMap_CompilationUnit_superClassMethods);
    }
  }

  /**
   * @attribute syn
   * @aspect NameCheck
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/NameCheck.jrag:68
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="NameCheck", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/NameCheck.jrag:68")
  public Collection<Problem> nameProblems() {
    {
        Collection<Problem> problems = refined_NameCheck_CompilationUnit_nameProblems();
        for (int i = 0; i < getNumImportDecl(); i++) {
          if (getImportDecl(i) instanceof SingleStaticImportDecl) {
            SingleStaticImportDecl decl = (SingleStaticImportDecl) getImportDecl(i);
            String name = decl.name();
            if (!decl.importedTypes(name).isEmpty()) {
              TypeDecl type = decl.importedTypes(name).iterator().next();
              if (localLookupType(name).contains(type)) {
                problems.add(decl.errorf("the imported name %s.%s is already declared in this compilation unit",
                    packageName(), name));
              }
            }
          }
        }
        return problems;
      }
  }
  /** Searches for a type with the given simple name in this compilation unit. 
   * @attribute syn
   * @aspect TypeScopePropagation
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/LookupType.jrag:401
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeScopePropagation", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/LookupType.jrag:401")
  public SimpleSet<TypeDecl> localLookupType(String name) {
    {
        for (int i = 0; i < getNumTypeDecl(); i++) {
          if (getTypeDecl(i).name().equals(name)) {
            return getTypeDecl(i);
          }
        }
        return emptySet();
      }
  }
  /**
   * @attribute syn
   * @aspect TypeScopePropagation
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/LookupType.jrag:410
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeScopePropagation", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/LookupType.jrag:410")
  public SimpleSet<TypeDecl> importedTypes(String name) {
    {
        SimpleSet<TypeDecl> result = emptySet();
        for (int i = 0; i < getNumImportDecl(); i++) {
          if (!getImportDecl(i).isOnDemand()) {
            for (TypeDecl type : getImportDecl(i).importedTypes(name)) {
              result = result.add(type);
            }
          }
        }
        return result;
      }
  }
  /**
   * @attribute syn
   * @aspect TypeScopePropagation
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/LookupType.jrag:422
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeScopePropagation", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/LookupType.jrag:422")
  public SimpleSet<TypeDecl> importedTypesOnDemand(String name) {
    {
        SimpleSet<TypeDecl> result = emptySet();
        for (int i = 0; i < getNumImportDecl(); i++) {
          if (getImportDecl(i).isOnDemand()) {
            for (TypeDecl type : getImportDecl(i).importedTypes(name)) {
              result = result.add(type);
            }
          }
        }
        return result;
      }
  }
  /**
   * @attribute syn
   * @aspect ErrorCheck
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/ErrorCheck.jrag:280
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="ErrorCheck", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/ErrorCheck.jrag:280")
  public Collection<Problem> errors() {
    {
        Collection<Problem> errors = new LinkedList<Problem>();
        for (Problem problem : problems()) {
          if (problem.severity() == Problem.Severity.ERROR) {
            errors.add(problem);
          }
        }
        return errors;
      }
  }
  /**
   * @attribute syn
   * @aspect ErrorCheck
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/ErrorCheck.jrag:290
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="ErrorCheck", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/ErrorCheck.jrag:290")
  public Collection<Problem> warnings() {
    {
        Collection<Problem> warnings = new LinkedList<Problem>();
        for (Problem problem : problems()) {
          if (problem.severity() == Problem.Severity.WARNING) {
            warnings.add(problem);
          }
        }
        return warnings;
      }
  }
  /**
   * @attribute syn
   * @aspect PrettyPrintUtil
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/PrettyPrintUtil.jrag:233
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="PrettyPrintUtil", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/PrettyPrintUtil.jrag:233")
  public boolean hasPackageDecl() {
    boolean hasPackageDecl_value = !getPackageDecl().isEmpty();
    return hasPackageDecl_value;
  }
  /**
   * @return The path to the source file, or the path to the file inside a Jar
   * file.
   * @attribute syn
   * @aspect ClassPath
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/ClassPath.jrag:92
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="ClassPath", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/ClassPath.jrag:92")
  public String relativeName() {
    String relativeName_value = getClassSource().relativeName();
    return relativeName_value;
  }
  /**
   * @return The path to the source file, or the enclosing Jar file.
   * @attribute syn
   * @aspect ClassPath
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/ClassPath.jrag:97
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="ClassPath", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/ClassPath.jrag:97")
  public String pathName() {
    String pathName_value = getClassSource().pathName();
    return pathName_value;
  }
  /**
   * @return {@code true} if this compilation unit was parsed from source.
   * @attribute syn
   * @aspect ClassPath
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/ClassPath.jrag:102
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="ClassPath", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/ClassPath.jrag:102")
  public boolean fromSource() {
    boolean fromSource_value = fromSource;
    return fromSource_value;
  }
  /** @apilevel internal */
  private void packageName_reset() {
    packageName_computed = null;
    packageName_value = null;
  }
  /** @apilevel internal */
  protected ASTNode$State.Cycle packageName_computed = null;

  /** @apilevel internal */
  protected String packageName_value;

  /**
   * @attribute syn
   * @aspect TypeName
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/QualifiedNames.jrag:112
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeName", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/QualifiedNames.jrag:112")
  public String packageName() {
    ASTNode$State state = state();
    if (packageName_computed == ASTNode$State.NON_CYCLE || packageName_computed == state().cycle()) {
      return packageName_value;
    }
    packageName_value = packageName_compute();
    if (state().inCircle()) {
      packageName_computed = state().cycle();
    
    } else {
      packageName_computed = ASTNode$State.NON_CYCLE;
    
    }
    return packageName_value;
  }
  /** @apilevel internal */
  private String packageName_compute() {return getPackageDecl();}
  /**
   * @attribute syn
   * @aspect StaticImports
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/StaticImports.jrag:191
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="StaticImports", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/StaticImports.jrag:191")
  public SimpleSet<Variable> importedFields(String name) {
    {
        SimpleSet<Variable> set = emptySet();
        for (int i = 0; i < getNumImportDecl(); i++) {
          if (!getImportDecl(i).isOnDemand()) {
            for (Variable field : getImportDecl(i).importedFields(name)) {
              set = set.add(field);
            }
          }
        }
        return set;
      }
  }
  /**
   * @attribute syn
   * @aspect StaticImports
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/StaticImports.jrag:203
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="StaticImports", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/StaticImports.jrag:203")
  public SimpleSet<Variable> importedFieldsOnDemand(String name) {
    {
        SimpleSet<Variable> set = emptySet();
        for (int i = 0; i < getNumImportDecl(); i++) {
          if (getImportDecl(i).isOnDemand()) {
            for (Variable field : getImportDecl(i).importedFields(name)) {
              set = set.add(field);
            }
          }
        }
        return set;
      }
  }
  /**
   * @attribute syn
   * @aspect StaticImports
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/StaticImports.jrag:233
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="StaticImports", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/StaticImports.jrag:233")
  public Collection<MethodDecl> importedMethods(String name) {
    {
        Collection<MethodDecl> methods = new ArrayList<MethodDecl>();
        for (int i = 0; i < getNumImportDecl(); i++) {
          if (!getImportDecl(i).isOnDemand()) {
            methods.addAll(getImportDecl(i).importedMethods(name));
          }
        }
        return methods;
      }
  }
  /**
   * @attribute syn
   * @aspect StaticImports
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/StaticImports.jrag:243
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="StaticImports", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/StaticImports.jrag:243")
  public Collection<MethodDecl> importedMethodsOnDemand(String name) {
    {
        Collection<MethodDecl> methods = new ArrayList<MethodDecl>();
        for (int i = 0; i < getNumImportDecl(); i++) {
          if (getImportDecl(i).isOnDemand()) {
            methods.addAll(getImportDecl(i).importedMethods(name));
          }
        }
        return methods;
      }
  }
  /**
   * @attribute syn
   * @aspect ImportOnDemand
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/src/jastadd/ImportOnDemand.jrag:7
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="ImportOnDemand", declaredAt="/home/felix/edan70final/EDAN70/extension-base/src/jastadd/ImportOnDemand.jrag:7")
  public HashSet<String> importTypesOnDemand() {
    {
            HashSet<String> temp = new HashSet<String>();
            for(ImportDecl decl : getImportDeclList()) {
                if(decl.isOnDemand()) {
                    HashSet<String> all = new HashSet<String>();
                    all.addAll(usedTypes());
                    all.addAll(usedTypesList());
                    for(String type : all) {
                        if(decl.importedTypes(type).toString().equals("org.extendj.ast.GenericInterfaceDecl") ||
                         decl.importedTypes(type).toString().equals("org.extendj.ast.ClassDecl") ||
                         decl.importedTypes(type).toString().equals("org.extendj.ast.GenericClassDecl") ) {
                             if(!decl.isImportedAlready(type)){
                                temp.add(decl.getAccess().packageName() + "." + type);
                            }
                        }
                    }
    
    
                }
            }
            return temp;
        }
  }
  /**
   * @attribute syn
   * @aspect ImportOnDemand
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/src/jastadd/ImportOnDemand.jrag:31
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="ImportOnDemand", declaredAt="/home/felix/edan70final/EDAN70/extension-base/src/jastadd/ImportOnDemand.jrag:31")
  public HashSet<String> staticImportsOnDemand() {
    {
            HashSet<String> temp = new HashSet<String>();
            for(ImportDecl decl : getImportDeclList()) {
                if(decl.isOnDemand()) {
                        for(String ma : staticMethods()) {
                            if(!decl.importedMethods(ma).isEmpty() ) {
                                if(!decl.isImportedAlready(ma)){
                                   temp.add(decl.getAccess().packageName() + "." + decl.getAccess().uberID() + "." + ma);
                               }
                            }
                        }
                        for(String faderTorsk : variableAccess()){
                            if(decl.importedFields(faderTorsk).toString().equals("org.extendj.ast.FieldDeclarator")){
                                if(!decl.isImportedAlready(faderTorsk)){
                                   temp.add(decl.getAccess().packageName() + "." + decl.getAccess().uberID() + "." + faderTorsk);
                               }
                            }
                        }
                }
            }
            return temp;
        }
  }
  /**
   * @attribute syn
   * @aspect UnusedImports
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/src/jastadd/UnusedImports.jrag:117
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="UnusedImports", declaredAt="/home/felix/edan70final/EDAN70/extension-base/src/jastadd/UnusedImports.jrag:117")
  public HashSet<Integer> killableLines() {
    {
            HashSet<Integer> killable = new HashSet<Integer>();
            for(SingleTypeImportDecl s : importTypes()) {
                HashSet<String> all = new HashSet<String>();
                all.addAll(usedTypes());
                all.addAll(usedTypesList());
                if( !all.contains(s.getAccess().uberID()) && !variableAccess().contains(s.getAccess().uberID())){
                    killable.add(s.lineNumber());
                }
            }
            for(SingleStaticImportDecl st : staticImports()) {
                if(!staticMethods().contains(st.getID()) && !variableAccess().contains(st.getID())) {
                    killable.add(st.lineNumber());
                }
            }
    
            return killable;
    
        }
  }
  /**
   * @attribute syn
   * @aspect OverrideAnnotation
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/src/jastadd/OverrideAnnotation.jrag:19
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="OverrideAnnotation", declaredAt="/home/felix/edan70final/EDAN70/extension-base/src/jastadd/OverrideAnnotation.jrag:19")
  public HashSet<Integer> methodLinesWhereWeShouldAddOverrideAnnotation() {
    {
            HashSet<Integer> temp = new HashSet<Integer>();
            for(MethodDecl m : methods()){
                for(MethodDecl sm : superClassMethods()){
                    if(m.overrides(sm) && !m.hasOverride()){
                        temp.add(m.lineNumber());
                    }
                }
            }
            return temp;
    
    
        }
  }
  /**
   * @attribute inh
   * @aspect LookupFullyQualifiedTypes
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/LookupType.jrag:131
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="LookupFullyQualifiedTypes", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/LookupType.jrag:131")
  public TypeDecl lookupType(String packageName, String typeName) {
    TypeDecl lookupType_String_String_value = getParent().Define_lookupType(this, null, packageName, typeName);
    return lookupType_String_String_value;
  }
  /**
   * @attribute inh
   * @aspect TypeScopePropagation
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/LookupType.jrag:350
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="TypeScopePropagation", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/LookupType.jrag:350")
  public SimpleSet<TypeDecl> lookupType(String name) {
    Object _parameters = name;
    if (lookupType_String_computed == null) lookupType_String_computed = new java.util.HashMap(4);
    if (lookupType_String_values == null) lookupType_String_values = new java.util.HashMap(4);
    ASTNode$State state = state();
    if (lookupType_String_values.containsKey(_parameters) && lookupType_String_computed != null
        && lookupType_String_computed.containsKey(_parameters)
        && (lookupType_String_computed.get(_parameters) == ASTNode$State.NON_CYCLE || lookupType_String_computed.get(_parameters) == state().cycle())) {
      return (SimpleSet<TypeDecl>) lookupType_String_values.get(_parameters);
    }
    SimpleSet<TypeDecl> lookupType_String_value = getParent().Define_lookupType(this, null, name);
    if (state().inCircle()) {
      lookupType_String_values.put(_parameters, lookupType_String_value);
      lookupType_String_computed.put(_parameters, state().cycle());
    
    } else {
      lookupType_String_values.put(_parameters, lookupType_String_value);
      lookupType_String_computed.put(_parameters, ASTNode$State.NON_CYCLE);
    
    }
    return lookupType_String_value;
  }
  /** @apilevel internal */
  private void lookupType_String_reset() {
    lookupType_String_computed = new java.util.HashMap(4);
    lookupType_String_values = null;
  }
  /** @apilevel internal */
  protected java.util.Map lookupType_String_values;
  /** @apilevel internal */
  protected java.util.Map lookupType_String_computed;
  /**
   * @attribute inh
   * @aspect StaticImports
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/StaticImports.jrag:189
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="StaticImports", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/StaticImports.jrag:189")
  public SimpleSet<Variable> lookupVariable(String name) {
    SimpleSet<Variable> lookupVariable_String_value = getParent().Define_lookupVariable(this, null, name);
    return lookupVariable_String_value;
  }
  /**
   * @attribute inh
   * @aspect StaticImports
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/StaticImports.jrag:231
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="StaticImports", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/StaticImports.jrag:231")
  public Collection<MethodDecl> lookupMethod(String name) {
    Collection<MethodDecl> lookupMethod_String_value = getParent().Define_lookupMethod(this, null, name);
    return lookupMethod_String_value;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/NameCheck.jrag:50
   * @apilevel internal
   */
  public SimpleSet<TypeDecl> Define_allImportedTypes(ASTNode _callerNode, ASTNode _childNode, String name) {
    if (_callerNode == getImportDeclListNoTransform()) {
      // @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/NameCheck.jrag:52
      int childIndex = _callerNode.getIndexOfChild(_childNode);
      return importedTypes(name);
    }
    else {
      return getParent().Define_allImportedTypes(this, _callerNode, name);
    }
  }
  protected boolean canDefine_allImportedTypes(ASTNode _callerNode, ASTNode _childNode, String name) {
    return true;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/DefiniteAssignment.jrag:66
   * @apilevel internal
   */
  public boolean Define_isIncOrDec(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getTypeDeclListNoTransform()) {
      // @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/DefiniteAssignment.jrag:68
      int childIndex = _callerNode.getIndexOfChild(_childNode);
      return false;
    }
    else {
      return getParent().Define_isIncOrDec(this, _callerNode);
    }
  }
  protected boolean canDefine_isIncOrDec(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/SyntacticClassification.jrag:36
   * @apilevel internal
   */
  public NameType Define_nameType(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getImportDeclListNoTransform()) {
      // @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/SyntacticClassification.jrag:93
      int childIndex = _callerNode.getIndexOfChild(_childNode);
      return NameType.PACKAGE_NAME;
    }
    else {
      return getParent().Define_nameType(this, _callerNode);
    }
  }
  protected boolean canDefine_nameType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/GenericMethods.jrag:225
   * @apilevel internal
   */
  public SimpleSet<TypeDecl> Define_lookupType(ASTNode _callerNode, ASTNode _childNode, String name) {
    if (_callerNode == getImportDeclListNoTransform()) {
      // @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/LookupType.jrag:486
      int childIndex = _callerNode.getIndexOfChild(_childNode);
      return lookupType(name);
    }
    else {
      int childIndex = this.getIndexOfChild(_callerNode);
      {
          SimpleSet<TypeDecl> result = emptySet();
          for (TypeDecl typeDecl : refined_TypeScopePropagation_CompilationUnit_Child_lookupType_String(name)) {
            if (typeDecl instanceof ParTypeDecl) {
              result = result.add(((ParTypeDecl) typeDecl).genericDecl());
            } else {
              result = result.add(typeDecl);
            }
          }
          return result;
        }
    }
  }
  protected boolean canDefine_lookupType(ASTNode _callerNode, ASTNode _childNode, String name) {
    return true;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/ClassPath.jrag:105
   * @apilevel internal
   */
  public CompilationUnit Define_compilationUnit(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return this;
  }
  protected boolean canDefine_compilationUnit(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/QualifiedNames.jrag:108
   * @apilevel internal
   */
  public String Define_packageName(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return packageName();
  }
  protected boolean canDefine_packageName(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java7/frontend/TryWithResources.jrag:115
   * @apilevel internal
   */
  public boolean Define_handlesException(ASTNode _callerNode, ASTNode _childNode, TypeDecl exceptionType) {
    if (_callerNode == getImportDeclListNoTransform()) {
      // @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/StaticImports.jrag:299
      int childIndex = _callerNode.getIndexOfChild(_childNode);
      return false;
    }
    else if (_callerNode == getTypeDeclListNoTransform()) {
      // @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/ExceptionHandling.jrag:199
      int childIndex = _callerNode.getIndexOfChild(_childNode);
      return false;
    }
    else {
      return getParent().Define_handlesException(this, _callerNode, exceptionType);
    }
  }
  protected boolean canDefine_handlesException(ASTNode _callerNode, ASTNode _childNode, TypeDecl exceptionType) {
    return true;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/TypeAnalysis.jrag:547
   * @apilevel internal
   */
  public TypeDecl Define_enclosingType(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return null;
  }
  protected boolean canDefine_enclosingType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/NameCheck.jrag:30
   * @apilevel internal
   */
  public BodyDecl Define_enclosingBodyDecl(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return null;
  }
  protected boolean canDefine_enclosingBodyDecl(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/TypeAnalysis.jrag:572
   * @apilevel internal
   */
  public boolean Define_isNestedType(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return false;
  }
  protected boolean canDefine_isNestedType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/TypeAnalysis.jrag:580
   * @apilevel internal
   */
  public boolean Define_isMemberType(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getTypeDeclListNoTransform()) {
      // @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/TypeAnalysis.jrag:583
      int childIndex = _callerNode.getIndexOfChild(_childNode);
      return false;
    }
    else {
      return getParent().Define_isMemberType(this, _callerNode);
    }
  }
  protected boolean canDefine_isMemberType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/TypeAnalysis.jrag:598
   * @apilevel internal
   */
  public boolean Define_isLocalClass(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return false;
  }
  protected boolean canDefine_isLocalClass(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/TypeAnalysis.jrag:633
   * @apilevel internal
   */
  public String Define_hostPackage(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return packageName();
  }
  protected boolean canDefine_hostPackage(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java7/frontend/MultiCatch.jrag:76
   * @apilevel internal
   */
  public TypeDecl Define_hostType(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getImportDeclListNoTransform()) {
      // @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/TypeAnalysis.jrag:646
      int childIndex = _callerNode.getIndexOfChild(_childNode);
      return null;
    }
    else {
      return getParent().Define_hostType(this, _callerNode);
    }
  }
  protected boolean canDefine_hostType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/Enums.jrag:130
   * @apilevel internal
   */
  public boolean Define_isOriginalEnumConstructor(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return false;
  }
  protected boolean canDefine_isOriginalEnumConstructor(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/Enums.jrag:566
   * @apilevel internal
   */
  public boolean Define_inEnumInitializer(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return false;
  }
  protected boolean canDefine_inEnumInitializer(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/Annotations.jrag:95
   * @apilevel internal
   */
  public boolean Define_inComplexAnnotation(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return false;
  }
  protected boolean canDefine_inComplexAnnotation(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/LookupVariable.jrag:30
   * @apilevel internal
   */
  public SimpleSet<Variable> Define_lookupVariable(ASTNode _callerNode, ASTNode _childNode, String name) {
    if (_callerNode == getTypeDeclListNoTransform()) {
      // @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/StaticImports.jrag:177
      int childIndex = _callerNode.getIndexOfChild(_childNode);
      {
          SimpleSet<Variable> set = importedFields(name);
          if (!set.isEmpty()) {
            return set;
          }
          set = importedFieldsOnDemand(name);
          if (!set.isEmpty()) {
            return set;
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
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/LookupMethod.jrag:52
   * @apilevel internal
   */
  public Collection<MethodDecl> Define_lookupMethod(ASTNode _callerNode, ASTNode _childNode, String name) {
    if (_callerNode == getTypeDeclListNoTransform()) {
      // @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/StaticImports.jrag:219
      int childIndex = _callerNode.getIndexOfChild(_childNode);
      {
          Collection<MethodDecl> methods = importedMethods(name);
          if (!methods.isEmpty()) {
            return methods;
          }
          methods = importedMethodsOnDemand(name);
          if (!methods.isEmpty()) {
            return methods;
          }
          return lookupMethod(name);
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
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java5/frontend/Generics.jrag:789
   * @apilevel internal
   */
  public String Define_typeVariableContext(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return "";
  }
  protected boolean canDefine_typeVariableContext(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/TypeVariablePositions.jrag:29
   * @apilevel internal
   */
  public int Define_typeVarPosition(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return -1;
  }
  protected boolean canDefine_typeVarPosition(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/TypeVariablePositions.jrag:32
   * @apilevel internal
   */
  public boolean Define_typeVarInMethod(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return false;
  }
  protected boolean canDefine_typeVarInMethod(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/TypeVariablePositions.jrag:31
   * @apilevel internal
   */
  public int Define_genericMethodLevel(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return 0;
  }
  protected boolean canDefine_genericMethodLevel(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/EnclosingLambda.jrag:37
   * @apilevel internal
   */
  public LambdaExpr Define_enclosingLambda(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return null;
  }
  protected boolean canDefine_enclosingLambda(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/TargetType.jrag:195
   * @apilevel internal
   */
  public boolean Define_assignmentContext(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return false;
  }
  protected boolean canDefine_assignmentContext(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/TargetType.jrag:196
   * @apilevel internal
   */
  public boolean Define_invocationContext(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return false;
  }
  protected boolean canDefine_invocationContext(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/TargetType.jrag:197
   * @apilevel internal
   */
  public boolean Define_castContext(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return false;
  }
  protected boolean canDefine_castContext(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/TargetType.jrag:198
   * @apilevel internal
   */
  public boolean Define_stringContext(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return false;
  }
  protected boolean canDefine_stringContext(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java8/frontend/TargetType.jrag:199
   * @apilevel internal
   */
  public boolean Define_numericContext(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return false;
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
  /**
   * Collects semantic errors in the AST.
   * 
   * <p>Separate error checks are added using individual contribution statements.
   * @attribute coll
   * @aspect ErrorCheck
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/ErrorCheck.jrag:278
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
  @ASTNodeAnnotation.Source(aspect="ErrorCheck", declaredAt="/home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/ErrorCheck.jrag:278")
  public LinkedList<Problem> problems() {
    ASTNode$State state = state();
    if (CompilationUnit_problems_computed == ASTNode$State.NON_CYCLE || CompilationUnit_problems_computed == state().cycle()) {
      return CompilationUnit_problems_value;
    }
    CompilationUnit_problems_value = problems_compute();
    if (state().inCircle()) {
      CompilationUnit_problems_computed = state().cycle();
    
    } else {
      CompilationUnit_problems_computed = ASTNode$State.NON_CYCLE;
    
    }
    return CompilationUnit_problems_value;
  }
  /** @apilevel internal */
  private LinkedList<Problem> problems_compute() {
    ASTNode node = this;
    while (node != null && !(node instanceof CompilationUnit)) {
      node = node.getParent();
    }
    CompilationUnit root = (CompilationUnit) node;
    root.survey_CompilationUnit_problems();
    LinkedList<Problem> _computedValue = new LinkedList<Problem>();
    if (root.contributorMap_CompilationUnit_problems.containsKey(this)) {
      for (ASTNode contributor : root.contributorMap_CompilationUnit_problems.get(this)) {
        contributor.contributeTo_CompilationUnit_problems(_computedValue);
      }
    }
    return _computedValue;
  }
  /** @apilevel internal */
  protected ASTNode$State.Cycle CompilationUnit_problems_computed = null;

  /** @apilevel internal */
  protected LinkedList<Problem> CompilationUnit_problems_value;

  /**
   * @attribute coll
   * @aspect ImportOnDemand
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/src/jastadd/ImportOnDemand.jrag:4
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
  @ASTNodeAnnotation.Source(aspect="ImportOnDemand", declaredAt="/home/felix/edan70final/EDAN70/extension-base/src/jastadd/ImportOnDemand.jrag:4")
  public HashSet<Integer> onDemlines() {
    ASTNode$State state = state();
    if (CompilationUnit_onDemlines_computed == ASTNode$State.NON_CYCLE || CompilationUnit_onDemlines_computed == state().cycle()) {
      return CompilationUnit_onDemlines_value;
    }
    CompilationUnit_onDemlines_value = onDemlines_compute();
    if (state().inCircle()) {
      CompilationUnit_onDemlines_computed = state().cycle();
    
    } else {
      CompilationUnit_onDemlines_computed = ASTNode$State.NON_CYCLE;
    
    }
    return CompilationUnit_onDemlines_value;
  }
  /** @apilevel internal */
  private HashSet<Integer> onDemlines_compute() {
    ASTNode node = this;
    while (node != null && !(node instanceof CompilationUnit)) {
      node = node.getParent();
    }
    CompilationUnit root = (CompilationUnit) node;
    root.survey_CompilationUnit_onDemlines();
    HashSet<Integer> _computedValue = new HashSet<Integer>();
    if (root.contributorMap_CompilationUnit_onDemlines.containsKey(this)) {
      for (ASTNode contributor : root.contributorMap_CompilationUnit_onDemlines.get(this)) {
        contributor.contributeTo_CompilationUnit_onDemlines(_computedValue);
      }
    }
    return _computedValue;
  }
  /** @apilevel internal */
  protected ASTNode$State.Cycle CompilationUnit_onDemlines_computed = null;

  /** @apilevel internal */
  protected HashSet<Integer> CompilationUnit_onDemlines_value;

  /**
   * @attribute coll
   * @aspect ImportOnDemand
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/src/jastadd/ImportOnDemand.jrag:5
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
  @ASTNodeAnnotation.Source(aspect="ImportOnDemand", declaredAt="/home/felix/edan70final/EDAN70/extension-base/src/jastadd/ImportOnDemand.jrag:5")
  public HashSet<Integer> staticOnDemlines() {
    ASTNode$State state = state();
    if (CompilationUnit_staticOnDemlines_computed == ASTNode$State.NON_CYCLE || CompilationUnit_staticOnDemlines_computed == state().cycle()) {
      return CompilationUnit_staticOnDemlines_value;
    }
    CompilationUnit_staticOnDemlines_value = staticOnDemlines_compute();
    if (state().inCircle()) {
      CompilationUnit_staticOnDemlines_computed = state().cycle();
    
    } else {
      CompilationUnit_staticOnDemlines_computed = ASTNode$State.NON_CYCLE;
    
    }
    return CompilationUnit_staticOnDemlines_value;
  }
  /** @apilevel internal */
  private HashSet<Integer> staticOnDemlines_compute() {
    ASTNode node = this;
    while (node != null && !(node instanceof CompilationUnit)) {
      node = node.getParent();
    }
    CompilationUnit root = (CompilationUnit) node;
    root.survey_CompilationUnit_staticOnDemlines();
    HashSet<Integer> _computedValue = new HashSet<Integer>();
    if (root.contributorMap_CompilationUnit_staticOnDemlines.containsKey(this)) {
      for (ASTNode contributor : root.contributorMap_CompilationUnit_staticOnDemlines.get(this)) {
        contributor.contributeTo_CompilationUnit_staticOnDemlines(_computedValue);
      }
    }
    return _computedValue;
  }
  /** @apilevel internal */
  protected ASTNode$State.Cycle CompilationUnit_staticOnDemlines_computed = null;

  /** @apilevel internal */
  protected HashSet<Integer> CompilationUnit_staticOnDemlines_value;

  /**
   * @attribute coll
   * @aspect UnusedImports
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/src/jastadd/UnusedImports.jrag:25
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
  @ASTNodeAnnotation.Source(aspect="UnusedImports", declaredAt="/home/felix/edan70final/EDAN70/extension-base/src/jastadd/UnusedImports.jrag:25")
  public HashSet<String> usedTypes() {
    ASTNode$State state = state();
    if (CompilationUnit_usedTypes_computed == ASTNode$State.NON_CYCLE || CompilationUnit_usedTypes_computed == state().cycle()) {
      return CompilationUnit_usedTypes_value;
    }
    CompilationUnit_usedTypes_value = usedTypes_compute();
    if (state().inCircle()) {
      CompilationUnit_usedTypes_computed = state().cycle();
    
    } else {
      CompilationUnit_usedTypes_computed = ASTNode$State.NON_CYCLE;
    
    }
    return CompilationUnit_usedTypes_value;
  }
  /** @apilevel internal */
  private HashSet<String> usedTypes_compute() {
    ASTNode node = this;
    while (node != null && !(node instanceof CompilationUnit)) {
      node = node.getParent();
    }
    CompilationUnit root = (CompilationUnit) node;
    root.survey_CompilationUnit_usedTypes();
    HashSet<String> _computedValue = new HashSet<String>();
    if (root.contributorMap_CompilationUnit_usedTypes.containsKey(this)) {
      for (ASTNode contributor : root.contributorMap_CompilationUnit_usedTypes.get(this)) {
        contributor.contributeTo_CompilationUnit_usedTypes(_computedValue);
      }
    }
    return _computedValue;
  }
  /** @apilevel internal */
  protected ASTNode$State.Cycle CompilationUnit_usedTypes_computed = null;

  /** @apilevel internal */
  protected HashSet<String> CompilationUnit_usedTypes_value;

  /**
   * @attribute coll
   * @aspect UnusedImports
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/src/jastadd/UnusedImports.jrag:26
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
  @ASTNodeAnnotation.Source(aspect="UnusedImports", declaredAt="/home/felix/edan70final/EDAN70/extension-base/src/jastadd/UnusedImports.jrag:26")
  public HashSet<String> usedTypesList() {
    ASTNode$State state = state();
    if (CompilationUnit_usedTypesList_computed == ASTNode$State.NON_CYCLE || CompilationUnit_usedTypesList_computed == state().cycle()) {
      return CompilationUnit_usedTypesList_value;
    }
    CompilationUnit_usedTypesList_value = usedTypesList_compute();
    if (state().inCircle()) {
      CompilationUnit_usedTypesList_computed = state().cycle();
    
    } else {
      CompilationUnit_usedTypesList_computed = ASTNode$State.NON_CYCLE;
    
    }
    return CompilationUnit_usedTypesList_value;
  }
  /** @apilevel internal */
  private HashSet<String> usedTypesList_compute() {
    ASTNode node = this;
    while (node != null && !(node instanceof CompilationUnit)) {
      node = node.getParent();
    }
    CompilationUnit root = (CompilationUnit) node;
    root.survey_CompilationUnit_usedTypesList();
    HashSet<String> _computedValue = new HashSet<String>();
    if (root.contributorMap_CompilationUnit_usedTypesList.containsKey(this)) {
      for (ASTNode contributor : root.contributorMap_CompilationUnit_usedTypesList.get(this)) {
        contributor.contributeTo_CompilationUnit_usedTypesList(_computedValue);
      }
    }
    return _computedValue;
  }
  /** @apilevel internal */
  protected ASTNode$State.Cycle CompilationUnit_usedTypesList_computed = null;

  /** @apilevel internal */
  protected HashSet<String> CompilationUnit_usedTypesList_value;

  /**
   * @attribute coll
   * @aspect UnusedImports
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/src/jastadd/UnusedImports.jrag:27
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
  @ASTNodeAnnotation.Source(aspect="UnusedImports", declaredAt="/home/felix/edan70final/EDAN70/extension-base/src/jastadd/UnusedImports.jrag:27")
  public HashSet<SingleTypeImportDecl> importTypes() {
    ASTNode$State state = state();
    if (CompilationUnit_importTypes_computed == ASTNode$State.NON_CYCLE || CompilationUnit_importTypes_computed == state().cycle()) {
      return CompilationUnit_importTypes_value;
    }
    CompilationUnit_importTypes_value = importTypes_compute();
    if (state().inCircle()) {
      CompilationUnit_importTypes_computed = state().cycle();
    
    } else {
      CompilationUnit_importTypes_computed = ASTNode$State.NON_CYCLE;
    
    }
    return CompilationUnit_importTypes_value;
  }
  /** @apilevel internal */
  private HashSet<SingleTypeImportDecl> importTypes_compute() {
    ASTNode node = this;
    while (node != null && !(node instanceof CompilationUnit)) {
      node = node.getParent();
    }
    CompilationUnit root = (CompilationUnit) node;
    root.survey_CompilationUnit_importTypes();
    HashSet<SingleTypeImportDecl> _computedValue = new HashSet<SingleTypeImportDecl>();
    if (root.contributorMap_CompilationUnit_importTypes.containsKey(this)) {
      for (ASTNode contributor : root.contributorMap_CompilationUnit_importTypes.get(this)) {
        contributor.contributeTo_CompilationUnit_importTypes(_computedValue);
      }
    }
    return _computedValue;
  }
  /** @apilevel internal */
  protected ASTNode$State.Cycle CompilationUnit_importTypes_computed = null;

  /** @apilevel internal */
  protected HashSet<SingleTypeImportDecl> CompilationUnit_importTypes_value;

  /**
   * @attribute coll
   * @aspect StaticStuff
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/src/jastadd/StaticStuff.jrag:7
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
  @ASTNodeAnnotation.Source(aspect="StaticStuff", declaredAt="/home/felix/edan70final/EDAN70/extension-base/src/jastadd/StaticStuff.jrag:7")
  public HashSet<String> staticMethods() {
    ASTNode$State state = state();
    if (CompilationUnit_staticMethods_computed == ASTNode$State.NON_CYCLE || CompilationUnit_staticMethods_computed == state().cycle()) {
      return CompilationUnit_staticMethods_value;
    }
    CompilationUnit_staticMethods_value = staticMethods_compute();
    if (state().inCircle()) {
      CompilationUnit_staticMethods_computed = state().cycle();
    
    } else {
      CompilationUnit_staticMethods_computed = ASTNode$State.NON_CYCLE;
    
    }
    return CompilationUnit_staticMethods_value;
  }
  /** @apilevel internal */
  private HashSet<String> staticMethods_compute() {
    ASTNode node = this;
    while (node != null && !(node instanceof CompilationUnit)) {
      node = node.getParent();
    }
    CompilationUnit root = (CompilationUnit) node;
    root.survey_CompilationUnit_staticMethods();
    HashSet<String> _computedValue = new HashSet<String>();
    if (root.contributorMap_CompilationUnit_staticMethods.containsKey(this)) {
      for (ASTNode contributor : root.contributorMap_CompilationUnit_staticMethods.get(this)) {
        contributor.contributeTo_CompilationUnit_staticMethods(_computedValue);
      }
    }
    return _computedValue;
  }
  /** @apilevel internal */
  protected ASTNode$State.Cycle CompilationUnit_staticMethods_computed = null;

  /** @apilevel internal */
  protected HashSet<String> CompilationUnit_staticMethods_value;

  /**
   * @attribute coll
   * @aspect StaticStuff
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/src/jastadd/StaticStuff.jrag:8
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
  @ASTNodeAnnotation.Source(aspect="StaticStuff", declaredAt="/home/felix/edan70final/EDAN70/extension-base/src/jastadd/StaticStuff.jrag:8")
  public HashSet<String> variableAccess() {
    ASTNode$State state = state();
    if (CompilationUnit_variableAccess_computed == ASTNode$State.NON_CYCLE || CompilationUnit_variableAccess_computed == state().cycle()) {
      return CompilationUnit_variableAccess_value;
    }
    CompilationUnit_variableAccess_value = variableAccess_compute();
    if (state().inCircle()) {
      CompilationUnit_variableAccess_computed = state().cycle();
    
    } else {
      CompilationUnit_variableAccess_computed = ASTNode$State.NON_CYCLE;
    
    }
    return CompilationUnit_variableAccess_value;
  }
  /** @apilevel internal */
  private HashSet<String> variableAccess_compute() {
    ASTNode node = this;
    while (node != null && !(node instanceof CompilationUnit)) {
      node = node.getParent();
    }
    CompilationUnit root = (CompilationUnit) node;
    root.survey_CompilationUnit_variableAccess();
    HashSet<String> _computedValue = new HashSet<String>();
    if (root.contributorMap_CompilationUnit_variableAccess.containsKey(this)) {
      for (ASTNode contributor : root.contributorMap_CompilationUnit_variableAccess.get(this)) {
        contributor.contributeTo_CompilationUnit_variableAccess(_computedValue);
      }
    }
    return _computedValue;
  }
  /** @apilevel internal */
  protected ASTNode$State.Cycle CompilationUnit_variableAccess_computed = null;

  /** @apilevel internal */
  protected HashSet<String> CompilationUnit_variableAccess_value;

  /**
   * @attribute coll
   * @aspect StaticStuff
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/src/jastadd/StaticStuff.jrag:9
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
  @ASTNodeAnnotation.Source(aspect="StaticStuff", declaredAt="/home/felix/edan70final/EDAN70/extension-base/src/jastadd/StaticStuff.jrag:9")
  public HashSet<SingleStaticImportDecl> staticImports() {
    ASTNode$State state = state();
    if (CompilationUnit_staticImports_computed == ASTNode$State.NON_CYCLE || CompilationUnit_staticImports_computed == state().cycle()) {
      return CompilationUnit_staticImports_value;
    }
    CompilationUnit_staticImports_value = staticImports_compute();
    if (state().inCircle()) {
      CompilationUnit_staticImports_computed = state().cycle();
    
    } else {
      CompilationUnit_staticImports_computed = ASTNode$State.NON_CYCLE;
    
    }
    return CompilationUnit_staticImports_value;
  }
  /** @apilevel internal */
  private HashSet<SingleStaticImportDecl> staticImports_compute() {
    ASTNode node = this;
    while (node != null && !(node instanceof CompilationUnit)) {
      node = node.getParent();
    }
    CompilationUnit root = (CompilationUnit) node;
    root.survey_CompilationUnit_staticImports();
    HashSet<SingleStaticImportDecl> _computedValue = new HashSet<SingleStaticImportDecl>();
    if (root.contributorMap_CompilationUnit_staticImports.containsKey(this)) {
      for (ASTNode contributor : root.contributorMap_CompilationUnit_staticImports.get(this)) {
        contributor.contributeTo_CompilationUnit_staticImports(_computedValue);
      }
    }
    return _computedValue;
  }
  /** @apilevel internal */
  protected ASTNode$State.Cycle CompilationUnit_staticImports_computed = null;

  /** @apilevel internal */
  protected HashSet<SingleStaticImportDecl> CompilationUnit_staticImports_value;

  /**
   * @attribute coll
   * @aspect OverrideAnnotation
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/src/jastadd/OverrideAnnotation.jrag:5
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
  @ASTNodeAnnotation.Source(aspect="OverrideAnnotation", declaredAt="/home/felix/edan70final/EDAN70/extension-base/src/jastadd/OverrideAnnotation.jrag:5")
  public HashSet<MethodDecl> methods() {
    ASTNode$State state = state();
    if (CompilationUnit_methods_computed == ASTNode$State.NON_CYCLE || CompilationUnit_methods_computed == state().cycle()) {
      return CompilationUnit_methods_value;
    }
    CompilationUnit_methods_value = methods_compute();
    if (state().inCircle()) {
      CompilationUnit_methods_computed = state().cycle();
    
    } else {
      CompilationUnit_methods_computed = ASTNode$State.NON_CYCLE;
    
    }
    return CompilationUnit_methods_value;
  }
  /** @apilevel internal */
  private HashSet<MethodDecl> methods_compute() {
    ASTNode node = this;
    while (node != null && !(node instanceof CompilationUnit)) {
      node = node.getParent();
    }
    CompilationUnit root = (CompilationUnit) node;
    root.survey_CompilationUnit_methods();
    HashSet<MethodDecl> _computedValue = new HashSet<MethodDecl>();
    if (root.contributorMap_CompilationUnit_methods.containsKey(this)) {
      for (ASTNode contributor : root.contributorMap_CompilationUnit_methods.get(this)) {
        contributor.contributeTo_CompilationUnit_methods(_computedValue);
      }
    }
    return _computedValue;
  }
  /** @apilevel internal */
  protected ASTNode$State.Cycle CompilationUnit_methods_computed = null;

  /** @apilevel internal */
  protected HashSet<MethodDecl> CompilationUnit_methods_value;

  /**
   * @attribute coll
   * @aspect OverrideAnnotation
   * @declaredat /home/felix/edan70final/EDAN70/extension-base/src/jastadd/OverrideAnnotation.jrag:6
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
  @ASTNodeAnnotation.Source(aspect="OverrideAnnotation", declaredAt="/home/felix/edan70final/EDAN70/extension-base/src/jastadd/OverrideAnnotation.jrag:6")
  public HashSet<MethodDecl> superClassMethods() {
    ASTNode$State state = state();
    if (CompilationUnit_superClassMethods_computed == ASTNode$State.NON_CYCLE || CompilationUnit_superClassMethods_computed == state().cycle()) {
      return CompilationUnit_superClassMethods_value;
    }
    CompilationUnit_superClassMethods_value = superClassMethods_compute();
    if (state().inCircle()) {
      CompilationUnit_superClassMethods_computed = state().cycle();
    
    } else {
      CompilationUnit_superClassMethods_computed = ASTNode$State.NON_CYCLE;
    
    }
    return CompilationUnit_superClassMethods_value;
  }
  /** @apilevel internal */
  private HashSet<MethodDecl> superClassMethods_compute() {
    ASTNode node = this;
    while (node != null && !(node instanceof CompilationUnit)) {
      node = node.getParent();
    }
    CompilationUnit root = (CompilationUnit) node;
    root.survey_CompilationUnit_superClassMethods();
    HashSet<MethodDecl> _computedValue = new HashSet<MethodDecl>();
    if (root.contributorMap_CompilationUnit_superClassMethods.containsKey(this)) {
      for (ASTNode contributor : root.contributorMap_CompilationUnit_superClassMethods.get(this)) {
        contributor.contributeTo_CompilationUnit_superClassMethods(_computedValue);
      }
    }
    return _computedValue;
  }
  /** @apilevel internal */
  protected ASTNode$State.Cycle CompilationUnit_superClassMethods_computed = null;

  /** @apilevel internal */
  protected HashSet<MethodDecl> CompilationUnit_superClassMethods_value;

  protected void collect_contributors_CompilationUnit_problems(CompilationUnit _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
    // @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/NameCheck.jrag:66
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
  }
}
