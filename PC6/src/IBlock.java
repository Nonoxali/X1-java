import edu.polytechnique.xvm.asm.opcodes.*;
import java.util.Vector;

@SuppressWarnings("unused")
public final class IBlock extends AbstractInstruction {
  public final Vector<AbstractInstruction> body;  // list of instructions (block)

  public IBlock(Vector<AbstractInstruction> instructions) {
    this.body = instructions;
  }

  public IBlock() {
    this(new Vector<AbstractInstruction>());
  }

  @Override
  public boolean isEmpty() {
    return this.body.isEmpty();
  }

  @Override
  public void codegen(CodeGen cg) {
	  for(int i =0; i< body.size();i++){
		  this.body.get(i).codegen(cg);
	  }
  }
}
