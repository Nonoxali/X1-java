import edu.polytechnique.xvm.asm.opcodes.*;
import edu.polytechnique.mjava.ast.UniOp;

public final class EUniOp extends AbstractExpr {
  public final UniOp        op  ; // operator
  public final AbstractExpr expr; // operand

  public EUniOp(UniOp op, AbstractExpr expr) {
    this.expr = expr;
    this.op = op;
  }

  @Override
  public void codegen(CodeGen cg) {
    switch (this.op) {
    case NOT:
      this.expr.codegen(cg);
      cg.pushInstruction(new NOT());
      break;

    case NEG:
    	// a1; a2; a3
      cg.pushInstruction(new PUSH(0));
      // 0; a1 ;a2 ;a3
      this.expr.codegen(cg);
      // n; 0; a1; a2; a3
      cg.pushInstruction(new SUB());
      // 0-n; a1; a2; a3
      break;
    }
  }
}
