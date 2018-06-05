/* Generated By:JJTree: Do not edit this line. ASTTerm.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
import java.io.*;
import java.util.*;

public
class ASTTerm extends SimpleNode {
  private int element_value = -99;
  private String signal;
  protected String type;
  public ASTTerm(int id) {
    super(id);
  }

  public ASTTerm(yal2jvm p, int id) {
    super(p, id);
  }

  public void setSignal(String signal){
    this.signal=signal;
  }

  public String getSignal(){
    return this.signal;
  }

  public int getValue(){
    return this.element_value;
  }

  public void setType(String type){
    this.type=type;
  }

  public String getType(){
    return this.type;
  }

  public void setElementValue(String value){
    String finalValue;
    if(this.signal!=null)
    finalValue= this.signal +value;
    else
    finalValue=value;


    this.element_value=Integer.parseInt(finalValue);
  }

  public void process(BufferedWriter s,SymbolTable st,String funcName){
    this.func_name=funcName;
    try{

      // if(this.signal != null){
      //
      //   if(this.signal.equals("+")){
      //       s.write("iadd\n");
      //     }
      //     else if(this.signal.equals("-")){
      //       s.write("isub\n");
      //     }
      // }

        if(this.element_value != -99){
          if(this.element_value <= 5){
            s.write("iconst_" + this.element_value + "\n");
          }else{
            s.write("bipush " + this.element_value + "\n");
          }
        }

        if(children != null) {
          for (int i = 0; i < children.length; ++i) {
            SimpleNode n = (SimpleNode)children[i];
            if (n != null) {
              n.process(s,st,funcName);
            }
          }

      }



    }catch (IOException e)
      {
        System.out.println("Exception ");

      }

  }

  @Override
  public String toString() {
    return yal2jvmTreeConstants.jjtNodeName[id] +" "+ "element value:"+ this.element_value;
  }

}
/* JavaCC - OriginalChecksum=170cb74cc85d4b20c7823a847b360c09 (do not edit this line) */
