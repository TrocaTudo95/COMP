/* Generated By:JJTree: Do not edit this line. ASTAccessElement.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
import java.io.*;
import java.util.*;

public
class ASTAccessElement extends SimpleNode {
  protected String type="";
  public ASTAccessElement(int id) {
    super(id);
  }

  public ASTAccessElement(yal2jvm p, int id) {
    super(p, id);
  }

  public void setType(String a){
    this.type=a;
  }
  public String getType(){
    return this.type;
  }
  public String toString() { return yal2jvmTreeConstants.jjtNodeName[id] +" "+ this.name; }

  public void lookForLocals(String func_name, SymbolTable st){
    if(children != null) {
      for (int i = 0; i < children.length; ++i) {
        if(children[i].getClass().getName() == "ASTScalarAccess"){
        ASTScalarAccess n = (ASTScalarAccess)children[i];
        if (n != null) {
          if(!st.existVar(func_name,this.name)){
            AbstractSymbol as;
            if(this.parent.jjtGetParent().getClass().getName()=="ASTAssign") {

              ASTAssign ass=(ASTAssign)this.parent.jjtGetParent();
              if(ass.isArray())
               as=new AbstractSymbol(this.name,"ARRAY",null,0,null,null,firstToken.beginLine);
              else
              as=new AbstractSymbol(this.name,"INT",null,0,null,null,firstToken.beginLine);
           }
           else
            as=new AbstractSymbol(this.name,"INT",null,0,null,null,firstToken.beginLine);
            st.addLocalVar(func_name,this.name,as);
            //as.print();
          }
        }
      }
      else if(children[i].getClass().getName() == "ASTArrayAccess"){
      ASTArrayAccess n = (ASTArrayAccess)children[i];
      if (n != null) {
        if(!st.existVar(func_name,this.name)){
           AbstractSymbol as=new AbstractSymbol(this.name,"ARRAY",null,0,null,null,firstToken.beginLine);
          st.addLocalVar(func_name,this.name,as);
          //as.print();
        }
      }
    }
    }
  }
  }

  public void process(BufferedWriter s,SymbolTable st,String funcName){
    this.func_name=funcName;
    try{
    //lhs (Assign)
    if(this.parent.getClass().getName() == "ASTLhs" && this.parent.jjtGetParent().getClass().getName() == "ASTAssign"){
      if(st.getVarType(funcName, this.name) == "GLOBAL"){
        if(st.getTypeVariable(funcName, this.name) == "INT"){
          s.write("putstatic " + this.Module + "/" + this.name + " I \n");
        }
        if(st.getTypeVariable(funcName, this.name) == "ARRAY" && this.type == ""){
          s.write("putstatic " + this.Module + "/" + this.name + " [I \n");
        }
        if(this.type == "ARRAY"){
          s.write("getstatic " + this.Module + "/" + this.name + " [I \n");
          if (children != null) {
            for (int i = 0; i < children.length; ++i) {
              if(children[i].getClass().getName() == "ASTArrayAccess"){
              ASTArrayAccess n = (ASTArrayAccess)children[i];
              if (n != null) {
                n.process(s,st,funcName);
                }
              }
            }
          }

        }
      }

      if(st.getVarType(funcName, this.name) == "LOCAL" || st.getVarType(funcName, this.name) == "PARAMETER"){
        if(st.getTypeVariable(funcName, this.name) == "INT"){
          if(ASTModule.getStack().contains(this.name)){
            if(ASTModule.getStack().indexOf(this.name) <= 3)
              s.write("istore_");
                else
              s.write("istore ");
            s.write(ASTModule.getStack().indexOf(this.name) + "\n");
          }else{
            ASTModule.addToStack(this.name);
            if(ASTModule.getStack().indexOf(this.name) <= 3)
              s.write("istore_");
                else
              s.write("istore ");
            s.write(ASTModule.getStack().indexOf(this.name) + "\n");
          }
          }
        if(st.getTypeVariable(funcName, this.name) == "ARRAY"){
          if(ASTModule.getStack().contains(this.name)){
            if(ASTModule.getStack().indexOf(this.name) <= 3)
              s.write("aload_");
                else
              s.write("aload ");
            s.write(ASTModule.getStack().indexOf(this.name) + "\n");
          }else{
            ASTModule.addToStack(this.name);
            if(ASTModule.getStack().indexOf(this.name) <= 3)
              s.write("aload_");
                else
              s.write("aload ");
            s.write(ASTModule.getStack().indexOf(this.name) + "\n");
          }
          if(this.type == "ARRAY"){
            if (children != null) {
              for (int i = 0; i < children.length; ++i) {
                if(children[i].getClass().getName() == "ASTArrayAccess"){
                ASTArrayAccess n = (ASTArrayAccess)children[i];
                if (n != null) {
                  n.process(s,st,funcName);
                  }
                }
              }
            }

          }

        }

      }
    }

        //lhs(Exprtest)
        if(this.parent.getClass().getName() == "ASTLhs" && this.parent.jjtGetParent().getClass().getName() == "ASTExprtest"){
          if(st.getVarType(funcName, this.name) == "GLOBAL"){
            if(st.getTypeVariable(funcName, this.name) == "INT"){
              s.write("getstatic " + this.Module + "/" + this.name + " I \n");
            }
            if(st.getTypeVariable(funcName, this.name) == "ARRAY" && this.type == ""){
              s.write("getstatic " + this.Module + "/" + this.name + " [I \n");
            }
            if(this.type == "ARRAY"){
              s.write("getstatic " + this.Module + "/" + this.name + " [I \n");
              if (children != null) {
                for (int i = 0; i < children.length; ++i) {
                  if(children[i].getClass().getName() == "ASTArrayAccess"){
                  ASTArrayAccess n = (ASTArrayAccess)children[i];
                  if (n != null) {
                    n.process(s,st,funcName);
                    }
                  }
                }
              }
              s.write("iaload\n");

            }

          }
          if(st.getVarType(funcName, this.name) == "LOCAL" || st.getVarType(funcName, this.name) == "PARAMETER"){
          if(st.getTypeVariable(funcName, this.name) == "ARRAY" && this.type ==""){
              if(ASTModule.getStack().contains(this.name)){
                if(ASTModule.getStack().indexOf(this.name) <= 3)
                  s.write("aload_");
                    else
                  s.write("aload ");
                s.write(ASTModule.getStack().indexOf(this.name) + "\n");
              }else{
                ASTModule.addToStack(this.name);
                if(ASTModule.getStack().indexOf(this.name) <= 3)
                  s.write("aload_");
                    else
                  s.write("aload ");
                s.write(ASTModule.getStack().indexOf(this.name) + "\n");
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
            if(this.type == "ARRAY"){
              if(ASTModule.getStack().contains(this.name)){
                if(ASTModule.getStack().indexOf(this.name) <= 3)
                  s.write("aload_");
                    else
                  s.write("aload ");
                s.write(ASTModule.getStack().indexOf(this.name) + "\n");
              }else{
                ASTModule.addToStack(this.name);
                if(ASTModule.getStack().indexOf(this.name) <= 3)
                  s.write("aload_");
                    else
                  s.write("aload ");
                s.write(ASTModule.getStack().indexOf(this.name) + "\n");
              }

              if (children != null) {
                for (int i = 0; i < children.length; ++i) {
                  if(children[i].getClass().getName() == "ASTArrayAccess"){
                  ASTArrayAccess n = (ASTArrayAccess)children[i];
                  if (n != null) {
                    n.process(s,st,funcName);
                    }
                  }
                }
              }
              s.write("iaload\n");

            }

            if(st.getTypeVariable(funcName, this.name) == "INT"){
              if(ASTModule.getStack().contains(this.name)){
                if(ASTModule.getStack().indexOf(this.name) <= 3)
                  s.write("iload_");
                    else
                  s.write("iload ");
                s.write(ASTModule.getStack().indexOf(this.name) + "\n");
              }else{
                ASTModule.addToStack(this.name);
                if(ASTModule.getStack().indexOf(this.name) <= 3)
                  s.write("iload_");
                    else
                  s.write("iload ");
                s.write(ASTModule.getStack().indexOf(this.name) + "\n");
              }

            }
        }
      }



        //Rhs (Assign/Exprtest)
        if(this.parent.getClass().getName() == "ASTTerm"){
          if(st.getVarType(funcName, this.name) == "GLOBAL"){
            if(st.getTypeVariable(funcName, this.name) == "INT"){
              s.write("getstatic " + this.Module + "/" + this.name + " I \n");
            }
            if(st.getTypeVariable(funcName, this.name) == "ARRAY" && this.type == ""){
              s.write("getstatic " + this.Module + "/" + this.name + " [I \n");
            }
            if(this.type == "ARRAY"){
              s.write("getstatic " + this.Module + "/" + this.name + " [I \n");
              if (children != null) {
                for (int i = 0; i < children.length; ++i) {
                  if(children[i].getClass().getName() == "ASTArrayAccess"){
                  ASTArrayAccess n = (ASTArrayAccess)children[i];
                  if (n != null) {
                    n.process(s,st,funcName);
                    }
                  }
                }
              }
              s.write("iaload\n");

            }
          }
        if(st.getVarType(funcName, this.name) == "LOCAL" || st.getVarType(funcName, this.name) == "PARAMETER"){
          if(st.getTypeVariable(funcName, this.name) == "ARRAY" && this.type == ""){
            if(ASTModule.getStack().contains(this.name)){
              if(ASTModule.getStack().indexOf(this.name) <= 3)
                s.write("aload_");
                  else
                s.write("aload ");
              s.write(ASTModule.getStack().indexOf(this.name) + "\n");
            }else{
              ASTModule.addToStack(this.name);
              if(ASTModule.getStack().indexOf(this.name) <= 3)
                s.write("aload_");
                  else
                s.write("aload ");
              s.write(ASTModule.getStack().indexOf(this.name) + "\n");
            }
              if (children != null) {
                for (int i = 0; i < children.length; ++i) {
                  SimpleNode n = (SimpleNode)children[i];
                  if (n != null) {
                    n.process(s,st,funcName);
                  }
                }
              }

            }if(this.type == "ARRAY"){
              if(ASTModule.getStack().contains(this.name)){
                if(ASTModule.getStack().indexOf(this.name) <= 3)
                  s.write("aload_");
                    else
                  s.write("aload ");
                s.write(ASTModule.getStack().indexOf(this.name) + "\n");
              }else{
                ASTModule.addToStack(this.name);
                if(ASTModule.getStack().indexOf(this.name) <= 3)
                  s.write("aload_");
                    else
                  s.write("aload ");
                s.write(ASTModule.getStack().indexOf(this.name) + "\n");
              }

              if (children != null) {
                for (int i = 0; i < children.length; ++i) {
                  if(children[i].getClass().getName() == "ASTArrayAccess"){
                  ASTArrayAccess n = (ASTArrayAccess)children[i];
                  if (n != null) {
                    n.process(s,st,funcName);
                    }
                  }
                }
              }
              s.write("iaload\n");

            }
            if(st.getTypeVariable(funcName, this.name) == "INT"){
              if(ASTModule.getStack().contains(this.name)){
                if(ASTModule.getStack().indexOf(this.name) <= 3)
                  s.write("iload_");
                    else
                  s.write("iload ");
                s.write(ASTModule.getStack().indexOf(this.name) + "\n");
              }else{
                ASTModule.addToStack(this.name);
                if(ASTModule.getStack().indexOf(this.name) <= 3)
                  s.write("iload_");
                    else
                  s.write("iload ");
                s.write(ASTModule.getStack().indexOf(this.name) + "\n");
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
/* JavaCC - OriginalChecksum=5cb57520f1b7d6f77670f63c633c5392 (do not edit this line) */
