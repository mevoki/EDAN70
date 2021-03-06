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
 * @ast interface
 * @aspect DefiniteUnassignment
 * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/DefiniteAssignment.jrag:1224
 */
 interface FinallyHost {

     
    public boolean unassignedAfterFinally(Variable v);

     
    public boolean assignedAfterFinally(Variable v);

     
    public FinallyHost enclosingFinally(Stmt branch);

     
    public Block getFinallyBlock();
}
