package org.fujure.truffle.runtime;

import org.fujure.truffle.runtime.io.Effect;

import java.util.Collections;
import java.util.List;

public final class IO<T> {
    public static <T> IO<T> of(Effect<T> effect) {
        return new IO<>(Collections.singletonList(effect));
    }

    public final List<Effect<?>> effects;

    private IO(List<Effect<?>> effects) {
        this.effects = effects;
    }

    public T unsafePerformEffects() {
        Object ret = null;
        for (Effect<?> effect : this.effects) {
            ret = effect.unsafePerformEffect();
        }
        return (T) ret;
    }
}
