package de.rub.nds.asn1.translator;

public abstract class Context {

    private final ContextComponent[] contextComponents;

    private int contextComponentPointer = 0;

    protected Context(final ContextComponent[] contextComponents) {
        this.contextComponents = contextComponents;
    }

    public final boolean hasCurrent() {
        return contextComponentPointer < this.contextComponents.length;
    }

    public final boolean has(int offset) {
        return (contextComponentPointer + offset) < this.contextComponents.length;
    }

    public final ContextComponent getCurrent() {
        return this.contextComponents[this.contextComponentPointer];
    }

    public final ContextComponent peek(int offset) {
        return this.contextComponents[this.contextComponentPointer + offset];
    }

    public final void consume() {
        this.contextComponentPointer++;
    }

    public final boolean canBeFinished() {
        boolean result = true;
        ContextComponent current;
        int offset = 0;
        while(this.contextComponentPointer + offset < this.contextComponents.length) {
            current = this.contextComponents[this.contextComponentPointer + offset];
            if(current.isOptional == false && current.isRepetitive == false) {
                result = false;
                break;
            }
            offset++;
        }
        return result;
    }

    public abstract String getName();
}