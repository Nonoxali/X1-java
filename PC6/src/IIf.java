import edu.polytechnique.xvm.asm.opcodes.*;


public final class IIf extends AbstractInstruction {
  public final AbstractExpr        condition; // condition (<> 0 => true)
  public final AbstractInstruction iftrue   ; // if "true  (<> 0)" branch
  public final AbstractInstruction iffalse  ; // if "false (== 0)" branch

  public IIf(AbstractExpr condition,
             AbstractInstruction iftrue,
             AbstractInstruction iffalse)
  {
    this.condition = condition;
    this.iftrue = iftrue;
    this.iffalse = iffalse;
  }

  @Override
  public void codegen(CodeGen cg) {
	    String lbl0 = CodeGen.generateLabel();
	    String lbl1 = CodeGen.generateLabel();
	    
	    // Assemble condition
	    this.condition.codegen(cg);
	    // If condition is 0, jump to lbl1 (false)
	    cg.pushInstruction(new GTZ(lbl0));
	    // Generate true code for the body
	    this.iftrue.codegen(cg);
	    // Jump to lbl2 because true has been executed
	    cg.pushInstruction(new GTO(lbl1));
	    // Push start of block label
	    cg.pushLabel(lbl0);
	    // Generate false code for the body
	    this.iffalse.codegen(cg);
	    //Push end of condition label
	    cg.pushLabel(lbl1);
  }
}
