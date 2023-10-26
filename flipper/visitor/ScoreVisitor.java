package flipper.visitor;

import flipper.composite.AbstractFlipperElement;

public class ScoreVisitor implements Visitor {

    private Integer scoreTotal;

    public Integer getScoreTotal() {
        return scoreTotal;
    }

    public void setScoreTotal(Integer scoreTotal) {
        this.scoreTotal = scoreTotal;
    }

    @Override
    public void visit(AbstractFlipperElement element) {
        element.accept(this);
    }
}
