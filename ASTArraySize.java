/* Generated By:JJTree: Do not edit this line. ASTArraySize.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
import java.io.*;
import java.util.*;

public
class ASTArraySize extends SimpleNode {
  protected String type;
  public ASTArraySize(int id) {
    super(id);
  }

  public ASTArraySize(yal2jvm p, int id) {
    super(p, id);
  }

  public void setType(String type){
    this.type = type;
  }

  public void process(BufferedWriter s,SymbolTable st,String funcName){
    this.func_name=funcName;
    try{
      if(this.parent.getClass().getName() != "ASTDeclaration"){
        if(this.type == "I"){
          s.write("bipush " + this.value + "\n");
          s.write("newarray int \n");
        }else if(this.type == "ID"){
          if(this.parent.jjtGetParent().getClass().getName() == "ASTAssign"){
            if(st.getTypeVariable(funcName, this.name) == "INT"){
              if(ASTModule.getLoadI().size() <= 3)
              s.write("iload_");
              else
              s.write("iload ");

              if(ASTModule.getLoadI().contains(this.name)){
                s.write((ASTModule.getLoadI().indexOf(this.name)+1) + "\n");
              }else{
                ASTModule.setStoreI(this.name);
                s.write((ASTModule.getLoadI().indexOf(this.name)+1) + "\n");
              }
            }
            if(st.getTypeVariable(funcName, this.name) == "ARRAY"){
              if(ASTModule.getLoadA().size() <= 3)
                s.write("aload_");
                else
                s.write("aload ");

                if(ASTModule.getLoadA().contains(this.name)){
                  s.write((ASTModule.getLoadA().indexOf(this.name)+1) + "\n");
                }else{
                  ASTModule.setStoreA(this.name);
                  s.write((ASTModule.getLoadA().indexOf(this.name)+1) + "\n");
                }
                if (children != null) {
                  for (int i = 0; i < children.length; ++i) {
                    SimpleNode n = (SimpleNode)children[i];
                    if (n != null) {
                      n.process(s,st,funcName);
                    }
                  }
                }

              }
        }
    }
  }
  }catch (IOException e)
    {
      System.out.println("Exception ");

    }

  }
}
/* JavaCC - OriginalChecksum=65ca104da57a6c64dcf6fdfac1060a61 (do not edit this line) */
