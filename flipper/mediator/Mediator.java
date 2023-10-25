package flipper.mediator;

import flipper.composite.AbstractFlipperElement;

public interface Mediator {
    void notify(AbstractFlipperElement sender, Boolean hit);

    void subscribe(AbstractFlipperElement sender);
}
