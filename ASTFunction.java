/* Generated By:JJTree: Do not edit this line. ASTFunction.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
import java.io.*;
import java.util.*;

public
class ASTFunction extends SimpleNode {
  public ASTFunction(int id) {
    super(id);
  }

  public ASTFunction(yal2jvm p, int id) {
    super(p, id);
  }

  public void process(BufferedWriter s){
    try{
    s.write(".method public static " + this.name + "(");
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        if(1==1){ // validar se é um varlist
        SimpleNode n = (SimpleNode)children[i];
        if (n != null) {
          n.process(s);
        }
      }
    }
  }
    s.write(")"+"\n"); //falta meter o return value ex: ")V" para void
    s.write(".limit locals " + "\n");
    s.write(".limit stack " + "\n");

    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        SimpleNode n = (SimpleNode)children[i];
        if (n != null) {
          n.process(s);
        }
      }
    }

    s.write("return\n");
    s.write(".end method\n");
  }
    catch (IOException e)
    {
      System.out.println("Exception ");

    }
  }

}
/* JavaCC - OriginalChecksum=a2652e971e8086c1460c0bacb6e77b08 (do not edit this line) */
