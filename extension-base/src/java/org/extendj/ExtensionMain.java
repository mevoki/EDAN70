package org.extendj;

import org.extendj.ast.CompilationUnit;

public class ExtensionMain extends JavaChecker {
//public static Object DrAST_root_node; //Enable debugging with DrAST

  public static void main(String args[]) {
    int exitCode = new ExtensionMain().run(args);
    if (exitCode != 0) {
      System.exit(exitCode);
    }

  }

  @Override
  protected int processCompilationUnit(CompilationUnit unit) throws Error {
    // Replace the following super call to skip semantic error checking in unit.
    return super.processCompilationUnit(unit);
  }

  /** Called by processCompilationUnit when there are no errors in the argument unit.  */
  @Override
  protected void processNoErrors(CompilationUnit unit) {
      System.out.println("processNoErrors");
      //DrAST_root_node = unit.getParent().getParent(); //Enable debugging with DrAST
    unit.process();
    unit.removeImports();

  }

}
