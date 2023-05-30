import java.util.*;

import edu.polytechnique.xvm.asm.*;
import edu.polytechnique.xvm.asm.interfaces.*;

public final class CodeGen {
  private Vector<AsmInstruction> instructions;
  private Map<String, Integer>   labels;
  private Map<String, Integer>   offsets;

  public CodeGen() {
    this.instructions = new Vector<AsmInstruction>();
    this.labels = new HashMap<String, Integer>();
    this.offsets = new HashMap<String, Integer>();
  }

  private static int labelc = 0;

  public static String generateLabel() {
	  String label = "l" + Integer.toString(labelc);
	  labelc++;
	  return label;
  }

  public void pushLabel(String label) {
	  labels.put(label, instructions.capacity());
  }

  public void pushInstruction(AsmInstruction asm) {
	instructions.add(asm);
  }

  public void pushLocalVariable(String name, int offset) {
	  offsets.put(name, offset); 
  }
  
  public void clearLocals() {
    this.offsets.clear();
  }
  
  public int offset(String name) {
	  return offsets.get(name);
  }
  
  @Override
  public String toString() {
    return Printer.programToString(this.instructions, this.labels);
  }
}
