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
 * @ast class
 * @aspect BytecodeDescriptor
 * @declaredat /h/dc/q/stv10hjo/Documents/EDAN70/extension-base/extendj/java5/frontend/BytecodeDescriptor.jrag:33
 */
 class FieldDescriptor extends java.lang.Object {
  
    private AbstractClassfileParser p;

  
    String typeDescriptor;

  

    public FieldDescriptor(AbstractClassfileParser parser, String name) throws IOException {
      p = parser;
      int descriptor_index = p.u2();
      typeDescriptor = ((CONSTANT_Utf8_Info) p.constantPool[descriptor_index]).string();
      if (AbstractClassfileParser.VERBOSE) {
        p.println("  Field: " + name + ", " + typeDescriptor);
      }
    }

  

    public Access type() {
      return new TypeDescriptor(p, typeDescriptor).type();
    }

  

    public boolean isBoolean() {
      return new TypeDescriptor(p, typeDescriptor).isBoolean();
    }


}
