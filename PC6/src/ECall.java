import java.util.Vector;
import edu.polytechnique.xvm.asm.opcodes.*;

public final class ECall extends AbstractExpr {
  public final String               name; // procedure name
  public final Vector<AbstractExpr> args; // arguments

  public ECall(String name, Vector<AbstractExpr> args) {
    this.name = name;
    this.args = args;
  }

  @Override
  public void codegen(CodeGen cg) {
	  for(int i=0;i<args.size();i++) {
		args.get(i).codegen(cg);
	  }
	  
	  cg.pushInstruction(new GSB(ProgramCodeGen.labelOfProcName(name)));
	  for(int i=0;i<args.size();i++) {
			cg.pushInstruction(new POP());
		  }
	  cg.pushInstruction(new PRX());
  }
}
