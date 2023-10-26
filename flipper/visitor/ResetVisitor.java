package flipper.visitor;

import flipper.composite.AbstractFlipperElement;

public class ResetVisitor implements Visitor{

    @Override
    public void visit(AbstractFlipperElement element) {
        element.accept(this);
    }
}
