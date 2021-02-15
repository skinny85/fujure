package org.fujure.fbc.analyze

import org.fujure.fbc.analyze.BuiltInTypes.io
import org.fujure.fbc.ast.Module

class SymbolTable(private val modules: Map<Module, ModuleSymbols> = emptyMap()) {
    fun hasModule(module: Module): Boolean {
        return BUILT_IN_MODULES.containsKey(module) ||
                modules.containsKey(module)
    }

    fun lookup(targetModule: Module, name: String): CompleteType {
        val builtInModuleSymbols = BUILT_IN_MODULES[targetModule]
        if (builtInModuleSymbols != null) {
            val qualifiedType = builtInModuleSymbols[name]
            if (qualifiedType != null)
                return qualifiedType
        }

        val moduleSymbols = modules[targetModule]
        if (moduleSymbols != null) {
            val qualifiedType = moduleSymbols.lookup(name)
            if (qualifiedType != null)
                return qualifiedType
        }
        throw NotFound(targetModule, name)
    }

    fun merge(symbolTable: SymbolTable): SymbolTable {
        return SymbolTable(modules + symbolTable.modules)
    }

    class NotFound(val targetModule: Module, val name: String) :
            Exception("Name '$name' not found in target module: $targetModule")

    private companion object {
        val BUILT_IN_MODULES = mapOf(
                Module("fujure", "Int") to mapOf(
                        "minInt" to CompleteType(BuiltInTypes.Int),
                        "maxInt" to CompleteType(BuiltInTypes.Int),
                        "abs" to CompleteType(PartialType.Func(BuiltInTypes.Int, listOf(BuiltInTypes.Int))),
                        "min" to CompleteType(PartialType.Func(BuiltInTypes.Int, listOf(BuiltInTypes.Int, BuiltInTypes.Int))),
                        "max" to CompleteType(PartialType.Func(BuiltInTypes.Int, listOf(BuiltInTypes.Int, BuiltInTypes.Int)))
                ),
                Module("fujure", "Unit") to mapOf(
                ),
                Module("fujure", "Bool") to mapOf(
                ),
                Module("fujure", "Char") to mapOf(
                ),
                Module("fujure", "String") to mapOf(
                ),
                Module("fujure.io.std", "IO") to mapOf(
                        "putStrLn" to CompleteType(PartialType.Func(io(BuiltInTypes.Unit), listOf(BuiltInTypes.String))),
                        "chain" to CompleteType(PartialType.Func(io(PartialType.NonFunc.TypeVariable(2)),
                                listOf(
                                        io(PartialType.NonFunc.TypeVariable(1)),
                                        io(PartialType.NonFunc.TypeVariable(2)))
                        ))
                )
        )
    }
}

class ModuleSymbols(private val simpleValues: Map<String, CompleteType>) {
    fun lookup(name: String): CompleteType? {
        return simpleValues[name]
    }
}
