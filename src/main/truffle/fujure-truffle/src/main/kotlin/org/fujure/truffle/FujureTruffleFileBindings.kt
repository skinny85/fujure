package org.fujure.truffle

import org.fujure.fbc.ast.Def
import org.fujure.fbc.ast.Expr
import org.fujure.fbc.parse.ParsedFile

class FujureTruffleFileBindings(private val parsedFile: ParsedFile) {
    fun bindingNames(): List<String> {
        return parsedFile.ast.defs.map { def ->
            when (def) {
                is Def.ValueDef.SimpleValueDef -> def.id
            }
        }
    }

    fun evalBinding(name: String): Any? {
        val def = parsedFile.ast.defs.findLast { def ->
            when (def) {
                is Def.ValueDef.SimpleValueDef -> def.id == name
            }
        } ?: return null

        return when (def) {
            is Def.ValueDef.SimpleValueDef -> {
                val expr = def.initializer
                when (expr) {
                    is Expr.IntLiteral -> expr.value
                    else -> throw UnsupportedOperationException()
                }
            }
        }
    }
}
