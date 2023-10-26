package flipper.visitor;

import flipper.composite.AbstractFlipperElement;

public interface Visitor {
    void visit(AbstractFlipperElement element);
}
