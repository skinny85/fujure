package org.fujure.truffle;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.interop.ForeignAccess;
import com.oracle.truffle.api.interop.MessageResolution;
import com.oracle.truffle.api.interop.Resolve;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.interop.UnknownIdentifierException;
import com.oracle.truffle.api.nodes.Node;
import org.fujure.fbc.ast.Module;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// The <ClassName>Foreign classes used in this code are autogenerated
// using Truffle's annotation processor.
public final class FujureTruffleBindings implements TruffleObject {
    public static boolean isInstance(TruffleObject obj) {
        return obj instanceof FujureTruffleBindings;
    }

    private final Map<String, ModuleBindings> modulesBindings;

    public FujureTruffleBindings() {
        this.modulesBindings = new HashMap<>();
    }

    public void resetModule(Module module) {
        modulesBindings.put(module.getFullyQualifiedName(), new ModuleBindings());
    }

    public void registerValue(Module module, String name, Object value) {
        modulesBindings.get(module.getFullyQualifiedName()).register(name, value);
    }

    public Object find(Module targetModule, String reference) {
        ModuleBindings bindingsForTargetModule = modulesBindings.get(targetModule.getFullyQualifiedName());
        if (bindingsForTargetModule == null) {
            throw UnknownIdentifierException.raise(targetModule.getFullyQualifiedName());
        }
        return bindingsForTargetModule.find(reference);
    }

    @Override
    public ForeignAccess getForeignAccess() {
        return FujureTruffleBindingsMessageResolutionForeign.ACCESS;
    }

    @MessageResolution(receiverType = FujureTruffleBindings.class)
    static final class FujureTruffleBindingsMessageResolution {
        @Resolve(message = "KEYS")
        abstract static class KeysNode extends Node {
            @CompilerDirectives.TruffleBoundary
            public Object access(FujureTruffleBindings fujureTruffleBindings) {
                return new MemberKeys(fujureTruffleBindings.modulesBindings.keySet());
            }
        }

        @Resolve(message = "READ")
        abstract static class ReadNode extends Node {
            @CompilerDirectives.TruffleBoundary
            public Object access(FujureTruffleBindings fujureTruffleBindings, String name) {
                ModuleBindings moduleBindings = fujureTruffleBindings.modulesBindings.get(name);
                if (moduleBindings == null)
                    throw UnknownIdentifierException.raise(name);
                return moduleBindings;
            }
        }
    }

    public static final class ModuleBindings implements TruffleObject {
        private final Map<String, Object> moduleValues;

        public static boolean isInstance(TruffleObject obj) {
            return obj instanceof ModuleBindings;
        }

        public ModuleBindings() {
            this.moduleValues = new HashMap<>();
        }

        public void register(String name, Object value) {
            moduleValues.put(name, value);
        }

        public Object find(String reference) {
            Object ret = moduleValues.get(reference);
            if (ret == null) {
                throw UnknownIdentifierException.raise(reference);
            }
            return ret;
        }

        public void remove(String name) {
            moduleValues.remove(name);
        }

        @Override
        public ForeignAccess getForeignAccess() {
            return ModuleBindingsMessageResolutionForeign.ACCESS;
        }

        @MessageResolution(receiverType = ModuleBindings.class)
        static final class ModuleBindingsMessageResolution {
            @Resolve(message = "KEYS")
            abstract static class KeysNode extends Node {
                @CompilerDirectives.TruffleBoundary
                public Object access(ModuleBindings moduleBindings) {
                    return new MemberKeys(moduleBindings.moduleValues.keySet());
                }
            }

            @Resolve(message = "READ")
            abstract static class ReadNode extends Node {
                @CompilerDirectives.TruffleBoundary
                public Object access(ModuleBindings moduleBindings, String name) {
                    Object value = moduleBindings.find(name);

                    // Truffle doesn't support returning chars from bindings,
                    // so we special case char and convert them to an int
                    return value instanceof Character ? (int) (Character) value : value;
                }
            }
        }
    }

    static final class MemberKeys implements TruffleObject {
        public static boolean isInstance(TruffleObject obj) {
            return obj instanceof MemberKeys;
        }

        private final Collection<String> keys;

        public MemberKeys(Collection<String> keys) {
            this.keys = keys;
        }

        @Override
        public ForeignAccess getForeignAccess() {
            return MemberKeysMessageResolutionForeign.ACCESS;
        }

        @MessageResolution(receiverType = MemberKeys.class)
        static final class MemberKeysMessageResolution {
            @Resolve(message = "GET_SIZE")
            abstract static class GetSizeNode extends Node {
                @CompilerDirectives.TruffleBoundary
                public Object access(MemberKeys memberKeys) {
                    return memberKeys.keys.size();
                }
            }

            @Resolve(message = "READ")
            abstract static class ReadNode extends Node {
                @CompilerDirectives.TruffleBoundary
                public Object access(MemberKeys memberKeys, int index) {
                    if (index >= memberKeys.keys.size()) {
                        throw UnknownIdentifierException.raise(Integer.toString(index));
                    }
                    Iterator<String> iterator = memberKeys.keys.iterator();
                    int i = index;
                    while (i-- > 0) {
                        iterator.next();
                    }
                    return iterator.next();
                }
            }
        }
    }
}
