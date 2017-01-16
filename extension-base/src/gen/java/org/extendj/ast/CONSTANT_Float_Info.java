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
 * @ast class
 * @aspect BytecodeCONSTANT
 * @declaredat /home/felix/edan70final/EDAN70/extension-base/extendj/java4/frontend/BytecodeCONSTANT.jrag:139
 */
 class CONSTANT_Float_Info extends CONSTANT_Info {
  
    public float value;

  

    public CONSTANT_Float_Info(AbstractClassfileParser parser) throws IOException {
      super(parser);
      value = p.readFloat();
    }

  

    @Override
    public String toString() {
      return "FloatInfo: " + Float.toString(value);
    }

  

    public Expr expr() {
      return Literal.buildFloatLiteral(value);
    }


}
