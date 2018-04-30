/* Generated By:JJTree: Do not edit this line. ASTArgument.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
import java.io.*;
import java.util.*;

public
class ASTArgument extends SimpleNode {
  private String str_arg;
  private int int_arg;
  private String type;
  public ASTArgument(int id) {
    super(id);
  }

  public ASTArgument(yal2jvm p, int id) {
    super(p, id);
  }
  public void set_str_arg(String arg){
    this.str_arg=arg;
  }
  public void set_int_arg(String arg){
    this.int_arg=Integer.parseInt(arg);
  }

  public void setType(String type){
    this.type = type;
  }

  public void process(BufferedWriter s){
    try{
      if(this.type.equals("S")){
        s.write("Ljava/lang/String;");
      }
      else if(this.type.equals("I")){
        s.write("I");
      }
      else if(this.type.equals("ID")){
        s.write("ola");
      }
    }
    catch (IOException e)
    {
      System.out.println("Exception ");
    }
  }

  @Override
  public String toString() {
    String temp;
    if(this.str_arg==null)
    temp= " type:int value:"+this.int_arg;
    else
      temp= " type:String value:"+this.str_arg;

    return yal2jvmTreeConstants.jjtNodeName[id] + " " + this.name + temp;
  }
}
/* JavaCC -stion has one right answer; wrong answers are graded with minus 1/4 of  OriginalChecksum=e86f66cff9855a3eddf055967b3542f6 (do not edit this line) */
